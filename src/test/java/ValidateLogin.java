import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class ValidateLogin extends BaseTest {





    @Test
    public void testWelconeMessage() {

        HomePage homePage=new HomePage(driver);
        homePage.clickOnLoginLink();
        LoginPage loginPage=new LoginPage(driver);
        softAssert.assertEquals(loginPage.getWelocmeMessage(),"Welcome, Please Sign In!");
        softAssert.assertAll();
    }

    @Test
    public void enterValidData() {
        HomePage homePage=new HomePage(driver);
        homePage.clickOnLoginLink();
        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterEmailAndPassword("123456789mahmouddd6789@gmail.com","Mahmoud12@");
        loginPage.checkRememberMe();
        loginPage.clickOnSubmitButton();
        softAssert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        softAssert.assertAll();
    }
    @Test
    public void leaveEmailFieldEmpty() {
        HomePage homePage=new HomePage(driver);
        homePage.clickOnLoginLink();
        LoginPage loginPage=new LoginPage(driver);
        loginPage.clickOnSubmitButton();
        softAssert.assertEquals(loginPage.getErrorMessageEmailEmpty(),"Please enter your email");
        softAssert.assertAll();
    }
    @Test
    public void enterUnRegisteredEmail() {
        HomePage homePage=new HomePage(driver);
        homePage.clickOnLoginLink();
        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterEmailAndPassword("mahmoud@gmail.com","Mahmoud12@");
        loginPage.clickOnSubmitButton();
        softAssert.assertEquals(loginPage.getErrorMessageOfUnRegisteredEmail(),"No customer account found");
        softAssert.assertAll();
    }
    @Test
    public void enterWrongEmailFormat() {
        HomePage homePage=new HomePage(driver);
        homePage.clickOnLoginLink();
        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterEmailAndPassword("123456789mahmoud678","Mahmoud12@");
        loginPage.clickOnSubmitButton();
        softAssert.assertEquals(loginPage.getErrorMessageOfWrongEmail(),"Wrong email");
        softAssert.assertAll();
    }
    @Test
    public void leaveEmptyPasswordOrWrongPassword() {
        HomePage homePage=new HomePage(driver);
        homePage.clickOnLoginLink();
        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterEmailAndPassword("123456789mahmoud6789@gmail.com","Mahmoud12");
        loginPage.clickOnSubmitButton();
        softAssert.assertEquals(loginPage.getErrorMessageOfWrongPasswordOrEmpty(),"The credentials provided are incorrect");
        softAssert.assertAll();
    }
    @Test
    public void clickOnForgetPassword() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnLoginLink();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPassword("123456789mahmoud6789@gmail.com", " ");
        loginPage.clickOnForgetPassword();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/passwordrecovery");
    }
    }
