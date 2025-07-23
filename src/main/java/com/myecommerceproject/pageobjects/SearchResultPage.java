package com.myecommerceproject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myecommerceproject.base.BaseClass;
import com.myecommereceproject.actiondriver.ActionClass;

public class SearchResultPage extends BaseClass {
	ActionClass action=new ActionClass();
	@FindBy(css=".card-img-top")
	WebElement productImage;
	@FindBy(css=".card-body b")
	WebElement getProductName;
	@FindBy(xpath="(//div[@class='card-body']/button)[2]")
	WebElement addToCart;
//	By waitForProduct=By.cssSelector(".card-body");
	@FindBy(css=".toast-message")
	WebElement productAddToCartMessage; //Wait for this element to disappear to go to cart page and add this step in addToCart function
	By productMessage=By.cssSelector(".toast-message");
	@FindBy(xpath="(//button[contains(@class,'btn-custom')])[3]")
	WebElement cartButton;
//	@FindBy(css=".mb-3")
//	WebElement waitForProduct;
	By waitForProduct=By.cssSelector(".mb-3");
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	public String verifyProductImage() {
//		action.waitForElementToAppear(waitForProduct);
		String image=productImage.getDomAttribute("src");
		return image;
	}
	
	public String verifyProductName() {
//		action.waitForElementToAppear(waitForProduct);
		String productName=getProductName.getText();
		return productName;
	}
//	public String verifyProductAddToCart() {
//		action.waitForElementToAppear(productMessage);
//		return "";
//	}
	public String verifyProductAddToCart() {
//		action.waitForElementToAppear(productMessage);
		action.waitForElementToBeClickable(addToCart);
		addToCart.click();
		String productAddToCartSuccessMessage=productAddToCartMessage.getText();
		action.waitForElementToDisappear(productMessage);
//		action.waitForElementToAppear(productMessage);
		return productAddToCartSuccessMessage;
		//Add wait here to wait for product add to cart message disappear
	}
	public CartPage goToCartPage() {
		action.waitForElementToDisappear(productMessage);
		cartButton.click();
		return new CartPage();
	}
}
