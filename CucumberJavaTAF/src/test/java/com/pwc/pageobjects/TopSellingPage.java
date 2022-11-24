package com.pwc.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TopSellingPage {

	private WebDriver driver;
	private JavascriptExecutor js;

	public TopSellingPage(WebDriver driver) {

		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}

	// Properties
	
	By myProfileLnk =  By.xpath("//button[text()='My profile']");


	// Methods

	public void validateTheNFTByName(String nameOfTheNFT) throws InterruptedException {

		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'"+nameOfTheNFT+"')]")).isDisplayed());
		Thread.sleep(3000);
	}
	
	public void clickOnMyProfileLink() throws InterruptedException {
		
		js.executeScript("arguments[0].click();", driver.findElement(myProfileLnk));
		Thread.sleep(3000);
	}
}