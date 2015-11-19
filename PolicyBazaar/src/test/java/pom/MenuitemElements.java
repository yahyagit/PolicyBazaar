package pom;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MenuitemElements {
	
	//Identify elements
		@AndroidFindBy(id = "com.policybazaar:id/menuUsername")
		public MobileElement username;
		
		@AndroidFindBy(id = "com.policybazaar:id/menuItemHome")
		public MobileElement home ;

		@AndroidFindBy(id = "com.policybazaar:id/menuItemMyPoloicies")
		public MobileElement MyPoloicies ;
		
		@AndroidFindBy(id = "com.policybazaar:id/menuItemMyDocuments")
		public MobileElement MyDocuments ;
		
		@AndroidFindBy(id = "com.policybazaar:id/menuItemTrackApplication")
		public MobileElement TrackApplication ;
		
		@AndroidFindBy(id = "com.policybazaar:id/menuItemMyProfile")
		public MobileElement MyProfile ;
		
		@AndroidFindBy(id = "com.policybazaar:id/menuItemTwoWheeler")
		public MobileElement ItemTwoWheeler ;
		
		@AndroidFindBy(id = "com.policybazaar:id/menuItemCarInsurance")
		public MobileElement CarInsurance ;
		
		@AndroidFindBy(id = "com.policybazaar:id/menuItemTerm")
		public MobileElement Terminsurance ;
		
		@AndroidFindBy(id = "com.policybazaar:id/menuItemInvestment")
		public MobileElement InvestmentPlans ;
		
		@AndroidFindBy(id = "com.policybazaar:id/menuItemHealth")
		public MobileElement HealthInsurance ;
}