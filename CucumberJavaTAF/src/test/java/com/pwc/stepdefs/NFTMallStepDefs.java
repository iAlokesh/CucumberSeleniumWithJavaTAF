package com.pwc.stepdefs;

import java.util.Set;

import com.pwc.pageobjects.HomePage;
import com.pwc.pageobjects.MetaMaskNotificationPage;
import com.pwc.pageobjects.MyProfilePage;
import com.pwc.pageobjects.NFTMintPage;
import com.pwc.pageobjects.PublishArtPage;
import com.pwc.pageobjects.TopSellingPage;
import com.pwc.util.ReusableLibraries;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NFTMallStepDefs extends BaseTest{
	
	BaseTest bt;
	
	public NFTMallStepDefs(BaseTest bt) {
		
		this.bt = bt;
		System.out.println("stepbt.driver : "+bt.driver);
	}

	@Given("^User is on NFTMall homepage$")
	public void user_is_on_NFTMall_homepage() throws Throwable {

		String parent = bt.driver.getWindowHandle();
		Thread.sleep(5000);
		Set<String> wh = bt.driver.getWindowHandles();
		String child = ReusableLibraries.getChildWindow(parent, wh);

		bt.driver.switchTo().window(child);
		Thread.sleep(3000);

		MetaMaskNotificationPage mmnp = new MetaMaskNotificationPage(bt.driver);
		mmnp.unlockMetaMaskAccount(bt.pdr.getPropertyvalue("MetaMaskPwd"));
		
		bt.driver.switchTo().window(parent);
	}

	@When("^User navigated to the NFTMint page$")
	public void user_navigated_to_the_NFTMint_page() throws Throwable {

		HomePage hm = new HomePage(bt.driver);
		hm.clickOnCreateBtn();

		PublishArtPage pap = new PublishArtPage(bt.driver);
		pap.clickOnCreateNowBtn();		
	}

	@When("^Fill up the NFTMint form and click on create btn$")
	public void fill_up_the_NFTMint_form_and_click_on_create_btn() throws Throwable {

		NFTMintPage nftMintPage = new NFTMintPage(bt.driver);
		nftMintPage.mintNFT(bt.pdr);
		Thread.sleep(30000);
	}

	@When("^Confirm the transaction in the Metamask Notification page$")
	public void accept_the_transaction_in_the_Metamask_Notification_page() throws Throwable {

		String parent = bt.driver.getWindowHandle();
		Thread.sleep(5000);
		Set<String> wh = bt.driver.getWindowHandles();
		String child = ReusableLibraries.getChildWindow(parent, wh);
		bt.driver.switchTo().window(child);

		MetaMaskNotificationPage mmnp = new MetaMaskNotificationPage(bt.driver);
		mmnp.clickOnConfirmBtn();
		Thread.sleep(10000);

		bt.driver.switchTo().window(parent);

		HomePage hp = new HomePage(bt.driver);
		hp.clickOnClosePopUpBtn();
	}

	@Then("^Validate that NFT is minted$")
	public void nft_is_minted() throws Throwable {

		HomePage hp = new HomePage(bt.driver);
		hp.clickOnViewAllLnk();

		TopSellingPage tsp = new TopSellingPage(bt.driver);
		tsp.validateTheNFTByName(bt.pdr.getPropertyvalue("Title"));

		bt.driver.close();
	}

	@When("^user clicks on Buy Now btn for the specified NFT$")
	public void user_clicks_on_Buy_Now_btn_for_the_specified_NFT() throws Throwable {

		HomePage hp = new HomePage(bt.driver);
		
		hp.clickOnViewAllLnk();
		hp.clickOnBuyNowBtnForNFT(bt.pdr.getPropertyvalue("NFTToBuy"));
	}

	@Then("^validate purchased NFT on My Collection tab under MyProfile section$")
	public void validate_purchased_NFT_on_My_Collection_tab_under_MyProfile_section() throws Throwable {

		TopSellingPage tsp = new TopSellingPage(bt.driver);
		tsp.clickOnMyProfileLink();
		
		MyProfilePage mpp = new MyProfilePage(bt.driver);
		mpp.clickOnMyCollectionsTab();
		mpp.validateThePurchasedNFT(bt.pdr.getPropertyvalue("NFTToBuy"));

		bt.driver.close();
	}
}