package testNGDemos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class DataDrivernTestingExcellnTestNG {

    static WebDriver driver;
    DataFromExcel datafile = new DataFromExcel();

    @BeforeClass
    public void launchApplication()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3001/signup");
    }

    @AfterClass
    public void closeBrowser(){
        //driver.close();
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String name,String email, String phone, String password,String address)
    {
        driver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
        driver.findElement(By.id(":r1:")).sendKeys(name);
        driver.findElement(By.id(":r3:")).sendKeys(email);
        driver.findElement(By.id(":r5:")).sendKeys(phone);
        driver.findElement(By.id(":r7:")).sendKeys(password);
        driver.findElement(By.id(":r9:")).sendKeys(password);
        driver.findElement(By.id(":rb:")).sendKeys(address);
        driver.findElement(By.xpath("//button[text()='Register']")).click();
        driver.findElement(By.xpath("//a[text()='Dont have an account? Sign Up']")).click();
    }

    @DataProvider(name="loginData")
    public Object[][] dpMethod() throws IOException {
       return datafile.ExcelData("C:\\Users\\abhijeet.kumar2\\Desktop\\java fundametal\\seleniumExample\\Test_data\\Untitled spreadsheet.xlsx");
        }
    }

