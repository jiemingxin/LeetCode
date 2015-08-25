package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.array.CheckDuplicates;

public class CheckDuplicatesTest {

	@Test
	public void testContainDuplicatesCase1() {
		
		int[] arr = {1, 2, 3, 4, 1, 2, 3, 4};
		int k = 3; 
		assertEquals(false, CheckDuplicates.containDuplicates(arr, k)); 
	}

	
	@Test
	public void testContainDuplicatesCase2() {
		
		int[] arr =  {1, 2, 3, 1, 4, 5};
		int k = 3; 
		assertEquals(true, CheckDuplicates.containDuplicates(arr, k)); 
	}
	
	
	@Test
	public void testContainDuplicatesCase3() {
		
		int[] arr =  {1, 2, 3, 4, 5};
		int k = 3; 
		assertEquals(false, CheckDuplicates.containDuplicates(arr, k)); 
	}
	
	
	
	@Test
	public void testContainDuplicatesCase4() {
		
		int[] arr =  {1, 2, 3, 4, 4};
		int k = 3; 
		assertEquals(true, CheckDuplicates.containDuplicates(arr, k)); 
	}
	
}
