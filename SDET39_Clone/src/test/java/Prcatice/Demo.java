package Prcatice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Demo {
@Test
public void test1(){
	System.out.println("LogIn");
	System.out.println("pass");
	SoftAssert softAssert = new SoftAssert();
	Assert.assertEquals(true, false);
	

	System.out.println("hello");
}
}
