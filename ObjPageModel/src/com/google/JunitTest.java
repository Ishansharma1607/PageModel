package com.google;

//import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class JunitTest {
	
	
	
	@Test
	public void test()
	{
		
		String str = "Hi";
	assertEquals("Strings Not Same","Hi", str);
}
	@Test
	public void test2()
	{
		
		String str = "Hi";
		assertEquals("Strings Not Same","Hii", str);
	}
	
//	@Test
//	public void test()
//	{
//		
//		String str = "Hi";
//		Assert.assertEquals("Strings Not Same","Hi", str);
//	}
//	@Test
//	public void test2()
//	{
//		
//		String str = "Hi";
//		Assert.assertEquals("Strings Not Same","Hii", str);
//	}
//	
	
}
