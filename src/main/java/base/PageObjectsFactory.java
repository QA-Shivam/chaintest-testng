package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.HomePage;

import java.util.HashMap;
import java.util.Map;

public class PageObjectsFactory {
    // Cache for page object instances
    private static final Map<Class<?>, Object> instances = new HashMap<>();
    protected  static HomePage homePage;
    // Thread-safe and lazy initialization of page objects
    public static synchronized <T> T getInstance(WebDriver driver, Class<T> pageClass) {
        // Check if page object is already created
        if (!instances.containsKey(pageClass)) {
            // Initialize page object if not already cached
            T instance = PageFactory.initElements(driver, pageClass);
            instances.put(pageClass, instance);
        }
        // Return the cached page object instance
        return (T) instances.get(pageClass);
    }

    // Method to initialize all page objects at once
    public void initPageObjects(WebDriver driver) {
        // Initializing individual page objects
         homePage = getInstance(driver, HomePage.class);
    }
}
