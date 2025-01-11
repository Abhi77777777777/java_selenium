package day3;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FatchingXLSXData {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\abhijeet.kumar2\\Desktop\\java fundametal\\seleniumExample\\Test_data\\test1.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        String cellData = sheet.getRow(1).getCell(1).getStringCellValue();
        System.out.println(cellData);

        int rowCount = sheet.getPhysicalNumberOfRows();
        for(int i=0; i<rowCount;i++)
        {
            int colCount = sheet.getRow(i).getPhysicalNumberOfCells();
            for(int j=0; j<colCount;j++)
            {
                cellData=sheet.getRow(i).getCell(j).getStringCellValue();
                System.out.println(cellData);
            }
        }
    }
}
