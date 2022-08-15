package Prcatice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTrip {
	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get("https://www.makemytrip.com/");
	driver.findElement(By.id("fromCity")).sendKeys("new delhi");
	driver.findElement(By.xpath("//p[text()='New Delhi, India']")).click();
	driver.findElement(By.id("toCity")).sendKeys("mumbai");
	driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
		driver.findElement(By.xpath("//span[@class='lbl_input latoBold appendBottom10']")).click();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		driver.findElement(By.xpath("//p[text()='3']")).click();
		driver.findElement(By.xpath("(//span[@class='lbl_input latoBold appendBottom10'])[2]")).click();
		driver.findElement(By.xpath("//p[text()='13']")).click();
		
}
}