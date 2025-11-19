package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.utilities.ExtentManager;
import com.ecommerce.utilities.FileDownloadUtils;
import com.ecommerce.utilities.WaitUtils;


public class DownloadInvoiceAfterPurchaseOrderTest extends BaseTest {
	
	private HomePage homePage;
	
	@Test
    public void verifyInvoiceDownloadAfterPurchase() throws InterruptedException {

		/** Initializes the HomePage object with the active WebDriver */
        homePage = new HomePage(driver);

        /** Verify Home Page is displayed */
	    Assert.assertTrue(homePage.isHomeButtonDisplayed(), "Home page not displayed");
	    ExtentManager.getTest().pass("Verified Home Page is displayed successfully");

	    /** Add product to cart */
	    homePage.clickAddToCartButton(3);
	    ExtentManager.getTest().info("Added 1st product to cart");

	    /** Click 'Cart' button */
	    homePage.clickViewCart();
	    ExtentManager.getTest().info("Navigated to Cart page");

	    /** Proceed to Checkout */
	    homePage.clickProceedToCheckoutButton();
	    ExtentManager.getTest().info("Clicked on 'Proceed To Checkout' button");

	    /** Register/Login during checkout */
	    homePage.clickRegisterLogin();
	    ExtentManager.getTest().info("Clicked on 'Register / Login' button");

	 // ===== Account Creation Flow =====
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

	    /** Navigate back to Cart */
	    homePage.clickCartLink();
	    ExtentManager.getTest().info("Opened Cart page again");

	    /** Proceed to Checkout again */
	    homePage.clickProceedToCheckoutButton();
	    ExtentManager.getTest().info("Proceeded to Checkout again");

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
	    
	    /** Step 1: Click 'Download Invoice' button */
	    homePage.clickDownloadInvoice();
	    ExtentManager.getTest().pass("Clicked on <b>Download Invoice</b> button");

        /** Step 2: Wait for download to complete */
        WaitUtils.waitForSeconds(driver, 3);              // you can replace with WebDriverWait for file existence

        /** Step 3: Verify invoice file is downloaded */
        String downloadPath = "C:\\Users\\mural\\Downloads";                // adjust path
        boolean isDownloaded = FileDownloadUtils.isFileDownloaded(downloadPath, "invoice");

        if (isDownloaded) {
            ExtentManager.getTest().pass("Invoice was successfully downloaded and verified in <b>Downloads folder</b>");
        } else {
            ExtentManager.getTest().fail("Invoice download verification failed. File not found in Downloads folder");
        }

        Assert.assertTrue(isDownloaded, "Invoice file was not downloaded successfully");
    
	    /** Delete Account */
	    homePage.clickDeleteAccount();
	    ExtentManager.getTest().info("Clicked on 'Delete Account' link");

	    /** Verify Account Deleted */
	    Assert.assertTrue(homePage.isAccountDeletedHeadingDisplayed(), "Account Deleted heading not displayed");
	    ExtentManager.getTest().pass("Verified <b>ACCOUNT DELETED!</b> message is displayed successfully");
       
	}


}
