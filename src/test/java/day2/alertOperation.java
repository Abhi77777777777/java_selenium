package day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class alertOperation {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in//Alerts.html");
        driver.findElement(By.xpath("//button[contains(text(),'alert box')]")).click();
        Alert alert= driver.switchTo().alert();
        Thread.sleep(3000);
        alert.accept();

        driver.findElement(By.partialLinkText("Alert with OK & Cancel")).click();
        driver.findElement(By.xpath("//button [contains(@class,'btn btn-primary')]")).click();
        Thread.sleep(3000);
        alert.dismiss();
        Thread.sleep(3000);

       driver.findElement(By.partialLinkText("Alert with Textbox")).click();
       driver.findElement(By.xpath("//button[contains(@class,'btn btn-info')]")).click();
       String alertMessage= alert.getText();
        System.out.println(alertMessage);
        alert.sendKeys("abhijeet");
        Thread.sleep(3000);
        alert.accept();
       







    }
}
