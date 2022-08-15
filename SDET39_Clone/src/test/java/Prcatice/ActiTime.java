package Prcatice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActiTime {
public static void main(String[] args) throws IOException {
	FileInputStream	fis=new FileInputStream("./Data/Act.properties");
	Properties property=new Properties();
	property.load(fis);
	String url = property.getProperty("url");
	String username = property.getProperty("uname");
	String pass = property.getProperty("pwd");
	
	WebDriver driver=new ChromeDriver();
	driver.get(url);
	driver.findElement(By.name("username")).sendKeys(username);
	driver.findElement(By.name("pwd")).sendKeys(pass);
	driver.findElement(By.xpath("//div[text()='Login ']")).click();

	
	
	
	
}

}
