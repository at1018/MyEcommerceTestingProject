package com.myecommerceproject.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myecommerceproject.base.BaseClass;
import com.myecommerceproject.dataprovider.DataProviders;
import com.myecommerceproject.pageobjects.CartPage;
import com.myecommerceproject.pageobjects.HomePage;
import com.myecommerceproject.pageobjects.PaymentPage;
import com.myecommerceproject.pageobjects.SearchResultPage;

public class EndToEndTest extends BaseClass {
//	String productName="ZARA COAT 3";
	String countryName="India";
	@Test(dataProvider = "ReadDataFromExcel", dataProviderClass = DataProviders.class)
	public void selectCountry(String username, String password, String productName) {
		HomePage homePage=loginPage.loginScreen(username, password);
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
		paymentPageTest.placeOrder();
		
	}

}
