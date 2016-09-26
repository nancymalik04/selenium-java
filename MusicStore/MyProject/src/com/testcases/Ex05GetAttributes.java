package com.testcases;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Ex05GetAttributes {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testEx05GetAttributes() throws Exception {
    driver.get(baseUrl + "/MusicStore/");
    driver.findElement(By.linkText("Register")).click();
    
	//WebElement textBox = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
	WebElement textBox = driver.findElement(By.id("UserName"));
	
	System.out.println("Name of the Textbox is: " + textBox.getAttribute("name"));
	System.out.println("Id of the Textbox is: " + textBox.getAttribute("id"));
	System.out.println("Class of the Textbox is: " + textBox.getAttribute("class"));
	System.out.println("Label of the Textbox is: " + textBox.getAttribute("aria-label"));
	System.out.println("Type of the Textbox is: " + textBox.getAttribute("type"));
	System.out.println("data-val-required of the Textbox is: " + textBox.getAttribute("data-val-required"));

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

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
