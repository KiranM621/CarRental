package test.ContactUsui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.ContactUs;
import utilities.PropertyReader;

public class ContactUsTestUi {
	//local host url
	String localHostName = PropertyReader.getProperty("home_URL");
	//chrome path
	String path = PropertyReader.getProperty("Chrome_Driver_Path");
	
	WebDriver driver = null; 
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver",path);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}
	
	@Test(priority=1,description="Testing contact option on home page")
	public void contactUsTest() {
		driver.get(localHostName);
		ContactUs obj= new ContactUs(driver);
		//Referencing from ContactUs
		obj.pageContactUs();
	}
	
	@Test(priority=2,description="Testing all fields in contact us page")
	public void contactUsFeildCheck() {
		ContactUs obj= new ContactUs(driver);
		//Referencing from ContactUs
		obj.contactUsPageFeilds();
	}
	
	@AfterTest	
	public void afterTest() { 
		
		driver.quit();
		
	}
		
	

}

