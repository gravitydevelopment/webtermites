package selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/*
 * class  : wfgetseleniumconfig.java
 * author : fami
 * date   : 30/9/2016
 */


public class wfgetseleniumconfig {
	
	public static String getSeleniumProperties (String srcProp) throws IOException {
		
		String propertiesFile = srcProp;
		Properties seleniumConfig = new Properties();
		
		InputStream inputStream = new FileInputStream(propertiesFile); 
		seleniumConfig.load(inputStream);
		
		String urlWebdriver = seleniumConfig.getProperty("urlWebdriver");
		String testFolder = seleniumConfig.getProperty("testFolder");
		String reportFolder = seleniumConfig.getProperty("reportFolder");
		
		System.out.println("urlWebdriver: "+urlWebdriver);
		System.out.println("testFolder: "+testFolder);
		System.out.println("reportFolder: "+reportFolder);
		
		
		return "";
		
		
	}
	
	

}
