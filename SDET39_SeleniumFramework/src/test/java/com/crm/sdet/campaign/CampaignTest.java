package com.crm.sdet.campaign;


import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.Generic_Utility.BaseClass;
import com.crm.Generic_Utility.Excel_utility;
import com.crm.Generic_Utility.File_utility;
import com.crm.Generic_Utility.Java_Utility;
import com.crm.Generic_Utility.WebDriverUtility;
import com.crm.objectRepsitory.Campaign;
import com.crm.objectRepsitory.CampaignValidation;
import com.crm.objectRepsitory.HomePage;

public class CampaignTest extends BaseClass {
	@Test
	public void createCampaign() throws Throwable {
		
		Java_Utility jlib=new Java_Utility();
		Excel_utility elib=new Excel_utility();
	
		HomePage home=new HomePage(driver);
		home.more();
		home.clickCampaign();
		int count = jlib.getRandom();
		//mtd called from generic excel.
		String data = elib.getValueFromExcel("Sheet1", 1, 0);
		String name = data+count;
		Campaign campaign=new Campaign(driver);
		campaign.plusCampaign();
		campaign.campaignName(name);
		campaign.saveCampaign();
		CampaignValidation ActualData = new CampaignValidation(driver);
		String ActualCampaignData = ActualData.actualCampaignName();
		Assert.assertEquals(ActualCampaignData.contains(name), true);
		
		
		home.signOut();
		
		
	}

}
