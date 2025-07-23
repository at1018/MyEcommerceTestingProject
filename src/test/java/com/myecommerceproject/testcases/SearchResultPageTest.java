package com.myecommerceproject.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myecommerceproject.base.BaseClass;
import com.myecommerceproject.pageobjects.CartPage;
import com.myecommerceproject.pageobjects.HomePage;
import com.myecommerceproject.pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass {
	String productName="ZARA COAT 3";
	String imageUrl="https://rahulshettyacademy.com/api/ecom/uploads/productImage_1650649434146.jpeg";
	@Test
	public void verifyProductImage() {
		HomePage homePage=loginPage.loginScreen(prop.getProperty("username"), prop.getProperty("password"));
		SearchResultPage searchResultPage=homePage.searchProduct(productName);
		String productImageUrl=searchResultPage.verifyProductImage();
		System.out.println(productImageUrl);
		Assert.assertEquals(productImageUrl, imageUrl);
	}
	@Test
	public void verifyProductName() {
		HomePage homePage=loginPage.loginScreen(prop.getProperty("username"), "Abcd@123456");
		SearchResultPage searchResultPage=homePage.searchProduct(productName);
		String productName1=searchResultPage.verifyProductName();
		System.out.println(productName1);
		Assert.assertEquals(productName1, productName);
	}
	@Test
	public void verifyProductAddToCartSuccessMessage() {
		HomePage homePage=loginPage.loginScreen(prop.getProperty("username"), prop.getProperty("password"));
		SearchResultPage searchResultPage= homePage.searchProduct(productName);
		String productAddToCartSuccessMessage=searchResultPage.verifyProductAddToCart();
		System.out.println(productAddToCartSuccessMessage);
		Assert.assertEquals(productAddToCartSuccessMessage, "Product Added To Cart");
	}
	@Test
	public void goToCartPageTest() {
		HomePage homePage=loginPage.loginScreen(prop.getProperty("username"), prop.getProperty("password"));
		SearchResultPage searchResultPage=homePage.searchProduct(productName);
		String productAddToCartSuccessMessage=searchResultPage.verifyProductAddToCart();
		System.out.println(productAddToCartSuccessMessage);
		Assert.assertEquals(productAddToCartSuccessMessage, "Product Added To Cart");
		searchResultPage.goToCartPage();
		
	}


}
