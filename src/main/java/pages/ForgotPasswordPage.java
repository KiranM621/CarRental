package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
	
	WebDriver driver = null;
	
	//Click On Forget Password
	By forget_Password=By.xpath("//*[@id=\"loginform\"]/div/div/div[3]/p[2]/a");
	// Email field on forgot password page
	By user_Email =  By.xpath("//*[@id=\"forgotpassword\"]/div/div/div[2]/div/div/div/form/div[1]/input");
	// Contact Number field on forgot password page
	By user_Number = By.xpath("(//input[@name='mobile'])");
	// New Password field on forgot password page
	By user_NewPassword = By.xpath("(//input[@name='newpassword'])");
	// Confirm Password field on forgot password page
	By user_ConfirmPassword = By.xpath("//*[@id=\"forgotpassword\"]/div/div/div[2]/div/div/div/form/div[4]/input");
	// ResetPassword button on forgot password page
	By reset_Password = By.xpath("//*[@id=\"forgotpassword\"]/div/div/div[2]/div/div/div/form/div[5]/input");
	//Back to Login button on forgot password page
	By back_TO_Login= By.xpath("//*[@id=\"forgotpassword\"]/div/div/div[2]/div/div/div/div/p[2]/a");
	
	public ForgotPasswordPage(WebDriver driver) { 
		
		this.driver = driver;
		
	}
	
	public void setUserEmail(String email) { 
		
		driver.findElement(user_Email).sendKeys(email);
		
	}
	
	public void setUserNumber(String number) { 
		
		driver.findElement(user_Number).sendKeys(number);

		
	}
	
	public void setNewPassword(String password) { 
		
		driver.findElement(user_NewPassword).sendKeys(password);

		
	}
	
	public void setConfirmPassword(String password) { 
		
		driver.findElement(user_ConfirmPassword).sendKeys(password);

		
	}
	
	public void clickOnReset() { 
		
		driver.findElement(reset_Password).click();
	}
	
	
	//GUI 
	
	public void forgetPassWord(){
		    WebElement forgetpassword =driver.findElement(forget_Password);
			if(forgetpassword.isEnabled() &&forgetpassword.isDisplayed())   
			   {
		        System.out.println("--ForgetPassword Button is Enabled and Visible--");
			   }else{
			   System.out.println("--ForgetPassword is Not Enabled and Visible--");
			   
		}
			forgetpassword.click();
    }
	
	 public void userEmailId(){
		    WebElement useremailID=driver.findElement (user_Email);
			if(useremailID.isEnabled())
			   {
		        System.out.println("1]Your Email Address Button is Enabled and Visible");
			   }else{
			   System.out.println("1]Your Email Address is Not Enabled and Visible");
			   
		}
			useremailID.click();
	 }	
	 
	 public void regMobNo(){
		    WebElement regmobno =driver.findElement(user_Number);
			if(regmobno.isEnabled() &&regmobno.isDisplayed())   
			   {
		        System.out.println("2]Register Mobile No.Button is Enabled and Visible");
			   }else{
			   System.out.println("2]Register Mobile No.Button is Not Enabled and Visible");
			   
		}
			regmobno.click();
	 }	
	 
	 public void newPassword() {
		    WebElement newpass =driver.findElement(user_NewPassword);
			if(newpass.isEnabled() &&newpass.isDisplayed())   
			   {
		        System.out.println("3]NewPassword Button is Enabled and Visible");
			   }else{
			   System.out.println("3]NewPassword Button is Not Enabled and Visible");
			   
		}
			newpass.click();
	 }	
	 public void confPassword() {
		    WebElement confpassword =driver.findElement(user_ConfirmPassword);
			if(confpassword.isEnabled() &&confpassword.isDisplayed())   
			   {
		        System.out.println("4]ConfirmPassword Button is Enabled and Visible");
			   }else{
			   System.out.println("4]ConfirmPassword Button is Not Enabled and Visible");
			   
		}
			confpassword.click();
	 }	
	 
	 public void resetPassWord(){
		    WebElement resetpassword =driver.findElement(reset_Password);
			if(resetpassword.isEnabled() &&resetpassword.isDisplayed())   
			   {
		        System.out.println("--ResetPassWord Button is Enabled and Visible--");
			   }else{
			   System.out.println("--ResetPassWord is Not Enabled and Visible--");
		}
			resetpassword.click();
	 }	
	 
	 public void backToLogin(){
		    WebElement backtoLog=driver.findElement(back_TO_Login);
			if(backtoLog.isEnabled() &&backtoLog.isDisplayed())   
			   {
		        System.out.println("--Back-To-Login Button is Enabled and Visible--");
			   }else{
			   System.out.println("--Back-To-Login is Not Enabled and Visible--");
			   
		}
			backtoLog.click();
	 }	

}

