package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BrowserActions;

public class RegisterPage extends BasePage {

    /*********** Elements Locators ***********/





    By genderField=By.xpath("//input[@id='gender-male']");
    By firstNameField=By.xpath("//input[@id='FirstName']");
    By lastNameField=By.xpath("//input[@id='LastName']");
    By dayField=By.xpath("//select[@name='DateOfBirthDay']");
    By monthField=By.xpath("//select[@name='DateOfBirthMonth']");
    By yearField=By.xpath("//select[@name='DateOfBirthYear']");

    By emailField=By.xpath("//input[@id='Email']");
    By companyField=By.xpath("//input[@id='Company']");
    By newSelterFielf=By.xpath("//input[@id='Newsletter']");
    By passwordField=By.xpath("//input[@id='Password']");
    By confirmPasswordField=By.xpath("//input[@id='ConfirmPassword']");

    By submitButton=By.xpath("//button[text()='Register']");

    By registerationCompletedMessage=By.xpath("//div[text()='Your registration completed']");

    By errorEmailIsEmpty=By.xpath("//span[@id='Email-error']");
    By errorEmailAlreadyExists=By.xpath("//div[@class='message-error validation-summary-errors']//li");

    By errorWrongEmailFormat=By.xpath("//span[@id='Email-error']");
    By errorPasswordRulePart1=By.xpath("//span[@id='Password-error']//p");
    By errorPasswordRulePart2=By.xpath("//span[@id='Password-error']//li");
    By errorConfirmPasswordNotMatch=By.xpath("//span[@id='ConfirmPassword-error']");
    //By changeCurrency=By.xpath("//select[@id='customerCurrency']");
    By errorFirstNameField=By.xpath("//span[@id='FirstName-error']");
    By errorLastNameField=By.xpath("//span[@id='LastName-error']");


    /*********** page Constructor**************/
    public RegisterPage(WebDriver driver){
        super(driver);
    }

    /************** Page Functions ****************/
    public void clickOnGenderType(){
        BrowserActions.clickButton(driver,genderField);
    }
    public void enterTextInFirstNameBox(String text){
        BrowserActions.sendKey(driver,firstNameField,text);}
    public void enterTextInLastNameBox(String text){
        BrowserActions.sendKey(driver,lastNameField,text);}
    public void selectDateOfBirthOptions(String day,String month,String year){
        BrowserActions.executeWait(driver,dayField);
        Select daySelect=new Select(driver.findElement(dayField));
        BrowserActions.executeWait(driver,monthField);
        Select monthSelect=new Select(driver.findElement(monthField));
        BrowserActions.executeWait(driver,yearField);
        Select yearSelect=new Select(driver.findElement(yearField));
        daySelect.selectByValue(day);
        monthSelect.selectByVisibleText(month);
        yearSelect.selectByValue(year);
    }


    public void enterTextInEmaillBox(String text){
        BrowserActions.sendKey(driver,emailField,text);}
    public void enterTextInCompanyBox(String text){
        BrowserActions.sendKey(driver,companyField,text);}
    public void clickOnNewsletterCheckBox(){
        BrowserActions.executeWait(driver,newSelterFielf);
        if(driver.findElement(newSelterFielf).isSelected())
            BrowserActions.clickButton(driver,newSelterFielf);
        else
            BrowserActions.clickButton(driver,newSelterFielf);
    }

    public void enterTextInPasswordBox(String text){
        BrowserActions.sendKey(driver,passwordField,text);}
    public void enterTextInConfirmPasswordBox(String text){
        BrowserActions.sendKey(driver,confirmPasswordField,text);}


    public String getRegisterationCompletedMessage(){
        return BrowserActions.getText(driver,registerationCompletedMessage);}

    public String getErrorMessageEmailFieldEmpty(){

        return BrowserActions.getText(driver,errorEmailIsEmpty);}
    public String getErrorMessageEmailAlreadyExists(){

        return BrowserActions.getText(driver,errorEmailAlreadyExists);}
    public String getErrorMessageWrongEmailFormat(){

        return BrowserActions.getText(driver,errorWrongEmailFormat);}
    public String getErrorMessageWrongPasswordRules(){

        String errorMess= BrowserActions.getText(driver,errorPasswordRulePart1);
        errorMess+=BrowserActions.getText(driver,errorPasswordRulePart2);
        return errorMess;
    }
    public String getErrorMessageConfirmPasswordNotMatch() {
        return BrowserActions.getText(driver, errorConfirmPasswordNotMatch);

    }
    public String getErrorFirstNameField() {
        return BrowserActions.getText(driver, errorFirstNameField);

    }
    public String getErrorLastNameField() {
        return BrowserActions.getText(driver, errorLastNameField);

    }

    public void clickOnSubmitButton(){
        BrowserActions.clickButton(driver,submitButton);
    }



}
