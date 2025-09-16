package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.utilities.ExtentManager;


public class LoginWithInvalidCredentialsTest extends BaseTest {
	
	@Test
	public void verifyLoginWithInvalidCredentials() {
		
	    HomePage homePage = new HomePage(driver);

	    homePage.clickSignupLogin();
	    homePage.enterEmail("wrong.email@test.com");
	    homePage.enterPassword("wrongPassword123");
	    homePage.clickLoginButton();

	    Assert.assertTrue(homePage.isIncorrectEmailPasswordWarningDisplayed(),
	            "Warning message should be displayed for invalid login.");

	    ExtentManager.getTest().pass("Verified: Warning message displayed for invalid login attempt.");
	}


}
