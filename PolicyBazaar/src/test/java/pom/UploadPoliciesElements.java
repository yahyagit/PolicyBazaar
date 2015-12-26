package pom;

import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class UploadPoliciesElements {
	//Upload Policy elements
			@AndroidFindBy(id = "com.policybazaar:id/editview")
			public MobileElement EnterPolicyNumber ;
			
			@AndroidFindBy(id = "com.policybazaar:id/docz_addmore_product")
			public MobileElement enterPolicyType ;
			
			@AndroidFindBy(className ="android.widget.ListView")
			private MobileElement PolicyTypeList ;
			List<MobileElement> contList=PolicyTypeList.findElementsById("android:id/text1");
			public MobileElement TermInsurance=contList.get(1);
			public MobileElement LifeInsurance=contList.get(2);
			public MobileElement HealthInsurance=contList.get(3);
			public MobileElement CarInsurance=contList.get(4);
			public MobileElement TwoWheelerInsurance=contList.get(5);
			public MobileElement TravelInsurance=contList.get(6);
			
			@AndroidFindBy(id = "com.policybazaar:id/docz_addmore_policyterm")
			public MobileElement enterPolicyTerm ;
			
			@AndroidFindBy(className ="android.widget.ListView")
			private MobileElement PolicyTermList ;
			List<MobileElement> List2=PolicyTermList.findElementsById("android:id/text1");
			public MobileElement firstyear=List2.get(1);
			public MobileElement secondyear=List2.get(2);
			public MobileElement thirdyear=List2.get(3);
			public MobileElement fourthyear=List2.get(4);
			public MobileElement fifthyear=List2.get(5);
			public MobileElement sixthyear=List2.get(6);
			
			@AndroidFindBy(id = "com.policybazaar:id/docz_addmore_previousinsurer")
			public MobileElement enterPolicyinsurer ;
			
			@AndroidFindBy(className ="android.widget.ListView")
			private MobileElement PolicyinsurerList ;
			List<MobileElement> List3=PolicyTermList.findElementsById("android:id/text1");
			public MobileElement BajajAllianz=List3.get(1);
			public MobileElement ICICIPru=List3.get(2);
			public MobileElement Aviva=List3.get(3);
			public MobileElement MetLife=List3.get(4);
			public MobileElement KotakMahindra=List3.get(5);
			public MobileElement SBILifeInsurance=List3.get(6);
			public MobileElement MAXLife=List3.get(7);
			public MobileElement HDFC=List3.get(8);
			public MobileElement LIC=List3.get(9);
			
			@AndroidFindBy(id = "com.policybazaar:id/btn_main")
			public MobileElement selectExpiryDate ;

			@AndroidFindBy(id = "com.policybazaar:id/addmore_attchbutton")
			public MobileElement attachButton ;
			
			@AndroidFindBy(id = "com.policybazaar:id/addmore_camerabutton")
			public MobileElement takePicture ;
			
			@AndroidFindBy(id = "com.policybazaar:id/addmore_imageshowgone")
			public MobileElement enlargeimageButton ;
			
			@AndroidFindBy(id = "com.policybazaar:id/docs_addmore_savebutton")
			public MobileElement saveButton ;
			
			@AndroidFindBy(id = "com.policybazaar:id/doc_addmore_cancelButton")
			public MobileElement cancelButton ;
}
