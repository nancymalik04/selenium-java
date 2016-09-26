package com.testcases;

import static org.junit.Assert.fail;

import java.io.File;
import java.util.concurrent.TimeUnit;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ex07InvalidLogin_Write {
	
	private WebDriver driver;
	private StringBuffer verificationErrors	= new StringBuffer();
	
	private String loginError = "";
	private String errorLocation = "";
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void testInvalidLogin() throws Exception {
		Workbook wb = Workbook.getWorkbook(new File("C:\\Users\\Training\\Desktop\\Selenium Exercises\\Exercise 7 - Debugging\\Data\\LoginUser.xls"));
		WritableWorkbook copy = Workbook.createWorkbook(new File("C:\\Users\\Training\\Desktop\\Selenium Exercises\\Exercise 7 - Debugging\\Data\\Results.xls"), wb);
		WritableSheet s = copy.getSheet(("Sheet1"));
		int Rows = s.getRows();
		
		for(int i=1; i<=Rows; i++) {
		//for (int i = 1; i <= 3; i++) {
			driver.get("http://localhost/MusicStore/");
			driver.findElement(By.linkText("Admin")).click();
			driver.findElement(By.id("UserName")).clear();
			driver.findElement(By.id("UserName")).sendKeys(s.getWritableCell("A" + i).getContents());
			driver.findElement(By.id("Password")).clear();
			driver.findElement(By.id("Password")).sendKeys(s.getWritableCell("B" + i).getContents());
			driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
			
			//writing to D coloumn and i row.. A is 0 so need to make i - 1 so it adds in 0 row. 
			s.addCell(new Label(2, i-1, "Executed"));
			
			// Use the code below to print out to the console:
			System.out.print("-------rowcount: " + s.getRows());
		 // 
		
		
		
		loginError = "Login was unsuccessful. Please correct the errors and try again.";
		errorLocation = driver.findElement(By.cssSelector("html body div#main div.validation-summary-errors span")).getText();
		
		if (errorLocation.equals(loginError) == false) {
			fail("[FAIL] Expected" + loginError + " Found " + errorLocation);
			
		} else {
			System.out.println("[PASS]  \"" + errorLocation + "\" was displayed on the page");
		}
		
		
	}//End of "for" loop
		
	copy.write();
	copy.close();
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}
