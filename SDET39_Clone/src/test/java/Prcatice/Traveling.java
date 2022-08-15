package Prcatice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Traveling {
@Test (dataProvider="dataProvider_test")
	public void bookTicket(String sorc,String des) {
		System.out.println("travelling from " + sorc+ " to "+des+"");
	}
	
	
	@DataProvider
	public Object[][] dataProvider_test()
	{
		Object[][] objArr=new Object[5][2];
		objArr[0][0]="Banglore";
		objArr[0][1]="Delhi";

		objArr[1][0]="Banglore";
		objArr[1][1]="goa";
		
		objArr[2][0]="Banglore";
		objArr[2][1]="pune";
		
		objArr[3][0]="Banglore";
		objArr[3][1]="lucknow";
		
		objArr[4][0]="Banglore";
		objArr[4][1]="kerela";
		return objArr;
	}
}
