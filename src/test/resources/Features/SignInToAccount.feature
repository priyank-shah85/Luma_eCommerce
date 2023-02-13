Feature: Testing the Sign In functionality.

In order to login to existing account
As a user
I want to test the different credentials

Background:
	Given user navigates to "https://magento.softwaretestingboard.com/"
	When user clicks on Sign In link
	And user can see page heading as "Customer Login"
	
@smoke @sanity @regression @Critical
Scenario: Verify user can login successfully with valid credentials.
	And user enters email as "p1.s1@test.com"
	And user enters password as "Test@1234"
	And user clicks on Sign In button
	Then user will see "Welcome, " text on top right corner of the page
	
@regression @Major
Scenario Outline: Verify the red asterisk sign for both the fields.
	Then user can see red asterisk sign next to "<field>"
	
	Examples:
	|field 		|
	|Email 		|
	|Password |
	
@sanity @regression @Major
Scenario: Verify the mandatory validation for both the fields.
	And user clicks on Sign In button
	Then user will see validation message for both fields
	
@sanity @regression @Major
Scenario Outline: Verify that Email accepts input only in valid format.
	And user enters password as "Test@1234"
	And user enters email as "<email_address>"
	And user clicks on Sign In button
	Then user can see error message "Please enter a valid email address (Ex: johndoe@domain.com)." for incorrect email format
	
	Examples:
	|email_address 	|
	|asdfasdf				|
	|p1.s1					|
	|p1.s1@test			|
	|@test.com			|
	|@test					|
	
@sanity @regression @Major
Scenario: Verify that user can redirect to create new customer account.
	And user clicks on Create an Account button present under New Customers section
	Then user redirects to "Create New Customer Account" page
	
@regression @Minor
Scenario: Verify the Forgot Password link is present on page.
	Then "Forgot Your Password?" link is present on page
	
	