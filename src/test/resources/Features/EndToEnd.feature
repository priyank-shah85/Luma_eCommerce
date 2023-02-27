Feature: Testing of end to end flows.

Background:
	Given user navigates to "https://magento.softwaretestingboard.com/"

# This is for Men and Women products.	
@smoke @sanity @regression @Critical
Scenario Outline: Verify that new user can register, buy men/women product and can view the history under My Orders after login.
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
	And user can see "Shipping Address" step
	And user can see First Name
	And user can see Last Name
	And user enters "Test1" in Street Address1
	And user enters "Test2" in Street Address2
	And user enters "Test3" in Street Address3
	And user enters "Test" in City
	And user selects "United States" Country
	And user selects "Washington" Region
	And user enters "12345-1234" Post Code
	And user enters "1234567890" Phone Number
	And user can see "Shipping Methods" step
	And user selects "Table Rate" shipping method
	And user clicks on Next button
	And user can see "Payment Method" step
	And user clicks on Place Order button
	Then user can see page heading as "Thank you for your purchase!"
	And user can see order number
	And user clicks on My Account link
	And user clicks on My Orders link
	And user can see the same order number present under "Order #" column
	
	Examples:
	|main_menu	|sub_menu	|product_link					 |product_name							 |product_size	|product_color |cart_confirmation															 						 |
	|Men				|Tops			|Tees									 |Zoltan Gym Tee 						 |L							|Yellow				 |You added Zoltan Gym Tee to your shopping cart.						 |
	|Men				|Bottoms	|Pants								 |Geo Insulated Jogging Pant |34						|Green				 |You added Geo Insulated Jogging Pant to your shopping cart.|
	|Women			|Tops			|Hoodies & Sweatshirts |Eos V-Neck Hoodie					 |XS						|Orange				 |You added Eos V-Neck Hoodie to your shopping cart.				 |
	|Women			|Tops			|Jackets							 |Inez Full Zip Jacket			 |L							|Purple				 |You added Inez Full Zip Jacket to your shopping cart.			 |

# This is for Gear products.	
@sanity @regression @Major
Scenario Outline: Verify that new user can register, buy Gear product and can view the history under My Orders after login.
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
	And user opens "<main_menu>" menu
	And user hovers on "<sub_menu>" sub menu
	And user can see page heading as "<product_link>"
	And user clicks on "<product_name>" product
	And user can see page heading as "<product_name>"
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
	And user can see "Shipping Address" step
	And user can see First Name
	And user can see Last Name
	And user enters "Test1" in Street Address1
	And user enters "Test2" in Street Address2
	And user enters "Test3" in Street Address3
	And user enters "Test" in City
	And user selects "United States" Country
	And user selects "Washington" Region
	And user enters "12345-1234" Post Code
	And user enters "1234567890" Phone Number
	And user can see "Shipping Methods" step
	And user selects "Table Rate" shipping method
	And user clicks on Next button
	And user can see "Payment Method" step
	And user clicks on Place Order button
	Then user can see page heading as "Thank you for your purchase!"
	And user can see order number
	And user clicks on My Account link
	And user clicks on My Orders link
	And user can see the same order number present under "Order #" column
	
	Examples:
	|main_menu |sub_menu					|product_link				|product_name				 |cart_confirmation															 		 	 |
	|Gear			 |Bags							|Bags								|Driven Backpack 		 |You added Driven Backpack to your shopping cart.		 |
	|Gear			 |Watches					  |Watches						|Summit Watch				 |You added Summit Watch to your shopping cart. 			 |
	|Gear			 |Fitness Equipment |Fitness Equipment	|Affirm Water Bottle |You added Affirm Water Bottle to your shopping cart. |
		
# This is for Men and Women products
@sanity @regression @Critical
Scenario Outline: Verify that existng user can buy Men & Women products and can view the history under My Orders after login.
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
	And user can see "Shipping Address" step
	And user clicks on Next button
	And user can see "Payment Method" step
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
	
# This is for Gear products
@regression @Major @temp
Scenario Outline: Verify that existng user can buy Gear products and can view the history under My Orders after login.
	When user clicks on Sign In link
	And user enters email as "<email>"
	And user enters password as "<password>"
	And user clicks on Sign In button
	And user clicks on LUMA logo
	And user opens "<main_menu>" menu
	And user hovers on "<sub_menu>" sub menu
	And user can see page heading as "<product_link>"
	And user clicks on "<product_name>" product
	And user can see page heading as "<product_name>"
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
	And user can see "Shipping Address" step
	And user clicks on Next button
	And user can see "Payment Method" step
	And user can see "Order Summary" section
	And user clicks on Place Order button
	Then user can see page heading as "Thank you for your purchase!"
	And user can see order number
	And user clicks on My Account link
	And user clicks on My Orders link
	And user can see the same order number present under "Order #" column
	
	Examples:
	|email					|password	 |main_menu	|sub_menu					 |product_link			|product_name				|cart_confirmation															 		 |
	|p2.s2@test.com |Test@1234 |Gear			|Bags							 |Bags							|Fusion Backpack 		|You added Fusion Backpack to your shopping cart.		 |
	|p2.s2@test.com |Test@1234 |Gear			|Watches					 |Watches						|Dash Digital Watch	|You added Dash Digital Watch to your shopping cart. |
	|p2.s2@test.com |Test@1234 |Gear			|Fitness Equipment |Fitness Equipment	|Sprite Foam Roller |You added Sprite Foam Roller to your shopping cart. |
	
	