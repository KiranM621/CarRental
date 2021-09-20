package test.userlogin;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginSignupPage;
import utilities.ExcelUtils;
import utilities.PropertyReader;

public class UserLogin {
	WebDriver driver;
	LoginSignupPage objLoginSignupPage ;
	
	 JavascriptExecutor js;
	String driverPath = null;
	String home_URL,user_Email,user_Password,wrong_Password,excel_Path;
	
	@BeforeTest
	 public void beforeTest() throws InterruptedException, IOException {
			

		driverPath = PropertyReader.getProperty("Chrome_Driver_Path");
		user_Email=PropertyReader.getProperty("user_Email");
		user_Password=PropertyReader.getProperty("user_Password");
		wrong_Password=PropertyReader.getProperty("wrong_Password");
		home_URL=PropertyReader.getProperty("home_URL");
		  excel_Path=PropertyReader.getProperty("excel_Path");

		 System.setProperty("webdriver.chrome.driver", driverPath);
				driver = new ChromeDriver();
				 js = (JavascriptExecutor) driver;
				objLoginSignupPage =new LoginSignupPage(driver);

				 
		  }
	
	@BeforeMethod
	public void beforeMethod() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.get(home_URL);
		

	}
	
	@DataProvider(name="testData")
	public Object[][] getData() { 
		
		
		Object data[][] = testData(excel_Path,"Login");
		return data;
		
	}
		
	
	public static Object[][] testData(String path,String sheet) { 
		
		ExcelUtils excel = new ExcelUtils(path,sheet);
		int row_Count = excel.getRowCount();
		int col_Count = excel.getColumnCount();

		
		Object data[][] = new Object[row_Count - 1][col_Count];
		
		for(int i = 1 ; i < row_Count ; i++) { 
			
			
			for(int j = 0 ; j < col_Count ; j++) { 
				

				String cellData = excel.getCellValue(i, j);
				data[i-1][j] = cellData;
				
			}
			
		}
		
		return data;
		 
		
	}	
	
	
	@Test(priority=1,description="Login Test for Invalid credentials")
	public void loginWithInValidDetailsTest() throws InterruptedException {
		
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//Referencing from LoginSignupPage
		objLoginSignupPage.clickOnLoginSignup();
		
		driver.manage().window().maximize();
		objLoginSignupPage.setLoginUserName(user_Email);
		objLoginSignupPage.setLoginPasswrod(wrong_Password);
	 
	   	objLoginSignupPage.clickOnLogin();
		
		
		Alert alert=driver.switchTo().alert();
		String alertMessage=driver.switchTo().alert().getText();
		assertEquals("Invalid Details",alertMessage);
		Thread.sleep(5000);
		alert.accept();
	
	}
	
	@Test(priority=2,dataProvider="testData",description="Login Test for valid credentials")
	public void loginWithValidDetailsTest(String email,String password) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//Referencing from LoginSignupPage
		objLoginSignupPage.clickOnLoginSignup();
		
		driver.manage().window().maximize();
		objLoginSignupPage.setLoginUserName(email);
		objLoginSignupPage.setLoginPasswrod(password);
	 
	   	objLoginSignupPage.clickOnLogin();
		
	   	//validation of login
		
		String welcomMsg=driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div")).getText();
		Assert.assertTrue(welcomMsg.contains("Welcome To Car rental portal"));
		
	}
	
	
	
@AfterTest
	
	public void AfterTest() { 
		
		WebDriverWait wait = new WebDriverWait(driver,30);

		driver.quit();
		
	}
	
	
}
