package java1;

import java1.ProductActions;

import java1.Baseclass;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProductTest extends Baseclass {
    @Test
    public void Q2ProductSearchFilter() throws InterruptedException, IOException {

        ProductActions actions = new ProductActions(driver, wait);

        // Step 1: Wait for site to load fully
        actions.waitForPageToLoad();
        test.info("Waiting for site to load completely - used explicit wait");
        

        // Step 2: Click search input
        actions.clickSearchInput();
        test.info("Click search input - used explicit wait");

        // Step 3: Search "Hammer"
        String keyword = "Hammer";
        actions.searchProduct(keyword);
        test.info("locate input element, clicked it, used explicit wait - also after clicking used explicit wait for resulting element");
      

        // Step 4: Get all product titles
        List<String> titles = actions.getAllProductTitles();
        test.info("After clicking search, product Titles are saved in list - used explicit wait, handle StaleElementReferenceException");
        captureAndAttachScreenshot("Q2.Hammer related productlist");
        
        // Step 5: Validate all titles contain "Hammer"
        for (String title : titles) {
            Assert.assertTrue(
                    title.toLowerCase().contains(keyword.toLowerCase()),
                    "Product does not match search: " + title
            );
        }
        test.info("Checked For every product name contains search keyword (hammer)");
        
        
        // Step 6: Required wait
        Thread.sleep(4000);
        test.info("To see the visual difference of product lists, for search and filter");

        // Step 7: Click "Pliers" category
        actions.clickPliersCategory();
        test.info("Plier Category selected from category filter - used explicit wait");
        captureAndAttachScreenshot("Q2.Plier in categoray clicked");

        // Step 8: Validate results after filter
        String noResultMsg = actions.getNoResultsMessage();
        test.info("After clicking on category what result it has produced is saved - used explicit wait");
        captureAndAttachScreenshot("Q2.PLier search not working");

        if (noResultMsg != null) {

         //   System.out.println("Their are no products found for Categoray inspite of clicking after keyword search, result produced is when Plier categoray selected ::" + noResultMsg);

            Assert.assertTrue(
                    noResultMsg.toLowerCase().contains("searched for" ),
                    "Expected Products list with Search + categoray Filter - Negative test pass");
            test.info("Filter for PLier should produce pliers nt hammers but the result is ::"+ noResultMsg);
            
        }
        else {

            System.out.println("Yes Results Message: there are results found");

            // 🔹 Get product titles
            List<String> titles1 = actions.getAllcatProductTitles();

            // 🔹 Assert products exist
            Assert.assertTrue(
                    titles1.size() > 0,
                    "Expected products but none found"
            );

            // 🔹 Print all titles
            for (String title : titles1) {
                System.out.println("Product Title: " + title);
            }
        
        }
       
    }
}