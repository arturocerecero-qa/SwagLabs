package SauceDemo.tests;

import SauceDemo.pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    @Test
    public void CartButtonCheck () {
//        For  valid users (predefined)
        for (int i =1; i<= excelReader.getLastRow("LoginValid"); i++) {
            username = excelReader.getStringData("LoginValid", i, 0);
            password = excelReader.getStringData("LoginValid", 1, 1);
            logIn(username,password);
            homePage.addItemToCartBackPack();
            cartPage.clickOnShopingCartButton();
            cartPage.clickOnCheckOutButton();
            firstname = excelReader.getStringData("CheckOut", 1,0);
            lastname = excelReader.getStringData("CheckOut", 1,1);
            postcode = excelReader.getStringData("CheckOut", 1,2);
            checkOut(firstname,lastname,postcode);
            Assert.assertTrue(IsElementDisplayed(checkoutPage.OverviewLabel));
        }
    }
    @AfterMethod
    public void shutDownTest () {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
