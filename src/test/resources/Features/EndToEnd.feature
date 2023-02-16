Feature: Testing of end to end flows.

Background:
	Given user navigates to "https://magento.softwaretestingboard.com/"
	
@smoke @sanity @regression @Critical @temp
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
	And user select yellow color
	And user clicks on Add to Cart button
	And user can see "You added Zoltan Gym Tee to your shopping cart." message on top of the same page
	And user can see one product added next to cart icon
	And user clicks on cart icon
	And user clicks on View and Edit Cart link from cart pop up
	And user can see page heading as "Shopping Cart"
	And user can see "Zoltan Gym Tee" presents in the cart
	And user can see total amount for the product
	And user clicks on Proceed to Checkout button
	And user can see page heading as "Checkout"
	And user lands on "Shipping Address" step
	And user clicks on Next button
	And user moves to "Payment Method" step
	And user can see "Order Summary" section
	And user clicks on Place Order button
	Then user can see page heading as "Thank you for your purchase!"
	And user can see order number
	And user clicks on My Account link
	And user clicks on My Orders link
	And user can see the same order number present under order history table