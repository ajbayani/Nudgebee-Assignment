package java1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
 
import java.time.Duration;
public class Baseclass {

	    // WebDriver instance — protected so all test classes can access it
	    protected WebDriver driver;
	 
	    // Explicit wait instance — reusable across all tests
	    protected WebDriverWait wait;
	 
	    // Base URL — change this once if URL changes
	    protected static final String BASE_URL = "https://practicesoftwaretesting.com";
	 
	    // Timeout constant
	    protected static final int WAIT_TIMEOUT = 10;
	    
	   
	 
	    @BeforeMethod
	    public void setUp() {
	        // driver setup
	    	
	    	 WebDriver driver = new ChromeDriver(); 
	    	 driver.manage().window().maximize();
       
	        // Initialize explicit wait
	        wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
	 
	        // Navigate to base URL
	        driver.get(BASE_URL);
	        System.out.println("Driver in setup: " + driver);
	  }
	    
	 
	    @AfterMethod
	    public void tearDown() {
	        // Close browser after every test method
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}

