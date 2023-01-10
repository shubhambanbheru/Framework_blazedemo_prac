package com.blazedemo.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Exceldataprovider {
	static XSSFWorkbook wb;

	public Exceldataprovider() {

		File file = new File(System.getProperty("user.dir") + "/testdata/Testdata.xlsx");

		try {
			FileInputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("File not found :"+e.getMessage());
		}
		

	}

	public  String getStringdata(String sheetname,int row,int col) {
  return wb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
	}
	
	public  double getnumericdata(String sheetname,int row,int col) {
		  return wb.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue();
	}

}
