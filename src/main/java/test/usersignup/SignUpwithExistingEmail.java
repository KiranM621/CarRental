package test.usersignup;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginSignupPage;
import utilities.PropertyReader;

public class SignUpwithExistingEmail {
	WebDriver driver;
	LoginSignupPage objLoginSignupPage ;	
	 JavascriptExecutor js;
	String driverPath = null;
	String home_URL,user_Email,user_Password,new_User_Name,new_User_Number;
	
	
@BeforeMethod
	 public void beforeMethod() throws InterruptedException, IOException {
			
				driverPath = PropertyReader.getProperty("Chrome_Driver_Path");
				user_Email=PropertyReader.getProperty("user_Email");
				home_URL=PropertyReader.getProperty("home_URL");
				new_User_Name=PropertyReader.getProperty("new_User_Name");
				new_User_Number=PropertyReader.getProperty("new_User_Number");
			   	System.setProperty("webdriver.chrome.driver", driverPath);
				driver = new ChromeDriver();
				 js = (JavascriptExecutor) driver;
				 
		  }	
	
  @Test
  public void signupTest() throws InterruptedException {
	 
	  	driver.get(home_URL);//getURL
		
		
		Thread.sleep(5000);
		objLoginSignupPage =new LoginSignupPage(driver);
		Thread.sleep(2000);
		//click on login/signup btn
		objLoginSignupPage.clickOnLoginSignup();
		
		//click on sign-up
		driver.manage().window().maximize();

		objLoginSignupPage.clickSignup();
		Thread.sleep(5000);
		
		//enter name, mobile no, email
		objLoginSignupPage.enterFullname(new_User_Name);
		objLoginSignupPage.enterMob(new_User_Number);
		objLoginSignupPage.enterEmailId(user_Email);
		 
		driver.findElement(By.xpath("//*[@id=\"signupform\"]/div/div/div[2]/div/div/div/form/div[4]/input")).sendKeys("asdsdd");
		  
		  
		String alertmsg=driver.findElement(By.xpath("//*[@id=\"user-availability-status\"]/span")).getText();
		assertEquals("Email already exists .",alertmsg);
		
		  
  }
  
  @AfterTest
  public void aftertest() {
	  driver.quit();
  }
}
