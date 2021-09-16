package test.usersignup;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.PropertyReader;

public class ForgotPassword {
	
	String base_Url = PropertyReader.getProperty("home_URL");
	String path = PropertyReader.getProperty("Chrome_Driver_Path");
	WebDriver driver;
	String user_Email = PropertyReader.getProperty("new_User_Email");
	String user_Number = PropertyReader.getProperty("new_User_Number");
	String password = PropertyReader.getProperty("new_User_Number");
	String user_New_Password = PropertyReader.getProperty("new_Password");

	
	@BeforeTest
	public void beforeTest() { 
		System.setProperty("webdriver.chrome.driver",path);

		driver = new ChromeDriver();
		
	}
	
	@BeforeMethod
	public void beforeMethod() { 
		
		driver.get(base_Url);
		driver.manage().window().maximize();
	}

	@Test(priority=1)
	public void changePasswordOne() { 
		
		String expected_Message = PropertyReader.getProperty("password_Change_Success_Message");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/div[4]/a")).click();
		driver.findElement(By.linkText("Forgot Password ?")).click();
		
		driver.findElement(By.xpath("//*[@id=\"forgotpassword\"]/div/div/div[2]/div/div/div/form/div[1]/input")).sendKeys(user_Email);
		driver.findElement(By.xpath("(//input[@name='mobile'])")).sendKeys(user_Number);
		driver.findElement(By.xpath("(//input[@name='newpassword'])")).sendKeys(user_New_Password);
		driver.findElement(By.xpath("//*[@id=\"forgotpassword\"]/div/div/div[2]/div/div/div/form/div[4]/input")).sendKeys(user_New_Password);

		driver.findElement(By.xpath("//*[@id=\"forgotpassword\"]/div/div/div[2]/div/div/div/form/div[5]/input")).click();
	
	
		String actual_Message = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		Assert.assertEquals(actual_Message, expected_Message);
	
	}
	
	@Test(priority=2)
	public void changePasswordTwo() { 
		
		String expected_Message = PropertyReader.getProperty("forgot_Password_Error_Message");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/div[4]/a")).click();
		driver.findElement(By.linkText("Forgot Password ?")).click();
		
		driver.findElement(By.xpath("//*[@id=\"forgotpassword\"]/div/div/div[2]/div/div/div/form/div[1]/input")).sendKeys(user_Email);
		driver.findElement(By.xpath("(//input[@name='mobile'])")).sendKeys(user_Number);
		driver.findElement(By.xpath("(//input[@name='newpassword'])")).sendKeys(user_New_Password);
		driver.findElement(By.xpath("//*[@id=\"forgotpassword\"]/div/div/div[2]/div/div/div/form/div[4]/input")).sendKeys(password);

		driver.findElement(By.xpath("//*[@id=\"forgotpassword\"]/div/div/div[2]/div/div/div/form/div[5]/input")).click();
	
	
		String actual_Message = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		Assert.assertEquals(actual_Message, expected_Message);
	
	}
	@AfterTest
	public void afterTest() { 
		
		driver.quit();
		
	}
	
	
}
