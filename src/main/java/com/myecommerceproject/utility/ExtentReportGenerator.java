package com.myecommerceproject.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.myecommerceproject.base.BaseClass;

public class ExtentReportGenerator extends BaseClass {
	public static ExtentReports extentReport() {
	String path=System.getProperty("user.dir")+"\\ExtentReports\\index.html";
//	String path="C:\\Users\\anujt\\OneDrive\\Documents\\Selenium Project\\MyEcommerceProject\\ExtentReports\\index.html";
//	ExtentSparkReporter extentReporter=new ExtentSparkReporter(path);
	extentReporter=new ExtentSparkReporter(path);
	extentReporter.config().setDocumentTitle("MyEcommereceSite");
	extentReporter.config().setReportName("Web Automation Test Result");
//	ExtentReports extentReports=new ExtentReports();
	extentReport=new ExtentReports();
	extentReport.attachReporter(extentReporter);
	return extentReport;
	}
}
