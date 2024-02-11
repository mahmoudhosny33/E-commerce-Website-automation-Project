import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class DataProviderTest extends BaseTest{
    @DataProvider(name = "loginWithInValidData")
    public Object[][] providerLoginWithInvalidData(){
        return new Object[][]{
                {"123456789mahmoud67891@gmail.com","Mahmoud12@"},
                {"","Mahmoud12@"},
                {"123456789mahmoud67891@gmail.com",""},
                {"",""},
        };
    }
    @DataProvider(name = "loginWithValidData")
    public Object[][] providerLoginWithValidData(){
        return new Object[][]{
                {"123456789mahmoud67891@gmail.com","Mahmoud12@"},
        };
    }
    @DataProvider(name = "registerWithValidData")
    public Object[][] providerRegisterWithValidData(){

        return new Object[][]{
                {"Mahmoud","Hosnyyy","2","July","2000","xyz@gmail.com","AUCcompany","Mahmoud12@","Mahmoud12@"},
        };
    }
    @DataProvider(name = "registerWithInValidData")
    public Object[][] providerRegisterWithInValidData(){

        return new Object[][]{
                {"","Hosnyyy","2","July","2000","mahmoud@gmail.com","AUCcompany","Mahmoud12@","Mahmoud12@"},//leave first name empty
                {"Mahmoud","","2","July","2000","mahmoud@gmail.com","AUCcompany","Mahmoud12@","Mahmoud12@"},//leave last name empty
                {"Mahmoud","Hosnyyy","2","July","2000","xyz@gmail.com","AUCcompany","Mahmoud12@","Mahmoud12@"},//enter existing email
                {"Mahmoud","Hosnyyy","2","July","2000","","AUCcompany","Mahmoud12@","Mahmoud12@"},//leave email empty
                {"Mahmoud","Hosnyyy","2","July","2000","mahmoud@gmail.com","","Mahmoud12@","Mahmoud12@"},//leave company name empty
                {"Mahmoud","Hosnyyy","2","July","2000","mahmoud@gmail.com","AUCcompany","","Mahmoud12@"},//leave password empty
                {"Mahmoud","Hosnyyy","2","July","2000","mahmoud@gmail.com","AUCcompany","Mahmoud12@",""},//leave confirm password empty
                {"Mahmoud","Hosnyyy","2","July","2000","mahmoud@gmail.com","AUCcompany","Mahmoud12@","smdnsnsx"},//enter different confirm password


        };
    }
    @Test(dataProvider = "registerWithValidData")
    public void registerationSuccessfullyTest(String firstN,String lastN,String day,String month,String year,
                                         String email,String companyN,String password,String confirmPass){
        HomePage homePage=new HomePage(driver);
        homePage.clickOnRegisterLink();
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.clickOnGenderType();
        registerPage.enterTextInFirstNameBox(firstN);
        registerPage.enterTextInLastNameBox(lastN);
        registerPage.selectDateOfBirthOptions(day,month,year);
        registerPage.enterTextInEmaillBox(email);
        registerPage.enterTextInCompanyBox(companyN);
        registerPage.clickOnNewsletterCheckBox();
        registerPage.enterTextInPasswordBox(password);
        registerPage.enterTextInConfirmPasswordBox(confirmPass);
        registerPage.clickOnSubmitButton();
        softAssert.assertEquals(registerPage.getRegisterationCompletedMessage(), "Your registration completed");
        softAssert.assertAll();

    }
    @Test(dataProvider = "registerWithInValidData")
    public void registerationWrongTest(String firstN,String lastN,String day,String month,String year,
                                         String email,String companyN,String password,String confirmPass){
        HomePage homePage=new HomePage(driver);
        homePage.clickOnRegisterLink();
        RegisterPage registerPage=new RegisterPage(driver);
        registerPage.clickOnGenderType();
        registerPage.enterTextInFirstNameBox(firstN);
        registerPage.enterTextInLastNameBox(lastN);
        registerPage.selectDateOfBirthOptions(day,month,year);
        registerPage.enterTextInEmaillBox(email);
        registerPage.enterTextInCompanyBox(companyN);
        registerPage.clickOnNewsletterCheckBox();
        registerPage.enterTextInPasswordBox(password);
        registerPage.enterTextInConfirmPasswordBox(confirmPass);
        registerPage.clickOnSubmitButton();
        softAssert.assertNotEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        softAssert.assertAll();
    }
    @Test(dataProvider = "loginWithValidData")
    public void loginSuccessfullyTest(String email,String password) {
        HomePage homePage=new HomePage(driver);

        homePage.clickOnLoginLink();
        LoginPage loginPage=new LoginPage(driver);
        //  wait.until(ExpectedConditions.visibilityOfElementLocated(emailTextBox));
        loginPage.enterEmailAndPassword(email,password);
        //   wait.until(ExpectedConditions.elementToBeClickable(loginPage.submitButton));
        loginPage.clickOnSubmitButton();
        //   wait.until(ExpectedConditions.elementToBeClickable(homePage.myAccountButton));
        softAssert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        softAssert.assertAll();
    }
    @Test(dataProvider = "loginWithInValidData")
    public void loginWithInValidDataTest(String email,String password) {
        HomePage homePage=new HomePage(driver);

        homePage.clickOnLoginLink();
        LoginPage loginPage=new LoginPage(driver);
        //  wait.until(ExpectedConditions.visibilityOfElementLocated(emailTextBox));
        loginPage.enterEmailAndPassword(email,password);
        //   wait.until(ExpectedConditions.elementToBeClickable(loginPage.submitButton));
        loginPage.clickOnSubmitButton();
        //   wait.until(ExpectedConditions.elementToBeClickable(homePage.myAccountButton));
        softAssert.assertNotEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        softAssert.assertAll();
    }
}
