import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class ValidateHomeActions extends BaseTest{
    @Test
    public void addItemToCart() {
        HomePage homePage=new HomePage(driver);
        homePage.clickOnBokksListLink();
        WebElement element=driver.findElement(By.xpath("(//button[text()='Add to cart'])[1]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
        homePage.clickOnAddToCartBtn();
        softAssert.assertEquals(homePage.getMessageOfItemIsAddedToMyCart(),"The product has been added to your shopping cart");
        softAssert.assertAll();
    }
}
