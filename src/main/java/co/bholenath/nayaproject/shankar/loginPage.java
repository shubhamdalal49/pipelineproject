package co.bholenath.nayaproject.shankar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import java.time.Duration;

public class loginPage extends BasePage{
	private WebDriver driver;
	private WebDriverWait wait;
	
	//locators...

	private By username = By.id("user-name");
	private By password = By.id("password");
	private By loginbtn = By.id("login-button");
	
	//constructor to initialize the driver and waits....
	
	public loginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	
	// Wait for an element to be visible
    private WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    //Methods....
    
    public void userName(String userInputNumber) {
    	WebElement userName = waitForElementToBeVisible(username);
    	BasePage bp = new BasePage();
    	bp.enterText(userName, userInputNumber);
    	
//    	userName.clear();
//    	userName.sendKeys(userInputNumber);
    }
    
   public void password(String userInputText) {
	   WebElement pwd = waitForElementToBeVisible(password);
//	   pwd.clear();
//	   pwd.sendKeys(userInputText);
	   BasePage bp = new BasePage();
	   bp.enterText(pwd, userInputText);
   }
   
//   public void inputPassword(String userInputPassword) {
//	   WebElement inpPassword = waitForElementToBeVisible(inputPassword);
//	   inpPassword.clear();
//	   inpPassword.sendKeys(userInputPassword);
//	   
//   }
//   
//   public void inputDate(String userInputDate) {
//	   WebElement inpPassword = waitForElementToBeVisible(inputDate);
//	   inpPassword.clear();
//	   inpPassword.sendKeys(userInputDate);
//	   
//   }
   
   public void loginbutton() {
	   WebElement submit = waitForElementToBeVisible(loginbtn);
	   submit.click();
   }
   
   public String getTextdata() {
	   WebElement oN = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
	   return oN.getText();
//	   return ((WebElement) outputNumber).getText();
	   
   }
}
