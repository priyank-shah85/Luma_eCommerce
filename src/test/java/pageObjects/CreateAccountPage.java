package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import cucumber.ScenarioContext;
import enums.Context;

public class CreateAccountPage extends BasePage {

	public CreateAccountPage(WebDriver driver) {
		super(driver);
	}
	
	Faker faker = new Faker();
	public static ScenarioContext sc = new ScenarioContext();
	
	// Elements for page details
	@FindBy(xpath = "//h1[@class='page-title']//span")
	WebElement pageTitle;
	
	@FindBy(xpath = "//button[@title='Create an Account']")
	WebElement btnCreateAccount;
	
	// Elements for Personal Information section
	@FindBy(xpath = "//form[@id='form-validate']//fieldset[1]//legend//span")
	WebElement sectionPersonalInformation;
	
	@FindBy(xpath = "//form[@id='form-validate']//fieldset[1]//div//label")
	List <WebElement> allPersonalInformationFields;
	
	@FindBy(xpath = "//label[@for='firstname']")
	WebElement lblFirstName;
	
	@FindBy(id = "firstname")
	WebElement fldFirstName;
	
	@FindBy(xpath = "//label[@for='lastname']")
	WebElement lblLastName;
	
	@FindBy(id = "lastname")
	WebElement fldLastName;
	
	@FindBy(xpath = "//label[@for='is_subscribed']")
	WebElement lblNewsletterSignUp;
	
	@FindBy(id = "is_subscribed")
	WebElement chkNewsletterSignUp;
	
	// Elements for Sign-in Information section
	@FindBy(xpath = "//form[@id='form-validate']//fieldset[2]//legend//span")
	WebElement sectionSigninInformation;
	
	@FindBy(xpath = "//form[@id='form-validate']//fieldset[2]//div//label")
	List <WebElement> allSigninInformationFields;
	
	@FindBy(xpath = "//label[@for='email_address']")
	WebElement lblEmail;
	
	@FindBy(id = "email_address")
	WebElement fldEmail;
	
	@FindBy(xpath = "//label[@for='password']")
	WebElement lblPassword;
	
	@FindBy(id = "password")
	WebElement fldPassword;
	
	@FindBy(xpath = "//label[@for='password-confirmation']")
	WebElement lblConfirmPassword;
	
	@FindBy(id = "password-confirmation")
	WebElement fldConfirmPassword;
	
