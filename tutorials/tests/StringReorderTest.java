package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.strings.StringReorder;

public class StringReorderTest {

	@Test
	public void testReorderString() {
		
		String source = "abb" ; 
		int dist = 2 ; 
		String reordered = StringReorder.reorderString(source, dist); 
		System.out.println(reordered); 		
	}

}
