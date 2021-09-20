package test.homepageui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import utilities.PropertyReader;

public class HomePageTest {
	
	//Localhost url
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
	
	@Test(priority=1,description="Testing title of home page")
	public void testTitle() {
		driver.get(localHostName);
		HomePage obj=new HomePage(driver);
		//Referencing from HomePage
		obj.testPageTitle();
	}
	
	@Test(priority=2,description="Testing logo of home page")
	public void testLogo() {
		HomePage obj=new HomePage(driver);
		//Referencing from HomePage
		obj.testPageLogo();
	}
	
	@Test(priority=3,description="Testing heading of home page")
	public void testHeading() {
		HomePage obj=new HomePage(driver);
		//Referencing from HomePage
		obj.testPageHeading();
	}
	
	@Test(priority=4,description="Testing search box on home page")
	public void testSearchbox() {
		HomePage obj=new HomePage(driver);
		//Referencing from HomePage
		obj.testSearchBox();
	}
	
	@Test(priority=5,description="Testing heading color of home page")
	public void testHomeHeadingColor() {
		HomePage obj=new HomePage(driver);
		//Referencing from HomePage
		obj.testHeadingColor();
	}
	
	@Test(priority=6,description="Testing scroll bar on home page")
	public void testScrollBar() {
		HomePage obj=new HomePage(driver);
		obj.scrollBar();
	}
	
	@AfterTest	
	public void afterTest() { 
		
		driver.quit();
		
	}

}
