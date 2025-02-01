package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1 extends BaseTest {

    @Test(description = "Test Case - Open Godaddy.com and Print its Page title.")
    public void test1() {
        String pagetilte= homePage.getPageTitle();
        String url=driver.get().getCurrentUrl();
        System.out.println("Page title is: "+pagetilte);
        System.out.println("URL is: "+url);
    }

    @Test(description = "Test Case - Open Godaddy.com and Validate Page Title")
    public void test2() {
        String pagetilte= homePage.getPageTitle();
        String url=driver.get().getCurrentUrl();
        Assert.assertEquals(pagetilte,"Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN","Page title is not correct");
        System.out.println("Page title is: "+pagetilte);
        Assert.assertEquals(url,"https://www.godaddy.com/en-in","URL is not Matched");
        System.out.println("URL is: "+url);
        String pageSource=driver.get().getPageSource();
        System.out.println("Page Source is: "+pageSource);
        Assert.assertTrue(pageSource.contains("GoDaddy"), "Page Source does not contains GoDaddy.com");
    }

    @Test(description = "Automate GoDaddy.com website menu links")
    public void test3() {
        String url=driver.get().getCurrentUrl();
        System.out.println("Navigated to : "+url);
        homePage.clickDomainMenu();

    }
}
