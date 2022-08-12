package Prcatice;

import java.io.FileInputStream;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateAndDeleteProduct {
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
		String actname = driver.findElement(By.className("lvtHeaderText")).getText();
		if(actname.contains(name)) {
			System.out.println("created");
		}
		else {
			System.out.println("not created");
		}
		//for refresh and select created present product
		driver.findElement(By.linkText("Products")).click();
	
		driver.findElement(By.name("search_text")).sendKeys(name);
		 WebElement ele = driver.findElement(By.id("bas_searchfield"));
		Select sel=new Select(ele);
		sel.selectByValue("productname");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		//for delete
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("(//input[@type='button'])[8]")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		
		//for sign out
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"))).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			
	
	
	
	
	
	
	
	
	
	
}

}
