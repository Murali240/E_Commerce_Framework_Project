package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.ProductsPage;
import com.ecommerce.utilities.ExtentManager;
import com.ecommerce.utilities.WaitUtils;


public class SubmitProductReviewTest extends BaseTest {

	ProductsPage productsPage;
	
	@Test
    public void verifySubmitProductReviewSuccessfully() {
	
        /** Initialize the ProductPage object */
		productsPage = new ProductsPage(driver);
		
	    /** Step 1: Navigate to Products page */
        productsPage.clickProducts();
        Assert.assertTrue(productsPage.isAllProductsHeadingDisplayed(), "All Products heading not displayed");

        /** Step 2: Get total product count (form All Products) */
        int totalProducts = productsPage.getProductsCount();
        ExtentManager.getTest().info("Total Products available: " + totalProducts);

        /** Step 3: Click on the 1st product (you can parameterize this index) */
        productsPage.clickProductByIndex(3);
        String name = productsPage.getProductName();
        ExtentManager.getTest().info("Product Name in product details page: <b>" + name+"</b>");

        /** Enter reviewer name */
		productsPage.enterNameForReview("Krishna K");
        ExtentManager.getTest().pass("Entered reviewer name: <b>Krishna K</b>");

        /** Enter reviewer email */
        productsPage.enterEmailForReview("muralikrishna@gmail.com");
        ExtentManager.getTest().pass("Entered reviewer email: <b>muralikrishna@gmail.com</b>");

        /** Enter review comment */
        productsPage.enterProductReview("This is a detailed product review for testing purpose.");
        ExtentManager.getTest().pass("Entered product review comment successfully");
        
        /** Click Submit button */
        productsPage.clickSubmitReviewButton();
        ExtentManager.getTest().pass("Clicked on <b>Submit Review</b> button");

        if (productsPage.isReviewSuccessMessageDisplayed()) {
        	ExtentManager.getTest().pass("Review submitted and <b>success message</b> verified successfully");
        	WaitUtils.waitForSeconds(driver, 1);
        } else {
            ExtentManager.getTest().fail("Review submission failed or success message not displayed");
        }
      
    }


}
