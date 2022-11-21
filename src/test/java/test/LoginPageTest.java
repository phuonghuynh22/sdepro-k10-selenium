package test;

import driver.DriverFactory;
import models.components.LoginFormComponent;
import models.pages.HerokuLoginPage;
import models.pages.LoginPageMod03;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class LoginPageTest implements Urls {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {

            // Navigate to the target page
            driver.get(BASE_URL.concat(LOGIN_SLUG));

            // Input login creds
            HerokuLoginPage loginPage = new HerokuLoginPage(driver);
            System.out.println(loginPage.footerComp().getLinkText());

            LoginFormComponent loginFormComp = loginPage.loginFormComp();
            loginFormComp.usernameElem().sendKeys("tomsmith");


            // Debug purpose
            Thread.sleep(2000);

        }catch (Exception e){
            e.printStackTrace();
        }

        driver.quit();
    }
}
