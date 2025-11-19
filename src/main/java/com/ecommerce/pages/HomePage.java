package com.ecommerce.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ecommerce.utilities.ExtentManager;


public class HomePage  {
	
    private WebDriver driver;
    private JavascriptExecutor js;

    /** Constructor to initialize WebDriver and WebElements using PageFactory */
    public HomePage(WebDriver driver) {
    	
       this.driver = driver;
       this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }
    

 // ===== Locators using @FindBy =====
    
 // Login & Logout elements
    /** WebElement representing the "Signup / Login" link in the navigation menu */
    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
    private WebElement signupLoginLink;

    /** WebElement for entering the Email Address in the login form */
    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement emailAddressField;

    /** WebElement for entering the Password in the login form */
    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordField;

    /** WebElement representing the "Login" button in the login form */
    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement loginButton;
    
    /** WebElement representing the "Logout" link displayed after successful login */
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement logoutLink;
    
 // Signup link elements
    /** WebElement for entering new user's name */
    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement newUserName;

    /** WebElement for entering new user's email */
    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement newUserEmail;

    /** WebElement for clicking Signup button */
    @FindBy(xpath = "//button[normalize-space()='Signup']")
    private WebElement signupButton;

    /** WebElement for selecting Mr. radio button */
    @FindBy(xpath = "//input[@id='id_gender1']")
    private WebElement mrRadioButton;

    /** WebElement for entering new user's password */
    @FindBy(xpath = "//input[@id='password']")
    private WebElement newUserPassword;

    /** WebElement for selecting Day in DOB dropdown */
    @FindBy(xpath = "//select[@id='days']")
    private WebElement dayInDOB;

    /** WebElement for selecting Month in DOB dropdown */
    @FindBy(xpath = "//select[@id='months']")
    private WebElement monthInDOB;

    /** WebElement for selecting Year in DOB dropdown */
    @FindBy(xpath = "//select[@id='years']")
    private WebElement yearInDOB;

    /** WebElement for selecting Newsletter checkbox */
    @FindBy(xpath = "//input[@id='newsletter']")
    private WebElement newsletterCheckbox;

    /** WebElement for selecting Special Offers checkbox */
    @FindBy(xpath = "//input[@id='optin']")
    private WebElement specialOffersCheckbox;

    /** WebElement for entering First Name */
    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement firstNameField;

    /** WebElement for entering Last Name */
    @FindBy(xpath = "//input[@id='last_name']")
    private WebElement lastNameField;

    /** WebElement for entering Company Name */
    @FindBy(xpath = "//input[@id='company']")
    private WebElement companyField;

    /** WebElement for entering Main Address */
    @FindBy(xpath = "//input[@id='address1']")
    private WebElement mainAddressField;

    /** WebElement for entering Address Line 2 */
    @FindBy(xpath = "//input[@id='address2']")
    private WebElement addressFieldTwo;

    /** WebElement for selecting Country dropdown */
    @FindBy(xpath = "//select[@id='country']")
    private WebElement countryDropdown;

    /** WebElement for entering State */
    @FindBy(xpath = "//input[@id='state']")
    private WebElement stateField;

    /** WebElement for entering City */
    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityField;

    /** WebElement for entering Zipcode */
    @FindBy(xpath = "//input[@id='zipcode']")
    private WebElement zipcodeField;

    /** WebElement for entering Mobile Number */
    @FindBy(xpath = "//input[@id='mobile_number']")
    private WebElement mobileNumberField;

    /** WebElement for clicking Create Account button */
    @FindBy(xpath = "//button[normalize-space()='Create Account']")
    private WebElement createAccountButton;
    
 // Account Created elements 
    /** WebElement representing the "Account Created!" success heading */
    @FindBy(xpath = "//b[normalize-space()='Account Created!']")
    private WebElement accountCreated;

    /** WebElement representing the congratulations message after signup */
    @FindBy(xpath = "//p[contains(text(),'Congratulations! Your new account has been success')]")
    private WebElement congratulationsMessage;

    /** WebElement for clicking on the Continue button */
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    private WebElement continueButton;
    
    /** WebElement for the dynamic Logged in as <username> text */
    @FindBy(xpath = "//b[preceding-sibling::text()[normalize-space()='Logged in as']]")
    private WebElement loggedInAsUser;
    
 // Incorrect Email & Password warning message -Login
    /** Warning message shown when login fails with incorrect email/password */
    @FindBy(xpath = "//p[normalize-space()='Your email or password is incorrect!']")
    private WebElement incorrectEmailPasswordWarningMessage;
    
 // Already existed user mail id - Signup
    /** Email Address already exist! error message */
    @FindBy(xpath = "//p[normalize-space()='Email Address already exist!']")
    private WebElement emailAlreadyExisted;
    
 // Contact Us Link elements
    /** 🔗 "Contact us" link - Navigates to Contact Us page */
    @FindBy(xpath = "//a[normalize-space()='Contact us']")
    private WebElement contactUsLink;

