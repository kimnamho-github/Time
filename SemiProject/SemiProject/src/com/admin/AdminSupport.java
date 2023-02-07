package com.admin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AdminSupport {
	private Properties prop = new Properties();
	public AdminSupport() {
		String filePath = AdminSupport.class.getResource("/db/properties/admin-route.properties").getPath();
		try {
			prop.load(new FileInputStream(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String toXmlUrl(String xmlName) {
		return String.format(prop.getProperty("xmlUrl"), xmlName);
	}
	public String toBoardUrl(String jspName) {
		return String.format(prop.getProperty("boardUrl"), jspName);
	}
	public String toCommonUrl(String jspName) {
		return String.format(prop.getProperty("commonUrl"), jspName);
	}
	public String getAleatMsg() {
		return "alertMsg";
	}
	
}
