package test.adminfunctional;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AdminLoginPage;
import pages.AdminPanelPage;
import pages.HomePage;
import pages.LoginSignupPage;
import utilities.PropertyReader;

public class ManageBooking {
	WebDriver driver;
	JavascriptExecutor js;
	String driverPath;
	AdminPanelPage objAdminPanelPage;
	AdminLoginPage objAdminLoginPage;
	LoginSignupPage objLoginSignupPage;
	HomePage objHomePage;
	String admin_URL,home_URL,admin_Name,user_Email,password;
	
	@BeforeTest
	public void beforeTest() throws InterruptedException, IOException {
		driverPath = PropertyReader.getProperty("Chrome_Driver_Path");
		admin_URL=PropertyReader.getProperty("admin_URL");
		home_URL=PropertyReader.getProperty("home_URL");
		user_Email=PropertyReader.getProperty("user_Email");
		admin_Name=PropertyReader.getProperty("admin_Name");
		password=PropertyReader.getProperty("user_Password");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		objAdminPanelPage =new AdminPanelPage(driver);
		objLoginSignupPage =new LoginSignupPage(driver);
		objAdminLoginPage=new AdminLoginPage(driver);
		objHomePage =new HomePage(driver);
		
	
	}
	@Test(description="Admin confirm booked car ,Test status reflect to Home page or not")
	public void manageBooking() throws InterruptedException {
			driver.get(admin_URL);//load url

			//Referencing from AdminLoginPage and AdminPanelPage
			objAdminLoginPage.setUserName(admin_Name);
			objAdminLoginPage.setPassword(password);
			objAdminLoginPage.clickLogin();
			objAdminPanelPage.clickOnManageBooking();
			objAdminPanelPage.clickOnconfirm();
			Alert alert=driver.switchTo().alert();
			alert.accept();
			
			//check whether status On home page of my booking it updated or not
			driver.navigate().to(home_URL);
			
			//User Login to Homepage Referencing from LoginSignupPage
			objLoginSignupPage.clickOnLoginSignup();
			driver.manage().window().maximize();
			objLoginSignupPage.setLoginUserName(user_Email);
			 objLoginSignupPage.setLoginPasswrod(password);
			 objLoginSignupPage.clickOnLogin();
			
			//Referencing from HomePage
			objHomePage.clickOnprofile();
			objHomePage.clickOnMyBooking();
			
			
			 //validate confirmed is updated or not
			String btnText= driver.findElement(By.xpath("/html/body/section[2]/div/div[2]/div[2]/div/div/ul/li[3]/div[3]/a")).getText();
			assertEquals("Confirmed",btnText);
	}
	
	@AfterTest
	public void afterTest() {
	driver.quit();
	}


 
 
}
  

