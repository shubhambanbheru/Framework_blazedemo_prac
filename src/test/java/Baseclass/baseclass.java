package Baseclass;

import java.io.File;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.blazedemo.utility.Exceldataprovider;
import com.blazedemo.utility.Helper;
import com.blazedemo.utility.browserfactory;
import com.blazedemo.utility.configdataprovider;

public class baseclass {
	public WebDriver driver;
	public Exceldataprovider excel;
	public configdataprovider config;
	public ExtentReports report;
	public ExtentTest logger;
	public Helper helper;
	
	@BeforeSuite
	public void setup() {
		
		excel= new Exceldataprovider();
		config =new configdataprovider();
		
		report =new ExtentReports();
		ExtentHtmlReporter extenthtml =new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/reports/report_"+Helper.getcurrentdateandtime()+".html"));
        report.attachReporter(extenthtml);
	}

	@BeforeClass
	public void startapp() {
		driver = browserfactory.openbrowser(driver, config.getbrowser(),config.getqaurl());
	}
	
	@AfterClass
	public void teardown() {
		browserfactory.quitbrowser(driver);
	}
	@AfterMethod
	public void getsceenshots(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE){
			
			Helper.getscreenshot(driver);
			
		}
		
		report.flush();
	}
	
	
}
