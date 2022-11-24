package com.pwc.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyProfilePage {

	private WebDriver driver;
	private JavascriptExecutor js;

	public MyProfilePage(WebDriver driver) {

		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}

	// Properties

	private By createBtn = By.xpath("//button[text()='Create']");
	private By myCollectionTab = By.xpath("//button[text()='My Collections']");

	// Methods

	public void clickOnMyCollectionsTab() throws InterruptedException {

		js.executeScript("arguments[0].click();", driver.findElement(myCollectionTab));
		Thread.sleep(3000);
	}
	
	//Methods for My Collections Tab
	
	public void validateThePurchasedNFT(String nameOfTheNFT) throws InterruptedException {
		
		WebElement nftName = driver.findElement(By.xpath("//p[text()='"+nameOfTheNFT+"']"));
		Thread.sleep(3000);
		Assert.assertTrue(nftName.isDisplayed());
	}
}
