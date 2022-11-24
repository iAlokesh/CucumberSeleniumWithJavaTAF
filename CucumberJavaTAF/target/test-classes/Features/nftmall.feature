Feature: NFT Mint and Buy

@create
Scenario: Create NFT
Given User is on NFTMall homepage
When User navigated to the NFTMint page
And Fill up the NFTMint form and click on create btn
And Confirm the transaction in the Metamask Notification page
Then Validate that NFT is minted 

@buy
Scenario: Buy NFT
Given User is on NFTMall homepage
When user clicks on Buy Now btn for the specified NFT
And Confirm the transaction in the Metamask Notification page
Then validate purchased NFT on My Collection tab under MyProfile section