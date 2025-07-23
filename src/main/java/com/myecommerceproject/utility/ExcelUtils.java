package com.myecommerceproject.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.Inet4Address;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public String filePath="C:\\Users\\anujt\\OneDrive\\Documents\\Selenium Project\\MyEcommerceProject\\src\\test\\resources\\TestData\\TestDataForEcommerceSite.xlsx";
	public FileInputStream fileInputStream;
	public XSSFWorkbook workBook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public XSSFSheet OpenExcelSheet() throws IOException {
		fileInputStream=new FileInputStream(filePath);
		workBook=new XSSFWorkbook(fileInputStream);
		sheet= workBook.getSheetAt(0);
		return sheet;	
	}
	public int getRowCount() throws IOException {
		sheet=OpenExcelSheet();
		row=sheet.getRow(0);
		int rowCount=sheet.getPhysicalNumberOfRows();
		return rowCount;
	}
	public int getColumnCount() throws IOException {
		sheet=OpenExcelSheet();
		row=sheet.getRow(0);
		int columnCount=row.getPhysicalNumberOfCells();
		return columnCount;
	}
	public String getCellData(int rowNumber, int columnNumber) throws IOException {
		
//		int rowCount=getRowCount();
//		int columnCount=getColumnCount();
		row=sheet.getRow(rowNumber);
		cell=row.getCell(columnNumber);
		String cellValue=cell.getStringCellValue();
		return cellValue;
//		for(int i=0;i<rowCount-1;i++) {
//			row=sheet.getRow(i+1);
//			for(int j=0;i<columnCount;j++) {
//				cell=row.getCell(j);
//				String cellValue= cell.getStringCellValue();
//				System.out.println("This is cell Data="+cellValue);
//				return cellValue;
//				
//			}
//		}
//		return null;
	}

}
