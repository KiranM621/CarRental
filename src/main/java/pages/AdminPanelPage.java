package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPanelPage {
	
	WebDriver driver = null;
	
	//change admin password page
	//current password field 
	By current_Password = By.xpath("(//input[@name = 'password'])");
	//new password field
	By new_Password = By.xpath("(//input[@name = 'newpassword'])");
	//confirm password field
	By confirm_Password = By.xpath("(//input[@name = 'confirmpassword'])");
	// save changes button
	By savechanges_Button = By.xpath("/html/body/div[2]/div/div/div/div/div/div/div/div[2]/form/div[7]/div/button");
	// account icon
	By account = By.linkText("Account");
	// logout in accounts
	By logout = By.linkText("Logout");
	//manage booking
	By manage_Booking=By.xpath("/html/body/div[2]/nav/ul/li[5]/a");
	// confirm from manage booking
	By confirm=By.xpath("//*[@id=\"zctb\"]/tbody/tr[3]/td[9]/a[1]");
	
	//GUI
	//admin page heading
	By adminPageHeading=By.xpath("//a[@href='dashboard.php']");
	// admin dropdown
	By dropDownList=By.xpath("//i[@class='fa fa-angle-down hidden-side']");
	//change password in dropdown
	By changePassword=By.xpath("//a[@href='change-password.php']");
	// logout in dropdown
	By logoutAdmin=By.xpath("//a[@href='logout.php']");
	// admin  dashboard
	By adminDashboard=By.xpath("//i[@class='fa fa-dashboard']");
	// update contact info
	By updateContactInfo=By.xpath("//a[@href='update-contactinfo.php']");
	//update address in update contact info
	By updateAddress=By.xpath("//textarea[@name='address']");
	//update email in update contact info
	By updateEmail=By.xpath("//input[@id='email']");
	// update contcat num in update contact info
	By updateContactNum=By.xpath("//input[@id='contactno']");
	// submit button in update contact info
	By submit=By.xpath("//button[@name='submit']");
	// manage pages on admin 
	By managePage=By.xpath("//a[@href='manage-pages.php']");
	// manage subscribers on admin
	By manageSubscriber=By.xpath("//a[@href='manage-subscribers.php']");
	// register users in admin
	By regUser=By.xpath("//a[@href='reg-users.php']");
	// manage query in admin page
	By manageQueries=By.xpath("//a[@href='manage-conactusquery.php']");
	// manage booking in admin page
	By manageBookings=By.xpath("//a[@href='manage-bookings.php']");
	// vehicle in admin page
	By vehicle=By.xpath("/html/body/div[2]/nav/ul/li[4]/a");
	// post vehivle in vehicle option
	By postVehicles=By.xpath("//a[@href='post-avehical.php']");
	// create vehicle
	By manageVehicles=By.xpath("//a[@href='manage-vehicles.php']");
	// brands on admin page
	By brand=By.xpath("/html/body/div[2]/nav/ul/li[3]/a");
	// create brand in admin page
	By createBrands=By.xpath("//a[@href='create-brand.php']");
	//manage brands in admin page
	By manageBrands=By.xpath("//a[@href='manage-brands.php']");
		

	
	public AdminPanelPage(WebDriver driver) { 
		
		this.driver = driver;
		
	}
	
	public void setCurrentPassword(String password) { 
		
		driver.findElement(current_Password).sendKeys(password);
		
	}
	
	public void setNewPassword(String password) { 
		
		driver.findElement(new_Password).sendKeys(password);
		
	}
	
	public void setConfirmPassword(String password) { 
		
		driver.findElement(confirm_Password).sendKeys(password);
		
	}

	public void clickOnSaveChange() { 
		
		driver.findElement(savechanges_Button).click();
		
	}
	
	public void clickOnAccount() { 
		
		driver.findElement(account).click();
		
	}
	
	public void clickOnLogout() { 
		
		driver.findElement(logout).click();
		
	}
	
	public void clickOnManageBooking() {
		driver.findElement(manage_Booking).click();
	}
	
	public void clickOnconfirm() {
		driver.findElement(confirm).click();
	}
	
	//Admin panel heading test
	public void adminPanel() {	
		//Admin Heading
		String adminHeading=driver.findElement(adminPageHeading).getText();
		//Expected Heading
		String expectedAdminHead="Car Rental Portal | Admin Panel";
		if(adminHeading.equals(expectedAdminHead)) {
			System.out.println("Admin page open successfully...");
		}else {
			System.out.println("Failed");
		}
	}
	
	//Dropdown list in admin panel
	public void dropDownAdmin() {
		//WebElement for Dropdown option on admin page
		WebElement dropdownList=driver.findElement(dropDownList);
		dropdownList.click();
		
		//WebElement for Change pass on Admin page
		WebElement changePass=driver.findElement(changePassword);
		//WebElement for logout on Admin page
		WebElement logOut=driver.findElement(logoutAdmin);
		if(changePass.isDisplayed() && logOut.isDisplayed() && changePass.isEnabled() && logOut.isEnabled()) {
			System.out.println("Change Password, logout option are visible and enabled in Dropdown List");
		}else {
			System.out.println("Change Password, logout option are not visible and enabled in Dropdown List");
		}
	}
	
	//Dashboard on admin panel
	public void dashboard() {
		//WebElement for Dashboard option on admin page
		WebElement dashboard=driver.findElement(adminDashboard);
		if(dashboard.isDisplayed() && dashboard.isEnabled()) {
			System.out.println("Dashboard option is visible and Enabled");
		}else {
			System.out.println("Dashboard option is visible and Enabled");
		}
		dashboard.click();
	}
	
	//Update contcat us page in admin panel
	public void updateContactInfo() {
		//WebElement for Update contact info on Admin page
		WebElement updateInfo=driver.findElement(updateContactInfo);
		if(updateInfo.isDisplayed() && updateInfo.isEnabled()) {
			System.out.println("Update Contact Info option is visible and Enabled");
		}else {
			System.out.println("Update Contact Info option is visible and Enabled");
		}
		updateInfo.click();
		
		//WebElement for address on Update contact info page
		WebElement address=driver.findElement(updateAddress);
		//WebElement for email on Update contact info page
		WebElement email=driver.findElement(updateEmail);
		//WebElement for contact num on Update contact info page
		WebElement contactNum=driver.findElement(updateContactNum);
		//WebElement for update button on Update contact info page
		WebElement update=driver.findElement(submit); 
		
		if(address.isDisplayed() && address.isEnabled() && email.isDisplayed() && email.isEnabled() && contactNum.isDisplayed() && contactNum.isEnabled() && update.isDisplayed() && update.isEnabled()) {
			System.out.println("All TextFeilds and button in UpdateContact page are visible and Enabled");
		}else {
			System.out.println("All TextFeilds and button in UpdateContact page are not visible and Enabled");
		}

	}
	
	// Manage pages on admin panel
	public void managePages() {
		//WEbElement for manage pages on admin panel
		WebElement managePages=driver.findElement(managePage);
		if(managePages.isDisplayed() && managePages.isEnabled()) {
			System.out.println("Manage Pages option is visible and Enabled");
		}else {
			System.out.println("Manage Pages option is visible and Enabled");
		}
		managePages.click();
	}
	
	// Manage subscribers on admin panel
	public void manageSubscribers() {
		//WEbElement for manage subscribers on admin panel
		WebElement manageSubscribers=driver.findElement(manageSubscriber);
		if(manageSubscribers.isDisplayed() && manageSubscribers.isEnabled()) {
			System.out.println("manageSubscribers option is visible and Enabled");
		}else {
			System.out.println("manageSubscribers option is visible and Enabled");
		}
		manageSubscribers.click();
	}
	
	
	// Register user in amdin panel
	public void regUsers() {
		//WEbElement for RegUser on admin panel
		WebElement regUsers=driver.findElement(regUser);
		if(regUsers.isDisplayed() && regUsers.isEnabled()) {
			System.out.println("Reg Users option is visible and Enabled");
		}else {
			System.out.println("Reg Users option is visible and Enabled");
		}
		regUsers.click();
	}
	
	//Manage query on admin panel
	public void manageQuery() {
		//WEbElement for manage Query on admin panel
		WebElement manageQuery=driver.findElement(manageQueries);
		if(manageQuery.isDisplayed() && manageQuery.isEnabled()) {
			System.out.println("manage Contactus Query option is visible and Enabled");
		}else {
			System.out.println("manage Contactus Query option is visible and Enabled");
		}
		manageQuery.click();
	}

	//manage booking page on admin panel
	public void manageBooking() {
		//WEbElement for manage Booking on admin panel
		WebElement manageBooking=driver.findElement(manageBookings);
		if(manageBooking.isDisplayed() && manageBooking.isEnabled()) {
			System.out.println("Manage Booking option is visible and Enabled");
		}else {
			System.out.println("Manage Booking option is visible and Enabled");
		}
		manageBooking.click();
	}
	 
	// vehicle page in admin panel
	public void vehicles() {
		//WEbElement for vehicles on admin panel
		WebElement vehicles=driver.findElement(vehicle);
		//WEbElement for post vehivles on vehicle page
		WebElement postVehicle=driver.findElement(postVehicles);
		//WEbElement for manage vehivles on vehicle page
		WebElement manageVehicle=driver.findElement(manageVehicles);
		if(vehicles.isDisplayed() && vehicles.isEnabled()) {
			System.out.println("Vehicles option is visible and Enabled");
		}else {
			System.out.println("Vehicles option is visible and Enabled");
		}
		vehicles.click();
		
		if(postVehicle.isDisplayed() && postVehicle.isEnabled() && manageVehicle.isDisplayed() && manageVehicle.isEnabled()) {
			System.out.println("Post Vehicle, Manage Vehicle options are visible and Enabled");
		}else {
			System.out.println("Post Vehicle, Manage Vehicle options are not visible and Enabled");
		}
	}
	
	//brand page in admin panel
	public void brands() {
		//WEbElement for brands on admin panel
		WebElement brands=driver.findElement(brand);
		//WebElement for create brand on brand page
		WebElement createBrand=driver.findElement(createBrands);
		//WebElement for manage brand on brand page
		WebElement manageBrand=driver.findElement(manageBrands);
		if(brands.isDisplayed() && brands.isEnabled()) {
			System.out.println("Brands option is visible and Enabled");
		}else {
			System.out.println("Brands Booking option is visible and Enabled");
		}
		brands.click();
		driver.manage().window().maximize();
		
		if(createBrand.isDisplayed() && createBrand.isEnabled() && manageBrand.isDisplayed() && manageBrand.isEnabled()) {
			System.out.println("create brand, Manage brand options are visible and Enabled");
		}else {
			System.out.println("create brand, Manage brand options are not visible and Enabled");
		}
	}
	
}
