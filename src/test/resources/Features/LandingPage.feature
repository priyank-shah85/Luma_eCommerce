Feature: Landing on home page and verifying the entire page.

In order to verify the landing page
As a user
I want to test the various elements on home page

Background:
	Given user navigates to "https://magento.softwaretestingboard.com/"
	When user can see the "Default welcome msg!" on page

@smoke @sanity @regression @Critical
Scenario: Verifying the correct landing page by browser title assertion.
	Then user can see browser title as "Home Page - Magento eCommerce - website to practice selenium | demo website for automation testing | selenium practice sites | selenium demo sites | best website to practice selenium automation | automation practice sites Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites"
	
@Sanity @regression @Critical @temp
Scenario: Verifying the correct image on landing page.
	Then user can see the LUMA image on page

@regression @Minor
Scenario Outline: Verify the top menu links.
	Then user can see the "<link>" in top menu item
	
	Examples:
	|link				|
	|What's New	|
	|Women			|
	|Men				|
	|Gear				|
	|Training		|
	|Sale				|
	
@regression @Major
Scenario: Verify the search box.
	And search box is present on the page
	And search box has placeholder present as "Search entire store here..."
	Then search icon is disabled to user
	
@sanity @regression @Major
Scenario Outline: Verify the search with valid terms.
	And search box is present on the page
	And user enters "<keyword>" in search box
	And user hits enter on keyboard
	Then user will redirect to page where heading contains the "<keyword>" after "Search results for: " text
	And user will see various "<keyword>" links under "Related search terms" section
	
	Examples:
	|keyword	|
	|jackets	|
	|pants		|
	|bags			|
	
@regression @Minor
Scenario Outline: Verify the search with invalid terms.
	And search box is present on the page
	And user enters "<keyword>" in search box
	And user hits enter on keyboard
	Then user will redirect to page where heading contains the "<keyword>" after "Search results for: " text
	And user will see "Your search returned no results." message on page
	
	Examples:
	|keyword 						|
	|Test123456 				|
	|$$##@@& 						|
	|malicious input&^% |
	
@regression @Major
Scenario: Verify the Video Download link.
	And user opens "Training" menu
	And user hovers on "Video Download" sub menu
	And user can see page heading as "Video Download"
	Then user can see "We can't find products matching the selection." message on page
