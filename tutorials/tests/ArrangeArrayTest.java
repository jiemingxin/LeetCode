package tutorials.tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import tutorials.array.ArrangeArray;

public class ArrangeArrayTest {

	@Test
	public void testArrangeCase1() {
		
		int[] arr = {3, 2, 0, 1}; 
		int[] expected = {1, 0, 3, 2}; 
		
		ArrangeArray.arrange(arr); 
		assertTrue(Arrays.equals(expected, arr)); 
	}
	
	
	
	@Test
	public void testArrangeCase2() {
		
		int[] arr =  {4, 0, 2, 1, 3}; 
		int[] expected = {3, 4, 2, 0, 1};
		
		ArrangeArray.arrange(arr); 
		assertTrue(Arrays.equals(expected, arr)); 
	}
	
	
	@Test
	public void testArrangeCase3() {
		
		int[] arr =  {0, 1, 2, 3};  
		int[] expected = {0, 1, 2, 3};
		
		ArrangeArray.arrange(arr); 
		assertTrue(Arrays.equals(expected, arr)); 
	}
	

}
