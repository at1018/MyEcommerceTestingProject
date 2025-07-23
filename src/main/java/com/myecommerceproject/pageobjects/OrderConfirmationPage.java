package com.myecommerceproject.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myecommerceproject.base.BaseClass;

public class OrderConfirmationPage extends BaseClass {
	@FindBy(css=".hero-primary")
	WebElement confirmationMessage;
	@FindBy(css="td[class*='product-info-column'] div")
	WebElement productNameConfirmation;
	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	public String verifyOrderConfirmationMessage() {
		String orderConfirmationMessageString=confirmationMessage.getText();
		return orderConfirmationMessageString;
	}
	public String verifyPrdouctNameOnOrderConfirmationPage() {
		String getProductNameString=productNameConfirmation.getText();
		return getProductNameString;
	}

}
