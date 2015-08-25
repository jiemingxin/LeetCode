package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.strings.StringTransform;

public class StringTransformTest {

	@Test
	public void testGetMinOPerations() {
		
		String source = "EACBD" ;
		String dest   = "EABCD" ;
		
		int actual = StringTransform.getMinOPerations(source, dest); 
		int expected = 3; 
		
		assertEquals(expected, actual); 
	}

}
