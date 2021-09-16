package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSignupPage {

	WebDriver driver;

	By login_Signup=By.xpath("/html/body/header/div/div/div/div[2]/div/div[4]/a");
	By user_Name = By.xpath("//*[@id=\"loginform\"]/div/div/div[2]/div/div/div/form/div[1]/input");
	By password = By.xpath("//*[@id=\"loginform\"]/div/div/div[2]/div/div/div/form/div[2]/input");
	By login_Button = By.xpath("//*[@id=\"loginform\"]/div/div/div[2]/div/div/div/form/div[4]/input");
	By sign_Up=By.xpath("//*[@id=\"loginform\"]/div/div/div[3]/p[1]/a");
	By sign_Up_Fullname=By.name("fullname");
	By sign_Up_Mob=By.name("mobileno");
	By sign_Up_Email=By.id("emailid");
	
	
	public LoginSignupPage (WebDriver driver) {
		this.driver = driver;
		}
	
	
	public void clickOnLoginSignup() {
		driver.findElement(login_Signup).click();
	}
	
	
	public void enterUserName(String arg1) {
	driver.findElement(user_Name).sendKeys(arg1);
	}
	
	
	public void enterPasswrod(String arg1) {
	driver.findElement(password).sendKeys(arg1);
	}
	
	public void login() {
		driver.findElement(login_Button).click();
		
	}
	
	public void clickSignup() {
		driver.findElement(sign_Up).click();
		
	}
	
	
	public void enterFullname(String arg1) {
		driver.findElement(sign_Up_Fullname).sendKeys(arg1);
		}
	
	
	public void enterMob(String arg1) {
		driver.findElement(sign_Up_Mob).sendKeys(arg1);
		}
	
	
	public void enterEmailId(String arg1) {
		driver.findElement(sign_Up_Email).sendKeys(arg1);
		}


}
