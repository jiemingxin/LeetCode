package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.array.ClosestValuesInSortedArray;

public class ClosestValuesInSortedArrayTest {

	@Test
	public void testFindClosetElementsCase1() {
		int arr[] ={12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
		int key = 35; 
		int total = 4; 
		
		String actual = "[30, 39, 42, 45]"; 
		String expected = ClosestValuesInSortedArray.findClosetValues(arr,total,key);
		assertEquals(actual, expected); 
	}

	
	
	@Test
	public void testFindClosetElementsCase2() {
		int arr[] ={12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
		int key = 22; 
		int total = 3; 
		
		String actual = "[12, 16, 30]"; 
		String expected = ClosestValuesInSortedArray.findClosetValues(arr,total,key);
		assertEquals(actual, expected); 
	}

	
	@Test
	public void testFindClosetElementsCase3() {
		int arr[] ={12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
		int key = 12; 
		int total = 3; 
		
		String actual = "[16, 22, 30]"; 
		String expected = ClosestValuesInSortedArray.findClosetValues(arr,total,key);
		assertEquals(actual, expected); 
	}

	
	
	@Test
	public void testFindClosetElementsCase4() {
		int arr[] ={12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56};
		int key = 56; 
		int total = 1; 
		
		String actual = "[55]"; 
		String expected = ClosestValuesInSortedArray.findClosetValues(arr,total,key);
		assertEquals(actual, expected); 
	}
	
	
	
	
	@Test
	public void testFindCrossoverPoint() {
		int[] arr = { 3, 5, 7, 8, 11, 19, 20};  
		int X = 21; 
		int expectedIndex = 6 ; 
		int actualIndex = ClosestValuesInSortedArray.findCrossoverIndex(arr, X); 
		assertEquals(expectedIndex, actualIndex); 
		
		X = -1; 
		expectedIndex = 0 ; 
		actualIndex = ClosestValuesInSortedArray.findCrossoverIndex(arr, X); 
		assertEquals(expectedIndex, actualIndex); 
		
		X = 3; 
		expectedIndex = 0 ; 
		actualIndex = ClosestValuesInSortedArray.findCrossoverIndex(arr, X); 
		assertEquals(expectedIndex, actualIndex); 
		
		X = 19; 
		expectedIndex = 5 ; 
		actualIndex = ClosestValuesInSortedArray.findCrossoverIndex(arr, X); 
		assertEquals(expectedIndex, actualIndex); 
		
		X = 18; 
		expectedIndex = 4 ; 
		actualIndex = ClosestValuesInSortedArray.findCrossoverIndex(arr, X); 
		assertEquals(expectedIndex, actualIndex); 
		
		X = 8; 
		expectedIndex = 3 ; 
		actualIndex = ClosestValuesInSortedArray.findCrossoverIndex(arr, X); 
		assertEquals(expectedIndex, actualIndex); 
		
		X = 17; 
		expectedIndex = 4 ; 
		actualIndex = ClosestValuesInSortedArray.findCrossoverIndex(arr, X); 
		assertEquals(expectedIndex, actualIndex); 
		
	}
	
}
