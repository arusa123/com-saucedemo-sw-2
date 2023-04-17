package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.time.Duration;

public class LoginTest extends BaseTest {
    //browser setup
    @Before
    public void setUp() {
        openBrowser("Chrome");
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //implicitly wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //enter username in the username field
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //password in the password field
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //finding the click button element
        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();

        //expected elemement text
        String expectedElement = "Products";
        //actual element
        String actualElement = driver.findElement(By.xpath("//span[@class='title']")).getText();

        Assert.assertEquals("Products", expectedElement, actualElement);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //enter username in the username field
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //password in the password field
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //finding the click button element
        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();

        //expected elemement text
        String expectedElement = "Products";
        //actual element
        String actualElement = driver.findElement(By.xpath("//span[@class='title']")).getText();

        Assert.assertEquals("Products", expectedElement, actualElement);
        //expected list size
        int expectedListSize = 6;
        //actual list size
        int actualListSize = driver.findElements(By.xpath("//div[@class='inventory_list']/div")).size();
        Assert.assertEquals("size of the product list", expectedListSize, actualListSize);

    }

    @After
    public void closeBrowser23() {
        closeBrowser();


    }

}
