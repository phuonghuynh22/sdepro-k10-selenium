package test;

import driver.DriverFactory;
import models.pages.LoginPageMod03;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class LoginMod03Test implements Urls {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {

            // Navigate to the target page
            driver.get(BASE_URL.concat(LOGIN_SLUG));

            // Input login creds
            // Method chaining
            LoginPageMod03 loginPageMod03 = new LoginPageMod03(driver);
            loginPageMod03
                    .inputUsername("tomsmith")
                    .inputPassword("SuperSecretPassword!")
                    .clickLoginBtn();

            // Debug purpose
            Thread.sleep(2000);

        }catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }
}
