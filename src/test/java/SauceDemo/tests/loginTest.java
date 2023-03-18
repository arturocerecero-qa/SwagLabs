package SauceDemo.tests;

import SauceDemo.pages.BaseClass;
import SauceDemo.pages.HomePage;
import SauceDemo.pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class loginTest extends BaseClass {

    String usernameInfo;
    String passwordInfo;

    @BeforeMethod
    public void setUpPage () {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        waiter = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @Test
    public void userCanLogIn () {
        for (int i = 1; i<= excelReader.getLastRow("LoginValid"); i++) {
            usernameInfo = excelReader.getStringData("LoginValid", i, 0);
            passwordInfo = excelReader.getStringData("LoginValid", 1, 1);
            logIn(usernameInfo,passwordInfo);
            waitForVisibilityOfElements(homePage.pageTitle);
        }
    }
    @Test
    public void userCantLogIn () {
        usernameInfo = excelReader.getStringData("LoginValid", 1, 2);
        passwordInfo = excelReader.getStringData("LoginValid", 1, 1);
        logIn(usernameInfo,passwordInfo);
        Assert.assertTrue(loginPage.IsElementDisplayed(loginPage.error));
    }
    @Test
    public void userCantLogInWithEmptyPassword () {
        usernameInfo = excelReader.getStringData("LoginValid", 1, 2);
        passwordInfo = "";
        logIn(usernameInfo,passwordInfo);
        Assert.assertTrue(IsElementDisplayed(loginPage.error));
    }
    @Test
    public void userCantLogInWithInvalidPassword () {
//       Looping invalid passwords with users
        for (int i =1; i<= excelReader.getLastRow("LoginValid"); i++) {
            for (int j =1; j<= excelReader.getLastRow("Invalid password"); j++) {
                usernameInfo = excelReader.getStringData("LoginValid",i,0);
                passwordInfo = excelReader.getStringData("Invalid password", j,0);
                logIn(usernameInfo,passwordInfo);
                Assert.assertTrue(IsElementDisplayed(loginPage.error));
            }
        }
    }
    @AfterMethod
    public void shutDownTest () {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
