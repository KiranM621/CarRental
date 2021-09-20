package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePage {
	
	WebDriver driver;
    
	//Home page car list btn
	By car_List=By.xpath("//*[@id=\"navigation\"]/ul/li[3]/a");
	
	//my profile btn
	By homePage_Profile=By.xpath("//*[@id=\"navigation_bar\"]/div/div[2]/div[1]/ul/li/a");
	//my booking under my profile
	By homePage_MyBooking=By.xpath("//*[@id=\"navigation_bar\"]/div/div[2]/div[1]/ul/li/ul/li[3]/a");
	//Home logo
	By logo=By.xpath("//img[@src='assets/images/logg.png']");
	//Home Heading
	By homePageHeading=By.xpath("//*[@id=\"banner\"]/div/div/div/div/div/h1");
	// Search box in home page
	By searchBox=By.xpath("//input[@class='form-control'][@placeholder='Search...']");
	//Dropdown option in home page
	By dropDown=By.className("dropdown");
	// profile setting option in dropdown Home page
	By profileSettings1=By.xpath("//*[@id=\"navigation_bar\"]/div/div[2]/div[1]/ul/li/ul/li[1]/a");
	//update passwors option in dropdown Home page
	By updatePassword1=By.xpath("//*[@id=\"navigation_bar\"]/div/div[2]/div[1]/ul/li/ul/li[2]/a");
	// my booking option in dropdown Home page
	By myBooking1=By.xpath("//*[@id=\"navigation_bar\"]/div/div[2]/div[1]/ul/li/ul/li[3]/a");
	// post testimonial option in dropdown Home page
	By postATestimonial1=By.xpath("//*[@id=\"navigation_bar\"]/div/div[2]/div[1]/ul/li/ul/li[4]/a");
	//my testimonial option in dropdown Home page
	By myTestimonial1=By.xpath("//*[@id=\"navigation_bar\"]/div/div[2]/div[1]/ul/li/ul/li[5]/a");
	//sign out option in dropdown Home page
	By signOut1=By.xpath("//*[@id=\"navigation_bar\"]/div/div[2]/div[1]/ul/li/ul/li[6]/a");
	// color changer option in home page
	By  colorChanger=By.xpath("//div[@class='demo-icon customBgColor']");
	//red color in color changer
	By redColor=By.xpath("//a[@href='#'][@data-switchcolor='red']");
	//orange color in color changer
	By orangeColor=By.xpath("//a[@href='#'][@data-switchcolor='orange']");
	//blue color in color changer
	By blueColor=By.xpath("//a[@href='#'][@data-switchcolor='blue']");
	//pink color in color changer
	By pinkColor=By.xpath("//a[@href='#'][@data-switchcolor='pink']");
	//green color in color changer
	By greenColor=By.xpath("//a[@href='#'][@data-switchcolor='green']");
	//purple color in color changer
	By purpleColor=By.xpath("//a[@href='#'][@data-switchcolor='purple']");
	
	
	public HomePage (WebDriver driver) {
		this.driver = driver;
		}
	
	
	
	
	public void clickOnprofile() {
		driver.findElement(homePage_Profile).click();
	}
	
	
	public void clickOnMyBooking() {
		driver.findElement(homePage_MyBooking).click();
	}
	
	//Check the Title of Home Page
		public void testPageTitle() {
			String title=driver.getTitle();
			String expectedTitle="Car Rental Portal";
			Assert.assertEquals(title,expectedTitle); 	
		}
		
		//Check the Logo of Home Page
		public void testPageLogo() {
			WebElement logoTest=driver.findElement(logo);
			Boolean imagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", logoTest);
			if(!imagePresent) {
				System.out.println("Logo is not Visible");	
			}else {
				System.out.println("Logo is Visible");
			}
			
		}
		
		//Check the Heading of Home Page
		public void testPageHeading() {
			String expectedHeading="FIND THE RIGHT CAR FOR YOU.";
			String heading=driver.findElement(homePageHeading).getText();
			if(expectedHeading.contentEquals(heading)) {
				System.out.println("Heading Matched");
			}else {
				System.out.println("Heading not Matched");
			}
		}
		
		//Check  the Search box on Home Page
		public void testSearchBox() {
			boolean eleDisplay=driver.findElement(searchBox).isDisplayed();
			System.out.println("SearchBox Visible is "+eleDisplay);
			boolean eleEnable=driver.findElement(searchBox).isEnabled();
			System.out.println("SearchBox enable is "+eleEnable);
		}
		
		//Check the color of Heading
		public void testHeadingColor() {
		      String errorColor = "#ffffff";
			  WebElement heading = driver.findElement(homePageHeading); 
			  String fontColor = heading.getCssValue("color"); 
			  String hexColorValue = Color.fromString(fontColor).asHex();
		      Assert.assertEquals(hexColorValue, errorColor);	      

		}
		
		//Check the Scroll bar 
		public void scrollBar() {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,1000)");

		}
		
		//Check the DropDown option in Home Page
		public void testDropdown()  {
			WebElement dropdown = driver.findElement(dropDown);
			dropdown.click();
			if(dropdown.isEnabled() && dropdown.isDisplayed()) 
			   { 
			      System.out.println("Dropdown button is enabled and visible"); 
			   } 
			  else { 
			      System.out.println("Dropdown button is not visible"); 
			  } 
		}
		
		// test list in dropdown 
		public void testDropdownList() {
			WebElement profileSettings=driver.findElement(profileSettings1);
			WebElement updatePassword=driver.findElement(updatePassword1);
			WebElement myBooking=driver.findElement(myBooking1);
			WebElement postATestimonial=driver.findElement(postATestimonial1);
			WebElement myTestimonial=driver.findElement(myTestimonial1);
			WebElement signOut=driver.findElement(signOut1);
			if(profileSettings.isEnabled() && profileSettings.isDisplayed() && updatePassword.isEnabled() && updatePassword.isDisplayed() && myBooking.isEnabled() && myBooking.isDisplayed() && postATestimonial.isEnabled() && postATestimonial.isDisplayed() && myTestimonial.isEnabled() && myTestimonial.isDisplayed() && signOut.isEnabled() && signOut.isDisplayed()) 
			{
				System.out.println("All List in Dropdown is enabled and visible");
			}
			else { 
			      System.out.println("All List in Dropdown is not visible"); 
			}
		}
		
		// Check the color changer option
		public void testColorChanger() {
			WebElement colorChange=driver.findElement(colorChanger);
			if(colorChange.isDisplayed() && colorChange.isEnabled()) {
				System.out.println("Color changer is Visible And Enabled");
			}else {
				System.out.println("Color changer is not Visible And Enabled");
			}
			colorChange.click();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		}
		
		//test colors in color changer
		public void testColors() {
			WebElement red=driver.findElement(redColor);
			WebElement orange=driver.findElement(orangeColor);
			WebElement blue=driver.findElement(blueColor);
			WebElement pink=driver.findElement(pinkColor);
			WebElement green=driver.findElement(greenColor);
			WebElement purple=driver.findElement(purpleColor);
			
			if(red.isEnabled() && orange.isEnabled() && blue.isEnabled() && pink.isEnabled() && green.isEnabled() && purple.isEnabled()) {
				System.out.println("All color buttons are Enabled");
			}else {
				System.out.println("Not Enabled");
			}
		}
	

}
