package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	
	// Action methods for traversing through product list
	public void clickProductNameLink(String productName) {
		for(int i=0; i<lnkProducts.size(); i++) {
			List<WebElement> productLinks = driver.findElements(By.xpath("//ol[@class='products list items product-items']//li//div//div//strong//a"));
			// System.out.println(productLinks.get(i).getText());
			if(productLinks.get(i).getText().contentEquals(productName)) {
				productLinks.get(i).click();
				break;
			}
		}
	}

}
