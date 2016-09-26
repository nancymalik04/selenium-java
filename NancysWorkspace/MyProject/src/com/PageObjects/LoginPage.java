package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	
	@FindBy(how = How.LINK_TEXT, using = "Admin")
	private WebElement AdminButton;
	
	//since UserName is an ID there is no need to do findby id. It defaults it to ID and finds the element. 
	private WebElement UserName;
	
	//since Password is an ID there is no need to do findby id. It defaults it to ID and finds the element. 
	private WebElement Password;
	
	@FindBy(how = How.CSS, using = "input[type=\"submit\"]")
	private WebElement SubmitButton;
	
	
	public void clickAdminButton()
	{
		AdminButton.click();
	}
	
	public void enterUserName(String username)
	{
		UserName.clear();
		UserName.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		Password.clear();
		Password.sendKeys(password);
	}
	
	public void clickSubmit()
	{
		SubmitButton.click();
		
	}
	
	
	

}
