package test.ContactUsTest;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.ContactUs;
import pages.HomePage;
import utilities.PropertyReader;

public class ContactUsTest {
	WebDriver driver;
	ContactUs objContactUs ;
	
	 JavascriptExecutor js;
	String driverPath = null;
	String home_URL,user_Email,user_Password,contactus_Fullname,contactus_Mob,contactus_Email,contactus_Msg;
	
@BeforeTest
	 public void beforeTest() throws InterruptedException, IOException {
			
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

  @Test(description="Test successful contact us")
  public void contactusTest() throws InterruptedException {
		
	  	driver.get(home_URL);//getURL
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		objContactUs =new ContactUs(driver);
		
		//Referencing from ContactUsPage
		objContactUs.clickContactus();
  
        objContactUs.contactusEnterfullname(contactus_Fullname);
        objContactUs.contactusEnteremail(contactus_Email);
        objContactUs.contactusEnterphone(contactus_Mob);
        objContactUs.contactusMessage(contactus_Msg);
        
		
//		objContactUs.clickOnsend();
       
       //validation
       
//        String msg=  driver.findElement(By.xpath("/html/body/section[2]/div/div/div[1]/div[1]")).getText();
//        assertEquals("SUCCESS:Query Sent. We will contact you shortly",msg);
	  
  }
  
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

  
}
