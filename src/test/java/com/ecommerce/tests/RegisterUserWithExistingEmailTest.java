package com.ecommerce.tests;

import org.testng.annotations.Test;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.utilities.ExtentManager;


public class RegisterUserWithExistingEmailTest extends BaseTest {
	
	private HomePage homePage;
	 
    @Test
    public void verifyNewUserSignup() {
    	
	    /** Initializes the HomePage object with the active WebDriver */
        homePage = new HomePage(driver);
        
        /** Navigate to Signup link */
        homePage.clickSignupLogin();
    	
        /** Enter new user name */
        homePage.enterNewUserName("Murali Krishna");

        /** Enter new user email */
        homePage.enterNewUserEmail("muralikrishna.kolusu3@gmail.com");

        /** Click on Signup button */
        homePage.clickSignupButton();

        /** Validate that the email ID already exists during registration */
        if (homePage.isEmailAlreadyExistedDisplayed()) {
        	ExtentManager.getTest().pass(
        		    "Verified that the <b>Email Address already exist!</b> error message is displayed "
        		    + "when attempting to register with an existing email ID");

        } else {
        	ExtentManager.getTest().fail("No error displayed.");
        }
    }
 

}
