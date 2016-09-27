/*
 * class  : procs
 * author : fami
 * date   : 26/9/2016
 */

package webtermites;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;


public class procs {
	
	// Method print out log
	public static void printlog (String log) {
		
		System.out.println(log);
		
	}
	
	
	// Method to check the web url accessibility
	public static String checkUrlAccessibility( String siteUrl) throws MalformedURLException{
		
		String result;
		 
		try {
            URL url = new URL(siteUrl);
            HttpURLConnection httpurlconnection = (HttpURLConnection) url.openConnection();
            httpurlconnection.setRequestMethod("GET");
            httpurlconnection.connect();
 
            int code = httpurlconnection.getResponseCode(); 
            
            if (code == 200) {
            	
                //result = 200;
            	result = Integer.toString(code);
                
            } else {
            	
            	result = Integer.toString(code);
            }
            
        } catch (Exception e) {
            result ="Exception::procs::checkUrlAccessibility::"+e;
        }
		
        return result;
	}
	
	//public static String 
	
	

}
