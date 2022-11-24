package com.pwc.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MetaMaskNotificationPage {
	
	private WebDriver driver;
	private JavascriptExecutor js;

	public MetaMaskNotificationPage(WebDriver driver) {

		this.driver = driver;
		js = (JavascriptExecutor)driver;
	}
	
	//Properties
	
	private By passwordTxt = By.xpath("//input[@id='password']");
	private By unlockBtn = By.xpath("//button[text()='Unlock']");
	private By confirmBtn = By.xpath("//button[text()='Confirm']");
	
	//Methods
	
	public void unlockMetaMaskAccount(String password) {
		
		driver.findElement(passwordTxt).sendKeys(password);
		driver.findElement(unlockBtn).click();
	}
	
	public void clickOnConfirmBtn() throws InterruptedException {
		
		driver.findElement(confirmBtn).click();
		Thread.sleep(3000);
	}
}
