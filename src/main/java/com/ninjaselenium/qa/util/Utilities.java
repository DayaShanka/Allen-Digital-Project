package com.ninjaselenium.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilities {
	
	
	public static String generateEmailWithTimeStamp() {
		// using static to use this method in Login class with the help of
		// Utilities.generateEmailWithTimeStamp()

		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "daya.choubey.111." + timeStamp + "@gmail.com";

	}

	@SuppressWarnings("incomplete-switch")
	public static Object[][] getTestDataFromExcel(String sheetName) {
		File excelFile = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\ninjaselenium\\qa\\testdata\\testdata.xlsx");
		XSSFWorkbook workbook = null; //make it global

		try {
			FileInputStream fisExcel = new FileInputStream(excelFile);
			workbook = new XSSFWorkbook(fisExcel);

		} catch (Throwable e) {
			e.printStackTrace();

		}

		XSSFSheet sheet = workbook.createSheet(sheetName);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rows][cols];

		for (int i = 0; i < rows; i++) {

			XSSFRow row = sheet.getRow(i + 1);

			for (int j = 0; j < cols; j++) {

				XSSFCell cell = row.getCell(j);
				CellType cellType = cell.getCellType();

				switch (cellType) {

				case STRING:
					data[i][j] = cell.getStringCellValue();
					break;

				case NUMERIC:
					data[i][j] = Integer.toString((int) cell.getNumericCellValue());
					break;
					
				case BOOLEAN:
					data[i][j] = cell.getBooleanCellValue();

				}

			}
		}
		
		return data;
	}
}
	

