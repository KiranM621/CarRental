package test.carlistingTests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CarListingPage;
import pages.LoginSignupPage;
import utilities.PropertyReader;

public class BookCarTests {
	WebDriver driver;
	CarListingPage objCarListingPage ;
	LoginSignupPage objLoginSignupPage;
	
	 JavascriptExecutor js;
	String driverPath = null;

	String home_URL,user_Email,user_Password, book_car_msg,bookcar_fromdate,bookcar_todate;
	
	@BeforeTest
	 public void beforeTest() throws InterruptedException, IOException {
			
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
	
	@BeforeMethod
	public void beforeMethod() {
		WebDriverWait wait = new WebDriverWait(driver,30);

		
		driver.get(home_URL);
		

	}
  @Test(priority=1,description="Test user can book car without login or not")
  public void bookwithoutloginTest() throws InterruptedException {
		driver.manage().window().maximize();
				
		WebDriverWait wait = new WebDriverWait(driver,30);
		//Referencing from CarListingPage
		objCarListingPage.clickCarListingbtn();
		
		 js.executeScript("window.scrollBy(0,350)", "");//scroll down
		 objCarListingPage.selectCarAndFuel();
		 
		 objCarListingPage.clickSearchCar();
		 js.executeScript("window.scrollBy(0,350)", "");
		 objCarListingPage.clickViewDetails();
		 js.executeScript("window.scrollBy(0,350)", "");
		 
		 
		 WebElement bookBtn=driver.findElement(By.xpath("/html/body/section[2]/div/div[2]/aside/div[2]/form/a"));
		 String textofbtn=bookBtn.getText();
		 assertEquals("LOGIN FOR BOOK",textofbtn);
		    bookBtn.click();	

		 //Thread.sleep(5000);
  }
  
  
  
  @Test(priority=2,description="Required field test of Book car Field")
  public void bookCarRequireFieldTest() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		//Referencing from LoginSignUpPage
		objLoginSignupPage.clickOnLoginSignup();
		driver.manage().window().maximize();
		objLoginSignupPage.setLoginUserName(user_Email);
		objLoginSignupPage.setLoginPasswrod(user_Password);
		objLoginSignupPage.clickOnLogin();
		
		//Referencing from CarListingPage
		objCarListingPage.clickCarListingbtn();
		js.executeScript("window.scrollBy(0,350)", "");//scroll down
		 
		 objCarListingPage.selectCarAndFuel();
		 objCarListingPage.clickSearchCar();
		 
		 js.executeScript("window.scrollBy(0,350)", "");
		 objCarListingPage.clickViewDetails();
		 js.executeScript("window.scrollBy(0,550)", "");
		
		 objCarListingPage.setFromdate(bookcar_fromdate);
		 objCarListingPage.setTodate(bookcar_todate);
		 objCarListingPage.clickBookNow();
			
			WebElement message = driver.findElement(By.xpath("/html/body/section[2]/div/div[2]/aside/div[2]/form/div[3]/textarea"));
			String validationMessage = message.getAttribute("validationMessage");
			assertEquals("Please fill out this field.",validationMessage);
				 
			 //Thread.sleep(8000);
			 
  }
  
  @Test(priority=3,description="Book car successfully")
  public void bookCarTest() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		//Referencing from CarListingPage
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		objCarListingPage.clickCarListingbtn();
		js.executeScript("window.scrollBy(0,350)", "");//scroll down
		 
		 objCarListingPage.selectCarAndFuel();
		 objCarListingPage.clickSearchCar();
		 
		 js.executeScript("window.scrollBy(0,350)", "");
		 objCarListingPage.clickViewDetails();
		 js.executeScript("window.scrollBy(0,550)", "");
		 objCarListingPage.setFromdate(bookcar_fromdate);
		 objCarListingPage.setTodate(bookcar_todate);
		 
		 objCarListingPage.setMessage(book_car_msg);
		
//		 objCarListingPage.clickBookNow();
		 
	 
	 
		 	//validation Booking successful pop-up message got or not
//		 Alert alert=driver.switchTo().alert();
//			String alertMessage=driver.switchTo().alert().getText();
//			assertEquals("Booking successfull.",alertMessage);	
		 
		// Thread.sleep(5000);
		 
		 
		 
		 
  }

  
  
  
  @AfterTest
  public void afterMethod() {
	  driver.quit();
  }
  
}