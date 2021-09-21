package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ContactUs {
 
	WebDriver driver;
	
	//contact us btn
	By contactus=By.xpath("//*[@id=\"navigation\"]/ul/li[5]/a");
	//contact us fullname textbox
	By contactus_Fullname=By.xpath("//*[@id=\"fullname\"]");
	//contact us email textbox
	By contactus_Email=By.xpath("//*[@id=\"emailaddress\"]");
	//contact us mobile number textbox
	By contactus_Mob=By.xpath("//*[@id=\"phonenumber\"]");
	//contact us message textbox
	By contactus_Msg=By.xpath("/html/body/section[2]/div/div/div[1]/div/form/div[4]/textarea");
	//contact us send btn
	By contactus_send=By.xpath("//button[@name='send']");
	// Contact us page heading
	By contactHeading=By.xpath("/html/body/section[1]/div[1]/div/div/h1");

	
	public ContactUs(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public void clickContactus() {
		driver.findElement(contactus).click();

	}
	
	public void contactusEnterfullname(String arg1) {
		driver.findElement(contactus_Fullname).sendKeys(arg1);
	}
	
	public void contactusEnterphone(String arg1) {
		driver.findElement(contactus_Mob).sendKeys(arg1);
		
	}
	
	public void contactusEnteremail(String arg1) {
		driver.findElement(contactus_Email).sendKeys(arg1);
	}
	
	public void contactusMessage(String arg1) {
		driver.findElement(contactus_Msg).sendKeys(arg1);
	}
	
	public void clickOnsend() {
		driver.findElement(contactus_send).click();
	}
	

	//Contact us option on home page and check heading of contact us page
		public void pageContactUs() {
			//WebElement for contact us option on home page
			WebElement contactUs1=driver.findElement(contactus);
			if(contactUs1.isEnabled() && contactUs1.isDisplayed()) {
				System.out.println("ContactUs button is enabled and visible");
			}else {
				System.out.println("ContactUs button is not enabled and visible");
			}
			contactUs1.click();
			
			//WebElement for heading in contact page
			WebElement contactHeading1=driver.findElement(contactHeading);

			if(contactHeading1.isDisplayed()) {
				System.out.println("Heading is Display properly in Contact Us Page");
			}
			
		}
		
		//Check all feilds of contact us page
		public void contactUsPageFeilds() {
			// WebElement for full name on contactus page
			WebElement fullName=driver.findElement(contactus_Fullname);
			// WebElement for Email on contactus page
			WebElement emailAdd=driver.findElement(contactus_Email);
			// WebElement for phone number on contactus page
			WebElement phoneNum=driver.findElement(contactus_Mob);
			// WebElement for message on contactus page
			WebElement message=driver.findElement(contactus_Msg);
			// WebElement for submit button on contactus page
			WebElement submit=driver.findElement(contactus_send);


			if(fullName.isDisplayed() && emailAdd.isDisplayed() && phoneNum.isDisplayed() && message.isDisplayed() && submit.isDisplayed()) {
				System.out.println("All TextBox and Button Are Visible");
			}else {
				System.out.println("TextBox Are not Visible");
			}
		
			if(fullName.isEnabled() && emailAdd.isEnabled() && phoneNum.isEnabled() && message.isEnabled() && submit.isEnabled()) {
				System.out.println("All TextBox and Button Are Enabled");
			}else {
				System.out.println("TextBox Are not isEnabled");
			}
		}
		
}
