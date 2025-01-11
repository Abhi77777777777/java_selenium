package Assignment6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Question1 {
    WebDriver driver;
    @BeforeClass
    public void launchAnApplication()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3001/signin");
    }

    @Test
    public void Login()
    {
        driver.manage().timeouts().implicitlyWait(Duration.of(3, ChronoUnit.SECONDS));
        driver.findElement(By.id("email")).sendKeys("manz@gmail.com");
        driver.findElement(By.id("password")).sendKeys("manz@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    @AfterClass
    public void closeApplication()
    {
       driver.close();
    }


}
