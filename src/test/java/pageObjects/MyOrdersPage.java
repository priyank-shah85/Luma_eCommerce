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

public class MyOrdersPage extends BasePage {

	public MyOrdersPage(WebDriver driver) {
		super(driver);
	}
	
	ScenarioContext ordernosc = PurchaseConfirmationPage.ordernosc;
	
	// Elements for page details
	@FindBy(xpath = "//div[@class='message info empty']//span")
	WebElement msgNoOrderPlaced;
	
	@FindBy(id = "my-orders-table")
	WebElement tableMyOrders;
	
	@FindBy(xpath = "//table[@id='my-orders-table']//thead//tr//th")
	List<WebElement> allHeaders;
	
	@FindBy(xpath = "//table[@id='my-orders-table']//tbody//tr")
	List<WebElement> allRows;
	
	// Action methods for page details
	public boolean verifyNoOrderPlacedMessage(String expectedMsg) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(msgNoOrderPlaced));
		if(msgNoOrderPlaced.getText().contentEquals(expectedMsg)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifyOrderNumber(String headerName) {
		boolean results = false;
		
		// Let's get header first
		List<String> allHeaderNames = new ArrayList<String>();
		for(int k=0; k<allHeaders.size(); k++) {
			// Initializing header locators again to avoid Stale Element exception
			List<WebElement> headers = driver.findElements(By.xpath("//table[@id='my-orders-table']//thead//tr//th"));
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
			List<WebElement> rows = driver.findElements(By.xpath("//table[@id='my-orders-table']//tbody//tr"));
			allRows = rows;
			
			// Getting specific row with each iteration
			String specificRowLoc = "//table[@id='my-orders-table']//tbody//tr[" + i + "]";
			
			// Locating only cells of specific row
			List<WebElement> allColumns = driver.findElement(By.xpath(specificRowLoc)).findElements(By.tagName("td"));
			// Creating a map to store key-value pair data. It will be created for each iteration of row.
			LinkedHashMap<String, String> eachRowData = new LinkedHashMap<>();

			// Iterating each cell
			for(int j=0; j<allColumns.size(); j++) {
				// Initializing columns locators to avoid Stale Element exception
				List<WebElement> columns = driver.findElement(By.xpath("//table[@id='my-orders-table']//tbody//tr[" + i + "]"))
						.findElements(By.tagName("td"));
				
				// Getting cell value
				String cellValue = columns.get(j).getText();
				
				// We will put in to map with header name and value with iteration
				// Get jth index value from allHeaderNames and jth cell value of row
				eachRowData.put(allHeaderNames.get(j), cellValue);
				
				// Comparing the header and order number
				String expectedOrderNumber = ordernosc.getContext(Context.ORDER_NUMBER).toString();
				if(allHeaderNames.get(j).contentEquals(headerName) && cellValue.contentEquals(expectedOrderNumber)) {
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

}
