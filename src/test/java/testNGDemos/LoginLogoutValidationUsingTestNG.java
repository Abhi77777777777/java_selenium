package testNGDemos;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static java.awt.SystemColor.text;

public class LoginLogoutValidationUsingTestNG {
    WebDriver driver;
    @BeforeClass
    public void launchApplication()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3001/signin");
    }

    @AfterClass
    public void closeApplication()
    {
        driver.close();
    }

    @Test(priority = 1)
    public void loginTestg()
    {
        driver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
        driver.findElement(By.id("email")).sendKeys("manz@gmail.com");
        driver.findElement(By.id("password")).sendKeys("manz@123");
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();

    }

    @Test(priority = 2)
    public void LogoutTest()
    {
        driver.manage().timeouts().implicitlyWait(Duration.of(5,ChronoUnit.SECONDS));
        driver.findElement(By.xpath("//button[text()='Logout']")).click();
        String text = driver.findElement(By.xpath("//button[text()='Login / SignUp']")).getText();
        Assert.assertEquals(text,"LOGIN / SIGNUP");

    }
}
