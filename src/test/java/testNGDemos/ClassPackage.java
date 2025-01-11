package testNGDemos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class ClassPackage {
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
       // driver.close();
    }

    @Test(priority = 1)
    public void packageTest()
    {
        driver.manage().timeouts().implicitlyWait(Duration.of(10, ChronoUnit.SECONDS));
        driver.findElement(By.linkText("Packages")).click();
        driver.findElement(By.xpath("//a[@href='/packages/P101']")).click();


    }

}
