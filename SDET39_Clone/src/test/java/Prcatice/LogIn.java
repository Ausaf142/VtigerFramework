package Prcatice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogIn {
	public static void main(String[] args) throws IOException {
	FileInputStream	fis=new FileInputStream("./Data/tiger.properties");
	Properties property=new Properties();
	property.load(fis);
	String url = property.getProperty("url");
	String username = property.getProperty("un");
	String pass = property.getProperty("pw");

	WebDriver driver=new ChromeDriver();
	driver.get(url);
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(pass);
	driver.findElement(By.id("submitButton")).click();

}
}