package test.homepageTests;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import utilities.PropertyReader;

public class HomePageContactUs {
	WebDriver driver;
	HomePage objHomePage ;
	
	 JavascriptExecutor js;
	String driverPath = null;
	String home_URL,user_Email,user_Password,contactus_Fullname,contactus_Mob,contactus_Email,contactus_Msg;
	
@BeforeMethod
	 public void beforeMethod() throws InterruptedException, IOException {
			
			driverPath = PropertyReader.getProperty("Chrome_Driver_Path");
			home_URL=PropertyReader.getProperty("home_URL");
			contactus_Fullname=PropertyReader.getProperty("contactus_Fullname");
			contactus_Email=PropertyReader.getProperty("contactus_Email");
			contactus_Mob=PropertyReader.getProperty("contactus_Mob");
			contactus_Msg=PropertyReader.getProperty("contactus_Msg");
			  System.setProperty("webdriver.chrome.driver", driverPath);
				driver = new ChromeDriver();
				 js = (JavascriptExecutor) driver;
				 
		  }	
  @Test
  public void contactusTest() throws InterruptedException {
		
	  	driver.get(home_URL);//getURL
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		objHomePage =new HomePage(driver);
		
		//click on contact-us
		objHomePage.clickContactus();
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(5000);
  
		objHomePage.contactusEnterfullname(contactus_Fullname);
		objHomePage.contactusEnteremail(contactus_Email);
		objHomePage.contactusEnterphone(contactus_Mob);
		objHomePage.contactusMessage(contactus_Msg);
		Thread.sleep(5000);
        
		
		//objHomePage.clickOnsend();
      //  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       Thread.sleep(5000);
       
       //validation
       
     // String msg=  driver.findElement(By.xpath("/html/body/section[2]/div/div/div[1]/div[1]")).getText();
	//  assertEquals("SUCCESS:Query Sent. We will contact you shortly",msg);
	  
  }
  
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

  
}
