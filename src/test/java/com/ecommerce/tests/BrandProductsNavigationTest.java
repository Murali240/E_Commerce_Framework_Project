package com.ecommerce.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.utilities.ExtentManager;


public class BrandProductsNavigationTest extends BaseTest {
	
	HomePage homePage;
	
	    @Test
	    public void verifyBrandProductsNavigation() {

	        /** Initialize Page Object */
	        homePage = new HomePage(driver);

	        /** Step 1: Click on Products link */
	        homePage.clickProducts();

	        /** Step 2: Verify that Brands section is visible */
	        if (homePage.isBrandsHeadingDisplayed()) {
	            ExtentManager.getTest().pass("Verified that <b>Brands section</b> is visible on the left sidebar");
	        } else {
	            ExtentManager.getTest().fail("Brands section is <b>not visible</b> on the left sidebar");
	        }

	        /** Step 3: Log all brands with counts */
	        List<String> brandsWithCounts = homePage.getAllBrandsWithCountsFromSidebar();
	        ExtentManager.getTest().info("Available brands with product counts: " + brandsWithCounts);
	        brandsWithCounts.forEach(System.out::println);

	        /** Step 4: Click on 'Polo' and verify navigation */
	        verifyBrandNavigation("Polo");

	        /** Step 5: Click on 'H&M' and verify navigation */
	        verifyBrandNavigation("H&M");      
	    }	 
	 
	    /** Helper method to click brand, verify heading, and log matched product count  */
	    private void verifyBrandNavigation(String brandName) {
	        /** Click on the brand */
	        homePage.clickOnBrand(brandName);

	        /** Get the brand page heading */
	        String heading = homePage.getBrandPageHeadingText();

	        /** Verify heading contains brand name */
	        if (heading.toLowerCase().contains(brandName.toLowerCase().trim())) {
	            ExtentManager.getTest().pass(
	                    "Successfully navigated to <b>" + brandName + "</b> brand page and products are displayed");
	        } else {
	            ExtentManager.getTest().fail(
	                    "Failed to navigate to <b>" + brandName + "</b> brand page or products not displayed. Actual heading: "
	                            + heading);
	        }

	        Assert.assertTrue(heading.toLowerCase().contains(brandName.toLowerCase().trim()),
	                "Brand page not displayed for " + brandName + ". Actual heading: " + heading);

	        /** Get matched products count and log it */
	        int matchedCount = homePage.getMatchedProductsCount();
	        ExtentManager.getTest().info("Matched Products Count for <b>" + brandName + "</b>: " + matchedCount);
	    }

	    
}
	    
	    
	   