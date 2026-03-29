package java1;

import java1.CartActions;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends Baseclass {

	int times = 4;

	@Test
	public void Q3CartFlow() throws InterruptedException, IOException {
		CartActions cartactions = new CartActions(driver, wait);

		// Step 1: Click product
		cartactions.clickFirstProduct();
		test.info("Clicked on first product and wait for next page's + button");
		captureAndAttachScreenshot("Q3.productClicked");

		// Step 2: Increase quantity 4 times
		cartactions.increaseQuantity(times);
		test.info("Increased quantity 4 times with breaks");
		captureAndAttachScreenshot("Q3.Increase quantity 4 times");

		// Step 3: Verify quantity
		int qty = cartactions.getQuantityFromField();
		Assert.assertEquals(qty, times, "Quantity mismatch!");
		test.info("Quantity verified: " + qty);
		captureAndAttachScreenshot("Q3.Verified quantity");

		// Step 4: Save product details
		String name = cartactions.getProductNameProduct();
		String price = cartactions.getProductPriceProduct();
		int Quantity = cartactions.getQuantityProduct();
		test.info("Saved product details: " + name + " | " + price + " | " + Quantity);
		captureAndAttachScreenshot("Q3.Save product details");

		captureAndAttachScreenshot("Q3.Before Adding to cart");
		// Step 5: Add to cart
		cartactions.clickAddToCart();
		test.info("Clicked Add to Cart and waited for loader");
		captureAndAttachScreenshot("Q3.Added to cart");

		// Step 6: Go to cart
		cartactions.goToCart();
		test.info("Navigated to cart");
		captureAndAttachScreenshot("Q3.Go to cart");

		// Step 7: Verify cart details
		Assert.assertEquals(cartactions.getCartProductName(), name, "Name mismatch in cart");
		Assert.assertEquals(cartactions.getCartProductPrice(), price, "Price mismatch in cart");
		Assert.assertEquals(cartactions.getCartProductQuantity(), qty, "Quantity mismatch in cart");

		test.info("Same product is added, Cart validation successfull");
		captureAndAttachScreenshot("Q3.Verify cart details");

		// Step 8: Remove product
		cartactions.removeProductFromCart();
		test.info("Removed product from cart");
		captureAndAttachScreenshot("Q3.Removed product");

		String emptyMsg = cartactions.getEmptyCartMessage();
		Assert.assertTrue(emptyMsg.toLowerCase().contains("empty"), "Cart is not empty after removal");
		test.info("Cart is empty - validation passed");
		captureAndAttachScreenshot("Q3.EmptyCartvalidation");

	}

}
