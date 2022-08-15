package Prcatice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMytrip2 {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
		WebElement src = driver.findElement(By.id("fromCity"));
		src.sendKeys("new delhi");
		driver.findElement(By.xpath("//p[text()='New Delhi, India']")).click();
		
		WebElement des = driver.findElement(By.id("toCity"));
		des.sendKeys("mumbai");
		driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
		
			driver.findElement(By.xpath("//span[@class='lbl_input latoBold appendBottom10']")).click();
			
			driver.findElement(By.xpath("//span[@class='langCardClose']")).click();//pop up
			String reqMonth = "November";
			String reqYear = "2022";
			String reqDate = "10";
			String currentMonthYear = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption']/div)[1]")).getText();
			String currentMonth = currentMonthYear.split(" ")[0];
			String currentYear = currentMonthYear.split(" ")[1];
			while(!(currentMonth.equalsIgnoreCase(reqMonth)&&currentYear.equals(reqYear))){
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
				//driver.findElement(By.xpath("//div[@class='DayPicker-Day']")).click();
				currentMonthYear = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption']/div)[1]")).getText();
				currentMonth = currentMonthYear.split(" ")[0];
				currentYear = currentMonthYear.split(" ")[1];
				
			}
			
			
			driver.findElement(By.xpath("(//p[text()='"+reqDate+"'])[1]")).click();
			
			
					
	}
}
