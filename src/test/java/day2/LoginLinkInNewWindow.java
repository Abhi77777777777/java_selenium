package day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;

public class LoginLinkInNewWindow {
    public static void main(String[] args) throws InterruptedException, AWTException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/login");

        WebElement logIn = driver.findElement(By.linkText("Log in"));
        Actions act = new Actions(driver);
        act.moveToElement(logIn).contextClick().perform();

        Robot bot = new Robot();
        bot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(3000);
        bot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(3000);
        bot.keyPress(KeyEvent.VK_ENTER);
    }
}
