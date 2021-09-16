package test.adminfunctional;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AdminPage;
import pages.HomePage;
import pages.LoginSignupPage;
import utilities.PropertyReader;

public class AdminPageMyBooking {
	WebDriver driver;
	 JavascriptExecutor js;
	String driverPath;
	AdminPage objAdminPage;
	LoginSignupPage objLoginSignupPage;
	HomePage objHomePage;
	
	String admin_URL,home_URL,Admin_username,email,password;
	
	@BeforeMethod
	 public void beforeMethod() throws InterruptedException, IOException {
			
			  driverPath = PropertyReader.getProperty("Chrome_Driver_Path");
			  admin_URL=PropertyReader.getProperty("admin_URL");
			  home_URL=PropertyReader.getProperty("home_URL");
			  email=PropertyReader.getProperty("user_Email");
			  Admin_username=PropertyReader.getProperty("admin_Name");
			  password=PropertyReader.getProperty("user_Password");
			 
			  System.setProperty("webdriver.chrome.driver", driverPath);
				driver = new ChromeDriver();
				 js = (JavascriptExecutor) driver;
				 
		  }
		
  @Test
public void myBooking() throws InterruptedException {
	  driver.get(admin_URL);//load url
	  Thread.sleep(4000);
	  
	  objAdminPage =new AdminPage(driver);
	  
	  //enter username ,password 
	  objAdminPage.enterUsername(Admin_username);
	  objAdminPage.enterPassword(password);
	 
		//click on login 
	  objAdminPage.clickOnLogin();
		Thread.sleep(4000);
		
		//click on manage booking
		objAdminPage.clickOnManageBooking();
		Thread.sleep(4000);

		//click on confirmed button
		objAdminPage.clickOnconfirm();
		
		Alert alert=driver.switchTo().alert();

	  
	  				Thread.sleep(5000);
				alert.accept();
		
	//check whether status On home page of my booking it updated or not	
				   Thread.sleep(5000);

		//navigate to home page of carrental
		driver.navigate().to(home_URL);
		
		
		
		Thread.sleep(5000);
		objLoginSignupPage =new LoginSignupPage(driver);
		
		//click on login/signup btn
		objLoginSignupPage.clickOnLoginSignup();
		
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//enter email
		objLoginSignupPage.enterUserName(email);
		
		//enter password
		objLoginSignupPage.enterPasswrod(password);
	   Thread.sleep(5000);
	   
	   // click on login button
	   objLoginSignupPage.login();
	   objHomePage =new HomePage(driver);

		//click on profile
	   objHomePage.clickOnprofile();
		
		//click my booking
	   objHomePage.clickOnMyBooking();
	   
		   Thread.sleep(5000);

	   //validate confirmed is updated or not
		String btnText= driver.findElement(By.xpath("/html/body/section[2]/div/div[2]/div[2]/div/div/ul/li[3]/div[3]/a")).getText();
		assertEquals("Confirmed",btnText);
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
 
  
  
}
