package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.bitwise.MagicNumber;

public class MagicNumberTest {

	// 5, 25, 30(5+25), 125, 130(125+5) 
	
	@Test
	public void testNthNumber() {
		
		assertEquals(5, MagicNumber.nthNumber(1)); 
		assertEquals(25, MagicNumber.nthNumber(2)); 
		assertEquals(30, MagicNumber.nthNumber(3)); 
		assertEquals(125, MagicNumber.nthNumber(4)); 
		assertEquals(130, MagicNumber.nthNumber(5)); 
	}

}
