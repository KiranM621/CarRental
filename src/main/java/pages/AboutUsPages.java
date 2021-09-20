package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutUsPages {
	private static WebDriver driver=null;
	
	//About us option on home page
	By aboutUs = By.xpath("//a[@href='page.php?type=aboutus']");
	//About us heading
	By aboutHeading = By.xpath("//div[@class='page-heading']/h1");
	
	//Constructor of class 
	public AboutUsPages(WebDriver driver) {
		this.driver=driver;
	}
	
	//To check About us option is visible and enable on home page
	public void pageAboutUs() {	
		// webElement for aboutus option on home page
		WebElement aboutus=driver.findElement(aboutUs);

		if(aboutus.isEnabled() && aboutus.isDisplayed()) {
			System.out.println("About Us button is enabled and visible");
		}else {
			System.out.println("About Us button is not enabled and visible");
		}
		driver.findElement(aboutUs).click();
	}
	
	
	// Check the heading of About us page
	public void pageAboutHeading() {
		//WebElement of Heading in about us page
		WebElement aboutusHeading=driver.findElement(aboutHeading);
		if(aboutusHeading.isDisplayed()) {
			System.out.println("In About Us page heading is visible.");
		}else {
			System.out.println("In About Us page heading is not visible");
		}
	}

}


	
	


