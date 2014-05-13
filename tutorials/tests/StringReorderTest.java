package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.strings.StringReorder;

public class StringReorderTest {

	@Test
	public void testReorderStringCase1() {
		
		String source = "abb" ; 
		int dist = 2 ; 
		String reordered = StringReorder.reorderString(source, dist); 
		System.out.println(reordered); 		
	}
	
	
	
	@Test
	public void testReorderStringCase2() {
		
		String source = "bbaaaccdd" ; 
		int dist = 3 ; 
		String reordered = StringReorder.reorderString(source, dist); 
		System.out.println(reordered); 		
	}
	
	
	

}
