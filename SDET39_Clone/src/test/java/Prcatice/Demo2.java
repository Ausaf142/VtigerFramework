package Prcatice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo2 {
	@Test(retryAnalyzer=com.crm.Generic_Utility.ReTryImpClass.class)
	public void modifyContact() {
		Assert.assertEquals(true, false);
		System.out.println("modify created");
	}

}
