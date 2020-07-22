package com.telecom.stepdefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//import io.cucumber.datatable.DataTable;


public class AddTariffSteps {
	
	static WebDriver d;
	
	@Given("User launches telecom web application")
	public void user_launches_telecom_web_application() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aaba-PC\\eclipse-workspace\\simpleCucumber\\driver\\Chrome_83\\chromedriver.exe");
		d = new ChromeDriver();
		d.get("http://demo.guru99.com/telecom/");
		d.manage().window().maximize();
	}

	@Given("Click on the Add Tariff Plan")
	public void click_on_the_Add_Tariff_Plan() {
	    WebElement AddTariff = d.findElement(By.xpath("//a[text()='Add Tariff Plan']"));
	    
	    AddTariff.click();
	}

	@When("Close the Video Pop up window")
	public void closewindow() throws InterruptedException {
		
		Thread.sleep(5000);
		d.switchTo().frame("flow_close_btn_iframe");
		WebElement FrameCloseBtn = d.findElement(By.xpath("//div[@id='closeBtn']"));
	    FrameCloseBtn.click();
	    d.switchTo().defaultContent();
	    
	    
	}

	@When("Enter the Tariff Plan Data value")
	public void enter_the_Tariff_Plan_Data_value() {
	    WebElement MonthlyRental = d.findElement(By.id("rental1"));
	    MonthlyRental.sendKeys("499");
	    
	    WebElement LocalMinutes = d.findElement(By.id("local_minutes"));
	    LocalMinutes.sendKeys("1000");
	    
	    WebElement InterMins = d.findElement(By.id("inter_minutes"));
	    InterMins.sendKeys("1000");
	    
	    WebElement Freesms = d.findElement(By.id("sms_pack"));
	    Freesms.sendKeys("100");
	    
	    WebElement MinusCharge = d.findElement(By.id("minutes_charges"));
	    MinusCharge.sendKeys("1");
	    
	    WebElement InterCharge = d.findElement(By.id("inter_charges"));
	    InterCharge.sendKeys("10");
	    
	    WebElement SmsCharge = d.findElement(By.id("sms_charges"));
	    SmsCharge.sendKeys("2");
	    
	}
	
	@When("Enter the Tariff Plan Data value in 1dimesion list")
	public void enter_the_Tariff_Plan_Data_value_in_1dimesion_list(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		
		Thread.sleep(2000);
		
		List<String> TariffAddList = dataTable.asList();
		
		d.findElement(By.id("rental1")).sendKeys(TariffAddList.get(0));
		d.findElement(By.id("local_minutes")).sendKeys(TariffAddList.get(1));
		d.findElement(By.id("inter_minutes")).sendKeys(TariffAddList.get(2));
		d.findElement(By.id("sms_pack")).sendKeys(TariffAddList.get(3));
		d.findElement(By.id("minutes_charges")).sendKeys(TariffAddList.get(4));
		d.findElement(By.id("inter_charges")).sendKeys(TariffAddList.get(5));
		d.findElement(By.id("sms_charges")).sendKeys(TariffAddList.get(6));
	}


	@When("Click on the Tariff submit button")
	public void click_on_the_Tariff_submit_button() {
		
		WebElement TariffSubmit = d.findElement(By.xpath("//input[@type='submit']"));
		TariffSubmit.click();
	}

	@Then("Check the congratulations message")
	public void check_the_congratulations_message() {
		
		WebElement Message = d.findElement(By.xpath("//h2[contains(text(),'Congratulation')]"));
		String gettext = Message.getText();
		
		boolean b = gettext.contains("Congratulation you add Tariff Plan");
			
		if(b == true) {
			System.out.println("Tariff Plan is successfully Added");
		}
		
	}

	@Then("Close Tariff browser")
	public void close_Tariff_browser() {
		d.close();
	}


}
