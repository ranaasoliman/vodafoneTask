package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;


    @BeforeMethod
    @Parameters({"browser"})
    public void StartDriver( @Optional ("chrome") String browserName){

        if (browserName.equalsIgnoreCase("chrome")){

            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }

        else  if (browserName.equalsIgnoreCase("chrome-headless")){

            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");

            driver = new ChromeDriver(options);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.navigate().to("https://twitter.com/login");
    }
//    @AfterSuite
//    public void StopDriver(){
//
//        driver.quit();
//    }

    @AfterMethod
    public void takeScreenshot(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE){
            System.out.println("Failed, Taking screenshot....");
            Helper.screenshot(driver, result.getName());
        }
        if (result.getStatus() == ITestResult.SUCCESS){
            System.out.println("Passed, Taking screenshot....");
            Helper.screenshot(driver, result.getName());
        }
    }
}
