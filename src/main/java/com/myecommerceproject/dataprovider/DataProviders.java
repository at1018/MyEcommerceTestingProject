package com.myecommerceproject.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.myecommerceproject.utility.ExcelUtils;

public class DataProviders {
	ExcelUtils excelUtils=new ExcelUtils();
	@DataProvider(name="ReadDataFromExcel")
	public Object[][] readDataFromExcel() throws IOException{
		int rowCount=excelUtils.getRowCount();
		int columnCount=excelUtils.getColumnCount();
		Object[][] data=new Object[rowCount-1][columnCount];
		for(int i=0;i<rowCount-1;i++) {
			for(int j=0;j<columnCount;j++) {
//				System.out.println("This is cell Data="+excelUtils.getCellData());
				data[i][j]=excelUtils.getCellData(i+1,j);
			}
		}
		return data;
		
	}

}
