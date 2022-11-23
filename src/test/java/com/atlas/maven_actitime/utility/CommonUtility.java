package com.atlas.maven_actitime.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonUtility {

	// public static Map<String, String> data = new LinkedHashMap<>();

	public static String getPropertyValue(String filename, String key) {
		try (FileInputStream fis = new FileInputStream("actitime_testdata/" + filename + ".properties")) {
			Properties prop = new Properties();
			prop.load(fis);

			return prop.getProperty(key);
		} catch (IOException ioe) {
			System.out.println("file location is worng");
			ioe.printStackTrace();
		}
		return null;
	}
}
