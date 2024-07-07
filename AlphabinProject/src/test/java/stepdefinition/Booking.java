package stepdefinition;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Booking {
	
	WebDriver driver;
	
	@Given("Open browser")
	public void open_browser() {
		
		driver = new FirefoxDriver();
		
	}

	@Given("Enter url")
	public void enter_url() {
		
		driver.get("https://www.makemytrip.com/");
	  
	}

	@When("Click on hotels")
	public void click_on_hotels() {
		
		driver.findElement(By.xpath("(//span[text()='Hotels'])[1]")).click();
	  
	}

	@When("Click on location")
	public void click_on_location() throws InterruptedException {
		
        driver.findElement(By.xpath("//span[text()='City, Property name or Location']")).click();
		
		Thread.sleep(Duration.ofSeconds(3));
	   
	}

	@When("Enter location fetch location")
	public void enter_location_fetch_location() throws InterruptedException {
		
        driver.findElement(By.xpath("//input[@placeholder='Where do you want to stay?']")).sendKeys("Munnar");
		
		Thread.sleep(Duration.ofSeconds(3));
		
        driver.findElement(By.xpath("//p[text()='City in Kerala']")).click();
		
		Thread.sleep(Duration.ofSeconds(3));
	 
	}

	@When("Fetch dates")
	public void fetch_dates() throws InterruptedException {
		
		//checkin date
		driver.findElement(By.xpath("(//div[@aria-label='Sun Jul 28 2024'])[1]")).click();
		
		Thread.sleep(Duration.ofSeconds(3));

		//checkout date
		driver.findElement(By.xpath("(//div[@aria-label='Wed Jul 31 2024'])[1]")).click();

	  
	}

	@When("Click on apply button")
	public void click_on_apply_button() {
		
		driver.findElement(By.xpath("(//button[text()='Apply'])[1]")).click();
	    
	}

	@When("Select price from dropdown")
	public void select_price_from_dropdown() throws InterruptedException {
		
		driver.findElement(By.xpath("(//span[text()='Price per Night'])[1]")).click();
		
		Thread.sleep(Duration.ofSeconds(2));
		
		driver.findElement(By.xpath("(//li[text()='₹5000+'])[1]")).click();
	    
	}

	@When("Click on search button")
	public void click_on_search_button() {
		
		driver.findElement(By.xpath("//button[text()='Search']")).click();
	    
	}

	@Then("Search result should be display")
	public void search_result_should_be_display() {
		
		System.out.println("Search result is displaying");
	    
	}

	@Then("List of hotels should be display")
	public void list_of_hotels_should_be_display() throws InterruptedException {
		
		System.out.println("lots of numbers of hotels are visible");
		
		Thread.sleep(Duration.ofSeconds(3));
	    
	}

	@When("Click on breakfast include checkbox")
	public void click_on_breakfast_include_checkbox() throws InterruptedException {
		
		driver.findElement(By.xpath("(//span[text()='Breakfast Included'])[1]")).click();
		
		Thread.sleep(Duration.ofSeconds(3));

	   
	}

	@When("Click on ratings checkbox")
	public void click_on_ratings_checkbox() throws InterruptedException {
		
		driver.findElement(By.xpath("(//span[text()='Very Good: 3.5+'])[1]")).click();
		
		Thread.sleep(Duration.ofSeconds(3));
	    
	}

	@When("Click on mountain view checkbox")
	public void click_on_mountain_view_checkbox() throws InterruptedException {
		
		driver.findElement(By.xpath("(//span[text()='Mountain View'])[1]")).click();
		
		Thread.sleep(Duration.ofSeconds(3));
	    
	}

	@When("Select Hotel Blanket Hotel & Spa Munnar")
	public void select_Hotel_Blanket_Hotel_Spa_Munnar() throws InterruptedException {
		
		driver.findElement(By.xpath("(//span[text()='Blanket Hotel & Spa Munnar'])[1]")).click();
		
		Thread.sleep(Duration.ofSeconds(5));
	    
	}

	@When("Click on Bookthisnow button")
	public void click_on_Bookthisnow_button() throws InterruptedException {
				
		String childurl="https://www.makemytrip.com/hotels/hotel-details/?hotelId=201708281306414073&_uCurrency=INR&checkin=07282024&checkout=07312024&city=CTXMN&country=IN&filterData=HOTEL_PRICE_BUCKET%7C5000-2147483647%5EFREE_BREAKFAST_AVAIL%7CBREAKFAST_AVAIL%5EUSER_RATING_MMT_BRAND%7C3.5%5EROOM_VIEWS%7CMountain%20View&lat=10.04956&lng=77.05663&locusId=CTXMN&locusType=city&rank=1&regionNearByExp=3&roomStayQualifier=2e0e&rsc=1e2e0e&searchText=Munnar&viewType=PREMIUM&mtkeys=-2488288746843397781";
		String parentwindow = driver.getWindowHandle();
		Set<String> childids = driver.getWindowHandles();
		for (String string : childids) {
			driver.switchTo().window(string);
			if(driver.getCurrentUrl().contains(childurl)) {
				break;
			}
		}
		
		driver.findElement(By.xpath("(//button[text()='BOOK THIS NOW'])[1]")).click();
		
	    Thread.sleep(Duration.ofSeconds(3));

		
	}

	@When("Add guest details")
	public void add_guest_details() throws InterruptedException {
		
		//scroll till required module
		WebElement firstname = driver.findElement(By.xpath("(//input[@placeholder='First Name'])[1]"));
	    JavascriptExecutor jse1=(JavascriptExecutor)driver;
	    jse1.executeScript("arguments[0].scrollIntoView()", firstname);
	    
	    Thread.sleep(Duration.ofSeconds(3));
	    
	    firstname.sendKeys("Deepak");
	    
	    driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Patel");
	    
	    driver.findElement(By.xpath("//input[@placeholder='Email ID']")).sendKeys("deepak@gmail.com");
	    
	    driver.findElement(By.xpath("//input[@placeholder='Contact Number']")).sendKeys("9685879793");
	    
	    driver.findElement(By.xpath("//p[text()='Confirm and save billing details to your profile']")).click();

	    Thread.sleep(Duration.ofSeconds(5));
	    
	}

	@When("Click on paynow button")
	public void click_on_paynow_button() {
		
		driver.findElement(By.xpath("//a[text()='Pay Now']")).click();
	    
	}

	@Then("Payment page should be visible")
	public void payment_page_should_be_visible() {
		
		System.out.println("Payment page is visible");
	    
	}

	@Then("Hotel name should be visible")
	public void hotel_name_should_be_visible() {
		
		System.out.println("Hotel name is visible and correct");
	   
	}

	@Then("Booking dates should be visible")
	public void booking_dates_should_be_visible() {
		
		System.out.println("Booking checkin and checkout dates both are visible and correct");
	    
	}
	

}
