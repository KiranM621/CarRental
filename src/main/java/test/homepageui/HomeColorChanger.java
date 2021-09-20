package test.homepageui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import utilities.PropertyReader;

public class HomeColorChanger {
	//localhost url
	String localHostName = PropertyReader.getProperty("home_URL"); 
	//chrome path
	String path = PropertyReader.getProperty("Chrome_Driver_Path");
	
	WebDriver driver = null; 
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver",path);
		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}
	
	@Test(priority=1,description="Testing color changer option on home page")
	public void testHomePageColorChnager() {
		driver.get(localHostName);
		driver.manage().window().maximize();
		HomePage obj=new HomePage(driver);
		//Referencing from HomePage
		obj.testColorChanger();
	}
	
	@Test(priority=2,description="Testing all colors in color changer")
	public void testColorsInChanger () {
		HomePage obj=new HomePage(driver);
		//Referencing from HomePage
		obj.testColors();
	}
	
	@AfterTest	
	public void afterTest() { 
		
		driver.quit();
		
	}

}
