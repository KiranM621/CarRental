package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	
	WebDriver driver;
    
	//Home page car list btn
	By car_List=By.xpath("//*[@id=\"navigation\"]/ul/li[3]/a");
	//search car
	By search_Car=By.xpath("/html/body/section[2]/div/div/aside/div[1]/div[2]/form/div[3]/button");
	//contact us btn
	By contactus=By.xpath("//*[@id=\"navigation\"]/ul/li[5]/a");
	//contact us fullname textbox
	By contactus_Fullname=By.id("fullname");
	//contact us email textbox
	By contactus_Email=By.name("email");
	//contact us mobile number textbox
	By contactus_Mob=By.id("phonenumber");
	//contact us message textbox
	By contactus_Msg=By.name("message");
	//contact us send btn
	By contactus_send=By.name("send");
	//my profile btn
	By homePage_Profile=By.xpath("//*[@id=\"navigation_bar\"]/div/div[2]/div[1]/ul/li/a");
	//my booking under my profile
	By homePage_MyBooking=By.xpath("//*[@id=\"navigation_bar\"]/div/div[2]/div[1]/ul/li/ul/li[3]/a");
	
	
	
	
	public HomePage (WebDriver driver) {
		this.driver = driver;
		}
	
	public void clickCarListingbtn() {
		driver.findElement(car_List).click();
		
	}
	public void clickSearchCar() {
		driver.findElement(search_Car).click();
		
	}
	
	public void clickContactus() {
		driver.findElement(contactus).click();

	}
	public void selectCarAndFuel() {
		 //select BMW from brand dropdown list
		 Select drpBrand= new Select(driver.findElement(By.name("brand")));
		 drpBrand.selectByVisibleText("BMW");
		 
		 //select fuel from fuel dropdown list
		 Select drpFuel = new Select(driver.findElement(By.name("fueltype")));
		 drpFuel.selectByIndex(3);
		 
	}
	public void contactusEnterfullname(String arg1) {
		driver.findElement(contactus_Fullname).sendKeys(arg1);
	}
	
	public void contactusEnterphone(String arg1) {
		driver.findElement(contactus_Email).sendKeys(arg1);
		
	}
	
	public void contactusEnteremail(String arg1) {
		driver.findElement(contactus_Mob).sendKeys(arg1);
	}
	
	public void contactusMessage(String arg1) {
		driver.findElement(contactus_Msg).sendKeys(arg1);
	}
	
	public void clickOnsend() {
		driver.findElement(contactus_send).click();
	}
	
	
	public void clickOnprofile() {
		driver.findElement(homePage_Profile).click();
	}
	
	
	public void clickOnMyBooking() {
		driver.findElement(homePage_MyBooking).click();
	}
	
	
	

}
