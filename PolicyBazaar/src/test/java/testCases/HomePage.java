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
import libraries.Generic;
import pom.HomePageElements;

public class HomePage {
	
	HomePageElements mobileelement =new HomePageElements();
	Generic find = new Generic();
	
	@BeforeSuite
	public void startserver() {
		SuperAppium.startServer(); 
	}
	
	@BeforeClass
	  public void openApp() throws MalformedURLException {
		  SuperAppium.openApp(find.valueof("appPath"), find.valueof("deviceName"), find.valueof("appActivity"), find.valueof("appPackage"));
	  }
	
	@Test
	  public void appRegistration() throws InterruptedException {
		  ProjectSpecific.numberRegistration(find.valueof("MobileNumber"));
	  }
	
	@Test(dependsOnMethods = { "appRegistration" })
		public void notification() {
		mobileelement.ghanti.click();
		mobileelement.close.click();
		}
  
	@AfterMethod
	public void afterMethod() {
	}
  
	@AfterSuite
	public void afterSuite() {
	}
}
