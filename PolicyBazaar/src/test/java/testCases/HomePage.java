package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import libraries.SuperAppium;
import libraries.ProjectSpecific;


public class HomePage {
	public static String MobileNumber = "9663514114";
	public static String appPath = "\\app\\PolicyBazaar_1.0.8.apk";
	public static String deviceName = "ca18b445";
	public static String appActivity = "com.policybazaar.login.Splash_DashBoard";
	public static String appPackage = "com.policybazaar";
	
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
		}
	
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  

 

  @AfterSuite
  public void afterSuite() {
  }

}
