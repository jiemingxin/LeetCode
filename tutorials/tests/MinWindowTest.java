package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.strings.MinWindow;
import tutorials.utils._;

public class MinWindowTest {

	
	@Test
	public void testLocateMinWindowNegativeCase() {
		
		String source   = "ABC"; 
		String charSet  = "CED"; 
			
		_<Integer> minWinBegin = new _<Integer>(); 
		_<Integer> minWinEnd  = new _<Integer>(); 
		
		boolean found = MinWindow.locateMinWindow(source, charSet, minWinBegin, minWinEnd); 
		assertFalse(found); 		
	}
	
	
	
	@Test
	public void testLocateMinWindowSameString() {
		
		String source   = "ABCDEFGHIJ"; 
		String charSet  = source ; 
			
		_<Integer> minWinBegin = new _<Integer>(); 
		_<Integer> minWinEnd  = new _<Integer>(); 
		
		boolean found = MinWindow.locateMinWindow(source, charSet, minWinBegin, minWinEnd); 
		assertTrue(found);
		
	}
	
	
	
	@Test
	public void testLocateMinWindowPositiveCase1() {
		
		String source   = "adobecodebancbbcaa"; 
		String charSet  = "abc" ; 
			
		_<Integer> minWinBegin = new _<Integer>(); 
		_<Integer> minWinEnd  = new _<Integer>(); 
		
		boolean found = MinWindow.locateMinWindow(source, charSet, minWinBegin, minWinEnd); 
		assertTrue(found);
		assertEquals(minWinBegin.value().intValue(), 14);
		assertEquals(minWinEnd.value().intValue(), 16); 
	}
	
	
	
	@Test
	public void testLocateMinWindowPositiveCase2() {
		
		String source   = "acbdbaab"; 
		String charSet  = "aabd" ; 
			
		_<Integer> minWinBegin = new _<Integer>(); 
		_<Integer> minWinEnd  = new _<Integer>(); 
		
		boolean found = MinWindow.locateMinWindow(source, charSet, minWinBegin, minWinEnd); 
		assertTrue(found);
		assertEquals(minWinBegin.value().intValue(), 3);
		assertEquals(minWinEnd.value().intValue(),   6); 
	}
	
	
	
	@Test
	public void testLocateMinWindowPositiveCase3() {
		
		String source   = "adobecodebanc"; 
		String charSet  = "abc" ; 
			
		_<Integer> minWinBegin = new _<Integer>(); 
		_<Integer> minWinEnd  = new _<Integer>(); 
		
		boolean found = MinWindow.locateMinWindow(source, charSet, minWinBegin, minWinEnd); 
		assertTrue(found);
		assertEquals(minWinBegin.value().intValue(), 9);
		assertEquals(minWinEnd.value().intValue(),   12); 
	}

	
	
	
	@Test
	public void testLocateMinWindowPositiveCase4() {
		
		String source   = "adobecodebanc"; 
		String charSet  = "abcda" ; 
			
		_<Integer> minWinBegin = new _<Integer>(); 
		_<Integer> minWinEnd  = new _<Integer>(); 
		
		boolean found = MinWindow.locateMinWindow(source, charSet, minWinBegin, minWinEnd); 
		assertTrue(found);
		assertEquals(minWinBegin.value().intValue(), 0);
		assertEquals(minWinEnd.value().intValue(),   10); 
	}
	
	
	
	
	
	
}
