package Practice_Home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ICIBankTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.icicibank.com/?utm_source=homepage&utm_medium=stand&utm_campaign=homepage-header-logo");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement login = driver.findElement(By.xpath("//span[text()='Login']"));
        Actions act = new Actions(driver);
        act.moveToElement(login).build().perform();
        driver.findElement( By.xpath("//*[@id=\"login-dropdown\"]/div/div/div[2]/ul/li[1]/a")).click();
        Thread.sleep(5000);


        driver.switchTo().frame("iframetop");
        driver.switchTo().frame("Revamp_Banner_ID");
        WebElement id = driver.findElement(By.xpath("//input[@id=\"DUMMY1\"]"));
        id.click();
        WebElement userid = driver.findElement(By.xpath("//input[@ name=\"AuthenticationFG.USER_PRINCIPAL\"]"));
        userid.sendKeys("abhijeet@gmail");
        driver.findElement(By.xpath("(//input[@type='password'])[4]")).sendKeys("abhijeet123456");
        driver.findElement(By.xpath("//input[@ id = 'VALIDATE_CREDENTIALS1']")).click();

    }

}
