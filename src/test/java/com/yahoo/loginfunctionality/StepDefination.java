package com.yahoo.loginfunctionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefination {

	public static WebDriver driver = null;

	@Given("^User is home page of yahoo$")
	public void user_is_home_page_of_yahoo() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// WebDriverManager.firefoxdriver().setup();
		// driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://in.yahoo.com/");
	}

	@When("^User navigate to login page$")
	public void click_on_mail_icon_for_navigate_to_login_page() {

		driver.findElement(By.xpath("//span[text()='Sign in']")).click();
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 10);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
		 * "//button[text()='skip']")));
		 * driver.findElement(By.xpath("//button[text()='skip']")).click();
		 */

	}

	@Then("^User enter Username and click on next button$")
	public void user_enter_Username_and_click_on_next_button() {
		driver.findElement(By.id("login-username")).sendKeys("Enter Valid mail id");
		driver.findElement(By.id("login-signin")).click();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
	}

	@Then("^User enter password$")
	public void user_enter_password() {
		driver.findElement(By.className("password")).sendKeys("Enter Password ");
	}

	@Then("^Click on Next button of password$")
	public void click_on_Next_button_of_password() {
		driver.findElement(By.id("login-signin")).click();
		driver.findElement(By.xpath("//button[text()='skip']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header-mail-button")));
		driver.findElement(By.id("header-mail-button")).click();

	}

	@Then("^User is login sucessfully$")
	public void user_is_login_sucessfully() {
		driver.findElement(By.xpath("//a[contains(text(),'Compose')]"));
		// System.out.println(" Mail login sucessfully");

	}

	@When("^User is click on compose button$")
	public void user_is_click_on_compose_button() {
		driver.findElement(By.xpath("//a[contains(text(),'Compose')]")).click();
	}

	@Then("^User enter valid email address$")
	public void user_enter_valid_email_address() {
		driver.findElement(By.id("message-to-field")).sendKeys("Surendrapatil27@yahoo.com");
		driver.findElement(By.xpath("//button[@data-test-id='btn-cc']")).click();
		driver.findElement(By.id("message-cc-field")).sendKeys("surendrapatil27@yahoo.com");
		driver.findElement(By.id("message-bcc-field")).sendKeys("surendrapatil27@yahoo.com");
		
	}

	@Then("^User enter subject$")
	public void user_enter_subject() {
		driver.findElement(By.xpath("//input[@data-test-id='compose-subject']")).sendKeys("Testmail");
	}

	@Then("^User enter body$")
	public void user_enter_body() {
		driver.findElement(By.xpath("//div[@id='editor-container']/div/div")).sendKeys("Yahoo test mail script");

	}

	@Then("^click on send button$")
	public void click_on_send_button() {
		driver.findElement(By.xpath("//button[@data-test-id='compose-send-button']")).click();
	}

	@When("^User click on user account name for signout$")
	public void user_click_on_user_account_name_for_signout() {
		driver.findElement(By.xpath("//span[@role='presentation']")).click();
	}

	@Then("^User click on signout$")
	public void user_click_on_signout() {
		driver.findElement(By.xpath("//span[text()='Sign out']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Mail']")));
	}

	@Then("^User close the browser$")
	public void user_close_the_browser() {
		driver.close();
	}

}
