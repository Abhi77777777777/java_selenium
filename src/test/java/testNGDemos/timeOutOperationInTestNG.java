package testNGDemos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class timeOutOperationInTestNG {
    static WebDriver driver;
    @BeforeClass
    public void Launchapplication(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3001/signin");
    }

    @AfterClass
    public void Closeapplication(){
        driver.close();
    }

    @Test(timeOut = 400)
    public void loginTest(){
        driver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
        driver.findElement(By.id("email")).sendKeys("manz@gmail.com");
        driver.findElement(By.id("password")).sendKeys("manz@123");
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
        String logintext = driver.findElement(By.xpath("//h5[text()='Manzoor']")).getText();
        Assert.assertEquals(logintext,"Hey, Manzoor");
    }

}
