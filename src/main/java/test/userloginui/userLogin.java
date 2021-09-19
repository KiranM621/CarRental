package test.userloginui;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginSignupPage;
import utilities.PropertyReader;

public class userLogin {
	
	WebDriver driver;
	LoginSignupPage objLoginSignupPage ;
	
	JavascriptExecutor js;
	String driverPath = null;
	String home_URL;
  
 @BeforeMethod
  
  public void beforeMethod() throws InterruptedException, IOException {
		
	 driverPath = PropertyReader.getProperty("Chrome_Driver_Path");
	// email=PropertyReader.getProperty("useremail");
	// password=PropertyReader.getProperty("password");
	 home_URL=PropertyReader.getProperty("home_URL");
	 System.setProperty("webdriver.chrome.driver", driverPath);
	 driver = new ChromeDriver();
	 js = (JavascriptExecutor) driver;
  }
 
 @Test
  public void loginButton() throws InterruptedException {
		driver.get(home_URL);//getURL
		Thread.sleep(2000);
		objLoginSignupPage =new LoginSignupPage(driver);
		
		//click on login/signup btn
		objLoginSignupPage.loginRegistrationbtn();
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//enter email
		objLoginSignupPage.enterUserName();
		
		//enter password
		objLoginSignupPage.enterPasswrod();
	   Thread.sleep(2000);
	   
	   // click on login button
	   objLoginSignupPage.login();
		
	   
		Thread.sleep(2000);
		
  }

  @AfterMethod
  public void afterMethod() {
	 
		 driver.quit();
	  }
  
}
