package test.bookcar;

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

import pages.BookCarPage;
import utilities.PropertyReader;

public class BookCarWithoutLogin {
	WebDriver driver;
	BookCarPage objBookCarPage ;
			
	 JavascriptExecutor js;
	String driverPath = null;
	String home_URL,user_Email,user_Password, book_car_msg,bookcar_fromdate,bookcar_todate;

	@BeforeMethod
	 public void beforeMethod() throws InterruptedException, IOException {
		
		driverPath = PropertyReader.getProperty("Chrome_Driver_Path");
		
		  home_URL=PropertyReader.getProperty("home_URL");
		  book_car_msg=PropertyReader.getProperty("book_car_msg");
		  bookcar_fromdate=PropertyReader.getProperty("bookcar_fromdate");
		  bookcar_todate=PropertyReader.getProperty("bookcar_todate");
		  System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			 js = (JavascriptExecutor) driver;
				 
		  }	
	
  @Test
  public void bookwithoutloginTest() throws InterruptedException {
	  driver.get(home_URL);//getURL
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		objBookCarPage =new BookCarPage(driver);
		
	  //click on carlisting btn
		objBookCarPage.clickCarListingbtn();
		 Thread.sleep(5000);
		
		 js.executeScript("window.scrollBy(0,350)", "");//scroll down
		 
		 objBookCarPage.selectCarAndFuel();
		// click search car
		 objBookCarPage.clickSearchCar();
		 
		 Thread.sleep(5000);
		 js.executeScript("window.scrollBy(0,350)", "");
		 Thread.sleep(5000);
		 
		 //click view details of car
		 objBookCarPage.clickViewDetails();
		 js.executeScript("window.scrollBy(0,350)", "");
		 
	 
	objBookCarPage.validateBookCarWithoutLogin();
	 Thread.sleep(5000);	

  }
  
  
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  
}
