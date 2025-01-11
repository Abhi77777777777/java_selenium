package Assignment7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class TestJust {
    WebDriver driver;
    //driver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
    // DataFromExcel datafile = new DataFromExcel();
    @BeforeClass
    public void launchApplication()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");
    }

    @AfterClass
    public void closeBrowser(){
        // driver.close();
    }

    @Test(priority = 1)
    public void login()
    {
        driver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys("abhijeet7@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@ value='Log in']")).click();

    }

    @Test(priority = 2)
    public void addElementToCart()
    {

        driver.manage().timeouts().implicitlyWait(Duration.of(10,ChronoUnit.SECONDS));
        Actions act = new Actions(driver);
        WebElement comp = driver.findElement((By.xpath("//ul[@class='top-menu']//a[@href='/computers']")));
        //to perform mouse over
        act.moveToElement(comp).build().perform();
        driver.findElement(By.xpath("//ul[@class='top-menu']//a[@href='/desktops']")).click();
        WebElement dropdown = driver.findElement(By.xpath("//select[@ id ='products-orderby']"));
        //selecting element from dropdown
        Select select = new Select(dropdown);
        select.selectByVisibleText("Price: High to Low");
        driver.findElement(By.xpath("//div[@class=\"add-info\"]//input[@value=\"Add to cart\"][1]")).click();
        //Scroll To view using javascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement addToCart = driver.findElement(By.xpath("//input[@id=\"add-to-cart-button-74\"]"));
        js.executeScript("arguments[0].scrollIntoView();",addToCart);
        addToCart.click();
        //come page on default view
        js.executeScript("window.scrollTo(0,0)");
        driver.findElement(By.xpath("//a[@class='ico-cart']/span[@ class='cart-label']")).click();

    }
    @Test(priority = 3)
    public void checkout()
    {
        driver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement checkBox = driver.findElement(By.xpath("//input[@id = 'termsofservice']"));
        js.executeScript("arguments[0].scrollIntoView();",checkBox);
        checkBox.click();
        WebElement checkOut = driver.findElement(By.xpath("//button[@id = 'checkout']"));
        js.executeScript("arguments[0].scrollIntoView();",checkOut);
        checkOut.click();
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='billing-address-select']"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("New Address");



    }
    @Test(priority = 4)
    public void BillingAddress() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
        //First Name
        Thread.sleep(11000);
        // driver.findElement(By.xpath("//input[@class='text-box single-line valid']")).clear();
       // driver.findElement(By.xpath("//input[@class='text-box single-line valid']")).sendKeys("Abhinav");
        //lastname
       // driver.findElement(By.xpath("//input[@id='BillingNewAddress_LastName']")).clear();
       // driver.findElement(By.xpath("//input[@id='BillingNewAddress_LastName']")).sendKeys("Kumar");
        //email
        //driver.findElement(By.xpath("//input[@id='BillingNewAddress_Email']")).clear();
        //driver.findElement(By.xpath("//input[@id='BillingNewAddress_Email']")).sendKeys("abhinav@gmail.com");
        WebElement firstNameField = driver.findElement(By.id("BillingNewAddress_FirstName"));
        firstNameField.sendKeys("John");
        //company
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_Company']")).sendKeys("XGF");
        //country
        WebElement country_dropdown = driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"));
        Select select = new Select(country_dropdown);
        select.selectByValue("1");
        Thread.sleep(5000);
        //city
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("nagpur");
        //adress1
        driver.findElement(By.xpath("//input[@name=\"BillingNewAddress.Address1\"]")).sendKeys("ujjwal nagar");
        //address2
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address2']")).sendKeys("manish nagar");
        //zip/postal code
        driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("911511");
        //phoneNumber
        driver.findElement(By.xpath("//input[@name=\"BillingNewAddress.PhoneNumber\"]")).sendKeys("1234567890");
        //FaxNumber
        driver.findElement(By.xpath("//input[@id=\"BillingNewAddress_FaxNumber\"]")).sendKeys("0987654321");

        driver.findElement(By.xpath("(//input[@class='button-1 new-address-next-step-button'])[1]")).click();
        driver.findElement(By.xpath("(//input[@class='button-1 new-address-next-step-button'])[2]")).click();

    }
    @Test(priority = 5)
    public void remaining_action_Method()
    {
        driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']")).click();
        driver.findElement(By.xpath("//input[@onclick='PaymentMethod.save()']")).click();
        driver.findElement(By.xpath("//input[@onclick='PaymentInfo.save()']")).click();
        WebElement cont = driver.findElement(By.xpath("//input[@onclick='ConfirmOrder.save()']"));
        //scroll to view
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", cont);
        cont.click();

    }
}
