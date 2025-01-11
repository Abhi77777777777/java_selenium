package day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class pretice1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
       // driver.manage().window().maximize();

        driver.get("https://demo.automationtesting.in/Frames.html");
        JavascriptExecutor js= (JavascriptExecutor)driver;
        WebElement logInButton=driver.findElement(By.xpath("//div/input"));
        js.executeScript("arguments[0].click()",logInButton);


        driver.findElement(By.xpath("//div/input")).sendKeys("Abhijeet");
    }
}
