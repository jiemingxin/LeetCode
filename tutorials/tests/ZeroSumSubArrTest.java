package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.array.ZeroSumSubArr;
import tutorials.utils._;

public class ZeroSumSubArrTest {

	@Test
	public void testFindZeroSumSubArrCase1() {
		
		int[] arr = {4, 2, -3, 1, 6} ; 

		_<Integer> begin = new _<Integer>(); 
		_<Integer> end   = new _<Integer>(); 		
		boolean exists = ZeroSumSubArr.findZeroSumSubArr(arr, begin, end); 
		boolean expected = true; 
		
		assertEquals(exists, expected);
		assertEquals(begin.value().intValue(), 1);
		assertEquals(end.value().intValue(), 3); 
	}
	
	
	
	
	@Test
	public void testFindZeroSumSubArrCase2() {
		
		int[] arr = {4, 2, 0, 1, 6}; 

		_<Integer> begin = new _<Integer>(); 
		_<Integer> end   = new _<Integer>(); 		
		boolean exists = ZeroSumSubArr.findZeroSumSubArr(arr, begin, end); 
		boolean expected = true; 
		
		assertEquals(exists, expected);
		assertEquals(begin.value().intValue(), 2);
		assertEquals(end.value().intValue(), 2); 
	}
	
	
	
	@Test
	public void testFindZeroSumSubArrCase3() {
		
		int[] arr = {-3, 2, 3, 1, 6}; 

		_<Integer> begin = new _<Integer>(); 
		_<Integer> end   = new _<Integer>(); 		
		boolean exists = ZeroSumSubArr.findZeroSumSubArr(arr, begin, end); 
		boolean expected = false; 
		
		assertEquals(exists, expected);
	}
	
	
	
	@Test
	public void testFindZeroSumSubArrCase4() {
		
		int[] arr = {-1, -2, -3, 1, 5}; 

		_<Integer> begin = new _<Integer>(); 
		_<Integer> end   = new _<Integer>(); 		
		boolean exists = ZeroSumSubArr.findZeroSumSubArr(arr, begin, end); 
		boolean expected = true; 
		
		assertEquals(exists, expected);
		assertEquals(begin.value().intValue(), 0);
		assertEquals(end.value().intValue(), 4); 
	}
	
	
}
