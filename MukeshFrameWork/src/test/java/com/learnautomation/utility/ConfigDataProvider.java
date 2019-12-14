package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ConfigDataProvider {
	public Properties prop;

	public ConfigDataProvider() throws Throwable {
		
		File src= new File("./Configuration/config.properties");
		//FileInputStream src= new FileInputStream("./Configuration/config.properties");
		FileInputStream fi= new FileInputStream(src);
		 prop= new Properties();
		prop.load(fi);
	}
		
	public String getDataFromConfig(String searchKey) {
		return prop.getProperty(searchKey);
	}
	public String getBrowser() {
		System.out.println("Amit");
		System.out.println(prop.getProperty("qaUrl"));
	return	prop.getProperty("Browser");
	}
	
	public String getStringUrl() {
		return prop.getProperty("qaUrl");
	}
}
