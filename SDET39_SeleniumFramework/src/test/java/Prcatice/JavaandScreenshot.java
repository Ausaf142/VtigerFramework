package Prcatice;

import java.io.File;
import java.sql.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class JavaandScreenshot {
	public static void main(String[] args) throws Throwable {
		/*Date date=new Date(0);
		String d2 = date.toString().replace(" ","_");*/
		Random r=new Random();
		int gan = r.nextInt(100);
		Random r1=new Random();
		int gan2 = r1.nextInt(100);

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demoapp.skillrary.com/");
		File d = driver.findElement(By.xpath("//input[@class='form-control']")).getScreenshotAs(OutputType.FILE);
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File pic = ts.getScreenshotAs(OutputType.FILE);
		File des=new File("./Sdet/photo"+gan+".png");
		File dest=new File("./Sdet/photo"+gan2+".png");
		FileUtils.copyFile(pic, des);
		FileUtils.copyFile(d, dest);
	}

}
