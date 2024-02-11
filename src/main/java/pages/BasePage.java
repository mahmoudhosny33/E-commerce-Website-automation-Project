package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BrowserActions;

public class BasePage {

    WebDriver driver;

    /*********** Elements Locators ***********/

    By loginLink= By.xpath("//a[text()='Log in']");


    By registerLink= By.xpath("//a[text()='Register']");


    /*********** page Constructor**************/
    public BasePage(WebDriver driver){
        this.driver=driver;
    }

    /************** Page Functions ****************/
    public void clickOnLoginLink(){ BrowserActions.clickButton(driver,loginLink);}

    public void clickOnRegisterLink(){  BrowserActions.clickButton(driver,registerLink);}


}
