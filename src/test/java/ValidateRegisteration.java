import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.RegisterPage;

public class ValidateRegisteration extends BaseTest {

    @Test
    public void enterValidData(){
        HomePage homePage=new HomePage(driver);
        homePage.clickOnRegisterLink();
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.clickOnGenderType();
        registerPage.enterTextInFirstNameBox("Mahmoud");
        registerPage.enterTextInLastNameBox("Hosny");
        registerPage.selectDateOfBirthOptions("2","July","2000");
        registerPage.enterTextInEmaillBox("123456789mahmouddd6789@gmail.com");
        registerPage.enterTextInCompanyBox("AUCcompany");
        registerPage.clickOnNewsletterCheckBox();
        registerPage.enterTextInPasswordBox("Mahmoud12@");
        registerPage.enterTextInConfirmPasswordBox("Mahmoud12@");
        registerPage.clickOnSubmitButton();
        softAssert.assertEquals(registerPage.getRegisterationCompletedMessage(), "Your registration completed");
        softAssert.assertAll();
    }
    @Test
    public void leaveEmailFieldEmpty(){
        HomePage homePage=new HomePage(driver);
        homePage.clickOnRegisterLink();
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.clickOnGenderType();
        registerPage.enterTextInFirstNameBox("Mahmoud");
        registerPage.enterTextInLastNameBox("Hosnyyy");
        registerPage.selectDateOfBirthOptions("2","July","2000");
        registerPage.enterTextInCompanyBox("AUCcompany");
        registerPage.clickOnNewsletterCheckBox();
        registerPage.enterTextInPasswordBox("Mahmoud12@");
        registerPage.enterTextInConfirmPasswordBox("Mahmoud12@");
        registerPage.clickOnSubmitButton();
        softAssert.assertEquals(registerPage.getErrorMessageEmailFieldEmpty(), "Email is required.");
        softAssert.assertAll();
    }
    //Preconditon
    //run enterValidData test before run enterExistedEmail test
    @Test
    public void enterEmailAlreadyExists(){
        HomePage homePage=new HomePage(driver);
        homePage.clickOnRegisterLink();
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.clickOnGenderType();
        registerPage.enterTextInFirstNameBox("Mahmoud");
        registerPage.enterTextInLastNameBox("Hosnyyy");
        registerPage.selectDateOfBirthOptions("2","July","2000");
        registerPage.enterTextInEmaillBox("123456789mahmoud6789@gmail.com");
        registerPage.enterTextInCompanyBox("AUCcompany");
        registerPage.clickOnNewsletterCheckBox();
        registerPage.enterTextInPasswordBox("Mahmoud12@");
        registerPage.enterTextInConfirmPasswordBox("Mahmoud12@");
        registerPage.clickOnSubmitButton();
        softAssert.assertEquals(registerPage.getErrorMessageEmailAlreadyExists(), "The specified email already exists");
        softAssert.assertAll();
    }
    @Test
    public void enterWrongFormatEmail(){
        HomePage homePage=new HomePage(driver);
        homePage.clickOnRegisterLink();
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.clickOnGenderType();
        registerPage.enterTextInFirstNameBox("Mahmoud");
        registerPage.enterTextInLastNameBox("Hosnyyy");
        registerPage.selectDateOfBirthOptions("2","July","2000");
        registerPage.enterTextInEmaillBox("123456789mahmoud6789");
        registerPage.enterTextInCompanyBox("AUCcompany");
        registerPage.clickOnNewsletterCheckBox();
        registerPage.enterTextInPasswordBox("Mahmoud12@");
        registerPage.enterTextInConfirmPasswordBox("Mahmoud12@");
        registerPage.clickOnSubmitButton();
        softAssert.assertEquals(registerPage.getErrorMessageWrongEmailFormat(), "Wrong email");
        softAssert.assertAll();
    }
    @Test
    public void enterWrongPasswordRule(){
        HomePage homePage=new HomePage(driver);
        homePage.clickOnRegisterLink();
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.clickOnGenderType();
        registerPage.enterTextInFirstNameBox("Mahmoud");
        registerPage.enterTextInLastNameBox("Hosny");
        registerPage.selectDateOfBirthOptions("2","July","2000");
        registerPage.enterTextInEmaillBox("123456789mahmouddd6789@gmail.com");
        registerPage.enterTextInCompanyBox("AUCcompany");
        registerPage.clickOnNewsletterCheckBox();
        registerPage.enterTextInPasswordBox("Mah");
        registerPage.enterTextInConfirmPasswordBox("Mah");
        registerPage.clickOnSubmitButton();
        softAssert.assertEquals(registerPage.getErrorMessageWrongPasswordRules(), "Password must meet the following rules:must have at least 6 characters");
        softAssert.assertAll();
    }
    @Test
    public void enterConfirmPasswordNotMatch(){
        HomePage homePage=new HomePage(driver);
        homePage.clickOnRegisterLink();
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.clickOnGenderType();
        registerPage.enterTextInFirstNameBox("Mahmoud");
        registerPage.enterTextInLastNameBox("Hosny");
        registerPage.selectDateOfBirthOptions("2","July","2000");
        registerPage.enterTextInEmaillBox("123456789mahmouddd6789@gmail.com");
        registerPage.enterTextInCompanyBox("AUCcompany");
        registerPage.clickOnNewsletterCheckBox();
        registerPage.enterTextInPasswordBox("Mahoud");
        registerPage.enterTextInConfirmPasswordBox("Mahoud12");
        registerPage.clickOnSubmitButton();
        softAssert.assertEquals(registerPage.getErrorMessageConfirmPasswordNotMatch(), "The password and confirmation password do not match.");
        softAssert.assertAll();
    }
    @Test
    public void leaveFirstNameFieldEmpty(){
        HomePage homePage=new HomePage(driver);
        homePage.clickOnRegisterLink();
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.clickOnGenderType();
        registerPage.enterTextInLastNameBox("Hosny");
        registerPage.selectDateOfBirthOptions("2","July","2000");
        registerPage.enterTextInEmaillBox("123456789mahmouddd6789@gmail.com");
        registerPage.enterTextInCompanyBox("AUCcompany");
        registerPage.clickOnNewsletterCheckBox();
        registerPage.enterTextInPasswordBox("Mahmoud12@");
        registerPage.enterTextInConfirmPasswordBox("Mahmoud12@");
        registerPage.clickOnSubmitButton();
        softAssert.assertEquals(registerPage.getErrorFirstNameField(), "First name is required.");
        softAssert.assertAll();
    }
    @Test
    public void leaveLastNameFieldEmpty(){
        HomePage homePage=new HomePage(driver);
        homePage.clickOnRegisterLink();
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.clickOnGenderType();
        registerPage.enterTextInFirstNameBox("Mahmoud");
        registerPage.selectDateOfBirthOptions("2","July","2000");
        registerPage.enterTextInEmaillBox("123456789mahmouddd6789@gmail.com");
        registerPage.enterTextInCompanyBox("AUCcompany");
        registerPage.clickOnNewsletterCheckBox();
        registerPage.enterTextInPasswordBox("Mahmoud12@");
        registerPage.enterTextInConfirmPasswordBox("Mahmoud12@");
        registerPage.clickOnSubmitButton();
        softAssert.assertEquals(registerPage.getErrorLastNameField(), "Last name is required.");
        softAssert.assertAll();
    }
}
