import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class ParameterizedTest extends BaseTest {
    @Parameters({"email","password"})
    @Test
    public void loginTest(String email,String password) {
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
}
