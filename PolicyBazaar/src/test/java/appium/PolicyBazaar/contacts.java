package appium.PolicyBazaar;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class contacts {
	
	
	@org.testng.annotations.Test
	public void Test() throws MalformedURLException
	{
		
		AppiumDriver driver;
    	DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "192.168.0.4:5555");	
		cap.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
		cap.setCapability("appPackage", "com.android.contacts");
		driver=new AndroidDriver(new URL ("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		
		
		
		driver.findElement(By.id("android:id/search_src_text")).sendKeys("karan");
		
		
		WebElement clist=driver.findElement(By.id("android:id/list"));		
		List<WebElement> list=clist.findElements(By.className("android.view.View"));		
		list.get(0).click();
		
		driver.findElement(By.id("com.android.contacts:id/action_icon")).click();
		
	}

}
