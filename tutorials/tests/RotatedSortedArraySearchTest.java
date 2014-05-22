package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.array.RotatedSortedArraySearch;

public class RotatedSortedArraySearchTest {

	
	@Test
	public void testSearchKeyNotExists() {
		
		int[] arr = {7,1,2,3,4,5,6}; 
		int key = 0; 

		int actual   = RotatedSortedArraySearch.searchKey(arr, key); 
		int expected = -1; 
		assertEquals(actual, expected); 
	}
	
	
	@Test
	public void testSearchKeyCase1() {
		
		int[] arr = {7,1,2,3,4,5,6}; 
		int key = 7; 

		int actual   = RotatedSortedArraySearch.searchKey(arr, key); 
		int expected = 0; 
		assertEquals(actual, expected); 
	}
	
	
	
	@Test
	public void testSearchKeyCase2() {
		
		int[] arr = {7,1,2,3,4,5,6}; 
		int key = 4; 

		int actual   = RotatedSortedArraySearch.searchKey(arr, key); 
		int expected = 4; 
		assertEquals(actual, expected); 
	}
	
	
	
	
	@Test
	public void testSearchKeyCase3() {
		
		int[] arr = {7,1,2,3,4,5,6}; 
		int key = 4; 

		int actual   = RotatedSortedArraySearch.searchKey(arr, key); 
		int expected = 4; 
		assertEquals(actual, expected); 
	}
	
	
	
	@Test
	public void testSearchKeyCase4() {
		
		int[] arr = {6,7,1,2,3,4,5}; 
		int key = 5; 

		int actual   = RotatedSortedArraySearch.searchKey(arr, key); 
		int expected = 6; 
		assertEquals(actual, expected); 
	}
	
	

}
