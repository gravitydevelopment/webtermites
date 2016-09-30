package selenium;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * class  : seleniumprocs.java
 * author : fami
 * date   : 30/9/2016
 */


public class seleniumprocs {
	
	
	public String readSeleniumProperties (String srcProp) throws IOException {
		
		String propertiesFile = srcProp;
		Properties seleniumConfig = new Properties();
		
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFile);
		
		if (inputStream != null) {
			
			seleniumConfig.load(inputStream);
			
		} else {
			
			throw new FileNotFoundException("EXCEPTION::wfgetseleniumconfig:: Property file "+srcProp+" not found.");
		}
		
		return "";
		
		
	}
	
	
	public static Object driverDetermination(String browserType) throws IOException {
		
		WebDriver driver = null;
		
		if (browserType.matches("firefox")) {
			
			System.setProperty("webdriver.firefox.marionette","geckodriver.exe");
			
			driver = new FirefoxDriver();
			
		} else if (browserType.matches("chrome")) {
			
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			
			driver = new ChromeDriver();
		} 
		
		return driver;
	}

	
	
	
}
