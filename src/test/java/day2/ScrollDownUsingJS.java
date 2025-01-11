package day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ScrollDownUsingJS {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/login");
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('Email').value='manz@gmail.com'");
        js.executeScript("document.getElementById('Password').value='manz@123'");

        WebElement logInButton=driver.findElement(By.xpath("//input[@value='Log in']"));
        js.executeScript("arguments[0].click()",logInButton);


        //driver.close();

    }
}
