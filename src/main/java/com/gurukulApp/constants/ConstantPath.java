package com.gurukulApp.constants;

import java.io.File;

public class ConstantPath {
	public static final String LOGGER_FILE_PATH = System.getProperty("user.dir") + File.separator + "properties" + File.separator + "Log4j.properties";
	public static final String PROPERTIES_FOLDER_PATH = System.getProperty("user.dir") + File.separator + "properties" + File.separator;
	public static final String CHROME_EXE_PATH = System.getProperty("user.dir") + File.separator + "lib" + File.separator + "chromedriver.exe";
	public static final String FIREFOX_EXE_PATH = System.getProperty("user.dir") + File.separator + "lib" + File.separator + "geckodriver.exe";
	public static final String DOWNLOAD_FOLDER_PATH = System.getProperty("user.dir") + File.separator + "download";
	public static final String REPORT_PATH = System.getProperty("user.dir") + File.separator + "test-output" + File.separator;
	public static final String FIREFOX_LOG_PATH = System.getProperty("user.dir") + File.separator + "log/FF.log";
	public static final String CREDENTIALS_FOLDER_PATH = System.getProperty("user.dir") + File.separator + "credentials" + File.separator;
	public static final String LOG_PATH = System.getProperty("user.dir") + File.separator + "log" + File.separator;
}
