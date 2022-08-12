package Prcatice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelAllData {

		public static void main(String[] args) throws EncryptedDocumentException, IOException {
			FileInputStream fis=new FileInputStream("./Data/Book1.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheet("Sheet1");
			int last = sheet.getLastRowNum();
			for(int i=1;i<=last;i++) {
				Row r = sheet.getRow(i);
				Cell cell = r.getCell(0);
				String data = cell.getStringCellValue();
				System.out.println(data);
			
			}
	}

}
