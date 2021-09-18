package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	
	WebDriver driver;
    
	//Home page car list btn
	By car_List=By.xpath("//*[@id=\"navigation\"]/ul/li[3]/a");
	
	//my profile btn
	By homePage_Profile=By.xpath("//*[@id=\"navigation_bar\"]/div/div[2]/div[1]/ul/li/a");
	//my booking under my profile
	By homePage_MyBooking=By.xpath("//*[@id=\"navigation_bar\"]/div/div[2]/div[1]/ul/li/ul/li[3]/a");
	
	
	
	
	public HomePage (WebDriver driver) {
		this.driver = driver;
		}
	
	
	
	
	public void clickOnprofile() {
		driver.findElement(homePage_Profile).click();
	}
	
	
	public void clickOnMyBooking() {
		driver.findElement(homePage_MyBooking).click();
	}
	
	
	

}
