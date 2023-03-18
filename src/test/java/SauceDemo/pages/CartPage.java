package SauceDemo.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BaseClass {
    public CartPage() {
        PageFactory.initElements(driver,this);
    }
    public @FindBy(id = "checkout") WebElement checkOutButton;
    public @FindBy(id="cancel") WebElement cancelBtn;
    public @FindBy (id = "shopping_cart_container") WebElement shopingCartButton;

    public void clickOnShopingCartButton () {
        shopingCartButton.click();
    }
    public void clickOnCheckOutButton () {
        checkOutButton.click();
    }

    public void cancelCheckOut(){
        cancelBtn.click();
    }

}
