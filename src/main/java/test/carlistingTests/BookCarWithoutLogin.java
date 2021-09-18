package test.carlistingTests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CarListingPage;
import pages.LoginSignupPage;
import utilities.PropertyReader;

public class BookCarWithoutLogin {
	WebDriver driver;
	CarListingPage objCarListingPage;
			
	 JavascriptExecutor js;
	String driverPath = null;
String home_URL,user_Email,user_Password, book_car_msg,bookcar_fromdate,bookcar_todate;
	
	@BeforeMethod
	 public void beforeMethod() throws InterruptedException, IOException {
			
			  driverPath = PropertyReader.getProperty("Chrome_Driver_Path");
			  user_Email=PropertyReader.getProperty("user_Email");
			  user_Password=PropertyReader.getProperty("user_Password");
			  home_URL=PropertyReader.getProperty("home_URL");
			  book_car_msg=PropertyReader.getProperty("book_car_msg");
			  bookcar_fromdate=PropertyReader.getProperty("bookcar_fromdate");
			  bookcar_todate=PropertyReader.getProperty("bookcar_todate");
			  System.setProperty("webdriver.chrome.driver", driverPath);
				driver = new ChromeDriver();
				 js = (JavascriptExecutor) driver;
				 objCarListingPage =new CarListingPage(driver);
	}	
	
  @Test
  public void bookwithoutloginTest() throws InterruptedException {
	  driver.get(home_URL);//getURL
		driver.manage().window().maximize();
		
		
	  //click on carlisting btn
		objCarListingPage.clickCarListingbtn();
		
		 js.executeScript("window.scrollBy(0,350)", "");//scroll down
		 
		 objCarListingPage.selectCarAndFuel();
		// click search car
		 objCarListingPage.clickSearchCar();
		 
		 Thread.sleep(5000);
		 js.executeScript("window.scrollBy(0,350)", "");
		 
		 //click view details of car
		 objCarListingPage.clickViewDetails();
		 js.executeScript("window.scrollBy(0,350)", "");
		 
		 
		 String textofbtn=driver.findElement(By.xpath("/html/body/section[2]/div/div[2]/aside/div[2]/form/a")).getText();
		 assertEquals("LOGIN FOR BOOK",textofbtn);
		 driver.findElement(By.xpath("/html/body/section[2]/div/div[2]/aside/div[2]/form/a")).click();	

  }
  
  
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  
}
