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
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.ScenarioContext;
import enums.Context;

public class ShoppingCartPage extends BasePage {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	public static ScenarioContext cartsc = new ScenarioContext();
	
	// Elements for page details
	@FindBy(id = "shopping-cart-table")
	WebElement tabelShoppingCart;
	
	@FindBy(xpath = "//table[@id='shopping-cart-table']//thead//tr//th")
	List<WebElement> allHeaders;
	
	@FindBy(xpath = "//table[@id='shopping-cart-table']//tbody//tr")
	List<WebElement> allRows;
	
	@FindBy(css = ".grand.totals")
	WebElement grandTotal;
	
	@FindBy(xpath = "//strong//span[@class='price']")
	WebElement amtOrderTotal;
	
	@FindBy(xpath = "//button[@data-role='proceed-to-checkout']")
	WebElement btnProceedToCheckout;
	
	// Action methods for page details
	public boolean verifyProductNameInCart(String expectedName, String columnName) {
		boolean results = false;
		
		// Let's get headers first
		List<String> allHeaderNames = new ArrayList<String>();
		
		// Running a loop to find all header names
		for(int i=0; i<allHeaders.size(); i++) {
			// Finding the header elements again to avoid Stale Element exception
			List<WebElement> headers = driver.findElements(By.xpath("//table[@id='shopping-cart-table']//thead//tr//th"));
			
			// Storing each header name in variable
			String headerName = headers.get(i).getText();
			// Storing above header name into List
			allHeaderNames.add(headerName);
		}
		
		// Running a loop to find all rows
		// System.out.println(allRows.size());
		for(int j=1; j<=allRows.size(); j++) {
			// Finding the row elements again to avoid Stale Element exception
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='shopping-cart-table']//tbody//tr"));
			allRows = rows;
			
			// Getting specific row location with each iteration
			String specificRowLoc = "//table[@id='shopping-cart-table']//tbody//tr[" + j + "]";
			
			// Locating individual cells of specific row
			List<WebElement> allColumns = driver.findElement(By.xpath(specificRowLoc)).findElement(By.tagName("td")).
					findElement(By.tagName("div")).findElement(By.tagName("strong")).findElements(By.tagName("a"));
			
			// Creating a map to store key-value pair data. It will be created for each iteration of row.
			LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();
			
			// Iterating each cell
			for(int k=0; k<allColumns.size(); k++) {
				// Finding the column elements again to avoid Stale Element exception
				// Locating individual cells of specific row
				List<WebElement> columns = driver.findElement(By.xpath("//table[@id='shopping-cart-table']//tbody//tr[" + j + "]")).
						findElement(By.tagName("td")).findElement(By.tagName("div")).findElement(By.tagName("strong")).
						findElements(By.tagName("a"));
				
				// Getting cell value
				String cellValue = columns.get(k).getText();
				// System.out.println(cellValue);
				
				// We will put in to map with header name and value with iteration
				// Get kth index value from allHeaderNames and kth cell value of row
				eachRowData.put(allHeaderNames.get(k), cellValue);
				
				if(allHeaderNames.get(k).contentEquals(columnName) && cellValue.contentEquals(expectedName)) {
					// System.out.println("Item: " + allHeaderNames.get(k) + " |Value: " + cellValue);
					results = true;
					return true;
				}
				else {
					results = false;
					continue;
				}
			}
			// System.out.println(eachRowData);
		}
		return results;
	}
	
	public boolean verifyOrderTotalVisibility() {
		new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(grandTotal));
		if(amtOrderTotal.isDisplayed()) {
			cartsc.setContext(Context.ORDER_TOTAL, amtOrderTotal.getText());
			return true;
		}
		else {
			return false;
		}
	}
	
	public void clickProceedToCheckout() {
		btnProceedToCheckout.click();
	}

}
