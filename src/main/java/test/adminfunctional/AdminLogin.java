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

import utilities.PropertyReader;

public class AdminLogin {

	String base_Url = PropertyReader.getProperty("admin_URL");
	String path = PropertyReader.getProperty("Chrome_Driver_Path");
	String admin_Name = PropertyReader.getProperty("admin_Name");
	String admin_Password = PropertyReader.getProperty("admin_Password");
	String admin_Invalid_Password = PropertyReader.getProperty("admin_Invalid_Password");
	
	WebDriver driver = null;
	
	@BeforeTest
	public void BeforeTest() {

		System.setProperty("webdriver.chrome.driver",path);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;




	}

	
	
	

	@Test(priority = 1)
	
	public void validLogin() { 
		
		String expected_Title = PropertyReader.getProperty("admin_Page_Title");
		
		driver.get(base_Url);
		
		
		driver.findElement(By.xpath("(//input[@name = 'username'])")).sendKeys(admin_Name);
		

		
		driver.findElement(By.xpath("(//input[@name = 'password'])")).sendKeys(admin_Password);

        
		
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/form/button")).click();
		

		
		String actual_Title = driver.getTitle();
		
		Assert.assertEquals(actual_Title, expected_Title);
		

		
	}
	
	@Test(priority = 2)

	public void adminLogout() throws InterruptedException { 
		
		String expected_Title = PropertyReader.getProperty("admin_Login_Page_Title");
		
		driver.findElement(By.linkText("Account")).click();

		
		driver.findElement(By.linkText("Logout")).click();
		

		String actual_Title = driver.getTitle();
		
		Assert.assertEquals(actual_Title, expected_Title);
		
		
	}
	
	@Test(priority = 3)
	
	public void invalidLogin() { 
		driver.get(base_Url);
		String expected_Message = "Invalid Details";
		
		driver.get(base_Url);
		

		driver.findElement(By.xpath("(//input[@name = 'username'])")).sendKeys(admin_Name);
		

		
		driver.findElement(By.xpath("(//input[@name = 'password'])")).sendKeys(admin_Invalid_Password);

        
		
		driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div/form/button")).click();

		
		
		
		String actual_Message = driver.switchTo().alert().getText();
		
		Assert.assertEquals(actual_Message, expected_Message);

	}
	
	
	@AfterTest
	
	public void AfterTest() { 
		
		driver.quit();
		
	}
}

