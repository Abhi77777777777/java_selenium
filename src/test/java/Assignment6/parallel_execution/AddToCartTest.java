package Assignment6.parallel_execution;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddToCartTest {
    WebDriver driver;
    @BeforeClass
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/login");
    }
    @AfterClass
    public void AfterClass()
    {
        //driver.close();
    }
    @Test
    public void addToCartTest() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys("abhijeet7@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@value='Log in']")).click();

        Thread.sleep(2000);
       WebElement book = driver.findElement(By.xpath("//input[@ value='Add to cart']"));
        js.executeScript("arguments[0].scrollIntoView();",book);
        book.click();
        Thread.sleep(3000);
       WebElement name = driver.findElement(By.xpath("//input[@ name='giftcard_2.RecipientName' ]"));
        js.executeScript("arguments[0].scrollIntoView();",name);
        name.sendKeys("Abhijeet Kumar");
        WebElement email =driver.findElement(By.xpath("//input[@ name='giftcard_2.RecipientEmail' ]"));
        js.executeScript("arguments[0].scrollIntoView();",email);
        email.sendKeys("abhijeet7@gmail.com");
        driver.findElement(By.id("add-to-cart-button-2")).click();
    }

}
