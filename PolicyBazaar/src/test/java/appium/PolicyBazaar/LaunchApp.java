package appium.PolicyBazaar;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

public class LaunchApp {
	
	public static void main(String[] args) throws MalformedURLException {
		AppiumDriver driver;
    	
		File appDir = new File(System.getProperty("user.dir"));//F:\Learning\23Sep\PolicyBazar
		File app = new File(appDir, "\\Apps\\PolicyBazaar_1.0.8.apk");


		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "192.168.0.7:5555");	
		cap.setCapability("appActivity", "com.policybazaar.login.Splash_DashBoard");
		cap.setCapability("appPackage", "com.policybazaar");
		cap.setCapability("app", app.getAbsolutePath());
		driver=new AndroidDriver(new URL ("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		//driver=new IOSDriver(new URL ("http://127.0.0.1:4743/wd/hub"), cap);
	//	driver.findElement(By.id(id))		
		//driver.findElementById("com.policybazaar:id/iv_logo").click();
	}


}
