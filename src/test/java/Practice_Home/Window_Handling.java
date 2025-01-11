package Practice_Home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class Window_Handling {
    public static void main(String[] args) {
        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        Set<String> set = driver.getWindowHandles();
        Iterator<String> it = set.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();

        driver.switchTo().window(childWindow);
        String childText = driver.findElement(By.xpath("//h3")).getText();
        System.out.println(childText);
        driver.switchTo().window(parentWindow);
        String parentText = driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText();
        System.out.println(parentText);

    }


}
