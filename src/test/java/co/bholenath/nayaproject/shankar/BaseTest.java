package co.bholenath.nayaproject.shankar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;  // Protected so it can be accessed in subclasses

    @BeforeMethod
    public void setUp() {
        // Initialize WebDriver and open the browser
        driver = new ChromeDriver();
        driver.get("https://example.com/login");  // Navigate to the login page
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser after the test
        if (driver != null) {
            driver.quit();
        }
    }
}

