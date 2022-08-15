package com.crm.sdet.ProductDelete;




import org.openqa.selenium.By;


import org.testng.annotations.Test;

import com.crm.Generic_Utility.BaseClass;
import com.crm.Generic_Utility.Excel_utility;

import com.crm.Generic_Utility.Java_Utility;
import com.crm.Generic_Utility.WebDriverUtility;
import com.crm.objectRepsitory.DeleteProduct;
import com.crm.objectRepsitory.HomePage;
import com.crm.objectRepsitory.Product;

public class DeleteProductTest extends BaseClass{
	@Test
	public void deletProduct() throws Throwable {
		HomePage home=new HomePage(driver);
		home.product();
		Java_Utility jlib=new Java_Utility();
		int count = jlib.getRandom();
		Excel_utility elib=new Excel_utility();
		String name = elib.getValueFromExcel("Sheet1", 1, 0)+count;
		Product prod=new Product(driver);
		prod.PlusProduct();
		prod.productName(name);
		prod.saveProduct();
		
		String actname = driver.findElement(By.className("lvtHeaderText")).getText();
		if(actname.contains(name)) {
			System.out.println("created");
		}
		else {
			System.out.println("not created");
		}
		DeleteProduct del=new DeleteProduct(driver);
		del.delete();
		WebDriverUtility wlib = new WebDriverUtility();
		wlib.switchToAlertAndAccept(driver);
		home.signOut();
		driver.quit();
			
			
	}

}