package libraries;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class MyTestListner extends TestListenerAdapter
{
	public void onTestFailure(ITestResult arg0) 
	{
				
		File scrFile = ((TakesScreenshot)SuperTestNG.driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		try {
			FileUtils.copyFile(scrFile, new File("./screenshots/"+"/failed/"+"_failed"+arg0.getStatus()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void onTestSuccess(ITestResult arg0)
	{		
		File scrFile = ((TakesScreenshot)SuperTestNG.driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		try {
			FileUtils.copyFile(scrFile, new File("./screenshots/"+"_passed"+arg0.getStatus()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}