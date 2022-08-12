package Prcatice;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CampaignAndProduct {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.MILLISECONDS);
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		Random r=new Random();
		int count = r.nextInt(1000);
		FileInputStream fis=new FileInputStream("./Data/Book4.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(0);
		String name = cell.getStringCellValue()+count;
		System.out.println(name);
		driver.findElement(By.name("productname")).sendKeys(name);
		driver.findElement(By.name("button")).click();
		Thread.sleep(3000);
		
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[@href='javascript:;']"))).perform();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		//for unique name 
		Random rn=new Random();
		int random = rn.nextInt(1000);
		
		//from excel sheet
		FileInputStream fis2=new FileInputStream("./Data/Book6.xlsx");
		Workbook wbook = WorkbookFactory.create(fis2);
		Sheet sheet1 = wb.getSheet("crm");
		Row row1 = sheet.getRow(0);
		Cell cell1 = row.getCell(0);
		String name1 = cell.getStringCellValue()+random;
		
		
		driver.findElement(By.name("campaignname")).sendKeys(name1);
		
		Thread.sleep(2000);
		Set<String> allId = driver.getWindowHandles();
		Iterator<String> ID = allId.iterator();
		while(ID.hasNext()) {
			String win = ID.next();
			driver.switchTo().window(win);
			Thread.sleep(1000);
			if(driver.getTitle().contains("Products&action")) {
				break;
			}
			driver.findElement(By.xpath("//img[@title='Select']")).click();
			driver.findElement(By.id("search_txt")).sendKeys(name);
			driver.findElement(By.id("search_txt")).click();
			driver.findElement(By.xpath("//a[text()='"+name+"']")).click();
		}
		Set<String> allId2 = driver.getWindowHandles();
		Iterator<String> ID2 = allId2.iterator();
		while(ID2.hasNext()) {
			String win2 = ID2.next();
			driver.switchTo().window(win2);
			if(driver.getTitle().contains("Campaigns&action")) {
				break;
			}
			
		}
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
		

}
}