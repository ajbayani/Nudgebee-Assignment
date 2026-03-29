package java1;

import java1.ProductLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ProductActions {

	private final WebDriver driver;
	private final WebDriverWait wait;

	public ProductActions(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	// Wait for page to fully load (using search bar as anchor element)
	public void waitForPageToLoad() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ProductLocators.SEARCH_INPUT));
	}

	// Click search input
	public void clickSearchInput() {
		WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(ProductLocators.SEARCH_INPUT));
		searchInput.click();
	}

	// Search product
	public void searchProduct(String keyword) {
		WebElement searchInput = wait
				.until(ExpectedConditions.visibilityOfElementLocated(ProductLocators.SEARCH_INPUT));

		searchInput.clear();
		searchInput.sendKeys(keyword);

		WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(ProductLocators.SEARCH_BUTTON));
		searchBtn.click();
		 wait.until(ExpectedConditions.textToBePresentInElementLocated(
		            ProductLocators.PRODUCT_CARD_TITLE, keyword));
}

	// Get all product titles
	public List<String> getAllProductTitles() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(ProductLocators.PRODUCT_CARD_TITLE));
			List<WebElement> elements = driver.findElements(ProductLocators.PRODUCT_CARD_TITLE);
			return elements.stream().map(e -> e.getText().trim()).filter(text -> !text.isEmpty()).toList();
		} catch (StaleElementReferenceException e) {
			List<WebElement> elements = driver.findElements(ProductLocators.PRODUCT_CARD_TITLE);
			return elements.stream().map(j -> j.getText().trim()).filter(text -> !text.isEmpty()).toList();
		}
	}

	// Click "Pliers" category
	public void clickPliersCategory() throws InterruptedException {
		// By CATEGORY_PLIERS = By.xpath("//label[contains(text(),'Pliers')]");

		WebElement category = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Pliers')]")));
		category.click();
		Thread.sleep(4000);
	}

	// Get "No Results" message text
	public String getNoResultsMessage() {
		List<WebElement> elements;
		wait.until(ExpectedConditions.visibilityOfElementLocated(ProductLocators.NO_RESULTS_MESSAGE));
		elements = driver.findElements(ProductLocators.NO_RESULTS_MESSAGE);

		if (elements.size() > 0) {
			return elements.get(0).getText().trim();
		}
		return null;
	}

	List<String> getAllcatProductTitles() {
		List<String> titles = new ArrayList<>();

		List<WebElement> Categorayelements = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ProductLocators.PRODUCT_CARD_TITLE));

		for (int i = 0; i < Categorayelements.size(); i++) {
			try {
				titles.add(Categorayelements.get(i).getText().trim());
			} catch (StaleElementReferenceException e) {
				// 🔁 Re-fetch elements if stale
				Categorayelements = driver.findElements(ProductLocators.PRODUCT_CARD_TITLE);
				titles.add(Categorayelements.get(i).getText().trim());
			}
		}

		return titles.stream().filter(text -> !text.isEmpty()).toList();
	}

}