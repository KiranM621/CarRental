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

import utilities.PropertyReader;

public class AdminPassword {

	String base_Url = PropertyReader.getProperty("admin_URL");
	String path = PropertyReader.getProperty("Chrome_Driver_Path");
	String admin_Name = PropertyReader.getProperty("admin_Name");
	String admin_Password = PropertyReader.getProperty("admin_Password");
	String admin_Invalid_Password = PropertyReader.getProperty("admin_Invalid_Password");
	
	WebDriver driver = null;
	
	@BeforeTest
	
	public void BeforeTest() {

		System.setProperty("webdriver.chrome.driver","D:\\Java\\MiniProject\\resource\\chromedriver.exe");
		driver = new ChromeDriver();



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
		
		
    	driver.findElement(By.xpath("(//input[@name = 'username'])")).sendKeys(admin_Name);		
		driver.findElement(By.xpath("(//input[@name = 'password'])")).sendKeys(admin_Password);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/form/button")).click();
		
		
		
		
		driver.findElement(By.xpath("(//input[@name = 'password'])")).sendKeys(admin_Password);	
		driver.findElement(By.xpath("(//input[@name = 'newpassword'])")).sendKeys(admin_Password);
		driver.findElement(By.xpath("(//input[@name = 'confirmpassword'])")).sendKeys(admin_Password);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/div[2]/form/div[7]/div/button")).click();
		
		
		
		String actual_Message =  driver.findElement(By.xpath("(//div[@class = 'succWrap'])")).getText();

		Assert.assertEquals(actual_Message, actual_Message);

	}
    
    @Test(priority = 2)
	
	public void changePasswordTwo() { 
		
    	
    	String alertExpectedMsg = PropertyReader.getProperty("expected_Alert_Message");
		
		
    	driver.findElement(By.xpath("(//input[@name = 'username'])")).sendKeys(admin_Name);		
		driver.findElement(By.xpath("(//input[@name = 'password'])")).sendKeys(admin_Password);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/form/button")).click();
		
		
		
		
		driver.findElement(By.xpath("(//input[@name = 'password'])")).sendKeys(admin_Password);
		
		driver.findElement(By.xpath("(//input[@name = 'newpassword'])")).sendKeys(admin_Invalid_Password);

		driver.findElement(By.xpath("(//input[@name = 'confirmpassword'])")).sendKeys(admin_Password);
		
	
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		driver.findElement(By.tagName("button")).click();

		
	    String alertActualMsg =  driver.switchTo().alert().getText();		
	    driver.switchTo().alert().accept();

	
		Assert.assertEquals(alertExpectedMsg,alertActualMsg);

	}
    
    
    @Test(priority = 3)
	
   	public void changePasswordThree() { 
   		
   	
       	String expected_Error_Message = PropertyReader.getProperty("invalid_Admin_Login_Message");
   		

    	driver.findElement(By.xpath("(//input[@name = 'username'])")).sendKeys(admin_Name);		
		driver.findElement(By.xpath("(//input[@name = 'password'])")).sendKeys(admin_Password);
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/form/button")).click();
   		

   		
   		
   		
   		driver.findElement(By.xpath("(//input[@name = 'password'])")).sendKeys(admin_Invalid_Password);
   		
   		driver.findElement(By.xpath("(//input[@name = 'newpassword'])")).sendKeys(admin_Invalid_Password);

   		driver.findElement(By.xpath("(//input[@name = 'confirmpassword'])")).sendKeys(admin_Invalid_Password);
		WebDriverWait wait = new WebDriverWait(driver,20);

		driver.findElement(By.tagName("button")).click();

   		
   	    String actual_Error_Message =  driver.findElement(By.xpath("(//div[@class = 'errorWrap'])")).getText();;		

   	
   		Assert.assertEquals(actual_Error_Message,expected_Error_Message);

   	}
       
	
	@AfterTest
	
	public void AfterTest() { 
		
		WebDriverWait wait = new WebDriverWait(driver,20);

		driver.quit();
		
	}
	
	
}
