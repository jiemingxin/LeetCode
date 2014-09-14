package tutorials.tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import tutorials.array.DistinctPairs;

public class DistinctPairsTest {

	@Test
	public void testRemoveDuplicates(){
		
		int[] arr1 = { 1,1,1,1,1,1}; 
		int[] expected = {1}; 
		int[] actual = DistinctPairs.removeDuplicates(arr1); 
		assertTrue(Arrays.equals(expected, actual)); 
		
		
		int[] arr2 = { 2,2,3,3,4,4,5}; 
		int[] expected2 = {2,3,4,5}; 
		int[] actual2 = DistinctPairs.removeDuplicates(arr2); 
		assertTrue(Arrays.equals(expected2, actual2)); 

		
		
		int[] arr3 = { 1,5,5,6,7,7,7,7}; 
		int[] expected3 = {1,5,6,7}; 
		int[] actual3 = DistinctPairs.removeDuplicates(arr3); 
		assertTrue(Arrays.equals(expected3, actual3)); 
		
		
		
		
	}
	
	
	
	@Test
	public void testCountCase1() {
		
		int[] arr = {1, 5, 3, 4, 2};
		int diff=3; 
		int expected =2; 
		int actual = DistinctPairs.count(arr,diff); 
		assertEquals(expected, actual); 
	}
	
	
	@Test
	public void testCountCase2() {
		
		int[] arr = {8, 12, 16, 4, 0, 20};
		int diff=4; 
		int expected =5; 
		int actual = DistinctPairs.count(arr,diff); 
		assertEquals(expected, actual); 
	}
	
	
	


}
