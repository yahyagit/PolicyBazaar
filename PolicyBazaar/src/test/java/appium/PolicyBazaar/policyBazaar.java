package appium.PolicyBazaar;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class policyBazaar {
	AppiumDriverLocalService service;
	public AndroidDriver driver;
	String optVal;
	
	@BeforeSuite
	public void startServer()
	{
		String baselogPath=System.getProperty("user.dir");
		String finalLogPath=baselogPath+"\\logs\\AppiumServerLogs.txt";
		service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File("C:/Program Files/nodejs/node.exe"))
				.withAppiumJS(new File("G:/appium/Appium/node_modules/appium/bin/appium.js"))
				.withLogFile(new File(finalLogPath))
				.withIPAddress("127.0.0.1")
				.usingPort(4747));
		service.start();
		
		if(service.isRunning())
			System.out.println("Appium server started successfully");
	}
	  @BeforeClass
	  public void openApp() throws MalformedURLException{
			
			File appDir = new File(System.getProperty("user.dir"));//G:\appium\myown
			File app = new File(appDir, "\\app\\PolicyBazaar_1.0.8.apk");

			DesiredCapabilities cap=new DesiredCapabilities();			
			cap.setCapability("deviceName", "ca18b445");				
			cap.setCapability("appActivity", "com.policybazaar.login.Splash_DashBoard");
			cap.setCapability("appPackage", "com.policybazaar");
		
			driver = new AndroidDriver(new URL("http://127.0.0.1:4747/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
	  }
	  @Test(priority =1)
	  public void reinstall() throws InterruptedException
	  {
//	  if(!driver.isAppInstalled("com.policybazaar"))
//		{
//			System.out.println("App is not installed");
//			driver.installApp("G:\\appium\\myown\\app\\PolicyBazaar_1.0.8.apk");
//		}
//		else
//		{
//			System.out.println("App is already installed");
//			driver.removeApp(("com.policybazaar"));
//			System.out.println("App is Removed");
//			driver.installApp("G:\\appium\\myown\\app\\PolicyBazaar_1.0.8.apk");
//			System.out.println("App is Installed");
//			
////			driver.startActivity("com.android.vending","com.google.android.finsky.activities.MainActivity", null, null);
////			driver.findElementById("com.android.vending:id/search_box_idle_text").sendKeys("Policybazaar");
////			driver.findElementByName("App: Policybazaar - Compare Online").click();
////			driver.findElementById("com.android.vending:id/buy_button").click();
////			driver.findElementById("com.android.vending:id/continue_button_label").click();
////			Thread.sleep(10000);
////			if(!driver.findElementById("com.android.vending:id/launch_button").isEnabled())
////			{
////				service.stop();
////				driver.quit();
////			}
//		}
		System.out.println("------Test Case 1------------");
	  }
	  @Test(priority =2)
	  public void test() throws InterruptedException
	  {
		 driver.findElementById("com.policybazaar:id/mobile_number_edittext").sendKeys("9663514114");		
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.findElementById("com.policybazaar:id/mobile_num_submit_button").click();
		 Thread.sleep(3000);
		 System.out.println("------Test Case 2------------");
		 }
	@Test(priority =3 )
		 public void OTP() throws InterruptedException {
		     Thread.sleep(5000);
		     driver.startActivity("com.android.mms","com.android.mms.ui.ConversationList", null, null);
		     WebElement list=driver.findElement(By.id("android:id/list"));
		     List<WebElement> msg=list.findElements(By.id("com.android.mms:id/subject"));
		     System.out.println("Policy Bazaar Message :-" +msg.get(0).getText());
		     String opt[]= msg.get(0).getText().split("\\s+");
		     optVal = opt[2];
		     System.out.println(optVal);
	  }
		 @Test(priority =4 )
		 public void backToApp()  {
		     driver.startActivity("com.policybazaar","com.policybazaar.login.Splash_DashBoard", null, null);
		     driver.findElementById("com.policybazaar:id/dashboard_loginStatus").click();
		     driver.findElementById("com.policybazaar:id/otp_edittext").sendKeys(optVal);
		     driver.findElementById("com.policybazaar:id/otp_btn").click();
		 }
		 @Test(priority =5 )
		 public void twoWheelerInsurance() throws InterruptedException {
			 WebDriverWait wait = new WebDriverWait(driver, 200);
			 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.policybazaar:id/iv_logo")));
		     driver.findElementById("com.policybazaar:id/iv_logo").click();
		     driver.scrollTo("Two Wheeler Insurance").click();
//		     driver.findElementById("com.policybazaar:id/otp_edittext").sendKeys(optVal);
//		     driver.findElementById("com.policybazaar:id/otp_btn").click();
		 }
	  @AfterSuite
	  	public void stopServer()
	  	{
//		  		driver.removeApp("com.policybazaar");
		  		service.stop();
		  		if(!service.isRunning())
		  		System.out.println("Server stopped");
	  	}
}