package day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FetchingDataFromDropDownElement {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.automationtesting.in/Register.html");

        WebElement skills = driver.findElement(By.id("Skills"));
        Select sel = new Select(skills);
        List<WebElement> skillValue=sel.getOptions();

        System.out.println("total element present inside a skills is "+skillValue.size());

        for(int i=0; i<skillValue.size();i++)
        {
            String data = skillValue.get(i).getText();
            System.out.println(data);
        }
    }
}
