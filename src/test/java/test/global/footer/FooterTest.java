package test.global.footer;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import test_flows.global.footer.FooterTestFlow;
import url.Urls;

public class FooterTest {

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

    public void testCategoryPageFooter(){
    }

    public void testLoginPageFooter(){}
}
