Feature: Testing the My Account page.

In order to verify the My Account page
As a user
I want to login with valid credentails

Background:
	Given user navigates to "https://magento.softwaretestingboard.com/"
	When user clicks on Sign In link
	And user enters email as "p1.s1@test.com"
	And user enters password as "Test@1234"
	And user clicks on Sign In button
	And user can see page heading as "My Account"
	
@regression @Minor @temp
Scenario: Verify the page is showing Account Information section
	Then user can see the "Account Information" section
	
@smoke @sanity @regression @Critical @temp
Scenario Outline: Verify the left side links.
	Then user can see the "<links>" from left side panel
	
	Examples:
	|links										|
	|My Account								|
	|My Orders								|
	|My Downloadable Products	|
	|My Wish List							|
	|Address Book							|
	|Account Information			|
	|Stored Payment Methods		|
	|My Product Reviews				|
	|Newsletter Subscriptions	|