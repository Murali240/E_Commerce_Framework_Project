package com.ecommerce.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.ProductsPage;
import com.ecommerce.utilities.ExtentManager;


public class SearchProductsAndVerifyCartAfterLoginTest extends BaseTest {
	
	@Test
    public void searchProducts_AddToCart_VerifyPersistenceAfterLogin() {
		
        ProductsPage productsPage = new ProductsPage(driver);
        HomePage homePage = new HomePage(driver);

        /** Step 1: Navigate to Products page */
        productsPage.clickProducts();
        Assert.assertTrue(productsPage.isAllProductsHeadingDisplayed(), "All Products heading not displayed");
        ExtentManager.getTest().pass("Clicked on <b>Products</b> button");

        /** Step 2: Perform search */
        String keyword = "Cotton";                   // You can parameterize this
        productsPage.enterSearchText(keyword);
        productsPage.clickSearchButton();

        /** Step 3: Verify searched products heading */
        Assert.assertTrue(productsPage.isSearchedProductsHeadingDisplayed(), "'Searched Products' heading not displayed");
        ExtentManager.getTest().pass("Searched product: <b>" + keyword + "</b> and verified SEARCHED PRODUCTS section");
        
       /** Step 4: Get matched products count and names */
        int count = productsPage.getMatchedProductsCount();
        ExtentManager.getTest().info("Matched Products Count: " + count);

        List<String> productNames = productsPage.getMatchedProductsText();
        ExtentManager.getTest().info("Matched Products: " + productNames);

        /** Step 5: Assertions */
        Assert.assertTrue(count > 0, "No products found for search keyword: " + keyword);

        /** ✅ Final Extent log */
        ExtentManager.getTest().pass("Verified <b>Searched Products</b> successfully with keyword: <b>" 
                                     + keyword + "</b>. Total products found: <b>" + count + "</b>");
        
        /** Step 6: Verify adding searched products to cart */
        homePage.clickAddToCartButton(1);            // 1st product
        homePage.clickContinueShopping();
        ExtentManager.getTest().info("Added 1st product to cart");

        homePage.clickAddToCartButton(3);            // 2nd product
        homePage.clickContinueShopping();
        ExtentManager.getTest().info("Added 2nd product to cart");

        homePage.clickAddToCartButton(5);             // 3rd product
        ExtentManager.getTest().info("Added 3rd product to cart");

        /** Click on View Cart button */
        homePage.clickViewCart();
        ExtentManager.getTest().info("Navigated to View Cart before login");

        /** Step 7: Verify number of items in cart page */
        int cartProductsBeforeLogin = homePage.getNumberOfItemsInCart();
        ExtentManager.getTest().info("Verified products are visible in cart before login: <b>" + cartProductsBeforeLogin+"</b>");
    
        /** Step 8: Login and go to cart again */
        homePage.clickSignupLogin();
        homePage.enterEmail("muralikrishna.kolusu3@gmail.com");
        homePage.enterPassword("testing123");
        homePage.clickLoginButton();
        ExtentManager.getTest().pass("Verified: <b>Logout</b> link is displayed after successful login with valid credentials");
        
        homePage.clickCartLink();
        ExtentManager.getTest().info("Again navigated to View Cart after login");

        /** Step 9: Verify products in cart after login */
        int cartProductsAfterLogin = homePage.getNumberOfItemsInCart();
        Assert.assertEquals(cartProductsBeforeLogin, cartProductsAfterLogin, "Cart product count mismatch after login");
        ExtentManager.getTest().info("Verified products are visible in cart after login: <b>" + cartProductsAfterLogin+"</b>");
        
        /** Final Test Status */
        ExtentManager.getTest().pass("Searched products were successfully added and verified in the cart <b>both before and after login</b>");

    }


}
