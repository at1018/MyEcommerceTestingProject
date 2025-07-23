package com.myecommerceproject.testcases;

import org.testng.annotations.Test;

import com.myecommerceproject.base.BaseClass;
import com.myecommerceproject.pageobjects.HomePage;
import com.myecommerceproject.pageobjects.LoginPage;

public class HomePageTest extends BaseClass {
	String productName="ZARA COAT 3";
	@Test
	public void enterProductNameInSearchField() {
		HomePage homePageTest=loginPage.loginScreen(System.getProperty("username"), System.getProperty("password"));
		homePageTest.searchProduct(productName);
	}

}
