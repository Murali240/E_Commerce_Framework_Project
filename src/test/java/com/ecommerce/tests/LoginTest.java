package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.utilities.ExtentManager;


public class LoginTest extends BaseTest {
	
	/** Page Object reference for HomePage, shared across all test methods */
	private HomePage homePage;
	
	@Test
    public void verifyLoginTest() {
		
	    /** Initializes the HomePage object with the active WebDriver */
        homePage = new HomePage(driver);
		
     // Navigate to Login link
        homePage.clickSignupLogin();

     // Enter credentials
        homePage.enterEmail("muralikrishna.kolusu3@gmail.com");
        homePage.enterPassword("testing123");

     // Click Login button
        homePage.clickLoginButton();
        
     // Assert that logout link is displayed after login
        Assert.assertTrue(homePage.isLogoutDisplayed(), "Logout link should be visible after login");
        ExtentManager.getTest().pass("Verified: <b>Logout</b> link is displayed after successful login with valid credentials");

    }


}
