//package day3;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.apache.poi.ss.usermodel.DataFormat;
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.time.Duration;
//import java.time.temporal.ChronoUnit;
//
//public class RegisterMultipleUserUsingExcel {
//    public static void main(String[] args) throws IOException {
//        File file = new File("C:\\Users\\abhijeet.kumar2\\Desktop\\java fundametal\\seleniumExample\\Test_data\\test2.xlsx");
//        FileInputStream fis = new FileInputStream(file);
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        XSSFSheet sheet = workbook.getSheetAt(0);
//        int rowCount = sheet.getPhysicalNumberOfRows();
//
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("http://localhost:3001/signin");
//        driver.manage().window().maximize();
//       // driver.manage().timeouts().implicitlyWait(Duration.of(10, ChronoUnit.SECONDS));
//
//        for(int i=1;i<=rowCount;i++)
//        {
//            DataFormatter data = new DataFormatter();
//
//            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Dont have an account? Sign Up")));
//
//            driver.findElement(By.linkText("Dont have an account? Sign Up")).click();
//            String name = sheet.getRow(i).getCell(0).getStringCellValue();
//            String email = sheet.getRow(i).getCell(1).getStringCellValue();
//            String phone = data.formatCellValue(sheet.getRow(i).getCell(2));
//            String password = sheet.getRow(i).getCell(3).getStringCellValue();
//            String address = sheet.getRow(i).getCell(4).getStringCellValue();
//
//            driver.findElement(By.id(":r1:")).sendKeys(name);
//            driver.findElement(By.id(":r3:")).sendKeys(email);
//            driver.findElement(By.id(":r5:")).sendKeys(phone);
//            driver.findElement(By.id(":r7:")).sendKeys(password);
//            driver.findElement(By.id(":r9:")).sendKeys(password);
//            driver.findElement(By.id(":rb:")).sendKeys(address);
//            driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
//
//
//        }
//
//    }
//}
