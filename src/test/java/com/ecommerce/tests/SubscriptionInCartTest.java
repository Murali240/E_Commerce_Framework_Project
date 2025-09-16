package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.utilities.ExtentManager;
import com.ecommerce.utilities.WaitUtils;

public class SubscriptionInCartTest extends BaseTest {
	
	@Test
    public void verifySubscribeFlowInCart() {
		
     // Step 1: Initialize SubscriptionPage
        HomePage homePage = new HomePage(driver);
        homePage.clickCartLink();

     // Step 2: Verify Subscription section is displayed
        Assert.assertTrue(homePage.isSubscriptionTextDisplayed(), 
                          "Subscription section is not displayed");
        ExtentManager.getTest().info("Subscription section is visible");

     // Step 3: Enter email and click subscribe
        String email = "testemail@example.com";        // You can parameterize this
        homePage.enterSubscriptionEmail(email);
        WaitUtils.waitForSeconds(driver, 1);
        ExtentManager.getTest().info("Entered subscription email: " + email);

        homePage.clickSubscriptionArrow();
        ExtentManager.getTest().info("Clicked subscription arrow button");

     // Step 4: Verify success message
        String successMessage = homePage.getSubscriptionSuccessMessage();
        ExtentManager.getTest().info("Subscription message displayed: <b>" + successMessage+"</b>");
        Assert.assertEquals(successMessage, "You have been successfully subscribed!", 
                            "Subscription success message mismatch");

     // ✅ Final pass log
        ExtentManager.getTest().pass("Subscription flow verified successfully for email: " + email);
    
	}

	
}