    /** 📝 "Get In Touch" heading - Verify Contact Us page loaded */
    @FindBy(xpath = "//h2[normalize-space()='Get In Touch']")
    private WebElement getInTouchHeading;

    /** 👤 Name input field - Enter user's name */
    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement nameField;

    /** 📧 Email input field - Enter user's email address */
    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement emailField;

    /** 📌 Subject input field - Enter subject for query */
    @FindBy(xpath = "//input[@placeholder='Subject']")
    private WebElement subjectField;
    
    /** 📝 "Your Message Here" text area field */
    @FindBy(xpath = "//textarea[@id='message']")
    private WebElement yourMessageHereField;

    /** 📂 File upload button - Attach file to submit */
    @FindBy(xpath = "//input[@name='upload_file']")
    private WebElement chooseFileButton;

    /** ✅ Submit button - Click to submit Contact Us form */
    @FindBy(xpath = "//input[@name='submit']")
    private WebElement submitButton;

    /** 🎉 Success message - Verify form submission successful */
    @FindBy(xpath = "//div[@class='status alert alert-success']")
    private WebElement successMessage;

    /** 🏠 Home button - Navigate back to homepage */
    @FindBy(xpath = "//a[normalize-space()='Home']")
    private WebElement homeButton;
    
 // Test Cases link elements
    /** 📂 "Test Cases" link */
    @FindBy(xpath = "//a[normalize-space()='Test Cases']")
    private WebElement testCasesLink;

    /** 📝 "Test Cases" heading */
    @FindBy(xpath = "//b[normalize-space()='Test Cases']")
    private WebElement testCasesHeading;
    
 // Subscription elements
    /** Subscription section header */
    @FindBy(xpath = "//h2[normalize-space()='Subscription']")
    private WebElement subscriptionText;

    /** Email input box for subscription */
    @FindBy(xpath = "//input[@id='susbscribe_email']")
    private WebElement subscribeEmailBox;

    /** Right arrow button to submit subscription */
    @FindBy(xpath = "//i[@class='fa fa-arrow-circle-o-right']")
    private WebElement subscriptionRightArrow;

    /** Success message after subscription */
    @FindBy(xpath = "//div[@class='alert-success alert'][normalize-space()='You have been successfully subscribed!']")
    private WebElement successfullySubscribed;
    
 // Cart link element
    /** Cart link in the header */
    @FindBy(xpath = "//a[normalize-space()='Cart']")
    private WebElement cartLink;
    
 // Adding products to Cart elements
    /** Continue Shopping button */
    @FindBy(xpath = "//button[normalize-space()='Continue Shopping']")
    private WebElement continueShoppingButton;

    /** View Cart button */
    @FindBy(xpath = "//u[normalize-space()='View Cart']")
    private WebElement viewCartButton;

    /** All items images in cart (to count number of added items) */
    @FindBy(xpath = "//img[@alt='Product Image']")
    private List<WebElement> cartItems;
    
 // Order placing
    /** Locator for Proceed To Checkout button */
    @FindBy(xpath = "//a[normalize-space()='Proceed To Checkout']")
    private WebElement proceedToCheckoutButton;

    /** Locator for Register / Login button */
    @FindBy(xpath = "//u[normalize-space()='Register / Login']")
    private WebElement registerLoginButton;

    /** Locator for Address Details heading */
    @FindBy(xpath = "//h2[normalize-space()='Address Details']")
    private WebElement addressDetailsHeading;

    /** Locator for Review Your Order heading */
    @FindBy(xpath = "//h2[normalize-space()='Review Your Order']")
    private WebElement reviewYourOrderHeading;

    /** Locator for Add Comment for Your Order textarea */
    @FindBy(xpath = "//textarea[@name='message']")
    private WebElement addCommentForYourOrder;

    /** Locator for Place Order button */
    @FindBy(xpath = "//a[normalize-space()='Place Order']")
    private WebElement placeOrderButton;

    /** Locator for Payment heading */
    @FindBy(xpath = "//h2[normalize-space()='Payment']")
    private WebElement paymentHeading;

    /** Locator for Name on Card input */
    @FindBy(xpath = "//input[@name='name_on_card']")
    private WebElement nameOfCardInput;

    /** Locator for Card Number input */
    @FindBy(xpath = "//input[@name='card_number']")
    private WebElement cardNumberInput;

    /** Locator for CVV input */
    @FindBy(xpath = "//input[@placeholder='ex. 311']")
    private WebElement cvvInput;

    /** Locator for Expiry Month input */
    @FindBy(xpath = "//input[@placeholder='MM']")
    private WebElement monthExpireInput;

    /** Locator for Expiry Year input */
    @FindBy(xpath = "//input[@placeholder='YYYY']")
    private WebElement yearExpireInput;

    /** Locator for Pay and Confirm Order button */
    @FindBy(xpath = "//button[@id='submit']")
    private WebElement payAndConfirmOrderButton;

    /** Locator for Order Placed heading */
    @FindBy(xpath = "//b[normalize-space()='Order Placed!']")
    private WebElement orderPlacedHeading;

