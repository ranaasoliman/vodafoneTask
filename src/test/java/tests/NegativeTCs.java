package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.io.File;

public class NegativeTCs extends TestBase {

    String username = "User12206315700";
    String password = "Password122";
    String tweet = "Tweet 1";

    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void checkAddingSameTweetTwice() {

        loginPage = new LoginPage(driver);
        homePage = loginPage.Login(username, password);
        homePage.addTweet(tweet);
        homePage.addTweet(tweet);
        Assert.assertTrue(homePage.getTweetFailureMsg().isDisplayed());
    }

    @Test
    public void checkAddingMultipleInputs() throws InterruptedException {

        loginPage = new LoginPage(driver);
        homePage = loginPage.Login(username, password);

        File imageFile = new File("uploads/twitter1.jpg");
        homePage.addImage(imageFile.getAbsolutePath());

        Assert.assertTrue(Boolean.parseBoolean(homePage.getAddGIF().getAttribute("disabled")));
        Assert.assertTrue(Boolean.parseBoolean(homePage.getPollBtn().getAttribute("disabled")));
    }

    @Test
    public void checkAddingMaxNoImages() throws InterruptedException {

        loginPage = new LoginPage(driver);
        homePage = loginPage.Login(username, password);

        File imageFile = new File("uploads/twitter1.jpg");
        homePage.addMultipleImage(imageFile.getAbsolutePath());

        Thread.sleep(3000);
        Assert.assertTrue(Boolean.parseBoolean(homePage.getImageBtn().getAttribute("disabled")));
    }
}
