package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSignupPage {

	WebDriver driver;

	By login_Signup=By.xpath("/html/body/header/div/div/div/div[2]/div/div[4]/a");
	By user_Name = By.xpath("//*[@id=\"loginform\"]/div/div/div[2]/div/div/div/form/div[1]/input");
	By password = By.xpath("//*[@id=\"signupform\"]/div/div/div[2]/div/div/div/form/div[4]/input");
	By confirm_Password = By.xpath("(//input[@name='confirmpassword'])");
	By login_Button = By.xpath("//*[@id=\"loginform\"]/div/div/div[2]/div/div/div/form/div[4]/input");
	By sign_Up= By.linkText("Signup Here");
	By sign_Up_Fullname=By.name("fullname");
	By sign_Up_Mob=By.name("mobileno");
	By sign_Up_Email=By.id("emailid");
	By forgot_Password = By.linkText("Forgot Password ?");
	By submit = By.xpath("//*[@id=\"submit\"]");
	
	
	public LoginSignupPage (WebDriver driver) {
		this.driver = driver;
		}
	
	
	public void clickOnLoginSignup() {
		driver.findElement(login_Signup).click();
	}
	
	
	
	
	public void setPasswrod(String new_Password) {
	driver.findElement(password).sendKeys(new_Password);
	}
	
	public void setConfirmPassword(String password) {
		driver.findElement(confirm_Password).sendKeys(password);
	}
	
	public void clickOnLogin() {
		driver.findElement(login_Button).click();
		
	}
	
	public void clickSignup() {
		driver.findElement(sign_Up).click();
		
	}
	
	
	public void setUserName(String name) {
		driver.findElement(sign_Up_Fullname).sendKeys(name);
		}
	
	
	public void setUserNumber(String number) {
		driver.findElement(sign_Up_Mob).sendKeys(number);
		}
	
	
	public void setUserEmail(String email) {
		driver.findElement(sign_Up_Email).sendKeys(email);
		}
	
	public void clickOnForgotPassword() { 
		
		driver.findElement(forgot_Password).click();
		
	}
	
	public void clickOnSubmit() { 
		driver.findElement(submit).click();

	}


}
