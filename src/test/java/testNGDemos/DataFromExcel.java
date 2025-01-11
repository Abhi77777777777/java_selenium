package testNGDemos;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DataFromExcel {
    public Object[][] ExcelData(String sheetName)throws IOException{
        File file = new File(sheetName);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook Workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = Workbook.getSheetAt(0);
        int rowCount=sheet.getPhysicalNumberOfRows();
        int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
       // Object[][] data = new Object[rowCount-1][columnCount];
        Object[][] data = new Object[2][5];

        for(int i=1;i<3;i++)
        {
            for(int j=0;j<5;j++)
            {
                DataFormatter dat = new DataFormatter();
                data[i-1][j] =dat.formatCellValue(sheet.getRow(i).getCell(j));
            }
        }

       return data;
    }
}
