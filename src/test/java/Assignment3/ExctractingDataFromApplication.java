package Assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ExctractingDataFromApplication {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys("abhijeet7@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
        String url = driver.getCurrentUrl();
        System.out.println(url);

        //print the value from dropdown

        WebElement computer = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/a"));

        Actions act = new Actions(driver);
        act.moveToElement(computer).build().perform();
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/ul/li[1]/a")).click();

        WebElement sortBy = driver.findElement(By.id("products-orderby"));
        Select sel = new Select(sortBy);

        List<WebElement> sort = sel.getOptions();

        System.out.println("total element present inside a Desktops drop dwon is " + sort.size());

        for (int i = 0; i < sort.size(); i++) {
            String data = sort.get(i).getText();
            System.out.println(data);
        }
        System.out.println();

        //total no of link on login page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("total element present inside Desktops dropdown is " + links.size());

        for (int i = 0; i < links.size(); i++) {
            String data = links.get(i).getText();
            System.out.println(data);
        }

    }
}




