Feature: Testing of end to end flows.

Background:
	Given user navigates to "https://magento.softwaretestingboard.com/"
	
@smoke @sanity @regression @Critical
Scenario: Verify that new user can register, place an order successfully and can view the history under My Orders after login.
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
	And user clicks on LUMA logo
	And user opens Mens menu
	And user hovers on Tops sub menu
	And user clicks on Tees link
	And user can see page heading as "Tees"
	And user clicks on "Zoltan Gym Tee" product
	And user can see page heading as "Zoltan Gym Tee"
	And user selects "L" size
	And user select "Yellow" color
	And user clicks on Add to Cart button
	And user can see "You added Zoltan Gym Tee to your shopping cart." message on top of the same page
	And user can see "1" product added next to cart icon
	And user clicks on cart icon
	And user clicks on View and Edit Cart link from minicart
	And user can see page heading as "Shopping Cart"
	And user can see "Zoltan Gym Tee" presents as "Item"
	And user can see total amount for the product
	And user clicks on Proceed to Checkout button
	And user can see page heading as "Checkout"
	And user lands on "Shipping Address" step
	And user clicks on Next button
	And user lands on "Payment Method" step
	And user can see "Order Summary" section
	And user clicks on Place Order button
	Then user can see page heading as "Thank you for your purchase!"
	And user can see order number
	And user clicks on My Account link
	And user clicks on My Orders link
	And user can see the same order number present under "Order #" column
	
@smoke @sanity @regression @Critical @temp
Scenario Outline: Verify that existng user can place an order successfully and can view the history under My Orders after login.
	When user clicks on Sign In link
	And user enters email as "<email>"
	And user enters password as "<password>"
	And user clicks on Sign In button
	And user clicks on LUMA logo
	And user opens "<main_menu>" menu
	And user hovers on "<sub_menu>" sub menu
	And user clicks on "<product_link>" link
	And user can see page heading as "<product_link>"
	And user clicks on "<product_name>" product
	And user can see page heading as "<product_name>"
	And user selects "<product_size>" size
	And user select "<product_color>" color
	And user clicks on Add to Cart button
	And user can see "<cart_confirmation>" message on top of the same page
	And user can see "1" product added next to cart icon
	And user clicks on cart icon
	And user clicks on View and Edit Cart link from minicart
	And user can see page heading as "Shopping Cart"
	And user can see "<product_name>" presents as "Item"
	And user can see total amount for the product
	And user clicks on Proceed to Checkout button
	And user can see page heading as "Checkout"
	And user lands on "Shipping Address" step
	And user clicks on Next button
	And user lands on "Payment Method" step
	And user can see "Order Summary" section
	And user clicks on Place Order button
	Then user can see page heading as "Thank you for your purchase!"
	And user can see order number
	And user clicks on My Account link
	And user clicks on My Orders link
	And user can see the same order number present under "Order #" column
	
	Examples:
	|email					|password	 |main_menu	|sub_menu	|product_link	|product_name				 	 |product_size |product_color	|cart_confirmation															 				|
	|p2.s2@test.com |Test@1234 |Men				|Tops			|Tees					|Zoltan Gym Tee 		 	 |L						 |Yellow				|You added Zoltan Gym Tee to your shopping cart. 				|
	|p2.s2@test.com |Test@1234 |Women			|Bottoms	|Shorts				|Fiona Fitness Short 	 |29					 |Black					|You added Fiona Fitness Short to your shopping cart. 	|
	|p2.s2@test.com |Test@1234 |Men				|Tops			|Tanks				|Cassius Sparring Tank |XL					 |Blue					|You added Cassius Sparring Tank to your shopping cart. |
	|p2.s2@test.com |Test@1234 |Women			|Tops			|Bras & Tanks	|Maya Tunic						 |S						 |White					|You added Maya Tunic to your shopping cart. 						|
	
	