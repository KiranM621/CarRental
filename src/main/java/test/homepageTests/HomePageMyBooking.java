package test.homepageTests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginSignupPage;
import utilities.PropertyReader;

public class HomePageMyBooking {
	WebDriver driver;
	LoginSignupPage objLoginSignupPage;
	HomePage objHomePge ;
	
	 JavascriptExecutor js;
	String driverPath = null;
	String home_URL,user_Email,user_Password;
	
	@BeforeTest
	 public void beforeTest() throws InterruptedException, IOException {
			
		driverPath = PropertyReader.getProperty("Chrome_Driver_Path");
		  user_Email=PropertyReader.getProperty("user_Email");
		  user_Password=PropertyReader.getProperty("user_Password");
		  home_URL=PropertyReader.getProperty("home_URL");;
			  System.setProperty("webdriver.chrome.driver", driverPath);
			  driver = new ChromeDriver();
			  js = (JavascriptExecutor) driver;
				objLoginSignupPage =new LoginSignupPage(driver);
				objHomePge =new HomePage(driver);
				 
		  }

  @Test(description="Test my booking button redirect to correct page")
  public void homePageMyBookingTest() throws InterruptedException {
	  driver.get(home_URL);//getURL
		WebDriverWait wait = new WebDriverWait(driver,30);

		//Referencing from LoginSignupPage
		objLoginSignupPage.clickOnLoginSignup();
		
		driver.manage().window().maximize();
		objLoginSignupPage.setLoginUserName(user_Email);
		objLoginSignupPage.setLoginPasswrod(user_Password);
	   	objLoginSignupPage.clickOnLogin();
		
	  //Referencing from HomePage
	    objHomePge.clickOnprofile();
	    objHomePge.clickOnMyBooking();
		
		
		String Text= driver.findElement(By.xpath("/html/body/section[2]/div/div[2]/div[2]/div/h5")).getText();
		assertEquals("MY BOOKINGS",Text);
	  
	  
	  
	  
  }
  
  @AfterTest
  public void afteTest() {
	  driver.quit();
  }

}
