package com.blazedemo.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.blazedemo.pages.Homepage;
import com.blazedemo.utility.Exceldataprovider;

import Baseclass.baseclass;

public class Homepage_testclass extends baseclass {
	@Test
	public void homepage() {

		Homepage homepage = PageFactory.initElements(driver, Homepage.class);
		
		logger =report.createTest("Blazedemo Test");

		homepage.verifythetitle(excel.getStringdata("Sheet1", 0, 1));
		
		logger.pass("Title on Homepage Verified");
			
		homepage.clickonthelink();
		logger.pass("clicked on the link successfully");
		homepage.gettitle();
		
		homepage.fromport();
		logger.pass("Mexico City Selected");
		homepage.toport();
		logger.pass("London Selected");

		homepage.clickonfindflight();
		logger.pass("clicked on the findflights");

		homepage.clickonchooseflight();
		
		logger.pass("clicked on the chooseflight");

		homepage.gettotalcost();
		
		logger.pass("got total cost");

		homepage.clickonpurchaseticket();
		logger.pass("Clicked on the purchaseflight");

		homepage.getid();

		logger.pass("got the id");
		
		logger.pass("Browser closed successfully");


	}

}
