package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.strings.MaxPalindromicSubstring;

public class MaxPalindromicSubstringTest {

	@Test
	public void testNaiveSearchCase1() {
		
		String source = "abba" ; 
		String actual = MaxPalindromicSubstring.naiveSearch(source); 
		String expected = "abba" ; 	
		assertEquals(actual, expected); 
	}

	
	@Test
	public void testNaiveSearchCase2() {
		
		String source = "ababa" ; 
		String actual = MaxPalindromicSubstring.naiveSearch(source); 
		String expected = "ababa" ; 	
		assertEquals(actual, expected); 
	}
	
	
	
	@Test
	public void testNaiveSearchCase3() {
		
		String source = "abcdef" ; 
		String actual = MaxPalindromicSubstring.naiveSearch(source); 
		String expected = "a" ; 	
		assertEquals(actual.length(), expected.length()); 
	}
	
	
	
	@Test
	public void testNaiveSearchCase4() {
		
		String source = "a" ; 
		String actual = MaxPalindromicSubstring.naiveSearch(source); 
		String expected = "a" ; 	
		assertEquals(actual.length(), expected.length()); 
	}
	
	
	
	@Test
	public void testDPSearchCase1() {
		
		String source = "abba" ; 
		String actual = MaxPalindromicSubstring.dpSearch(source); 
		String expected = "abba" ; 	
		assertEquals(actual, expected); 
	}
	
	
	@Test
	public void testDPSearchCase2() {
		
		String source = "ababa" ; 
		String actual = MaxPalindromicSubstring.dpSearch(source); 
		String expected = "ababa" ; 	
		assertEquals(actual, expected); 
	}
	
	
	
	@Test
	public void testDPSearchCase3() {
		
		String source = "abcdef" ; 
		String actual = MaxPalindromicSubstring.dpSearch(source); 
		String expected = "a" ; 	
		assertEquals(actual.length(), expected.length()); 
	}
	
	
	
	@Test
	public void testDPSearchCase4() {
		
		String source = "a" ; 
		String actual = MaxPalindromicSubstring.dpSearch(source); 
		String expected = "a" ; 	
		assertEquals(actual.length(), expected.length()); 
	}
	
	
	
}
