package Prcatice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelWrite2 {
	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream("./Data/Book3.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		Row row = sheet.getRow(0);
		Cell cell = row.createCell(2);
		cell.setCellValue("price");
		Row row2 = sheet.getRow(1);
		Cell cell2 = row2.createCell(2);
		cell2.setCellValue("5000");
		FileOutputStream fos=new FileOutputStream("./Data/Book3.xlsx");
		wb.write(fos);
		wb.close();
		
		
		
	}

}
