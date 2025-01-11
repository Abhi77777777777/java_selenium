package testNGDemos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class LoginWithMultipleValuesUsingDataProvider {

    static WebDriver driver;
    @BeforeClass
    public void launchApplication()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3001/signin");
    }

    @AfterClass
    public void closeBrowser(){
        driver.close();
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String email, String password)
    {
        driver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
        driver.findElement(By.xpath("//button[text()='Login / SignUp']")).click();
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
        driver.findElement(By.xpath("//button[text()='Logout']")).click();
    }

    @DataProvider(name="loginData")
    public Object[][] dpMethod(){
        return new Object[][]{
                {"manz@gmail.com", "manz@123"},
                {"manzoor@gmail.com", "manz@123"}
        };
    }

}

