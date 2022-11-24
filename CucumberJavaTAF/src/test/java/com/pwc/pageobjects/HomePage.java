package com.pwc.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver;
	private JavascriptExecutor js;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}

	// Properties

	private By createBtn = By.xpath("//button[text()='Create']");
	private By accountBtn = By.xpath("//button[text()='Account']");
	private By viewAllLnk = By.xpath("//button[text()='View All']");
	private By closePopupBtn = By.xpath("//button[text()='Close']");

	// Methods

	public void clickOnCreateBtn() throws InterruptedException {

		driver.findElement(createBtn).click();
		Thread.sleep(3000);
	}

	public void clickOnAccountBtn() throws InterruptedException {

		js.executeScript("arguments[0].click();", driver.findElement(accountBtn));
		Thread.sleep(3000);
	}

	public void clickOnViewAllLnk() throws InterruptedException {

		js.executeScript("arguments[0].click();", driver.findElement(viewAllLnk));
		Thread.sleep(3000);
	}

	public void clickOnBuyNowBtnForNFT(String nameOfTheNFT) throws InterruptedException {
		
		//js.executeScript("window.scrollBy(0,1)", "");
		Thread.sleep(10000);
		WebElement buynow = driver
				.findElement(By.xpath("//p[contains(text(),'" + nameOfTheNFT + "')]/../../button[text()='Buy Now']"));
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", buynow);
		Thread.sleep(20000);
	}
	
	public void clickOnClosePopUpBtn() throws InterruptedException {
		
		driver.findElement(closePopupBtn).click();
		Thread.sleep(3000);
	}
}
