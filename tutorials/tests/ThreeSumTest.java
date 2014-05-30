package tutorials.tests;

import static org.junit.Assert.assertTrue;
import java.util.Set;
import org.junit.Test;
import tutorials.array.ThreeSum;

public class ThreeSumTest {
	
	@Test
	public void testSearchTripletsNotFound() {
		
		int[] arr = { 1, 2, 3, 5, 5, 5, 6, 7, 10 }; 
		int sum = 0; 
		
		Set<Set<Integer>> actual = ThreeSum.searchTriplets(arr, sum);  	 
		assertTrue( actual.isEmpty()); 
	}
	
	

	@Test
	public void testSearchTripletsCase1() {

		int[] arr = { 1, 2, 3, 5, 5, 5, 6, 7, 10 }; 
		int sum = 15; 
		
		Set<Set<Integer>> expected = ThreeSum.bruteforceSearch(arr, sum); 
		Set<Set<Integer>> actual = ThreeSum.searchTriplets(arr, sum);  	 
		assertTrue( actual.equals(expected) ); 
	}
	
	
	
	
	@Test
	public void testSearchTripletsCase2() {

		int[] arr =  {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6}; 
		int sum = 0; 		
		Set<Set<Integer>> expected = ThreeSum.bruteforceSearch(arr, sum);  
		Set<Set<Integer>> actual = ThreeSum.searchTriplets(arr, sum);  	 
		assertTrue( actual.equals(expected) ); 
	}
	

}
