package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSignupPage {

	WebDriver driver;

	// Login/Register Button
	By login_Signup=By.xpath("/html/body/header/div/div/div/div[2]/div/div[4]/a");
	
	// Email_Id on login form
	By user_Name = By.xpath("//*[@id=\"loginform\"]/div/div/div[2]/div/div/div/form/div[1]/input");
	
	// password filed on signup page
	By signup_Password = By.xpath("//*[@id=\"signupform\"]/div/div/div[2]/div/div/div/form/div[4]/input");
	// confirmPassword filed on confirm Password
	By signup_Confirm_Password = By.xpath("(//input[@name='confirmpassword'])");
	
	// login button on login page
	By login_Button = By.xpath("//*[@id=\"loginform\"]/div/div/div[2]/div/div/div/form/div[4]/input");
	
	// signup link login page
	By sign_Up= By.linkText("Signup Here");
	// fullname field on signup page
	By sign_Up_Fullname=By.name("fullname");
	// contact number field on signup page
	By sign_Up_Mob=By.name("mobileno");
	// email field on signup ppage
	By sign_Up_Email=By.id("emailid");
	// signup button on signup page
	By submit = By.xpath("//*[@id=\"submit\"]");

	
	// forgot password link on login page.
	By forgot_Password = By.linkText("Forgot Password ?");
	
	
	
	public LoginSignupPage (WebDriver driver) {
		this.driver = driver;
		}
	
	
	public void clickOnLoginSignup() {
		driver.findElement(login_Signup).click();
	}
	
	
	
	
	public void setSignupPasswrod(String new_Password) {
	driver.findElement(signup_Password).sendKeys(new_Password);
	}
	
	public void setSignupConfirmPassword(String password) {
		driver.findElement(signup_Confirm_Password).sendKeys(password);
	}
	
	public void clickOnLogin() {
		driver.findElement(login_Button).click();
		
	}
	
	public void clickOnSignup() {
		driver.findElement(sign_Up).click();
		
	}
	
	
	public void setSignupUserName(String name) {
		driver.findElement(sign_Up_Fullname).sendKeys(name);
		}
	
	
	public void setSignupUserNumber(String number) {
		driver.findElement(sign_Up_Mob).sendKeys(number);
		}
	
	
	public void setSignupUserEmail(String email) {
		driver.findElement(sign_Up_Email).sendKeys(email);
		}
	
	public void clickOnForgotPassword() { 
		
		driver.findElement(forgot_Password).click();
		
	}
	
	public void clickOnSignup_Button() { 
		driver.findElement(submit).click();

	}


}
