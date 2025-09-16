package com.ecommerce.tests;

import org.testng.annotations.Test;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;

public class E_CommerceLogoTest extends BaseTest {
	
    HomePage homePage;
	
	@Test
	public void verifyE_CommerceLogoIsVisible() {
	    
	    homePage = new HomePage(driver);

	    /** Step 1: Scroll down to bottom of page */
	    homePage.logECommerceLogo();

	}


}
