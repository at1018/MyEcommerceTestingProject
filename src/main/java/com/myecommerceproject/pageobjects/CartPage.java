package com.myecommerceproject.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myecommerceproject.base.BaseClass;

public class CartPage extends BaseClass{
	@FindBy(css=".cartSection h3")
	WebElement getProductNameAtCartPage;
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkOutButton;
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	public String verifyProductAtCartPage() {
		String productName=getProductNameAtCartPage.getText();
		return productName;
	}
	public PaymentPage clickOnCheckOutButton() {
		checkOutButton.click();
		return new PaymentPage();
	}
	

}
