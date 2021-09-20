package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AdminLoginPage {
	
	WebDriver driver = null;
	
	//username textfield
	By admin_User = By.xpath("(//input[@name = 'username'])");
	//password field
	By admin_Password = By.xpath("(//input[@name = 'password'])");
	//Login Button
	By admin_Login = By.xpath("/html/body/div/div/div/div/div/div/div/form/button");
	//Admin button
	By loginAdmin1=By.xpath("//a[@href='admin/']");
	//login page heading
	By pageHeading=By.xpath("//h1[@class='text-center text-bold text-light mt-4x']");
	
	public AdminLoginPage(WebDriver driver) { 
		
		this.driver = driver;
		
	}
	
	
	public void setUserName(String adminName) { 
		
		driver.findElement(admin_User).sendKeys(adminName);
		
	}
	
	
	
	public void setPassword(String password) { 
		
		driver.findElement(admin_Password).sendKeys(password);

		
	}
	
	public void clickLogin() { 
		
		driver.findElement(admin_Login).click();

		
	}
	
	public void loginAdmin(String adminUser, String adminPass) {
		WebElement loginAdmin=driver.findElement(loginAdmin1);
		if(loginAdmin.isDisplayed() && loginAdmin.isEnabled()) {
			System.out.println("Admin login option is enabled and visible");
		}else {
			System.out.println("Admin login option is not enabled and visible");
		}
		loginAdmin.click();
		String heading=driver.findElement(pageHeading).getText();
		String expectedHead="Sign in";
	    Assert.assertEquals(heading, expectedHead);
		WebElement userName=driver.findElement(admin_User);
		WebElement password=driver.findElement(admin_Password);
		if(userName.isDisplayed() && password.isDisplayed() && userName.isEnabled() && password.isEnabled()) {
			System.out.println("Textbox of username and password is visible and enabled");
		}else {
			System.out.println("Textbox of username and password is not visible and enabled");
		}
		WebElement login=driver.findElement(admin_Login);
		userName.sendKeys(adminUser);
		password.sendKeys(adminPass);
		login.click();
	}
	
	
	
	
	

}
