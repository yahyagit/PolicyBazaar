package pom;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class motorInstaRenewElements {
	
	//Motor Insta Renewal elements
	
	@AndroidFindBy(id = "com.policybazaar:id/txtUploadPolicy")
	public MobileElement toptextcontent ;

	@AndroidFindBy(id = "com.policybazaar:id/selectFromGalleryLayout")
	public MobileElement Gallery ;
	
	@AndroidFindBy(id = "com.policybazaar:id/selectFromCameraLayout")
	public MobileElement Camera ;
	
	@AndroidFindBy(id = "com.policybazaar:id/selectDocumentLayout")
	public MobileElement Document ;
	
	@AndroidFindBy(id = "com.policybazaar:id/txtHaveYouMade")
	public MobileElement Bottomtextcontent ;
	
	@AndroidFindBy(id = "com.policybazaar:id/toggle")
	public MobileElement Switch ;
	
	@AndroidFindBy(id = "com.policybazaar:id/secondary_proceed")
	public MobileElement proceed ;
}
