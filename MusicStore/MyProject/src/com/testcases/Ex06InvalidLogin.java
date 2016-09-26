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

public class Ex06InvalidLogin {
	
	private WebDriver driver;
	private String baseUrl="";
	private StringBuffer verificationErrors = new StringBuffer();
	
	private String loginError="";
	private String errorLocation = "";
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testInvalidLogin() throws Exception {
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		FileInputStream fi = new FileInputStream("C:\\Users\\Training\\Desktop\\Selenium Exercises\\Exercise 6 - Data Driving and Reporting\\Data\\LoginUser.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet s = wb.getSheet("Sheet1");
		int Rows = s.getRows();
		
		for(int i=1; i<=Rows; i++)
		{
			driver.get("http://localhost/MusicStore/");
			driver.findElement(By.linkText("Admin")).click();
			driver.findElement(By.id("UserName")).clear();
			driver.findElement(By.id("UserName")).sendKeys(s.getCell("A" + i).getContents());
			driver.findElement(By.id("Password")).clear();
			driver.findElement(By.id("Password")).sendKeys(s.getCell("B" + i).getContents());
			driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		}
		
		

		
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
