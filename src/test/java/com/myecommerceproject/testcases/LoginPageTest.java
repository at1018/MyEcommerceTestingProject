package com.myecommerceproject.testcases;

import java.io.IOException;
import java.sql.DriverManager;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myecommerceproject.base.BaseClass;
import com.myecommerceproject.pageobjects.HomePage;
import com.myecommerceproject.pageobjects.LoginPage;

public class LoginPageTest extends BaseClass{
//	LoginPage loginPage=new LoginPage();
	@Test
	public void verifyLoginPage() {
//		LoginPage loginPage=new LoginPage();
		String loginTitle=loginPage.verifyLoginTitle();
		Assert.assertEquals(loginTitle, "Log in");
	}
	@Test
	public void loginToMyEcommerce() {
//		LoginPage loginPage=new LoginPage(driver);
		HomePage homePage= loginPage.loginScreen("ankit1234@gmail.com", "Abcd@1234");
	}
}
