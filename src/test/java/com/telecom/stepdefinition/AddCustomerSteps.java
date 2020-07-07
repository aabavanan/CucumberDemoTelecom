package com.telecom.stepdefinition;

import java.util.List;
import java.util.Map;

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
	public void click_on_the_Add_Customer(){
		
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
	public void enter_the_customer_fields() throws InterruptedException {
		
		Thread.sleep(2000);
		
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
	
	@When("Enter the customer fields in 1dimensional list")
	public void enter_the_customer_fields_in_1dimensional_list(io.cucumber.datatable.DataTable dataTable) throws InterruptedException{
		
		Thread.sleep(2000);
		
		List<String> dimlist = dataTable.asList();
		
		d.findElement(By.xpath("(//label[@for='done'])[1]")).click();
		d.findElement(By.id("fname")).sendKeys(dimlist.get(0));
		d.findElement(By.id("lname")).sendKeys(dimlist.get(1));
		d.findElement(By.id("email")).sendKeys(dimlist.get(2));
		d.findElement(By.name("addr")).sendKeys(dimlist.get(3));
		d.findElement(By.id("telephoneno")).sendKeys(dimlist.get(4));
		
		
	}
	
	@When("Enter the customer fields in 1dimensional map")
	public void enter_the_customer_fields_in_1dimensional_map(io.cucumber.datatable.DataTable dataTable) throws InterruptedException{
		
		Thread.sleep(2000);
		
		Map<String, String> asMap = dataTable.asMap(String.class, String.class);
		
		d.findElement(By.xpath("(//label[@for='done'])[1]")).click();
		d.findElement(By.id("fname")).sendKeys(asMap.get("fname"));
		d.findElement(By.id("lname")).sendKeys(asMap.get("lname"));
		d.findElement(By.id("email")).sendKeys(asMap.get("mail"));
		d.findElement(By.name("addr")).sendKeys(asMap.get("address"));
		d.findElement(By.id("telephoneno")).sendKeys(asMap.get("phone"));
		
		
	}

	@When("Enter the customer fields in 2dimensional list")
	public void enter_the_customer_fields_in_2dimensional_list(io.cucumber.datatable.DataTable dataTable) throws InterruptedException{
		
		Thread.sleep(2000);
		
		List<List<String>> asLists = dataTable.asLists();
		
		d.findElement(By.xpath("(//label[@for='done'])[1]")).click();
		d.findElement(By.id("fname")).sendKeys(asLists.get(1).get(0));
		d.findElement(By.id("lname")).sendKeys(asLists.get(1).get(1));
		d.findElement(By.id("email")).sendKeys(asLists.get(1).get(2));
		d.findElement(By.name("addr")).sendKeys(asLists.get(1).get(3));
		d.findElement(By.id("telephoneno")).sendKeys(asLists.get(1).get(4));
		
		
	}
	
	@When("Enter the customer fields in 2dimensional map")
	public void enter_the_customer_fields_in_2dimensional_map(io.cucumber.datatable.DataTable dataTable) throws InterruptedException{
		
		Thread.sleep(2000);
		
		List<Map<String, String>> asMaps = dataTable.asMaps();
		
		d.findElement(By.xpath("(//label[@for='done'])[1]")).click();
		d.findElement(By.id("fname")).sendKeys(asMaps.get(2).get("fname"));
		d.findElement(By.id("lname")).sendKeys(asMaps.get(2).get("lname"));
		d.findElement(By.id("email")).sendKeys(asMaps.get(1).get("mail"));
		d.findElement(By.name("addr")).sendKeys(asMaps.get(3).get("address"));
		d.findElement(By.id("telephoneno")).sendKeys(asMaps.get(1).get("phone"));
	}

	@When("Click on submit button")
	public void click_on_submit_button(){
		
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
