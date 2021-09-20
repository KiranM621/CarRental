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
	public void testTitle() {
		driver.get(localHostName);
		HomePage obj=new HomePage(driver);
		obj.testPageTitle();
	}
	
	@Test(priority=2)
	public void testLogo() {
		HomePage obj=new HomePage(driver);
		obj.testPageLogo();
	}
	
	@Test(priority=3)
	public void testHeading() {
		HomePage obj=new HomePage(driver);
		obj.testPageHeading();
	}
	
	@Test(priority=4)
	public void testSearchbox() {
		HomePage obj=new HomePage(driver);
		obj.testSearchBox();
	}
	
	@Test(priority=5)
	public void testHomeHeadingColor() {
		HomePage obj=new HomePage(driver);
		obj.testHeadingColor();
	}
	
	@Test(priority=6)
	public void testScrollBar() {
		HomePage obj=new HomePage(driver);
		obj.scrollBar();
	}
	
	@AfterTest	
	public void afterTest() { 
		
		driver.quit();
		
	}

}
