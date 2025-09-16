package com.ecommerce.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductsPage {

    WebDriver driver;

 // Constructor
    public ProductsPage(WebDriver driver) {
    	
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /** 🔗 "Products" link */
    @FindBy(xpath = "//a[@href='/products']")
    private WebElement productsLink;

    /** 📝 "All Products" heading */
    @FindBy(xpath = "//h2[normalize-space()='All Products']")
    private WebElement allProductsHeading;

    /** 📦 List of products */
    @FindBy(xpath = "//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1]")
    private List<WebElement> listOfProducts;

    /** 🛒 Dynamic "View Product" buttons */
    @FindBy(xpath = "(//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1])")
    private List<WebElement> viewProductButtons;

    /** 🏷️ Product name */
    @FindBy(xpath = "//div[@class='product-information']//h2")
    private WebElement productName;

    /** 🗂️ Product category */
    @FindBy(xpath = "//div[@class='product-details']//p[contains(text(),'Category')]")
    private WebElement productCategory;

    /** 💲 Product price */
    @FindBy(xpath = "//span[contains(text(),'Rs.')]")
    private WebElement productPrice;

    /** 📦 Product availability */
    @FindBy(xpath = "//div[@class='product-details']//p[2]")
    private WebElement productAvailability;

    /** ✅ Product condition */
    @FindBy(xpath = "//body//section//p[3]")
    private WebElement productCondition;

    /** 🏭 Product brand */
    @FindBy(xpath = "//body//section//p[4]")
    private WebElement productBrand;
    
 // Search elements
    /** 🔎 Search input box */
    @FindBy(xpath = "//input[@id='search_product']")
    private WebElement searchInputBox;

    /** 🔍 Search button */
    @FindBy(xpath = "//i[@class='fa fa-search']")
    private WebElement searchButton;

    /** 📑 "Searched Products" heading */
    @FindBy(xpath = "//h2[normalize-space()='Searched Products']")
    private WebElement searchedProductsHeading;

    /** 📦 Matched products titles */
    @FindBy(xpath = "//div[@class='productinfo text-center']//p")
    private List<WebElement> matchedProducts;
    
    /** Locator for "Write Your Review" link */
    @FindBy(xpath = "//a[normalize-space()='Write Your Review']")
    private WebElement writeYourReviewTab;

    /** Locator for Product Quantity input box */
    @FindBy(xpath = "//input[@id='quantity']")
    private WebElement productQuantityInput;

    /** Locator for "Add to Cart" button */
    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    private WebElement addToCartButton;
    
    /** View Cart button */
    @FindBy(xpath = "//u[normalize-space()='View Cart']")
    private WebElement viewCartButton;
    
 // Product Review web elements
    /** Textbox to enter your name for giving review */
    @FindBy(xpath = "//input[@id='name']")
    private WebElement yourNameForGivingReview;

    /** Textbox to enter your email address for review */
    @FindBy(xpath = "//input[@id='email']")  
    private WebElement emailAddressForReview;

    /** Textarea to enter product review comment */
    @FindBy(xpath = "//textarea[@id='review']")    
    private WebElement addReviewHereTextAreaBox;
    
    /** Button to submit the product review */
    @FindBy(xpath = "//button[@id='button-review']") 
    private WebElement reviewSubmitButton;
    
    /** Message displayed after successfully submitting a product review */
    @FindBy(xpath = "//span[normalize-space()='Thank you for your review.']") 
    private WebElement reviewSuccessMessage;

    
    

 // ================= Action methods =================

    /** Click on Products link */
    public void clickProducts() { 
    	productsLink.click(); 
    }

    /** Verify All Products heading displayed */
    public boolean isAllProductsHeadingDisplayed() {
    	return allProductsHeading.isDisplayed(); 
    }

    /** Get total products count */
    public int getProductsCount() { 
    	return listOfProducts.size(); 
    }

    /** Click on product by index (1-based) */
    public void clickProductByIndex(int index) {
        int totalProducts = viewProductButtons.size();

        if (index < 1 || index > totalProducts) {
            throw new IllegalArgumentException(
                "Invalid product index: " + index + ", Please choose between 1 to " + totalProducts);
        }
    	
        WebElement product = viewProductButtons.get(index - 1);

     // Scroll into view first
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);

     // Then click
        product.click();
    }

    /** Get product name text */
    public String getProductName() { 
    	return productName.getText(); 
    }

    /** Get product category text */
    public String getProductCategory() { 
    	return productCategory.getText(); 
    }

    /** Get product price text */
    public String getProductPrice() { 
    	return productPrice.getText().trim(); 
    }

    /** Get product availability text */
    public String getProductAvailability() { 
    	return productAvailability.getText(); 
    }

    /** Get product condition text */
    public String getProductCondition() { 
    	return productCondition.getText(); 
    }

    /** Get product brand text */
    public String getProductBrand() { 
    	return productBrand.getText(); 
    }
    
 // Search methods
    /** Enter text in search box */
    public void enterSearchText(String text) {
        searchInputBox.sendKeys(text);
    }

    /** Click on search button */
    public void clickSearchButton() {
        searchButton.click();
    }

    /** Check if 'Searched Products' heading is displayed */
    public boolean isSearchedProductsHeadingDisplayed() {
        return searchedProductsHeading.isDisplayed();
    }

    /** Get total count of matched products */
    public int getMatchedProductsCount() {
        return matchedProducts.size();
    }

    /** Get all matched product names */
    public List<String> getMatchedProductsText() {
        return matchedProducts.stream()
                              .map(e -> e.getText().trim())
                              .filter(name -> !name.isEmpty())         // remove blanks
                              .toList();
    }
    
    /** Check if "Write Your Review" link is displayed on Product Page */
    public boolean isWriteYourReviewDisplayed() {
        return writeYourReviewTab.isDisplayed();
    }

    /** Clear existing product quantity and enter a new quantity */
    public void setProductQuantity(String quantity) {
        productQuantityInput.clear();                                  // remove old value
        productQuantityInput.sendKeys(quantity);                       // enter new value
    }

    /** Click on "Add to Cart" button */
    public void clickAddToCart() {
        addToCartButton.click();
    }
    
    /** Method to click View Cart button */
    public void clickViewCart() {
        viewCartButton.click();
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
    
    /** Method to click product remove icon dynamically by index
     * Uses JavaScriptExecutor for reliable clicking
     * @param productIndex product number (example: 1, 2, 3, ...) */
    public void clickProductRemoveIcon(int productIndex) {
        String dynamicXpath = "//tr[@id='product-" + productIndex + "']//i[@class='fa fa-times']";
        WebElement removeIcon = driver.findElement(By.xpath(dynamicXpath));

        // Scroll element into view before clicking
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", removeIcon);

        // Perform click using JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", removeIcon);
    }
    
 // Action Methods for Product Review Section
    /** Enters the given name into 'Your Name' textbox for review */
    public void enterNameForReview(String name) {
        yourNameForGivingReview.clear();
        yourNameForGivingReview.sendKeys(name);
    }

    /** Enters the given email into 'Email Address' textbox for review */
    public void enterEmailForReview(String email) {
        emailAddressForReview.clear();
        emailAddressForReview.sendKeys(email);
    }

    /** Enters the product review comment into 'Add Review' textarea box */
    public void enterProductReview(String review) {
        addReviewHereTextAreaBox.clear();
        addReviewHereTextAreaBox.sendKeys(review);
    }
    
    /** Clicks on the 'Submit Review' button */
    public void clickSubmitReviewButton() {
        reviewSubmitButton.click();
    }
    
    /** Checks if the review success message is displayed
        @return true if the message is visible, false otherwise */
    public boolean isReviewSuccessMessageDisplayed() {
        return reviewSuccessMessage.isDisplayed();
    }
    
 
    

    
}

