Feature: Integration scenario verification.

This has use case of integration between different modules.

Background:
	Given user navigates to "https://magento.softwaretestingboard.com/"
	
# This use case is for integration between Landing Page, Create Account, Sign In & My Account.
@sanity @regression @Critical
Scenario: Verify the Contact Information details on My Account page after doing successfull registration.
	When user clicks on Create an Account link
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
	Then user can see above First Name, Last Name & Email under "Contact Information"
	And user can see "Edit" and "Change Password" links
	
# This use case is for integration between Landing Page, Create Account, Sign In & My Account.
@sanity @regression @Major
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
	
# This use case is for integration between Landing Page, Sign In, My Account & Address Book.
@sanity @regression @Major
Scenario: Verify the Default Billing and Shipping address when there is no record present in Address Book.
	When user clicks on Sign In link
	And user enters email as "p1.s1@test.com"
	And user enters password as "Test@1234"
	And user clicks on Sign In button
	And user clicks on My Account link
	And user clicks on Address Book link
	And user can see page heading as "Add New Address"
	And user clicks on browser back button
	Then user can see "You have not set a default billing address." message under "Default Billing Address" billing section
	And user can see "You have not set a default shipping address." message under "Default Shipping Address" shipping section
	
# This use case is for integration between Landing Page, Sign In, My Account & Address Book.
@sanity @regression @Major
Scenario: Verify the Default Billing and Shipping address when there is default record exists in Address Book.
	When user clicks on Sign In link
	And user enters email as "p2.s2@test.com"
	And user enters password as "Test@1234"
	And user clicks on Sign In button
	And user clicks on My Account link
	And user clicks on Address Book link
	And user can see page heading as "Address Book"
	And user stores Default Billing Address
	And user stores Default Shipping Address
	And user clicks on browser back button
	Then user can see same Default Billing Address
	And user can see same Default Shipping Address
	