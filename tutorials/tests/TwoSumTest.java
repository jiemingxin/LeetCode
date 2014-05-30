package tutorials.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import tutorials.array.TwoSum;

public class TwoSumTest {

	
	@Test
	public void testSearchPairsNullCase() {

		int[] arr = { 1, 2, 3, 5, 5, 5, 6, 7, 10 }; 
		int sum = 14; 
		
		Set<Set<Integer>> actual = TwoSum.searchPairs(arr, sum);  	 
		assertTrue( actual.isEmpty()); 
	}
	

	@Test
	public void testSearchPairsCase1() {

		int[] arr = { 1, 2, 3, 5, 5, 5, 6, 7, 10 }; 
		int sum = 10; 
		
		Set<Set<Integer>> expected = new HashSet<Set<Integer>>();
		expected.add( new HashSet<Integer>(Arrays.asList(3,7)));
		
		// NOTE that duplicated elements will be removed. This however
		// does not affect the comparison 
		expected.add( new HashSet<Integer>(Arrays.asList(5,5)));
		
		Set<Set<Integer>> actual = TwoSum.searchPairs(arr, sum);  	 
		assertTrue( actual.equals(expected) ); 
	}


	
	@Test
	public void testSearchPairsCase2() {

		int[] arr = { 1, 2, 3, 5, 5, 5, 6, 7, 10 }; 
		int sum = 13; 
		
		Set<Set<Integer>> expected = new HashSet<Set<Integer>>();
		expected.add( new HashSet<Integer>(Arrays.asList(3,10)));
		expected.add( new HashSet<Integer>(Arrays.asList(6,7)));
		
		Set<Set<Integer>> actual = TwoSum.searchPairs(arr, sum);  	 
		assertTrue( actual.equals(expected) ); 
	}
	
	
	
	@Test
	public void testSearchPairsCase3() {

		int[] arr = { 1, 2, 3, 5, 5, 5, 6, 7, 10 }; 
		int sum = 17; 
		
		Set<Set<Integer>> expected = new HashSet<Set<Integer>>();
		expected.add( new HashSet<Integer>(Arrays.asList(7,10)));
		
		Set<Set<Integer>> actual = TwoSum.searchPairs(arr, sum);  	 
		assertTrue( actual.equals(expected) ); 
	}
	
	
	
	
}
