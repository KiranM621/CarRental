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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AdminLoginPage;
import pages.AdminPanelPage;
import utilities.PropertyReader;

public class AdminPassword {

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
		adminLoginPageObject = new AdminLoginPage(driver);
		adminPanelPageObject = new AdminPanelPage(driver);


	}

	@BeforeMethod(description = "Loads basurl before every test")
	
	public void beforeMethod() {
		

		driver.get(base_Url);
		

	}
	
    @Test(priority = 1,description = "Changing password with valid details")
	
	public void changePasswordWithValidDetails() throws InterruptedException { 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;


    	String success_Message = PropertyReader.getProperty("admin_Password_Change_Message");
    	Thread.sleep(1000);
		//Referencing from AdminPanelPageObject
    	adminLoginPageObject.setUserName(admin_Name);
		adminLoginPageObject.setPassword(admin_Password);
		Thread.sleep(1000);
        adminLoginPageObject.clickLogin();
        Thread.sleep(2000);
		
		//Referencing from AdminPanelPageObject
        adminPanelPageObject.setCurrentPassword(admin_Password);
        adminPanelPageObject.setNewPassword(admin_Password);
        adminPanelPageObject.setConfirmPassword(admin_Password);
        Thread.sleep(2000);
        adminPanelPageObject.clickOnSaveChange();
        Thread.sleep(2000);
		
		
		
		
		String actual_Message =  driver.findElement(By.xpath("(//div[@class = 'succWrap'])")).getText();

		Assert.assertEquals(actual_Message, actual_Message);

	}
    
    @Test(priority = 2,description = "Changing password : new password and confirm password don't match")
	
	public void changePasswordWithInvalidDetails() throws InterruptedException { 
		
    	
    	String alertExpectedMsg = PropertyReader.getProperty("expected_Alert_Message");
		
    	Thread.sleep(1000);
    	//Referencing from AdminPanelPageObject
    	adminLoginPageObject.setUserName(admin_Name);
		adminLoginPageObject.setPassword(admin_Password);
		Thread.sleep(1000);
        adminLoginPageObject.clickLogin();
		
        Thread.sleep(1000);
		//Referencing from AdminPanelPageObject
        adminPanelPageObject.setCurrentPassword(admin_Password);
        adminPanelPageObject.setNewPassword(admin_Invalid_Password);
        adminPanelPageObject.setConfirmPassword(admin_Password);
		
        Thread.sleep(2000);
	
		WebDriverWait wait = new WebDriverWait(driver,20);
		
        adminPanelPageObject.clickOnSaveChange();
        Thread.sleep(2000);
		
	    String alertActualMsg =  driver.switchTo().alert().getText();	
	    driver.switchTo().alert().accept();

	
		Assert.assertEquals(alertExpectedMsg,alertActualMsg);

	}
    
    
    @Test(priority = 3,description = "Changing password : with wrong current password")
	
   	public void changePasswordWithInavlidCurrentPassword() throws InterruptedException { 
   		
   	
       	String expected_Error_Message = PropertyReader.getProperty("invalid_Admin_Login_Message");
       	Thread.sleep(1000);

      //Referencing from AdminPanelPageObject
    	adminLoginPageObject.setUserName(admin_Name);
		adminLoginPageObject.setPassword(admin_Password);
		Thread.sleep(1000);
        adminLoginPageObject.clickLogin();
   		
        Thread.sleep(1000);
   		
      //Referencing from AdminPanelPageObject
        adminPanelPageObject.setCurrentPassword(admin_Invalid_Password);
        adminPanelPageObject.setNewPassword(admin_Invalid_Password);
        adminPanelPageObject.setConfirmPassword(admin_Invalid_Password);
   		
        Thread.sleep(2000);

        adminPanelPageObject.clickOnSaveChange();

        Thread.sleep(2000);
   	    String actual_Error_Message =  driver.findElement(By.xpath("(//div[@class = 'errorWrap'])")).getText();;		

   	
   		Assert.assertEquals(actual_Error_Message,expected_Error_Message);

   	}
       
	
	@AfterTest
	
	public void AfterTest() { 
		

		driver.quit();
		
	}
	
	
}
