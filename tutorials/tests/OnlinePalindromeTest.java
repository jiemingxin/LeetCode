package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.strings.OnlinePalindrome;

public class OnlinePalindromeTest {

	@Test
	public void testCheckPalindromeCase1() {
			String text = "aabaacaabaa" ;
			String actual = OnlinePalindrome.checkPalindrome(text); 
			String expected = "YYNNYNNNNNY"; 
			assertEquals(expected, actual); 
	}

	
	@Test
	public void testCheckPalindromeCase2() {
			String text = "abba" ;
			String actual = OnlinePalindrome.checkPalindrome(text); 
			String expected = "YNNY"; 
			assertEquals(expected, actual); 
	}

	
	@Test
	public void testCheckPalindromeCase3() {
			String text = "abaaba" ;
			String actual = OnlinePalindrome.checkPalindrome(text); 
			String expected = "YNYNNY"; 
			assertEquals(expected, actual); 
	}
	
	
	
	@Test
	public void testCheckPalindromeCase4() {
			String text = "baacaab" ;
			String actual = OnlinePalindrome.checkPalindrome(text); 
			String expected = "YNNNNNY"; 
			assertEquals(expected, actual); 
	}

	
	
	
}
