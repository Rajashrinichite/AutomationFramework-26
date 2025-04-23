package Practies;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AddProductToCart {
	
		public static void main(String[] args)  {
			
			
			//step1: lounch the browser
			
			WebDriver driver=new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			//step1:load the Application
			driver.get("https://www.saucedemo.com/");
			
			
			//step3:Login to application
			driver.findElement(By.id("user-name")).sendKeys("standard_user\r\n"
					+ "");
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			driver.findElement(By.id("login-button")).click();
			
			
			//step4:Click on product- sauce Labs Bolt T-shirt
			WebElement productEle= driver.findElement(By.xpath("//div[.=''Sauce Labs Bolt T-Shirt]"));
			String pAddedToCart=productEle.getText();
			productEle.click();
			
            //step5:Add the product to cart
			driver.findElement(By.id("add-to-cart")).click();
			
			//step6:Navigate to cart
			driver.findElement(By.id("shopping_cart_container")).click();
			
			//step7:Validate the product in cart
			String pInCart = driver.findElement(By.className("inventory_item_name ")).getText();
			  if(pInCart.equals(pAddedToCart))
			  {
				  System.out.println("PASS");
				  System.out.println(pInCart);
			  }
			  else {
				  System.out.println("FAIL");
				
			}
			//step88:logout of App
			  driver.findElement(By.id("react-burger-menu-btn")).click();
			  driver.findElement(By.linkText("Logout")).click();
		}

}
