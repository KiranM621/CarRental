package test.usersignup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.ForgotPasswordPage;
import pages.LoginSignupPage;
import utilities.PropertyReader;

public class ForgotPassword {
	
	String base_Url = PropertyReader.getProperty("home_URL");
	String path = PropertyReader.getProperty("Chrome_Driver_Path");
	String user_Email = PropertyReader.getProperty("new_User_Email");
	String user_Number = PropertyReader.getProperty("new_User_Number");
	String password = PropertyReader.getProperty("new_User_Number");
	String user_New_Password = PropertyReader.getProperty("new_Password");
	
	ForgotPasswordPage forgotPasswordPageObject = null;
	LoginSignupPage loginSignupPageObject;
	WebDriver driver = null;

	
	@BeforeTest(description = "Creation of objects and settingup properties before test")
	public void beforeTest() { 
		System.setProperty("webdriver.chrome.driver",path);

		driver = new ChromeDriver();
		forgotPasswordPageObject = new ForgotPasswordPage(driver);
		loginSignupPageObject = new LoginSignupPage(driver);	
	
	}
	
	@BeforeMethod(description = "Loads basurl before every test")
	public void beforeMethod() { 
		
		driver.get(base_Url);
		driver.manage().window().maximize();
	}

	@Test(priority=1,description = "Using valid user data")
	public void retrievePasswordWithValidData() { 
		
		String expected_Message = PropertyReader.getProperty("password_Change_Success_Message");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		//Referencing from LoginSignupPage
		loginSignupPageObject.clickOnLoginSignup();
		loginSignupPageObject.clickOnForgotPassword();
		
		//Referencing from ForgotPasswordPage
		forgotPasswordPageObject.setUserEmail(user_Email);
		forgotPasswordPageObject.setUserNumber(user_Number);
		forgotPasswordPageObject.setNewPassword(user_New_Password);
		forgotPasswordPageObject.setConfirmPassword(user_New_Password);
		forgotPasswordPageObject.clickOnReset();

		
	
	
		String actual_Message = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		Assert.assertEquals(actual_Message, expected_Message);
	
	}
	
	@Test(priority=2,description = "Using Invalid user data,new password and confirmpassword don't match")
	public void  retrievePasswordWithInvalidData() { 
		
		String expected_Message = PropertyReader.getProperty("forgot_Password_Error_Message");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Referencing from LoginSignupPage
		loginSignupPageObject.clickOnLoginSignup();
		loginSignupPageObject.clickOnForgotPassword();

		//Referencing from ForgotPasswordPage
		forgotPasswordPageObject.setUserEmail(user_Email);
		forgotPasswordPageObject.setUserNumber(user_Number);
		forgotPasswordPageObject.setNewPassword(user_New_Password);
		forgotPasswordPageObject.setConfirmPassword(password);
		forgotPasswordPageObject.clickOnReset();
		
	
		String actual_Message = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		Assert.assertEquals(actual_Message, expected_Message);
	
	}
	@AfterTest(description="Closing browser")
	public void afterTest() { 
		
		driver.quit();
		
	}
	
	
}
