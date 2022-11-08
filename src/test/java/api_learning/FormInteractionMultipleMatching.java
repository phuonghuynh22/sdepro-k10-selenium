package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FormInteractionMultipleMatching {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try{
            // Navigate to the target page
            driver.get("https://the-internet.herokuapp.com/login");

            // Define selector values
            By inputFieldSel = By.tagName("input"); // get the 1st element
            WebElement usernameElem = driver.findElement(inputFieldSel);
            List<WebElement> inputFieldElem = driver.findElements(inputFieldSel);

            if (inputFieldElem.isEmpty()) {
                throw new RuntimeException("[ERROR] There is no input fields!");
            }

            // magic number 0, 1: get(0)
            final int USERNAME_INDEX = 0;
            final int PASSWORD_INDEX = 1;

            inputFieldElem.get(USERNAME_INDEX).sendKeys("teo");
            inputFieldElem.get(PASSWORD_INDEX).sendKeys("123456789");


            // DEBUG PURPOSE ONLY
            try {
                Thread.sleep(3000);
            }catch (Exception ignored){}

        }catch ( Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
