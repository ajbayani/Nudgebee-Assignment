package java1;

import java1.LoginActions;
import java1.Baseclass;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * LoginTest — Scenario 1: Login Flow Extends BaseClass to get driver, wait,
 * setUp, tearDown
 */

public class LoginTest extends Baseclass {

	// Valid test credentials
	private static final String VALID_EMAIL = "customer@practicesoftwaretesting.com";
	private static final String VALID_PASSWORD = "welcome01";
	private static final String EXPECTED_NAME = "Jane Doe"; // Expected username after login

	@Test(description = "Scenario 1 — Full Login and Logout Flow")
	public void testLoginAndLogout() {

		// Step 1: Create actions object — pass driver and wait from BaseClass
		LoginActions LoginActions = new LoginActions(driver, wait);

		// Step 2: Navigate to login page
		LoginActions.navigateToLoginPage();

		// Step 3: Verify login page is loaded — URL should contain /auth/login

//		String currentUrl = getCurrentUrl();
//		Assert.assertTrue(currentUrl.contains("/auth/login"), "Login page did not load. Current URL: " + currentUrl);

		// Step 4: Login with valid credentials
		LoginActions.login(VALID_EMAIL, VALID_PASSWORD);

		// Step 5: Verify dashboard loads — URL should NOT contain login anymore
//		String postLoginUrl = getCurrentUrl();
//		Assert.assertFalse(postLoginUrl.contains("/auth/login"),
//				"User was NOT redirected after login. Still on: " + postLoginUrl);

		// Step 6: Verify correct username is visible in nav
		String displayedUsername = LoginActions.getLoggedInUsername();
		Assert.assertEquals(displayedUsername, EXPECTED_NAME,
				"Logged in username mismatch. Expected: " + EXPECTED_NAME + " but got: " + displayedUsername);

		// Step 7: Logout
		LoginActions.logout();

		// Step 8: Verify redirect back to login page after logout
//		String postLogoutUrl = getCurrentUrl();
//		Assert.assertTrue(postLogoutUrl.contains("/auth/login"),
//				"User was NOT redirected to login page after logout. Current URL: " + postLogoutUrl);
	}

	
}
