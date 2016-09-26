package com.testcases;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Ex05ActionBuildPerform {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testEx05ActionBuildPerform() throws Exception {
    driver.get(baseUrl + "/MusicStore/");
    
	driver.get("file://C:/Users/Training/Desktop/Selenium Exercises/Exercise 5 - WebDriver 2.0/HTML/Selectable.html");
	WebElement one = driver.findElement(By.name("one"));
	WebElement three = driver.findElement(By.name("three"));
	WebElement five = driver.findElement(By.name("five"));
	WebElement six = driver.findElement(By.name("six"));
	
	//Select '3'
	three.click();
	Thread.sleep(5000);
	
	//Select '5'. This will unselect '3'
	five.click();
	Thread.sleep(5000);
	
	//Select '6'. This will unselect '5'
	six.click();
	Thread.sleep(5000);

	// Add all the actions into the Actions builder
	// so that you can select three elements at once.
	//hold ctrl key and other keys together
	Actions builder = new Actions(driver);
	builder.keyDown(Keys.CONTROL)
						.click(one)
						.click(three)
						.click(five)
						.keyUp(Keys.CONTROL);

	// Generate the composite action.
	Action compositeAction = builder.build();

	// Perform the composite action.
	compositeAction.perform();
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
}

