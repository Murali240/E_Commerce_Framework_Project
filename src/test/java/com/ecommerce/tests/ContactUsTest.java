package com.ecommerce.tests;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.utilities.ExtentManager;
import com.ecommerce.utilities.WaitUtils;

public class ContactUsTest extends BaseTest {
	
	@Test
    public void verifyContactUsFormSubmission() {
		
        HomePage homePage = new HomePage(driver);

        homePage.clickContactUs();
        Assert.assertTrue(homePage.isGetInTouchDisplayed(), "Get In Touch heading not displayed");

        homePage.enterName("John Doe");
        homePage.enterEmailForContactUS("john@example.com");
        homePage.enterSubject("Automation Query");
        homePage.enterMessage("This is a sample message entered in the contact form.");
        homePage.uploadFile("C:\\Users\\mural\\Downloads\\LoginCredentials.xlsx");
        homePage.clickSubmit();
        WaitUtils.waitForSeconds(driver, 1);
        
     // Handling Confirmation Alert
        Alert alert = driver.switchTo().alert();
        alert.accept();                            // clicks OK button

     // ✅ Final validation only
        Assert.assertTrue(homePage.isSuccessMessageDisplayed(), "Success message not displayed");
        WaitUtils.waitForSeconds(driver, 2);

        ExtentManager.getTest().pass("Verified <b>Contact Us</b> form submitted successfully and success message is displayed.");
    
	}

	
}


