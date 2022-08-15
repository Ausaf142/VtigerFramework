package Prcatice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertSoft {
	
	@Test
	public void prog1() {
		System.out.println("this is softassert");
		System.out.println("now its time for soft assert");
		SoftAssert ass=new SoftAssert();
		ass.assertEquals("A", "B");
		System.out.println("executed");
		ass.assertAll();
	}
	@Test
	public void prog2() {
		System.out.println("hello");
		System.out.println("byee");
	}
	

}
