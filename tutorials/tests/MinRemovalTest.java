package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.array.MinRemoval;

public class MinRemovalTest {

	@Test
	public void testRecursiveCompute() {
	
		int arr0[] = {4, 5, 100, 9, 10, 11, 12, 15, 200}; 
		int expected = 4; 
		int actual = MinRemoval.recursiveCompute(arr0); 
		assertEquals(expected, actual); 
		
		int arr1[] = {4, 7, 5, 6};  
		expected = 0; 
		actual = MinRemoval.recursiveCompute(arr1); 
		assertEquals(expected, actual); 
		
		int arr2[] = {20, 7, 5, 6}; 
		expected = 1; 
		actual = MinRemoval.recursiveCompute(arr2); 
		assertEquals(expected, actual); 
		
		int arr3[] = {20, 4, 1, 3}; 
		expected = 3; 
		actual = MinRemoval.recursiveCompute(arr3); 
		assertEquals(expected, actual); 
		
		int arr4[] = {20}; 
		expected = 0; 
		actual = MinRemoval.recursiveCompute(arr4); 
		assertEquals(expected, actual); 	
	}
	
	
	@Test
	public void testDPCompute() {
	
		int arr0[] = {4, 5, 100, 9, 10, 11, 12, 15, 200}; 
		int expected = 4; 
		int actual = MinRemoval.dpCompute(arr0); 
		assertEquals(expected, actual); 
		
		int arr1[] = {4, 7, 5, 6};  
		expected = 0; 
		actual = MinRemoval.dpCompute(arr1); 
		assertEquals(expected, actual); 
		
		int arr2[] = {20, 7, 5, 6}; 
		expected = 1; 
		actual = MinRemoval.dpCompute(arr2); 
		assertEquals(expected, actual); 
		
		int arr3[] = {20, 4, 1, 3}; 
		expected = 3; 
		actual = MinRemoval.dpCompute(arr3); 
		assertEquals(expected, actual); 
		
		int arr4[] = {20}; 
		expected = 0; 
		actual = MinRemoval.dpCompute(arr4); 
		assertEquals(expected, actual); 	
	}
	

	
	@Test
	public void testPairwiseCompute() {
	
		int arr0[] = {4, 5, 100, 9, 10, 11, 12, 15, 200}; 
		int expected = 4; 
		int actual = MinRemoval.pairwiseCompute(arr0); 
		assertEquals(expected, actual); 
		
		int arr1[] = {4, 7, 5, 6};  
		expected = 0; 
		actual = MinRemoval.pairwiseCompute(arr1); 
		assertEquals(expected, actual); 
		
		int arr2[] = {20, 7, 5, 6}; 
		expected = 1; 
		actual = MinRemoval.pairwiseCompute(arr2); 
		assertEquals(expected, actual); 
		
		int arr3[] = {20, 4, 1, 3}; 
		expected = 3; 
		actual = MinRemoval.pairwiseCompute(arr3); 
		assertEquals(expected, actual); 
		
		int arr4[] = {20}; 
		expected = 0; 
		actual = MinRemoval.pairwiseCompute(arr4); 
		assertEquals(expected, actual); 	
	}
	
	
	
}
