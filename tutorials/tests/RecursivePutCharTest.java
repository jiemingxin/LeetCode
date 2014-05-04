package tutorials.tests;

import org.junit.Test;

import tutorials.strings.RecursivePutChar;

public class RecursivePutCharTest {

	@Test
	public void testPutLong() {
		
		//long number = 101111100000001L ; 
		long number = 121; 
		RecursivePutChar.putLong(number); 
	}

}
