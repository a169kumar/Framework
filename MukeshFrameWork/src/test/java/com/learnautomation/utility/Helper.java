package com.learnautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;



public class Helper {

	
	public static String captureScreenShot(WebDriver driver)  {
	TakesScreenshot sc=	(TakesScreenshot)driver;
	File fi=sc.getScreenshotAs(OutputType.FILE);
	//Files.copy(fi, new File(""));
	String screenshotPath=System.getProperty("user.dir")+"/ScreenShot/"+ getCurrentDateTime()+".png";
	try {
		FileHandler.copy(fi, new File(screenshotPath));
		System.out.println("Screenshot captured");
	} catch (IOException e) {
		System.out.println("unable to capture screen shot" +e.getMessage());
		//e.printStackTrace();
	}
	return screenshotPath;
	}
	
	public static String getCurrentDateTime() {
	 DateFormat customeFormat= new SimpleDateFormat("MM_dd_yyyy_mm_ss");
		Date currentDate= new Date();
		return customeFormat.format(currentDate);
		
	}
}
