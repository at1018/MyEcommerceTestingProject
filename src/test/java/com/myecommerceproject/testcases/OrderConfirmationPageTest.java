package com.myecommerceproject.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myecommerceproject.base.BaseClass;
import com.myecommerceproject.pageobjects.CartPage;
import com.myecommerceproject.pageobjects.HomePage;
import com.myecommerceproject.pageobjects.OrderConfirmationPage;
import com.myecommerceproject.pageobjects.PaymentPage;
import com.myecommerceproject.pageobjects.SearchResultPage;

public class OrderConfirmationPageTest extends BaseClass {
	String productName="ZARA COAT 3";
	String countryName="India";
	String confirmationMessage=("Thankyou for the order.").toUpperCase();
	@Test
	public void verifyOrderConfirmationMessage() {
		HomePage homePage=loginPage.loginScreen(System.getProperty("username"), System.getProperty("password"));
		SearchResultPage searchResultPage=homePage.searchProduct(productName);
		String productAddToCartSuccessMessage=searchResultPage.verifyProductAddToCart();
		System.out.println(productAddToCartSuccessMessage);
		Assert.assertEquals(productAddToCartSuccessMessage, "Product Added To Cart");
		CartPage cartPageTest=searchResultPage.goToCartPage();
		String productNameFromCartPageString=cartPageTest.verifyProductAtCartPage();
		Assert.assertEquals(productNameFromCartPageString, productName);
		PaymentPage paymentPageTest= cartPageTest.clickOnCheckOutButton();
		paymentPageTest.enterCountryName(countryName);
		paymentPageTest.selectCountryFromList(countryName);
		OrderConfirmationPage orderConfirmationPageTest= paymentPageTest.placeOrder();
		String orderConfirmationMessage= orderConfirmationPageTest.verifyOrderConfirmationMessage();
		Assert.assertEquals(orderConfirmationMessage, confirmationMessage);
		String productNameAtConfirmationPage=orderConfirmationPageTest.verifyPrdouctNameOnOrderConfirmationPage();
		Assert.assertEquals(productNameAtConfirmationPage, productName);
		
		
	}

}
