package com.learnautomation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	public static WebDriver startApplication( WebDriver driver,String browserName, String appUrl) {
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver= new ChromeDriver();
		
			
		}
		else if(browserName.equals("Firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		else if(browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "./IEDriverServer.exe");
		}
		else {
			System.out.println("We Do not support this browser");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver) {
		
		driver.quit();
	}
	
	
}
