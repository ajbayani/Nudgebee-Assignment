package java1;

import org.openqa.selenium.WebDriver;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.reflect.Method;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;

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
	    
	    protected static ExtentReports extent;
	    protected ExtentTest test;

	 
	    
	    @BeforeMethod
	    public void setUp(Method method) {
	        // driver setup
	    	
	    	 driver = new ChromeDriver(); 
	    	 driver.manage().window().maximize();
       
	        // Initialize explicit wait
	        wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
	 
	        // Navigate to base URL
	        driver.get(BASE_URL);
	        System.out.println("Driver in setup: " + driver);
	        
	        // 🔹 Initialize report only once
	        if (extent == null) {
	        	String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date());
	        	String reportPath = "C:/Users/hp/Desktop/Reports/" 
	        	        + method.getName() + "_" + timestamp + ".html";
	            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
	            extent = new ExtentReports();
	            extent.attachReporter(spark);}
	        
	        // 🔹 Create test entry dynamically (test name)
	        test = extent.createTest(method.getName());
	  }
	    
	    public String getCurrentUrl() {
	        return driver.getCurrentUrl(); // driver is never null here if setUp() ran
	    }

	 // 🔹 Add this inside Baseclass
	    public String captureScreenshot(String testName) {

	        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date());

	        String path = "C:/Users/hp/Desktop/Reports/screenshots/" 
	                + testName + "_" + timestamp + ".png";

	        try {
	            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            File dest = new File(path);
	            FileHandler.copy(src, dest);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return path;
	    }
	    
	    public void captureAndAttachScreenshot(String stepName) throws IOException {

	        String screenshotPath = captureScreenshot(stepName);

	        test.info(stepName);
			test.addScreenCaptureFromPath(screenshotPath);
	    }
	    
	    @AfterMethod
	    public void tearDown() {
	        // Close browser after every test method
	        if (driver != null) {
	            driver.quit();
	        }
	        // Flush report
	        extent.flush();}
	}

