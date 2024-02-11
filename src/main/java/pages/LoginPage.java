package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.*;

public class LoginPage extends BasePage {

    /*********** Elements Locators ***********/

    By welcomeMessage= By.xpath("//h1[text()='Welcome, Please Sign In!']");

    By emailTextBox=By.xpath("//input[@id='Email']");
    By passwordTextBox=By.xpath("//input[@id='Password']");
     By submitButton=By.xpath("//button[text()='Log in']");

     By emailIsUnRegistered=By.xpath("//li[text()='No customer account found']");
     By passwordIsEmptyOrWrong=By.xpath("//li[text()='The credentials provided are incorrect']");

     By emailEmpty=By.xpath("//span[@id='Email-error']");
     By emailIsWrong=By.xpath("//span[@id='Email-error']");
     By rememberMe=By.xpath("//input[@id='RememberMe']");
     By forgetPass=By.xpath("//a[@href='/passwordrecovery']");

    /*********** page Constructor**************/
    public LoginPage(WebDriver driver){
        super(driver);
    }

    /************** Page Functions ****************/
    public void clickOnSubmitButton(){
        BrowserActions.clickButton(driver,submitButton);
    }
    public String getWelocmeMessage(){
        return BrowserActions.getText(driver,welcomeMessage);}

    public void enterEmailAndPassword(String email,String password){
        BrowserActions.sendKey(driver,emailTextBox,email);
        BrowserActions.sendKey(driver,passwordTextBox,password);}

    public String getErrorMessageOfUnRegisteredEmail(){
        return BrowserActions.getText(driver,emailIsUnRegistered);}

    public String getErrorMessageOfWrongPasswordOrEmpty(){
        return BrowserActions.getText(driver,passwordIsEmptyOrWrong);}
    public String getErrorMessageEmailEmpty(){
        return BrowserActions.getText(driver,emailEmpty);}
    public String getErrorMessageOfWrongEmail(){
        return BrowserActions.getText(driver,emailIsWrong);}
    public void checkRememberMe(){
        BrowserActions.clickButton(driver,rememberMe);
    }
    public void clickOnForgetPassword(){
        BrowserActions.clickButton(driver,forgetPass);
    }
}
