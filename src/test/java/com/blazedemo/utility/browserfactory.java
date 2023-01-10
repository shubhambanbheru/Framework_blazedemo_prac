package com.blazedemo.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class browserfactory {
	
	public static WebDriver openbrowser(WebDriver driver,String browsername,String url) {
		
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver =new ChromeDriver();
		}
		if(browsername.equals("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/drivers/IEDriverServer.exe");
			driver =new InternetExplorerDriver();
		}
		if(browsername.equals("edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/drivers/msedgedriver.exe");
			driver =new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		

		return driver;
	}

	public static WebDriver quitbrowser(WebDriver driver) {
		driver.quit();
		return driver;
	}
	

}