	// Action methods for page details
	public boolean verifyCreateAccountPageTitle(String expectedTitle) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(pageTitle));
		if(pageTitle.getText().contentEquals(expectedTitle)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void clickCreateAccountBtn() {
		btnCreateAccount.click();
	}
	
	// Common action methods for both sections
	public boolean verifyBothSections(String expectedName1, String expectedName2) {
		// First fetching the results from individual section methods
		boolean section1 = verifyPersonalInformationSection(expectedName1);
		boolean section2 = verifySigninInformationSection(expectedName2);
		
		// Now comparing the combine outcome of both methods
		if(section1 && section2) {
			System.out.println("Both " + expectedName1 + " and " + expectedName2 + " sections are present on page.");
			return true;
		}
		else if (section1 == true && section2 == false) {
			System.out.println("Only " + expectedName1 + " section is present but " + expectedName2 + " section is missing.");
			return false;
		}
		else if (section1 == false && section2 == true) {
			System.out.println("Only " + expectedName2 + " section is present but " + expectedName1 + " section is missing.");
			return false;
		}
		else {
			System.out.println("Both " + expectedName1 + " and " + expectedName2 + " sections are missing on page.");
			return false;
		}
	}
	
	public boolean verifyFirstField(String fieldName) {
		boolean results = false;
		
		// Verify the Personal Information first field
		if(sc.getContext(Context.SECTION_NAME).toString().contentEquals(sectionPersonalInformation.getText())) {
			if(lblFirstName.getText().contentEquals(fieldName)) {
				results = true;
			}
			else {
				results = false;
			}
		}
		
		// Verify the Sign-in Information first field
		else if(sc.getContext(Context.SECTION_NAME).toString().contentEquals(sectionSigninInformation.getText())) {
			if(lblEmail.getText().contentEquals(fieldName)) {
				results = true;
			}
			else {
				results = false;
			}
		}
		
		else {
			results = false;
		}
		return results;
	}
	
	public boolean verifySecondField(String fieldName) {
		boolean results = false;
		
		// Verify the Personal Information second field
		if(sc.getContext(Context.SECTION_NAME).toString().contentEquals(sectionPersonalInformation.getText())) {
			if(lblLastName.getText().contentEquals(fieldName)) {
				results = true;
			}
			else {
				results = false;
			}
		}
		
		// Verify the Sign-in Information second field
		else if(sc.getContext(Context.SECTION_NAME).toString().contentEquals(sectionSigninInformation.getText())) {
			if(lblPassword.getText().contentEquals(fieldName)) {
				results = true;
			}
			else {
				results = false;
			}
		}
		
		else {
			results = false;
		}
		return results;
	}
	
	public boolean verifyThirdField(String fieldName) {
		boolean results = false;
		
		// Verify the Personal Information third field
		if(sc.getContext(Context.SECTION_NAME).toString().contentEquals(sectionPersonalInformation.getText())) {
			if(lblNewsletterSignUp.getText().contentEquals(fieldName)) {
				results = true;
			}
			else {
				results = false;
			}
		}
		
		// Verify the Sign-in Information third field
		else if(sc.getContext(Context.SECTION_NAME).toString().contentEquals(sectionSigninInformation.getText())) {
			if(lblConfirmPassword.getText().contentEquals(fieldName)) {
				results = true;
			}
			else {
				results = false;
			}
		}
		
		else {
			results = false;
		}
		return results;
	}
	
	// Action methods for Personal Information section
	public boolean verifyPersonalInformationSection(String expectedName) {
		new WebDriverWait (driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(sectionPersonalInformation));
		if(sectionPersonalInformation.getText().contentEquals(expectedName)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifyPersonalInformationFields() {
		new WebDriverWait (driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(sectionPersonalInformation));
		if(allPersonalInformationFields.size() == 3) {
			sc.setContext(Context.SECTION_NAME, sectionPersonalInformation.getText());
			return true;
		}
		else {
			return false;
		}
	}
	
	public void enterFirstName() {
		String fName = faker.name().firstName();
		sc.setContext(Context.FIRST_NAME, fName);
		fldFirstName.sendKeys(fName);
	}
	
	public void enterLastName() {
		String lName = faker.name().lastName();
		sc.setContext(Context.LAST_NAME, lName);
		fldLastName.sendKeys(lName);
	}
	
	public void checkNewletterSignUp() {
		chkNewsletterSignUp.click();
	}
	
	// Action methods for Sign-in Information section
	public boolean verifySigninInformationSection(String expectedName) {
		new WebDriverWait (driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(sectionSigninInformation));
		if(sectionSigninInformation.getText().contentEquals(expectedName)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifySigninInformationFields() {
		new WebDriverWait (driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(sectionSigninInformation));
		if(allSigninInformationFields.size() == 3) {
			sc.setContext(Context.SECTION_NAME, sectionSigninInformation.getText());
			return true;
		}
		else {
			return false;
		}
	}
	
	public void enterEmail() {
		String email = faker.internet().emailAddress();
		sc.setContext(Context.EMAIL, email);
		fldEmail.sendKeys(email);
	}
	
	public void enterPassword() {
		String pwd = faker.internet().password(10, 14, true, true, true);
		fldPassword.sendKeys(pwd);
		sc.setContext(Context.PASSWORD, pwd);
	}
	
	public void enterConfirmPassword() {
		String cnfpwd = (String) sc.getContext(Context.PASSWORD);
		fldConfirmPassword.sendKeys(cnfpwd.toString());
	}

}
