package webtermites;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;

import org.jsoup.nodes.Document;

/*
 * class  : procs
 * author : fami
 * date   : 26/9/2016
 */


public class procs {
	
	// Method print out log
	public static void printlog (String log) {
		
		System.out.println(log);
		
	}
	
	// Method to create a temp file
	public static void createTempFile(String srcFile, Document doc) throws FileNotFoundException, IOException {
		
		File tempFile = new File(srcFile);
		
		if (tempFile.exists()) {
			procs.printlog("INFO::procs::createTempFile::File "+srcFile+" existed, remove the file.");
			tempFile.delete();
		} 
		
		PrintWriter writer = new PrintWriter(srcFile, "UTF-8");
		writer.println(doc);
		writer.close();
		
		procs.printlog("INFO::createTempFile::"+srcFile+" created.");
		
	}


	// Method to delete file
	public static void deleteFile(String srcFilePath) throws FileNotFoundException, IOException {
			
		File file =new File(srcFilePath);
		file.delete();
		
		if (file.exists()) {
			procs.printlog("ERROR::procs::deleteFile::Fail to delete "+srcFilePath+"files.");
			
		} else {
			
			procs.printlog("INFO::procs::deleteFile:: Successfully delete "+srcFilePath+" files.");
		}
		
	}
	
	
	// Method to write to file
	public static void writeToFile(String srcFilePath, String content) throws FileNotFoundException, IOException {
	
		
		File file =new File(srcFilePath);
		FileWriter fileWritter = new FileWriter(file,true);
		BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        bufferWritter.write("\n"+content);
        bufferWritter.close();
        
		//System.out.println(content);
	}
	
	
	// Method to check the web url accessibility
	public static String checkUrlAccessibility( String siteUrl, String testUrl) throws MalformedURLException{
		
		String result;
		String newTestUrl = testUrl;
		if (testUrl.substring(0,1).matches("/")) {
			
			newTestUrl = testUrl.substring(0, 1).replace("/", siteUrl);	
		}
		 		
		try {
            URL url = new URL(newTestUrl);
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
	
}
