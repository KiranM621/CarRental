package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
	
	WebDriver driver = null;
	
	By user_Email =  By.xpath("//*[@id=\"forgotpassword\"]/div/div/div[2]/div/div/div/form/div[1]/input");
	By user_Number = By.xpath("(//input[@name='mobile'])");
	By user_NewPassword = By.xpath("(//input[@name='newpassword'])");
	By user_ConfirmPassword = By.xpath("//*[@id=\"forgotpassword\"]/div/div/div[2]/div/div/div/form/div[4]/input");
	By reset_Password = By.xpath("//*[@id=\"forgotpassword\"]/div/div/div[2]/div/div/div/form/div[5]/input");
	
	
	public ForgotPasswordPage(WebDriver driver) { 
		
		this.driver = driver;
		
	}
	
	public void setUserEmail(String email) { 
		
		driver.findElement(user_Email).sendKeys(email);
		
	}
	
	public void setUserNumber(String number) { 
		
		driver.findElement(user_Number).sendKeys(number);

		
	}
	
	public void setNewPassword(String password) { 
		
		driver.findElement(user_NewPassword).sendKeys(password);

		
	}
	
	public void setConfirmPassword(String password) { 
		
		driver.findElement(user_ConfirmPassword).sendKeys(password);

		
	}
	
	public void clickOnReset() { 
		
		driver.findElement(reset_Password).click();
	}
	
}
