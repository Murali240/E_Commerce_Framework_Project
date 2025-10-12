package com.ecommerce.tests;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.base.BaseTest;
import com.ecommerce.utilities.ExtentManager;

/** Test class to verify that all links on the Automation Exercise home page
 * are valid and do not return HTTP response codes >= 400. */
public class BrokenLinksTest extends BaseTest {

    @Test
    public void verifyAllLinksAreHealthy() {
     // Get all <a> elements on the page
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        ExtentManager.getTest().info("Total links found: " + allLinks.size());

     // Counters for summary
        int validCount = 0;
        int invalidCount = 0;
        int skippedCount = 0;

        for (WebElement link : allLinks) {
            String url = link.getAttribute("href");

         // Skip empty or null href values
            if (url == null || url.isEmpty()) {
                skippedCount++;
                ExtentManager.getTest().info("Skipping empty or null href");
                continue;
            }

         // Skip non-HTTP links like JavaScript and mailto
            if (url.startsWith("javascript") || url.startsWith("mailto:")) {
                skippedCount++;
                ExtentManager.getTest().info("Skipping non-http link: " + url);
                continue;
            }

            try {
             // Open connection to check the link status
                HttpURLConnection connection = (HttpURLConnection) (new URL(url).openConnection());
                connection.setRequestMethod("HEAD"); // faster than GET
                connection.connect();
                int responseCode = connection.getResponseCode();

             // Log status in Extent Report
                ExtentManager.getTest().info(url + " --> " + responseCode);

                if (responseCode >= 400) {
                    invalidCount++;
                    ExtentManager.getTest().fail("Broken link: " + url + " returned " + responseCode);
                } else {
                    validCount++;
                    ExtentManager.getTest().pass("Valid link: " + url);
                }

            } catch (Exception e) {
                invalidCount++;
                ExtentManager.getTest().fail("Exception while checking link: " + url + " | " + e.getMessage());
            }
        }

     // Final summary log
        ExtentManager.getTest().info("========== Summary ==========");
        ExtentManager.getTest().info("Total links found: " + allLinks.size());
        ExtentManager.getTest().info("Valid links: " + validCount);
        ExtentManager.getTest().info("Invalid links: " + invalidCount);
        ExtentManager.getTest().info("Skipped links: " + skippedCount);

     // Final pass/fail marking
        if (invalidCount == 0) {
            ExtentManager.getTest().pass("All links are valid!");
        } else {
            ExtentManager.getTest().fail(invalidCount + " invalid link(s) found.");
            Assert.fail(invalidCount + " invalid link(s) found.");
        }
    }


}