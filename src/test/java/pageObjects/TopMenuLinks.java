package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopMenuLinks extends BasePage {

	public TopMenuLinks(WebDriver driver) {
		super(driver);
	}
	
	// Global declarations
	Actions action = new Actions(driver);
	
	//<---------- Storing elements for Level0, Level1 & Level2 menu links ----------> 
	// Element for top menu area
	@FindBy(id = "ui-id-2")
	WebElement topLinks;
	
	// Elements for Level0 main menus
	@FindBy(linkText = "What's New")
	WebElement lnkWhatsNew;
	
	@FindBy(linkText = "Women")
	WebElement lnkWomen;
	
	@FindBy(linkText = "Men")
	WebElement lnkMen;
	
	@FindBy(linkText = "Gear")
	WebElement lnkGear;
	
	@FindBy(linkText = "Training")
	WebElement lnkTraining;
	
	@FindBy(linkText = "Sale")
	WebElement lnkSale;
	
	// Elements for Level1 Women & Men sub menus
	@FindBy(linkText = "Tops")
	WebElement lnkTops;
	
	@FindBy(linkText = "Bottoms")
	WebElement lnkBottoms;
	
	// Elements for Level2 Women and Men links
	@FindBy(linkText = "Jackets")
	WebElement lnkJackets;
	
	@FindBy(linkText = "Hoodies & Sweatshirts")
	WebElement lnkHoodiesSweatshirts;
	
	@FindBy(linkText = "Tees")
	WebElement lnkTees;
	
	@FindBy(linkText = "Pants")
	WebElement lnkPants;
	
	@FindBy(linkText = "Shorts")
	WebElement lnkShorts;
	
	// Elements for Level2 Women
	@FindBy(linkText = "Bras & Tanks")
	WebElement lnkBrasTanks;
	
	// Elements for Level2 Men
	@FindBy(linkText = "Tanks")
	WebElement lnkTanks;
	
	// Elements for Level1 Gear sub menus
	@FindBy(linkText = "Bags")
	WebElement lnkBags;
	
	@FindBy(linkText = "Fitness Equipment")
	WebElement lnkFitnessEquipment;
	
	@FindBy(linkText = "Watches")
	WebElement lnkWatches;
	
	// Elements for Level1 Training sub menu
	@FindBy(linkText = "Video Download")
	WebElement lnkVideoDownload;
	
	//<---------- Action methods to mouse hover/click on Level0, Level1 & Level2 menu links ----------> 
	// Action methods for Level0 main menus
	public void mouseHoverOnMainMenu(String mainMenu) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(topLinks));
		
		switch(mainMenu) {
		
		case "What's New":
			action.moveToElement(lnkWhatsNew).click().build().perform();
		
		case "Men":
			action.moveToElement(lnkMen).perform();
			break;
			
		case "Women":
			action.moveToElement(lnkWomen).perform();
			break;
		
		case "Gear":
			action.moveToElement(lnkGear).perform();
			break;
			
		case "Sale":
			action.moveToElement(lnkSale).click().build().perform();
			
		default:
			break;
		}
	}
	
	// Action methods for Level1 sub menus
	public void mouseHoverOnSubMenu(String subMenu) {
		switch(subMenu) {
		
		case "Tops":
			action.moveToElement(lnkTops).perform();
			break;
			
		case "Bottoms":
			action.moveToElement(lnkBottoms).perform();
			break;
			
		case "Bags":
			action.moveToElement(lnkBags).click().build().perform();
			break;
			
		case "Fitness Equipment":
			action.moveToElement(lnkFitnessEquipment).click().build().perform();
			break;
			
		case "Watches":
			action.moveToElement(lnkWatches).click().build().perform();
			break;
			
		case "Video Download":
			action.moveToElement(lnkVideoDownload).click().build().perform();
			
		default:
			break;
		}
	}
	
	public void clickOnSubMenu(String subMenu) {
		switch(subMenu) {
		
		case "Tops":
			action.moveToElement(lnkTops).click().build().perform();
			break;
		
		case "Bottoms":
			action.moveToElement(lnkBottoms).click().build().perform();
			break;
			
		default:
			break;
		}
	}
	
	// Action methods for Level2 product links
	public void clickOnProductLink(String link) {
		switch(link) {
		
		case "Jackets":
			action.moveToElement(lnkJackets).click().build().perform();
			break;
			
		case "Hoodies & Sweatshirts":
			action.moveToElement(lnkHoodiesSweatshirts).click().build().perform();
			break;
			
		case "Tees":
			action.moveToElement(lnkTees).click().build().perform();
			break;
			
		case "Tanks":
			action.moveToElement(lnkTanks).click().build().perform();
			break;
			
		case "Bras & Tanks":
			action.moveToElement(lnkBrasTanks).click().build().perform();
			break;
			
		case "Pants":
			action.moveToElement(lnkPants).click().build().perform();
			break;
			
		case "Shorts":
			action.moveToElement(lnkShorts).click().build().perform();
			break;
			
		default:
			break;
		}
	}

}
