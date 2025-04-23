package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class TSeleniumUtility<TakeScreenshot> {
	public void maximizeWindow(WebDriver driver) 
	{
		driver.manage().window().maximize();
	}
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
		
	}
	public void WaitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions);
		
	}
	public void handleDropDown(WebElement element, String visibleText) {
		Select s=new Select(element);
		s.selectByVisibleText(visibleText);
				
	}
	public void handleDropDown(String Value, WebElement element) {
		Select s=new Select(element);
		s.deselectByValue(Value);
		
	}
	public void handleFrame(WebDriver driver,int index)
	{
	    driver.switchTo().frame(index);
	    
	}
	public void handleFrame(WebDriver driver,String IDorName)
	{
		driver.switchTo().frame(IDorName);
	}
	public void handleFrame(WebDriver driver,WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	
	public void switchToParent(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	public void switchTodefault(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	public void switchToWindow(WebDriver driver, String windowHandle)
	{
		driver.switchTo().window(windowHandle);
	}
	
	public void scrollDown(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500);", "");
	}
	public void scrollRight(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(500,0);", "");
	}
	public void scrollleft(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(-500,0);", "");
	}
	/*public String captureScreenShot(WebDriver driver,String screenShotName) throws IOException
	{
		TakeScreenshot ts= (TakeScreen) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst= new File(".\\Screenshots\\"+screenShotName+".png");
		FileHandler.copy(src,dst);
		
		return dst.getAbsolutePath();
	}8*/
	public String captureScreenShot(WebDriver driver,String screenShotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShots\\"+screenShotName+".png"); //tsname_date_Time
		FileHandler.copy(src, dst);
		
		return dst.getAbsolutePath(); //For Extent reports
	}
}
