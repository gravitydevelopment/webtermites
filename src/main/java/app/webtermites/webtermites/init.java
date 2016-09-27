/*
 * class  : init
 * author : fami
 * date   : 26/9/2016
 */

package webtermites;
import java.net.MalformedURLException;

import webtermites.termites;


public class init {
	
	public static void main (String[] args) throws MalformedURLException{

		//String str1 = null;
		String str1 = "http://stage-catho-companies.companyreview.co/por-dentro/";
		//String str1 = "http://bxcvbxcvb.com/";
		//String str1 = "file:///C:/Users/fahmi/Desktop/test_404.html";
		
			if (str1 == null){
				
			// Test when url is null
			termites termites1 = new termites(); 
				
			} else {
				
				// Test when url input is not null
				termites termites2 = new termites(str1);
				termites2.termitesFlow(str1);
				
			}
			
	}
}
