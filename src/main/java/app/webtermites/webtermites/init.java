/*
 * class  : init
 * author : fami
 * date   : 26/9/2016
 */

package webtermites;
import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import webtermites.termites;
import selenium.seleniumInit;



public class init {
	
	public static void main (String[] args) throws IOException{
				
		// CLI Input Option
		Options options = new Options();
		Option processType = new Option("p", "process", true, "Insert type of process either: termite or selenium");
		Option url = new Option("u", "url", true, "Insert Web url.");
		
		processType.setRequired(true);
		url.setRequired(true);
		
        options.addOption(processType);
        options.addOption(url);
        
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;
        
        try {
        	cmd = parser.parse(options, args);
        	
        } catch (ParseException e) {
        	
            System.out.println(e.getMessage());
            formatter.printHelp("WebTermite Execution Option", options);

            System.exit(1);
            return;
        }

        // Start Termite SEO Process
        String inputProcess = cmd.getOptionValue("process");
        System.out.println("inputProcess: "+inputProcess);
        
        // Initialize type of execution process
        if (inputProcess.matches("termite")) {
            
        	String inputUrl = cmd.getOptionValue("url");
            
            if (inputUrl == null){
            	
            	// Test when url is null
    			termites termites = new termites(); 
    				
    			} else {
    				
    				// Test when url input is not null
    				termites termites = new termites(inputUrl);
    				termites.termitesFlow(inputUrl);
    			}
        
        // Start Selenium Test Process
        } else if (inputProcess.matches("selenium")) {
        	
        	String srcSeleniumFile = cmd.getOptionValue("url");
        	seleniumInit.init(srcSeleniumFile);
        	
        }
			
	}
}
