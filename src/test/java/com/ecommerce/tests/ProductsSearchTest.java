package com.ecommerce.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.ProductsPage;
import com.ecommerce.utilities.ExtentManager;


public class ProductsSearchTest extends BaseTest {
	
	@Test
    public void verifySearchProducts() {
		
        ProductsPage productsPage = new ProductsPage(driver);

     // Step 1: Navigate to Products page
        productsPage.clickProducts();
        Assert.assertTrue(productsPage.isAllProductsHeadingDisplayed(), "All Products heading not displayed");

     // Step 2: Perform search
        String keyword = "Cotton";                // You can parameterize this
        productsPage.enterSearchText(keyword);
        productsPage.clickSearchButton();

     // Step 3: Verify searched products heading
        Assert.assertTrue(productsPage.isSearchedProductsHeadingDisplayed(), "'Searched Products' heading not displayed");

     // Step 4: Get matched products count and names
        int count = productsPage.getMatchedProductsCount();
        ExtentManager.getTest().info("Matched Products Count: " + count);

        List<String> productNames = productsPage.getMatchedProductsText();
        ExtentManager.getTest().info("Matched Products: " + productNames);

     // Step 5: Assertions
        Assert.assertTrue(count > 0, "No products found for search keyword: " + keyword);

     // ✅ Final Extent log
        ExtentManager.getTest().pass("Verified <b>Searched Products</b> successfully with keyword: <b>" 
                                     + keyword + "</b>. Total products found: <b>" + count + "</b>");
    }

	
}
