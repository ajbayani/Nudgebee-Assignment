package java1;

import org.openqa.selenium.By;

public class ProductLocators {

// 🔍 Search Section
public static final By SEARCH_INPUT  = By.cssSelector("[data-test='search-query']");
public static final By SEARCH_BUTTON = By.cssSelector("[data-test='search-submit']");


// Specific category used in your test
public static final By CATEGORY_PLIERS = 
        By.xpath("//label[contains(text(),'Pliers')]");

// 🛒 Product Listing
public static final By PRODUCT_CARDS       = By.cssSelector(".card");
public static final By PRODUCT_CARD_TITLE  = By.cssSelector(".card-title");


public static final By NO_RESULTS_MESSAGE  = By.cssSelector("[data-test='search-caption']");		
		
}