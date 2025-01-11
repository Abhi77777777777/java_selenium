//package testNGDemos;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import java.time.Duration;
//import java.time.temporal.ChronoUnit;
//
//public class MultipleBrowserExecution {
//    WebDriver driver;
//    @Parameters({"myBrowser"})
//    @BeforeClass
//    public void launchApplication(String myBrowser)
//    {
//        if(myBrowser.equalsIgnoreCase("chrome"))
//        {
//            WebDriverManager.chromedriver().setup();
//            driver=new ChromeDriver();
//            driver.manage().window().maximize();
//            driver.get("http://localhost:3001/signin");
//        }else if(myBrowser.equalsIgnoreCase("firefox"))
//        {
//            WebDriverManager.firefoxdriver().setup();
//            driver=new FirefoxDriver();
//            driver.manage().window().maximize();
//            driver.get("http://localhost:3001/signin");
//        }
//        @AfterClass
//        public void closeBrowser(){
//        driver.close();
//    }
//
//        @Test(priority = 1)
//        public void loginTest()
//        {
//            driver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
