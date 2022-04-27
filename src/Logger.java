package src;

import java.util.Date;

import src.driver.Driver;

public class Logger {
	
	public static LogType defLogType = LogType.DEBUG;
	
	public static void log(LogType t, String out) {
		
		if (Driver.state.debug || t != LogType.DEBUG) {
			
			System.out.println("[" + new Date() + "] [" + t.name() + "] " + out);
			
		}
		
	}
	
	public static void log(String out) {
		
		log(defLogType, out);
		
	}
	
	public static void i(String out) {
		
		log(LogType.INFO, out);
		
	}
	
	public static void d(String out) {
		
		log(LogType.DEBUG, out);
		
	}
	
	public static enum LogType {
		
		INFO,
		DEBUG,
		
	}
	
}