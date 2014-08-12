package tutorials.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tutorials.array.FloorInSortedArray;

public class FloorInSortedArrayTest {

	@Test
	public void testFindFloorCase1() {
		  int arr[] =  {1, 2, 3, 4, 6};
		  int val = 1; 
		  int expected = 0; 
		  int actual   = FloorInSortedArray.findFloor(arr, val); 
		  assertEquals(expected, actual); 
	}
	
	
	@Test
	public void testFindFloorCase2() {
		  int arr[] =  {1, 2, 3, 4, 6};
		  int val = 2; 
		  int expected = 1; 
		  int actual   = FloorInSortedArray.findFloor(arr, val); 
		  assertEquals(expected, actual); 
	}
	
	
	@Test
	public void testFindFloorCase3() {
		  int arr[] =  {1, 2, 3, 4, 6};
		  int val = 6; 
		  int expected = 4; 
		  int actual   = FloorInSortedArray.findFloor(arr, val); 
		  assertEquals(expected, actual); 
	}
	
	
	@Test
	public void testFindFloorCase4() {
		  int arr[] =  {1, 2};
		  int val = 2; 
		  int expected = 1; 
		  int actual   = FloorInSortedArray.findFloor(arr, val); 
		  assertEquals(expected, actual); 
	}
	
	
	@Test
	public void testFindFloorCase5() {
		  int arr[] =  {1, 2};
		  int val = 3; 
		  int expected = 1; 
		  int actual   = FloorInSortedArray.findFloor(arr, val); 
		  assertEquals(expected, actual); 
	}
	
	
	
	@Test
	public void testFindFloorCase6() {
		  int arr[] =  {1, 2};
		  int val = 0; 
		  int expected = -1; 
		  int actual   = FloorInSortedArray.findFloor(arr, val); 
		  assertEquals(expected, actual); 
	}
	
	
	@Test
	public void testFindFloorNeatCase1() {
		  int arr[] =  {1, 2, 3, 4, 6};
		  int val = 1; 
		  int expected = 0; 
		  int actual   = FloorInSortedArray.findFloorNeat(arr, val); 
		  assertEquals(expected, actual); 
	}
	
	
	@Test
	public void testFindFloorNeatCase2() {
		  int arr[] =  {1, 2, 3, 4, 6};
		  int val = 2; 
		  int expected = 1; 
		  int actual   = FloorInSortedArray.findFloorNeat(arr, val); 
		  assertEquals(expected, actual); 
	}
	
	
	@Test
	public void testFindFloorNeatCase3() {
		  int arr[] =  {1, 2, 3, 4, 6};
		  int val = 6; 
		  int expected = 4; 
		  int actual   = FloorInSortedArray.findFloorNeat(arr, val); 
		  assertEquals(expected, actual); 
	}
	
	
	@Test
	public void testFindFloorNeatCase4() {
		  int arr[] =  {1, 2};
		  int val = 2; 
		  int expected = 1; 
		  int actual   = FloorInSortedArray.findFloorNeat(arr, val); 
		  assertEquals(expected, actual); 
	}
	
	
	@Test
	public void testFindFloorNeatCase5() {
		  int arr[] =  {1, 2};
		  int val = 3; 
		  int expected = 1; 
		  int actual   = FloorInSortedArray.findFloorNeat(arr, val); 
		  assertEquals(expected, actual); 
	}
	
	
	
	@Test
	public void testFindFloorNeatCase6() {
		  int arr[] =  {1, 2};
		  int val = 0; 
		  int expected = -1; 
		  int actual   = FloorInSortedArray.findFloorNeat(arr, val); 
		  assertEquals(expected, actual); 
	}
	
	

}
