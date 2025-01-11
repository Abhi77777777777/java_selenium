package Assignment6;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Question3 {
    static WebDriver driver;
    @BeforeClass
    public void launchApplication()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/login");
    }
    @AfterClass
    public void closeBrowser() throws InterruptedException
   {
        try{
            //Assert.assertTrue(driver.findElement(By.linkText("Log out")).isDisplayed());
            String text = driver.findElement(By.linkText("Log out")).getText() ;
            Assert.assertEquals("Log out",text);
            driver.findElement(By.linkText("Log out")).click();
            Thread.sleep(3000);
            driver.close();
        }
        catch(AssertionError e){
            System.out.println("Worng use id or password are given");
       }
        catch (NoSuchElementException e)
        {
            System.out.println("No such element find");
        }


   }

    @Test
    public void Login()
    {

        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys("abhijeet7@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("1234568");
        driver.findElement(By.xpath("//input[@value='Log in']")).click();


    }
}
