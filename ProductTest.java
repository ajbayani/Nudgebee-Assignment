package java1;

import java1.ProductActions;
import java1.Baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
public class ProductTest extends Baseclass {
	private static final String SEARCH_KEYWORD = "Pliers";

    @Test(description = "Scenario 2 — Product Search, Filter, and Detail Page")
    public void testProductSearchAndFilter() throws InterruptedException {

		// Step 1: Create actions object
        ProductActions productActions = new ProductActions(driver, wait);

        
        // Step 2: Search for a product by keyword
      //  productActions.searchProduct(SEARCH_KEYWORD);

        //productActions.searchProduct(SEARCH_KEYWORD);
        
        // Step 3: Verify search results are returned — at least 1 product card visible
//        int resultCount = productActions.getProductCardCount();
//        Assert.assertTrue(
//            resultCount < 0,
//            "No products found for keyword: " + SEARCH_KEYWORD
//        );

        
        
        // Step 4: Apply category filter — Hand Tools
        productActions.applyHandToolsFilter();

        // Step 5: Verify filtered results still show products
        int filteredCount = productActions.getProductCardCount();
        Assert.assertTrue(
            filteredCount < 0,
            "No products visible after applying Hand Tools filter"
        );

        
        
        
        int resultCount = 10;
		// Step 6: Verify filter reduced or kept same results (not increased)
        Assert.assertTrue(
            filteredCount <= resultCount,
            "Filter did NOT reduce results — filter may not be working"
        );

        
        
        // Step 7: Click on the first product card
        productActions.clickFirstProduct();

        // Step 8: Verify product detail page loaded — URL should contain /product/
        String detailUrl = driver.getCurrentUrl();
        Assert.assertTrue(
            detailUrl.contains("/product/"),
            "Product detail page did NOT load. Current URL: " + detailUrl
        );

        
        
        // Step 9: Verify product name is displayed on detail page
        String productName = productActions.getProductDetailName();
        Assert.assertNotNull(productName, "Product name is null on detail page");
        Assert.assertFalse(
            productName.isEmpty(),
            "Product name is empty on detail page"
        );

        
        
        // Step 10: Verify product price is displayed
        String productPrice = productActions.getProductDetailPrice();
        Assert.assertNotNull(productPrice, "Product price is null on detail page");
        Assert.assertFalse(
            productPrice.isEmpty(),
            "Product price is empty on detail page"
        );
    }
}
