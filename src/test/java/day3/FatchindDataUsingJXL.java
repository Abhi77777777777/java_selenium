package day3;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FatchindDataUsingJXL {
    public static void main(String[] args) throws IOException, BiffException {
        File file = new File("C:\\Users\\abhijeet.kumar2\\Desktop\\java fundametal\\seleniumExample\\Test_data\\RegisterUser.xls");
        FileInputStream fis = new FileInputStream(file);
        Workbook wb = Workbook.getWorkbook(fis);
        Sheet sheet = wb.getSheet(0);

       String cellData = sheet.getCell(1,1).getContents();
        //String cellData = sheet.getCell(1,1).getContents();
        System.out.println(cellData);

        int rowCount = sheet.getRows();
        int columnCount =sheet.getColumns();;

        for(int i=1; i<rowCount;i++)
        {
            for(int j=0;j<columnCount;j++)
            {
                cellData= sheet.getCell(j,i).getContents();
                System.out.println(cellData);
            }
        }
    }
}
