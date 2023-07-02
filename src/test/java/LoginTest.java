
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("http://shop.pragmatic.bg/admin");
    }

    @Test
    public void testLogin() {
        WebElement username = driver.findElement(By.xpath("//*[@id=\"input-username\"]"));
        username.sendKeys("admin1");
        WebElement password = driver.findElement(By.cssSelector("#input-password"));
        password.sendKeys("parola123!");
        WebElement login = driver.findElement(By.cssSelector("#content > div > div > div > div > div.panel-body > form > div.text-right > button"));
        login.click();

        WebElement loggedUser = driver.findElement(By.cssSelector("#header > div > ul > li.dropdown > a"));
        String messageText = loggedUser.getText();
        Assert.assertEquals(messageText, "AdminQAC22_First AdminQAC22_Last");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
