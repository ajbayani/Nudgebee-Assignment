package java1;
import org.openqa.selenium.By;
public class CartLocators {

 // 🛒 Product Detail Page (PDP)
    public static final By FIRST_PRODUCT              = By.xpath("//img[@alt='Combination Pliers']");// By.cssSelector(".card:first-child"); 
    public static final By ADD_TO_CART_BTN            = By.cssSelector("[data-test='add-to-cart']");
    public static final By INCREMENT_QTY_BTN          = By.cssSelector("[data-test='increase-quantity']");
    public static final By QUANTITY_INPUT             = By.cssSelector("[data-test='quantity']");
    

    // 🧾 Product Info
    public static final By PRODUCT_NAME               = By.cssSelector("[data-test='product-name']");
    public static final By PRODUCT_PRICE              = By.cssSelector("[data-test='unit-price']");

    // ⏳ Loader / Pop up
    public static final By LOADER_POPUP               =By.xpath("//*[contains(text(),'added')]");

    // 🛍 Cart
    public static final By CART_ICON                  = By.cssSelector("[data-test='nav-cart']");
    public static final By CART_PRODUCT_NAME          = By.cssSelector("[data-test='product-title']");
    public static final By CART_PRODUCT_PRICE         = By.cssSelector("[data-test='product-price']");
    public static final By CART_PRODUCT_QUANTITY      = By.cssSelector("[data-test='product-quantity']");

    // ❌ Remove / Close
    public static final By REMOVE_PRODUCT_BTN         = By.xpath("//tr//a[contains(@class,'btn-danger')]");
    public static final By EMPTY_CART_MESSAGE         = By.xpath("//p[contains(text(),'cart is empty')]");
    public static final By REMOVE_LOADER_POPUP       = By.cssSelector("#toast-container .toast, #toast-container .toast-message"); 
   
}
