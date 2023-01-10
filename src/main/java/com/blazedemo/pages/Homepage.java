package com.blazedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Homepage {
	WebDriver driver;
	public Homepage(WebDriver ldriver) {
		
		this.driver =ldriver;
	}
	
	

	@FindBy(xpath="//h1[contains(text(),'Welcome to the Simple Travel Agency!')]") public WebElement title;
	@FindBy(xpath="//a[@href=\"vacation.html\"]") public WebElement clickonlink;
	@FindBy(xpath="//select[@name=\"fromPort\"]/option[6]") public WebElement mexicocity;
	@FindBy(xpath="//select[@name=\"toPort\"]/option[3]") public WebElement london;
	@FindBy(xpath="//input[@type=\"submit\"]") public WebElement clickonfindflights;
	@FindBy(xpath="//tr[3]//input[@type=\"submit\"1]") public WebElement chooseflight;
	@FindBy(xpath="//p[contains(text(),'Total Cost: ')]") public WebElement totalcost;
	@FindBy(xpath="//input[@value=\"Purchase Flight\"]") public WebElement purchase;
	@FindBy(xpath="//tbody//tr[1]//td[2]") public WebElement id;
	
	
	
	public void verifythetitle(String actualtitle) {
	String expectedtitle =	title.getText();
		if(actualtitle.equals(expectedtitle)) {
			System.out.println("Title Verified : "+expectedtitle);
			
		}
		
	}
	public void clickonthelink() {
		clickonlink.click();
	}
	public void gettitle() {
		String url =driver.getCurrentUrl();
		if(url.contains("vacation")) {
			System.out.println("The url contains String 'vacation'");
		}
		else {
			System.out.println("url do not contains 'vacation'");
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		
		driver.navigate().back();
	}
	public void fromport() {
		mexicocity.click();
	}
	public void toport() {
		london.click();
	}
	
	public void clickonfindflight() {
		clickonfindflights.click();
	}
	public void clickonchooseflight() {
		chooseflight.click();
	}
	public void gettotalcost() {
		System.out.println(totalcost.getText());
	}
	public void clickonpurchaseticket() {
		purchase.click();
		
		
		String title =driver.getCurrentUrl();
if(title.contains("confirmation")) {
	System.out.println("user is navigated to Purchase Confirmation page");
}
else {
	System.out.println("user is not navigated to Purchase Confirmation page");
}
	
	}
	public void getid() {
	 System.out.println("ID = "+id.getText());
	}
	
}
