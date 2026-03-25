package java1;

import org.openqa.selenium.By;

public class ProductLocators {
	   // Search bar
    public static final By SEARCH_INPUT            = By.cssSelector("[data-test='search-query']");
    public static final By SEARCH_BUTTON           = By.cssSelector("button[data-test='search-submit']");

    // Category filter (left sidebar)
    public static final By CATEGORY_FILTER_HEADER  = By.xpath("//h5[contains(text(),'By category')]");
    public static final By CATEGORY_HAND_TOOLS     = By.xpath("[data-test='category-01KMJZ10VRBYP6S28VZ9BD3W4A']");
    public static final By CATEGORY_POWER_TOOLS    = By.xpath("//label[contains(text(),'Power Tools')]");

    // Search results
    public static final By PRODUCT_CARDS           = By.cssSelector(".card");
    public static final By PRODUCT_CARD_TITLE      = By.cssSelector(".card-title");
    public static final By FIRST_PRODUCT           = By.cssSelector(".card:first-child");
    public static final By NO_RESULTS_MESSAGE      = By.cssSelector("[data-test='no-results']");

    // Product detail page
    public static final By PRODUCT_DETAIL_NAME     = By.cssSelector("h1[data-test='product-name']");
    public static final By PRODUCT_DETAIL_PRICE    = By.cssSelector("span[data-test='unit-price']");
    public static final By PRODUCT_DETAIL_DESC     = By.cssSelector("div[data-test='product-description']");
    public static final By ADD_TO_CART_BUTTON      = By.cssSelector("button[data-test='add-to-cart']");

}
