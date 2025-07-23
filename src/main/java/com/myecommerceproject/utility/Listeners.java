package com.myecommerceproject.utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.myecommerceproject.base.BaseClass;

public class Listeners extends ExtentReportGenerator implements ITestListener{
//	ExtentReportGenerator extentReporter=new ExtentReportGenerator();
//	ExtentReports extentReport=extentReporter.extentReport();
	ExtentReports extentReport=extentReport();
//	ExtentTest extentTest;
	ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
//		System.out.println("Method started"+ result.getName());
			extentTest=extentReport.createTest(result.getMethod().getMethodName());
			test.set(extentTest);

		}

		@Override
		public void onStart(ITestContext contextStart) {
//		System.out.println("onStart method started");
		}

		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		System.out.println("Method failed with certain success percentage"+ result.getName());

		}

		@Override
		public void onTestFailure(ITestResult result) {
//		System.out.println("Test case got failed");
//			test.log(Status.FAIL, "Test Failed");
			test.get().fail(result.getThrowable());
//			try {
//				driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//				driver=(WebDriver) testClass.getClass().getDeclaredField("driver").get(testClass);
//				driver=(WebDriver) result.getTestContext().getAttribute("driver");
//			} catch (Exception e1) {
				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			String filePath = null;
			try {
				filePath=getScreenShot(result.getMethod().getMethodName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			test.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());

		}

		@Override
		public void onTestSkipped(ITestResult result) {
//		System.out.println("Method skipped"+ result.getName());

		}

		@Override
		public void onTestSuccess(ITestResult result) {
			extentTest.log(Status.PASS, "Test Passed");
//		System.out.println("Test case executed successfully");

		}
		@Override
		public void onFinish(ITestContext contextFinish) {
//		System.out.println("onFinish method finished");
			extentReport.flush();

		}

	

}
