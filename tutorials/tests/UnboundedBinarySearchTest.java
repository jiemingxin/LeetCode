package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.array.UnboundedBinarySearch;

public class UnboundedBinarySearchTest {

	@Test
	public void testFindFirstPositive() {
		
		int index = UnboundedBinarySearch.findFirstPositive(); 
		System.out.println("Index found: " + index); 
		
		if(index>0){ 
			int prevValue = UnboundedBinarySearch.f(index-1); 
			System.out.println("Previous value :" + prevValue); 
		} 
		int currValue = UnboundedBinarySearch.f(index); 
		System.out.println("Current value :" + currValue); 
		assertTrue(currValue>0); 
	}

}
