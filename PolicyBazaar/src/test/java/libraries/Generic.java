package libraries;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.base.Function;


/*
 * Author : Aditya
 * Created on : 06/11/2015
 */

public class Generic 
{
	
	public static String getStringCellValue(String excelPath, String sheetName, int row, int col)
	{
		String var = null;
		try
		{
			FileInputStream fis = new FileInputStream(excelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			var = sh.getRow(row).getCell(col).getStringCellValue();
			
		}catch(Exception e)
		{
			Generic.failATestCase("Exception occured in fetching string cell value"+e.getMessage());
		}
		return var;
	}
	
	public static void setStringCellValue(String excelPath, String sheetName, int row, int col,String value)
	{
		
		try
		{
			FileInputStream fis = new FileInputStream(excelPath);
			Workbook wb = WorkbookFactory.create(fis);
//			wb.getSheet(sheetName).getRow(row).getCell(col).setCellValue(value);
			if(wb.getSheet(sheetName) == null){wb.createSheet(sheetName);}
			if(wb.getSheet(sheetName).getRow(row) == null){wb.getSheet(sheetName).createRow(row);}
			if(wb.getSheet(sheetName).getRow(row).getCell(col) == null){wb.getSheet(sheetName).getRow(row).createCell(col);}
			if(wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue() == null){wb.getSheet(sheetName).getRow(row).getCell(col).setCellValue(value);}
			else
			{
				wb.getSheet(sheetName).getRow(row).getCell(col).setCellValue(value);
			}
			
			FileOutputStream fos = new FileOutputStream(excelPath);
			wb.write(fos);
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			Generic.failATestCase("Exception occured in setting string cell value : "+e.getMessage());
		}
	}
	
	public static long getNumericCellValue(String excelPath, String sheetName, int row, int col)
	{
		long num = 0;
		try
		{
			FileInputStream fis = new FileInputStream(excelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			num = (long) sh.getRow(row).getCell(col).getNumericCellValue();
			
		}catch(Exception e)
		{
			Reporter.log("Exception occured in fetching string cell value : "+e,true);
		}
		return num;
	}
	
	public static Map<String, String> getKEY_VALUE_OnColCondition(String excelPath, String sheetName,int conditionCol,int valuesPresentInColumn, String[] strList)
	{
		Map<String, String> map = new HashMap<String, String>();
		String var = null;
		try
		{
			FileInputStream fis = new FileInputStream(excelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Iterator<Row> shIt = sh.iterator();
			System.out.println("Before while loop");
			 while (shIt.hasNext()) 
			 {
				 Row row = shIt.next();
				 
				 for(int i=0;i<strList.length;i++)
		            {
					 	String firstColEle = row.getCell(conditionCol).getStringCellValue();
		            	if(firstColEle.equals(strList[i]))
		            	{
		            		var=row.getCell(1).getStringCellValue();
		            		System.out.println(var);
		            		map.put(firstColEle, var);
		            	}

		            }
			 }
		}
		catch(NullPointerException n)
		{
			Reporter.log("Exception occured : "+n);
		} catch (FileNotFoundException e) {
			Reporter.log("File not found for the given path",true);
		}  catch (Exception e) {
			Reporter.log("Exception occured : "+e,true);
		}
		return map;	
	}
	@SuppressWarnings("null")
	public static String[] getValues_BasedOnInputColumn(String excelPath, String sheetName,int conditionCol,int valuesPresentInColumn, String[] strList)
	{
		String[] arrayString = null;
		String var = null;
		try
		{
			FileInputStream fis = new FileInputStream(excelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Iterator<Row> shIt = sh.iterator();
			System.out.println("Before while loop");
			 while (shIt.hasNext()) 
			 {
				 Row row = shIt.next();
				 
				 for(int i=0;i<strList.length;i++)
		            {
					 	String firstColEle = row.getCell(conditionCol).getStringCellValue();
		            	if(firstColEle.equals(strList[i]))
		            	{
		            		var=row.getCell(valuesPresentInColumn).getStringCellValue();
		            		arrayString[i]=var;
		            		i++;
		            	}
		            }
			 }
		}
		catch(NullPointerException n)
		{
			Reporter.log("Exception occured : "+n);
		} catch (FileNotFoundException e) {
			Reporter.log("File not found for the given path",true);
		}  catch (Exception e) {
			Reporter.log("Exception occured : "+e,true);
		}
		return arrayString;
	}
	public static int getRowCount(String excelPath, String sheetName)
	{
		int count=-1;
		try
		{
			FileInputStream fis = new FileInputStream(excelPath);
			Workbook wb = WorkbookFactory.create(fis);
			count = wb.getSheet(sheetName).getLastRowNum();		
		}catch(Exception e)
		{
			Generic.failATestCase("Exception occured in fetching row count from excel. Crosscheck the excel --->"+excelPath+"--->"+sheetName);
		}
		return count;
	}
	public static int getLastCellNumber(String excelPath, String sheetName, int row)
	{
		int cell=-1;
		try
		{
			FileInputStream fis = new FileInputStream(excelPath);
			Workbook wb = WorkbookFactory.create(fis);
			cell = wb.getSheet(sheetName).getRow(row).getLastCellNum();		
		}catch(Exception e)
		{
			Reporter.log("Exception occured in reading excel : "+e,true);
		}
		return cell;
	}

	public static boolean waitForElementVisible(WebDriver driver, WebElement element)
	{
		
		try
		{
			nullifyImplicitlyWait();
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.withTimeout(20, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS).ignoring(StaleElementReferenceException.class);
			wait.until(ExpectedConditions.visibilityOf(element));
			
		}catch(TimeoutException t)
		{
			return isPresentAndDisplayed(element);
			
		}catch(Exception e)
		{
			Generic.failATestCase("Exception occured while waiting for element to be visible");
		}
		finally
		{enableImplicitlyWait();}
		return false;
	}
	
	public static void waitForElementToClick(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.withTimeout(SuperTestNG.implicitlyWait, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
		
	public static void waitForTitlePresent(WebDriver driver, String title)
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.withTimeout(30, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	public static void validatePageTitle(WebDriver driver, String actualTitle)
	{
		waitForTitlePresent(driver, actualTitle);
		String currentTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, currentTitle);
		Reporter.log("Actual and obtained title matches",true);
	}
	public static void doAssertion(String actual, String expected)
	{
		Assert.assertEquals(actual, expected);
		Reporter.log("Assertion done on : "+actual,true);
	}
	
	public static void doAssertion(WebDriver driver,WebElement actual, String xpath)
	{
		String obtainedTxt = driver.findElement(By.xpath(xpath)).getText();
		String actualTxt=actual.getText();
		Assert.assertEquals(actualTxt, obtainedTxt);
	}
	
	public static String selectvalueFromDropDownBySelectClass(WebElement we,String actual)
	{
		String selected = null;
		int index = -1;
		try
		{
			
			List<WebElement> list = new Select(we).getOptions();
			int count = list.size();
			
			for(int i=0; i<count;i++)
			{
				String obtained = list.get(i).getText();
				if(actual.equals(obtained))
				{
					index=i;
					selected=obtained;
					break;
				}
			}
			list.get(index).click();
			Generic.forceSleep(2000);
			
		}catch(Exception e)
		{
			Reporter.log("Exception occured in selecting data from drop down"+e.toString(),true);
		}
		return selected;
	}
	
	public static void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}
	
		
	public static void failATestCase(String message)
	{
		Reporter.log("Test case failed due to :"+message,true);
		Assert.fail(message);
	}
	
	public static void captureScreenshot()
	{
		
	}
	
	public static void nullifyImplicitlyWait()
	{
		SuperTestNG.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}
	
	public static void enableImplicitlyWait()
	{
		SuperTestNG.driver.manage().timeouts().implicitlyWait(SuperTestNG.implicitlyWait, TimeUnit.SECONDS);
	}
	
	public static boolean waitForElement(final WebElement element)
	{
		nullifyImplicitlyWait();
		FluentWait<WebElement> wait = new FluentWait<WebElement>(element);
		wait.withTimeout(7, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS).ignoring(StaleElementReferenceException.class);
		try
		{
			Function<WebElement, Boolean> fun = new Function<WebElement, Boolean>()
					{

						@Override
						public Boolean apply(WebElement element) 
						{
							if(!element.isDisplayed())
							{
								return false;
							}
							else
							{
								return true;
							}
							
						}
					};
						return wait.until(fun);
		}catch (TimeoutException e)
		{
			return false;
		}
		catch (NoSuchElementException e)
		{
			return false;
		}
		finally
		{
			enableImplicitlyWait();
		}
		
	}
	
	public static boolean waitForElement_LongPeriod(final WebElement element)
	{
		nullifyImplicitlyWait();
		FluentWait<WebElement> wait = new FluentWait<WebElement>(element);
		wait.withTimeout(17, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS).ignoring(StaleElementReferenceException.class);
		try
		{
			Function<WebElement, Boolean> fun = new Function<WebElement, Boolean>()
					{

						@Override
						public Boolean apply(WebElement element) 
						{
							if(!element.isDisplayed())
							{
								return false;
							}
							else
							{
								return true;
							}
							
						}
					};
						return wait.until(fun);
		}catch (TimeoutException e)
		{
			return false;
		}
		catch (NoSuchElementException e)
		{
			return false;
		}
		finally
		{
			enableImplicitlyWait();
		}
		
	}
	
	public static boolean waitForElement_smallPeriod(final WebElement element)
	{
		nullifyImplicitlyWait();
		FluentWait<WebElement> wait = new FluentWait<WebElement>(element);
		wait.withTimeout(3, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS);
		try
		{
			Function<WebElement, Boolean> fun = new Function<WebElement, Boolean>()
					{

						@Override
						public Boolean apply(WebElement element) 
						{
							if(!element.isDisplayed())
							{
								return false;
							}
							else
							{
								return true;
							}
							
						}
					};
						return wait.until(fun);
		}catch (TimeoutException e)
		{
			return false;
		}
		catch (NoSuchElementException e)
		{
			return false;
		}
		finally
		{
			enableImplicitlyWait();
		}
		
	}
	
	
	
	public static String[] loopExcelSheetForData(String excelPath, String sheetName,int startRow, int col)
	{
		int rowCount = getRowCount(excelPath, sheetName);
		String[] var = new String[rowCount];
		int j=0;
		for(int i=startRow;i<=rowCount;i++)
		{
			var[j] = getStringCellValue(excelPath, sheetName, i, col);
			j++;
		}
		return var;
	}
		
	public static boolean isPresentAndDisplayed(final WebElement element) 
	{
		  try {
		    return element.isDisplayed();
		  } catch (NoSuchElementException e) {
		    return false;
		  }
	}
		
	public static Object[][] OneDimToTwoDim( final String[] array, final int rows, final int cols ) 
	{
	    if (array.length != (rows*cols))
	        throw new IllegalArgumentException("Invalid array length");

	    String[][] bidi = new String[rows][cols];
	    for ( int i = 0; i < rows; i++ )
	        System.arraycopy(array, (i*cols), bidi[i], 0, cols);
	    return bidi;
	}
	
	public static void typeDataAndPressTab(String s) 
	{
		Robot robo = null;
		try {
			robo = new Robot();
			robo.setAutoDelay(20);
			byte[] bytes = s.getBytes();
			
			for(Byte b: bytes)
			{
				int code=b;
				if(code>96 && code <123)
				{
					code=code-32;
					robo.keyPress(code);
					robo.keyRelease(code);
					robo.setAutoDelay(20);
				}
				else if(code>64 && code<91)
				{
					robo.keyPress(KeyEvent.VK_SHIFT);
					robo.keyPress(code);
					robo.setAutoDelay(20);
					robo.keyRelease(code);
					robo.keyRelease(KeyEvent.VK_SHIFT);
					
				}
				else
				{
					robo.keyPress(code);
					robo.setAutoDelay(20);
					robo.keyRelease(code);
				}
							
				
			}
			robo.setAutoDelay(20);
			robo.keyPress(KeyEvent.VK_TAB);
			robo.keyRelease(KeyEvent.VK_TAB);
			
			
		} catch (AWTException e) 
		{
			Reporter.log("Exception Inside typeData method while entering authentication data",true);
		}
		
	}
	public static void pressEnterBtn()
	{
		Robot robo;
		try {
			robo = new Robot();
			robo.keyPress(KeyEvent.VK_ENTER);
			robo.keyRelease(KeyEvent.VK_ENTER);
			
		} catch (AWTException e) 
		{
			e.printStackTrace();
		}	
	}
	public static void forceSleep(int timeInMilliSec)
	{
		try 
		{
			Thread.sleep(timeInMilliSec);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	public static int randomNumberGenerator()
	{
		int num;
		Random random = new Random();
		num=random.nextInt(1000);
		return num;
	}
	
	public static String alterEmailId(String email)
	{
		StringTokenizer st = new StringTokenizer(email, "@");
		return ((String) st.nextElement()+randomNumberGenerator()+"@"+st.nextElement());		
	}		
}