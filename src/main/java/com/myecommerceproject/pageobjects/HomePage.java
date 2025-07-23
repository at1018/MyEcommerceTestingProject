package com.myecommerceproject.pageobjects;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myecommerceproject.base.BaseClass;
import com.myecommereceproject.actiondriver.ActionClass;

public class HomePage extends BaseClass {
	ActionClass action=new ActionClass();
	@FindBy(xpath="(//input[@placeholder='search'])[2]")
	WebElement searchProductField;
	By waitForProduct=By.cssSelector(".mb-3");
	By waitForLoginSuccessfulMessage=By.cssSelector("div[aria-label='Login Successfully']");
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public SearchResultPage searchProduct(String productName) {
//		action.waitForElementToDisappear(waitForLoginSuccessfulMessage);
		searchProductField.sendKeys(productName);
		searchProductField.sendKeys(Keys.ENTER);
		action.waitForElementToAppear(waitForProduct);
		return new SearchResultPage();
		
	}

}
