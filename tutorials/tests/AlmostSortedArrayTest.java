package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.array.AlmostSortedArray;

public class AlmostSortedArrayTest {

	@Test
	public void testSearchCase1() {
		
		int[] arr = { 2, 1, 4, 3, 6, 5 }; 
		for(int i=0; i<arr.length; i++){
			int expected =  i; 
			int actual = AlmostSortedArray.search(arr, arr[i]); 
			assertEquals(expected, actual); 
		}
	}
	
	
	
	@Test
	public void testSearchCase2() {
		
		int[] arr = { 10, 11, 13, 12, 16, 14 }; 
		for(int i=0; i<arr.length; i++){
			int expected =  i; 
			int actual = AlmostSortedArray.search(arr, arr[i]); 
			assertEquals(expected, actual); 
		}
	}
	
	
	
	@Test
	public void testSearchCase3() {
		
		int[] arr = { 10, 3, 40, 20, 50, 80, 70 }; 
		for(int i=0; i<arr.length; i++){
			int expected =  i; 
			int actual = AlmostSortedArray.search(arr, arr[i]); 
			assertEquals(expected, actual); 
		}
	}
	
	
	
	
	
	

}
