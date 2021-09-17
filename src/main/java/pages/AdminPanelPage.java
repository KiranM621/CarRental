package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPanelPage {
	
	WebDriver driver = null;
	
	//change admin password page
	//current password field 
	By current_Password = By.xpath("(//input[@name = 'password'])");
	//new password field
	By new_Password = By.xpath("(//input[@name = 'newpassword'])");
	//confirm password field
	By confirm_Password = By.xpath("(//input[@name = 'confirmpassword'])");
	// save changes button
	By savechanges_Button = By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/div[2]/form/div[7]/div/button");
	// account icon
	By account = By.linkText("Account");
	// logout in accounts
	By logout = By.linkText("Logout");
	
	//manage booking
	By manage_Booking=By.xpath("/html/body/div[2]/nav/ul/li[5]/a");
	// confirm from manage booking
	By confirm=By.xpath("//*[@id=\"zctb\"]/tbody/tr[3]/td[9]/a[1]");

	
	public AdminPanelPage(WebDriver driver) { 
		
		this.driver = driver;
		
	}
	
	public void setCurrentPassword(String password) { 
		
		driver.findElement(current_Password).sendKeys(password);
		
	}
	
	public void setNewPassword(String password) { 
		
		driver.findElement(new_Password).sendKeys(password);
		
	}
	
	public void setConfirmPassword(String password) { 
		
		driver.findElement(confirm_Password).sendKeys(password);
		
	}

	public void clickOnSaveChange() { 
		
		driver.findElement(savechanges_Button).click();
		
	}
	
	public void clickOnAccount() { 
		
		driver.findElement(account).click();
		
	}
	
	public void clickOnLogout() { 
		
		driver.findElement(logout).click();
		
	}
	
	public void clickOnManageBooking() {
		driver.findElement(manage_Booking).click();
	}
	
	public void clickOnconfirm() {
		driver.findElement(confirm).click();
	}
	
}
