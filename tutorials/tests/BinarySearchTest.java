package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.array.BinarySearch;

public class BinarySearchTest {

	@Test
	public void testIterativeSearchNotFoundCases() {
		int[] arr = { 3, 5, 7, 8, 11, 19, 20}; 
		int key = 21; 
		int actualIndex = BinarySearch.iterativeSearch(arr, key); 
		int expectedIndex = -1 ; 
		assertEquals(actualIndex, expectedIndex); 
		
		key = -1; 
		actualIndex = BinarySearch.iterativeSearch(arr, key);  
		expectedIndex = -1 ;
		assertEquals(actualIndex, expectedIndex);  
		
		key = -1; 
		actualIndex = BinarySearch.iterativeSearchNeat(arr, key);  
		expectedIndex = -1 ;
		assertEquals(actualIndex, expectedIndex);  
		
	}

	
	@Test
	public void testIterativeSearchCornerCases() {
		
		int[] arr = { 3, 5, 7, 8, 11, 19, 20}; 
		int key = 20; 
		int actualIndex = BinarySearch.iterativeSearch(arr, key); 
		int expectedIndex = 6 ; 
		assertEquals(actualIndex, expectedIndex); 
		
		key = 3; 
		actualIndex = BinarySearch.iterativeSearch(arr, key);  
		expectedIndex = 0 ;
		assertEquals(actualIndex, expectedIndex);  
		
		key = 3; 
		actualIndex = BinarySearch.iterativeSearchNeat(arr, key);  
		expectedIndex = 0 ;
		assertEquals(actualIndex, expectedIndex);  
	}
	
	
	@Test
	public void testIterativeSearchBaseCases() {
		
		int[] arr = { 3, 5, 7, 8, 8, 19, 20}; 
		int key = 7; 
		int actualIndex = BinarySearch.iterativeSearch(arr, key); 
		int expectedIndex = 2 ; 
		assertEquals(actualIndex, expectedIndex); 

		actualIndex = BinarySearch.iterativeSearchNeat(arr, key);  
		assertEquals(actualIndex, expectedIndex);  
	}
	
	
		
	@Test
	public void testRecursiveSearchNotFoundCases() {
		int[] arr = { 3, 5, 7, 8, 11, 19, 20}; 
		int key = 21; 
		int actualIndex = BinarySearch.recursiveSearch(arr, key); 
		int expectedIndex = -1 ; 
		assertEquals(actualIndex, expectedIndex); 
		
		
		key = -1; 
		actualIndex = BinarySearch.recursiveSearch(arr, key);  
		expectedIndex = -1 ;
		assertEquals(actualIndex, expectedIndex);  
	}
	
	
	
	@Test
	public void testRecursiveSearchCornerCases() {
		
		int[] arr = { 3, 5, 7, 8, 11, 19, 20}; 
		int key = 20; 
		int actualIndex = BinarySearch.recursiveSearch(arr, key); 
		int expectedIndex = 6 ; 
		assertEquals(actualIndex, expectedIndex); 
		
		key = 3; 
		actualIndex = BinarySearch.recursiveSearch(arr, key);  
		expectedIndex = 0 ;
		assertEquals(actualIndex, expectedIndex);  
	}
	
	
	@Test
	public void testRecursiveSearchBaseCases() {
		
		int[] arr = { 3, 5, 7, 8, 11, 19, 20}; 
		int key = 7; 
		int actualIndex = BinarySearch.recursiveSearch(arr, key); 
		int expectedIndex = 2 ; 
		assertEquals(actualIndex, expectedIndex); 
		
		key = 8; 
		actualIndex = BinarySearch.recursiveSearch(arr, key);  
		expectedIndex = 3 ;
		assertEquals(actualIndex, expectedIndex);  
	}
	
	
	
}
