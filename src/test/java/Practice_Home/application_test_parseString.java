package Practice_Home;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class application_test_parseString {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        System.out.println("ram");
        System.out.println("raja");
        System.out.println("radha");
        String text = driver.findElement(By.xpath("//*[@id=\"carousel-example-generic\"]/div/div/div/div/h2/span")).getText().split("your")[1].trim().split(" ]")[0];
        System.out.println(text);



    }


}

//split("your")[1].trim().split(" ")[0];