package com.pwc.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pwc.util.PropertiesDataReader;

public class NFTMintPage {

	private WebDriver driver;
	private JavascriptExecutor js;

	public NFTMintPage(WebDriver driver) {

		this.driver = driver;
	}

	// Properties

	private By TitleTxt = By.xpath("//input[@name='title']");
	private By authorNameTxt = By.xpath("//input[@name='authorname']");
	private By priceTxt = By.xpath("//input[@name='price']");
	private By categoryDropdown = By.xpath("//select[@name='category']");
	private By chooseFileBrowse = By.xpath("//input[@type='file']");
	private By desciptionTxt = By.xpath("//textarea[@name='text']");
	private By royaltyAmountSwitch = By.xpath("//input[@type='checkbox']");
	private By royaltyAmountTxt = By.xpath("//input[@name='royelty']");
	private By createBtn = By.xpath("(//button[text()='Create'])[2]");

	// Methods

	public void mintNFT(PropertiesDataReader pdr) throws InterruptedException {

		js = (JavascriptExecutor)driver;
		
		driver.findElement(TitleTxt).sendKeys(pdr.getPropertyvalue("Title"));
		Thread.sleep(3000);
		
		driver.findElement(authorNameTxt).sendKeys(pdr.getPropertyvalue("AuthorName"));
		Thread.sleep(3000);
		
		driver.findElement(priceTxt).sendKeys(pdr.getPropertyvalue("Price"));
		Thread.sleep(3000);
		
		Select select = new Select(driver.findElement(categoryDropdown));
		select.selectByValue(pdr.getPropertyvalue("Category"));
		Thread.sleep(3000);
		
		driver.findElement(chooseFileBrowse).sendKeys(pdr.getPropertyvalue("Filepath"));
		Thread.sleep(3000);

		driver.findElement(desciptionTxt).sendKeys(pdr.getPropertyvalue("Description"));
		Thread.sleep(3000);

		js.executeScript("arguments[0].click();", driver.findElement(royaltyAmountSwitch));
		Thread.sleep(3000);

		driver.findElement(royaltyAmountTxt).sendKeys(pdr.getPropertyvalue("RoyaltyAmount"));
		Thread.sleep(3000);

		js.executeScript("arguments[0].click();", driver.findElement(createBtn));

	}

}
