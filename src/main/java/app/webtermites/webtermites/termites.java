/*
 * class  : termites
 * author : fami
 * date   : 26/9/2016
 */

package webtermites;

import java.io.IOException;
import java.net.MalformedURLException;

import webtermites.wfaccess;
import webtermites.procs;

public class termites {

	String srcURL;
	
	wfaccess execute = new wfaccess();
	
	// Default constructor if input url is null
	termites() {	
		System.out.println("INFO:: Web Address: "+ srcURL);
	}
	
	// Parameterized constructor if there is input url 
	termites(String url) {		
		srcURL = url;
		System.out.println("INFO:: Web Address: "+ srcURL);	
	}
	
	
	// Main WebTermites Flow
	public void termitesFlow(String url) throws MalformedURLException{
		
		// Workflow Access
		procs.printlog("INFO::Workflow Access Start.");
		String wf_accessProcess = wfaccess.checkUrlAccessibility(url);
		
		if (wf_accessProcess.endsWith("200")){
			
			//Workflow Read HTML
			procs.printlog("INFO::Workflow Read HTML Start.");
			String fami = null;
			
			try {
				
				wfreadhtml.hrefTest(url, "Test_Report.html");
				procs.printlog("INFO::Workflow Read HTML Finished.");
				
			} catch (IOException e) {
				procs.printlog("FAIL::wfreadhtml Fail.");
				e.printStackTrace();
			}	
		}
		
		// Workflow publish report
		//procs.printlog("INFO::Workflow Publish Report Start.");
		
		
		procs.printlog("INFO::WebTermite test finished.");
		
	}
	
}
