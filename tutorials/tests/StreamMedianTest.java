package tutorials.tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Test;
import tutorials.stream.StreamMedian;


public class StreamMedianTest {

	//@Test
	public void testComputeMedianUsingInsertionSort() {
		
		int[] dataStream = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; 
		int streamLength = dataStream.length ; 
		int[] dataBuffer = new int[streamLength]; 
		float[] medians  = new float[streamLength]; 
		StreamMedian.computeMedianUsingInsertionSort(dataStream, dataBuffer, medians); 
		
		System.out.println(Arrays.toString(dataBuffer)); 
		System.out.println(Arrays.toString(medians)); 
	}
	
	
	
	@Test
	public void testComputeMedianUsingMinMaxHeaps() {
		
		int[] dataStream = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; 
		int streamLength = dataStream.length ; 
		float[] medians  = new float[streamLength]; 
		
		StreamMedian.computeMedianUsingMinMaxHeaps(dataStream, medians); 
		System.out.println(Arrays.toString(medians)); 
	}
	
	
	

}
