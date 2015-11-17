package testCases;

import java.net.MalformedURLException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import libraries.ProjectSpecific;
import libraries.SuperAppium;
import pom.HomePageElements;

public class HomePage {
	public static String MobileNumber = "9663514114";
	public static String appPath = "\\app\\PolicyBazaar_1.0.8.apk";
	public static String deviceName = "ca18b445";
	public static String appActivity = "com.policybazaar.login.Splash_DashBoard";
	public static String appPackage = "com.policybazaar";
	HomePageElements mobileelement =new HomePageElements();
	
	@BeforeSuite
	public void startserver() {
		SuperAppium.startServer(); 
	}
	
	@BeforeClass
	  public void openApp() throws MalformedURLException {
		  SuperAppium.openApp(appPath, deviceName, appActivity, appPackage);
	  }
	
	@Test
	  public void appRegistration() throws InterruptedException {
		  ProjectSpecific.numberRegistration(MobileNumber);
	  }
	
	@Test(dependsOnMethods = { "appRegistration" })
		public void notification() {
		mobileelement.ghanti.click();
		}
  
	@AfterMethod
	public void afterMethod() {
	}
  
	@AfterSuite
	public void afterSuite() {
	}
}
