package com.eliasnogueira.quickloja;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utils {

	public static WebDriver selectBrowser(String browser) throws Exception {
		WebDriver driver = null;
		
		String so = GetOS.getOS();
		String exe = "";
		
		if (so.equals("win"))  {
			exe = ".exe";
		}
		
		switch (browser.toLowerCase()) {
		case "firefox":
			
			System.setProperty("webdriver.gecko.driver", "drivers/" + so + "/geckodriver" + exe);
			driver = new FirefoxDriver();
			break;

		case "chrome":
			
			System.setProperty("webdriver.chrome.driver", "drivers/" + so + "/chromedriver" + exe);
			driver = new ChromeDriver();
			break;
			
		default:
			break;
		}
		
		return driver;
	}
	
	
	public static String getPropertyValue(String property) {
		String value = null;
		
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File("config.properties")));
			
			value = prop.getProperty(property);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}
	
}
