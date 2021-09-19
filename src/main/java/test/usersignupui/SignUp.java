/**
 * 
 */
package test.usersignupui;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import pages.LoginSignupPage;
import pages.ForgotPasswordPage;
import utilities.PropertyReader;

/**
 * @author apeksha_giri
 *
 */
public class SignUp {
	WebDriver driver;
	LoginSignupPage objLoginSignupPage ;
	
	JavascriptExecutor js;
	String driverPath = null;
	String home_URL,Name,mobNo,mail;//passWorrd,confPass;
  
 
  @BeforeMethod
  
  public void beforeMethod() throws InterruptedException, IOException {
		
	 driverPath = PropertyReader.getProperty("Chrome_Driver_Path");
	 System.setProperty("webdriver.chrome.driver", driverPath);
	 driver = new ChromeDriver();
	 js = (JavascriptExecutor) driver;
  }
	 @Test
	  public void signUp() throws InterruptedException {
			driver.get(home_URL);//getURL
			Thread.sleep(2000);
			objLoginSignupPage=new LoginSignupPage(driver);
			
			//click on login/signup btn
			objLoginSignupPage.clickOnLoginSignup();
			
			driver.manage().window().maximize();
			Thread.sleep(2000);
			
			//signuphere
			objLoginSignupPage.signUpForNew();
			Thread.sleep(2000);

			//Enter FullName
			objLoginSignupPage.fullname();
			
			//Enter MobileNo
			objLoginSignupPage. mobileNumber();
			
			//Enter EmailID
			objLoginSignupPage.emailid();
			
			//Enter Password
			objLoginSignupPage.passWord();
			
			//Enter ConfirmPassword
			objLoginSignupPage.confirmPassword();
			
			//Click On Signup
			objLoginSignupPage.signup();
			
			Thread.sleep(2000);

			

	 } 
}
