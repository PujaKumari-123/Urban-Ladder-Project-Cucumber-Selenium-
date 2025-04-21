package stepdefinition;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class Urbanstep {

	WebDriver driver;
	WebDriverWait wait;

	@Given("Open the Browser Enter the Url")
	public void open_the_browser_enter_the_url() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://www.urbanladder.com/");
	}

	@Given("Verify that homepage loaded succesfully")
	public void verify_that_homepage_loaded_succesfully() {
		WebElement titlElement = driver.findElement(By.cssSelector("[fill='#2F4858']"));
		if (titlElement.isDisplayed()) {

			System.out.println("We are on Homepage");

		}
	}


	@When("User Search for a product and click on Search button")
	public void user_search_for_a_product_and_click_on_search_button() {
		WebElement searchboxElement = driver.findElement(By.xpath("(//*[@name='keywords'])[2]"));

		searchboxElement.sendKeys("Sofa",Keys.ENTER);
}


	@When("Verify that Results are displayed")
	public void verify_that_results_are_displayed() throws InterruptedException {
		
		Thread.sleep(3000);
		 WebElement boxtext=driver.findElement(By.cssSelector("[class='login-message']"));
         
	        if (boxtext.isDisplayed()){
	            System.out.println("Login Box found");
	            WebElement boxclosebutton=driver.findElement(By.partialLinkText("Close"));
	            boxclosebutton.click();
	        }

			WebElement productElement = driver.findElement(By.xpath("//*[.='Arminta Fabric Sofa Set ']"));

			if (productElement.isDisplayed()) {

				System.out.println("Search is based on : " + productElement.getAttribute("class"));

			}
		}


	@When("User apply Filter on Product Search")
	public void user_apply_filter_on_product_search() {
		WebElement categoryFilterElement = driver.findElement(By.xpath("(//*[@class='gname'])[1]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(categoryFilterElement).build().perform();

		WebElement fabricsofaElement = driver.findElement(By.xpath("//label[@for='filters_primary_category_Fabric_Sofa_Sets']"));

		wait.until(ExpectedConditions.visibilityOf(fabricsofaElement));
		fabricsofaElement.click();
		
	}

		
	@When("Verifies that Results are diplayed as per Filter Applied")
	public void verifies_that_results_are_diplayed_as_per_filter_applied() throws InterruptedException {
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		
		WebElement element = driver.findElement(By.cssSelector("[for='filters_availability_In_Stock_Only']"));
		action.moveToElement(element).build().perform();

		WebElement fabricElement = driver.findElement(By.xpath("(//*[.='Fabric Sofa Sets'])[4]"));
		
		fabricElement.click();
	}


	@Then("User Add a product to cart")
	public void user_add_a_product_to_cart() throws InterruptedException {
		WebElement firstproductElement = driver.findElement(By.xpath("//img[@title='Arminta Fabric Sofa Set (Grey)']"));

		firstproductElement.click();

	WebElement productpagElement = driver.findElement(By.id("add-to-cart-button"));

	
	wait.until(ExpectedConditions.visibilityOf(productpagElement));
	
	Thread.sleep(2000);
	
	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	
	jsExecutor.executeScript("arguments[0].click()", productpagElement);
	}

	@Then("User Verify that product added to cart")
	public void user_verify_that_product_added_to_cart() {
		WebElement productaddtocartpagElement = driver.findElement(By.partialLinkText("Arminta"));

		if (productaddtocartpagElement.isDisplayed()) {

			System.out.println("Product Added to cart Successfully");

		}
	}

	@Then("User go to Cart")
	public void user_go_to_cart() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.urbanladder.com/cart");

		System.out.println("Cart Reached successfully");
	}

	@Then("User click on Checkout button")
	public void user_click_on_checkout_button() {
		WebElement checkoutbuttonElement = driver.findElement(By.xpath("(//*[@name='checkout'])[2]"));

		checkoutbuttonElement.click();
	}	

	@Then("Enter details if visible")
	public void enter_details_if_visible() {
		WebElement emailidElement = driver.findElement(By.id("order_email"));

		emailidElement.sendKeys("puja@yopmail.ocm");

		WebElement pincodElement = driver.findElement(By.xpath("//input[@id='order_ship_address_attributes_zipcode']"));

		pincodElement.sendKeys("8000012");

		WebElement addressElement = driver.findElement(By.id("order_ship_address_attributes_address1"));

		addressElement.sendKeys("1231323");

		WebElement firsElement = driver.findElement(By.id("order_ship_address_attributes_firstname"));

		firsElement.sendKeys("puja");

		WebElement lastnamElement = driver.findElement(By.id("order_ship_address_attributes_lastname"));

		lastnamElement.sendKeys("kumari");

		WebElement mobilElement = driver.findElement(By.id("order_ship_address_attributes_phone"));

		mobilElement.sendKeys("9023902039901239");

	}

	@Then("User verify that product redirected to the payment page")
	public void user_verify_that_product_redirected_to_the_payment_page() {
		WebElement savebuttonElement = driver.findElement(By.name("commit"));

		savebuttonElement.click();

		Assert.assertEquals(driver.getCurrentUrl(), "https://www.urbanladder.com/checkout/address");

		System.out.println("Workflow Testing Done Successfully");
		
		driver.quit();
	}
}

