package tutorials.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;
import tutorials.array.SortedArrayIntersection ; 


public class SortedArrayIntersectionTest {

	
	@Test
	public void testFindIntersectionsCase1() {
		
		int[] A = { 1, 2, 3, 4, 5, 6, 7 }; 
		int[] B = {1, 3, 5, 7}; 
			
		ArrayList<Integer> actual = SortedArrayIntersection.findIntersections(A, B); 
		ArrayList<Integer> expected = SortedArrayIntersection.findIntersectionsPairwiseScan(A,B); 

		Collections.sort(actual);
		Collections.sort(expected);  
		
		assertTrue(actual.equals(expected)); 
	}
	
	
	
	@Test
	public void testFindIntersectionsCase2() {
		
		int[] A = { 1, 2, 3, 4, 5, 6, 7 }; 
		int[] B = { 2, 3}; 
		
		
		ArrayList<Integer> actual = SortedArrayIntersection.findIntersections(A, B); 
		ArrayList<Integer> expected = SortedArrayIntersection.findIntersectionsPairwiseScan(A,B); 

		Collections.sort(actual);
		Collections.sort(expected);  
		
		assertTrue(actual.equals(expected)); 
	}
	
	
	@Test
	public void testFindIntersectionsCase3() {
		
		int[] A = { 1, 2, 3, 4, 5, 6, 7 }; 
		int[] B = { 8 }; 
		
		
		ArrayList<Integer> actual = SortedArrayIntersection.findIntersections(A, B); 
		ArrayList<Integer> expected = SortedArrayIntersection.findIntersectionsPairwiseScan(A,B); 

		Collections.sort(actual);
		Collections.sort(expected);  
		
		assertTrue(actual.equals(expected)); 
	}
	
	
	
	@Test
	public void testFindIntersectionsCase4() {
		
		int[] A = { 1, 2, 3, 4, 5, 6, 7 }; 
		int[] B = { -1, 4, 7 }; 
		
		
		ArrayList<Integer> actual = SortedArrayIntersection.findIntersections(A, B); 
		ArrayList<Integer> expected = SortedArrayIntersection.findIntersectionsPairwiseScan(A,B); 

		Collections.sort(actual);
		Collections.sort(expected);  
		
		assertTrue(actual.equals(expected)); 
	}
	
	
	
	@Test
	public void testFindIntersectionsCase5() {
		
		int[] A = { 1, 2, 3, 4, 5, 6, 7 }; 
		int[] B = { 1, 2, 3, 4, 5, 6, 7 }; 
		
		
		ArrayList<Integer> actual = SortedArrayIntersection.findIntersections(A, B); 
		ArrayList<Integer> expected = SortedArrayIntersection.findIntersectionsPairwiseScan(A,B); 

		Collections.sort(actual);
		Collections.sort(expected);  
		
		assertTrue(actual.equals(expected)); 
	}
	
	
	
	

}
