package genericUtilities;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import objectRepository.InventoryPage;
import objectRepository.LoginPage;


public class BaseClass {
	
	public FileUtility fUtil = new FileUtility();
	public javautility jUtil = new javautility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	
	public WebDriver driver;

	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("----- Database Connection successfull -----");
	}
	
	@BeforeClass
	public void bcConfig() throws IOException
	{
		String URL = fUtil.readDataFromPropertyFile("url");
		
		driver = new ChromeDriver();
		
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlywait(driver);
		
		driver.get(URL);
		
		System.out.println("----- Browser Launch successfull -----");
	}
	
	@BeforeMethod
	public void bmConfig() throws IOException
	{
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("----- Login to App successfull -----");
	}
	
	
	@AfterMethod
	public void amConfig()
	{
		InventoryPage ip = new InventoryPage(driver);
		ip.logoutOfApp();
		
		System.out.println("----- Logout of App successfull -----");
	}
	
	@AfterClass
	public void acConfig()
	{
		driver.quit();
		
		System.out.println("----- Browser closure successfull -----");
	}
	
	
	@AfterSuite
	public void asConfig()
	{
		System.out.println("----- Database Closure successfull -----");
	}
}
 