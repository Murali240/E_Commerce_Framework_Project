package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.utilities.ExtentManager;


public class VerifyPlaceOrderRegistrationBeforeCheckoutTest extends BaseTest {
	
	private HomePage homePage;
	
	@Test
	public void verifyPlaceOrderAfterSuccessfulRegistration() {

	    /** Initialize HomePage object with active WebDriver */
	    homePage = new HomePage(driver);

	    /** Verify Home Page is displayed */
	    Assert.assertTrue(homePage.isHomeButtonDisplayed(), "Home page not displayed");
	    ExtentManager.getTest().pass("Verified Home Page is displayed successfully");
	    
	 // ===== Account Creation Flow =====
	    homePage.clickSignupLogin();
	    homePage.enterNewUserName("Mahesh Yadavalli");
	    homePage.enterNewUserEmail("murali" + System.currentTimeMillis() + "@gmail.com");
	    homePage.clickSignupButton();
	    homePage.selectMrRadioButton();
	    homePage.enterNewUserPassword("testing123");
	    homePage.selectDay("5");
	    homePage.selectMonth("June");
	    homePage.selectYear("1996");
	    homePage.clickNewsletterCheckbox();
	    homePage.enterFirstName("Mahesh");
	    homePage.enterLastName("Yadavalli");
	    homePage.enterCompany("OpenAI Solutions");
	    homePage.enterMainAddress("Flat No. 201, Space Building");
	    homePage.enterAddressLineTwo("Near Tech Park, Hyderabad");
	    homePage.selectCountry("India");
	    homePage.enterState("Telangana");
	    homePage.enterCity("Hyderabad");
	    homePage.enterZipcode("500032");
	    homePage.enterMobileNumber("9876543210");
	    homePage.clickCreateAccountButton();

	    /** Verify Account Creation */
	    Assert.assertTrue(homePage.isAccountCreatedDisplayed(), "Account Created message not displayed");
	    String actualMessage = homePage.getCongratulationsMessage();
	    Assert.assertTrue(actualMessage.contains("Congratulations!"), "Account creation message mismatch");
	    ExtentManager.getTest().pass("Verified Account Creation: " + actualMessage);

	    /** Continue to Home after account creation */
	    homePage.clickContinueButton();

	    /** Verify Logged in as <username> */
	    String actualUserName = homePage.getLoggedInUserName();
	    Assert.assertEquals(actualUserName, "Mahesh Yadavalli", "Logged in username mismatch!");
	    ExtentManager.getTest().pass("Verified Logged in as <b>" + actualUserName + "</b>");
	   
	    /** Add product to cart */
	    homePage.clickProducts();
	    homePage.clickAddToCartButton(1);
	    ExtentManager.getTest().info("Added 1st product to cart");

	    /** Click 'Cart' button */
	    homePage.clickViewCart();
	    ExtentManager.getTest().info("Navigated to Cart page");

	    /** Proceed to Checkout */
	    homePage.clickProceedToCheckoutButton();
	    ExtentManager.getTest().info("Clicked on 'Proceed To Checkout' button");

	    /** Verify Address Details & Review Your Order */
	    Assert.assertTrue(homePage.isAddressDetailsHeadingDisplayed(), "Address Details not displayed");
	    Assert.assertTrue(homePage.isReviewYourOrderHeadingDisplayed(), "Review Your Order not displayed");
	    ExtentManager.getTest().pass("Verified Address Details and Review Your Order sections are visible");

	    /** Enter comment & Place Order */
	    homePage.enterCommentForOrder("Please deliver between 9AM-6PM");
	    ExtentManager.getTest().info("Entered order comment: Please deliver between 9AM-6PM");
	    homePage.clickPlaceOrder();
	    ExtentManager.getTest().info("Clicked on 'Place Order' button");

	    /** Enter Payment details */
	    homePage.enterNameOnCard("John Doe");
	    homePage.enterCardNumber("4111111111111111");
	    homePage.enterCVV("123");
	    homePage.enterExpiryMonth("12");
	    homePage.enterExpiryYear("2028");
	    ExtentManager.getTest().info("Entered payment details successfully");

	    /** Pay & Confirm Order */
	    homePage.clickPayAndConfirmOrder();
	    ExtentManager.getTest().info("Clicked on 'Pay and Confirm Order' button");

	    /** Verify Order Success */
	    String successMessage = homePage.getOrderPlacedCongratsMessage();
	    Assert.assertTrue(successMessage.contains("Congratulations! Your order has been confirmed!"),
	            "Order confirmation message mismatch");
	    ExtentManager.getTest().pass("Verified Order Placed successfully: <b>" + successMessage+"</b>");

	    /** Delete Account */
	    homePage.clickDeleteAccount();
	    ExtentManager.getTest().info("Clicked on 'Delete Account' link");

	    /** Verify Account Deleted */
	    Assert.assertTrue(homePage.isAccountDeletedHeadingDisplayed(), "Account Deleted heading not displayed");
	    ExtentManager.getTest().pass("Verified <b>ACCOUNT DELETED!</b> message is displayed successfully");
	}


}
