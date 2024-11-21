package co.bholenath.nayaproject.shankar;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginPageTest {
	private WebDriver driver;

	@BeforeClass
	public void setUp() {
		// Webdriver setup...
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@DataProvider(name= "loginData")
	public Object[][] getData(){
		return new Object[][] {{"standard_user", "secret_sauce"},
			{"username", "password"},
			{"",""}
		};
		
	}

	@Test(dataProvider = "loginData")
	public void firstTest(String username, String password) throws InterruptedException {
		loginPage fp = new loginPage(driver);
		fp.userName(username);
		fp.password(password);
		fp.loginbutton();
		
		// verify login successfull
		String logintext = fp.getTextdata();
		System.out.println(logintext);
//		try {
//		Assert.assertEquals("Products", logintext);
//		System.out.println("pass: the login is successfully done ");}
//		catch (AssertionError e){
//			System.out.println("Fail: The login test is incorrect");
//		}
		
		if (logintext.equals("Products")) {
		    System.out.println("Pass: Successfully logged in.");
		} else {
		    System.out.println("Fail: Login not done. Incorrect username or password.");
		}
		
		
		Thread.sleep(5000);
		
	}
	
	
	
	

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
