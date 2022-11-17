package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import url.Urls;

public class JsExecutor implements Urls {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to the target page
            driver.get(Urls.BASE_URL.concat(Urls.FLOATING_MENU_SLUG));
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

            /**
             * Create a PageHelper to call defined methods
             */

            PageHelper pageHelper = new PageHelper(jsExecutor);

            // Scroll to the bottom
            //jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            pageHelper.scrollToBottom();

            // Debug purpose
            Thread.sleep(2000);

            // Then scroll to the top
            //jsExecutor.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
            pageHelper.scrollToTop();

            // Debug purpose
            Thread.sleep(2000);

            // Go to Dynamic control page
            driver.get(BASE_URL.concat(DYNAMIC_CONTROL_SLUG));
            Thread.sleep(2000);


            // Define 2 forms locator
            By checkboxFormSel = By.id("checkbox-example");
            By inputFormSel = By.cssSelector("#input-example");

            WebElement checkboxFormElem = driver.findElement(checkboxFormSel);
            WebElement inputFormElem = driver.findElement(inputFormSel);
            //jsExecutor.executeScript("arguments[0].remove()", inputFormElem);
            pageHelper.removeElement(inputFormElem);

            // Debug purpose
            Thread.sleep(2000);

            //jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 4px solid red;')", checkboxFormElem);
            pageHelper.changeElemStyleToFocusMode(checkboxFormElem);

            // Debug purpose
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}