package com.PageObjects;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class RegisterPage extends BasePage {
	
	private WebDriver	driver;
	private String		baseUrl;
	private String		browserName;
	private String		browserVersion;
	
	//-----------Below commented code is only used when running with Junit - RegisterUserTest.java
//	@FindBy(how = How.ID, using = ("UserName"))
//	private WebElement UserName;
//	
//	@FindBy(how = How.ID, using = ("Email"))
//	private WebElement Email;
//	
//	@FindBy(how = How.ID, using = ("Password"))
//	private WebElement Password;
//	
//	@FindBy(how = How.ID, using = ("ConfirmPassword"))
//	private WebElement ConfirmPassword;
	
//	@FindBy(how = How.CSS, using = ("input[type=\"submit\"]"))
//	private WebElement RegisterButton;
//	
//	@FindBy(how = How.XPATH, using = ("//*[@id='main']/form/div[1]/span"))
//	public WebElement errorMessage1;
//	
//	@FindBy(how = How.XPATH, using = ("//*[@id='main']/form/div[1]/ul/li"))
//	public WebElement errorMessage2;
	
////////--------------------------------------Set Up	
	
public void setUp() throws Exception {
		
		// driver = new HtmlUnitDriver();
		driver = new FirefoxDriver();
		
		// driver = new ChromeDriver();
		// driver = new InternetExplorerDriver ();
		// driver = new SafariDriver();
		
		baseUrl = "http://localhost/MusicStore/";
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		browserName = caps.getBrowserName();
		browserVersion = caps.getVersion();
		
		System.out.println("Automated test run. We’re running on " + browserName + " " + browserVersion);
}


public void navigateToRegisterPage() {
	driver.get(baseUrl + "Account/Register");
}
	
	public void tearDown() {
		driver.quit();
	}
	
	//-------------------------------------------------------------------------------------------------------------
	
	public void enterUserName(String username)
	{
		
		WebElement uname = driver.findElement(By.id("UserName"));
		uname.clear();
		uname.sendKeys(username);
		
		//This is used for JUNIT and NOT BDD
//		UserName.clear();
//		UserName.sendKeys(username);
	}
	
	public void enterEmail(String email)
	{
		WebElement mail = driver.findElement(By.id("Email"));
		mail.clear();
		mail.sendKeys(email);
		
//		Email.clear();
//		Email.sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		WebElement passw = driver.findElement(By.id("Password"));
		passw.clear();
		passw.sendKeys(password);
		
//		Password.clear();
//		Password.sendKeys(password);
	}
	
	public void enterConfirmPassword(String confirmpassword)
	{
		WebElement conpass = driver.findElement(By.id("ConfirmPassword"));
		conpass.clear();
		conpass.sendKeys(confirmpassword);
		
//		ConfirmPassword.clear();
//		ConfirmPassword.sendKeys(confirmpassword);
		
	}
	
	
	public void clickRegister()
	{
		WebElement RegisterButton = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
		RegisterButton.click();
	}
	
	public String getErrorMessage() {
		String actualErrorMessage = driver.findElement(By.xpath("//*[@id='main']/form/div[1]/span")).getText(); 
		//Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));
		return actualErrorMessage;
	}
	
	

}
