package Practies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import http://java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import http

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class testProduct {

	public static void main(String[] args) throws IOException {
		
		//Read Common Data from Property file
		FileInputStream fis = new FileInputStream(".src\\main\\resources\\commanData.properties");
		Properties p = new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		//Read Test Data From Excel File
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet("Product");
		Row rw = sh.getRow(1);
		Cell cl = rw.getCell(2);
		String PRODUCTNAME = cl.getStringCellValue();
		
		// Step 1: Launch the browser
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Step 2: Load the Application
		driver.get(URL);

		// Step 3: login To Application
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();

		// Step 4: Click on a Product 
		WebElement productEle= driver.findElement(By.xpath("//div[.=''Sauce Labs Bolt T-Shirt]"));
		String pAddedToCart=productEle.getText();
		productEle.click();

		// Step 5: Add the Product To Cart
		driver.findElement(By.id("add-to-cart")).click();

		// Step 6: Navigate to Cart
			driver.findElement(By.id("shopping_cart_container")).click();

		// Step 7: Validate the product in Cart
		String pInCart = driver.findElement(By.className("inventory_item_name")).getText();
		if (pInCart.equals(pAddedToCart)) {
			System.out.println("PASS");
			System.out.println(pInCart);
		} else {
			System.out.println("FAIL");
		}

		// Step 8: Logout of App
		  driver.findElement(By.id("react-burger-menu-btn")).click();
		  driver.findElement(By.linkText("Logout")).click();
	}

}
 