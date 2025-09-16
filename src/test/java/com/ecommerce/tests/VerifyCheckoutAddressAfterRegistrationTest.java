package com.ecommerce.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.utilities.ExtentManager;


public class VerifyCheckoutAddressAfterRegistrationTest extends BaseTest {
	
	private HomePage homePage;
	
	@Test
    public void validateDeliveryAndBillingAddressAreSame() {
    	
	    /** Initializes the HomePage object with the active WebDriver */
        homePage = new HomePage(driver);
        
        /** Navigate to Signup link */
        homePage.clickSignupLogin();
    	
        /** Enter new user name */
        homePage.enterNewUserName("Mahesh Yadavalli");

        /** Enter new user email */
        homePage.enterNewUserEmail("murali" + System.currentTimeMillis() + "@gmail.com");

        /** Click on Signup button */
        homePage.clickSignupButton();

        /** Select Title Mr */
        homePage.selectMrRadioButton();

        /** Enter password */
        homePage.enterNewUserPassword("testing123");

        /** Select Date of Birth */
        homePage.selectDay("5");
        homePage.selectMonth("June");
        homePage.selectYear("1996");

        /** Select checkboxes */
        homePage.clickNewsletterCheckbox();
       // homePage.clickSpecialOffersCheckbox();

        /** Enter personal details */
        homePage.enterFirstName("Mahesh");
        homePage.enterLastName("Yadavalli");
        homePage.enterCompany("OpenAI Solutions");
        homePage.enterMainAddress("Flat No. 201, Space Building");
        homePage.enterAddressLineTwo("Near Tech Park, Hyderabad");

        /** Select country */
        homePage.selectCountry("India");

        /** Enter city, state, zipcode, and mobile number */
        homePage.enterState("Telangana");
        homePage.enterCity("Hyderabad");
        homePage.enterZipcode("500032");
        homePage.enterMobileNumber("9876543210");

        /** Click on Create Account button */
        homePage.clickCreateAccountButton();
 
        /** Assert "Account Created!" heading is visible   ====== Assertion ====== */
        Assert.assertTrue(homePage.isAccountCreatedDisplayed(), "Account Created message should be visible");
        
        /** Verify Congratulations message text */
        String actualMessage = homePage.getCongratulationsMessage();
        Assert.assertTrue(actualMessage.contains("Congratulations!"), "Congratulations message should appear");
        ExtentManager.getTest().info(actualMessage);
        
        /** Click Continue button */
        homePage.clickContinueButton();
        
        /** Verify "Logged in as <username>" is displayed */
        String actualUserName = homePage.getLoggedInUserName();

        Assert.assertEquals(actualUserName, "Mahesh Yadavalli", "Logged in username does not match expected!");
        ExtentManager.getTest().pass("Verified: User is automatically Logged in as <b>" + actualUserName + "</b> after signup.");
      
	    /** Add products dynamically */
        homePage.clickAddToCartButton(1);            // 1st product
        homePage.clickViewCart();
        homePage.isShoppingCartPageDisplayed();
        homePage.clickProceedToCheckoutButton();
        
        /** Step 1: Fetch Delivery and Billing addresses */
        List<String> deliveryAddress = homePage.getDeliveryAddressDetails();
        List<String> billingAddress = homePage.getBillingAddressDetails();

        /** Step 2: Log values for readability */
        ExtentManager.getTest().info("Delivery Address: " + deliveryAddress);
        ExtentManager.getTest().info("Billing Address: " + billingAddress);

        /** Step 3: Assert both addresses are identical */
        Assert.assertEquals(deliveryAddress, billingAddress,
                "Delivery Address and Billing Address do not match!");

        ExtentManager.getTest().pass("Verified that <b>Delivery Address</b> and <b>Billing Address</b> are the same after registration");
       
    }
 

}
