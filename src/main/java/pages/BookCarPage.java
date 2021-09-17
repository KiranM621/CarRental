package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BookCarPage {
	
	WebDriver driver;
	//Home page car list button 
	By car_List=By.xpath("//*[@id=\"navigation\"]/ul/li[3]/a");
	
	//car brand dropdown list
	By brand=By.name("brand");
	//fuel type dropdown list
	By fuel=By.name("fueltype");
	//search car button in carlist
	By search_Car=By.xpath("/html/body/section[2]/div/div/aside/div[1]/div[2]/form/div[3]/button");
	
	// view details btn 
	By book_Car_View_Details=By.xpath("/html/body/section[2]/div/div/div/div[2]/div[2]/a");

	//from date text box
	By book_Car_Fromdate=By.name("fromdate");
	//todate textbox
	By book_Car_Todate=By.name("todate");
	//message textbox
	By book_Car_Msg=By.name("message");
	
	//book now button
	By book_Now=By.xpath("/html/body/section[2]/div/div[2]/aside/div[2]/form/div[4]/input");
	
	
	
	
	public BookCarPage (WebDriver driver) {
		this.driver = driver;
		}
		
	
	public void clickCarListingbtn() {
		driver.findElement(car_List).click();
		
	}
	
	public void selectCarAndFuel() {
		 //select BMW from brand dropdown list
		 Select drpBrand= new Select(driver.findElement(brand));
		 drpBrand.selectByVisibleText("BMW");
		 
		 //select fuel from fuel dropdown list
		 Select drpFuel = new Select(driver.findElement(fuel));
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


			
	
	
	
}
