package com.pwc.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PublishArtPage {

	private WebDriver driver;
	private JavascriptExecutor js;

	public PublishArtPage(WebDriver driver) {

		this.driver = driver;
		js = (JavascriptExecutor)driver;
	}
	
	//Properties
	
	By createNowBtn = By.xpath("(//button[text()='Create Now'])[1]");
	
	//Methods
	
	public void clickOnCreateNowBtn() throws InterruptedException {
		
		js.executeScript("arguments[0].click();", driver.findElement(createNowBtn));
		Thread.sleep(5000);
	}
}
