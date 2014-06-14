package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.array.CountOccurInSortedArray;

public class CountOccurInSortedArrayTest {

	@Test
	public void testCountOccurrenceCase1() {
		
		int arr[] = {1, 1, 2, 2, 2, 2, 3};
		int num   = 2;
		
		int actual    = CountOccurInSortedArray.countOccurrence(arr, num); 
		int expected = 4 ; 
		assertEquals(actual, expected); 
	}
	
	
	
	@Test
	public void testCountOccurrenceCase2() {
		
		int arr[] = {1, 1, 2, 2, 2, 2, 3};
		int num   = 3;
		
		int actual    = CountOccurInSortedArray.countOccurrence(arr, num); 
		int expected = 1 ; 
		assertEquals(actual, expected); 
	}
	
	
	
	@Test
	public void testCountOccurrenceCase3() {
		
		int arr[] = {1, 1, 2, 2, 2, 2, 3};
		int num   = 1;
		
		int actual    = CountOccurInSortedArray.countOccurrence(arr, num); 
		int expected = 2 ; 
		assertEquals(actual, expected); 
	}
	
	
	
	
	@Test
	public void testCountOccurrenceCase4() {
		
		int arr[] = {1, 1, 2, 2, 2, 2, 3};
		int num   = 4;
		
		int actual    = CountOccurInSortedArray.countOccurrence(arr, num); 
		int expected = -1 ; 
		assertEquals(actual, expected); 
	}
	
	
	

}
