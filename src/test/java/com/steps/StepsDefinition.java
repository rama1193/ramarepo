package com.steps;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefinition
{
	static WebDriver driver;
	@Given("I am on login page")
	public void i_am_on_login_page() 
	{
	   driver = new ChromeDriver();
	   driver.navigate().to("https://www.facebook.com/");
	   
	   driver.manage().window().maximize();
	   }

	@When("I enter user name an password")
	public void i_enter_user_name_an_password() 
	{
		driver.findElement(By.id("email")).sendKeys("rama1193@yahoo.in");
		driver.findElement(By.id("pass")).sendKeys("Aaradhana2016");
	
	}


	@When("I click on login button")
	public void i_click_on_login_button() 
	{
	  driver.findElement(By.name("login")).click();
	}


	@Then("I verify user login successfully")
	public void i_verify_user_login_successfully()
	{
		List<WebElement> element = driver.findElements(By.xpath("//span[contains(text(),'Ramalakshmi Krishnaswamy')]"));
		if (element.size()>0)
			Assert.assertEquals(element.get(0).getText(), "Ramalakshmi Krishnaswamy" );
		else
			Assert.fail("Login unsuccessfull");
	}

	

}
