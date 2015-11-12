package libraries;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
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
	public static String nodejsexefilepath = "C:/Program Files/nodejs/node.exe";
	public static String appiumjsfilepath = "G:/appium/Appium/node_modules/appium/bin/appium.js";
	public static AndroidDriver driver;
	public static String parentWh;
	static String url=Generic.getStringCellValue("./excels/data setup.xls", "ConfigSheet", 1, 1);
	protected static String excelPath;
	public static int implicitlyWait=20;
	
	public static void startServer()
	{
		String baselogPath=System.getProperty("user.dir");
		String finalLogPath=baselogPath+"\\logs\\AppiumServerLogs.txt";
		service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File(nodejsexefilepath))
				.withAppiumJS(new File("appiumjsfilepath"))
				.withLogFile(new File(finalLogPath))
				.withIPAddress("127.0.0.1")
				.usingPort(4747));
		service.start();
		
		if(service.isRunning())
			System.out.println("Appium server started successfully");
	}

		public static void openApp(String appPath, String deviceName, String appActivity, String appPackage) throws MalformedURLException{
		
		File appDir = new File(System.getProperty("user.dir"));//G:\appium\myown
		File app = new File(appDir, appPath);

		DesiredCapabilities cap=new DesiredCapabilities();			
		cap.setCapability("deviceName", deviceName);				
		cap.setCapability("appActivity", appActivity);
		cap.setCapability("appPackage", appPackage);
	
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
