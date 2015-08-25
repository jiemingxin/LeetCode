package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.array.LongestConsecutivePath;

public class LongestConsecutivePathTest {

	@Test
	public void testGetLongestPathLengthCharArrayArrayCharCase1() {
		
		char[][] matrix = { {'a', 'c', 'd'},
               				{'h', 'b', 'e'},
               				{'i', 'g', 'f'}}; 
		
		int actual = LongestConsecutivePath.getLongestPathLength(matrix, 'e'); 
		int expected = 5; 
		
		assertEquals(expected, actual); 
	}

	
	@Test
	public void testGetLongestPathLengthCharArrayArrayCharCase2() {
		
		char[][] matrix = { {'b', 'e', 'f'},
               				{'h', 'd', 'a'},
               				{'i', 'c', 'a'}}; 
				
		int actual = LongestConsecutivePath.getLongestPathLength(matrix, 'b'); 
		int expected = 1; 
		
		assertEquals(expected, actual); 
	}
	
	
}
