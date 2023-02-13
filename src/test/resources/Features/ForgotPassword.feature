Feature: Testing the Forgot Password functionality.

In order to reset the password
As a user
I want to enter the exisitng email address

Background:
	Given user navigates to "https://magento.softwaretestingboard.com/"
	When user clicks on Sign In link
	And user clicks on Forgot Password link

@smoke @sanity @regression @Critical
Scenario: Verify the Forgot Password functionality.
	And user can see page heading as "Forgot Your Password?"
	And user enters Email
	And user manaully enters captcha
	And user clicks on Reset My Password button
	And user can see page heading as "Customer Login"
	Then user will see confirmation message for reset password outcome