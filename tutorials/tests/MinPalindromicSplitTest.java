package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.strings.MinPalindromicSplit;

public class MinPalindromicSplitTest {

	@Test
	public void testGetMinSplitsCase1() {
		
		String source =  "abbab" ; 
		int actualMinSplits = MinPalindromicSplit.getMinSplits(source); 
		int expectedMinSplits = 1 ; 
		assertEquals(actualMinSplits, expectedMinSplits); 
	}
	
	
	@Test
	public void testGetMinSplitsCase2() {
		
		String source =  "abba" ; 
		int actualMinSplits = MinPalindromicSplit.getMinSplits(source); 
		int expectedMinSplits = 0 ; 
		assertEquals(actualMinSplits, expectedMinSplits); 
	}
	
	
	@Test
	public void testGetMinSplitsCase3() {
		
		String source =  "abc" ; 
		int actualMinSplits = MinPalindromicSplit.getMinSplits(source); 
		int expectedMinSplits = 2 ; 
		assertEquals(actualMinSplits, expectedMinSplits); 
	}
	
	
	@Test
	public void testGetMinSplitsCase4() {
		
		String source =  "a" ; 
		int actualMinSplits = MinPalindromicSplit.getMinSplits(source); 
		int expectedMinSplits = 0 ; 
		assertEquals(actualMinSplits, expectedMinSplits); 
	}
	
	

}
