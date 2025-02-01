package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1 extends BaseTest {

    @Test
    public void test1() {
        String pagetilte=driver.get().getTitle();
        String url=driver.get().getCurrentUrl();
        Assert.assertEquals(pagetilte,"Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN","Page title is not correct");
        System.out.println("Page title is: "+pagetilte);
        Assert.assertEquals(url,"https://in.godaddy.com/","URL is not correct");
        System.out.println("URL is: "+url);
    }

    @Test
    public void test2() {
        System.out.println("Test 2");
    }

    @Test
    public void test3() {
        System.out.println("Test 3");
    }
}
