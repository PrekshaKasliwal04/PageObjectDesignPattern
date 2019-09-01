package com.basesource.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.gurukulApp.constants.ConstantPath;

public class ObjectReader {
	private Properties property = new Properties();

	public final Properties getObjectRepository(String filename) throws IOException {
		// Read object repository file
		File propertiesFile = new File(ConstantPath.PROPERTIES_FOLDER_PATH + filename + ".properties");		
		InputStream stream;
		if (propertiesFile.exists()) {
			stream = new FileInputStream(propertiesFile);
		} else {
			stream = ObjectReader.class.getClassLoader().getResourceAsStream("properties/" + filename + ".properties");
		}

		// load all objects
		property.load(stream);
		return property;
	}

	public final Properties getCredentials(String credentials) throws IOException {
		// Read object repository file
		
		
		File propertiesFile = new File(ConstantPath.CREDENTIALS_FOLDER_PATH + File.separator + credentials.toUpperCase() + ".properties");
		InputStream stream;
		if (propertiesFile.exists()) {
			stream = new FileInputStream(propertiesFile);
		} else {
			// URLs of the resources inside a JAR are case sensitive.
			stream = ObjectReader.class.getClassLoader().getResourceAsStream("credentials/" + credentials + ".properties");
		}

		// load all objects
		property.load(stream);

		return property;
	}
}