package libraries;

import pom.HomePage;
import libraries.Generic;

public class ProjectSpecific {
	
	public static void numberRegistration(String MobileNumber) throws InterruptedException
	  {
		HomePage mobileelement =new HomePage();
		mobileelement.mobilenuberinputbox.sendKeys(MobileNumber);
		Generic.waitForElementVisible(SuperAppium.driver, mobileelement.submitButton);
		mobileelement.submitButton.click();
		Generic.waitForPageLoad(SuperAppium.driver);
		System.out.println("---------Mobile registration done------------");
	  }
}
