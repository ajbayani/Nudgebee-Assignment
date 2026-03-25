package java1;


import java1.LoginLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
/**
 * LoginActions — All reusable actions on the Login page
 * Accepts driver and wait from BaseClass — no driver creation here
 */

public class LoginActions {
    private final WebDriver driver;
    private final WebDriverWait wait;
 
    // Constructor injection — driver and wait passed from test
    public LoginActions(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
 
    /**
     * Navigate to login page by clicking Sign In link
     */
    public void navigateToLoginPage() {
        WebElement signInLink = wait.until(
            ExpectedConditions.elementToBeClickable(LoginLocators.NAV_SIGN_IN_LINK)
        );
        signInLink.click();
        wait.until(ExpectedConditions.urlContains("/auth/login"));
        
    }
 
    /**
     * Enter email in email field
     * @param email — email string to enter
     */
    public void enterEmail(String email) {
        WebElement emailField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(LoginLocators.EMAIL_INPUT)
        );
        emailField.clear();
        emailField.sendKeys(email);
    }
 
    /**
     * Enter password in password field
     * @param password — password string to enter
     */
    public void enterPassword(String password) {
        WebElement passwordField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(LoginLocators.PASSWORD_INPUT)
        );
        passwordField.clear();
        passwordField.sendKeys(password);
    }
 
    /**
     * Click the Login button
     */
    public void clickLoginButton() {
        WebElement loginBtn = wait.until(
            ExpectedConditions.elementToBeClickable(LoginLocators.LOGIN_BUTTON)
        );
        loginBtn.click();
    }
 
    /**
     * Full login flow combined — enter email, password, click login
     * @param email    — user email
     * @param password — user password
     */
    public void login(String email, String password) {
        navigateToLoginPage();
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
 
    /**
     * Get logged-in username text from nav menu
     * @return username string
     */
    public String getLoggedInUsername() {
        WebElement userMenu = wait.until(
            ExpectedConditions.visibilityOfElementLocated(LoginLocators.LOGGED_IN_USERNAME)
        );
        return userMenu.getText().trim();
    }
 
    /**
     * Click logout button
     */
    public void logout() {

        // Step 1: Click on user menu (Jane Doe dropdown)
        WebElement userMenu = wait.until(
            ExpectedConditions.elementToBeClickable(LoginLocators.USER_MENU)
        );
        userMenu.click();

        // Step 2: Wait for logout option to be visible
        WebElement logoutBtn = wait.until(
            ExpectedConditions.visibilityOfElementLocated(LoginLocators.LOGOUT_BUTTON)
        );

        // Step 3: Click logout
        logoutBtn.click();

        // Optional: wait for redirect to login/home page
        wait.until(ExpectedConditions.urlContains("/auth/login"));
    }
 
    /**
     * Check if login error message is displayed
     * @return true if error is visible
     */
    public boolean isErrorMessageDisplayed() {
        try {
            WebElement error = wait.until(
                ExpectedConditions.visibilityOfElementLocated(LoginLocators.LOGIN_ERROR_MESSAGE)
            );
            return error.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    
    
}
