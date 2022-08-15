package Prcatice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Property2 {
	public static void main(String[] args) throws Throwable {
	FileInputStream fis=new FileInputStream("./Data/my.properties");
	Properties prop=new Properties();
	prop.load(fis);
	String URL = prop.getProperty("url");
	String username = prop.getProperty("un");
	String pwd = prop.getProperty("pw");
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.MILLISECONDS);
	driver.get(URL);
	driver.findElement(By.id("email")).sendKeys(username);
	driver.findElement(By.id("pass")).sendKeys(pwd);
	driver.findElement(By.id("pass")).sendKeys(Keys.ENTER);
}
}