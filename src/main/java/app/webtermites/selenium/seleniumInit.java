package selenium;

import java.io.IOException;

import webtermites.procs;
import selenium.wfgetseleniumconfig;

/*
 * class  : seleniumInit.java
 * author : fami
 * date   : 30/9/2016
 */

public class seleniumInit {
	
	public static void init ( String srcTestFile ) {
		
		procs.printlog("INFO::seleniumInit:: Selenium Test Start.");
		
		try {
			
			// Start the Get Selenium Properties Workflow
			wfgetseleniumconfig.getSeleniumProperties(srcTestFile);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
