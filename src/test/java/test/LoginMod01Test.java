package test;

import driver.DriverFactory;
import models.pages.LoginPageMod01;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class LoginMod01Test implements Urls {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {

            // Navigate to the target page
            driver.get(BASE_URL.concat(LOGIN_SLUG));

            // Input login creds
            LoginPageMod01 loginPageMod01 = new LoginPageMod01(driver);
            loginPageMod01.usernameElem().sendKeys("tomsmith");
            loginPageMod01.passwordElem().sendKeys("SuperSecretPassword!");
            loginPageMod01.loginBtnElem().click();

            // Debug purpose
            Thread.sleep(2000);

        }catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }
}
