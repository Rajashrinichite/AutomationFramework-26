package Practies;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class teastAddProductToCartUsingDDT {


    public static void main(String[] args) {
        try {
            // Load the Excel file
            FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\AutomationFramework.QCO-SOEAJD-M26\\src\\main\\resources\\TestCase.xlsx");
            Workbook workbook = new XSSFWorkbook(fis);

            // Access the first sheet (you can also use getSheet("sheetName") to access by name)
         //  Sheet sh = workbook.getSheetAt(0); // Get the first sheet (index starts at 0)
            Sheet sh = workbook.getSheet("Sheet2"); // Replace "Sheet1" with the actual sheet name.

            // Check if the sheet is null
            if (sh == null) {
                System.out.println("Sheet not found!");
                return;
            }

            // Access the row (ensure the row index exists)
            Row row = sh.getRow(0); // Get the first row (index starts at 0)
            if (row == null) {
                System.out.println("Row not found!");
                return;
            }

            // Access the cell and print its value
            Cell cell = row.getCell(0); // Get the first cell
            if (cell != null) {
                System.out.println("Cell Value: " + cell.toString());
            } else {
                System.out.println("Cell is empty or does not exist.");
            }

            fis.close(); // Close the file stream
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
