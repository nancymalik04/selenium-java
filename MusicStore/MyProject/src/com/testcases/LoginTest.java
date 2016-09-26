package com.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.PageObjects.LoginPage;

public class LoginTest {
	
	private WebDriver driver;
	private String baseUrl="";
	private StringBuffer verificationErrors = new StringBuffer();
	
	private String loginError="";
	private String errorLocation = "";
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	@Test
	public void testLogin() throws Exception {
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		driver.get(baseUrl + "/MusicStore/");
		loginPage.clickAdminButton();
		loginPage.enterUserName("NancyMalik");
		loginPage.enterPassword("Password123");
		loginPage.clickSubmit();
	
		
//		driver.findElement(By.linkText("Admin")).click();
//		driver.findElement(By.id("UserName")).clear();
//		driver.findElement(By.id("UserName")).sendKeys("NancyMalik");
//		driver.findElement(By.id("Password")).clear();
//		driver.findElement(By.id("Password")).sendKeys("Password123");
//		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
			

		
		loginError = "Login was unsuccessful. Please correct the errors and try again.";
		errorLocation = driver.findElement(By.cssSelector("html body div#main div.validation-summary-errors span")).getText();
		
	    if (errorLocation.equals(loginError) == false)
	    {
	    	fail("[FAIL] Expected" + loginError + " Found " + errorLocation);   	
	    	
	    }
	    else
	    {
	    	System.out.println("[PASS]  \"" + errorLocation + "\" was displayed on the page");
	    }
	    	
	}


	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
