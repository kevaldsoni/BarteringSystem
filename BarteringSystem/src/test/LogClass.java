package test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogClass {
   
   private static final Logger log = Logger.getLogger(LogClass.class);
   
   public static void main(String[] args) {
	 
	   /* Logger.getRootLogger().setLevel(Level.ALL);
	   Layout layout = new PatternLayout("%d [%t] %-5p %c %x - %m%n");
	   Logger.getRootLogger().addAppender(new ConsoleAppender(layout));
	   */
	  try {
		   //BasicConfigurator.configure();
		 // PropertyConfigurator.configure("log4j.properties");
		  log.trace("Trace Message!");
	      log.debug("Debug Message!");
	      log.info("Info Message!");
	      log.warn("Warn Message!");
	      log.error("Error Message!");
	      log.fatal("Fatal Message!");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
   }
}