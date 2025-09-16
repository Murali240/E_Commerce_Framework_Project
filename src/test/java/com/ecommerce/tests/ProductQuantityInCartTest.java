package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.ProductsPage;
import com.ecommerce.utilities.ExtentManager;


public class ProductQuantityInCartTest extends BaseTest {
	
	@Test
	public void verifyProductQuantityAndAddToCart() {

	 // Initialize ProductsPage
	    ProductsPage productsPage = new ProductsPage(driver);

	 // Step 1: Navigate to first product
	    productsPage.clickProductByIndex(1);

	 // Step 2: Verify "Write Your Review" link is displayed
	    Assert.assertTrue(productsPage.isWriteYourReviewDisplayed(),
	            "'Write Your Review' link was not displayed on Product Page");
	    ExtentManager.getTest().info("Verified <b>Write Your Review</b> tab is displayed on Product Details page");

	 // Step 3: Set Product Quantity and Add to Cart
	    productsPage.setProductQuantity("4");
	    ExtentManager.getTest().info("Set Product Quantity to: 4");

	    productsPage.clickAddToCart();
	    ExtentManager.getTest().info("Clicked on 'Add to Cart' button from Product Details page");

	    productsPage.clickViewCart();
	    ExtentManager.getTest().info("Clicked on 'View Cart' button from Add to Cart popup successfully");
  
	 // Step 4: Fetch Product Quantity from Cart
	    String actualQuantityInCart = productsPage.getProductQuantity(1);
	    ExtentManager.getTest().info("Product Quantity retrieved from Cart page: " + actualQuantityInCart);

	 // Step 5: Validate Product Quantity is updated correctly
	    Assert.assertEquals(actualQuantityInCart, "4",
	            "Product quantity in Cart did not match expected value");
	    ExtentManager.getTest().pass("Verified Product Quantity updated successfully in Cart page: " + actualQuantityInCart);

	 // ✅ Final Extent log
	    ExtentManager.getTest().pass("Verified <b>Product Quantity & Add to Cart</b> flow successfully");
	}

	
}
