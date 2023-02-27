Feature: Verify Product List page.

As a user, I want to verify Product List page

Background:
	Given user navigates to "https://magento.softwaretestingboard.com/"

# This is for Men & Women product categories.
@regression @Major
Scenario Outline: Verify that by default list of Men & Women shows maximum 12 products on first page, without sign in.
	When user opens "<main_menu>" menu
	And user hovers on "<sub_menu>" sub menu
	And user clicks on "<product_link>" link
	And user can see page heading as "<product_link>"
	Then user can see maximum "12" products on page
	
	Examples:
	|main_menu |sub_menu |product_link				  |
	|Men			 |Tops		 |Jackets							  |
	|Men			 |Tops		 |Hoodies & Sweatshirts |
	|Men			 |Tops		 |Tees 									|
	|Men			 |Tops		 |Tanks 								|
	|Men			 |Bottoms	 |Pants 								|
	|Men			 |Bottoms	 |Shorts 								|
	|Women		 |Tops		 |Jackets							  |
	|Women		 |Tops		 |Hoodies & Sweatshirts |
	|Women		 |Tops		 |Tees 									|
	|Women		 |Tops		 |Bras & Tanks 					|
	|Women		 |Bottoms	 |Pants 								|
	|Women		 |Bottoms	 |Shorts 								|

# This is for Gear product categories.
@regression @Major
Scenario Outline: Verify that by default list of Gear shows maximum 12 products on first page, without sign in.
	When user opens "<main_menu>" menu
	And user hovers on "<sub_menu>" sub menu
	And user can see page heading as "<product_link>"
	Then user can see maximum "12" products on page
	
	Examples:
	|main_menu |sub_menu 					|product_link			 |
	|Gear			 |Bags		 					|Bags							 |
	|Gear			 |Fitness Equipment |Fitness Equipment |
	|Gear			 |Watches		 				|Watches 					 |
	
# This is for Men & Women product categories.
@regression @Minor
Scenario Outline: Verify that by default list of Men & Women shows maximum 12 products on first page, after sign in.
	When user clicks on Sign In link
	And user enters email as "<email>"
	And user enters password as "<password>"
	And user clicks on Sign In button
	And user opens "<main_menu>" menu
	And user hovers on "<sub_menu>" sub menu
	And user clicks on "<product_link>" link
	And user can see page heading as "<product_link>"
	Then user can see maximum "12" products on page
	
	Examples:
	|email					|password	 |main_menu |sub_menu |product_link				  |
	|p2.s2@test.com	|Test@1234 |Men			 |Tops		 |Jackets							  |
	|p2.s2@test.com	|Test@1234 |Men			 |Tops		 |Hoodies & Sweatshirts |
	|p2.s2@test.com	|Test@1234 |Men			 |Tops		 |Tees 									|
	|p2.s2@test.com	|Test@1234 |Men			 |Tops		 |Tanks 								|
	|p2.s2@test.com	|Test@1234 |Men			 |Bottoms	 |Pants 								|
	|p2.s2@test.com	|Test@1234 |Men			 |Bottoms	 |Shorts 								|
	|p2.s2@test.com	|Test@1234 |Women		 |Tops		 |Jackets							  |
	|p2.s2@test.com	|Test@1234 |Women		 |Tops		 |Hoodies & Sweatshirts |
	|p2.s2@test.com	|Test@1234 |Women		 |Tops		 |Tees 									|
	|p2.s2@test.com	|Test@1234 |Women		 |Tops		 |Bras & Tanks 					|
	|p2.s2@test.com	|Test@1234 |Women		 |Bottoms	 |Pants 								|
	|p2.s2@test.com	|Test@1234 |Women		 |Bottoms	 |Shorts 								|

# This is for Gear product categories.
@regression @Minor
Scenario Outline: Verify that by default list of Gear shows maximum 12 products on first page, after sign in.
	When user clicks on Sign In link
	And user enters email as "<email>"
	And user enters password as "<password>"
	And user clicks on Sign In button
	And user opens "<main_menu>" menu
	And user hovers on "<sub_menu>" sub menu
	And user can see page heading as "<product_link>"
	Then user can see maximum "12" products on page
	
	Examples:
	|email					|password	 |main_menu  |sub_menu 					|product_link			 |
	|p2.s2@test.com	|Test@1234 |Gear			 |Bags		 					|Bags							 |
	|p2.s2@test.com	|Test@1234 |Gear			 |Fitness Equipment |Fitness Equipment |
	|p2.s2@test.com	|Test@1234 |Gear			 |Watches		 				|Watches 					 |
	
@regression @Minor̥
Scenario Outline: Verify that user can move to next page if total products are more than 12.
	When user opens "<main_menu>" menu
	And user clicks on "<sub_menu>" sub menu
	And user can see page heading as "<sub_menu>"
	And page has more than 12 products
	Then user can move to next page till all products dipslayed
	
	Examples:
	|main_menu |sub_menu |
	|Men			 |Tops		 |
	|Women		 |Bottoms	 |
	|Men			 |Bottoms	 |
	|Women		 |Tops		 |
	
