package SauceDemo.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends BaseClass {
    public CheckOutPage() { PageFactory.initElements(driver,this); }

    public @FindBy(id="first-name") WebElement firstName;
    public @FindBy(id="last-name") WebElement lastName;
    public @FindBy(id="postal-code")WebElement postalCode;
    public @FindBy(id="continue") WebElement continueBtn;
    public @FindBy(xpath = "//span[@class='title']") WebElement OverviewLabel;

    public void inputFirstName(String firstname){
        firstName.clear();
        firstName.sendKeys(firstname);
    }

    public void inputLastName(String lastname){
        lastName.clear();
        lastName.sendKeys(lastname);
    }

    public void inputZipCode(String postcode){
        postalCode.clear();
        postalCode.sendKeys(postcode);
    }

    public void submitContinue(){
        continueBtn.click();
    }
}
