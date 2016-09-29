package webtermites;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * class  : wf_readhtml
 * author : fami
 * date   : 26/9/2016
 */


public class wfreadhtml {
	
	public static String hrefTest (String srcWebUrl, String srcReport) throws IOException{
		
		int totalLink = 0;
		int totalSuccessAccess = 0;
		int totalFailAccess = 0;
		
		//Document doc = Jsoup.connect("http://stage-catho-companies.companyreview.co/por-dentro/").get();
		Document doc = Jsoup.connect(srcWebUrl).get();
		Document blank = null ;
		
		procs.printlog("INFO::wf_readHtml:: Create a temp HTML files.");
		procs.createTempFile("temp.html", doc);
		procs.createTempFile(srcReport, blank);
		
		// Parse from the temp html files
		Document htmlFile = null;
		htmlFile = Jsoup.parse(new File("temp.html"), "UTF-8");
	   
		// Check the href link
		procs.printlog("INFO::wf_readHtml:: Check the href links");
		Elements links = htmlFile.select("a");
		
		// WriteOut the report title to the report file 
		procs.writeToFile(srcReport, 
				"<html><head><title>WebTermite Report</title>"
				+ "\n</head>"
				+ "\n<body bgcolor=\"#ffffff\">"
				+ "\n<h1 align=\"center\">WebTermite Report</h1>"
				+ "\n<p align=\"center\"> Page Link Checking</p>"
				+ "\n<table border=\"1\" cellpadding=\"5\" cellspacing=\"5\">"
				+ "\n<tr><th>No</th><th>Link</th><th>Return Response</th></tr>");
		
		
		int k =0;
		for (Element link : links) {
			
			if (!link.attr("href").isEmpty() && link.attr("href") != null ) {
				
				String accessTest= procs.checkUrlAccessibility(srcWebUrl, link.attr("href"));			
				//System.out.println("title : "+link.attr("title")+" :: href : "+link.attr("href")+" :: Access Test: "+accessTest);
				
				totalLink ++;
				
				// Write out to the report
				String content ="<tr><th>"+totalLink+"</th><th>"+link.attr("href")+"</th><th>"+accessTest+"</th></tr>";
				procs.writeToFile(srcReport, content);
				if (accessTest.contentEquals("200")){
		    	totalSuccessAccess ++;
				}
			}
	    }
	
		totalFailAccess = totalLink-totalSuccessAccess;
		
		String linkhref="hello";
		
		System.out.println("Total href Links: "+totalLink);
		System.out.println("Total Good Links: "+totalSuccessAccess);
		System.out.println("Total Dead Links: "+totalFailAccess);
		
		// Write out to the report
		procs.writeToFile(srcReport, 
				"\n<table border=\"1\">"
				+"\n<p align=\"left\"> Summary</p>"
				+ "\n<tr><th>Total href Links:</th><th>"+totalLink+"</th></tr>"
				+ "\n<tr><th>Total Good Links:</th><th bgcolor=\"green\">"+totalSuccessAccess+"</th></tr>"
				+ "\n<tr><th>Total Dead Links:</th><th bgcolor=\"red\">"+totalFailAccess+"</th></tr>"
				+ "\n</table>");
		
		// WriteOut the report close to the report file 
		procs.writeToFile(srcReport, 
				"\n</body></html>");
		
		// Delete the temp file
		procs.deleteFile("temp.html");
		
		return linkhref;
	}

}
