package com.learnautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClassCRM;
import com.learnautomation.pages.LoginPageCRM;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class LoginTestCRM extends BaseClassCRM {
	// WebDriver driver;

	@Test

	public void loginApp() {
		
        logger=report.createTest("Login to CRM");
		//driver = BrowserFactory.startApplication(driver, "chrome", "https://classic.crmpro.com/login.cfm");
		LoginPageCRM loginpage = PageFactory.initElements(driver, LoginPageCRM.class);
		logger.info("Starting Test");
		loginpage.loginCrm(excel.getStringData("Sheet1", 0, 0), excel.getStringData("Sheet1", 0, 1));
       logger.pass("login Pass");
		// Helper.captureScreenShot(driver);
	}
	@Test(priority=1)

	public void loginApp1() {
		
        logger=report.createTest("Log out");
        logger.fail("Log Out Failed");
		
	}

}
