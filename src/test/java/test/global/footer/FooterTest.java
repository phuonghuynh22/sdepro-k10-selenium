package test.global.footer;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;
import test_flows.global.footer.FooterTestFlow;
import url.Urls;

import java.beans.Transient;

public class FooterTest extends BaseTest {

    /*
     * Below is the way defining a method for a Test without BaseTest class
     * this class does not extend any class
     */
    /*
    @Test
    public void testHomePageFooter(){
        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            driver.get(Urls.DEMO_PAGE_URL);
            FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
            footerTestFlow.verifyFooterComponent();

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

     */

    @Test
    public void testHomePageFooter() {
        driver.get(Urls.DEMO_PAGE_URL);
        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
        footerTestFlow.verifyFooterComponent();
    }

    @Test
    public void testCategoryPageFooter() {

        driver.get(Urls.DEMO_PAGE_URL);
        Assert.fail("Demo taking screenshot when test is failed");
        FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
        footerTestFlow.verifyFooterComponent();
    }

    public void testLoginPageFooter() {
    }
}
