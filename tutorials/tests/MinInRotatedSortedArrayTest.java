package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.array.MinInRotatedSortedArray;

public class MinInRotatedSortedArrayTest {

	@Test
	public void testFindMinIntArrayCase1() {
		  int arr[] =  {5, 6, 1, 2, 3, 4};
		  int expectedMin = 1; 
		  int actualMin = MinInRotatedSortedArray.findMin(arr); 
		  assertEquals(expectedMin, actualMin); 
	}

	
	
	@Test
	public void testFindMinIntArrayCase2() {
		  int arr[] =  {1, 2};
		  int expectedMin = 1; 
		  int actualMin = MinInRotatedSortedArray.findMin(arr); 
		  assertEquals(expectedMin, actualMin); 
	}
	
	
	
	@Test
	public void testFindMinIntArrayCase3() {
		  int arr[] =  {2, 1};
		  int expectedMin = 1; 
		  int actualMin = MinInRotatedSortedArray.findMin(arr); 
		  assertEquals(expectedMin, actualMin); 
	}
	
	
	
	@Test
	public void testFindMinIntArrayCase4() {
		  int arr[] =  {1};
		  int expectedMin = 1; 
		  int actualMin = MinInRotatedSortedArray.findMin(arr); 
		  assertEquals(expectedMin, actualMin); 
	}
	
	
	@Test
	public void testFindMinIntArrayCase5() {
		  int arr[] =  {3, 4, 5, 1, 2};
		  int expectedMin = 1; 
		  int actualMin = MinInRotatedSortedArray.findMin(arr); 
		  assertEquals(expectedMin, actualMin); 
	}
	
	
	
	@Test
	public void testFindMinIntArrayCase6() {
		  int arr[] =  {3, 4, 5, 1, 2};
		  int expectedMin = 1; 
		  int actualMin = MinInRotatedSortedArray.findMin(arr); 
		  assertEquals(expectedMin, actualMin); 
	}
	
	
	@Test
	public void testFindMinIntArrayCase7() {
		  int arr[] =  {2, 3, 4, 5, 6, 7, 8, 1};
		  int expectedMin = 1; 
		  int actualMin = MinInRotatedSortedArray.findMin(arr); 
		  assertEquals(expectedMin, actualMin); 
	}
	
	
	@Test
	public void testFindMinIntArrayCase8() {
		  int arr[] =   {3, 4, 5, 1, 2};
		  int expectedMin = 1; 
		  int actualMin = MinInRotatedSortedArray.findMin(arr); 
		  assertEquals(expectedMin, actualMin); 
	}
	
	
	 
	
	@Test
	public void testFindMinIntArrayCase9() {
		  int arr[] =   {2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 1, 2};
		  int expectedMin = 0; 
		  int actualMin = MinInRotatedSortedArray.findMin(arr); 
		  assertEquals(expectedMin, actualMin); 
	}
	
	
	@Test
	public void testFindMinIntArrayCase10() {
		  int arr[] =   {2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2};
		  int expectedMin = 0; 
		  int actualMin = MinInRotatedSortedArray.findMin(arr); 
		  assertEquals(expectedMin, actualMin); 
	}
	
	
	
	
	
	
}
