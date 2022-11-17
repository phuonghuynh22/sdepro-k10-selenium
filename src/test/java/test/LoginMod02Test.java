package test;

import driver.DriverFactory;
import models.pages.LoginPageMod02;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class LoginMod02Test implements Urls {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {

            // Navigate to the target page
            driver.get(BASE_URL.concat(LOGIN_SLUG));

            // Input login creds
            LoginPageMod02 loginPageMod02 = new LoginPageMod02(driver);
            loginPageMod02.inputUsername("tomsmith");
            loginPageMod02.inputPassword("SuperSecretPassword!");
            loginPageMod02.clickLoginBtn();

            // Debug purpose
            Thread.sleep(2000);

        }catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }
}
