package Utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import Utilities.ApachePOI;

public class Read_Data {


        XSSFWorkbook workbook;
        XSSFSheet sheet;
        String location;
        int SheetNo;
        write_excel_data write_excel;
        public Read_Data(String excelPath)
        {
            location = "C:\\Users\\Reshoketswe\\Documents\\Data For UI Assessment";
            try {
                File src = new File(excelPath);
                FileInputStream fis = new FileInputStream(src);
                workbook = new XSSFWorkbook(fis);
                write_excel = new write_excel_data(location);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


    }
