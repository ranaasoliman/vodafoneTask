package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.util.concurrent.TimeUnit;

public class PageBase {

    public static WebDriver driver ;
    public Wait<WebDriver> fluentWait;

    public PageBase(WebDriver driver) {
        this.driver = driver ;
        this.fluentWait = new FluentWait<WebDriver>(driver).withTimeout(120, TimeUnit.SECONDS)
                .pollingEvery(3, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
    }



}
