package reportGeneraionday;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class log4jImplementation {
    public static void main(String[] args) {
        Logger log = Logger.getLogger("Test Output");
        log.info("launching browser");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3001/signin");
        log.info("application launched and starting login operation");
        driver.findElement(By.id("email")).sendKeys("manz@gmail.com");
        driver.findElement(By.id("password")).sendKeys("manz@123");
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
        log.warn("login operation is sucessful");


    }
}
