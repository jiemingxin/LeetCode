package tutorials.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import tutorials.sorting.RadixSort;

public class RadixSortTest {

	
	@Test
	public void testSortPositiveIntArray() {
		
		int[] arr = { 802, 24, 2, 66 }; 
		int[] copy = Arrays.copyOf(arr,arr.length);
		Arrays.sort(copy);
		RadixSort.sort(arr);
		
		assertTrue(Arrays.equals(copy, arr)); 
	}
	
	
	
	@Test
	public void testSortPositiveRandomIntArray() {
		
		int min=0, max=100, arrLen=10, range=max-min+1;
		
		for(int k=0; k<20; k++){
			
			Random rand = new Random();
			int[] arr = new int[arrLen]; 
			for(int i=0; i<arrLen; i++)
				arr[i] = rand.nextInt(max) % range + min;
			
			int[] copy = Arrays.copyOf(arr,arr.length);
			Arrays.sort(copy);
			RadixSort.sort(arr);
			
			assertTrue(Arrays.equals(copy, arr)); 
		}
	}
	
	
	
	@Test
	public void testHash(){
	
		int base = 10; 
		int exp = 10; 
		int figure = 630; 
		
		int actual = 3; 
		int expected = RadixSort.hash(figure, exp, base); 
		assertEquals(expected, actual); 
		
		exp = 100 ; 
		actual = 6; 
		expected = RadixSort.hash(figure, exp, base); 
		assertEquals(expected, actual);
	}
	

}
