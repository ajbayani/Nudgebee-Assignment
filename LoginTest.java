package java1;

import java1.LoginActions;
import java1.Baseclass;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LoginTest extends Baseclass {
// Valid test credentials
	private static final String VALID_EMAIL = "customer@practicesoftwaretesting.com";
	private static final String VALID_PASSWORD = "welcome01";
	private static final String EXPECTED_NAME = "Jane Doe";
// Initialize report

	@Test(description = "Scenario 1 — Full Login and Logout Flow")
	public void Q1LoginFlow() throws Exception {

		try {

			LoginActions LoginActions = new LoginActions(driver, wait);
			test.info("Entering login credentials");

			captureAndAttachScreenshot("Q1.Loggedin with correct credentials");

			LoginActions.login(VALID_EMAIL, VALID_PASSWORD);

			test.info("Waiting for account page to load");
			wait.until(ExpectedConditions.urlContains("/account"));

			String currentUrl = getCurrentUrl();
			test.info("Current URL: " + currentUrl);

			Assert.assertTrue(currentUrl.contains("/account"), "Login page loaded. Current URL: " + currentUrl);
			test.pass("Login successful and redirected to account page");

			// Logout step
			test.info("Logging out");
			LoginActions.logout();

			test.pass("Logout successful");
			captureAndAttachScreenshot("Q1.Loggedout successfully");

		} catch (AssertionError e) {
			test.fail("Assertion Failed: " + e.getMessage());
			throw e;

		} catch (Exception e) {
			test.fail("Test Failed: " + e.getMessage());
			throw e;

		} finally {
			extent.flush();
		}
	}
}