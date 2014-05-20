package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.array.ArraySpiralPrint;

public class ArraySpiralPrintTest {

	
	@Test
	public void testPrint2DArrayEvenRowsEvenCols() {
		
		int[][] arr = { {1,2}, {3, 4} }; 
		String actual   = ArraySpiralPrint.print2DArray(arr);
		String expected = "1 2 4 3 " ; 
		assertEquals(actual, expected); 
	}

	
	@Test
	public void testPrint2DArrayOddRowsOddCols() {
		
		int[][] arr = { {1,2,3,4,5}, {7, 8,9,10,11}, {12,13,14,15,16} }; 
		String actual = ArraySpiralPrint.print2DArray(arr);
		String expected = "1 2 3 4 5 11 16 15 14 13 12 7 8 9 10 "; 
		assertEquals(actual, expected); 
	}
	
	
	@Test 
	public void testPrint2DArrayEvenRowsOddCols() {
		
		int[][] arr = { {1,2,3,4,5}, {7,8,9,10,11} }; 
		String actual = ArraySpiralPrint.print2DArray(arr);
		String expected = "1 2 3 4 5 11 10 9 8 7 "; 
		assertEquals(actual, expected); 
	}
	
	
	@Test 
	public void testPrint2DArrayOddRowsEvenCols() {
		
		int[][] arr = { {1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}, {17,18,19,20} }; 
	
		String actual = ArraySpiralPrint.print2DArray(arr);
		String expected = "1 2 3 4 8 12 16 20 19 18 17 13 9 5 6 7 11 15 14 10 "; 
		assertEquals(actual, expected); 
	}
	
	
	@Test
	public void testPrint2DArraySingleRow(){
		
		int[][] arr = { {1,2,3,4,5,6,7,8,9,10} }; 
		
		String actual = ArraySpiralPrint.print2DArray(arr);
		String expected = "1 2 3 4 5 6 7 8 9 10 "; 
		assertEquals(actual, expected); 
	}
	
	
	@Test
	public void testPrint2DArraySingleColumn(){
		
		int[][] arr = { {1},{2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10} }; 
		
		String actual = ArraySpiralPrint.print2DArray(arr);
		String expected = "1 2 3 4 5 6 7 8 9 10 "; 
		assertEquals(actual, expected); 
	}
	
	
	
	
	
}
