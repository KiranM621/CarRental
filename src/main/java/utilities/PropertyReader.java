package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	

	public static String getProperty(String key) {
		
		Properties property = new Properties();
		FileReader reader = null;
		try {
			reader = new FileReader("resources/data/TestData.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			property.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return property.getProperty(key); 
		
		
		
	}

}
