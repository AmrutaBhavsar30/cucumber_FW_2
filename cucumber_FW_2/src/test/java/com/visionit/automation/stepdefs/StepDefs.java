package com.visionit.automation.stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class StepDefs {

	WebDriver driver;
    String base_url = "http://automationpractice.com/";
    int implicit_wait_timeout_in_sec = 20;
    
    
    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicit_wait_timeout_in_sec, TimeUnit.SECONDS);
    }

   
    @After
    public void cleanUp(){
        driver.quit();
    }
	
	@Given("User Opend the Browser")
	@Deprecated
	public void user_opend_the_browser() {
	    
	}


	@Given("User redirected to the application url")
	public void user_redirected_to_the_application_url() 
	{
	driver.get(base_url);
	String expected="My Store";
	String actualt=driver.getTitle();
	Assert.assertEquals("titles are not validating", expected, actualt);
	System.out.println("Titles are validated correctlty");
	}
	
	@When("User Search for product {string}")
	public void user_search_for_product(String productName) {
		WebDriverWait webDriverWait = new WebDriverWait(driver,20);
        WebElement elementSearchBox = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("search_query_top")));

        elementSearchBox.sendKeys(productName);
        driver.findElement(By.xpath("//button[@class='btn btn-default button-search']")).click();
		
	}
	
	@Then("Search Result page is displayed")
	public void search_result_page_is_displayed() {
WebDriverWait webDriverWait1 = new WebDriverWait(driver,30);
        
        webDriverWait1.until(ExpectedConditions.titleIs("Search - My Store"));

        Assert.assertEquals("Page Title validation","Search - My Store", driver.getTitle());
        
        driver.quit();
	}


	
}
