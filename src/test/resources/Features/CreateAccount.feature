Feature: Testing the Create Account functionality.

In order to create a new account
As a user
I want to test the different combinations of inputs

Background:
	Given user navigates to "https://magento.softwaretestingboard.com/"
	When user clicks on Create an Account link
	And user redirects to "Create New Customer Account" page
	
@smoke @sanity @regression @Critical
Scenario: Verify that user can create a new account with valid inputs to only mandatory fields.
	And user enters First Name
	And user enters Last Name
	And user enters Email
	And user enters Password
	And user enters same Password in Confirm Password
	And user clicks on Create an Account button
	Then user will see "Thank you for registering with Fake Online Clothing Store." message on next page

@regression @Minor
Scenario: Verify sections present on page.
	Then user can see both "Personal Information" and "Sign-in Information" sections on page
	
@sanity @regression @Major
Scenario: Verify fields under Personal Information section.
	Then user will see three fields under Personal Information section
	And the first field is "First Name"
	And the second field is "Last Name"
	And the third field is "Sign Up for Newsletter"
	
@sanity @regression @Major
Scenario: Verify fields under Sign-in Information section.
	Then user will see three fields under Sign-in Information section
	And the first field is "Email"
	And the second field is "Password"
	And the third field is "Confirm Password"
	
@sanity @regression @Critical
Scenario: Verify that user can create a new account with valid inputs for all the fields.
	And user enters First Name
	And user enters Last Name
	And user sign up for Newsletter
	And user enters Email
	And user enters Password
	And user enters same Password in Confirm Password
	And user clicks on Create an Account button
	Then user will see "Thank you for registering with Fake Online Clothing Store." message on next page
	
@smoke @sanity @regression @Critical
Scenario: Verify that newly registered user can login subsequently with same credentials.
	And user enters First Name
	And user enters Last Name
	And user enters Email
	And user enters Password
	And user enters same Password in Confirm Password
	And user clicks on Create an Account button
	And user will see "Thank you for registering with Fake Online Clothing Store." message on next page
	And user logs out from the account
	And user clicks on Sign In link
	And user enters newly registered email
	And user enters password for above email
	And user clicks on Sign In button
	Then user will see "Welcome, " text along with first & last name at top right corner of the page

	