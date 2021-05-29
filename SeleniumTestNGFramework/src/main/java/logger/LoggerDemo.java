package logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerDemo {

	private static Logger log = LogManager.getLogger(LoggerDemo.class);

			public static void main(String[] args) {
		System.out.println("\n    Hello into the Log4j    \n");
		log.info("This is info message");
		log.error("This is error message");
		log.fatal("This is fatal message");
		log.debug("This is debug message");
		
		System.out.println("\n    Completed   \n");
	}

}
