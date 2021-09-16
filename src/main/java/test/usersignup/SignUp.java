package test.usersignup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.PropertyReader;

public class SignUp {

	String base_Url = PropertyReader.getProperty("home_URL");
	String path = PropertyReader.getProperty("Chrome_Driver_Path");
	WebDriver driver = null;
	String user_Name = PropertyReader.getProperty("new_User_Name");
	String user_Email = PropertyReader.getProperty("new_User_Email");
	String user_Number = PropertyReader.getProperty("new_User_Number");
	String user_Password = PropertyReader.getProperty("new_User_Password");

	
	@BeforeTest
	
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver",path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();;

	}
	
	@BeforeMethod
	public void beforeMethod() {
		WebDriverWait wait = new WebDriverWait(driver,30);

		
		driver.get(base_Url);
		

	}
	
	@Test(priority=1)
	
	public void signupTestValid() { 
		WebDriverWait wait = new WebDriverWait(driver,30);
		String expected_Message = PropertyReader.getProperty("registration_Success");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;

		
		

		driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/div[4]/a")).click();
		
		driver.findElement(By.linkText("Signup Here")).click();
		
		driver.findElement(By.xpath("(//input[@name='fullname'])")).sendKeys(user_Name);
		driver.findElement(By.xpath("(//input[@name='mobileno'])")).sendKeys(user_Number);
		driver.findElement(By.xpath("(//input[@name='emailid'])")).sendKeys(user_Email);

		
		driver.findElement(By.xpath("//*[@id=\"signupform\"]/div/div/div[2]/div/div/div/form/div[4]/input")).sendKeys(user_Password);
		driver.findElement(By.xpath("(//input[@name='confirmpassword'])")).sendKeys(user_Password);

		
		
		

		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();

		String actual_Message =driver.switchTo().alert().getText() ;
		
		driver.switchTo().alert().accept();
		
		Assert.assertEquals(actual_Message,expected_Message);
		
		
	}
	
	@Test(priority=2)
	
	public void signupTestInvalid() { 
		WebDriverWait wait = new WebDriverWait(driver,30);
		String expected_Message = PropertyReader.getProperty("email_Present");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;

		
		

		driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div/div[4]/a")).click();
		
		driver.findElement(By.linkText("Signup Here")).click();
		
		driver.findElement(By.xpath("(//input[@name='fullname'])")).sendKeys(user_Name);
		driver.findElement(By.xpath("(//input[@name='mobileno'])")).sendKeys(user_Number);
		driver.findElement(By.xpath("(//input[@name='emailid'])")).sendKeys(user_Email);

		
		driver.findElement(By.xpath("//*[@id=\"signupform\"]/div/div/div[2]/div/div/div/form/div[4]/input")).sendKeys(user_Password);
		driver.findElement(By.xpath("(//input[@name='confirmpassword'])")).sendKeys(user_Password);

		
		
		String actual_Message = driver.findElement(By.xpath("//*[@id=\"user-availability-status\"]/span")).getText();
		


		
		
		Assert.assertEquals(actual_Message,expected_Message);
		
		
	}
	
	
	@AfterTest
	
	public void AfterTest() { 
		
		WebDriverWait wait = new WebDriverWait(driver,30);

		driver.quit();
		
	}
}
