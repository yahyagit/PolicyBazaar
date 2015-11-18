package pom;

import java.util.concurrent.TimeUnit;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import libraries.SuperAppium;


public class HomePageElements {
	
	//Identify elements
	@AndroidFindBy(id = "com.policybazaar:id/mobile_number_edittext")
	public MobileElement mobilenuberinputbox;
	
	@AndroidFindBy(id = "com.policybazaar:id/mobile_num_submit_button")
	public MobileElement submitButton;
	
	//Home Page elements
	
	@AndroidFindBy(id = "com.policybazaar:id/dashboard_loginStatus")
	public MobileElement MyAccount;
	
	@AndroidFindBy(id = "com.policybazaar:id/textView1")
	public MobileElement comparePolicies;
	
	@AndroidFindBy(id = "com.policybazaar:id/textView3")
	public MobileElement hospitalandGarageLocator ;
	
	@AndroidFindBy(id = "com.policybazaar:id/textView5")
	public MobileElement driveWise ;
	
	@AndroidFindBy(id = "com.policybazaar:id/notificationIcon")
	public MobileElement ghanti;
	
	@AndroidFindBy(id = "com.policybazaar:id/clear")
	public MobileElement close;
}
