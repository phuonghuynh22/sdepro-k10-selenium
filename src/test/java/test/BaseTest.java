package test;

import driver.DriverFactory;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BaseTest {

    // putting "static" (bad practice) here is intention in order to cause an error for the next lesson
    protected static WebDriver driver;

    @BeforeTest // this will be run at the step     <test name="Global Component Test" > in file regression.xml file
    public void initBrowserSession(){
        driver = DriverFactory.getChromeDriver();
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowserSession(){
        if(driver != null) driver.quit();
    }

    @AfterMethod
    public void captureScreenshot(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){

            // testMethodName-yyyy-MM-dd-hr-mm-sec.png

            // Get method name
            String methodName = result.getName();

            // Get taken time
            Calendar calendar = new GregorianCalendar();
            int y = calendar.get(Calendar.YEAR);
            int m = calendar.get(Calendar.MONTH) + 1;
            int d = calendar.get(Calendar.DATE);
            int hr = calendar.get(Calendar.HOUR_OF_DAY);
            int min = calendar.get(Calendar.MINUTE);
            int sec = calendar.get(Calendar.SECOND);

            String fileName = methodName + " - " + y + " - " + m + " - " + d + " - " + hr + " - " + min + " - " + sec + ".png";

            // Take screenshot
            File screenshotBase64Data = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);


            try{
                // 4. Save
                String fileLocation = System.getProperty("user.dir") + "/screenshots/" + fileName;
                FileUtils.copyFile(screenshotBase64Data, new File(fileLocation));

                // 5. Attach to allure reporter
                Path content = Paths.get(fileLocation);
                try(InputStream inputStream = Files.newInputStream(content)){
                    Allure.addAttachment(methodName, inputStream);
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
