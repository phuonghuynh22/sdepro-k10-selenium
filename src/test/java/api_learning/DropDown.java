package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import support.ui.SelectEx;
import url.Urls;

public class DropDown {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to dropdown page
            driver.get(Urls.BASE_URL.concat(Urls.DROPDOWN_SLUG));

            // Locate select tag/ dropdown
            WebElement dropdownElem = driver.findElement(By.id("dropdown"));
            //WebElement dropdownElem = driver.findElement(By.cssSelector("#dropdown"));

            /**
             * A first way to select an options
             * Calling a default select method directly in this class
             */
            /*

            Select select = new Select(dropdownElem);

            // Select by visible text
            select.selectByVisibleText("Option 1");
            Thread.sleep(2000);

            // Select by index
            select.selectByIndex(2);
            Thread.sleep(2000);

            // Select by value
            select.selectByValue("1");
            Thread.sleep(2000);
             */

            /**
             * Another way to call a separate method to select any Dropdown
             * By creating an own method
             */

            SelectEx select = new SelectEx(dropdownElem);
            select.SelectOption1();

            // Debug purpose only
            Thread.sleep(3000);

        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
