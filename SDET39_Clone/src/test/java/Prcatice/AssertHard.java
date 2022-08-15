package Prcatice;

import org.testng.Assert;
import org.testng.annotations.Test;


public class AssertHard {
	
@Test
 public void prog1() {
	System.out.println("first step");
	System.out.println("second step");
	Assert.assertEquals("A", "B");
	System.out.println("Thisrd step");
}
	@Test
	public void prog2() {
		System.out.println("hello");
		System.out.println("byee");
	}


}


