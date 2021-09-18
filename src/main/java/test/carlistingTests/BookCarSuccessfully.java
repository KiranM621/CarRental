package test.carlistingTests;

import org.testng.annotations.Test;

import pages.CarListingPage;
import pages.LoginSignupPage;
import utilities.PropertyReader;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class BookCarSuccessfully {
	WebDriver driver;
	CarListingPage objCarListingPage ;
	LoginSignupPage objLoginSignupPage;
	
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
				 objLoginSignupPage =new LoginSignupPage(driver);
				 objCarListingPage =new CarListingPage(driver);
				 
		  }
	
	
  @Test
  public void bookCarTest() throws InterruptedException {
	  
	  driver.get(home_URL);//getURL
		

		//click on login/signup btn
		objLoginSignupPage.clickOnLoginSignup();
		
		driver.manage().window().maximize();
		//enter email
		objLoginSignupPage.setLoginUserName(user_Email);
		
		//enter user_Password
		objLoginSignupPage.setLoginPasswrod(user_Password);
	   
	   // click on login button
	   objLoginSignupPage.clickOnLogin();
		
	   //click on carlisting btn
	   objCarListingPage.clickCarListingbtn();
		
		 js.executeScript("window.scrollBy(0,350)", "");//scroll down
		 
		 objCarListingPage.selectCarAndFuel();
		 
		// click search car
		 objCarListingPage.clickSearchCar();
		 
		 js.executeScript("window.scrollBy(0,350)", "");
		 
		 //click view details of car
		 objCarListingPage.clickViewDetails();
		 js.executeScript("window.scrollBy(0,550)", "");
		 
		 // for booking enter fromdate,todate,msg
		 objCarListingPage.setFromdate(bookcar_fromdate);
		 objCarListingPage.setTodate(bookcar_todate);
		 
		 objCarListingPage.setMessage(book_car_msg);
		
		 
		 // click book now btn
//		 objCarListingPage.clickBookNow();
		 
	 
	 
		 	//validation Booking successful pop-up message got or not
//		 Alert alert=driver.switchTo().alert();
//			String alertMessage=driver.switchTo().alert().getText();
//			assertEquals("Booking successfull.",alertMessage);	
		 
		 
		 
		 
		 
		 
  }


  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
 
}
