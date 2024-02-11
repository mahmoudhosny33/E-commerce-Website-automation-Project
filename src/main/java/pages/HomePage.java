package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BrowserActions;

public class HomePage extends BasePage {

    /*********** Elements Locators ***********/


     By searchTextBox= By.xpath("//input[@name='q']");

     By searchButton= By.xpath("//button[text()='Search']");
     By bookList=By.xpath("(//a[text()='Books '])[1]");

     By myAccountButton= By.linkText("My account");
     By addToCartBtn=By.xpath("(//button[text()='Add to cart'])[1]");
     By itemIsAddedToMyCartMessage=By.cssSelector("p.content");



    /*********** page Constructor**************/
    public HomePage(WebDriver driver){
        super(driver);
    }

    /************** Page Functions ****************/

    public void enterTextInSearchBox(String text){ BrowserActions.sendKey(driver,searchTextBox,text);}

    public void clickOnSearchButton(){ BrowserActions.clickButton(driver,searchButton);}
    public void clickOnBokksListLink(){
        BrowserActions.clickButton(driver,bookList);
    }
    public void clickOnAddToCartBtn(){
        BrowserActions.clickButton(driver,addToCartBtn);
    }
    public String getMessageOfItemIsAddedToMyCart(){
       return BrowserActions.getText(driver,itemIsAddedToMyCartMessage);
    }

}
