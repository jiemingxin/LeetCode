package tutorials.tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import tutorials.array.ArrayRightShift;

public class ArrayRightShiftTest {

	
	
	@Test
	public void testShiftRightOneShift() {
		
		int[] arr     = {1,2,3,4,5,6,7};  
		int[] shifted = {7,1,2,3,4,5,6}; 
		int nShifts   = 1;  
		
		ArrayRightShift.shiftRight(arr, nShifts); 
		String actual   = Arrays.toString(arr); 
		String expected = Arrays.toString(shifted); 
		assertEquals(actual, expected); 
	}
	
	
	
	@Test
	public void testShiftRightTwoShifts() {
		
		int[] arr     = {1,2,3,4,5,6,7};  
		int[] shifted = {6,7,1,2,3,4,5}; 
		int nShifts   = 2;  
		
		ArrayRightShift.shiftRight(arr, nShifts); 
		String actual   = Arrays.toString(arr); 
		String expected = Arrays.toString(shifted); 
		assertEquals(actual, expected); 
	}
	
	
	
	@Test
	public void testShiftRightThreeShifts() {
		
		int[] arr     = {1,2,3,4,5,6,7};  
		int[] shifted = {5,6,7,1,2,3,4}; 
		int nShifts   = 3;  
		
		ArrayRightShift.shiftRight(arr, nShifts); 
		String actual   = Arrays.toString(arr); 
		String expected = Arrays.toString(shifted); 
		assertEquals(actual, expected); 
	}
	
	
	
	
	@Test
	public void testShiftRightFourShifts() {
		
		int[] arr     = {1,2,3,4,5,6,7};  
		int[] shifted = {4,5,6,7,1,2,3}; 
		int nShifts   = 4;  
		
		ArrayRightShift.shiftRight(arr, nShifts); 
		String actual   = Arrays.toString(arr); 
		String expected = Arrays.toString(shifted); 
		assertEquals(actual, expected); 
	}

	
	
	@Test
	public void testShiftRightFiveShifts() {
		
		int[] arr     = {1,2,3,4,5,6,7};  
		int[] shifted = {3,4,5,6,7,1,2}; 
		int nShifts   = 5;  
		
		ArrayRightShift.shiftRight(arr, nShifts); 
		String actual   = Arrays.toString(arr); 
		String expected = Arrays.toString(shifted); 
		assertEquals(actual, expected); 
	}
	
	

	
	@Test
	public void testShiftRightSixShifts() {
		
		int[] arr     = {1,2,3,4,5,6,7};  
		int[] shifted = {2,3,4,5,6,7,1}; 
		int nShifts   = 6;  
		
		ArrayRightShift.shiftRight(arr, nShifts); 
		String actual   = Arrays.toString(arr); 
		String expected = Arrays.toString(shifted); 
		assertEquals(actual, expected); 
	}
	
	
	@Test
	public void testShiftRightSevenShifts() {
		
		int[] arr     = {1,2,3,4,5,6,7};  
		int[] shifted = {1,2,3,4,5,6,7}; 
		int nShifts   = 7;  
		
		ArrayRightShift.shiftRight(arr, nShifts); 
		String actual   = Arrays.toString(arr); 
		String expected = Arrays.toString(shifted); 
		assertEquals(actual, expected); 
	}
	
	
	@Test
	public void testShiftRightEqualShifts() {
		
		int[] arr     = {1,2,3,4,5,6,7,8};  
		int[] shifted = {5,6,7,8,1,2,3,4}; 
		int nShifts   = 4;  
		
		ArrayRightShift.shiftRight(arr, nShifts); 
		String actual   = Arrays.toString(arr); 
		String expected = Arrays.toString(shifted); 
		assertEquals(actual, expected); 
	}
	
	
	
	
	
}
