import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon_test {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.in/ref=nav_logo");
        Thread.sleep(20000);

        WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
        searchInput.sendKeys("samsung galaxy s24 ultra");
        searchInput.sendKeys(Keys.RETURN);
        Thread.sleep(20000);

        WebElement firstSearchResult = driver.findElement(By.xpath("//span[text()='Samsung Galaxy S24 Ultra 5G AI Smartphone (Titanium Black, 12GB, 512GB Storage)']"));
       firstSearchResult.click();
       driver.findElement(By.id("add-to-cart-button")).click();

    }


}


//
//public class SearchAndAddToCartTest {
//    public static void main(String[] args) {
//        // Set the path to chromedriver.exe based on your system configuration
//        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver.exe");
//
//        // Create a new instance of the ChromeDriver
//        WebDriver driver = new ChromeDriver();
//
//        // Navigate to the website
//        driver.get("https://example.com"); // Replace with the actual URL
//
//        // Find the search input field and enter the search query
//        WebElement searchInput = driver.findElement(By.name("search"));
//        searchInput.sendKeys("Samsung Galaxy Ultra");
//        searchInput.sendKeys(Keys.RETURN);
//
//        // Wait for search results to load
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".search-results .product")));
//
//        // Find and click on the first search result to add it to the cart
//        WebElement firstSearchResult = driver.findElement(By.cssSelector(".search-results .product"));
//        firstSearchResult.click();
//
//        // Wait for product page to load
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-name")));
//
//        // Get the name of the product on the product page
//        String productNameOnProductPage = driver.findElement(By.cssSelector(".product-name")).getText();
//
//        // Add the product to the cart (assuming there's a button to add it to the cart)
//        WebElement addToCartButton = driver.findElement(By.cssSelector(".add-to-cart-button"));
//        addToCartButton.click();
//
//        // Navigate to the cart page (assuming there's a link/button to navigate to the cart)
//        WebElement cartLink = driver.findElement(By.cssSelector(".cart-link"));
//        cartLink.click();
//
//        // Get the name of the product in the cart
//        String productNameInCart = driver.findElement(By.cssSelector(".cart-product-name")).getText();
//
//        // Assert that the product name in the cart matches the product name on the product page
//        if (productNameOnProductPage.equals(productNameInCart)) {
//            System.out.println("Test Passed: Product name in cart matches product name on product page");
//        } else {
//            System.out.println("Test Failed: Product name in cart does not match product name on product page");
//        }
//
//        // Close the browser
//        driver.quit();
//    }