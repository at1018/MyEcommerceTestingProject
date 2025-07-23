package com.myecommerceproject.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myecommerceproject.base.BaseClass;
import com.myecommerceproject.pageobjects.CartPage;
import com.myecommerceproject.pageobjects.HomePage;
import com.myecommerceproject.pageobjects.SearchResultPage;

public class CartPageTest extends BaseClass{
	String productName="ZARA COAT 3";
	@Test
	public void goToCartPageTest() {
		HomePage homePage=loginPage.loginScreen(System.getProperty("username"), System.getProperty("password"));
		SearchResultPage searchResultPage=homePage.searchProduct(productName);
		String productAddToCartSuccessMessage=searchResultPage.verifyProductAddToCart();
		System.out.println(productAddToCartSuccessMessage);
		Assert.assertEquals(productAddToCartSuccessMessage, "Product Added To Cart");
		CartPage cartPageTest=searchResultPage.goToCartPage();
		String productNameFromCartPageString=cartPageTest.verifyProductAtCartPage();
		Assert.assertEquals(productNameFromCartPageString, productName);
		cartPageTest.clickOnCheckOutButton();
		
	}

}