@sanity @regression @Major
Scenario Outline: Verify the Shopping Options.
	When user opens "<main_menu>" menu
	And user clicks on "<sub_menu>" sub menu
	And user can see page heading as "<sub_menu>"
	And user can see "Shopping Options" block on left side
	Then user can see "<shopping_option>" on left side
	And the "<shopping_option>" is below the "<previous_option>"
	
	Examples:
	|main_menu |sub_menu |shopping_option 	 |previous_option		 |
	|Men			 |Tops		 |CATEGORY					 |Shopping Options	 |
	|Men			 |Tops		 |STYLE							 |CATEGORY					 |
	|Men			 |Tops		 |SIZE							 |STYLE							 |
	|Men			 |Tops		 |PRICE							 |SIZE							 |
	|Men			 |Tops		 |COLOR							 |PRICE							 |
	|Men			 |Tops		 |MATERIAL					 |COLOR							 |
	|Men			 |Tops		 |ECO COLLECTION		 |MATERIAL					 |
	|Men			 |Tops		 |PERFORMANCE FABRIC |ECO COLLECTION		 |
	|Men			 |Tops		 |ERIN RECOMMENDS		 |PERFORMANCE FABRIC |
	|Men			 |Tops		 |NEW								 |ERIN RECOMMENDS		 |
	|Men			 |Tops		 |SALE							 |NEW								 |
	|Men			 |Tops		 |PATTERN						 |SALE							 |
	|Men			 |Tops		 |CLIMATE						 |PATTERN						 |
	|Men			 |Bottoms	 |CATEGORY					 |Shopping Options	 |
	|Men			 |Bottoms	 |STYLE							 |CATEGORY					 |
	|Men			 |Bottoms	 |SIZE							 |STYLE							 |
	|Men			 |Bottoms	 |PRICE							 |SIZE							 |
	|Men			 |Bottoms	 |COLOR							 |PRICE							 |
	|Men			 |Bottoms	 |MATERIAL					 |COLOR							 |
	|Men			 |Bottoms	 |ECO COLLECTION		 |MATERIAL					 |
	|Men			 |Bottoms	 |PERFORMANCE FABRIC |ECO COLLECTION		 |
	|Men			 |Bottoms	 |ERIN RECOMMENDS		 |PERFORMANCE FABRIC |
	|Men			 |Bottoms	 |NEW								 |ERIN RECOMMENDS		 |
	|Men			 |Bottoms	 |SALE							 |NEW								 |
	|Men			 |Bottoms	 |PATTERN						 |SALE							 |
	|Men			 |Bottoms	 |CLIMATE						 |PATTERN						 |
	|Women		 |Tops		 |CATEGORY					 |Shopping Options	 |
	|Women		 |Tops		 |STYLE							 |CATEGORY					 |
	|Women		 |Tops		 |SIZE							 |STYLE							 |
	|Women		 |Tops		 |PRICE							 |SIZE							 |
	|Women		 |Tops		 |COLOR							 |PRICE							 |
	|Women		 |Tops		 |MATERIAL					 |COLOR							 |
	|Women		 |Tops		 |ECO COLLECTION		 |MATERIAL					 |
	|Women		 |Tops		 |PERFORMANCE FABRIC |ECO COLLECTION		 |
	|Women		 |Tops		 |ERIN RECOMMENDS		 |PERFORMANCE FABRIC |
	|Women		 |Tops		 |NEW								 |ERIN RECOMMENDS		 |
	|Women		 |Tops		 |SALE							 |NEW								 |
	|Women		 |Tops		 |PATTERN						 |SALE							 |
	|Women		 |Tops		 |CLIMATE						 |PATTERN						 |
	|Women		 |Bottoms	 |CATEGORY					 |Shopping Options	 |
	|Women		 |Bottoms	 |STYLE							 |CATEGORY					 |
	|Women		 |Bottoms	 |SIZE							 |STYLE							 |
	|Women		 |Bottoms	 |PRICE							 |SIZE							 |
	|Women		 |Bottoms	 |COLOR							 |PRICE							 |
	|Women		 |Bottoms	 |MATERIAL					 |COLOR							 |
	|Women		 |Bottoms	 |ECO COLLECTION		 |MATERIAL					 |
	|Women		 |Bottoms	 |PERFORMANCE FABRIC |ECO COLLECTION		 |
	|Women		 |Bottoms	 |ERIN RECOMMENDS		 |PERFORMANCE FABRIC |
	|Women		 |Bottoms	 |NEW								 |ERIN RECOMMENDS		 |
	|Women		 |Bottoms	 |SALE							 |NEW								 |
	|Women		 |Bottoms	 |PATTERN						 |SALE							 |
	|Women		 |Bottoms	 |CLIMATE						 |PATTERN						 |
	
@smoke @sanity @regression @Critical @temp
Scenario: Verify that user can add product to cart from list page.
	When user opens "Men" menu
	And user hovers on "Tops" sub menu
	And user clicks on "Jackets" link
	And user can see page heading as "Jackets"
	And user selects "M" size for "Montana Wind Jacket" product
	And user selects "Green" color for "Montana Wind Jacket" product
	And user clicks on Add to Cart button for "Montana Wind Jacket" product
	Then user can see "You added Montana Wind Jacket to your shopping cart." message on top of the same page
	And user can see "1" product added next to cart icon
	
	