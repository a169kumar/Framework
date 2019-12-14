package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClassCRM  {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
    public ExtentTest logger;
	@BeforeSuite
	public void setUpSuite() throws Throwable {
		Reporter.log("setting up reports & test is getting redy", true); // we can also use log4j
		 excel = new ExcelDataProvider();
		 // this is amit message
		
			config= new ConfigDataProvider();
			
			ExtentHtmlReporter extent= new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/freeCrm"+Helper.getCurrentDateTime()+".html"));
	        report = new ExtentReports();
	        report.attachReporter(extent);
	        Reporter.log("setting done & test can be stated", true);
	} 
	

	@BeforeClass
	public void setUp() {
		Reporter.log("Trying to start browser & Getting application redy", true);
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStringUrl());
		Reporter.log("Browser & application is up and running", true);
	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		Reporter.log("Test is about to end", true);
		if(result.getStatus()==ITestResult.FAILURE) {
			//Helper.captureScreenShot(driver);
			
				logger.fail("Test Fail", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
			} 
		
		
	else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Pass", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
		
	else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.skip("Test skip", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
			
		report.flush();
		Reporter.log("Testing completed and test report generated", true);
	}

}
