package stepDefinition;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPage {
	WebDriver driver;

	@SuppressWarnings("deprecation")
	@Given("^I open chrome browser$")
	public void i_open_chrome_browser() {
		String os = System.getProperty("os.name"); // Windows 10

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
				
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	}

	@When("^I visit the qa environment$")
	public void i_visit_the_qa_environment() {
		driver.get("https://login.salesforce.com");
	}

	@Then("^I should be on the login page$")
	public void i_should_be_on_the_login_page() {

	}

	@Then("^I enter \"([^\"]*)\" username$")
	public void i_enter_username(String arg1) {
		driver.findElement(By.id("username")).sendKeys(arg1);
	}

	@Then("^I enter \"([^\"]*)\" password$")
	public void i_enter_password(String arg1) {
		driver.findElement(By.id("password")).sendKeys(arg1);
	}

	@When("^I click the login button$")
	public void i_click_the_login_button() {
		driver.findElement(By.id("Login")).click();
	}

	@Then("^I should see the home page$")
	public void i_should_see_the_home_page() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	}

	@Then("^I search for \"([^\"]*)\" object$")
	public void i_search_for_object(String arg1) {
		driver.findElement(By.xpath("//input[@placeholder='Search apps and items...']")).sendKeys(arg1);
	}

	@Then("^I click the \"([^\"]*)\" object$")
	public void i_click_the_object(String arg1) {
		driver.findElement(By.xpath("//p[@class='slds-truncate']//b[contains(text(),'" + arg1 + "')]")).click();
	}

	@Then("^I click the \"([^\"]*)\" button$")
	public void i_click_the_button(String arg1) {
		driver.findElement(By.xpath("//div[@title='" + arg1 + "']")).click();
	}

	@Then("^I enter the \"([^\"]*)\" field as \"([^\"]*)\"$")
	public void i_enter_the_field_as(String arg1, String arg2) throws InterruptedException {
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].value='" + arg2 + "'",
				driver.findElement(By.xpath("//input[@name='" + arg1 + "']")));

	}

	@Then("^I click the \"([^\"]*)\" dropdown field$")
	public void i_click_the_dropdown_field(String arg1) throws Throwable {

		if (arg1.equalsIgnoreCase("Marital Status")) {
			driver.findElement(
					By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[1]"))
					.click();
		} else if (arg1.equalsIgnoreCase("Loan will be used for")) {
			driver.findElement(
					By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[2]"))
					.click();
		} else if (arg1.equalsIgnoreCase("Address")) {
			driver.findElement(
					By.xpath("(//input[@class='slds-combobox__input slds-input slds-combobox__input-value'])[1]"))
					.click();
		}

	}
	
	@Then("^I scroll down to the \"([^\"]*)\" field$")
	public void i_scroll_down_to_the_field(String arg1) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("(//input[@class='slds-combobox__input slds-input slds-combobox__input-value'])[1]")));
	}

	@Then("^I should see the following option$")
	public void i_should_see_the_following_option(DataTable arg1) throws Throwable {
		List<WebElement> options = driver.findElements(By.xpath(
				"//lightning-base-combobox-item[@class='slds-media slds-listbox__option slds-media_center slds-media_small slds-listbox__option_plain']"));

		List<String> maritalStatus = arg1.asList(String.class);

		for (int i = 0; i < maritalStatus.size(); i++) {
			Assert.assertEquals(options.get(i).getText(), maritalStatus.get(i));
		}
	}

	@Then("^I select \"([^\"]*)\" from the options$")
	public void i_select_from_the_options(String arg1) {
		driver.findElement(By.xpath("//span[@title='" + arg1 + "']")).click();

	}
	
	@Then("^I select \"([^\"]*)\"$")
	public void i_select(String arg1) throws Throwable {
		driver.findElement(By.xpath("//input[@name='country']")).sendKeys(arg1);
		driver.findElement(By.xpath("//span[@title='" + arg1 + "']")).click();
	}

	@Then("^It should fail$")
	public void it_should_fail() {

	}

}
