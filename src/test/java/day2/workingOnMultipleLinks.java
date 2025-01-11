package day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class workingOnMultipleLinks {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("total element present inside a skills is "+links.size());

        for(int i=0;i<links.size();i++)
        {
            String data = links.get(i).getText();
            System.out.println(data);
        }
    }
}
