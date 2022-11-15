package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import url.Urls;

public class IFrame {

    public static void main(String[] args) {
        // iframe[id^="mce"]

        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to the target page
            driver.get(Urls.BASE_URL.concat(Urls.IFRAME_SLUG));

            // Locate the iframe by its pre-fix
            WebElement iframeElem = driver.findElement(By.cssSelector("iframe[id^='mce']"));

            // Switch to the iframe
            driver.switchTo().frame(iframeElem);

            // Input text into the input area
            WebElement editorInputElem = driver.findElement(By.cssSelector("#tinymce"));
            editorInputElem.click();
            editorInputElem.clear();
            editorInputElem.sendKeys("New text herererererererere \n....................!");

            // Switch to the parent frame
            // if not, error "NoSuchElementException" will show
            driver.switchTo().defaultContent();
            driver.findElement(By.partialLinkText("Selenium")).getAttribute("href");

            // Debug purpose only
            Thread.sleep(2000);

        }catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();

    }
}
