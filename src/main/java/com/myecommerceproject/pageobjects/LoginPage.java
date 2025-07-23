package com.myecommerceproject.pageobjects;


import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myecommerceproject.base.BaseClass;
import com.myecommereceproject.actiondriver.ActionClass;

public class LoginPage extends BaseClass{
//	Properties prop;
//	WebDriver driver;
	ActionClass action=new ActionClass();
	public LoginPage() {
//		this.driver=driver;
//		this.prop=prop;
		PageFactory.initElements(driver, this);
	}
	boolean flag=true;
	@FindBy(css=".login-title")
	WebElement loginTitle;
	@FindBy(id="userEmail")
	WebElement userEmail;
	@FindBy(id="userPassword")
	WebElement userPassword;
	@FindBy(id="login")
	WebElement loginButton;
	@FindBy(css="div[class*='toast-message']")
	WebElement incorrectId;
	@FindBy(css=".text-reset")
	WebElement registerLink;
	By waitForLoginSuccessfulMessage=By.cssSelector("div[aria-label='Login Successfully']");
//	public void goToUrl() {
//		String url=prop.getProperty("url");
//		driver.get(url);
//	}
	public String verifyLoginTitle() {
		String loginTextTitle=loginTitle.getText();
		System.out.println(loginTextTitle);
		return loginTextTitle;
	}
	public HomePage loginScreen(String email, String password) {
		boolean isUserEmailPresent =true;
		boolean isUserPasswordPresent=true;
		boolean isLoginButtonPresent=true;
		try {
			isUserEmailPresent=userEmail.isDisplayed();
			isUserPasswordPresent=userPassword.isDisplayed();
			isLoginButtonPresent=loginButton.isDisplayed();
		}
		catch(Exception e){
			if(isUserEmailPresent==false) {
				System.out.println("User Email element is not present");
			}
			if(isUserPasswordPresent==false) {
				System.out.println("User Password element is not present");
			}
			if(isLoginButtonPresent==false) {
				System.out.println("Login element is not present");
			}
		}
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		loginButton.click();
		action.waitForElementToDisappear(waitForLoginSuccessfulMessage);
//		if(incorrectId.getText().equalsIgnoreCase("Incorrect email or password.")) {
//			System.out.println("Account does not exist create an account");
//			flag=false;
//			return null;
//		}
//		else {
			return new HomePage();
//		}
	}
	public AccountCreationPage accountCreationPage() {
		if(flag==false) {
			registerLink.click();
		}
		return new AccountCreationPage();
		
	}

}
