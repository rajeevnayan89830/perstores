package api.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilitiesXcel {
    public FileInputStream fi;
    public FileOutputStream fo;
    public XSSFWorkbook wb;
    public XSSFSheet sheet;
    public XSSFRow row;
    public XSSFCell cell;
    public CellStyle style;
    String path;

    public UtilitiesXcel(String path) {
        this.path = path;
    }

    public int getRowCount(String sheetName) throws IOException {
        int rowCount = 0;
        try (FileInputStream fi = new FileInputStream(path);
             XSSFWorkbook wb = new XSSFWorkbook(fi)) {
            sheet = wb.getSheet(sheetName);
            rowCount = sheet.getLastRowNum();
        }
        return rowCount;
    }

    public int getCellCount(String sheetName, int rowNum) throws IOException {
        int cellCount = 0;
        try (FileInputStream fi = new FileInputStream(path);
             XSSFWorkbook wb = new XSSFWorkbook(fi)) {
            sheet = wb.getSheet(sheetName);
            row = sheet.getRow(rowNum);
            cellCount = row.getLastCellNum();
        }
        return cellCount;
    }

    public String getCellData(String sheetName, int rowNum, int cellNum) throws IOException {
        String data;
        try (FileInputStream fi = new FileInputStream(path);
             XSSFWorkbook wb = new XSSFWorkbook(fi)) {
            sheet = wb.getSheet(sheetName);
            row = sheet.getRow(rowNum);
            if (row == null) {
                return "";
            }
            cell = row.getCell(cellNum);
            DataFormatter formatter = new DataFormatter();
            data = (cell != null) ? formatter.formatCellValue(cell) : "";
        }
        return data;
    }
}
