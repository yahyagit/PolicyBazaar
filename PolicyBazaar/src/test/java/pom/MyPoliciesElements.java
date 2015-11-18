package pom;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MyPoliciesElements {
	
	//MyPolicies elements
		@AndroidFindBy(id = "com.policybazaar:id/titleid_uploaded_policyall")
		public MobileElement uploadedPolicies ;
		
		@AndroidFindBy(id = "com.policybazaar:id/notification_view")
		public MobileElement bookedpolicycontent ;
		
		@AndroidFindBy(id = "com.policybazaar:id/actionBarTitle")
		public MobileElement title ;
		
		
		@AndroidFindBy(id = "com.policybazaar:id/doucument_addmore")
		public MobileElement uploadPolicybutton ;
		
		@AndroidFindBy(id = "com.policybazaar:id/policy_listCheck")
		public MobileElement uploadpolicycontent ;
}

