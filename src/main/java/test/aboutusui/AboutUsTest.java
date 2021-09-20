package test.aboutusui;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AboutUsPages;
import utilities.PropertyReader;

public class AboutUsTest {
	
	//Localhost path
	String localHostName = PropertyReader.getProperty("home_URL");
	//chrome driver path
	String path = PropertyReader.getProperty("Chrome_Driver_Path");
	WebDriver driver = null;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver",path);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}
	
	
	@Test(priority=1)
	public void aboutUsTest() {
		driver.get(localHostName);
		// create object of page class
		AboutUsPages obj= new AboutUsPages(driver);
		obj.pageAboutUs();
		
	}
	
	@Test(priority=2)
	public void aboutUsHeading() {
		// create object of page class
		AboutUsPages obj= new AboutUsPages(driver);
		obj.pageAboutHeading();
	}
	
	@AfterTest	
	public void afterTest() { 
		
		driver.quit();
		
	}
}
