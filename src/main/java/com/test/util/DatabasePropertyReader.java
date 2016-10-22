package com.test.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;



public class DatabasePropertyReader {
	private static final Logger LOG = Logger.getLogger(DatabasePropertyReader.class); 
	static Properties p = new Properties();
	static InputStream input = null;
	static {
		try {
			//input =  DatabasePropertyReader.class.getClassLoader().getResourceAsStream("database.properies");
			input = new FileInputStream ("database.properties");
			p.load(input);

		} catch (FileNotFoundException e) {
			
			LOG.equals(e);
		} catch (IOException e) {
			LOG.error(e);
		}finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					LOG.error(e);
				}
			}
		}


	}

	public static String getDatabasUrl() {
		return p.getProperty("url");
	}

	public static String getDriverName() {
		return p.getProperty("driverClassame");
	}
	
	public static String getTrySql() {
		return p.getProperty("try_sql");
	}
	
	
}