package test.seleniumgrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginSignupPage;
import utilities.PropertyReader;

public class SeleniumGrid {
	 WebDriver driver;
	     LoginSignupPage objLoginSignupPage ;
	 	
		 JavascriptExecutor js;
		String driverPath = null;
		String home_URL,user_Email,user_Password,wrong_Password,nodeURL;
		
	     @BeforeTest
	     public void setUp() throws MalformedURLException {
	 		user_Email=PropertyReader.getProperty("user_Email");
	 		user_Password=PropertyReader.getProperty("user_Password");
	 		home_URL=PropertyReader.getProperty("home_URL");
	       
	 		 nodeURL = "http://192.168.93.121:4444/wd/hub";
	 		 DesiredCapabilities capability = DesiredCapabilities.chrome();
	         capability.setBrowserName("chrome");
	         capability.setPlatform(Platform.WINDOWS);
	         driver = new RemoteWebDriver(new URL(nodeURL), capability);	
				
	     }

	     @Test
	     public void sampleTest() throws MalformedURLException, InterruptedException {
	       
	 		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	 		
	         driver.get(home_URL);
	 		//Referencing from LoginSignupPage
	         objLoginSignupPage=new LoginSignupPage(driver);
	         Thread.sleep(4000);
	 		objLoginSignupPage.clickOnLoginSignup();
	 		driver.manage().window().maximize();
	 		 Thread.sleep(4000);
	 		objLoginSignupPage.setLoginUserName(user_Email);
	 		objLoginSignupPage.setLoginPasswrod(user_Password);
	 		 Thread.sleep(4000);
	 	   	objLoginSignupPage.clickOnLogin();
	 	   Thread.sleep(4000);
	         

	        

	     }
	     

	     @AfterTest
	     public void afterTest() {
	        // driver.quit();
	     }

	 }