    /** Locator for Congratulations message */
    @FindBy(xpath = "//p[normalize-space()='Congratulations! Your order has been confirmed!']")
    private WebElement orderPlacedCongratsMessage;
    
    /** Download Invoice button on Order Confirmation page */
    @FindBy(xpath = "//a[normalize-space()='Download Invoice']")
    private WebElement downloadInvoiceButton;

    /** Locator for Delete Account link */
    @FindBy(xpath = "//a[normalize-space()='Delete Account']")
    private WebElement deleteAccountLink;

    /** Locator for Account Deleted heading */
    @FindBy(xpath = "//b[normalize-space()='Account Deleted!']")
    private WebElement accountDeletedHeading;

    /** Locator for Account Deleted permanently message */
    @FindBy(xpath = "//p[normalize-space()='Your account has been permanently deleted!']")
    private WebElement accountDeletedPermanentlyMessage;

    /** 🔗 "Products" link */
    @FindBy(xpath = "//a[@href='/products']")
    private WebElement productsLink;
    
 // View Category Products elements in home
    /** Women main category link */
    @FindBy(xpath = "//a[normalize-space()='Women']")
    private WebElement womenCategoryLink;

    /** Dress sub-category link under Women */
    @FindBy(xpath = "//div[@id='Women']//a[contains(text(),'Dress')]")
    private WebElement dressSubCategoryLink;

    /** Heading for Women - Dress Products */
    @FindBy(xpath = "//h2[normalize-space()='Women - Dress Products']")
    private WebElement womenDressProductsHeading;

    /** Men main category link */
    @FindBy(xpath = "//a[normalize-space()='Men']")
    private WebElement menCategoryLink;

    /** T-Shirts sub-category link under Men */
    @FindBy(xpath = "//a[normalize-space()='Tshirts']")
    private WebElement tShirtsSubCategoryLink;

    /** Heading for Men - TShirts Products */
    @FindBy(xpath = "//h2[normalize-space()='Men - Tshirts Products']")
    private WebElement menTshirtsProductsHeading;
    
    /** Locator for the "Brands" heading element on the Home page. */
    @FindBy(xpath = "//h2[normalize-space()='Brands']")
    private WebElement brandsHeading;
   
    /** Common XPath for brand links with counts */
    @FindBy(xpath = "//div[@class='brands-name']//li/a")
    private List<WebElement> totalNumberOfBrands;
    
    /** Brand product-counts */
    @FindBy(xpath = "//span[@class='pull-right']")     // Replace with correct locator
    private WebElement brandProductCount;

    /** Locator for dynamic brand product page heading (e.g., "Brand - Polo Products") */
    @FindBy(xpath = "//h2[starts-with(normalize-space(),'Brand -')]")
    private WebElement brandPageHeading;
    
    /** 📦 Matched Brand products titles(total) */
    @FindBy(xpath = "//div[@class='productinfo text-center']//p")
    private List<WebElement> matchedProducts;
    
    /** Recommended Items heading displayed at the bottom of the page */
    @FindBy(xpath = "//h2[normalize-space()='recommended items']")
    private WebElement recommendedItemsHeading;

    /** Active Shopping Cart page displaying */
    @FindBy(xpath = "//li[@class='active']")
    private WebElement shoppingCartPage;
    
 // Your Delivery Address & Billing Address elements
    /** Your Delivery Address heading */
    @FindBy(xpath = "//h3[normalize-space()='Your delivery address']")
    private WebElement yourDeliveryAddressHeading;

    /** Your Billing Address heading */
    @FindBy(xpath = "//h3[normalize-space()='Your billing address']")
    private WebElement yourBillingAddressHeading;

    /** Delivery Address fields */
    @FindBy(xpath = "//ul[@id='address_delivery']//li[@class='address_firstname address_lastname']")
    private WebElement deliveryName;

    @FindBy(xpath = "//ul[@id='address_delivery']//li[@class='address_address1 address_address2'][1]")
    private WebElement deliveryCompany;

    @FindBy(xpath = "//ul[@id='address_delivery']//li[@class='address_address1 address_address2'][2]")
    private WebElement deliveryAddressOne;

    @FindBy(xpath = "//ul[@id='address_delivery']//li[@class='address_address1 address_address2'][3]")
    private WebElement deliveryAddressTwo;

    @FindBy(xpath = "//ul[@id='address_delivery']//li[@class='address_city address_state_name address_postcode']")
    private WebElement deliveryCityStateZip;

    @FindBy(xpath = "//ul[@id='address_delivery']//li[@class='address_country_name']")
    private WebElement deliveryCountry;

    @FindBy(xpath = "//ul[@id='address_delivery']//li[@class='address_phone']")
    private WebElement deliveryMobile;

    /** Billing Address fields */
    @FindBy(xpath = "//ul[@id='address_invoice']//li[@class='address_firstname address_lastname']")
    private WebElement billingName;

    @FindBy(xpath = "//ul[@id='address_invoice']//li[@class='address_address1 address_address2'][1]")
    private WebElement billingCompany;

