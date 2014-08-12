package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.array.NextGreatNumber;

public class NextGreatNumberTest {

	@Test
	public void testFindNext() {
		
		String number   = "218765" ; 
		String actual = NextGreatNumber.findNext(number); 
		String expected	= "251678" ;
		assertEquals(actual, expected); 
		
		number   = "1234" ;  
		actual = NextGreatNumber.findNext(number);
		expected = "1243" ; 
		assertEquals(actual, expected);  
		
		number   = "4321" ;  
		actual = NextGreatNumber.findNext(number);
		expected = "N/A" ; 
		assertEquals(actual, expected);  		
		
		number   = "534976" ;  
		actual = NextGreatNumber.findNext(number);
		expected = "536479" ; 
		assertEquals(actual, expected);  
	}

}
