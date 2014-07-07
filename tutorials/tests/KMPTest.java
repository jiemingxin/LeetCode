package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.strings.KMP;

public class KMPTest {

	
	@Test
	public void testFindString() {
		String text = "abcdefgh" ; 
		String pattern = "def" ; 
		int expected  = 3 ; 
		int actual = KMP.findString(text, pattern);
		assertEquals(expected,actual); 
		
		text = "abcdefgh" ; 
		pattern = "abe" ; 
		expected  = -1 ; 
		actual = KMP.findString(text, pattern);
		assertEquals(expected,actual); 
		
		text = "abcdefgh" ; 
		pattern = "gh" ; 
		expected  = 6 ; 
		actual = KMP.findString(text, pattern);
		assertEquals(expected,actual); 
		
		text = "aaaaaaab" ; 
		pattern = "ab" ; 
		expected  = 6 ; 
		actual = KMP.findString(text, pattern);
		assertEquals(expected,actual); 
		
		
	}

	
	
	
	
	
}