    @FindBy(xpath = "//ul[@id='address_invoice']//li[@class='address_address1 address_address2'][2]")
    private WebElement billingAddressOne;

    @FindBy(xpath = "//ul[@id='address_invoice']//li[@class='address_address1 address_address2'][3]")
    private WebElement billingAddressTwo;

    @FindBy(xpath = "//ul[@id='address_invoice']//li[@class='address_city address_state_name address_postcode']")
    private WebElement billingCityStateZip;

    @FindBy(xpath = "//ul[@id='address_invoice']//li[@class='address_country_name']")
    private WebElement billingCountry;

    @FindBy(xpath = "//ul[@id='address_invoice']//li[@class='address_phone']")
    private WebElement billingMobile;
    
 // Page Up arrow icon and Logo
    /** Scroll Up Arrow button */
    @FindBy(xpath = "//a[@id='scrollUp']")
    private WebElement scrollUpArrow;

    /** Footer section */
    @FindBy(xpath = "//footer")
    private WebElement footerSection;

    /** Header logo */
    @FindBy(xpath = "//img[@alt='Website for automation practice']")
    private WebElement headerLogo;
    
    
    

    // ===== Actions (Methods) =====

 // Login & Logout menthds
    /** Clicks on the "Signup / Login" link to navigate to the login page */
    public void clickSignupLogin() {
        signupLoginLink.click();
    }

    /** Enters the provided email address into the email field */
    public void enterEmail(String email) {
        emailAddressField.sendKeys(email);
    }

    /** Enters the provided password into the password field */
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    /** Clicks on the "Login" button to submit the login form */
    public void clickLoginButton() {
        loginButton.click();
    }

    /** Clicks on the "Logout" link */
    public void clickLogout() {
        logoutLink.click();
    }

    /** Returns true if the "Logout" link is displayed */
    public boolean isLogoutDisplayed() {
        return logoutLink.isDisplayed();
    }

    /** Returns true if the "Signup / Login" link is displayed */
    public boolean isSignupLoginDisplayed() {
        return signupLoginLink.isDisplayed();
    }

 // Signup methods
    /** Enters the new user's name */
    public void enterNewUserName(String name) {
        newUserName.sendKeys(name);
    }

    /** Enters the new user's email */
    public void enterNewUserEmail(String email) {
        newUserEmail.sendKeys(email);
    }

    /** Clicks on the Signup button */
    public void clickSignupButton() {
        signupButton.click();
    }

    /** Selects Mr. radio button */
    public void selectMrRadioButton() {
        mrRadioButton.click();
    }

    /** Enters the new user's password */
    public void enterNewUserPassword(String password) {
        newUserPassword.sendKeys(password);
    }

    /** Scrolls the element into view using JavaScriptExecutor */
    protected void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /** Selects a day from the Day dropdown */
    public void selectDay(String day) {
        scrollIntoView(dayInDOB);
        dayInDOB.click();     // open dropdown
        new Select(dayInDOB).selectByVisibleText(day.trim());    // trim spaces
    }

    /** Selects a month from the Month dropdown */
    public void selectMonth(String month) {
        scrollIntoView(monthInDOB);
        monthInDOB.click();   // open dropdown
        new Select(monthInDOB).selectByVisibleText(month.trim());
    }

    /** Selects a year from the Year dropdown */
    public void selectYear(String year) {
        scrollIntoView(yearInDOB);
        yearInDOB.click();   // open dropdown
        new Select(yearInDOB).selectByVisibleText(year.trim());
    }

    /** Clicks on the Newsletter checkbox */
    public void clickNewsletterCheckbox() {
        scrollIntoView(newsletterCheckbox);
        newsletterCheckbox.click();
    }

    /** Clicks on the Special Offers checkbox */
    public void clickSpecialOffersCheckbox() {
        scrollIntoView(specialOffersCheckbox);
        specialOffersCheckbox.click();
    }

    /** Enters the user's first name */
    public void enterFirstName(String firstName) {
        scrollIntoView(firstNameField);
        firstNameField.sendKeys(firstName);
    }

    /** Enters the user's last name */
    public void enterLastName(String lastName) {
        scrollIntoView(lastNameField);
        lastNameField.sendKeys(lastName);
    }

    /** Enters the company name */
    public void enterCompany(String company) {
        scrollIntoView(companyField);
        companyField.sendKeys(company);
    }

    /** Enters the main address */
    public void enterMainAddress(String address) {
        scrollIntoView(mainAddressField);
        mainAddressField.sendKeys(address);
    }

    /** Enters the second address line */
    public void enterAddressLineTwo(String addressLineTwo) {
        scrollIntoView(addressFieldTwo);
        addressFieldTwo.sendKeys(addressLineTwo);
    }

    /** Selects a country from the Country dropdown */
    public void selectCountry(String country) {
        scrollIntoView(countryDropdown);
        new Select(countryDropdown).selectByVisibleText(country);
    }

    /** Enters the user's state */
    public void enterState(String state) {
        scrollIntoView(stateField);
        stateField.sendKeys(state);
    }

