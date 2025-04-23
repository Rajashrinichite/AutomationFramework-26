package Practies;
import genericUtilities.SeleniumUtility;import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import http://java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import http://org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;

public class TAddProductToCArtUsingDDTandGU {

	public static void main(String[] args) throws IOException {
		
		//Create Object Of All Required Utility Classes
		FileUtility fUtil = new FileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		JavaUtility jUtil = new JavaUtility();
		
		// Read Common Data from Property file
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");

		// Read Test Data From Excel File
		String PRODUCTNAME = fUtil.readDataFromExcel("Product", 1, 2);

		// Step 1: Launch the browser
		WebDriver driver = new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlywait(driver);

		// Step 2: Load the Application
		driver.get(URL);

		// Step 3: login To Application
		driver.findElement(http://By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(http://By.id("password")).sendKeys(PASSWORD);
		driver.findElement(http://By.id("login-button")).click();

		// Step 4: Click on a Product
		WebElement productEle = driver.findElement(By.xpath("//div[.='" + PRODUCTNAME + "']"));
		String pAddedToCart = productEle.getText();
		http://productEle.click();

		// Step 5: Add the Product To Cart
		driver.findElement(http://By.id("add-to-cart")).click();

		// Step 6: Navigate to Cart
		driver.findElement(http://By.id("shopping_cart_container")).click();
		
		//Capture Screenshots for reference 
		String screenshotname = "Tc_001"+jUtil.getSystemDateInFormat();
		String path = sUtil.captureScreenShot(driver, screenshotname);
		System.out.println(path);

		// Step 7: Validate the product in Cart
		String pInCart = driver.findElement(By.className("inventory_item_name")).getText();
		if (pInCart.equals(pAddedToCart)) {
			System.out.println("PASS");
			System.out.println(pInCart);
		} else {
			System.out.println("FAIL");
		}

		// Step 8: Logout of App
		driver.findElement(http://By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

}

