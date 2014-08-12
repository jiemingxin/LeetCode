package tutorials.tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import tutorials.streams.StreamMedian;

public class StreamMedianTest {

	@Test
	public void testComputeMediansUsingMinMaxHeapCase1() {
	
		int[] streamData = {1,2,3,4,5,6,7,8,9,10}; 
		float[] actualMedians  = new float[streamData.length]; 
		float[] expectedMedians = {1.0f, 1.5f, 2.0f, 2.5f, 3.0f, 3.5f, 4.0f, 4.5f, 5.0f, 5.5f}; 
		
		StreamMedian.computeMediansUsingMinMaxHeap(streamData, actualMedians); 
		assertEquals(Arrays.toString(actualMedians), Arrays.toString(expectedMedians)); 
	}
	
	
	
	@Test
	public void testComputeMediansUsingMinMaxHeapCase2() {
	
		int[] streamData = {10,9,8,7,6,5,4,3,2,1}; 
		float[] actualMedians  = new float[streamData.length]; 
		float[] expectedMedians = {10.0f, 9.5f, 9.0f, 8.5f, 8.0f, 7.5f, 7.0f, 6.5f, 6.0f, 5.5f};
		
		StreamMedian.computeMediansUsingMinMaxHeap(streamData, actualMedians); 
		assertEquals(Arrays.toString(actualMedians), Arrays.toString(expectedMedians));  
	}
	
	
	@Test
	public void testComputeMediansUsingInsertionCase1() {
	
		int[] streamData = {1,2,3,4,5,6,7,8,9,10}; 
		int[] dataBuffer = new  int[streamData.length]; 
		float[] actualMedians  = new float[streamData.length]; 
		float[] expectedMedians = {1.0f, 1.5f, 2.0f, 2.5f, 3.0f, 3.5f, 4.0f, 4.5f, 5.0f, 5.5f}; 
		
		StreamMedian.computeMediansUsingInsertionSort(streamData, dataBuffer, actualMedians); 
		assertEquals(Arrays.toString(actualMedians), Arrays.toString(expectedMedians));  
	}

	
	
	@Test
	public void testComputeMediansUsingInsertionCase2() {
	
		int[] streamData = {10,9,8,7,6,5,4,3,2,1}; 
		int[] dataBuffer = new  int[streamData.length];  
		float[] actualMedians  = new float[streamData.length]; 
		float[] expectedMedians = {10.0f, 9.5f, 9.0f, 8.5f, 8.0f, 7.5f, 7.0f, 6.5f, 6.0f, 5.5f};
		
		StreamMedian.computeMediansUsingInsertionSort(streamData, dataBuffer, actualMedians); 
		assertEquals(Arrays.toString(actualMedians), Arrays.toString(expectedMedians));  
	}
	
	
	
}
