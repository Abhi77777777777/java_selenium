package reportGeneraionday;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class extentReportImplementation {
    public static void main(String[] args) throws IOException {
        ExtentReports extent;
        ExtentTest extentTest;
        extent = new ExtentReports(System.getProperty("user.dir")+("/test-output/BonvoyageReport.html"));
        extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
        extentTest = extent.startTest("Launch Application");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3001/signin");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile,new File(("C:\\Users\\abhijeet.kumar2\\Desktop\\java fundametal\\seleniumExample\\Test_Report\\launch.png")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String pageTitle = driver.getTitle();
        extentTest.log(LogStatus.PASS,pageTitle);
        extent.endTest(extentTest);
        extentTest = extent.startTest("Login Into Application");
        driver.findElement(By.id("email")).sendKeys("manz@gmail.com");
        driver.findElement(By.id("password")).sendKeys("manz@123");
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
        String text = driver.findElement(By.xpath("//h5[text()='Manzoor']")).getText();
        extentTest.log(LogStatus.PASS,text);
        extent.endTest(extentTest);
        extent.flush();
        extent.close();
    }
}
