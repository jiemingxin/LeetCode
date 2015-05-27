package tutorials.tests;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import tutorials.sorting.SelectionSort;

public class SelectionSortTest {

	@Test
	public void testSortIntArray() {
		
		int min=-10, max=10, arrLen=5, range=max-min+1;
		
		for(int k=0; k<20; k++){
			
			Random rand = new Random();
			int[] arr = new int[arrLen]; 
			for(int i=0; i<arrLen; i++)
				arr[i] = rand.nextInt() % range + min;
			
			int[] copy = Arrays.copyOf(arr,arrLen);
			Arrays.sort(copy);
			SelectionSort.sort(arr);
			
			assertArrayEquals(copy, arr); 
		}
	}
}
