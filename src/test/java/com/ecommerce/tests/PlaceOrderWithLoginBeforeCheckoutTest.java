package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.utilities.ExtentManager;


public class PlaceOrderWithLoginBeforeCheckoutTest extends BaseTest {
	
    private HomePage homePage;
	
	@Test
	public void verifyPlaceOrderAfterLoginBeforeCheckout() {

	    /** Initialize HomePage object with active WebDriver */
	    homePage = new HomePage(driver);

	    /** Verify Home Page is displayed */
	    Assert.assertTrue(homePage.isHomeButtonDisplayed(), "Home page not displayed");
	    ExtentManager.getTest().pass("Verified Home Page is displayed successfully");
	    
	    /** Login with valid credentials */
	    homePage.clickSignupLogin();
        homePage.enterEmail("muralikrishna.kolusu3@gmail.com");
        homePage.enterPassword("testing123");
        homePage.clickLoginButton();

	    /** Verify Logged in as <username> */
	    String actualUserName = homePage.getLoggedInUserName();
	    Assert.assertEquals(actualUserName, "Murali", "Logged in username mismatch!");
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

	}

	
}