    /** Enters the user's city */
    public void enterCity(String city) {
        scrollIntoView(cityField);
        cityField.sendKeys(city);
    }

    /** Enters the user's zipcode */
    public void enterZipcode(String zipcode) {
        scrollIntoView(zipcodeField);
        zipcodeField.sendKeys(zipcode);
    }

    /** Enters the user's mobile number */
    public void enterMobileNumber(String mobileNumber) {
        scrollIntoView(mobileNumberField);
        mobileNumberField.sendKeys(mobileNumber);
    }

    /** Clicks on the Create Account button */
    public void clickCreateAccountButton() {
        scrollIntoView(createAccountButton);
        createAccountButton.click();
    }
    
 // Account Created methods
    /** Checks if the "Account Created!" text is displayed */
    public boolean isAccountCreatedDisplayed() {
        return accountCreated.isDisplayed();
    }

    /** Gets the congratulations message text */
    public String getCongratulationsMessage() {
        return congratulationsMessage.getText();
    }

    /** Clicks on the Continue button */
    public void clickContinueButton() {
        continueButton.click();
    }
    
    /** Gets the logged in username text */
    public String getLoggedInUserName() {
        return loggedInAsUser.getText();
    }

 // Incorrect Email & Password warning method
    /** Checks if the incorrect email/password warning message is displayed */
    public boolean isIncorrectEmailPasswordWarningDisplayed() {
        scrollIntoView(incorrectEmailPasswordWarningMessage);
        return incorrectEmailPasswordWarningMessage.isDisplayed();
    }

 // Already user existed email id for Signup method
    /** Method to check if error message is displayed for "Email Address already exist!"  */
    public boolean isEmailAlreadyExistedDisplayed() {
        try {
            return emailAlreadyExisted.isDisplayed();
        } catch (Exception e) {
            return false;                                 // in case element is not present
        }
    }
    
 // Contact Us methods
    /** Click on Contact Us link */
    public void clickContactUs() {
        contactUsLink.click();
    }

    /** Verify Get In Touch heading is displayed */
    public boolean isGetInTouchDisplayed() {
        return getInTouchHeading.isDisplayed();
    }

