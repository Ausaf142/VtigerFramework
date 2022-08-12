package Prcatice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelWrite {
	public static void main(String[] args) throws Throwable  {
		FileInputStream fis=new FileInputStream("./Data/Book2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		Row row = sheet.createRow(0);
		 Cell cell = row.createCell(0);
		 cell.setCellValue("Ausaf");
		 FileOutputStream fos=new FileOutputStream("./Data/Book2.xlsx");
		 wb.write(fos);
		 wb.close();
	
	

}
}