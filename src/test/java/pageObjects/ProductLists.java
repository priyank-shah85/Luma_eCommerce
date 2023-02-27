package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductLists extends BasePage {

	public ProductLists(WebDriver driver) {
		super(driver);
	}
	
	// Elements for traversing through product list
	@FindBy(xpath = "//ol[@class='products list items product-items']")
	WebElement boxProductList;
	
	@FindBy(xpath = "//ol[@class='products list items product-items']//li")
	List<WebElement> listProducts;
	
	@FindBy(xpath = "//ol[@class='products list items product-items']//li//div//div//strong//a")
	List<WebElement> lnkProducts;
	
	@FindBy(xpath = "//div[@class='message info empty']")
	WebElement msgNoMatchingProducts;
	
	@FindBy(xpath = "(//p[@id='toolbar-amount'])[1]//span[3]")
	WebElement totalProductCount;
	
	@FindBy(xpath = "//ul[@class='items pages-items']")
	List<WebElement> pageElement;
	
	@FindBy(css = ".block-subtitle.filter-subtitle")
	WebElement txtShoppingOptions;
	
	@FindBy(xpath = "//div[@id='narrow-by-list']//div[@class='filter-options-title']")
	List<WebElement> shoppingOptions;
	
	// Action methods for traversing through product list
	public boolean clickProductNameLink(String productName) {
		boolean results = false;
		
		// Finding if there is at least one product displays on page
		if(listProducts.size()>0) {
			for(int i=0; i<lnkProducts.size(); i++) {
				List<WebElement> productLinks = driver.findElements(By.xpath("//ol[@class='products list items product-items']//li//div//div//strong//a"));
				// System.out.println(productLinks.get(i).getText());
				if(productLinks.get(i).getText().contentEquals(productName)) {
					results = true;
					productLinks.get(i).click();
					break;
				}
			}
		}
		else if(msgNoMatchingProducts.getText().contentEquals(productName)) {
				results = true;
		}
		else {
			results = false;
		}
		return results;
	}
	
	public boolean verifyMaxDefaultProducts(String no) {
		boolean result = false;
		
		// Storing expected & actual default number
		int actualNo = listProducts.size();
		int expectedNo = Integer.valueOf(no);
		System.out.println("Expected: " + expectedNo + " |Actual: " + actualNo);
		
		// Checking whether the actual product count is less than expected
		if(actualNo > 0 && actualNo <= expectedNo) {
			result = true;
		}
		else {
			result = false;
		}
		return result;
	}
	
	public boolean verifyTotalProductCount() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(totalProductCount));
		
		// Extracting numbers
		int actualTotalProductCount = Integer.valueOf(totalProductCount.getText());
		System.out.println(actualTotalProductCount);
		
		// Checking if it more than 12
		if(actualTotalProductCount > 12) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int moveToLastPage() throws InterruptedException {
		int totalPages = 1;
		
		// Searching through page element list and checking which one is visible on page
		for(int j=0; j<pageElement.size(); j++) {
			// Initializing the element again to avoid Stale element exception
			List<WebElement> pageNavigation = driver.findElements(By.xpath("//ul[@class='items pages-items']"));
			
			if(pageNavigation.get(j).isDisplayed()) {
				// Storing all li from pageNavigation
				List<WebElement> pages = pageNavigation.get(j).findElements(By.tagName("li"));
				
				// Clicking on next page till we reach at end
				do {
					List<WebElement> pageNavigationLoc = driver.findElements(By.xpath("//ul[@class='items pages-items']"));
					List<WebElement> pagesToNavigate = pageNavigationLoc.get(j).findElements(By.tagName("li"));
					//pages = pagesToNavigate;
					
					if(totalPages == (pagesToNavigate.size() - 1)) {
						break;
					}
					else {
						pagesToNavigate.get(pagesToNavigate.size() - 1).findElement(By.tagName("a")).click();
						totalPages++;
						Thread.sleep(2000);
					}
				} while(totalPages < pages.size());
			}
		}
		return totalPages;
	}
	
	public boolean verifyLastPage() throws InterruptedException {
		if(moveToLastPage() > 1) {
			return true;
		}
		else if(moveToLastPage() == 1) {
			return false;
		}
		else {
			return false;
		}
	}
	
	public boolean verifyShoppingOptionsLabel(String label) {
		if(txtShoppingOptions.getText().contentEquals(label)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifyShoppingOptionValue(String value) {
		for(int i=0; i<shoppingOptions.size(); i++) {
			// Stale element exception
			List<WebElement> shoppingOptionValue = driver.findElements(By.xpath("//div[@id='narrow-by-list']//div[@class='filter-options-title']"));
			
			// Checking the expected value
			if(shoppingOptionValue.get(i).getText().contentEquals(value)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean verifyShoppingOptionPosition(String value, String previous_value) {
		// Starting with 1 to avoid index out of bound exception
		for(int i=1; i<=shoppingOptions.size(); i++) {
			// Stale element exception
			List<WebElement> shoppingOptionValue = driver.findElements(By.xpath("//div[@id='narrow-by-list']//div[@class='filter-options-title']"));
			
			// If the incoming shopping option is the first one
			if(value.contentEquals("CATEGORY")) {
				// extracting actual text for option and label
				String currentOptionName = shoppingOptionValue.get(i-1).getText(); // We need to verify the 0th element here
				String previousLabel = txtShoppingOptions.getText();
				
				// Comparison with expected values
				if(currentOptionName.contentEquals(value) && previousLabel.contentEquals(previousLabel)) {
					return true;
				}
			}
			
			// If the incoming shopping option is not the first one
			else {
				// extracting actual text for current and previous option
				String currentOptionName = shoppingOptionValue.get(i).getText();
				String previousOptionName = shoppingOptionValue.get(i-1).getText();
				
				// Comparing actual values with expected
				if(currentOptionName.contentEquals(value) && previousOptionName.contentEquals(previous_value)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean selectSizeOnList(String size, String productName) throws InterruptedException {		
		// Running loop to find right product
		for(int i=1; i<=listProducts.size(); i++) {
			// Stale element exception
			List<WebElement> productLists = driver.findElements(By.xpath("//ol[@class='products list items product-items']//li"));
			
			// Verifying the product name
			if(productLists.get(i).getText().contains(productName)) {
				// Storing correct product size box
				WebElement rightProduct = productLists.get(i);
				List<WebElement> productSize = rightProduct.findElements(By.xpath(".//div[@attribute-code='size']//div[@role='listbox']//div"));
				
				// Running loop to find right size
				for(int j=0; j<productSize.size(); j++) {
					// Stale element exception
					List<WebElement> rightProductSize = rightProduct.findElements(By.xpath(".//div[@attribute-code='size']//div[@role='listbox']//div"));
					
					// Verifying the size
					if(rightProductSize.get(j).getText().contentEquals(size)) {
						// Selecting the size
						rightProductSize.get(j).click();
						Thread.sleep(3000);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean selectColorOnList(String color, String productName) throws InterruptedException {		
		// Running loop to find right product
		for(int i=0; i<listProducts.size(); i++) {
			// Stale element exception
			List<WebElement> productLists = driver.findElements(By.xpath("//ol[@class='products list items product-items']//li"));
			
			// Verifying the product name
			if(productLists.get(i).getText().contains(productName)) {
				// Storing correct product color box
				WebElement rightProduct = productLists.get(i);
				List<WebElement> productColor = rightProduct.findElements(By.xpath(".//div[@attribute-code='color']//div[@role='listbox']//div"));
				
				// Running loop to find right color
				for(int j=0; j<productColor.size(); j++) {
					// Stale element exception
					List<WebElement> rightProductColor = rightProduct.findElements(By.xpath(".//div[@attribute-code='color']//div[@role='listbox']//div"));
					
					// Verifying the color
					if(rightProductColor.get(j).getAttribute("option-label").contentEquals(color)) {
						// Selecting the size
						rightProductColor.get(j).click();
						Thread.sleep(3000);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public void hoverOnProductFromList(String productName) {
		// Running loop to find right product
		for(int i=0; i<listProducts.size(); i++) {
			// Stale element exception
			List<WebElement> productLists = driver.findElements(By.xpath("//ol[@class='products list items product-items']//li"));
			
			// Verifying the product name
			if(productLists.get(i).getText().contains(productName)) {
				// hovering to the middle of the product list
				Actions action = new Actions(driver);
				action.moveToElement(productLists.get(i)).perform();
				break;
			}
		}
	}
	
	public void clickOnAddToCartButtonOnList(String productName) {
		// Calling the method to move mouse to the middle of the product
		hoverOnProductFromList(productName);
		
		// Running loop to find right product
		for(int i=0; i<listProducts.size(); i++) {
			// Stale element exception
			List<WebElement> productLists = driver.findElements(By.xpath("//ol[@class='products list items product-items']//li"));
			
			// Verifying the product name
			if(productLists.get(i).getText().contains(productName)) {
				// Checking if the Add to Cart button is visible within product list
				WebElement btnAddToCartOnList = productLists.get(i).findElement(By.xpath(".//button[@class='action tocart primary']"));
				if(btnAddToCartOnList.isDisplayed()) {
					// Clicking on Add to Cart button
					Actions action = new Actions(driver);
					action.moveToElement(btnAddToCartOnList).click().build().perform();
					break;
				}
			}
		}
	}

}
