package com.ecommerce.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.ProductsPage;
import com.ecommerce.utilities.ExtentManager;


public class AddProductsToCartTest extends BaseTest {
	
	    @Test
	    public void verifyAddProductsToCart() {
	    	
	     // Step 1: Initialize HomePage & ProductsPage
	        HomePage cartPage = new HomePage(driver);
	     //   productsPage.clickProducts();      

	     // Step 2: Add multiple products dynamically
	        cartPage.clickAddToCartButton(1);            // 1st product
	        System.out.println("Step1 passed");
	        cartPage.clickContinueShopping();
	        ExtentManager.getTest().info("Added 1st product to cart");

	        cartPage.clickAddToCartButton(3);            // 2nd product
	        cartPage.clickContinueShopping();
	        ExtentManager.getTest().info("Added 2nd product to cart");

	        cartPage.clickAddToCartButton(3);             // 3rd product
	        ExtentManager.getTest().info("Added 3rd product to cart");

	     // Step 3: View Cart
	        cartPage.clickViewCart();
	        ExtentManager.getTest().info("Navigated to View Cart");

	     // Step 4: Verify number of items in cart
	        int itemCount = cartPage.getNumberOfItemsInCart();
	        ExtentManager.getTest().info("Total number of items in cart: <b>" + itemCount+"</b>");
	        Assert.assertTrue(itemCount >= 2, "Less than 2 items found in cart");

	     // Step 5: Verify product prices dynamically
	        String price1 = cartPage.getProductPrice(1);
	        String price2 = cartPage.getProductPrice(2);

	        ExtentManager.getTest().info("Product 1 Price: " + price1);
	        ExtentManager.getTest().info("Product 2 Price: " + price2);

	        Assert.assertFalse(price1.isEmpty(), "Product 1 price not found");
	        Assert.assertFalse(price2.isEmpty(), "Product 2 price not found");

	     // Step 6: Verify product quantities dynamically
	        String qty1 = cartPage.getProductQuantity(1); 
	        String qty2 = cartPage.getProductQuantity(2);

	        ExtentManager.getTest().info("Product 1 Quantity: " + qty1);
	        ExtentManager.getTest().info("Product 2 Quantity: " + qty2);

	        Assert.assertTrue(Integer.parseInt(qty1) > 0, "Invalid quantity for product 1");
	        Assert.assertTrue(Integer.parseInt(qty2) > 0, "Invalid quantity for product 2");

	     // Step 7: Verify total price
	        int totalCartPrice = cartPage.getTotalCartPrice();
	        ExtentManager.getTest().info("Calculated Total Cart Price: <b>" + totalCartPrice+"</b>");
	        Assert.assertTrue(totalCartPrice > 0, "Total price is not calculated correctly");

	     // ✅ Final Pass log
	        ExtentManager.getTest().pass("Verified <b>Add to Cart</b> flow successfully with multiple products");
	    }

	    
}
