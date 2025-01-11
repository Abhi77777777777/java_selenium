package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunchTest {
    public static void main(String[] args) {
      //  WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3001/signup");

        driver.findElement(By.id(":r1:")).sendKeys("manzoor");
        driver.findElement(By.id(":r3:")).sendKeys("Manz@gmail.com");
        driver.findElement(By.id(":r5:")).sendKeys("9890989089");
        driver.findElement(By.id(":r7:")).sendKeys("Manz@123");
        driver.findElement(By.id(":r9:")).sendKeys("Manz@123");
        driver.findElement(By.id(":rb:")).sendKeys("Bangalore");
        driver.findElement(By.xpath("//button[text()='Register']")).click();



    }
}
