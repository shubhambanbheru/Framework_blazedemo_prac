package com.blazedemo.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class configdataprovider {
	Properties pro;

	public configdataprovider() {

		File file = new File(System.getProperty("user.dir") + "/config/config.properties");

		try {
			FileInputStream fis = new FileInputStream(file);

			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Property file not found");

		}

	}

	public String getbrowser() {

		return pro.getProperty("browser");
	}
	
	public String getqaurl() {
		return pro.getProperty("qaurl");
	}
}
