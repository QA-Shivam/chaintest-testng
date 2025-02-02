package base;

import com.aventstack.chaintest.plugins.ChainTestListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

//@Listeners(ChainTestListener.class)
public class BaseTest extends PageObjectsFactory {

    // ThreadLocal to make WebDriver thread-safe
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    @BeforeMethod
    public void beforeMethod(Method method) {
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            ChainTestListener.embed(takess(),"image/png");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            ChainTestListener.embed(takess(),"image/png");
        } else if (result.getStatus() == ITestResult.SKIP) {
            ChainTestListener.embed(takess(),"image/png");
        }
    }

    @Parameters({"browser", "url"})
    @BeforeTest
    public void setUp(String browser, String url) {
        WebDriver driverInstance = null;
        // Initialize the WebDriver for the current thread
        switch (browser) {
            case "chrome":
                driverInstance = new ChromeDriver();
                break;
            case "firefox":
                driverInstance = new FirefoxDriver();
                break;
            case "safari":
                driverInstance = new SafariDriver();
            case "edge":
                driverInstance = new EdgeDriver();
                break;
            default:
                System.out.println("Unsupported browser: " + browser);
                break;
        }
        if (driverInstance != null) {
            driverInstance.manage().window().maximize();
            driverInstance.get(url);
            driver.set(driverInstance);
            // Initialize all page objects
            initPageObjects(driverInstance);
        } else {
            System.out.println("Error: WebDriver could not be initialized.");
        }
    }

    @AfterTest
    public void afterTest() {
        // Cleanup: quit the WebDriver for the current thread
        WebDriver driverInstance = driver.get();
        if (driverInstance != null) {
            driverInstance.quit();
        }
        // Remove the WebDriver instance from ThreadLocal to ensure thread safety
        driver.remove();
    }
    public byte[] takess() {
        TakesScreenshot screenshotDriver = (TakesScreenshot) driver.get();
        return  screenshotDriver.getScreenshotAs(OutputType.BYTES);
    }
}
