/*
 * class  : wf_access
 * author : fami
 * date   : 26/9/2016
 */

package webtermites;

import java.net.MalformedURLException;
import webtermites.procs;


public class wf_access {
	
	// Method to check the web url accessibility
	public static String checkUrlAccessibility( String siteUrl) {
		
		procs.printlog("INFO::wf_access:: Checking the site accessibility.");
		String accessCode = null;
		
		try {
			
			procs.printlog("INFO::wf_access:: Checking the site accessibility.");
			
			accessCode= (procs.checkUrlAccessibility(siteUrl));
			
			if (accessCode.matches("200")){
				procs.printlog("INFO::wf_access:: Succeed Access "+siteUrl+" . success code "+accessCode);
				
			} else {
				
				procs.printlog("FAIL::wf_access:: Fail Accessing "+siteUrl+" . error:"+"\n"+accessCode);
			}
			
		} catch (MalformedURLException e) {
		
			e.printStackTrace();
		}
		
		return accessCode;
	

	}	

}
