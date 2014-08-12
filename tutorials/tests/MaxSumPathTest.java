package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.array.MaxSumPath;

public class MaxSumPathTest {

	@Test
	public void testComputeMaxSumCase1() {
		int arr1[] = {2, 3, 7, 10, 12, 15, 30, 34}, arr2[] = {1, 5, 7, 8, 10, 15, 16, 19}; 
		int actual = 122; 
		int expected = MaxSumPath.computeMaxSum(arr1,arr2); 
		assertEquals(actual, expected); 
		
	}
	
	
	@Test
	public void testComputeMaxSumCase2() {
		int arr1[] = {2, 3, 7, 10, 12}, arr2[] = {1, 5, 7, 8}; 
		int actual = 35; 
		int expected = MaxSumPath.computeMaxSum(arr1,arr2); 
		assertEquals(actual, expected); 
	}
	
	
	@Test
	public void testComputeMaxSumCase3() {
		int arr1[] = {10, 12}, arr2[] = {5, 7, 9};
		int actual = 22 ; 
		int expected = MaxSumPath.computeMaxSum(arr1,arr2); 
		assertEquals(actual, expected); 
	}
	
	
	
	@Test
	public void testComputeMaxSumCase4() {
		int arr1[] = {1, 4, 7, 8, 9  } , arr2[] = {6, 7, 10 } ;
		int actual = 30 ; 
		int expected = MaxSumPath.computeMaxSum(arr1,arr2); 
		assertEquals(actual, expected); 
	}
	
}
