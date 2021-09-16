package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {
	
	WebDriver driver;
	By admin_Username=By.name("username");
	By admin_Password=By.name("password");
	By login=By.name("login");
	By manage_Booking=By.xpath("/html/body/div[2]/nav/ul/li[5]/a");
	By confirm=By.xpath("//*[@id=\"zctb\"]/tbody/tr[3]/td[9]/a[1]");

	public AdminPage (WebDriver driver) {
		this.driver = driver;
		}
	
	
	public void enterUsername(String arg1) {
		driver.findElement(admin_Username).sendKeys(arg1);
	}
	
	public void enterPassword(String arg1) {
		driver.findElement(admin_Password).sendKeys(arg1);
	}
	
	

	public void clickOnLogin() {
		driver.findElement(login).click();
	}
	
	public void clickOnManageBooking() {
		driver.findElement(manage_Booking).click();
	}
	
	public void clickOnconfirm() {
		driver.findElement(confirm).click();
	}
	
	
	
	
}
