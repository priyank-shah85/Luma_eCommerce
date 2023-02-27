package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.ScenarioContext;
import enums.Context;

public class CheckoutPage extends BasePage {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	ScenarioContext cartsc = ShoppingCartPage.cartsc; // Referencing to Cart Page enums
	ScenarioContext sc = CreateAccountPage.sc; // Referencing to Create Account Page enums
	
	// Elements for page details
	@FindBy(xpath = "//div[@class='step-title']")
	List<WebElement> stepAddressTitle;
	
	@FindBy(xpath = "//button[@class='button action continue primary']")
	WebElement btnNext;
	
	@FindBy(css = "span[class='title']")
	WebElement lblOrderSummary;
	
	@FindBy(xpath = "//strong//span[@class='price']")
	WebElement amtOrderTotal;
	
	@FindBy(css = ".action.primary.checkout")
	WebElement btnPlaceOrder;
	
	//-----> Elements to add new address on Checkout page -> Shipping Address step <-----
	@FindBy(name = "firstname")
	WebElement txtShippingAddressFirstName;
	
	@FindBy(name = "lastname")
	WebElement txtShippingAddressLastName;
	
	@FindBy(name = "street[0]")
	WebElement txtShippingAddressStreetAddress1;
	
	@FindBy(name = "street[1]")
	WebElement txtShippingAddressStreetAddress2;
	
	@FindBy(name = "street[2]")
	WebElement txtShippingAddressStreetAddress3;
	
	@FindBy(name = "city")
	WebElement txtShippingAddressCity;
	
	@FindBy(name = "country_id")
	WebElement txtShippingAddressCountry;
	
	@FindBy(name = "region_id")
	WebElement txtShippingAddressRegion;
	
	@FindBy(name = "postcode")
	WebElement txtShippingAddressPostcode;
	
	@FindBy(name = "telephone")
	WebElement txtShippingAddressPhone;
	
	// -----> Elements for Shipping Method table <-----
	@FindBy(xpath = "//table[@class='table-checkout-shipping-method']")
	WebElement tableCheckoutShippingMethod;
	
	@FindBy(xpath = "//table[@class='table-checkout-shipping-method']//thead//tr//th")
	List<WebElement> allHeaders;
	
	@FindBy(xpath = "//table[@class='table-checkout-shipping-method']//tbody//tr")
	List<WebElement> allRows;
	
	// Action methods for page details
	public boolean verifyStepAddressStep(String expectedTitle) {
		for(int i=0; i<stepAddressTitle.size(); i++) {
			List<WebElement> stepTitle = driver.findElements(By.xpath("//div[@class='step-title']"));
			if(stepTitle.get(i).getText().contentEquals(expectedTitle)) {
				return true;
			}
		}
		return false;
	}
	
	public void clickNext() {
		new WebDriverWait(driver,Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(btnNext));
		btnNext.click();
	}
	
	public boolean verifyOrderTotal() {
		String expected = amtOrderTotal.getText();
		String actual=cartsc.getContext(Context.ORDER_TOTAL).toString();		
		
		//Comparing both values
		if(actual.contentEquals(expected)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifyOrderSummaryExists(String expectedName) {
		if(lblOrderSummary.getText().contentEquals(expectedName)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void clickPlaceOrderButton() {
		btnPlaceOrder.click();
	}
	
	//-----> Action methods to add new address on Checkout page -> Shipping Address step <-----
	public boolean verifyShippingAddressFirstName() {
		// Storing expected first name
		String expectedfName = sc.getContext(Context.FIRST_NAME).toString();
		String actualfName = txtShippingAddressFirstName.getAttribute("value");
		// System.out.println("Expected: " + expectedfName + " |Actual: " + actualfName);
		
		// Comparing expected with current value
		if(actualfName.contentEquals(expectedfName)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifyShippingAddressLastName() {
		// Storing expected last name
		String expectedlName = sc.getContext(Context.LAST_NAME).toString();
		String actuallName = txtShippingAddressLastName.getAttribute("value");
		// System.out.println("Expected: " + expectedlName + " |Actual: " + actuallName);
		
		// Comparing expected with current value
		if(actuallName.contentEquals(expectedlName)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void enterShippingAddressStreetAdd1(String add1) {
		txtShippingAddressStreetAddress1.sendKeys(add1);
	}
	
	public void enterShippingAddressStreetAdd2(String add2) {
		txtShippingAddressStreetAddress2.sendKeys(add2);
	}
	
	public void enterShippingAddressStreetAdd3(String add3) {
		txtShippingAddressStreetAddress3.sendKeys(add3);
	}
	
	public void enterShippintAddressCity(String city) {
		txtShippingAddressCity.sendKeys(city);
	}
	
	public void selectShippingAddressCountry(String country) {
		Select select = new Select(txtShippingAddressCountry);
		select.selectByVisibleText(country);
	}
	
	public void selectShippingAddressRegion(String state) {
		Select select = new Select(txtShippingAddressRegion);
		select.selectByVisibleText(state);
	}
	
	public void enterShippingAddressPostcode(String postcode) {
		txtShippingAddressPostcode.sendKeys(postcode);
	}
	
	public void enterShippingAddressPhone(String phone) {
		txtShippingAddressPhone.sendKeys(phone);
	}
	
	// -----> Action method for Shipping Method table <-----
	public boolean selectShippingMethod(String methodName) {
		boolean results = false;
		
		// Let's get header first
		List<String> allHeaderNames = new ArrayList<String>();
		for(int k=0; k<allHeaders.size(); k++) {
			// Initializing header locators again to avoid Stale Element exception
			List<WebElement> headers = driver.findElements(By.xpath("//table[@class='table-checkout-shipping-method']//thead//tr//th"));
			String headerName1 = headers.get(k).getText();
			allHeaderNames.add(headerName1);
		}
		
		// Each row will be a key value pair. So we will use LinkedHashMap so that order can be retained.
		// All maps will be added to a list.
		// List<LinkedHashMap<String, String>> allTableData = new ArrayList<LinkedHashMap<String, String>>();
				 
		// Get total rows count
		// Starting from 2 as first row is header. Remember xpath index starts from 1
		for(int i=1; i<= allRows.size(); i++) {
			// Initializing row locators again to avoid Stale Element exception
			List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table-checkout-shipping-method']//tbody//tr"));
			allRows = rows;
			
			// Getting specific row with each iteration
			String specificRowLoc = "//table[@class='table-checkout-shipping-method']//tbody//tr[" + i + "]";
			
			// Locating only cells of specific row
			List<WebElement> allColumns = driver.findElement(By.xpath(specificRowLoc)).findElements(By.tagName("td"));
			// Creating a map to store key-value pair data. It will be created for each iteration of row.
			LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();

			// Iterating each cell
			for(int j=0; j<allColumns.size(); j++) {
				// Initializing columns locators to avoid Stale Element exception
				List<WebElement> columns = driver.findElement(By.xpath("//table[@class='table-checkout-shipping-method']//tbody//tr[" + i + "]"))
						.findElements(By.tagName("td"));
				
				// Getting cell value
				String cellValue = columns.get(j).getText();
				
				// We will put in to map with header name and value with iteration
				// Get jth index value from allHeaderNames and jth cell value of row
				eachRowData.put(allHeaderNames.get(j), cellValue);
				
				// Comparing the shipping method name
				if(cellValue.contentEquals(methodName)) {
					results = true;
					columns.get(j-2).click();
					break;
				}
				else {
					continue;
				}
			}
			// System.out.println(eachRowData);
		}
		return results;
	}

}
