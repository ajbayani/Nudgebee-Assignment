package java1;
import java1.CartLocators;

import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class CartActions extends Baseclass {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public CartActions(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    
 // Click  product
    public void clickFirstProduct() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(CartLocators.FIRST_PRODUCT));
        wait.until(ExpectedConditions.elementToBeClickable(CartLocators.FIRST_PRODUCT)).click();

        // Wait for PDP to load 
        wait.until(ExpectedConditions.visibilityOfElementLocated(CartLocators.INCREMENT_QTY_BTN));
    }

	
    public int getQuantityFromField() {
        String value = wait.until(
                ExpectedConditions.visibilityOfElementLocated(CartLocators.QUANTITY_INPUT)
        ).getAttribute("value");

        return Integer.parseInt(value.trim());
    }

    // Increase quantity N times
    public void increaseQuantity(int times) throws InterruptedException {
    	Thread.sleep(500);
    	wait.until(
                ExpectedConditions.elementToBeClickable(CartLocators.QUANTITY_INPUT)).clear();
     
    	WebElement plusBtn = wait.until(
                ExpectedConditions.elementToBeClickable(CartLocators.INCREMENT_QTY_BTN));

        for (int i = 1; i < times; i++) {
        	Thread.sleep(200);
            plusBtn.click();
        }
    }

    
    // Get quantity value
    public int getQuantityProduct() {
        String value = wait.until(
                ExpectedConditions.visibilityOfElementLocated(CartLocators.QUANTITY_INPUT))
                .getAttribute("value");

        return Integer.parseInt(value);
    }

    // Get product details
    public String getProductNameProduct() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(CartLocators.PRODUCT_NAME))
                .getText().trim();
    }

    public String getProductPriceProduct() {
    	String Price  =  wait.until(ExpectedConditions.visibilityOfElementLocated(CartLocators.PRODUCT_PRICE))
                .getText().trim();
        String fullPrice = "$" + Price;
        return fullPrice;
        
    }

    // Click Add to Cart
    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(CartLocators.ADD_TO_CART_BTN)).click();

        // Wait for toast to appear (optional but safer)
		wait.until(ExpectedConditions.presenceOfElementLocated(CartLocators.LOADER_POPUP));

		// Wait for it to disappear
		wait.until(ExpectedConditions.invisibilityOfElementLocated(CartLocators.LOADER_POPUP));
		
		 wait.until(ExpectedConditions.elementToBeClickable(CartLocators.CART_ICON));
        
    }

    // Go to Cart
    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(CartLocators.CART_ICON)).click();
    }

    // Get Cart Details
    public String getCartProductName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(CartLocators.CART_PRODUCT_NAME))
                .getText().trim();
    }

    public String getCartProductPrice() {
   
        return wait.until(ExpectedConditions.visibilityOfElementLocated(CartLocators.CART_PRODUCT_PRICE))
                .getText().trim();
    }

    public int getCartProductQuantity() {
    	 WebElement element = wait.until(
    	            ExpectedConditions.visibilityOfElementLocated(CartLocators.CART_PRODUCT_QUANTITY)
    	    );

    	    String qty = element.getAttribute("value");  
    	    if (qty == null || qty.trim().isEmpty()) {
    	        throw new RuntimeException("Quantity value is empty or not loaded");
    	    }

    	    return Integer.parseInt(qty.trim());  
    }

    // Remove product
    public void removeProductFromCart() {
        // Step 1: Wait for remove button to be clickable
        WebElement removeBtn = wait.until(
                ExpectedConditions.elementToBeClickable(CartLocators.REMOVE_PRODUCT_BTN)
        );

        // Step 2: Click remove
        removeBtn.click();

        // Step 3: Wait for loader/toast to appear (presence)
        wait.until(
                ExpectedConditions.presenceOfElementLocated(CartLocators.REMOVE_LOADER_POPUP)
        );
       
        // Step 4: Wait for loader/toast to disappear
        wait.until(
                ExpectedConditions.invisibilityOfElementLocated(CartLocators.REMOVE_LOADER_POPUP)
        );

        // Step 5: Wait for empty cart message to be visible
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(CartLocators.EMPTY_CART_MESSAGE)
        );
    }
    

    // Empty cart message
    public String getEmptyCartMessage() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(CartLocators.EMPTY_CART_MESSAGE))
                .getText().trim();
    }
    
    
    
    
    
    
    
    
    
    
    
}
