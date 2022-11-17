package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.ui.WaitForElementEnabled;
import url.Urls;

import java.time.Duration;

public class JsAlerts implements Urls{

    private final static By jsAlertSel = By.cssSelector("button[onclick=\"jsAlert()\"]"); // or "[onclick=\"jsAlert()\"]"
    private final static By jsConfirmSel = By.cssSelector("button[onclick=\"jsConfirm()\"]");
    private final static By jsPromptSel = By.cssSelector("button[onclick=\"jsPrompt()\"]");
    private final static By resultTextSel = By.cssSelector("#result");


    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getChromeDriver();

        try {

            // Navigate to the target page
            driver.get(Urls.BASE_URL.concat(Urls.JS_ALERT_SLUG));

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
            boolean isAcceptedAlert = true;

            // JS ALERT | OK
            WebElement triggerJsAlertBtnElem = driver.findElement(jsAlertSel);

            //this line of code replaces the block of code below
            handleAlert(wait, triggerJsAlertBtnElem, isAcceptedAlert);
            /*
            triggerJsAlertBtnElem.click();
            Alert jsAlert = wait.until(ExpectedConditions.alertIsPresent());
            jsAlert.accept();
             */
            System.out.println("Result: " + driver.findElement(resultTextSel).getText());


            // JS CONFIRM | CANCEL
            WebElement triggerJsConformBtnElem = driver.findElement(jsConfirmSel);
            isAcceptedAlert = false;
            handleAlert(wait, triggerJsConformBtnElem, isAcceptedAlert);

            /*
            triggerJsConformBtnElem.click();
            Alert jsConfirm = wait.until(ExpectedConditions.alertIsPresent());
            jsConfirm.dismiss();
             */
            System.out.println("Result: " + driver.findElement(resultTextSel).getText());


            // JS PROMPT | input text then accept
            WebElement triggerJsPromptBtnElem = driver.findElement(jsPromptSel);
            handleAlert(wait, triggerJsPromptBtnElem, "Sending from a prompt modal...\n nnnnn");

            /*triggerJsPromptBtnElem.click();
            Alert jsPrompt = wait.until(ExpectedConditions.alertIsPresent());
            jsPrompt.sendKeys("Sending from a prompt modal...");
            jsPrompt.accept();
             */
            System.out.println("Result: " + driver.findElement(resultTextSel).getText());


            // Debug purpose
            Thread.sleep(2000);

        }catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }

    // Create a common method

    private static void handleAlert (WebDriverWait wait, WebElement alertElem, boolean isAccepted){

        alertElem.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        if (isAccepted) alert.accept();
        else  alert.dismiss();
    }

    private static void handleAlert (WebDriverWait wait, WebElement alertElem, String inputStr){

        alertElem.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(inputStr);
        alert.accept();
    }
}
