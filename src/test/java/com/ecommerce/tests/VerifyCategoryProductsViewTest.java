package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.utilities.ExtentManager;


public class VerifyCategoryProductsViewTest extends BaseTest {
	
	    private HomePage homePage;    
	
	    @Test
	    public void verifyWomenDressCategoryNavigation() {
		 
			/** Initialize HomePage object with active WebDriver */
		    homePage = new HomePage(driver);
		    
	        /** Step 1: Click on Women category */
		    homePage.clickWomenCategory();
	        ExtentManager.getTest().info("Clicked on Women category link");

	        /** Step 2: Click on Dress sub-category */
	        homePage.clickDressSubCategory();
	        ExtentManager.getTest().info("Clicked on Dress sub-category under Women");

	        /** Step 3: Verify Women - Dress Products heading is displayed */
	        Assert.assertTrue(homePage.isWomenDressProductsHeadingDisplayed(),
	                "Women - Dress Products heading not displayed");
	        ExtentManager.getTest().pass("Verified Women - Dress Products heading displayed successfully");
	
	        
	        /** Step 4: Click on Men category */
	        homePage.clickMenCategory();
	        ExtentManager.getTest().info("Clicked on Men category link");

	        /** Step 5: Click on T-Shirts sub-category */
	        homePage.clickTShirtsSubCategory();
	        ExtentManager.getTest().info("Clicked on T-Shirts sub-category under Men");

	        /** Step 6: Verify Men - TShirts Products heading is displayed */
	        Assert.assertTrue(homePage.isMenTshirtsProductsHeadingDisplayed(),
	                "Men - TShirts Products heading not displayed");
	        ExtentManager.getTest().pass("Verified Men - TShirts Products heading displayed successfully");
	
	}

	
}
