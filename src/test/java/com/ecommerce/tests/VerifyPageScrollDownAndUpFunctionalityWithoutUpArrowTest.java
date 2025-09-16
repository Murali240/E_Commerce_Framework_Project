package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.utilities.ExtentManager;
import com.ecommerce.utilities.WaitUtils;


public class VerifyPageScrollDownAndUpFunctionalityWithoutUpArrowTest extends BaseTest {
	
	HomePage homePage;
	
	@Test
	public void verifyPageScrollDownAndUpWithoutUpArrow() {
	    
	    homePage = new HomePage(driver);

	    /** Step 1: Scroll down to bottom of page */
	    homePage.scrollPageToBottom();
	    WaitUtils.waitForSeconds(driver, 1);
	    ExtentManager.getTest().info("Scrolled down to the bottom of the page");
	
	    /** Step 2: Verify footer is visible after scroll down */
	    Assert.assertTrue(homePage.isFooterVisible(), "Footer is not visible after scrolling down");
        ExtentManager.getTest().pass("Verified that <b>Footer</b> is visible after scrolling down");

	    /** Step 3: Scroll back up to top of page */
	    homePage.scrollPageToUp();
	    WaitUtils.waitForSeconds(driver, 1);
	    ExtentManager.getTest().info("Scrolled back up to the top of the page");

	    /** Step 4: Verify page is scrolled up and header logo is visible */
	    Assert.assertTrue(homePage.isHeaderLogoVisible(), "Header logo not visible after scrolling up");
        ExtentManager.getTest().pass("Verified that page scrolled up successfully and <b>Header Logo</b> is visible");
	    
        /** Final Assertion */
        ExtentManager.getTest().pass("Verified <b>Scroll Down and Scroll Up functionality</b> successfully without using Up Arrow button");
	
	}

	
}
