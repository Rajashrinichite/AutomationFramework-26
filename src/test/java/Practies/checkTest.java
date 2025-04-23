package Practies;

import java.io.FileInputStream;

	//FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\AutomationFramework.QCO-SOEAJD-M26\\src\\main\\resources\\TestCase.xlsx");
	//FileInputStream fis = new FileInputStream("path_to_your_excel_file.xlsx");
	import org.apache.poi.ss.usermodel.*;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	import java.io.IOException;

	public class checkTest  {
	    public static void main(String[] args) {
	        try {
	            // Load the Excel file
	            FileInputStream fis = new FileInputStream("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\AutomationFramework.QCO-SOEAJD-M26\\\\src\\\\main\\\\resources\\\\TestCase.xlsx");
	            Workbook workbook = new XSSFWorkbook(fis);

	            // Check if the workbook has any sheets
	            int sheetCount = workbook.getNumberOfSheets();
	            if (sheetCount == 0) {
	                System.out.println("No sheets found in the Excel file.");
	                return;
	            }

	            // Access the first sheet (or change the index if needed)
	            Sheet sh = workbook.getSheetAt(0); // 0 for the first sheet
	            if (sh == null) {
	                System.out.println("Sheet not found!");
	                return;  // Exit if the sheet is null
	            }

	            // Access the first row (index starts at 0)
	            Row row = sh.getRow(0); // 0 for the first row
	            if (row == null) {
	                System.out.println("Row not found!");
	                return;  // Exit if the row is null
	            }

	            // Access the first cell (index starts at 0)
	            Cell cell = row.getCell(0); // 0 for the first cell
	            if (cell != null) {
	                System.out.println("Cell Value: " + cell.toString());
	            } else {
	                System.out.println("Cell is empty or does not exist.");
	            }

	            fis.close(); // Close the file input stream

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

}
