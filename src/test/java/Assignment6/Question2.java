package Assignment6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Question2 {
    static WebDriver driver;
    @BeforeClass
    public void launchApplication()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/register");
    }
    @AfterClass
    public void closeBrowser()
    {
        driver.close();
    }
    @Test(dataProvider = "loginData")
    public void loginTest(String email,String password,String firstName,String Lastname) throws InterruptedException {
        WebElement radioButton = driver.findElement(By.id("gender-male"));
        radioButton.click();
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(Lastname);
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
        Thread.sleep(3000);
        driver.findElement(By.id("register-button")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Log out")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Register")).click();

    }
    @DataProvider(name = "loginData")
    public Object[][] dpMethod()
    {
        return new Object[][]{
                { "abhinav@2gmail.com","123456","abhinav2","kumar"},
                {"ajit7@gmail.com","123456","ajit","dash"}
        };
    }

}
