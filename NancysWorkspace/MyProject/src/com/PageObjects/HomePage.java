package com.PageObjects;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class HomePage {
	
	//////////////////////////////////////////////////////////
	//		FIELD DECLARATIONS								//
	//////////////////////////////////////////////////////////
	@FindBy(how = How.NAME, using = "q")
	private WebElement SearchTextBox;
	
	@FindBy(how = How.CSS, using = "input[type=\"submit\"]")
	private WebElement SearchBtn;
	
	@FindBy(how = How.LINK_TEXT , using = "Show top 5 selling albums")
	private WebElement SearchTop5;
	
	@FindBy(how = How.LINK_TEXT , using = "Add to cart")
	private WebElement AddToCartLink;
	//////////////////////////////////////////////////////////
	
	
	////////////////////////////////////////////////////////////
	//		PAGE OBJECT METHODS								  //
	////////////////////////////////////////////////////////////
	public void enterSearchtext(String text)
	{
		SearchTextBox.clear();
		SearchTextBox.sendKeys(text);
	}
	
	public void pressSearchButton()
	{
		SearchBtn.click();
	}

	public void showTop5()
	{
		SearchTop5.click();
	}
	
	public void addToCart()
	{
		AddToCartLink.click();
	}
}


