package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.strings.CountBinaryStrings;

public class CountBinaryStringsTest {

	@Test
	public void testCountStrings() {
		
		int N = 1 ; 
		int expected = 2; 
		int actual   = CountBinaryStrings.countStrings(N); 
		assertEquals(expected, actual); 
		
		N = 2 ; 
		expected = 3; 
		actual   = CountBinaryStrings.countStrings(N); 
		assertEquals(expected, actual); 
		
		N = 3 ; 
		expected = 5; 
		actual   = CountBinaryStrings.countStrings(N); 
		assertEquals(expected, actual); 
	}

	
	@Test
	public void testCountStringsDP() {
		
		int N = 1 ; 
		int expected = 2; 
		int actual   = CountBinaryStrings.countStringsDP(N); 
		assertEquals(expected, actual); 
		
		N = 2 ; 
		expected = 3; 
		actual   = CountBinaryStrings.countStringsDP(N); 
		assertEquals(expected, actual); 
		
		N = 3 ; 
		expected = 5; 
		actual   = CountBinaryStrings.countStringsDP(N); 
		assertEquals(expected, actual); 

	}
	
	
}
