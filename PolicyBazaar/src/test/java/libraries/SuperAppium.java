package libraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.server.handler.FindActiveElement;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


/*
 * Author : Aditya
 * Created on : 11/12/2015
 */

public class SuperAppium 
{
	public static AppiumDriverLocalService service;
	public static AndroidDriver driver;
	public static String parentWh;
	static String url=Generic.getStringCellValue("./excels/data setup.xls", "ConfigSheet", 1, 1);
	protected static String excelPath;
	public static int implicitlyWait=20;
	static Generic find = new Generic();
	
	public static void startServer()
	{
		String baselogPath=System.getProperty("user.dir");
		String finalLogPath=baselogPath+"\\logs\\AppiumServerLogs.txt";
		service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File(find.valueof("nodejsexefilepath")))
				.withAppiumJS(new File(find.valueof("appiumjsfilepath")))
				.withLogFile(new File(finalLogPath))
				.withIPAddress("127.0.0.1")
				.usingPort(4747));
		service.start();
		
		if(service.isRunning())
			System.out.println("Appium server started successfully");
	}
	

		public static void openApp() throws MalformedURLException{
		
		File appDir = new File(System.getProperty("user.dir"));//G:\appium\myown
		File app = new File(appDir, find.valueof("appPath"));

		DesiredCapabilities cap=new DesiredCapabilities();			
		cap.setCapability("deviceName", find.valueof("deviceName"));				
		cap.setCapability("appActivity", find.valueof("appActivity"));
		cap.setCapability("appPackage", find.valueof("appPackage"));
	
		driver = new AndroidDriver(new URL("http://127.0.0.1:4747/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
  }
		public static void stopServer()
	  	{
		  		service.stop();
		  		if(!service.isRunning())
		  		System.out.println("Server stopped");
	  	}
		
		public static void LongPress(AndroidDriver driver, WebElement element) 
	    { 
	        TouchAction del=new TouchAction(driver);
	        del.longPress(element).perform();  
	    }
		
		public static void zoom(AndroidDriver driver, MobileElement element)
		{
			element.zoom();
		}

	@AfterMethod(alwaysRun=true)
	public void postCondition()
	{
		driver.quit();
	}

}
