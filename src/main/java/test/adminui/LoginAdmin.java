package test.adminui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AdminLoginPage;
import pages.AdminPanelPage;
import utilities.PropertyReader;

public class LoginAdmin {
	String base_Url = PropertyReader.getProperty("admin_URL");
	String path = PropertyReader.getProperty("Chrome_Driver_Path");
	String admin_Name = PropertyReader.getProperty("admin_Name");
	String admin_Password = PropertyReader.getProperty("admin_Password");
	String localHostName = PropertyReader.getProperty("home_URL");

	
	WebDriver driver = null;
	

	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver",path);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}
	
	@Test(priority=1)
	public void testAdmin() {
		driver.get(localHostName);
		AdminLoginPage obj1=new AdminLoginPage(driver);
		obj1.loginAdmin(admin_Name,admin_Password);
		
	}
	
	@Test(priority=2)
	public void testAdminPanel() {
		AdminPanelPage obj=new AdminPanelPage(driver);
		obj.adminPanel();
		
	}
	
	@Test(priority=3)
	public void adminDropdown() {
		AdminPanelPage obj=new AdminPanelPage(driver);
		obj.dropDownAdmin();
	}
	
	@Test(priority=4)
	public void adminDashboard() {
		AdminPanelPage obj=new AdminPanelPage(driver);
		obj.dashboard();
	}
	
	@Test(priority=5)
	public void updateContact() {
		AdminPanelPage obj=new AdminPanelPage(driver);
		obj.updateContactInfo();
	}

	@Test(priority=6)
	public void adminManagePages() {
		AdminPanelPage obj=new AdminPanelPage(driver);
		obj.managePages();
	}
	
	@Test(priority=7)
	public void adminManageSubscriber() {
		AdminPanelPage obj=new AdminPanelPage(driver);
		obj.manageSubscribers();
	}
	@Test(priority=8)
	public void adminRegUser() {
		AdminPanelPage obj=new AdminPanelPage(driver);
		obj.regUsers();
	}
	
	@Test(priority=8)
	public void adminManageQuery() {
		AdminPanelPage obj=new AdminPanelPage(driver);
		obj.manageQuery();
	}
	
	@Test(priority=9)
	public void adminManageBooking() {
		AdminPanelPage obj=new AdminPanelPage(driver);
		obj.manageBooking();
	}
	
	@Test(priority=10)
	public void adminVehicle() {
		AdminPanelPage obj=new AdminPanelPage(driver);
		obj.vehicles();

	}
	@Test(priority=11)
	public void adminBrand() {
		AdminPanelPage obj=new AdminPanelPage(driver);
		obj.brands();
	}	
	@AfterTest	
	public void afterTest() { 
		
		driver.quit();
		
	}

}
