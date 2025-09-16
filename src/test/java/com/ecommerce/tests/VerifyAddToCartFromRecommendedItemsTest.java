package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.utilities.ExtentManager;


public class VerifyAddToCartFromRecommendedItemsTest extends BaseTest {
	
	HomePage homePage;

    @Test
    public void verifyAddToCartFromRecommendedItems() {

        /** Initialize HomePage with active WebDriver */
        homePage = new HomePage(driver);

        /** Step 1: Verify Recommended Items section is displayed */
        if (homePage.isRecommendedItemsHeadingDisplayed()) {
            ExtentManager.getTest().pass("Verified that <b>Recommended Items</b> section is visible");
        } else {
            ExtentManager.getTest().fail("Recommended Items section is <b>not visible</b>");
        }
        Assert.assertTrue(homePage.isRecommendedItemsHeadingDisplayed(), "Recommended Items section is not visible");

        /** Step 2: Add 1st recommended product to Cart */
        homePage.clickOnRecommendedProductAddToCart(2);
        ExtentManager.getTest().pass("Clicked on <b>Recommended Product</b> Add to Cart button");
        
        /** Click on View Cart button */
        homePage.clickViewCart();

        /** Step 3: Verify Shopping Cart page is displayed after adding product */
        if (homePage.isShoppingCartPageDisplayed()) {
            ExtentManager.getTest().pass("Verified <b>Shopping Cart</b> page is displayed after adding product");
        } else {
            ExtentManager.getTest().fail("Shopping Cart page is <b>not displayed</b> after adding product");
        }
        Assert.assertTrue(homePage.isShoppingCartPageDisplayed(), "Shopping Cart page is not displayed after adding product");
    
        /** Step 4: Verify number of items in cart */
        int itemCount = homePage.getNumberOfItemsInCart();
        ExtentManager.getTest().info("Total number of items in cart: <b>" + itemCount+"</b>");
        ExtentManager.getTest().pass("Verified that <b>Recommended Item</b> is successfully displayed in the Cart page");
    
    }

   
}
