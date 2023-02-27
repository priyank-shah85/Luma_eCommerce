Feature: Testing of Minicart.

Background:
	Given user navigates to "https://magento.softwaretestingboard.com/"

@regression @Minor
Scenario: Verify that Minicart shows proper message when no product is added to cart, without login.
	When user clicks on cart icon
	Then user can see "You have no items in your shopping cart." message in cart pop up
	
@regression @Minor
Scenario: Verify that Minicart shows proper message when no product is added to cart, with existing user login.
	When user clicks on Sign In link
	And user enters email as "p2.s2@test.com"
	And user enters password as "Test@1234"
	And user clicks on Sign In button
	And user clicks on cart icon
	Then user can see "You have no items in your shopping cart." message in cart pop up
	
@regression @Minor
Scenario: Verify that Minicart shows proper message when no product is added to cart, with new registration.
	When user clicks on Create an Account link
	And user redirects to "Create New Customer Account" page
	And user enters First Name
	And user enters Last Name
	And user sign up for Newsletter
	And user enters Email
	And user enters Password
	And user enters same Password in Confirm Password
	And user clicks on Create an Account button
	And user will see "Thank you for registering with Fake Online Clothing Store." message on next page
	And user clicks on cart icon
	Then user can see "You have no items in your shopping cart." message in cart pop up
	
@regression @Minor
Scenario: Verify the Minicart closes when user clicks anywhere outside of it.
	When user clicks on cart icon
	And user can see "You have no items in your shopping cart." message in cart pop up
	And user clicks on outside the cart
	Then Minicart will be closed
	
@regression @Major
Scenario: Verify that Proceed to Checkout button is visible as soon as user adds first product to cart, without login.
	When user clicks on cart icon
	And user can see "You have no items in your shopping cart." message in cart pop up
	And user opens "Men" menu
	And user hovers on "Tops" sub menu
	And user clicks on "Jackets" link
	And user can see page heading as "Jackets"
	And user clicks on "Proteus Fitness Jackshirt" product
	And user can see page heading as "Proteus Fitness Jackshirt"
	And user selects "M" size
	And user select "Orange" color
	And user clicks on Add to Cart button
	And user can see "You added Proteus Fitness Jackshirt to your shopping cart." message on top of the same page
	And user clicks on cart icon
	Then user can see "Proceed to Checkout" button
	And button is in Blue color
	And button text is in White color
	
@regression @Minor
Scenario: Verify the Remove Item icon.
	When user opens "Gear" menu
	And user hovers on "Watches" sub menu
	And user can see page heading as "Watches"
	And user clicks on "Clamber Watch" product
	And user can see page heading as "Clamber Watch"
	And user clicks on Add to Cart button
	And user can see "You added Clamber Watch to your shopping cart." message on top of the same page
	And user clicks on cart icon
	Then user can see Remove Item icon in Minicart
	
@regression @Major
Scenario: User clicks Cancel on the Remove Item pop up of Minicart, for single product.
	When user opens "Gear" menu
	And user hovers on "Watches" sub menu
	And user can see page heading as "Watches"
	And user clicks on "Clamber Watch" product
	And user can see page heading as "Clamber Watch"
	And user clicks on Add to Cart button
	And user can see "You added Clamber Watch to your shopping cart." message on top of the same page
	And user clicks on cart icon
	And user clicks on Remove Item icon in Minicart
	And user can see pop up with "Are you sure you would like to remove this item from the shopping cart?" text
	And user clicks on "Cancel" button
	And user clicks on cart icon
	Then user can see the product exists in Minicart
	
@regression @Major
Scenario: User clicks OK on the Remove Item pop up of Minicart, for single product.
	When user opens "Gear" menu
	And user hovers on "Watches" sub menu
	And user can see page heading as "Watches"
	And user clicks on "Clamber Watch" product
	And user can see page heading as "Clamber Watch"
	And user clicks on Add to Cart button
	And user can see "You added Clamber Watch to your shopping cart." message on top of the same page
	And user clicks on cart icon
	And user clicks on Remove Item icon in Minicart
	And user can see pop up with "Are you sure you would like to remove this item from the shopping cart?" text
	And user clicks on "OK" button
	Then user can see "You have no items in your shopping cart." message in cart pop up
	
	