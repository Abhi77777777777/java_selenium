package Practice_Home;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ExcelHandle {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\abhijeet.kumar2\\Desktop\\java fundametal\\seleniumExample\\Test_data\\test1.xlsx");
        //fileInputStream is class of java which has power to read any file
        //XSSFWorkbook accept fileInputStream argument
        XSSFWorkbook workbook = new XSSFWorkbook(fis);//get the hold of excel

        int sheets = workbook.getNumberOfSheets();
        for(int i=0;i<sheets;i++)
        {
            if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
            {
                XSSFSheet sheet = workbook.getSheetAt(i);//get the hold of sheet

                Iterator<Row> rows = sheet.iterator();//Sheet is collection of rows
                Row firstrow = rows.next();
                Iterator<Cell> ce = firstrow.cellIterator();
                while(ce.hasNext())
                {
                    Cell value = ce.next();

                }



            }
        }

    }

}
