package Prcatice;


import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CampaignwithProduct {
	public static void main(String[] args) throws Throwable {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	//from property file
	FileInputStream fis=new FileInputStream("./Data/Vtiger.properties");
	Properties prop=new Properties();
	prop.load(fis);
	String URL = prop.getProperty("url");
	String uName = prop.getProperty("un");
	String pwd = prop.getProperty("pw");
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(uName);
	driver.findElement(By.name("user_password")).sendKeys(pwd);
	driver.findElement(By.name("user_password")).sendKeys(Keys.ENTER);
	//action class for campaign
	Actions act=new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("//a[@href='javascript:;']"))).perform();
	driver.findElement(By.name("Campaigns")).click();
	driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
	//for unique name 
	Random rn=new Random();
	int random = rn.nextInt(1000);
	
	//from excel sheet
	FileInputStream fis2=new FileInputStream("./Data/Book6.xlsx");
	Workbook wb = WorkbookFactory.create(fis2);
	Sheet sheet = wb.getSheet("crm");
	Row row = sheet.getRow(0);
	Cell cell = row.getCell(0);
	String name = cell.getStringCellValue()+random;
	
	
	driver.findElement(By.name("campaignname")).sendKeys(name);
	String parent = driver.getWindowHandle();
	driver.findElement(By.xpath("//img[@title='Select']")).click();
	Set<String> window = driver.getWindowHandles();
	for(String child:window) {
		if(!parent.equals(child)) {
			driver.switchTo().window(child);

			driver.findElement(By.id("search_txt")).sendKeys("iphone290");
			driver.findElement(By.name("search")).click();
			
		}
		else {
			driver.switchTo().window(parent);
		}
		
		
	}
	
	
	driver.findElement(By.name("button")).click();
	Thread.sleep(2000);
	//for sign out
	act.moveByOffset(1122, 13).perform();
	act.moveByOffset(1104, 65).click().perform();
	
	
	
	
}
}