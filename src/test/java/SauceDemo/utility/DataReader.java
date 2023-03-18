package SauceDemo.utility;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DataReader {
    File file;
    FileInputStream inputStream;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;

    public DataReader(String filePath) throws IOException {
        file = new File(filePath);
        try {
            inputStream = new FileInputStream(file);
            workbook = new XSSFWorkbook(inputStream);
        } catch (Exception e) {
            System.out.println("Unable to read excel " + e.getMessage());
        }
    }

    public String getStringData(String sheetName, int rowNumber, int cellNumber) {
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNumber);
        cell = row.getCell(cellNumber);
        return cell.getStringCellValue();
    }

    public int getIntegerData(String sheetName, int rowNumber, int cellNumber) {
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNumber);
        cell = row.getCell(cellNumber);
        return (int) cell.getNumericCellValue();
    }

    public int getLastRow(String sheet) {
        this.sheet = workbook.getSheet(sheet);
        return this.sheet.getLastRowNum();
    }



}
