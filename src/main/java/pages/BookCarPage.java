package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BookCarPage {
	
	WebDriver driver;
	By car_List=By.xpath("//*[@id=\"navigation\"]/ul/li[3]/a");
	By search_Car=By.xpath("/html/body/section[2]/div/div/aside/div[1]/div[2]/form/div[3]/button");
	By book_Now=By.xpath("/html/body/section[2]/div/div[2]/aside/div[2]/form/div[4]/input");
	By book_Car_View_Details=By.xpath("/html/body/section[2]/div/div/div/div[2]/div[2]/a");
	By book_Car_Fromdate=By.name("fromdate");
	By book_Car_Todate=By.name("todate");
	By book_Car_Msg=By.name("message");
	
	
	
	public BookCarPage (WebDriver driver) {
		this.driver = driver;
		}
		
	
	public void clickCarListingbtn() {
		driver.findElement(car_List).click();
		
	}
	
	public void selectCarAndFuel() {
		 //select BMW from brand dropdown list
		 Select drpBrand= new Select(driver.findElement(By.name("brand")));
		 drpBrand.selectByVisibleText("BMW");
		 
		 //select fuel from fuel dropdown list
		 Select drpFuel = new Select(driver.findElement(By.name("fueltype")));
		 drpFuel.selectByIndex(3);
		 
	}
	
	public void clickSearchCar() {
		driver.findElement(search_Car).click();
		
	}
	
	
	public void clickBookNow() {
		driver.findElement(book_Now).click();
		
	}
	
	
	public void clickViewDetails() {
		driver.findElement(book_Car_View_Details).click();
		
	}
	
	public void enterFromdate(String arg1) {
		driver.findElement(book_Car_Fromdate).sendKeys(arg1);
		}
	
	
	public void enterTodate(String arg1) {
		driver.findElement(book_Car_Todate).sendKeys(arg1);
		}
	
	
	public void enterMessage(String arg1) {
		driver.findElement(book_Car_Msg).sendKeys(arg1);
		}


	public void validateBookCarWithoutLogin() {
		 String textofbtn=driver.findElement(By.xpath("/html/body/section[2]/div/div[2]/aside/div[2]/form/a")).getText();
		 assertEquals("LOGIN FOR BOOK",textofbtn);
		 driver.findElement(By.xpath("/html/body/section[2]/div/div[2]/aside/div[2]/form/a")).click();		
	}


	public void validateBookCarSuccessfully() {
		 Alert alert=driver.switchTo().alert();
			String alertMessage=driver.switchTo().alert().getText();
			assertEquals("Booking successfull.",alertMessage);		
	}
		
	
	
	
}
