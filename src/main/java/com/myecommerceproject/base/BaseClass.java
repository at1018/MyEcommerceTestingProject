package com.myecommerceproject.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.security.PublicKey;
import java.time.Duration;
import java.util.Properties;

import javax.security.auth.login.LoginContext;

import org.apache.commons.collections4.map.StaticBucketMap;
import org.apache.commons.io.FileUtils;
import org.apache.poi.poifs.crypt.dsig.services.TSPTimeStampService;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.internal.annotations.IBeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.myecommerceproject.pageobjects.LoginPage;

public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;
	public LoginPage loginPage;
	public static ExtentSparkReporter extentReporter;
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
//	@BeforeTest
	public void loadConfig() throws IOException {
		try {
		FileInputStream file=new FileInputStream("C:\\Users\\anujt\\OneDrive\\Documents\\Selenium Project\\MyEcommerceProject\\Configuration\\Config.properties");
		prop =new Properties();
		prop.load(file);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
//		String browserName=System.getProperty("browser");
		
	}
	public WebDriver launchBrowser() throws IOException {
//		FileInputStream file=new FileInputStream("C:\\Users\\anujt\\OneDrive\\Documents\\Selenium Project\\MyEcommerceProject\\Configuration\\Config.properties");
//		prop=new Properties();
//		prop.load(file);
		loadConfig();
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver","C:\\Users\\anujt\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
//		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	@BeforeMethod
	public void launchMyEcommerceWebSite() throws IOException {
		driver=launchBrowser();
		driver.get(prop.getProperty("url"));
		System.out.println("This is base class driver="+driver);
		loginPage=new LoginPage();
//		loginPage.goToUrl();
	}
	@AfterMethod
	public void quitDriver() {
		driver.quit();
	}
	public String getScreenShot(String testName) throws IOException {
		TakesScreenshot takeScreenshot=(TakesScreenshot)driver;
		String path=System.getProperty("user.dir")+"\\Screenshot\\"+testName+".png";
		File targetScreenshotName=new File(path);
		File sourceFile=takeScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, targetScreenshotName);
		return path;
	}

}
