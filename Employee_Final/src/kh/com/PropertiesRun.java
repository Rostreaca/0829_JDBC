package kh.com;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesRun {

	public static void main(String[] args) {

		Properties prop = new Properties();
		
		try {
			//prop.store(new FileOutputStream("driver.properties"), "Setting for DBMS");
			prop.storeToXML(new FileOutputStream("Employee-mapper.xml"), "EMPLOYEE SQL");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
