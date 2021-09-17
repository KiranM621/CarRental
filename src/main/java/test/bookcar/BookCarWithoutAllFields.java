package test.bookcar;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.BookCarPage;
import pages.LoginSignupPage;
import utilities.PropertyReader;

public class BookCarWithoutAllFields {
	WebDriver driver;
	BookCarPage objBookCarPage ;
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
			 
				 
		  }
	
  @Test
  public void bookCarRequireFieldTest() throws InterruptedException {
	  driver.get(home_URL);//getURL
		
		
		Thread.sleep(5000);
		objLoginSignupPage =new LoginSignupPage(driver);
		objBookCarPage =new BookCarPage(driver);

		//click on login/signup btn
		objLoginSignupPage.clickOnLoginSignup();
		
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//enter email
		objLoginSignupPage.enterUserName(user_Email);
		
		//enter password
		objLoginSignupPage.enterPasswrod(user_Password);
	   Thread.sleep(5000);
	   
	   // click on login button
	   objLoginSignupPage.login();
		
	   //click on carlisting btn
	   objBookCarPage.clickCarListingbtn();
		 Thread.sleep(5000);
		
		 js.executeScript("window.scrollBy(0,350)", "");//scroll down
		 
		 //select BMW from brand dropdown list
		 Select drpBrand= new Select(driver.findElement(By.name("brand")));
		 drpBrand.selectByVisibleText("BMW");
		 
		 //select fuel from fuel dropdown list
		 Select drpFuel = new Select(driver.findElement(By.name("fueltype")));
		 drpFuel.selectByIndex(3);
		 Thread.sleep(8000);
		 
		// click search car
		 objBookCarPage.clickSearchCar();
		 
		 Thread.sleep(5000);
		 js.executeScript("window.scrollBy(0,350)", "");
		 Thread.sleep(5000);
		 
		 //click view details of car
		 objBookCarPage.clickViewDetails();
		 js.executeScript("window.scrollBy(0,550)", "");
		 
		 // for booking enter fromdate,todate,msg
		 objBookCarPage.enterFromdate(bookcar_fromdate);
		 objBookCarPage.enterTodate(bookcar_todate);
		 
		WebElement message = driver.findElement(By.xpath("/html/body/section[2]/div/div[2]/aside/div[2]/form/div[3]/textarea"));

		 Thread.sleep(5000);

		 driver.findElement(By.xpath("/html/body/section[2]/div/div[2]/aside/div[2]/form/div[4]/input")).click();
		 Thread.sleep(2000);
		 
		
		 	String validationMessage = message.getAttribute("validationMessage");
				assertEquals("Please fill out this field.",validationMessage);
			 
			 
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
 
	
}
