package day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class ExceptionHandlinginSelenium {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://localhost:3001/signin");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.of(10, ChronoUnit.SECONDS));
        driver.findElement(By.id("email")).sendKeys("anz@gmail.com");
        driver.findElement(By.id("password")).sendKeys("manz@123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        try{
            driver.findElement(By.xpath("//h5[text()='Manzoor']")).isDisplayed();
            System.out.println("Successful login");
        }
        catch (NoSuchElementException e)
        {
            System.out.println("unsuccessful Login");
        }
    }
}
