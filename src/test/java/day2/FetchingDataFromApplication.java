package day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchingDataFromApplication {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com");
        boolean linkData = driver.findElement(By.linkText("Log in")).isDisplayed();
        System.out.println("Login link is present :"+linkData);

        String linkText = driver.findElement(By.linkText("Log in")).getText();
        System.out.println("Text present on the Log is "+linkText);

        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys("manzoor@gmail.com");
        String emailValue = driver.findElement(By.id("Email")).getAttribute("value");
        System.out.println("value stored inside email texbox is "+emailValue);

    }
}
