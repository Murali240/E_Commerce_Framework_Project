package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.ProductsPage;
import com.ecommerce.utilities.ExtentManager;
import com.ecommerce.utilities.WaitUtils;


public class RemoveProductsFromCartTest extends BaseTest {
	
	@Test
	public void verifyRemoveProductFromCart() {
	    
	    /** Step 1: Initialize HomePage & ProductsPage */
	    HomePage cartPage = new HomePage(driver);
	    ProductsPage productsPage = new ProductsPage(driver);
	    productsPage.clickProducts();      

	    /** Step 2: Add multiple products dynamically */
	    cartPage.clickAddToCartButton(1);                          // 1st product
	    cartPage.clickContinueShopping();
	    ExtentManager.getTest().info("Added 1st product to cart");

	    cartPage.clickAddToCartButton(3);                          // 2nd product
	    cartPage.clickContinueShopping();
	    ExtentManager.getTest().info("Added 2nd product to cart");

	    cartPage.clickAddToCartButton(5);                         // 3rd product (corrected index to avoid duplicate)
	    ExtentManager.getTest().info("Added 3rd product to cart");

	    /** Step 3: View Cart */
	    cartPage.clickViewCart();
	    ExtentManager.getTest().info("Navigated to View Cart");

	    /** Step 4: Verify number of items in cart before removal */
	    int itemCount1 = cartPage.getNumberOfItemsInCart();
	    ExtentManager.getTest().info("Total number of products in cart page before removing products: <b>" + itemCount1 + "</b>");
	    
	    /** Step 5: Remove one product from cart */
	    productsPage.clickProductRemoveIcon(2); // removes product-2
	    WaitUtils.waitForSeconds(driver, 1);
	    int itemCount2 = cartPage.getNumberOfItemsInCart();
	    ExtentManager.getTest().info("Total number of products in cart page after removing products: <b>" + itemCount2 + "</b>");

	    /** Step 6: Final Pass log */
	    ExtentManager.getTest().pass("Verified <b>Remove Products</b> from cart page successfully");
	}


}
