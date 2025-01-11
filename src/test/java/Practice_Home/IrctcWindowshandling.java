package Practice_Home;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.*;

public class IrctcWindowshandling {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.irctc.co.in/nget/train-search");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

       driver.findElement(By.xpath("//span[@class ='allcircle circletwo']")).click();
        Set<String> windows = driver.getWindowHandles();
       System.out.println(windows);
       Iterator<String> it = windows.iterator();
       String parentWindow = it.next();
       String childWindow = it.next();
        System.out.println(childWindow);
        driver.switchTo().window(childWindow);
       driver.findElement(By.xpath("//i[@class='IRFlight']")).click();
       driver.switchTo().window(parentWindow);
       driver.findElement(By.xpath("//label[text()='RAIL DRISHTI']")).click();

    }
}
