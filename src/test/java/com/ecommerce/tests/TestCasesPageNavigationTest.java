package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.utilities.ExtentManager;
import com.ecommerce.utilities.WaitUtils;

public class TestCasesPageNavigationTest extends BaseTest {
	
	@Test
    public void verifyNavigationToTestCasesPage() {
		
		HomePage homePage = new HomePage(driver);

		homePage.clickTestCases();
		WaitUtils.waitForSeconds(driver, 2);
        Assert.assertTrue(homePage.isTestCasesHeadingDisplayed(), "Test Cases heading not displayed");
        

        ExtentManager.getTest().pass("Verified navigation to <b>Test Cases</b> page successfully.");
    }


}
