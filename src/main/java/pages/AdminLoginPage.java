package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLoginPage {
	
	WebDriver driver = null;
	
	By admin_User = By.xpath("(//input[@name = 'username'])");
	By admin_Password = By.xpath("(//input[@name = 'password'])");
	By admin_Login = By.xpath("/html/body/div/div/div/div/div/div/div/form/button");
	
	
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
	
	

}
