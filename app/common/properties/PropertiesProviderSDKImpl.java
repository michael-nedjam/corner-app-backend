package common.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import common.LogHelper;

public class PropertiesProviderSDKImpl implements PropertiesProviderInterface {

	// fields
	private static String propertiesFilePath = "properties.txt"; 
	private Properties properties = new Properties();
	
	// construct
	public PropertiesProviderSDKImpl() {
		try{
			// load file
			properties.load(new FileInputStream(propertiesFilePath));

			// debug : show prop loaded
			for (String name : properties.stringPropertyNames()) {
				String value = properties.getProperty(name);
				LogHelper.LogInfo(name + "=>" + value);
			}
		} catch (IOException ioe) {
			LogHelper.LogError(ioe);
		}
	}
	
	// methods
	public String getString(String propertyName) {
		return properties.getProperty(propertyName);
	}

	public Boolean getBoolean(String propertyName) {
		String strValue = properties.getProperty(propertyName);
		return new Boolean(strValue);
	}

	public Double getDouble(String propertyName) {
		String strValue = properties.getProperty(propertyName);
		return new Double(strValue);
	}
}
