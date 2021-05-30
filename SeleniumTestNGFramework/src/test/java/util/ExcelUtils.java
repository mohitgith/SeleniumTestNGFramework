package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static Logger log = LogManager.getLogger(ExcelUtils.class);
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	String excelPath = "./excels/";
	
	public ExcelUtils(String excelFile , String sheetName) {
		try {
			log.info("Reading the excel file : " + excelPath + excelFile);
			workbook = new XSSFWorkbook(excelPath + excelFile);
			log.info("Sheet Name : " + sheetName);
			sheet = workbook.getSheet(sheetName);
		} catch (Exception e) {
			log.error(e.getMessage());
			log.error(e.getCause());
			log.error("Object creation failed due to ", e);
		}
	}

	public int getRowCount() {
		int rowCount = 0;
		try {
			rowCount = sheet.getPhysicalNumberOfRows() - 1;
			log.info("Row Count excluding header : " + rowCount);
		} catch (Exception e) {
			log.error(e.getMessage());
			log.error(e.getCause());
			log.error("getRowCount() failed due to ", e);
		}
		return rowCount;
	}
	
	public int getColumnCount() {
		int colCount = 0;
		try {
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			log.info("Column Count: " + colCount);
		} catch (Exception e) {
			log.error(e.getMessage());
			log.error(e.getCause());
			log.error("getColumnCount() failed due to ", e);
		}
		return colCount;
	}
	
	public String getStringCellData(int rowNum, int colNum) {
		String cellDataString = null;
		try {
			cellDataString = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			log.debug("Data from row[" + rowNum + "], column[" + colNum + "] is " + cellDataString);
		} catch (Exception e) {
			log.error(e.getMessage());
			log.error(e.getCause());
			log.error("getStringCellData() failed due to ", e);
		}
		return cellDataString;
	}
	
	public int getNumericCellData(int rowNum, int colNum) {
		int cellDataNum = 0;
		try {
			cellDataNum = (int) sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			log.debug("Data from row[" + rowNum + "], column[" + colNum + "] is " + cellDataNum);
		} catch (Exception e) {
			log.error(e.getMessage());
			log.error(e.getCause());
			log.error("getNumericCellData() failed due to ", e);
		}
		return cellDataNum;
	}
	
	public boolean getBooleanCellData(int rowNum, int colNum) {
		boolean cellDataBoolean = false;
		try {
			cellDataBoolean = sheet.getRow(rowNum).getCell(colNum).getBooleanCellValue();
			log.debug("Data from row[" + rowNum + "], column[" + colNum + "] is " + cellDataBoolean);
		} catch (Exception e) {
			log.error(e.getMessage());
			log.error(e.getCause());
			log.error("getBooleanCellData() failed due to ", e);
		}
		return cellDataBoolean;
	}

}
