package tutorials.tests;

import org.junit.Test;

import tutorials.array.MinSubArr;

public class MinSubArrTest {

	@Test
	public void testFindMinSubArrIntArrayCase1() {
		int[] arr = {1, 4, 45, 6, 0, 19}; 
		int x = 51; 
		MinSubArr.findMinSubArr(arr, x); 
	}
	
	
	@Test
	public void testFindMinSubArrIntArrayCase2() {
		int[] arr = {1, 10, 5, 2, 7};
		int x = 9; 
		MinSubArr.findMinSubArr(arr, x); 
	}
	
	
	@Test
	public void testFindMinSubArrIntArrayCase3() {
		int[] arr = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
		int x = 280; 
		MinSubArr.findMinSubArr(arr, x); 
	}
	
	
	@Test
	public void testFindMinSubArrIntArrayCase4() {
		int[] arr = {1, 4, 45, 6, 0, 19}; 
		int x = 80; 
		MinSubArr.findMinSubArr(arr, x); 
	}
	
	
	

}
