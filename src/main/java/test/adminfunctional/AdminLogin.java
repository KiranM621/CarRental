package test.adminfunctional;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
	
	@BeforeTest
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver",path);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		adminLoginPageObject = new AdminLoginPage(driver);
		adminPanelPageObject = new AdminPanelPage(driver);

	}

	
	
	

	@Test(priority = 1)
	
	public void validLogin() { 
		
		String expected_Title = PropertyReader.getProperty("admin_Page_Title");
		
		driver.get(base_Url);
		
		
		// referencing through AdminLoginPage class

		adminLoginPageObject.setUserName(admin_Name);
		adminLoginPageObject.setPassword(admin_Password);
        adminLoginPageObject.clickLogin();
		
			
		String actual_Title = driver.getTitle();
		
		Assert.assertEquals(actual_Title, expected_Title);
		

		
	}
	
	@Test(priority = 2)

	public void adminLogout() throws InterruptedException { 
		
		String expected_Title = PropertyReader.getProperty("admin_Login_Page_Title");
		
		//refrencing from AdminPanelPage
		adminPanelPageObject.clickOnAccount();
		adminPanelPageObject.clickOnLogout();
		
		String actual_Title = driver.getTitle();
		
		Assert.assertEquals(actual_Title, expected_Title);
		
		
	}
	
	@Test(priority = 3)
	
	public void invalidLogin() { 
		
		driver.get(base_Url);
		String expected_Message = PropertyReader.getProperty("admin_Invalid_Login_Message");
		
		driver.get(base_Url);
		
		// referencing through AdminLoginPage class
		adminLoginPageObject.setUserName(admin_Name);
		adminLoginPageObject.setPassword(admin_Invalid_Password);
        adminLoginPageObject.clickLogin();
		
		String actual_Message = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		Assert.assertEquals(actual_Message, expected_Message);

	}
	
	
	@AfterTest
	
	public void afterTest() { 
		
		driver.quit();
		
	}
}

