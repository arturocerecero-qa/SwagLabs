package SauceDemo.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BaseClass {

    public LoginPage() {
        PageFactory.initElements(driver,this);
    }

    public @FindBy(id = "user-name") WebElement username;
    public @FindBy(id = "password") WebElement password;
    public @FindBy(id = "login-button") WebElement loginBtn;
    public @FindBy (className = "error-button") WebElement error;


    public void inputUsername (String usernameInfo) {
        username.clear();
        username.sendKeys(usernameInfo);
    }
    public void inputPassword (String passwordInfo) {
        password.clear();
        password.sendKeys(passwordInfo);
    }

    public void clickOnLogInButton () {
        loginBtn.click();
    }

    public void logInPage (String usernameInfo,String passwordInfo) {
        Assert.assertTrue(IsElementDisplayed(username));
        inputUsername(usernameInfo);
        inputPassword(passwordInfo);
        clickOnLogInButton();
    }



}
