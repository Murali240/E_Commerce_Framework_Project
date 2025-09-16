package com.ecommerce.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ecommerce.utilities.ExtentManager;


public class DynamicAlertHandler {
	
	private WebDriver driver;
    private WebDriverWait wait;

    public DynamicAlertHandler(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Handles all dynamic alerts if present by clicking either "Save" or "No thanks".
     * It loops through all alerts until none are visible.
     *
     * @param action "Save" or "No thanks" (case-insensitive)
     */
    public void handleDynamicAlerts(String action) {
        try {
            while (true) {
                // Check if popup is visible
                List<WebElement> popups = driver.findElements(
                    By.xpath("//div[contains(.,'Save address?')]")
                );

                if (popups.isEmpty()) {
                    System.out.println("✅ No more dynamic alerts present.");
                    break;
                }

                WebElement popup = wait.until(ExpectedConditions.visibilityOf(popups.get(0)));

                // Find button inside the popup
                WebElement button = popup.findElement(
                    By.xpath(".//button[normalize-space()='" + action + "']")
                );

                button.click();
                System.out.println("✅ Clicked alert button: " + action);

                // Small wait for next alert if any
                Thread.sleep(1000);
            }

        } catch (Exception e) {
            System.out.println("⚠️ Error handling alert: " + e.getMessage());
        }
    }


}
