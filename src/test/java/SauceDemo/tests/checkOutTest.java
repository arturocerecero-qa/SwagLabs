package SauceDemo.tests;

import SauceDemo.pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class checkOutTest extends BaseClass {
    String username;
    String password;
    String firstname;
    String lastname;
    String postcode;

    @BeforeMethod
    public void setUpPage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        waiter = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        loginPage = new LoginPage();
        cartPage = new CartPage();
        checkoutPage = new CheckOutPage();
        homePage = new HomePage();
    }
    public void setupLogin() {
        username = excelReader.getStringData("LoginValid", 1, 0);
        password = excelReader.getStringData("LoginValid", 1, 1);
        logIn(username, password);
    }
    @Test
    public void CorrectCheckOut () {
            setupLogin();
            homePage.addItemToCartBackPack();
            cartPage.clickOnShopingCartButton();
            cartPage.clickOnCheckOutButton();
            firstname = excelReader.getStringData("CheckOut", 1,0);
            lastname = excelReader.getStringData("CheckOut", 1,1);
            postcode = excelReader.getStringData("CheckOut", 1,2);
            checkOut(firstname,lastname,postcode);
            Assert.assertTrue(IsElementDisplayed(checkoutPage.OverviewLabel));
        }
    @Test
    public void CancelCheckOut(){
        setupLogin();
        homePage.addItemToCartJacket();
        cartPage.clickOnShopingCartButton();
        cartPage.clickOnCheckOutButton();
        cartPage.cancelCheckOut();
        Assert.assertTrue(IsElementDisplayed(cartPage.checkOutButton));
    }


    @AfterMethod
    public void shutDownTest () {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
