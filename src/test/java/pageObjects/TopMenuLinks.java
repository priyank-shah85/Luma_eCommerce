package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenuLinks extends BasePage {

	public TopMenuLinks(WebDriver driver) {
		super(driver);
	}
	
	//<---------- Storing elements for Level0, Level1 & Level2 menu links ----------> 
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
	

}
