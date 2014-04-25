package tutorials.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.PriorityQueue; 
import java.util.AbstractMap.* ; 

public class SlidingWindowMaximum {

	
	public static class EntryComparator implements Comparator<Entry<Integer,Integer>> 
	{
		@Override
		public int compare(Entry<Integer, Integer> arg0,
				Entry<Integer, Integer> arg1) {
			return -1 * arg0.getValue().compareTo(arg1.getValue()); 
		}
	}
	
	
	/**
	 *   
	 *   Time Complexity: O(nlogn)  
	 * @param source
	 * @param destination
	 * @param winSize
	 */
	public static void calculateUsingHeap(int[] source, int[] destination, int winSize){
		
		EntryComparator comparator = new EntryComparator(); 
		PriorityQueue<Entry<Integer, Integer>> pq = new PriorityQueue<Entry<Integer, Integer>>(11, comparator); 		
		int idx ; 
		for(idx=0;  idx<winSize;  idx++){
			Entry<Integer,Integer> entry = new SimpleEntry<Integer, Integer>(idx, source[idx]); 
			pq.add(entry); 
		}
		
		for(idx=winSize; idx< source.length; idx++ ){
			
			destination[idx-winSize] = pq.peek().getValue();  // get the maximum in the window 
			
			while(!pq.isEmpty() && pq.peek().getKey() <= idx - winSize)  // clear the out-of-range elements
				pq.poll(); 
			
			// add the current value 
			Entry<Integer,Integer> entry = new SimpleEntry<Integer, Integer>(idx, source[idx]);  
			pq.add(entry);  
		}
		destination[idx-winSize] = pq.peek().getValue(); 	
	}

	
	public static void calculateUsingMonotonousQueue(int[] source, int[] destination, int winSize){
		
		
		
		
		
		
		
	}

	


	
	public static void main(String[] args){
		
		int source[] = { 1, 2, 3, 4, 5, 6, 7, 8 }; 
		int dest[]   = { 0, 0, 0, 0, 0, 0, 0, 0 }; 
		int winSize  = 3 ; 
		
		SlidingWindowMaximum.calculateUsingHeap(source, dest, winSize); 
		System.out.println( Arrays.toString(dest)); 
	}
	
}

