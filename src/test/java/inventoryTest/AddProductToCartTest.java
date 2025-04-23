package inventoryTest;

import java.io.IOException;

import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;

public class AddProductToCartTest extends BaseClass{

	@Test
	public void tc_001_AddProductToCartTest() throws IOException
	{
		// Read Test Data From Excel File
		String PRODUCTNAME = fUtil.readDataFromExcel("Product", 1, 2);

		// Step 4: Click on a Product
		InventoryPage ip = new InventoryPage(driver);
		String pAddedToCart = ip.clickOnAProduct(driver, PRODUCTNAME);

		// Step 5: Add the Product To Cart
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCartBtn();

		// Step 6: Navigate to Cart
		ip.clickOnCartContainer();

		// Step 7: Validate the product in Cart
	    CartPage cp = new CartPage(driver);
	    String pInCart = cp.getProductName();
		
		if (pInCart.equals(pAddedToCart)) {
			System.out.println("PASS");
			System.out.println(pInCart);
		} else {
			System.out.println("FAIL");
		}

	}

}
 