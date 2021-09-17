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
	
	@BeforeTest
	
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver","D:\\Java\\MiniProject\\resource\\chromedriver.exe");
		driver = new ChromeDriver();
		adminLoginPageObject = new AdminLoginPage(driver);
		adminPanelPageObject = new AdminPanelPage(driver);


	}

	@BeforeMethod
	
	public void beforeMethod() {
		WebDriverWait wait = new WebDriverWait(driver,20);

		

		driver.get(base_Url);
		

	}
	
    @Test(priority = 1)
	
	public void changePasswordOne() { 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

		WebDriverWait wait = new WebDriverWait(driver,20);

    	String success_Message = PropertyReader.getProperty("admin_Password_Change_Message");
		
		//Referencing from AdminPanelPageObject
    	adminLoginPageObject.setUserName(admin_Name);
		adminLoginPageObject.setPassword(admin_Password);
        adminLoginPageObject.clickLogin();
		
		//Referencing from AdminPanelPageObject
        adminPanelPageObject.setCurrentPassword(admin_Password);
        adminPanelPageObject.setNewPassword(admin_Password);
        adminPanelPageObject.setConfirmPassword(admin_Password);
        adminPanelPageObject.clickOnSaveChange();
		
		
		
		
		String actual_Message =  driver.findElement(By.xpath("(//div[@class = 'succWrap'])")).getText();

		Assert.assertEquals(actual_Message, actual_Message);

	}
    
    @Test(priority = 2)
	
	public void changePasswordTwo() { 
		
    	
    	String alertExpectedMsg = PropertyReader.getProperty("expected_Alert_Message");
		
		
    	//Referencing from AdminPanelPageObject
    	adminLoginPageObject.setUserName(admin_Name);
		adminLoginPageObject.setPassword(admin_Password);
        adminLoginPageObject.clickLogin();
		

		//Referencing from AdminPanelPageObject
        adminPanelPageObject.setCurrentPassword(admin_Password);
        adminPanelPageObject.setNewPassword(admin_Invalid_Password);
        adminPanelPageObject.setConfirmPassword(admin_Password);
		
		
	
		WebDriverWait wait = new WebDriverWait(driver,20);
		
        adminPanelPageObject.clickOnSaveChange();

		
	    String alertActualMsg =  driver.switchTo().alert().getText();	
	    driver.switchTo().alert().accept();

	
		Assert.assertEquals(alertExpectedMsg,alertActualMsg);

	}
    
    
    @Test(priority = 3)
	
   	public void changePasswordThree() { 
   		
   	
       	String expected_Error_Message = PropertyReader.getProperty("invalid_Admin_Login_Message");
   		

      //Referencing from AdminPanelPageObject
    	adminLoginPageObject.setUserName(admin_Name);
		adminLoginPageObject.setPassword(admin_Password);
        adminLoginPageObject.clickLogin();
   		

   		
      //Referencing from AdminPanelPageObject
        adminPanelPageObject.setCurrentPassword(admin_Invalid_Password);
        adminPanelPageObject.setNewPassword(admin_Invalid_Password);
        adminPanelPageObject.setConfirmPassword(admin_Invalid_Password);
   		
   		
		WebDriverWait wait = new WebDriverWait(driver,20);

        adminPanelPageObject.clickOnSaveChange();

   		
   	    String actual_Error_Message =  driver.findElement(By.xpath("(//div[@class = 'errorWrap'])")).getText();;		

   	
   		Assert.assertEquals(actual_Error_Message,expected_Error_Message);

   	}
       
	
	@AfterTest
	
	public void AfterTest() { 
		
		WebDriverWait wait = new WebDriverWait(driver,20);

		driver.quit();
		
	}
	
	
}
