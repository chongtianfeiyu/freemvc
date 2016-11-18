package com.javalogging;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.ErrorManager;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.LoggingPermission;
import java.util.logging.SimpleFormatter;

/**
 * jdk logging—ßœ∞
 * @author liaokangli
 *
 */
public class LoggingTest {

	public static void main(String[] args) throws SecurityException, IOException{
		
		Logger log = Logger.getLogger("testlog");
		log.setLevel(Level.ALL);
		FileHandler fileHandler = new FileHandler("testlog.log");
		fileHandler.setLevel(Level.ALL);
		fileHandler.setFormatter(new SimpleFormatter());
		log.addHandler(fileHandler);
		log.info("this is test java util log");
		
	}
	
	/**
	 * ≤‚ ‘ConsoleHandler
	 */
	public static void testConsoleHandler(){
		ConsoleHandler consoleHandler;
	}
	
	/**
	 * ≤‚ ‘ErrorManager
	 */
	public static void testErrorManager(){
		ErrorManager errorManager;
	}
	
	/**
	 * ≤‚ ‘FileHandler
	 */
	public static void testFileHandler(){
		FileHandler fileHandler;
	}
	
	/**
	 * ≤‚ ‘Formatter
	 */
	public static void testFormatter(){
		Formatter formatter;
	}
	
	/**
	 * ≤‚ ‘Level
	 */
	public static void testLevel(){
		
		Level level;
	}
	
	/**
	 * ≤‚ ‘Logger
	 */
	public static void testLogger(){
		Logger logger;
	
	}
	
	/**
	 * ≤‚ ‘LoggingPermission
	 */
	public static void testLoggingPermission(){
		LoggingPermission loggingPermission;
	}
	
	/**
	 * ≤‚ ‘LogManager
	 */
	public static void testLogManager(){
		LogManager logManager = LogManager.getLogManager();
	}
	
	/**
	 * ≤‚ ‘LogRecord
	 */
	public static void testLogRecord(){
		LogRecord logRecord;
	}
	
	static class SubLevel extends Level{


		
		 protected SubLevel(String name, int value, String resourceBundleName) {
			super(name, value, resourceBundleName);
			// TODO Auto-generated constructor stub
		}

		public static final Level TT = new SubLevel("FINER", 400, "sun.util.logging.resources.logging");
		
	}
}
