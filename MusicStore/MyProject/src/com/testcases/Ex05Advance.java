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

public class Ex05Advance {
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
  public void testEx05BlankSelenium() throws Exception {
	  openBrowser();
	  clickLink();
	  WebElement lastNightOfThePromsAddToCartLink = driver.findElement(By.xpath(".//*[@id='album-list']/tbody/tr[7]/td[3]/a"));
	  lastNightOfThePromsAddToCartLink.click();
	  assertEquals("The Last Night of the Proms", driver.findElement(By.xpath(".//*[@id='row-4473']/td[1]/a")));
	  WebElement homeButton = driver.findElement(By.linkText("Home"));
	  homeButton.click();
	  List<WebElement> sideLinks = driver.findElements(By.xpath("//*[@id='categories']/li"));
	  sideLinks.get(0).click();
  }

private void clickLink() {
	driver.findElement(By.xpath(".//*[@id='latestReview']/a")).click();
}

private void openBrowser() {
	driver.get(baseUrl + ("MusicStore/"));
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
