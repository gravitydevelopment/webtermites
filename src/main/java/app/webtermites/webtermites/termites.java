/*
 * class  : termites
 * author : fami
 * date   : 26/9/2016
 */

package webtermites;

import java.net.MalformedURLException;
import webtermites.wf_access;
import webtermites.procs;

public class termites {

	String srcURL;
	
	wf_access execute = new wf_access();
	
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
	public static void termitesFlow(String url) throws MalformedURLException{
		
		// Workflow Access
		procs.printlog("INFO::Workflow Access Start.");
		String wf_accessProcess = wf_access.checkUrlAccessibility(url);
		
		if (wf_accessProcess.endsWith("200")){
			
			//Workflow Read HTML
			procs.printlog("INFO::Workflow Access Start.");
			
			
		}
		
		
	}
	
}
