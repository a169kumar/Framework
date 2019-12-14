package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageCRM {
	WebDriver driver;
	
	public LoginPageCRM(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(name="username")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//*[@value=\"Login\"]")
	WebElement login;
	
	
	public void loginCrm(String uname, String passwordAppl) {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		username.sendKeys(uname);
		password.sendKeys(passwordAppl);
		login.click();
		
		
	}

}
