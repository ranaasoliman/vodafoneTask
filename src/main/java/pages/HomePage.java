package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements( driver, this);
    }

    @FindBy (xpath = "//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div[2]/div/div/div/div")
    WebElement tweetTxt;

    @FindBy (xpath = "//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[4]/div/div/div[2]/div[3]/div")
    WebElement tweetBtn;

    @FindBy (xpath = "//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div")
    WebElement tweetFailureMsg;

    @FindBy (xpath = "//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[4]/div/div/div[1]/div[1]")
    WebElement imageBtn;

    @FindBy (xpath = "//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[2]/div/div/div[1]/div[2]/div")
    WebElement gifBtn;

    @FindBy (xpath = "//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[4]/div/div/div[1]/div[2]")
    WebElement addGIF;

    @FindBy (xpath = "//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[4]/div/div/div[1]/div[3]")
    WebElement pollBtn;

    public void clickTweetBtn() {
        fluentWait.until(ExpectedConditions.elementToBeClickable(tweetBtn));
        tweetBtn.click();
    }

    public void addTweet(String tweet) {

        tweetTxt.sendKeys(tweet);
        fluentWait.until(ExpectedConditions.elementToBeClickable(tweetBtn));
        tweetBtn.click();
    }

    public WebElement getTweetFailureMsg() {
        return tweetFailureMsg;
    }

    public WebElement getImageBtn() {
        return imageBtn;
    }
    public WebElement getAddGIF() {
        return addGIF;
    }

    public WebElement getGifBtn() {
        return gifBtn;
    }

    public WebElement getPollBtn() {
        return pollBtn;
    }

    public void addImage(String file) {
        //fluentWait.until(ExpectedConditions.visibilityOf(imageBtn));
        WebElement imageInput = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[2]/div/div/div[1]/input"));
        imageInput.sendKeys(file);

    }

    public void addMultipleImage(String file) {

        WebElement imageInput1 = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[2]/div/div/div[1]/input"));
        imageInput1.sendKeys(file);
        WebElement imageInput2 = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[4]/div/div/div[1]/div[1]/div"));
        imageInput1.sendKeys(file);
        imageInput1.sendKeys(file);
        imageInput1.sendKeys(file);
    }

    public void addGIF(String gifName) throws InterruptedException {

        fluentWait.until(ExpectedConditions.elementToBeClickable(gifBtn));
        gifBtn.click();

        WebElement gifDialog = driver.findElement(By.xpath("//*[@id=\"layers\"]/div[2]/div/div/div/div/div/div[2]/div[2]"));
        fluentWait.until(ExpectedConditions.visibilityOf(gifDialog));
        WebElement gifInput = driver.findElement(By.xpath("//*[@id=\"layers\"]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div[1]/div/div/div/div[2]/div[2]/div/div/div[2]/input"));
        gifInput.sendKeys(gifName);

        WebElement gifSelection = driver.findElement(By.xpath("//*[@id=\"layers\"]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/div[1]"));
        fluentWait.until(ExpectedConditions.elementToBeClickable(gifSelection));
        gifSelection.click();
    }

    public void addPoll(String question, String choice1, String choice2) {

        WebElement addPoll = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[2]/div/div/div[1]/div[3]/div"));
        addPoll.click();

        WebElement questionTxt = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/div/div/div[1]/div[1]/div/div/div/div[2]/div/div/div/div"));
        WebElement choice1Txt = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/div/div/div[2]/div/div[1]/div[1]/div[1]/div/label/div/div[2]/div/input"));
        WebElement choice2Txt = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/div/div/div[2]/div/div[1]/div[1]/div[2]/div/label/div/div[2]/div/input"));
        questionTxt.sendKeys(question);
        choice1Txt.sendKeys(choice1);
        choice2Txt.sendKeys(choice2);
    }








}
