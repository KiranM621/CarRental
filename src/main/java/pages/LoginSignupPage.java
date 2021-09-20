package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSignupPage {

	WebDriver driver;

	// Login/Register Button
	By login_Signup=By.xpath("//a[contains(@class,'btn btn-xs uppercase')]");
	// Email_Id on login form
	By user_Name = By.name("email");	
	// Password on login form
	By password = By.name("password"); 
	// login button on login page
	By login_Button = By.xpath("//input[contains(@name,'login')]");  

	// sign up password field 
	By signup_Password = By.xpath("//*[@id=\"signupform\"]/div/div/div[2]/div/div/div/form/div[4]/input");
	
	// confirmPassword filed on confirm Password
	By signup_Confirm_Password = By.xpath("(//input[@name='confirmpassword'])");
	
	// signup link login page
	By sign_Up= By.linkText("Signup Here");
	// fullname field on signup page
	By sign_Up_Fullname=By.name("fullname");
	// contact number field on signup page
	By sign_Up_Mob=By.name("mobileno");
	// email field on signup ppage
	By sign_Up_Email=By.id("emailid");
	// signup button on signup page
	By submit = By.xpath("//*[@id=\"submit\"]");

	// forgot password link on login page.
	By forgot_Password = By.linkText("Forgot Password ?");
	
	
	public LoginSignupPage (WebDriver driver) {
		this.driver = driver;
		}

		public void clickOnLoginSignup() {
		driver.findElement(login_Signup).click();
		}

		public void setLoginUserName(String name) {
			driver.findElement(user_Name).sendKeys(name);
			}
		
		public void setLoginPasswrod(String new_Password) {
		driver.findElement(password).sendKeys(new_Password);
		}
		
		public void setSignupUserName(String name) {
			driver.findElement(sign_Up_Fullname).sendKeys(name);
			}

		public void clickOnLogin() {
			driver.findElement(login_Button).click();
			}
		
		public void setSignupPasswrod(String new_Password) {
		driver.findElement(signup_Password).sendKeys(new_Password);
		}
		public void setSignupConfirmPassword(String password) {
		driver.findElement(signup_Confirm_Password).sendKeys(password);
		}
		
		public void clickOnSignup() {
		driver.findElement(sign_Up).click();
		}

		
		public void setSignupUserNumber(String number) {
		driver.findElement(sign_Up_Mob).sendKeys(number);
		}

		public void setSignupUserEmail(String email) {
			driver.findElement(sign_Up_Email).sendKeys(email);
		}
		
		public void clickOnForgotPassword() {
			driver.findElement(forgot_Password).click();
		}
		
		public void clickOnSignup_Button() {
		driver.findElement(submit).click();

		 }
		
		
		
		//GUI
		//1]For User Login
	public void loginRegistrationbtn() {
		//WebElemnt for loginReg button on home page
		WebElement loginRegbtn =driver.findElement(login_Signup);
		if(loginRegbtn.isEnabled() &&loginRegbtn.isDisplayed())
		{
			System.out.println("--Login/Registration button is Enabled and Visible--");
		}else{
			System.out.println("--Login/Registration button is Not Enabled and Visible--");
		}
		loginRegbtn.click();
			System.out.println("--LoginRegistration Button is Clicked--");
	}
	
	//enter user name on login page
	public void enterUserName(){
		//WebElemnt for enter user name on login page
		WebElement enterUserName =driver.findElement(user_Name);
		if(enterUserName.isEnabled() &&enterUserName.isDisplayed())
		{
			System.out.println("1]EnterUserName button is Enabled and Visible");
		}else{
			System.out.println("2]EnterUserName button is Not Enabled and Visible");
		}
		enterUserName.click();
	}
	
	//enter password on login page
	public void enterPasswrod() {
		//WebElemnt for enter password on login page
		WebElement enterPasswrod =driver.findElement(password);
		if(enterPasswrod.isEnabled() &&enterPasswrod.isDisplayed())
		{
			System.out.println("2]EnterPasswrod button is Enabled and Visible");
		}else{
			System.out.println("2]EnterPasswrod button is Not Enabled and Visible");
		}
		enterPasswrod.click();
	}
	
	//login button on login page
	public void login() {
		//WebElemnt for login button on login page
		WebElement login=driver.findElement(login_Button);
		if(login.isEnabled() &&login.isDisplayed())
		{
			System.out.println("--Login Button is Enabled and Visible--");
		}else{
			System.out.println("--login button is Not Enabled and Visible--");
		}
		login.click();
	}
	
		//2]For SignUp
	public void signUpForNew() {
		//WebElemnt for sign for new on login page
		WebElement signUpForNew =driver.findElement(sign_Up);
		if(signUpForNew.isEnabled() &&signUpForNew.isDisplayed())
		{
			System.out.println("--signUpForNew button is Enabled and Visible--");
		}else{
			System.out.println("--signUpForNew button is Not Enabled and Visible--");
		}
		signUpForNew.click();
	}
	
	//full name on signup page
	public void fullname () {
		//WebElement for full name on signup page
		WebElement fullname =driver.findElement(sign_Up_Fullname);
		if(fullname.isEnabled() &&fullname.isDisplayed())
		{
			System.out.println("1]FullName Button is Enabled and Visible");
		}else{
			System.out.println("1]FullName Button is Not Enabled and Visible");
		}
		fullname.click();
	}
	
	//mobile number on signup page
	public void mobileNumber() {
		//WebElement for Mobile number on signup page
		WebElement mobno =driver.findElement(sign_Up_Mob);
		if(mobno.isEnabled() &&mobno.isDisplayed())
		{
			System.out.println("2]MobileNo. Button is Enabled and Visible");
		}else{
			System.out.println("2]MobileNo. Button is Not Enabled and Visible");
		}
		mobno.click();
	}
	
	//Email on signup page
	public void emailid() {
		//WebElement for Email on signup page
		WebElement emailid =driver.findElement(sign_Up_Email);
		if(emailid.isEnabled() &&emailid.isDisplayed())
		{
			System.out.println("3]Email-ID Button is Enabled and Visible");
		}else{
			System.out.println("3]Email-ID Button is Not Enabled and Visible");
		}
		emailid.click();
	}
	
	//password on signup page
	public void passWord() {
		//WebElement for password on signup page
		WebElement password =driver.findElement(signup_Password);
		if(password.isEnabled() &&password.isDisplayed())
		{
			System.out.println("4]Password Button is Enabled and Visible");
		}else{
			System.out.println("4]Password Button is Not Enabled and Visible");
		}
		password.click();
	}
		
	//confirm password on signup page
	public void confirmPassword() {
		//WebElement for confirm password on signup page
		WebElement confirmpass =driver.findElement(signup_Confirm_Password);
		if(confirmpass.isEnabled() &&confirmpass.isDisplayed())
		{
			System.out.println("5]ConfirmPassword Button is Enabled and Visible");
		}else{
			System.out.println("5]ConfirmPassword Button is Not Enabled and Visible");
		}
		confirmpass.click();
	}
	
	//signup button on sign up page
	public void signup(){
		//WebElement for signup button on sign up page
		WebElement signup =driver.findElement(submit);
		if(signup.isEnabled() &&signup.isDisplayed())
		{
			System.out.println("--SignUp Button is Enabled and Visible--");
		}else{
			System.out.println("--SignUpButton is Not Enabled and Visible--");
		}
		signup.click();
	}
	

}
