package com.crm.sdet.organisation;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.Generic_Utility.BaseClass;
import com.crm.Generic_Utility.Excel_utility;

import com.crm.Generic_Utility.Java_Utility;

import com.crm.objectRepsitory.HomePage;
import com.crm.objectRepsitory.Organisation;
import com.crm.objectRepsitory.OrganisationValidation;


public class CreateOrganisationTest extends BaseClass {
	@Test (groups="smokeTest")
	public void createOrganisation() throws Throwable {
		HomePage home =new HomePage(driver);
		home.Organisation();
		Organisation org= new Organisation(driver);
		org.plusOraganisation();
		Java_Utility jlib=new Java_Utility();
		int jcount = jlib.getRandom();
		Excel_utility elib=new Excel_utility();
		String name = elib.getValueFromExcel("Sheet1", 1, 0)+jcount;
		org.oraganisationName(name);
		OrganisationValidation ActualData=new OrganisationValidation(driver);
		String ActualOrganisationData = ActualData.actualOrganisationName();
		Assert.assertEquals(ActualOrganisationData.contains(name), true);
		
		home.signOut();
	}

}
