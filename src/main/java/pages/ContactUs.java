package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUs {
 
	WebDriver driver;
	
	//contact us btn
	By contactus=By.xpath("//*[@id=\"navigation\"]/ul/li[5]/a");
	//contact us fullname textbox
	By contactus_Fullname=By.id("fullname");
	//contact us email textbox
	By contactus_Email=By.name("email");
	//contact us mobile number textbox
	By contactus_Mob=By.id("phonenumber");
	//contact us message textbox
	By contactus_Msg=By.name("message");
	//contact us send btn
	By contactus_send=By.name("send");
	
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
		driver.findElement(contactus_Email).sendKeys(arg1);
		
	}
	
	public void contactusEnteremail(String arg1) {
		driver.findElement(contactus_Mob).sendKeys(arg1);
	}
	
	public void contactusMessage(String arg1) {
		driver.findElement(contactus_Msg).sendKeys(arg1);
	}
	
	public void clickOnsend() {
		driver.findElement(contactus_send).click();
	}
	
}
