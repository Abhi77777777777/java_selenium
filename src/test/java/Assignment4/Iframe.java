package Assignment4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Iframe {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Frames.html");
        driver.switchTo().frame("singleframe");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Abhijeet");
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("Iframe with in an Iframe")).click();
//        driver.switchTo().frame(1);
//        driver.findElement(By.xpath("//input[@ type = 'text']")).sendKeys("abhijeet kumar");

//        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
//        for(int i=0; i< iframes.size();i++)
//        {
//            System.out.println("Index "+i);
//           WebElement  iframe = iframes.get(i);
//            System.out.println("Source: "+iframe.getAttribute("src"));
//        }


    }
}
