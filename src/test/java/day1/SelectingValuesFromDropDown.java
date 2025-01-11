package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SelectingValuesFromDropDown {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");

        Actions act = new Actions(driver);
        WebElement electronic=driver.findElement(By.xpath("//ul[@class='top-menu']//a[contains(text(),'Electronics')]"));
        act.moveToElement(electronic).build().perform();
        WebElement cellPhone=driver.findElement(By.partialLinkText("Cell phones"));
        act.moveToElement(cellPhone).click().perform();

        //webElement sortBy = driver.findElement(By.id("prodcts-orderby"));


    }
}
