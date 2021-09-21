package test.adminfunctional;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AdminLoginPage;
import pages.AdminPanelPage;
import utilities.PropertyReader;

public class AdminLogin {

	String base_Url = PropertyReader.getProperty("admin_URL");
	String path = PropertyReader.getProperty("Chrome_Driver_Path");
	String admin_Name = PropertyReader.getProperty("admin_Name");
	String admin_Password = PropertyReader.getProperty("admin_Password");
	String admin_Invalid_Password = PropertyReader.getProperty("admin_Invalid_Password");
	
	AdminPanelPage adminPanelPageObject = null;
	AdminLoginPage adminLoginPageObject = null;
	WebDriver driver = null;
	
	@BeforeTest(description = "Creation of objects and settingup properties before test")
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver",path);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		adminLoginPageObject = new AdminLoginPage(driver);
		adminPanelPageObject = new AdminPanelPage(driver);

	}

	
	
	

	@Test(priority = 1,description = "Testing admin login with valid data")
	
	public void validLogin() throws InterruptedException { 
		
		String expected_Title = PropertyReader.getProperty("admin_Page_Title");
		
		driver.get(base_Url);
		Thread.sleep(1000);
		
		// referencing through AdminLoginPage class

		adminLoginPageObject.setUserName(admin_Name);
		adminLoginPageObject.setPassword(admin_Password);
		Thread.sleep(2000);
        adminLoginPageObject.clickLogin();
        Thread.sleep(1000);	
		String actual_Title = driver.getTitle();

		Assert.assertEquals(actual_Title, expected_Title);
		

		
	}
	
	@Test(priority = 2,description = "Testing logout functionality from adminpanel")

	public void adminLogout() throws InterruptedException { 
		
		String expected_Title = PropertyReader.getProperty("admin_Login_Page_Title");
		Thread.sleep(1000);
		//refrencing from AdminPanelPage
		adminPanelPageObject.clickOnAccount();
		adminPanelPageObject.clickOnLogout();
		Thread.sleep(1000);
		String actual_Title = driver.getTitle();
		
		Assert.assertEquals(actual_Title, expected_Title);
		
		
	}
	
	@Test(priority = 3,description = "Testing adminlogin with invalid data")
	
	public void invalidLogin() throws InterruptedException { 
		
		driver.get(base_Url);
		String expected_Message = PropertyReader.getProperty("admin_Invalid_Login_Message");
		
		driver.get(base_Url);
		Thread.sleep(2000);
		// referencing through AdminLoginPage class
		adminLoginPageObject.setUserName(admin_Name);
		adminLoginPageObject.setPassword(admin_Invalid_Password);
		Thread.sleep(1000);
        adminLoginPageObject.clickLogin();
        Thread.sleep(2000);
		String actual_Message = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		Assert.assertEquals(actual_Message, expected_Message);

	}
	
	
	@AfterTest(description="Closing browser")
	
	public void afterTest() { 
		
		driver.quit();
		
	}
}

