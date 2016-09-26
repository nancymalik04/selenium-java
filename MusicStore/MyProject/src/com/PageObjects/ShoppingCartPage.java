package com.PageObjects;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ShoppingCartPage {
	
	//////////////////////////////////////////////////////////
	//		FIELD DECLARATIONS								//
	//////////////////////////////////////////////////////////
	@FindBy(how = How.LINK_TEXT , using = "Remove from cart")
	private WebElement RemoveFromCartLink;  //--create a variable and ontop use find by to find webelement.
	
	//////////////////////////////////////////////////////////
	
	
	////////////////////////////////////////////////////////////
	//		PAGE OBJECT METHODS								  //
	////////////////////////////////////////////////////////////
	public void removeFromCart()
	{
		RemoveFromCartLink.click();
	}
}
	


