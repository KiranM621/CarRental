package test.usersignup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginSignupPage;
import utilities.PropertyReader;

public class SignUp {

	String base_Url = PropertyReader.getProperty("home_URL");
	String path = PropertyReader.getProperty("Chrome_Driver_Path");
	WebDriver driver = null;
	String user_Name = PropertyReader.getProperty("new_User_Name");
	String user_Email = PropertyReader.getProperty("new_User_Email");
	String user_Number = PropertyReader.getProperty("new_User_Number");
	String user_Password = PropertyReader.getProperty("new_User_Password");

	LoginSignupPage loginSignupPageObject= null;
	
	@BeforeTest
	
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver",path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		loginSignupPageObject = new LoginSignupPage(driver);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		WebDriverWait wait = new WebDriverWait(driver,30);

		
		driver.get(base_Url);
		

	}
	
	@Test(priority=1)
	
	public void signupTestValid() { 
		WebDriverWait wait = new WebDriverWait(driver,30);
		String expected_Message = PropertyReader.getProperty("registration_Success");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		
		//Referencing From LoginSignupPage
		loginSignupPageObject.clickOnLoginSignup();

		loginSignupPageObject.clickSignup();
		
		
		
		loginSignupPageObject.setUserName(user_Name);
		loginSignupPageObject.setUserNumber(user_Number);
		loginSignupPageObject.setUserEmail(user_Email);
		loginSignupPageObject.setPasswrod(user_Password);
		loginSignupPageObject.setConfirmPassword(user_Password);
		
		
		
		loginSignupPageObject.clickOnSubmit();
		


		String actual_Message =driver.switchTo().alert().getText() ;
		
		driver.switchTo().alert().accept();
		
		Assert.assertEquals(actual_Message,expected_Message);
		
		
	}
	
	@Test(priority=2)
	
	public void signupTestInvalid() { 
		WebDriverWait wait = new WebDriverWait(driver,30);
		String expected_Message = PropertyReader.getProperty("email_Present");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		
		//Referencing From LoginSignupPages
		loginSignupPageObject.clickOnLoginSignup();
		loginSignupPageObject.clickSignup();
	
		loginSignupPageObject.setUserName(user_Name);
		loginSignupPageObject.setUserNumber(user_Number);
		loginSignupPageObject.setUserEmail(user_Email);
		loginSignupPageObject.setPasswrod(user_Password);
		loginSignupPageObject.setConfirmPassword(user_Password);

		
		
		String actual_Message = driver.findElement(By.xpath("//*[@id=\"user-availability-status\"]/span")).getText();
			
		Assert.assertEquals(actual_Message,expected_Message);
		
		
	}
	
	
	@AfterTest
	
	public void AfterTest() { 
		
		WebDriverWait wait = new WebDriverWait(driver,30);

		driver.quit();
		
	}
}
