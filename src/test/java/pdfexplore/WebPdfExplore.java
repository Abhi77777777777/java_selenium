package pdfexplore;

import de.redsix.pdfcompare.PdfComparator;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.HashMap;

public class WebPdfExplore {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        HashMap<String, Object> prefs = new HashMap<>();

        prefs.put("plugins.always_open_pdf_externally",true);
        prefs.put("download.default_directory","C:\\Users\\abhijeet.kumar2\\Desktop\\filetestdata");

        options.setExperimentalOption("prefs",prefs);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://s29.q4cdn.com/175625835/files/doc_downloads/test.pdf");


       // new PdfComparator("C:\\Users\\abhijeet.kumar2\\Desktop\\filetestdata\\abhijeettest.pdf", "C:\\Users\\abhijeet.kumar2\\Desktop\\filetestdata\\test.pdf").compare().writeTo("C:\\Users\\abhijeet.kumar2\\Desktop\\filetestdata\\result\\Result");
        new PdfComparator("C:\\Users\\abhijeet.kumar2\\Desktop\\filetestdata\\abhijeettest.pdf", "C:\\Users\\abhijeet.kumar2\\Desktop\\filetestdata\\latest.pdf").compare().writeTo("C:\\Users\\abhijeet.kumar2\\Desktop\\filetestdata\\result\\Result");
        System.out.println("Happy Abhijeet");


    }
}
//"C:\Users\abhijeet.kumar2\Desktop\filetestdata\latest.pdf"