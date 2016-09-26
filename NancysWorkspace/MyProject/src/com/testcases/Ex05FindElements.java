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

public class Ex05FindElements {
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
  public void testEx05FindElements() throws Exception {
    driver.get(baseUrl + "/MusicStore/");
   
    //Expect 10 items in list - 10 links
    List<WebElement> memberElements1 = driver.findElements(By.xpath("//*[@id='categories']/li"));
    System.out.println("Number of elements 1: " + memberElements1.size());
    
    
    List<WebElement> memberElements2 = driver.findElements(By.xpath("//*[@id='form0']/input"));
    System.out.println("Number of elements 2: " + memberElements2.size());

    
    
  //Use code similar to the following for getting the exact item
  // driver.findElements(By.xpath("//*[@id='form0']/input[1]"));		//First element
  // driver.findElements(By.xpath("//*[@id='form0']/input[2]"));		//Second element
  // driver.findElements(By.xpath("//*[@id='form0']/input[last()]"));	//Last element

    
    //String a = "A";


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
