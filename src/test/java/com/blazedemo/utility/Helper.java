package com.blazedemo.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	
	public static String getscreenshot(WebDriver driver) {
		
		String screenshotpath =System.getProperty("user.dir")+"/screenshots/blazedeomo_"+getcurrentdateandtime()+".png";
		
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileHandler.copy(src, new File(screenshotpath));
		} catch (IOException e) {

		}
		
		return screenshotpath;
	}

	
	public static String getcurrentdateandtime() {
		
		DateFormat format=new SimpleDateFormat("dd_MM_yy_HH_mm_ss");
		
		Date currentdate =new Date();
		
	return	format.format(currentdate);
	}
}
