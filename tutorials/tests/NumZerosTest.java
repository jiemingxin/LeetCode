package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.array.NumZeros;

public class NumZerosTest {

	@Test
	public void testCountZerosCase0() {
		
		int arr[] = {1, 1, 1, 1, 0, 0};
		int expected = 2; 
		int actual = NumZeros.countZeros(arr);
		assertEquals(expected, actual); 
	}
	
	
	@Test
	public void testCountZerosCase1() {
		
		int arr[] = {1, 0, 0, 0, 0};
		int expected = 4; 
		int actual = NumZeros.countZeros(arr);
		assertEquals(expected, actual); 
	}

	
	@Test
	public void testCountZerosCase2() {
		
		int arr[] = {0, 0, 0};
		int expected = 3; 
		int actual = NumZeros.countZeros(arr);
		assertEquals(expected, actual); 
	}
	
	@Test
	public void testCountZerosCase3() {
		
		int arr[] = {1, 1, 1, 1};
		int expected = 0; 
		int actual = NumZeros.countZeros(arr);
		assertEquals(expected, actual); 
	}
}
