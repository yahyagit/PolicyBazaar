package testCases;

import java.net.MalformedURLException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import libraries.Generic;
import libraries.ProjectSpecific;
import libraries.SuperAppium;
import pom.HomePageElements;
import pom.MyAccountElements;
import pom.MyPoliciesElements;

public class MyAccount 
{
	HomePageElements homepageelement =new HomePageElements();
	MyAccountElements accountelements =new MyAccountElements();
	MyPoliciesElements policyelements =new MyPoliciesElements();
	
	Generic find = new Generic();
	
	@BeforeSuite
	public void startserver() {
		SuperAppium.startServer(); 
	}
	
	@BeforeClass
	  public void openApp() throws MalformedURLException {
		  SuperAppium.openApp();
	  }
	
	@Test
	  public void appRegistration() throws InterruptedException {
		  ProjectSpecific.numberRegistration();
	  }
	@Test(dependsOnMethods = { "appRegistration" })
	public void mypolicies()
	{
		homepageelement.MyAccount.click();
		accountelements.myPolicies.click();
		policyelements.uploadedPolicies.click();
		policyelements.uploadPolicybutton.click();
	}
}