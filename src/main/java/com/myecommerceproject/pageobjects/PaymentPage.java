package com.myecommerceproject.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myecommerceproject.base.BaseClass;

import net.bytebuddy.asm.Advice.This;

public class PaymentPage extends BaseClass{
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement selectCountryElement;
	@FindBy(css=".list-group-item span")
	List<WebElement> countryList;
	@FindBy(css=".action__submit")
	WebElement placeOrderButton;
	public PaymentPage(){
		PageFactory.initElements(driver, this);
	}
	public void enterCountryName(String countryName) {
		selectCountryElement.sendKeys(countryName);;
	}
	public void selectCountryFromList(String countryName) {
		WebElement selectCountry=countryList.stream().filter(country->country.getText().equalsIgnoreCase(countryName)).findFirst().orElse(null);
		selectCountry.click();
	}
	public OrderConfirmationPage placeOrder() {
		placeOrderButton.click();
		return new OrderConfirmationPage();
	}
	
}
