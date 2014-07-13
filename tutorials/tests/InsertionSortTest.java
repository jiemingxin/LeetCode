package tutorials.tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import tutorials.sorting.InsertionSort;

public class InsertionSortTest {

	@Test
	public void testSortRandom() {
		
		int data[] = { 3, 7, 4, 9, 5, 2, 6, 1 } ; 
		int sorted[] = { 1, 2, 3, 4, 5, 6, 7, 9 } ; 
		
		String expected = Arrays.toString(sorted); 
		InsertionSort.sort(data); 
		String actual   = Arrays.toString(data); 
		
		assertEquals(expected, actual); 
	}
	
	
	@Test
	public void testSortSorted() {
		
		int data[]   = { 1, 2, 3, 4, 5, 6, 7, 9 } ; 
		int sorted[] = { 1, 2, 3, 4, 5, 6, 7, 9 } ; 
		
		String expected = Arrays.toString(sorted); 
		InsertionSort.sort(data); 
		String actual   = Arrays.toString(data); 
		
		assertEquals(expected, actual); 
	}
	
	
	
	@Test
	public void testSortReversedSorted() {
		
		int data[]   = { 9, 7, 6, 5, 4, 3, 2, 1 } ; 
		int sorted[] = { 1, 2, 3, 4, 5, 6, 7, 9 } ; 
		
		String expected = Arrays.toString(sorted); 
		InsertionSort.sort(data); 
		String actual   = Arrays.toString(data); 
		
		assertEquals(expected, actual); 
	}
	
	
	
	

}
