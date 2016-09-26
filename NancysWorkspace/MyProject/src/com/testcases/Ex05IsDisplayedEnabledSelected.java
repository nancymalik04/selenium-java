package com.testcases;

import java.util.List;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Ex05IsDisplayedEnabledSelected {
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
  public void testEx05IsDisplayedEnabledSelected() throws Exception {
    driver.get(baseUrl + "/MusicStore/");
   
    WebElement textBox = driver.findElement(By.name("q"));
    System.out.println("The textbox is displayed: " + textBox.isDisplayed());
    System.out.println("The textbox is enabled: " + textBox.isEnabled());
    
    //driver.findElement(By.linkText("Admin")).click(); -->> I have expanded that
    WebElement adminButton = driver.findElement(By.linkText("Admin"));
    adminButton.click();
    WebElement checkBox = driver.findElement(By.id("RememberMe"));
    Thread.sleep(5000);
    
    //This functionality only makes sense for radiobuttons and checkboxes
    System.out.println("The checkbox is selected: " + checkBox.isSelected());
    
    checkBox.click();
    System.out.println("Now click the checkbox ");    
    System.out.println("The checkbox is selected: " + checkBox.isSelected());
    Thread.sleep(5000);
    
    

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
