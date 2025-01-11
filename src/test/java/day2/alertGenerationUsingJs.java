package day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class alertGenerationUsingJs {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/login");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("alert('welcome to Globallogic')");
       // js.executeScript("confirm('Welcome to Globallogic')");
        js.executeScript("prompt('Welcome to Globallogic')");
    }
}
