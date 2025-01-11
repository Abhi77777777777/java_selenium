package day3;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FetchingDataUsingApachePOI {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\abhijeet.kumar2\\Desktop\\java fundametal\\seleniumExample\\Test_data\\RegisterUser.xls");
       FileInputStream fis = new FileInputStream(file);
       HSSFWorkbook workbook = new HSSFWorkbook(fis);
        HSSFSheet sheet = workbook.getSheet("sheet1");//

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
