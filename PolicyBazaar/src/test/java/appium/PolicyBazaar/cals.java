package appium.PolicyBazaar;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;

public class cals {
	
	public static void main(String[] args) throws MalformedURLException {
		AppiumDriver driver;
    	DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "192.168.0.4:5555");	
		cap.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		cap.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		driver=new AndroidDriver(new URL ("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

		
		
		driver.findElementById("com.sec.android.app.popupcalculator:id/bt_06").click();
		driver.findElementById("com.sec.android.app.popupcalculator:id/bt_05").click();
		
		driver.findElementById("com.sec.android.app.popupcalculator:id/bt_add").click();
		
		driver.findElementById("com.sec.android.app.popupcalculator:id/bt_05").click();
		
		driver.findElementById("com.sec.android.app.popupcalculator:id/bt_equal").click();
		
		
		String Result=driver.findElementById("com.sec.android.app.popupcalculator:id/txtCalc").getText();
		
		System.out.println(Result);
		//Assert.assertEquals(message, expected, actual, delta);
		
		
	}


}
