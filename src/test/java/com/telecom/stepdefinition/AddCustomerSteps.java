package com.telecom.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddCustomerSteps {
	
	static WebDriver d;

	@Given("User launches telecom web application in Chrome")
	public void user_launches_telecom_web_application_in_Chrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aaba-PC\\eclipse-workspace\\simpleCucumber\\driver\\Chrome_83\\chromedriver.exe");
		d = new ChromeDriver();
		d.get("http://demo.guru99.com/telecom/");
		d.manage().window().maximize();
	}

	@Given("Click on the Add Customer")
	public void click_on_the_Add_Customer() {
		WebElement AddCustomer = d.findElement(By.xpath("//a[text()=\"Add Customer\"][1]"));
		AddCustomer.click();
		
	}

	@When("Close the Pop up window")
	public void close_the_Pop_up_window() throws InterruptedException {
		Thread.sleep(5000);
		d.switchTo().frame("flow_close_btn_iframe");
	    WebElement FrameCloseBtn = d.findElement(By.xpath("//div[@id=\"closeBtn\"]"));
	    FrameCloseBtn.click();
	    d.switchTo().defaultContent();
	}

	@When("Enter the customer fields")
	public void enter_the_customer_fields() {
		
		WebElement LabelCheckBox = d.findElement(By.xpath("(//label[@for='done'])[1]"));
		LabelCheckBox.click();
		
		WebElement Fname = d.findElement(By.id("fname"));
		Fname.sendKeys("Aaba");
		
		WebElement Lname = d.findElement(By.id("lname"));
		Lname.sendKeys("vanan");
		
		WebElement Email = d.findElement(By.id("email"));
		Email.sendKeys("aaba@xyz.com");
		
		WebElement Address = d.findElement(By.name("addr"));
		Address.sendKeys("Salem");
		
		WebElement MobileNum = d.findElement(By.id("telephoneno"));
		MobileNum.sendKeys("9952220555");
		
	}

	@When("Click on submit button")
	public void click_on_submit_button() {
		
		WebElement SubmitBtn = d.findElement(By.xpath("(//input[@type='submit'])[1]"));
		SubmitBtn.click();

	}

	@Then("Check the Customer ID is displayed")
	public void check_the_Customer_ID_is_displayed() {
		
		Assert.assertTrue(d.findElement(By.xpath("(//td[@align='center'])[2]")).isDisplayed());
	}

	@Then("Close the Browser")
	public void close_the_Browser() {
		
		d.close();

	}

}
