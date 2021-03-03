package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageBase{

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements( driver, this);
    }

    @FindBy (xpath = "//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[1]/label/div/div[2]/div/input")
    WebElement usernameTxt;

    @FindBy (xpath = "//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[2]/label/div/div[2]/div/input")
    WebElement passwordTxt;

    @FindBy (xpath = "//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[3]/div/div")
    WebElement loginBtn;


    public HomePage Login(String username, String password) {

        usernameTxt.sendKeys(username);
        passwordTxt.sendKeys(password);
        fluentWait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();

        HomePage homePage = new HomePage(driver);
        return homePage;
    }

}
