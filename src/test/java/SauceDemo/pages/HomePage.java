package SauceDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
public class HomePage extends BaseClass {

    public HomePage() { PageFactory.initElements(driver,this); }

    /*Elements*/
    public @FindBy(xpath = "//span[@class='title']") WebElement pageTitle;
    public @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']") WebElement itemBackpack;
    public @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']") WebElement itemJacket;
    public @FindBy (id = "shopping_cart_container") WebElement shopingCartButton;

    /*Assertions*/
    public void HomePageAssertion(){
        List<WebElement> XpathTitleExist = driver.findElements(By.xpath("//span[@class='title']"));
        Assert.assertEquals(XpathTitleExist.size(),1,"Successfully Logged In");
    }

    /*Actions*/
    public void addItemToCartBackPack(){
        itemBackpack.click();
    }

    public void addItemToCartJacket(){
        itemJacket.click();
    }
}
