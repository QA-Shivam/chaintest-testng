package testcases;

import base.BaseTest;
import com.aventstack.chaintest.plugins.ChainTestListener;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1 extends BaseTest {

    @Test(description = "Test Case - Open Godaddy.com and Print its Page title.")
    public void test1() {
        String pagetilte= homePage.getPageTitle();
        String url=driver.get().getCurrentUrl();
        ChainTestListener.log("Page title is: "+pagetilte);
        ChainTestListener.log("URL is: "+url);
    }

    @Test(description = "Test Case - Open Godaddy.com and Validate Page Title")
    public void test2() {
        String pagetilte= homePage.getPageTitle();
        String url=driver.get().getCurrentUrl();
        Assert.assertEquals(pagetilte,"Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN","Page title is not correct");
        ChainTestListener.log("Page title is: "+pagetilte);
        Assert.assertEquals(url,"https://www.godaddyn","URL is not Matched");
        ChainTestListener.log("URL is: "+url);
        String pageSource=driver.get().getPageSource();
        ChainTestListener.log("Page Source is: "+pageSource);
        Assert.assertTrue(pageSource.contains("GoDaddy"), "Page Source does not contains GoDaddy.com");
    }

    @Test(description = "Automate GoDaddy.com website menu links")
    public void test3() {
        String url=driver.get().getCurrentUrl();
        ChainTestListener.log("Navigated to : "+url);
        homePage.clickDomainMenu();

    }
}
