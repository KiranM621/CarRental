package test.usersignupui;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginSignupPage;
import pages.ForgotPasswordPage;
import utilities.PropertyReader;

public class ForgotPassword {
	WebDriver driver;
	JavascriptExecutor js;
	String driverPath = null;
	String home_URL;//userEmailId,regmobno,newPass,newConPass;


	@BeforeMethod
	public void beforeMethod() throws InterruptedException, IOException {
		driverPath = PropertyReader.getProperty("Chrome_Driver_Path");
		home_URL=PropertyReader.getProperty("home_URL");

		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
	}
	
	@Test(priority=1,description="Testing forget password page")
	public void forgetPass() throws InterruptedException {
		driver.get(home_URL);//getURL
		Thread.sleep(2000);
		LoginSignupPage objLoginSignupPage= new LoginSignupPage(driver);

		ForgotPasswordPage forgotPasswordPageObject=new ForgotPasswordPage(driver);

		//Referencing from ForgotPasswordPage
		//click on login/signup btn
		objLoginSignupPage.clickOnLoginSignup();

		Thread.sleep(2000);

		//Click on ForgetPasssword
		forgotPasswordPageObject.forgetPassWord();

		driver.manage().window().maximize();

		//EnterEmailid
		forgotPasswordPageObject.userEmailId();

		//Enter Register Mob.No
		forgotPasswordPageObject.regMobNo();

		//Enter New Pass
		forgotPasswordPageObject.newPassword();

		//Enter ConfirmPass
		forgotPasswordPageObject.confPassword();


		//Click On ResetPassword
		forgotPasswordPageObject.resetPassWord();

		//Click On Back TO Login
		forgotPasswordPageObject.backToLogin();
	}

}
