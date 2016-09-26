package com.testcases.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.TestException;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.PageObjects.RegisterPage;

import static org.junit.Assert.*;

public class RegisterUserStepDef {
	

	//RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
	
	private RegisterPage registerPage;
	
	public void setUpWebDriver() throws Exception {
		registerPage = new RegisterPage();
		registerPage.setUp();
		registerPage.navigateToRegisterPage();
		
	}

	@Given("^I am on Register User Page$")
	public void i_am_on_Register_User_Page() throws Throwable {
		setUpWebDriver();
		
	}

	@When("^I enter my details$")
	public void i_enter_my_details() throws Throwable {
		registerPage.enterUserName("BloggsJ");
	    registerPage.enterEmail("j.bloggs@web.com");
	    registerPage.enterPassword("Pas1234");
	    registerPage.enterConfirmPassword("Pas1234");
	    registerPage.clickRegister();
	}

	@Then("^I am not registered with my new account$")
	public void i_am_registered_with_my_new_account() throws Throwable {
		assertEquals("Account creation was unsuccessful. Please correct the errors and try again.", registerPage.getErrorMessage());
	    //assertTrue(successMessage);
		registerPage.tearDown();
		
		
	}
	
}
