package stepDefinitions;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.CreateAccountPage;

public class CreateAccountPageSteps {
	
	WebDriver driver;
	CreateAccountPage cap = new CreateAccountPage(HomePageSteps.driver);
	
	Logger logger = HomePageSteps.logger;
	
	// Background steps
	@And("user redirects to {string} page")
	public void user_redirects_to_page(String expectedTitle) {
		try {
			Assert.assertTrue("Incorrect page title.", cap.verifyCreateAccountPageTitle(expectedTitle));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Something wrong with Create Account page.");
		}
	}
	
	// Steps for page details
	@And("user clicks on Create an Account button")
	public void user_clicks_on_create_anaAccount_button() {
		try {
			cap.clickCreateAccountBtn();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to create new account.");
		}
	}
	
	@Then("user can see both {string} and {string} sections on page")
	public void user_can_see_both_and_sections_on_page(String section1, String section2) {
		try {
			Assert.assertTrue("One or both sections are missing on page. Check the detailed log for exact section name.", 
					cap.verifyBothSections(section1, section2));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Can't verify any section.");
		}
	}
	
	// Steps for both sections
	@And("the first field is {string}")
	public void the_first_field_is(String fieldName) {
		try {
			Assert.assertTrue("First field is missing.", cap.verifyFirstField(fieldName));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Can't verify first field.");
		}
	}
	
	@And("the second field is {string}")
	public void the_second_field_is(String fieldName) {
		try {
			Assert.assertTrue("Second field is missing.", cap.verifySecondField(fieldName));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Can't verify second field.");
		}
	}
	
	@And("the third field is {string}")
	public void the_third_field_is(String fieldName) {
		try {
			Assert.assertTrue("Third field is missing.", cap.verifyThirdField(fieldName));
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Can't verify third field.");
		}
	}
	
	// Steps for Personal Information section
	@Then("user will see three fields under Personal Information section")
	public void user_will_see_three_fields_under_personal_information_section() {
		try {
			Assert.assertTrue("Personal Information section does not have correct 3 fields.", cap.verifyPersonalInformationFields());
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail();
		}
	}
	
	@And("user enters First Name")
	public void user_enters_first_name() {
		try {
			cap.enterFirstName();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to enter First Name.");
		}
	}
	
	@And("user enters Last Name")
	public void user_enters_last_name() {
		try {
			cap.enterLastName();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to enter Last Name.");
		}
	}
	
	@And("user sign up for Newsletter")
	public void user_sign_up_for_newsletter() {
		try {
			cap.checkNewletterSignUp();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to sign up for newsletter.");
		}
	}
	
	// steps for Sign-in Information section
	@Then("user will see three fields under Sign-in Information section")
	public void user_will_see_three_fields_under_sing_in_information_section() {
		try {
			Assert.assertTrue("Sign-in Information section does not have correct 3 fields.", cap.verifySigninInformationFields());
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail();
		}
	}
	
	@And("user enters Email")
	public void user_enters_email() {
		try {
			cap.enterEmail();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to enter Email.");
		}
	}
	
	@And("user enters Password")
	public void user_enters_password() {
		try {
			cap.enterPassword();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to enter Password.");
		}
	}
	
	@And("user enters same Password in Confirm Password")
	public void user_enters_same_password_in_confirm_password() {
		try {
			cap.enterConfirmPassword();
		}
		catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail("Not able to enter Confirm Password.");
		}
	}

}
