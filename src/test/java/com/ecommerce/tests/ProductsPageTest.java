package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.ProductsPage;
import com.ecommerce.utilities.ExtentManager;


public class ProductsPageTest extends BaseTest {
	
	@Test
    public void verifyProductDetails() {
		
        ProductsPage productsPage = new ProductsPage(driver);

     // Step 1: Navigate to Products page
        productsPage.clickProducts();
        Assert.assertTrue(productsPage.isAllProductsHeadingDisplayed(), "All Products heading not displayed");

     // Step 2: Get total product count (form All Products)
        int totalProducts = productsPage.getProductsCount();
        ExtentManager.getTest().info("Total Products available: " + totalProducts);

     // Step 3: Click on the 1st product (you can parameterize this index)
        productsPage.clickProductByIndex(3);

     // Step 4: Validate product details
        String name = productsPage.getProductName();
        String category = productsPage.getProductCategory();
        String price = productsPage.getProductPrice();
        String availability = productsPage.getProductAvailability();
        String condition = productsPage.getProductCondition();
        String brand = productsPage.getProductBrand();
        
        ExtentManager.getTest().info("Product Name: " + name);
        ExtentManager.getTest().info(category);
        ExtentManager.getTest().info("Price: " + price);
        ExtentManager.getTest().info(availability);
        ExtentManager.getTest().info(condition);
        ExtentManager.getTest().info(brand);

     // Step 5: Assertions (basic checks, can expand as per requirements)
        Assert.assertNotNull(name, "Product name is null");
        Assert.assertTrue(category.contains("Category"), "Category format mismatch");
        Assert.assertTrue(price.contains("Rs."), "Price not displayed correctly");
        Assert.assertTrue(availability.toLowerCase().contains("availability"), "Availability not shown");
        Assert.assertTrue(condition.toLowerCase().contains("condition"), "Condition not shown");
        Assert.assertTrue(brand.toLowerCase().contains("brand"), "Brand not shown");

     // ✅ Final Extent log
        ExtentManager.getTest().pass("Verified <b>Product Details</b> successfully for product: <b>" + name+"</b>");
    }

	
}
