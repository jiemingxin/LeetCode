package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.string.RotatedPalindrome;

public class RotatedPalindromeTest {

	@Test
	public void testIsRotatedPalindromeCase1() {
		
		String source = "aab" ; 
		boolean expected = true; 
		boolean actual  = RotatedPalindrome.isRotatedPalindrome(source); 
		assertEquals(expected, actual); 
		
	}

}
