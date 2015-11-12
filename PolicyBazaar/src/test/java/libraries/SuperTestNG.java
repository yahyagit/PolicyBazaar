package libraries;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


/*
 * Author : Manjunath
 * Created on : 01/09/2015
 * Last Modified : 03/09/2015
 */

public class SuperTestNG 
{
	public static WebDriver driver;
	public static String parentWh;
	static String url=Generic.getStringCellValue("./excels/data setup.xls", "ConfigSheet", 1, 1);
//	private String browserType=Generic.getStringCellValue("./excels/data setup.xls", "ConfigSheet", 0, 1);
	public static boolean isAuthentication=false;
	static String userName="staging";
	static String password="IBM06Nov";
	public static boolean blueMixApp, defaultApp=false;
	private static String blueMixUrl="http://wwwtest.ibm.com/account/us-en/signup/bluemix_landing_prod.html";
	private static String defaultUrl="https://wwwtest.ibm.com/account/us-en/signup/register.html";
	protected static String excelPath;
	public static int implicitlyWait=20;
	
//	Set excel path based on package name
	static void setExcel(Method m)
	{
		String varExcel = m.toString();
		if(varExcel.contains("registrationModule") && blueMixApp)
		{
			excelPath="./excels/Data setUp_blueMixPage.xls";
		}
		else if(varExcel.contains("registrationModule") && defaultApp)
		{
			excelPath="./excels/Data setUp_defaultPage.xls";
		}
		else if(varExcel.contains("signIn_PasswordResetModule"))
		{
			excelPath="./excels/signIn_PasswordResetModule.xls";
		}
		
	}
	
	private static void setApp()
	{
		if(url.equals(blueMixUrl))
		{
			blueMixApp=true;
			
		}else if(url.equals(defaultUrl))
		{
			defaultApp=true;
		}
		else
		{
			Generic.failATestCase("Please configure proper url");
		}
	}
				
//	Launch desired browser,enter URL and set implicit time out.
	
	@BeforeMethod(alwaysRun=true)
	@Parameters({"browser"})
	public void preConditions(Method m,String browserType)
	{
		setApp();
		setExcel(m);
		switch (browserType) 
		{
		case "IE":
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			Reporter.log("Launching Internet Explorer browser",true);
			break;
			
		case "FF":
			driver = new FirefoxDriver();
			Reporter.log("Launching Firefox browser",true);
			break;
			
		case "GC":
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			Reporter.log("Launching Chrome browser",true);
			Generic.waitForPageLoad(driver);
			break;
			
		default:
//            driver = new FirefoxDriver();
            break;
		}
		driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		if(isAuthentication)
		{
			try {
				System.out.println("Inside RunTime Auth");
//				Generic.forceSleep(3000);
				Runtime.getRuntime().exec("./Authentication.exe");
			} catch (IOException e) {
				Reporter.log("Exception in authentication of Firefox",true);
			}
		}
		
		driver.get(url);
		
		
		
		
//		if(isAuthentication==true && (driver instanceof ChromeDriver))
//		{
//			Generic.forceSleep(3000);
//			Generic.typeDataAndPressTab(userName);
//			Generic.typeDataAndPressTab(password);
//			Generic.pressEnterBtn();
//			Generic.forceSleep(5000);
//		}
		Generic.waitForPageLoad(driver);
		parentWh = driver.getWindowHandle();
	}
	
	
//	Close the browser instance
	@AfterMethod(alwaysRun=true)
	public void postCondition()
	{
//		if(driver instanceof FirefoxDriver)
//		Reporter.log("Closing "+browserType+" browser.",true);
		driver.quit();
	}

}
