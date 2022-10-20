package org.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testing {
	
	public static WebDriver driver;
	
	@BeforeSuite
	private void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://adactinhotelapp.com/");
	}
	
	@BeforeTest
	private void LoginDetails() {
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("Balaji0601");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("balaji2002");
	}
	
	@BeforeClass
	private void login() {
		WebElement login = driver.findElement(By.id("login"));
		login.click();
	}
	
	@BeforeMethod
	private void hotelCredentials() {
		WebElement location = driver.findElement(By.name("location"));
		location.sendKeys("London");
		
		WebElement hotels = driver.findElement(By.name("hotels"));
		hotels.sendKeys("Hotel Sunshine");

		WebElement roomType = driver.findElement(By.id("room_type"));
		roomType.sendKeys("Double");
		
		WebElement numberOfRooms = driver.findElement(By.id("room_nos"));
		numberOfRooms.sendKeys("5");
		
		WebElement checkIn = driver.findElement(By.name("datepick_in"));
		checkIn.sendKeys("10/10/2022");
		
		WebElement checkOut = driver.findElement(By.name("datepick_out"));
		checkOut.sendKeys("11/10/2022");
	
		WebElement adultsPerRoom = driver.findElement(By.id("adult_room"));
		adultsPerRoom.sendKeys("5");
		
		WebElement childrenPerRoom = driver.findElement(By.name("child_room"));
		childrenPerRoom.sendKeys("3");
		
		WebElement search = driver.findElement(By.name("Submit"));
		search.click();
	}
	
	@Test
	private void search() {
		WebElement radioButton = driver.findElement(By.id("radiobutton_0"));
		radioButton.click();
		
		WebElement Continue = driver.findElement(By.id("continue"));
		Continue.click();
	}
	
	@AfterMethod
	private void bookingHotels() {
		WebElement firstName = driver.findElement(By.name("first_name"));
		firstName.sendKeys("Balaji");
		
		WebElement lastName = driver.findElement(By.name("last_name"));
		lastName.sendKeys("P");
		
		WebElement billingAddress = driver.findElement(By.name("address"));
		billingAddress.sendKeys("Chennai");

		WebElement creditCardNo = driver.findElement(By.id("cc_num"));
		creditCardNo.sendKeys("1600200215992012");
		
		WebElement cardType = driver.findElement(By.name("cc_type"));
		cardType.sendKeys("VISA");
				
		WebElement expiryMonth = driver.findElement(By.name("cc_exp_month"));
		expiryMonth.sendKeys("December");
		
		WebElement expiryYear = driver.findElement(By.name("cc_exp_year"));
		expiryYear.sendKeys("2022");
		
		WebElement ccvNo = driver.findElement(By.id("cc_cvv"));
		ccvNo.sendKeys("567");
	}
	
	@AfterClass
	private void  booking() {
		WebElement bookNow = driver.findElement(By.id("book_now"));
		bookNow.click();
	}
	
	@AfterTest
	private void printId() throws InterruptedException { 
	   Thread.sleep(5000);
	   WebElement orderNo = driver.findElement(By.name("order_no"));
	   String attribute = orderNo.getAttribute("value");
       System.out.println("ORDER ID NUMBER :" + attribute);
	}
	
	@AfterSuite
	private void quit() {
		driver.close();
		driver.quit();
	}
	
}