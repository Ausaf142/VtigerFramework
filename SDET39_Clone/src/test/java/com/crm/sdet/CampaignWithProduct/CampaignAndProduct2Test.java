package com.crm.sdet.CampaignWithProduct;



import org.openqa.selenium.By;

import org.testng.annotations.Test;

import com.crm.Generic_Utility.BaseClass;
import com.crm.Generic_Utility.Excel_utility;

import com.crm.Generic_Utility.Java_Utility;
import com.crm.Generic_Utility.WebDriverUtility;
import com.crm.objectRepsitory.AddingProductToCampaign;
import com.crm.objectRepsitory.Campaign;
import com.crm.objectRepsitory.HomePage;
import com.crm.objectRepsitory.Product;

public class CampaignAndProduct2Test extends BaseClass {
	@Test
	public void campaignAndProduct() throws Throwable {
		HomePage home=new HomePage(driver);
		home.product();
		Product prod=new Product(driver);
		prod.PlusProduct();
		Java_Utility jlib= new Java_Utility();
		int count = jlib.getRandom();
		Excel_utility elib=new Excel_utility();
		String name= elib.getValueFromExcel("Sheet1", 0, 0)+count;
		prod.productName(name);
		prod.saveProduct();
		String actname = driver.findElement(By.className("lvtHeaderText")).getText();
		if(actname.contains(name)) {
			System.out.println("created");
		}
		else {
			System.out.println("not created");
		}
	
		
		//campaign name
		String campName = elib.getValueFromExcel("Sheet1", 1, 0)+count;
		home.more();
		home.clickCampaign();
		Campaign campaign=new Campaign(driver);
		campaign.plusCampaign();
		AddingProductToCampaign addprod=new AddingProductToCampaign(driver);
		addprod.plusProductCampaign();
		WebDriverUtility wlib=new WebDriverUtility();
		wlib.switchToWindow(driver, "Products&action");
		addprod.productName(name);
		addprod.search();
		driver.findElement(By.xpath("//a[text()='"+name+"']")).click();
		
		wlib.switchToWindow(driver, "Campaigns&action");
	
	
		
			campaign.campaignName(campName);
			campaign.saveCampaign();
			
			home.signOut();
			driver.quit();
	}		

	}
