package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class CommonProperties {
	private static Properties  prop = new Properties();
	static String filePath = "./src/test/java/config/";
	static String propVal;

//	public static void main(String[] args) {
//		getTestConfigProp();
//		setConfigProp();
//		getTestConfigProp();
//	}

	public static String getTestConfigProp(String propKey) {
		try {
			InputStream inStream = new FileInputStream(filePath + "testConfig.properties");
			prop.load(inStream);	
			propVal = prop.getProperty(propKey);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return propVal;
	}

	public static void setConfigProp() {

			try {
				OutputStream outStream = new FileOutputStream(filePath + "testConfig.properties");
				prop.setProperty("browser", "firefox");	
				prop.store(outStream, null);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

	}

}
