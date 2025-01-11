package day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.naming.ldap.Control;
import java.util.ArrayList;

public class WindowHandling {
    private static final Log log = LogFactory.getLog(WindowHandling.class);

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/login");
        WebElement logInLink = driver.findElement(By.linkText("Log in"));
        String parentWindowId = driver.getWindowHandle();
        System.out.println("parent window id");

        System.out.println(parentWindowId);
        logInLink.sendKeys(Keys.CONTROL,Keys.RETURN);

        ArrayList<String> windowDetails = new ArrayList<>(driver.getWindowHandles());
        System.out.println("all window ids");
        System.out.println(windowDetails);

        driver.switchTo().window(windowDetails.get(1));
        driver.findElement(By.id("Email")).sendKeys("manz@gmail.com");
        Thread.sleep(3000);
       // driver.quit();





    }
}
