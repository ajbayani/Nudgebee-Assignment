package java1;


import org.openqa.selenium.By;
 
/**
 * LoginLocators — All locators for the Login page
 * Follows Page Object Model (POM) pattern
 * Locators are static final — they never change
 */
public class LoginLocators {
	//Q1
    // Navigation to login page
    public static final By NAV_SIGN_IN_LINK       = By.cssSelector("[data-test='nav-sign-in']");
 
    // Login form fields
    public static final By EMAIL_INPUT             = By.cssSelector("[data-test='email']");
    public static final By PASSWORD_INPUT          = By.cssSelector("[data-test='password']");
    public static final By LOGIN_BUTTON            = By.cssSelector("[data-test='login-submit']");
 
    // Post-login verification
    public static final By USER_MENU               = By.cssSelector("[data-test='nav-menu']");
    public static final By LOGGED_IN_USERNAME      = By.cssSelector("[data-test='nav-menu']"); 
    		
    public static final By LOGOUT_BUTTON           = By.cssSelector("[data-test='nav-sign-out']");
 
    // Error message locator
    public static final By LOGIN_ERROR_MESSAGE     = By.cssSelector(".alert.alert-danger");

    
    
}
