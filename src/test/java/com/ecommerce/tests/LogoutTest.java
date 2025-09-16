package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.utilities.ExtentManager;


public class LogoutTest extends BaseTest {
	
	/** Page Object reference for HomePage, shared across all test methods */
    private HomePage homePage;
	
    @Test
    public void verifyLoginAndLogoutTest() {

        /** Initializes the HomePage object with the active WebDriver */
        homePage = new HomePage(driver);

     // Navigate to login page
        homePage.clickSignupLogin();

     // Enter credentials
        homePage.enterEmail("muralikrishna.kolusu3@gmail.com");
        homePage.enterPassword("testing123");

     // Click Login button
        homePage.clickLoginButton();

     // Assert that logout link is displayed after login
        Assert.assertTrue(homePage.isLogoutDisplayed(), "Logout link should be visible after login");
        ExtentManager.getTest().pass("Verified: <b>Logout</b> link is displayed after successful login with valid credentials.");

     // Click Logout link
        homePage.clickLogout();

      // Assert that user is redirected back to Signup/Login page
        Assert.assertTrue(homePage.isSignupLoginDisplayed(), "Signup/Login link should be visible after logout");
        ExtentManager.getTest().pass("Verified: <b>Signup/Login</b> link is displayed after successfully logged-out.");
  
    }


}
