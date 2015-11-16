package pom;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MyAccount {
	
	//MyAccount elements
	@AndroidFindBy(id = "com.policybazaar:id/id_mypolic")
	public MobileElement myPolicies ;
	
	@AndroidFindBy(id = "com.policybazaar:id/idcom_vehicledetail")
	public MobileElement myDocuments ;
	
	@AndroidFindBy(id = "com.policybazaar:id/idcom_mywallet")
	public MobileElement viewMyDocuments ;
	
	@AndroidFindBy(id = "com.policybazaar:id/idcom_mywalletUpload")
	public MobileElement uploadMyDocuments ;
	
	@AndroidFindBy(id = "com.policybazaar:id/motor_insta_Renewal")
	public MobileElement motorInstarenewal ;
	
	@AndroidFindBy(id = "com.policybazaar:id/idcom_trackapplication")
	public MobileElement trackApplication ;
	
	@AndroidFindBy(id = "com.policybazaar:id/idcom_myprofile")
	public MobileElement myprofile ;
	
	@AndroidFindBy(id = "com.policybazaar:id/idcom_sync")
	public MobileElement SyncAccount ;
}