    /** Enter Name */
    public void enterName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
    }

    /** Enter Email */
    public void enterEmailForContactUS(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    /** Enter Subject */
    public void enterSubject(String subject) {
        subjectField.clear();
        subjectField.sendKeys(subject);
    }
    
    /** 📝 Enter message into "Your Message Here" textarea */
    public void enterMessage(String message) {
        yourMessageHereField.sendKeys(message);
    }

    /** Upload File */
    public void uploadFile(String filePath) {
        chooseFileButton.sendKeys(filePath);
    }

    /** Click Submit */
    public void clickSubmit() {
        submitButton.click();
    }

    /** Verify Success Message displayed */
    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }

    /** Click Home Button */
    public void clickHome() {
        homeButton.click();
    }

    /** Verify Home Button displayed */
    public boolean isHomeButtonDisplayed() {
        return homeButton.isDisplayed();
    }
    
 // Test Cases methods
    /** Click on "Test Cases" link */
    public void clickTestCases() {
        testCasesLink.click();
    }

    /** Verify "Test Cases" heading is displayed */
    public boolean isTestCasesHeadingDisplayed() {
        return testCasesHeading.isDisplayed();
    }
    
 // Subscription methods
    /** Private helper method to navigate to any element */
    private void navigateToElement(WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }

    /** Method to check if subscription section is displayed */
    public boolean isSubscriptionTextDisplayed() {
        navigateToElement(subscriptionText);         // reuse helper
        return subscriptionText.isDisplayed();
    }

    /** Method to enter email in subscription box */
    public void enterSubscriptionEmail(String email) {
        navigateToElement(subscribeEmailBox);        // reuse helper
        subscribeEmailBox.sendKeys(email);
    }

    /** Method to click subscription arrow button 
    public void clickSubscriptionArrow() {
        navigateToElement(subscriptionRightArrow);   // reuse helper
        subscriptionRightArrow.click();
    }*/
    
    
    /** Method to click subscription arrow button */
    public void clickSubscriptionArrow() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));

        // Scroll arrow into the center of the screen
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior:'instant', block:'center'});",
                subscriptionRightArrow
        );

        // Wait until arrow is visible
        wait.until(ExpectedConditions.visibilityOf(subscriptionRightArrow));

        try {
            // Move to element to avoid hover issues
            new Actions(driver)
                    .moveToElement(subscriptionRightArrow)
                    .pause(Duration.ofMillis(400))
                    .perform();

            // Wait until clickable
            wait.until(ExpectedConditions.elementToBeClickable(subscriptionRightArrow));

            // Try normal click
            subscriptionRightArrow.click();
        }
        catch (Exception e) {
            // Fallback: JS click ignores popups / overlays
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", subscriptionRightArrow);
        }
    }

    

    /** Method to get subscription success message text */
    public String getSubscriptionSuccessMessage() {
        navigateToElement(successfullySubscribed);   // reuse helper
        return successfullySubscribed.getText();
    }
    
 // Cart methods
    /** Method to click on Cart link 
    public void clickCartLink() {
        navigateToElement(cartLink); // reusing helper method
        cartLink.click();
    }*/
    
    
    public void clickCartLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));

        By cartLocator = By.xpath("//a[@href='/view_cart']");  // adjust if needed

        try {
            // Re-find fresh cart element to avoid stale element issue
            WebElement freshCartLink = wait.until(
                   ExpectedConditions.presenceOfElementLocated(cartLocator)
            );

            // Scroll into view
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block:'center'});",
                    freshCartLink
            );

            // Try normal click
            wait.until(ExpectedConditions.elementToBeClickable(freshCartLink));
            freshCartLink.click();
        }
        catch (StaleElementReferenceException e) {

            // REFRESH AND TRY AGAIN
            WebElement freshCartLink2 = wait.until(
                   ExpectedConditions.presenceOfElementLocated(cartLocator)
            );

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", freshCartLink2);
        }
    }

    
 // Adding products to Cart methods
    /** Method to click Add to Cart button dynamically based on product index
     * Example: productIndex=1 → (//a[contains(text(),'Add to cart')])[1]
     * @param productIndex index number (1st=1, 2nd=3, 3rd=5 ...) 
    public void clickAddToCartButton(int productIndex) {
        String dynamicXpath = "(//a[contains(text(),'Add to cart')])[" + productIndex + "]";
        WebElement addToCartBtn = driver.findElement(By.xpath(dynamicXpath));
        addToCartBtn.click();
    }*/
    
    
    public void clickAddToCartButton(int productIndex) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));

        String dynamicXpath = "(//a[contains(text(),'Add to cart')])[" + productIndex + "]";

        WebElement addToCartBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicXpath))
        );

        // Scroll to center
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'instant', block: 'center'});",
                addToCartBtn
        );

        // Wait until no overlapping element is present
        wait.until(driver1 -> {
            try {
                return addToCartBtn.isDisplayed() && addToCartBtn.isEnabled() && 
                       addToCartBtn.getRect().getX() >= 0; // basic visibility check
            } catch (Exception e) {
                return false;
            }
        });

        // Try normal click
        try {
            new Actions(driver).moveToElement(addToCartBtn).pause(Duration.ofMillis(400)).perform();
            wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
            addToCartBtn.click();
        } 
        catch (Exception e) {
            // Fallback JS click when popup blocks normal click
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartBtn);
        }
    }



    /** Method to click Continue Shopping button */
    public void clickContinueShopping() {
        continueShoppingButton.click();
    }
    
    /** Method to click View Cart button using safeClick */
    public void clickViewCart() {
    	viewCartButton.click();
    }

    /** Method to click View Cart button  currently working code
    public void clickViewCart() {
        viewCartButton.click();
    } */

    /** Method to get total number of items in the cart */
    public int getNumberOfItemsInCart() {
        return cartItems.size();
    }

    /** Method to get product price dynamically by product row number
     * Example: productNumber=1 → //tr[@id='product-1']//td[@class='cart_price']
     * @param productNumber product index (1, 2, 3 ...) */
    public String getProductPrice(int productNumber) {
        String dynamicXpath = "//tr[@id='product-" + productNumber + "']//td[@class='cart_price']";
        return driver.findElement(By.xpath(dynamicXpath)).getText();
    }

    /** Method to get product quantity dynamically
     * Example:
     *   productNumber=1 → //tr[@id='product-1']//button[@class='disabled']
     *   productNumber=2 → //tr[@id='product-2']//button[@class='disabled']
     * @param productNumber product index (1, 2, 3 ...) */
    public String getProductQuantity(int productNumber) {
        String dynamicXpath = "//tr[@id='product-" + productNumber + "']//button[@class='disabled']";
        return driver.findElement(By.xpath(dynamicXpath)).getText();
    }

    /** Method to calculate total cart price properly by summing (unit price * quantity) 
     * for each product row.
     * Example:
     *   Product 1 → Rs. 500 × 1 = 500
     *   Product 2 → Rs. 400 × 1 = 400
     *   Final total = 900
     * @return total sum of all product prices in cart */
    public int getTotalCartPrice() {
     // Find total number of product rows dynamically
        List<WebElement> productRows = driver.findElements(By.xpath("//tr[starts-with(@id,'product-')]"));

        int total = 0;
        for (int i = 1; i <= productRows.size(); i++) {
         // 1. Get unit price (e.g. "Rs. 500")
            String priceText = getProductPrice(i).replace("Rs.", "").trim();
            int unitPrice = Integer.parseInt(priceText);

         // 2. Get quantity (e.g. "2")
            String qtyText = getProductQuantity(i).trim();
            int quantity = Integer.parseInt(qtyText);

         // 3. Add (unit price × quantity) to total
            total += unitPrice * quantity;
        }
        return total;
    }
    
 // Order Placing methods
    /** Click Proceed To Checkout button */
    public void clickProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }

    /** Click Register / Login button */
    public void clickRegisterLogin() {
        registerLoginButton.click();
    }

    /** Verify Address Details heading is displayed */
    public boolean isAddressDetailsHeadingDisplayed() {
        return addressDetailsHeading.isDisplayed();
    }

    /** Verify Review Your Order heading is displayed (using JavaScriptExecutor) */
    public boolean isReviewYourOrderHeadingDisplayed() {
        js.executeScript("arguments[0].scrollIntoView(true);", reviewYourOrderHeading);
        return reviewYourOrderHeading.isDisplayed();
    }

    /** Enter comments for order (using JavaScriptExecutor) */
    public void enterCommentForOrder(String comment) {
        js.executeScript("arguments[0].scrollIntoView(true);", addCommentForYourOrder);
        addCommentForYourOrder.clear();
        addCommentForYourOrder.sendKeys(comment);
    }

    /** Click Place Order button (using JavaScriptExecutor) */
    public void clickPlaceOrder() {
        js.executeScript("arguments[0].scrollIntoView(true);", placeOrderButton);
        js.executeScript("arguments[0].click();", placeOrderButton);
    }

    /** Verify Payment heading is displayed */
    public boolean isPaymentHeadingDisplayed() {
        return paymentHeading.isDisplayed();
    }

    /** Enter card holder name */
    public void enterNameOnCard(String name) {
        nameOfCardInput.sendKeys(name);
    }

    /** Enter card number */
    public void enterCardNumber(String number) {
        cardNumberInput.sendKeys(number);
    }

    /** Enter CVV number */
    public void enterCVV(String cvv) {
        cvvInput.sendKeys(cvv);
    }

    /** Enter expiry month */
    public void enterExpiryMonth(String month) {
        monthExpireInput.sendKeys(month);
    }

    /** Enter expiry year */
    public void enterExpiryYear(String year) {
        yearExpireInput.sendKeys(year);
    }

    /** Click Pay and Confirm Order button 
    public void clickPayAndConfirmOrder() {
        payAndConfirmOrderButton.click();
    }*/
    
    
    /** Click Pay and Confirm Order button */
    public void clickPayAndConfirmOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));

        // Scroll to the button (center of screen)
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'instant', block: 'center'});",
                payAndConfirmOrderButton
        );

        // Wait for button to become visible
        wait.until(ExpectedConditions.visibilityOf(payAndConfirmOrderButton));

        // Try normal click first
        try {
            new Actions(driver)
                    .moveToElement(payAndConfirmOrderButton)
                    .pause(Duration.ofMillis(500))
                    .perform();

            wait.until(ExpectedConditions.elementToBeClickable(payAndConfirmOrderButton));
            payAndConfirmOrderButton.click();
        } 
        catch (Exception e) {
            // Fallback to JavaScript click if popup blocks it
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", payAndConfirmOrderButton);
        }
    }

    

    /** Verify Order Placed heading is displayed */
    public boolean isOrderPlacedHeadingDisplayed() {
        return orderPlacedHeading.isDisplayed();
    }

    /** Get Congratulations message text */
    public String getOrderPlacedCongratsMessage() {
        return orderPlacedCongratsMessage.getText();
    }
    
    /** Clicks on Download Invoice button */
    public void clickDownloadInvoice() {
        downloadInvoiceButton.click();
    }

    /** Click Delete Account link */
    public void clickDeleteAccount() {
        deleteAccountLink.click();
    }

    /** Verify Account Deleted heading is displayed */
    public boolean isAccountDeletedHeadingDisplayed() {
        return accountDeletedHeading.isDisplayed();
    }

    /** Get Account Deleted permanently message text */
    public String getAccountDeletedPermanentlyMessage() {
        return accountDeletedPermanentlyMessage.getText();
    }
    
    /** Click on Products link */
    public void clickProducts() { 
    	productsLink.click(); 
    }
    
 // View Category Products methods in home 
    /** Click Women category link */
    public void clickWomenCategory() {
        womenCategoryLink.click();
    }

    /** Click Dress sub-category link */
    public void clickDressSubCategory() {
        dressSubCategoryLink.click();
    }

    /** Verify Women - Dress Products heading is displayed */
    public boolean isWomenDressProductsHeadingDisplayed() {
        return womenDressProductsHeading.isDisplayed();
    }

    /** Click Men category link */
    public void clickMenCategory() {
        menCategoryLink.click();
    }

    /** Click T-Shirts sub-category link */
    public void clickTShirtsSubCategory() {
        tShirtsSubCategoryLink.click();
    }

    /** Verify Men - TShirts Products heading is displayed */
    public boolean isMenTshirtsProductsHeadingDisplayed() {
        return menTshirtsProductsHeading.isDisplayed();
    }
    
 // Brands methods
    /** Checks if Brands heading is displayed after scrolling into view */
    public boolean isBrandsHeadingDisplayed() {
        scrollIntoView(brandsHeading);              // Scroll to the element using JS
        return brandsHeading.isDisplayed();
    }
    
    /** Get list of brands with counts from sidebar */
    public List<String> getAllBrandsWithCountsFromSidebar() {
        List<String> brandsWithCounts = new ArrayList<>();
        for (WebElement brand : totalNumberOfBrands) {
            String text = brand.getText().trim().replaceAll("^\\(\\d+\\)\\s*", "");
            brandsWithCounts.add(text);
        }
        return brandsWithCounts;
    }

    /** Clicks on a brand dynamically by its name 
        (ignores case, removes product count from text, and scrolls into view) */
    public void clickOnBrand(String brandName) {
        boolean found = false;

        for (WebElement brand : totalNumberOfBrands) {
         // Remove any count in parentheses and trim
            String currentBrand = brand.getText().replaceAll("\\(.*?\\)", "").trim();

            if (currentBrand.equalsIgnoreCase(brandName)) {
                scrollIntoView(brand);
                brand.click();
                ExtentManager.getTest().pass("Clicked on brand: <b>" + brandName + "</b>");
                found = true;
                break;                // Exit loop after clicking
            }
        }

        if (!found) {
            ExtentManager.getTest().fail("Brand not found: <b>" + brandName + "</b>");
         // Print available brands for debugging
            for (WebElement brand : totalNumberOfBrands) {
                System.out.println("Available brand: " + brand.getText());
            }
            Assert.fail("Brand not found: " + brandName);
        }
    }

    /** Returns the heading text of the selected Brand's product page, Example: "Brand - Polo Products", "Brand - H&M Products" */
    public String getBrandPageHeadingText() {
        scrollIntoView(brandPageHeading);
        return brandPageHeading.getText().trim();
    }
    
    /** Get total count of matched Brand products count */
    public int getMatchedProductsCount() {
        return matchedProducts.size();
    }
    
 // Recommended Products methods
    /** Scrolls to Recommended Items heading and checks visibility */
    public boolean isRecommendedItemsHeadingDisplayed() {
        scrollIntoView(recommendedItemsHeading);
        return recommendedItemsHeading.isDisplayed();
    }

    /** Clicks on a recommended product's 'Add to Cart' button dynamically by index (1=first, 2=second, 3=third, etc.) */
    public void clickOnRecommendedProductAddToCart(int index) {
        String dynamicXpath = "//div[@class='item active']//div[" + index + "]"+"//div[1]//div[1]//div[1]//a[1]";
        WebElement productAddToCartBtn = driver.findElement(By.xpath(dynamicXpath));
        scrollIntoView(productAddToCartBtn);
        productAddToCartBtn.click();
    }

    /** Verifies if Shopping Cart page is displayed */
    public boolean isShoppingCartPageDisplayed() {
        scrollIntoView(shoppingCartPage);
        return shoppingCartPage.isDisplayed();
    }
    
    /** Returns Delivery Address details as a List of Strings */
    public List<String> getDeliveryAddressDetails() {
        return Arrays.asList(
            deliveryName.getText().trim(),
            deliveryCompany.getText().trim(),
            deliveryAddressOne.getText().trim(),
            deliveryAddressTwo.getText().trim(),
            deliveryCityStateZip.getText().trim(),
            deliveryCountry.getText().trim(),
            deliveryMobile.getText().trim()
        );
    }

    /** Returns Billing Address details as a List of Strings */
    public List<String> getBillingAddressDetails() {
        return Arrays.asList(
            billingName.getText().trim(),
            billingCompany.getText().trim(),
            billingAddressOne.getText().trim(),
            billingAddressTwo.getText().trim(),
            billingCityStateZip.getText().trim(),
            billingCountry.getText().trim(),
            billingMobile.getText().trim()
        );
    }
    
 // Page Scroll Up Arrow & Logo methods
    /** Scrolls the page to the bottom using JavaScriptExecutor */
    public void scrollPageToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
    
    /** Click on Scroll Up Arrow button */
    public void clickScrollUpArrow() {
        scrollIntoView(scrollUpArrow);
        scrollUpArrow.click();
    }

    /** Verify footer is visible */
    public boolean isFooterVisible() {
        scrollIntoView(footerSection);
        return footerSection.isDisplayed();
    }

    /** Verify header logo is visible */
    public boolean isHeaderLogoVisible() {
        return headerLogo.isDisplayed();
    }
    
    /** Scrolls the page to the top using JavaScriptExecutor */
    public void scrollPageToUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    }
    
    /** Logs the E-Commerce Logo as an embedded image in Extent Report */
    public void logECommerceLogo() {
     // Fetch the logo image source
        String logoSrc = headerLogo.getAttribute("src");

     // If logoSrc is relative, prepend base URL
        if (!logoSrc.startsWith("http")) {
            logoSrc = driver.getCurrentUrl().replaceAll("/$", "") + "/" + logoSrc.replaceFirst("^/", "");
        }

     // Log the logo in Extent Report
        ExtentManager.getTest().pass(
            "E-Commerce Logo is displayed below:<br><img src='" + logoSrc + "' width='140' height='120'>"
        );
    }

    
}








/*
  Alert alert = driver.switchTo().alert();
alert.accept();  // clicks OK
// OR
alert.dismiss(); // clicks Cancel
*/
