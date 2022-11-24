package com.pwc.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDataReader {
	
	Properties p;
	
	public PropertiesDataReader() throws IOException {
		
		FileReader fr = new FileReader("./data.properties");
		p = new Properties();
		p.load(fr);
	}
	
	public String getPropertyvalue(String key) {
		
		return p.getProperty(key);
	}

}
