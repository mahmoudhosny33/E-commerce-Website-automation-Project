import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utilities.DriverSetup;

import java.util.Scanner;

public class BaseTest {
    WebDriver driver;
    SoftAssert softAssert;




    @BeforeMethod
    public void beforeTest(){
        softAssert=new SoftAssert();
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        driver=DriverSetup.setUp("chrome");
    }
    @AfterMethod
    public void afterTest(){
        //driver.close();
    }
}
