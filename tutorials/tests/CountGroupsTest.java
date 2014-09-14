package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.array.CountGroups;

public class CountGroupsTest {

	@Test
	public void testCount() {
		
		int arr[] = {3, 6, 7, 2, 9};
		int actual =8; 
		int expected = CountGroups.count(arr); 
		assertEquals(expected, actual); 

		int arr2[] = {2, 1, 3, 4};
		actual = 4; 
		expected = CountGroups.count(arr2); 
		assertEquals(expected, actual); 
	}

}
