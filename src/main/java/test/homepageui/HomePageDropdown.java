package test.homepageui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import utilities.PropertyReader;

public class HomePageDropdown {
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
	public void checkDropdown() {
		driver.get(localHostName);
		HomePage obj=new HomePage(driver);
		obj.testDropdown();
	}
	
	@Test(priority=2)
	public void checkDropdownList() {
		HomePage obj=new HomePage(driver);
		obj.testDropdownList();
	}
	
	@AfterTest	
	public void afterTest() { 
		
		driver.quit();
		
	}

}
