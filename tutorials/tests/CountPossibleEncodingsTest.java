package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.strings.CountPossibleEncodings;

public class CountPossibleEncodingsTest {

	@Test
	public void testCountEncodings() {
		
		String digits = "121" ; 
		int expected = 3; 
		int actual = CountPossibleEncodings.countEncodingsRecursive(digits);
		assertEquals(expected, actual); 
		
		digits = "1234" ; 
		expected = 3; 
		actual = CountPossibleEncodings.countEncodingsRecursive(digits);
		assertEquals(expected, actual); 
		
		digits = "34" ; 
		expected = 1; 
		actual = CountPossibleEncodings.countEncodingsRecursive(digits);
		assertEquals(expected, actual); 
		
		digits = "345" ; 
		expected = 1; 
		actual = CountPossibleEncodings.countEncodingsRecursive(digits);
		assertEquals(expected, actual); 
		
		
		digits = "24567" ; 
		expected = 2; 
		actual = CountPossibleEncodings.countEncodingsRecursive(digits);
		assertEquals(expected, actual); 
		
		digits = "101" ; 
		expected = 1; 
		actual = CountPossibleEncodings.countEncodingsRecursive(digits);
		assertEquals(expected, actual); 
		
		
	}

}
