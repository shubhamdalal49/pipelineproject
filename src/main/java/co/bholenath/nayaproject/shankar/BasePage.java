package co.bholenath.nayaproject.shankar;

//package com.yourcompany.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    
    protected WebDriver driver;
    private WebDriverWait wait;

    // Constructor to initialize the driver and wait objects
    public BasePage() {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // You can adjust the wait time as needed
    }

    // Method to wait until an element is visible
    protected void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Method to click on an element
    protected void clickElement(WebElement element) {
        waitForElementToBeVisible(element);  // Ensure the element is visible before clicking
        element.click();
    }

    // Method to enter text into an input field
    protected void enterText(WebElement element, String text) {
        waitForElementToBeVisible(element);  // Ensure the element is visible before entering text
        element.clear();
        element.sendKeys(text);
    }

    // Method to get the current page title
    public String getPageTitle() {
        return driver.getTitle();
    }
}
