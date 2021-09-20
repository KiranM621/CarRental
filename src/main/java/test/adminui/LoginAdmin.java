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
	//Admin base url
	String base_Url = PropertyReader.getProperty("admin_URL");
	// chrome path
	String path = PropertyReader.getProperty("Chrome_Driver_Path");
	//admin username
	String admin_Name = PropertyReader.getProperty("admin_Name");
	//admin password
	String admin_Password = PropertyReader.getProperty("admin_Password");
	//localhost url
	String localHostName = PropertyReader.getProperty("home_URL");

	WebDriver driver = null;
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver",path);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}
	

	@Test(priority=1,description="Testing Admin login option visible on home page and test heading of admin login page")
	public void testAdmin() {
		driver.get(localHostName);
		AdminLoginPage obj1=new AdminLoginPage(driver);
		//Referencing from AdminLoginPage
		obj1.loginAdmin(admin_Name,admin_Password);
		
	}
	
	
	@Test(priority=2,description="Testing heading of admin panel")
	public void testAdminPanel() {
		AdminPanelPage obj=new AdminPanelPage(driver);
		//Referencing from AdminPanelPage
		obj.adminPanel();
		
	}
	
	@Test(priority=3,description="Testing Dropdown list on admin page")
	public void adminDropdown() {
		AdminPanelPage obj=new AdminPanelPage(driver);
		//Referencing from AdminPanelPage
		obj.dropDownAdmin();
	}
	
	
	@Test(priority=4,description="Testing dashboard on admin page")
	public void adminDashboard() {
		AdminPanelPage obj=new AdminPanelPage(driver);
		//Referencing from AdminPanelPage
		obj.dashboard();
	}
	
	
	@Test(priority=5,description="Testing update contact up and its fields on admin page")
	public void updateContact() {
		AdminPanelPage obj=new AdminPanelPage(driver);
		//Referencing from AdminPanelPage
		obj.updateContactInfo();
	}

	
	@Test(priority=6,description="Testing manage pages on admin page")
	public void adminManagePages() {
		AdminPanelPage obj=new AdminPanelPage(driver);
		//Referencing from AdminPanelPage
		obj.managePages();
	}
	
	
	@Test(priority=7,description="Testing Manage subscribers option on admin page")
	public void adminManageSubscriber() {
		AdminPanelPage obj=new AdminPanelPage(driver);
		//Referencing from AdminPanelPage
		obj.manageSubscribers();
	}
	
	
	@Test(priority=8,description="Testing Reg User on admin page")
	public void adminRegUser() {
		AdminPanelPage obj=new AdminPanelPage(driver);
		//Referencing from AdminPanelPage
		obj.regUsers();
	}
	
	
	@Test(priority=8,description="Testing Manage query option on admin page")
	public void adminManageQuery() {
		AdminPanelPage obj=new AdminPanelPage(driver);
		//Referencing from AdminPanelPage
		obj.manageQuery();
	}
	
	
	@Test(priority=9,description="Testing manage booking option on admin page")
	public void adminManageBooking() {
		AdminPanelPage obj=new AdminPanelPage(driver);
		//Referencing from AdminPanelPage
		obj.manageBooking();
	}
	
	
	@Test(priority=10,description="Testing vehicles option on admin page and post,manage vehicles on vehicle page")
	public void adminVehicle() {
		AdminPanelPage obj=new AdminPanelPage(driver);
		//Referencing from AdminPanelPage
		obj.vehicles();
	}
	
	
	@Test(priority=11,description="Testing Brands on admin page and create,manage brand on brands page")
	public void adminBrand() {
		AdminPanelPage obj=new AdminPanelPage(driver);
		//Referencing from AdminPanelPage
		obj.brands();
	}
	
	
	@AfterTest	
	public void afterTest() { 
		driver.quit();	
	}

}
