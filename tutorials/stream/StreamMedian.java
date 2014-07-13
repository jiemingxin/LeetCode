package tutorials.stream;

import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * 
 * http://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/ 
 * 
 * Problem: 
 *    Given that integers are read from a data stream. Find median of 
 * elements read so for in efficient way. 
 * 
 * 
 * 
 * 
 * @author Endeavour
 *
 */
public class StreamMedian {

	/**
	 *  Compute the stream median using insertion sort. This method 
	 *  stores the data in an array 
	 *  
	 * @param dataStream  - the integer array which simulates the incoming data 
	 * @param dataBuffer  - the integer array that stores the computed medians 
	 */
	public static void computeMedianUsingInsertionSort(int[] dataStream, int[] dataBuffer, float[] medians){
		
		int numReceived = 0; 
		for(int i=0; i<dataStream.length; i++){
		
			// insert the new data 
			int received = dataStream[i]; 
			int insertLoc = numReceived ; 
			while(insertLoc>0 && dataBuffer[insertLoc-1] > received){
				dataBuffer[insertLoc] = dataBuffer[insertLoc-1]; 
				insertLoc -- ; 
			}
			dataBuffer[insertLoc] = received ; 
			
			// compute the median 
			numReceived ++; 
			int mid = numReceived/2; 
			if( numReceived % 2 == 0)
				medians[i] = (dataBuffer[mid] + dataBuffer[mid-1])/2.0f ; 
			else
				medians[i] = dataBuffer[mid]; 			
		}
	}
	
	
	public static class AscendingComparator implements Comparator<Integer> {
		 
		public int compare(Integer one, Integer two) {
			return one.compareTo(two);
		}
	} 
	
	public static class DescendingComparator implements Comparator<Integer> {
		
		public int compare(Integer one, Integer two) {
			return (-1) * one.compareTo(two); 
		}
	}
	
	
	
	
	public static void computeMedianUsingMinMaxHeaps(int[] dataStream, float[] medians){
		
		int initialCapacity = 10; // an arbitary number 
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(initialCapacity, new AscendingComparator() ); 
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(initialCapacity, new DescendingComparator() );  
	
		int numReceived = 0; 
		for(int i=0; i<dataStream.length; i++){
		
			// receiving the new data 
			numReceived ++ ; 
			int received = dataStream[i];  
			maxHeap.add(received); 
			
			// adjust the heap 
			int half = numReceived/2 ; 
			while(maxHeap.size() > minHeap.size()){
				Integer value = maxHeap.poll();
				minHeap.add(value); 	
			}
				
			// compute the median 
			if(numReceived%2==0){
				medians[i] = (maxHeap.peek() + minHeap.peek())/2; 
			}else{
				medians[i] = minHeap.peek(); 
			}			
		}
	}
	
	
	
	
	
	
	
	
	
}
