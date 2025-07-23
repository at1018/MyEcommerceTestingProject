package com.myecommereceproject.actiondriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.myecommerceproject.base.BaseClass;

public class ActionClass extends BaseClass{
	WebDriverWait wait;
//	public void click(WebDriver driver, WebElement element) {
//		Actions action=new Actions(driver);
//		action.moveToElement(element).build().perform();
//	}
//	public void findElement(WebDriver driver, WebElement element) {
//		boolean flag=true;
//		try {
//			element.isDisplayed();
//			flag=true;
//		}
//		catch(Exception e) {
//			
//		}
//	}
	public void waitForElementToAppear(By element) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	public void waitForVisibilityOfElement(WebElement element) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForPresenceOfElement(By element) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}
	public void waitForElementToBeClickable(WebElement element) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitForElementToDisappear(By element) {
		wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
		
	}

}
