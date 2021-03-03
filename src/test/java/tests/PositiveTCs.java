package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import java.io.File;

public class PositiveTCs extends TestBase{

    String username = "User12206315700";
    String password = "Password122";
    String question = "What do you think?";
    String choice1 = "Option 1";
    String choice2 = "Option 2";
    String gifSearch = "Friends";

    LoginPage loginPage;
    HomePage homePage;


    //Positive Scenarios
    @Test
    public void uploadImage() {

        loginPage = new LoginPage(driver);
        homePage = loginPage.Login(username, password);

        File imageFile = new File("uploads/twitter1.jpg");
        homePage.addImage(imageFile.getAbsolutePath());
        homePage.clickTweetBtn();
    }

    @Test
    public void AddGIF() throws InterruptedException {

        loginPage = new LoginPage(driver);
        homePage = loginPage.Login(username, password);

        homePage.addGIF(gifSearch);
        homePage.clickTweetBtn();
    }

    @Test
    public void addPoll() {

        loginPage = new LoginPage(driver);
        homePage = loginPage.Login(username, password);

        homePage.addPoll(question, choice1, choice2);
        homePage.clickTweetBtn();
    }



}
