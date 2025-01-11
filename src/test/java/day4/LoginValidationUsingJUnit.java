package day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class LoginValidationUsingJUnit {
    static WebDriver driver;
    @BeforeAll
    public static void launchApplication()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3001/signin");

    }
    @AfterAll
    public static void closeBrowser()
    {
        driver.close();
    }

    @Test
    public void login_validation()
    {
        driver.manage().timeouts().implicitlyWait(Duration.of(3, ChronoUnit.SECONDS));
        driver.findElement(By.id("email")).sendKeys("manz@gmail.com");
        driver.findElement(By.id("password")).sendKeys("manz@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }


}

