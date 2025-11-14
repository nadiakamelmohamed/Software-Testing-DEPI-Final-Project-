package tests;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public static String[] readTestData(String filePath) {
        
        String[] data = new String[3];

        try {
            FileInputStream excelFile = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);
            
            Row row = sheet.getRow(0);
            
            Cell cell1 = row.getCell(0);
            data[0] = cell1.getStringCellValue();
            
            Cell cell2 = row.getCell(1);
            data[1] = cell2.getStringCellValue();
            
            Cell cell3 = row.getCell(2);
            
            // الكود المصحح للتعامل مع الخلايا الرقمية
            if (cell3.getCellType() == CellType.NUMERIC) { // تم التغيير هنا
                data[2] = String.valueOf((int)cell3.getNumericCellValue());
            } else {
                data[2] = cell3.getStringCellValue();
            }
            
            workbook.close();

        } catch (Exception e) {
            System.out.println("An error occurred while reading the Excel file.");
            e.printStackTrace();
        }
        
        return data;
    }
}
