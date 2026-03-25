package java1;

import java1.ProductLocators;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductActions {

	private final WebDriver driver;
	private final WebDriverWait wait;

	public ProductActions(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	/**
	 * Search for a product by keyword
	 * 
	 * @param keyword — search term
	 * @throws InterruptedException 
	 */
	public void searchProduct(String keyword) throws InterruptedException {
		WebElement searchInput = wait
				.until(ExpectedConditions.visibilityOfElementLocated( ProductLocators.SEARCH_INPUT));
	
		searchInput.sendKeys(keyword);

		WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(ProductLocators.SEARCH_BUTTON));
		searchBtn.click();
	}
	
	public void SearchProduct (String keyword) {

	    WebElement searchInput = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(ProductLocators.SEARCH_INPUT)
	    );

	    // Clear existing value
	    ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", searchInput);

	    // Set value using JavaScript (no events triggered)
	    ((JavascriptExecutor) driver).executeScript(
	        "arguments[0].value = arguments[1];",
	        searchInput,
	        keyword
	    );

	    // Click search button using JavaScript
	    WebElement searchBtn = wait.until(
	        ExpectedConditions.elementToBeClickable(ProductLocators.SEARCH_BUTTON)
	    );

	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchBtn);
	}

	/**
	 * Click on Hand Tools category filter
	 */
	public void applyHandToolsFilter() {
		WebElement categoryFilter = wait
				.until(ExpectedConditions.elementToBeClickable(ProductLocators.CATEGORY_HAND_TOOLS));
		categoryFilter.click();
	}

	/**
	 * Click on Power Tools category filter
	 */
	public void applyPowerToolsFilter() {
		WebElement categoryFilter = wait
				.until(ExpectedConditions.elementToBeClickable(ProductLocators.CATEGORY_POWER_TOOLS));
		categoryFilter.click();
	}

	/**
	 * Get count of product cards currently visible on page
	 * 
	 * @return int — number of product cards
	 */
	public int getProductCardCount() {
		List<WebElement> cards = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ProductLocators.PRODUCT_CARDS));
		return cards.size();
	}

	/**
	 * Click the first product card in search results
	 */
	public void clickFirstProduct() {
		WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(ProductLocators.FIRST_PRODUCT));
		firstProduct.click();
	}

	/**
	 * Get product name from product detail page
	 * 
	 * @return product name string
	 */
	public String getProductDetailName() {
		WebElement productName = wait
				.until(ExpectedConditions.visibilityOfElementLocated(ProductLocators.PRODUCT_DETAIL_NAME));
		return productName.getText().trim();
	}

	/**
	 * Get product price from product detail page
	 * 
	 * @return price string
	 */
	public String getProductDetailPrice() {
		WebElement price = wait
				.until(ExpectedConditions.visibilityOfElementLocated(ProductLocators.PRODUCT_DETAIL_PRICE));
		return price.getText().trim();
	}

	/**
	 * Click Add to Cart button on product detail page
	 */
	public void clickAddToCart() {
		WebElement addToCartBtn = wait
				.until(ExpectedConditions.elementToBeClickable(ProductLocators.ADD_TO_CART_BUTTON));
		addToCartBtn.click();
	}

}
