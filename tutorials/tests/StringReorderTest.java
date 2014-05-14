package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.strings.StringReorder;

public class StringReorderTest {

	
	protected static boolean isValidReorderedString(String str, int dist){
		
		int strLen = str.length(); 
		for(int i=0;  i<strLen;  i++){
			char c = str.charAt(i); 
			
			for(int j=1; j<dist; j++){	
				int offset = i +j ; 
				if( i+j >= strLen) 
					continue ; 		
				char nc = str.charAt(offset); 
				if( c == nc )
					return false ; 
			}
		}
		
		return true; 
	}
	
	
	
	@Test
	public void testReorderStringNullCase() {
		
		String source = "aaa" ; 
		int dist = 2 ; 
		String reordered = StringReorder.reorderString(source, dist); 
		assertTrue(reordered==null); 
	}
	
	
	
	@Test
	public void testReorderStringCase1() {
		
		String source = "abb" ; 
		int dist = 2 ; 
		String reordered = StringReorder.reorderString(source, dist); 
		assertTrue(isValidReorderedString(reordered, dist)); 
	}
	
	
	@Test
	public void testReorderStringCase2() {
		
		String source = "bbaaaccdd" ; 
		int dist = 3 ; 
		String reordered = StringReorder.reorderString(source, dist);  
		assertTrue(isValidReorderedString(reordered, dist));  
	}
	
	
	
	@Test
	public void testReorderStringCase3() {
		
		String source = "bbbaadeecd" ; 
		int dist = 3 ; 
		String reordered = StringReorder.reorderString(source, dist);  
		assertTrue(isValidReorderedString(reordered, dist));  
	}
	
	
	

}
