package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutUsPages {
	private static WebDriver driver=null;
	By aboutUs = By.xpath("//a[@href='page.php?type=aboutus']");
	By aboutHeading = By.xpath("//div[@class='page-heading']/h1");
	
	public AboutUsPages(WebDriver driver) {
		this.driver=driver;
	}
	
	public void pageAboutUs() {	
		WebElement aboutus=driver.findElement(aboutUs);

		if(aboutus.isEnabled() && aboutus.isDisplayed()) {
			System.out.println("About Us button is enabled and visible");
		}else {
			System.out.println("About Us button is not enabled and visible");
		}
		driver.findElement(aboutUs).click();
	}
	
	public void pageAboutHeading() {
		WebElement aboutusHeading=driver.findElement(aboutHeading);
		if(aboutusHeading.isDisplayed()) {
			System.out.println("In About Us page heading is visible.");
		}else {
			System.out.println("In About Us page heading is not visible");
		}
	}

}


	
	


