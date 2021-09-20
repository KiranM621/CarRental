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
	String localHostName = PropertyReader.getProperty("home_URL");
	String path = PropertyReader.getProperty("Chrome_Driver_Path");
	
	WebDriver driver = null;
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver",path);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}
	
	@Test(priority=1)
	public void contactUsTest() {
		driver.get(localHostName);
		ContactUs obj= new ContactUs(driver);
		obj.pageContactUs();
	}
	
	@Test(priority=2)
	public void contactUsFeildCheck() {
		ContactUs obj= new ContactUs(driver);
		obj.contactUsPageFeilds();
	}
	
	@AfterTest	
	public void afterTest() { 
		
		driver.quit();
		
	}
		
	

}

