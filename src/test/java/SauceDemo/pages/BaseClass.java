package SauceDemo.pages;

import SauceDemo.utility.Browsers;
import SauceDemo.utility.DataReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class BaseClass {
    public WebDriver driver;
    public WebDriverWait waiter;
    public String landPage;
    public LoginPage loginPage;
    public HomePage homePage;
    public String loggedPage;
    public CartPage cartPage;
    public CheckOutPage checkoutPage;
    public DataReader excelReader;

    @BeforeClass
    public void setup() throws IOException {
        WebDriverManager.chromedriver().setup();
        excelReader = new DataReader("DataFile/Data.xlsx");
        landPage = excelReader.getStringData("URL",1,0);
        loggedPage = excelReader.getStringData("URL", 1, 1);
    }
    public void logIn (String usernameInfo,String passwordInfo) {
        driver.get(landPage);
        Assert.assertTrue(IsElementDisplayed(loginPage.username));
        loginPage.inputUsername(usernameInfo);
        loginPage.inputPassword(passwordInfo);
        loginPage.clickOnLogInButton();
    }

    public void checkOut(String firstname, String lastname, String postcode){
        checkoutPage.inputFirstName(firstname);
        checkoutPage.inputLastName(lastname);
        checkoutPage.inputZipCode(postcode);
        checkoutPage.submitContinue();
    }
    public void waitForVisibilityOfElements(WebElement element) {
        waiter.until(ExpectedConditions.visibilityOf(element));
    }
    public boolean IsElementDisplayed(WebElement element) {
        boolean webelement = false;
        try { webelement = element.isDisplayed();
        } catch (Exception e) { }
        return webelement;
    }

    @AfterClass
        public void tearDown() {
            Browsers.quitBrowser(driver);
        }

}