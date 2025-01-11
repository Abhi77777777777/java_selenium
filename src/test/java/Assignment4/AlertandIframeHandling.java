package Assignment4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AlertandIframeHandling {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in//Alerts.html");
        driver.findElement(By.xpath("//button[contains(text(),'alert box')]")).click();
        Alert alert = driver.switchTo().alert();
        //Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        alert.accept();
        driver.findElement(By.linkText("Alert with OK & Cancel")).click();
        driver.findElement(By.xpath("//button[text()='click the button to display a confirm box ']")).click();
        Thread.sleep(3000);
        alert.dismiss();

        driver.findElement(By.linkText("Alert with Textbox")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        alert.sendKeys("Abhijeet");
        Thread.sleep(700);
        alert.accept();

        driver.findElement(By.linkText("Alert with Textbox")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        System.out.println(alert.getText());






    }
}
