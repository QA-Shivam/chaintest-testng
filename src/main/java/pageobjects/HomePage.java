package pageobjects;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BaseTest {
    private WebDriver driver;

    // Example web elements
    private By domainMenu = By.xpath("//li[@data-track-name='domain_names2']");
    private By loginButton = By.id("loginButton");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
    public void clickDomainMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement menu=wait.until(driver -> driver.findElement(domainMenu));
        menu.click();
    }
}
