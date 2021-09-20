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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginSignupPage;
import utilities.ExcelUtils;
import utilities.PropertyReader;

public class SignUp {

	String base_Url = PropertyReader.getProperty("home_URL");
	String path = PropertyReader.getProperty("Chrome_Driver_Path");
	WebDriver driver = null;
	String user_Name = PropertyReader.getProperty("new_User_Name");
	String user_Email = PropertyReader.getProperty("new_User_Email");
	String user_Number = PropertyReader.getProperty("new_User_Number");
	String user_Password = PropertyReader.getProperty("new_User_Password");
    String excel_Path=PropertyReader.getProperty("excel_Path");
	LoginSignupPage loginSignupPageObject= null;
	
	@BeforeTest(description = "Creation of objects and settingup properties before test")
	
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver",path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		loginSignupPageObject = new LoginSignupPage(driver);
	}
	
	@BeforeMethod(description = "Loads basurl before every test")
	public void beforeMethod() {
		WebDriverWait wait = new WebDriverWait(driver,30);

		
		driver.get(base_Url);
		

	}
	
	

	
	@DataProvider(name="testData")
	public Object[][] getData() { 
		
		//storing data retrieved from excel in 2d array
		Object data[][] = testData(excel_Path,"Signup");
		return data;
		
	}
	
	
	
	//Reading data from excel file
	public static Object[][] testData(String path,String sheet) { 
		
		//calling and using methods defined in ExcelUtil class from utilities.
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
	
	@Test(priority=1,dataProvider="testData",description="Verifying valid signup using data-driven test")
	
	public void signupTestValid(String name,String number,String email,String password,String confirmPassword) { 
		WebDriverWait wait = new WebDriverWait(driver,30);
		String expected_Message = PropertyReader.getProperty("registration_Success");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		
		//Referencing From LoginSignupPage
		loginSignupPageObject.clickOnLoginSignup();

		loginSignupPageObject.clickOnSignup();
		
		
		
		loginSignupPageObject.setSignupUserName(name);
		loginSignupPageObject.setSignupUserNumber(number);
		loginSignupPageObject.setSignupUserEmail(email);
		loginSignupPageObject.setSignupPasswrod(password);
		loginSignupPageObject.setSignupConfirmPassword(confirmPassword);
		
		
		
		loginSignupPageObject.clickOnSignup_Button();
		


		String actual_Message =driver.switchTo().alert().getText() ;
		
		driver.switchTo().alert().accept();
		
		Assert.assertEquals(actual_Message,expected_Message);
		
		
	}
	
	@Test(priority=2,description="Verifying invalid signup")
	
	public void signupTestInvalid() { 
		WebDriverWait wait = new WebDriverWait(driver,30);
		String expected_Message = PropertyReader.getProperty("email_Present");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		
		//Referencing From LoginSignupPages
		loginSignupPageObject.clickOnLoginSignup();
		loginSignupPageObject.clickOnSignup();
	
		loginSignupPageObject.setSignupUserName(user_Name);
		loginSignupPageObject.setSignupUserNumber(user_Number);
		loginSignupPageObject.setSignupUserEmail(user_Email);
		loginSignupPageObject.setSignupPasswrod(user_Password);
		loginSignupPageObject.setSignupConfirmPassword(user_Password);

		
		
		String actual_Message = driver.findElement(By.xpath("//*[@id=\"user-availability-status\"]/span")).getText();
			
		Assert.assertEquals(actual_Message,expected_Message);
		
		
	}
	
	
	@AfterTest(description="Closing browser")
	
	public void AfterTest() { 
		
		WebDriverWait wait = new WebDriverWait(driver,30);

		driver.quit();
		
	}
}