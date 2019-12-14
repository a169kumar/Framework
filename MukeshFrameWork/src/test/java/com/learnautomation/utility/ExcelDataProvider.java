package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	File src;
	XSSFWorkbook wb;

	public ExcelDataProvider() {
		
		 src= new File("./Test Data/Data.xlsx");
		try {
		FileInputStream fi= new FileInputStream(src);
		
			 wb= new XSSFWorkbook(fi);
		} catch (IOException e) {
			
			System.out.println(" unable to read excel file" + e.getMessage());
		}
	}
	
	public String getStringData(String sheet,int row, int col) {
	return	wb.getSheet(sheet).getRow(row).getCell(col).getStringCellValue();
	}
	
	public Double getNumericData(String sheet,int row, int col) {
		
		return	wb.getSheet(sheet).getRow(row).getCell(col).getNumericCellValue();
	}
}

