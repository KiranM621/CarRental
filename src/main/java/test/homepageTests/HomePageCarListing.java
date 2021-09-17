package test.homepageTests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import utilities.PropertyReader;


public class HomePageCarListing {
	WebDriver driver;
	HomePage objHomePage ;
	
	 JavascriptExecutor js;
	String driverPath = null,home_URL;
	String brand_Name,fuel_Name;
	
@BeforeMethod
public void beforeMethod() throws InterruptedException, IOException {
	
			  driverPath = PropertyReader.getProperty("Chrome_Driver_Path");
			  home_URL=PropertyReader.getProperty("home_URL");
			  brand_Name=PropertyReader.getProperty("brand_Name");
			  fuel_Name=PropertyReader.getProperty("fuel_Name");
			  System.setProperty("webdriver.chrome.driver", driverPath);
				driver = new ChromeDriver();
				 js = (JavascriptExecutor) driver;
				 
 }
		 
	  
	
  @Test
  public void fetchCarTest() throws InterruptedException {
	
	  		driver.get(home_URL);//getURL
			driver.manage().window().maximize();
			Thread.sleep(5000);
			
			objHomePage =new HomePage(driver);
			
			//click on carlisting btn
			objHomePage.clickCarListingbtn();
			 Thread.sleep(5000);
			
			 js.executeScript("window.scrollBy(0,350)", "");//scroll down
			 Thread.sleep(5000);
			 
			 objHomePage.selectCarAndFuel();
			 Thread.sleep(8000);
			 
			// click search car
			 objHomePage.clickSearchCar();
			 js.executeScript("window.scrollBy(0,350)", "");//scroll down

			 Thread.sleep(5000);

			 
			 //validation
			 String getbrandname=driver.findElement(By.xpath("/html/body/section[2]/div/div/div/div[2]/div[2]/h5/a")).getText();
			 String getfuel=driver.findElement(By.xpath("/html/body/section[2]/div/div/div/div[2]/div[2]/ul/li[3]")).getText();
			 assertEquals(brand_Name,getbrandname);
			 assertEquals(fuel_Name,getfuel);
			 Thread.sleep(5000);

	 
  }
  
  
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
