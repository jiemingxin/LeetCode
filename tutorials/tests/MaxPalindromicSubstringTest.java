package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.strings.MaxPalindromicSubstring;

public class MaxPalindromicSubstringTest {

	//@Test
	public void testFindMaxPalindrome() {
		fail("Not yet implemented");
	}

	@Test
	public void testPreProcess() {
		
		String source ="abc" ; 
		String expected = "#a#b#c#" ; 
		String actual   = MaxPalindromicSubstring.preProcess(source);
		assertEquals(expected,actual); 
		
		source ="ab" ; 
		expected = "#a#b#" ; 
		actual   = MaxPalindromicSubstring.preProcess(source);
		assertEquals(expected,actual); 
		
		source ="a" ; 
		expected = "#a#" ; 
		actual   = MaxPalindromicSubstring.preProcess(source);
		assertEquals(expected,actual); 
		
		source ="abcde" ; 
		expected = "#a#b#c#d#e#" ; 
		actual   = MaxPalindromicSubstring.preProcess(source);
		assertEquals(expected,actual); 
		
	}
	

}
