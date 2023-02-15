Feature: Testing the My Orders page.

As a user, I want to verify my order history.

Background:
	Given user navigates to "https://magento.softwaretestingboard.com/"
	When user clicks on Sign In link
	And user enters email as "p1.s1@test.com"
	And user enters password as "Test@1234"
	And user clicks on Sign In button
	And user clicks on My Account link
	And user clicks on My Orders link
	
@sanity @regression @Major
Scenario: Verify the message when there is no order placed by logged in user.
	And user logs out from the account
	And user clicks on Sign In link
	And user enters email as "p1.noorder@test.com"
	And user enters password as "Test@1234"
	And user clicks on Sign In button
	And user clicks on My Orders link
	Then user can see "You have placed no orders." message