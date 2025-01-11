package Assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScripExecutorexample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/login");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement passWordTexbox = driver.findElement(By.id("Password"));
        js.executeScript("arguments[0].scrollIntoView();",passWordTexbox);
        passWordTexbox.sendKeys("12345");

        //Generating alert using javaScriptexecutor

        js.executeScript("alert('welcome to Globallogic')");
        // js.executeScript("confirm('Welcome to Globallogic')");
        //js.executeScript("prompt('Welcome to Globallogic')");



    }

}
