package tutorials.streams;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  http://codercareer.blogspot.com.au/2012/01/no-30-median-in-stream.html 
 *  Problem: 
 *     How to compute the medians from streaming numbers  
 *   
 *  Analysis:
 *   
 *   We can start the analysis from the data container for storing the 
 *   streaming data. We can analyse the time to insert the data/the time 
 *   to compute the median. 
 *   
 *   Possible data containers include the following: arrays, linked list, 
 *   binary tree, AVL tree, and heap. Amongst all, the heap container 
 *   turns out to be the most efficient data container for this task. 
 *   
 *   Container Type   |  Insert Time   |  Compute Timer 
 *    sorted array    |  O(n)          |  O(1)
 *    sorted list     |  O(n)          |  O(1) 
 *    bst             |  O(log(n))     |  O(log(n)) on average, O(n) for worst case 
 *    AVL			  |  O(log(n))     |  O(1) 
 *    Min Max Heaps   |  O(log(n)      |  O(1) 
 * 
 *  NOTE: 
 *   
 *    (1) The head of the priority queue is the LEAST element based on 
 *        the natural ordering or comparator based ordering,	
 *  
 *  Extension: 
 *     (1) what if we cannot load all the data into the memory ?
 *  
 *        
 * @author Endeavour
 *
 */

public class StreamMedian {
		
	   public static void computeMediansUsingInsertionSort(int[] streamData, int[] dataBuffer,
			   float[] medians){
		   
		   int numReceived = 0; 
		   for(int i=0;  i<streamData.length;  i++){
			   
			   // insert the received data into a sorted array 
			   int received  = streamData[i]; 
			   int insertLoc = numReceived ; 
			   while(insertLoc>0 && dataBuffer[insertLoc-1] > received){
				   dataBuffer[insertLoc] = dataBuffer[insertLoc-1]; 
				   insertLoc -- ; 
			   }
			   dataBuffer[insertLoc] = received ; 
			   numReceived ++ ; 
			   
			   // now compute the medians
			   int midIndex = numReceived/2; 
			   if(numReceived%2==0){
				   medians[i] = (dataBuffer[midIndex] + dataBuffer[midIndex-1])/2.0f; 
			   }else{
				   medians[i] = dataBuffer[midIndex]; 
			   }
		   }
	   }
	
	
	

		public static void computeMediansUsingMinMaxHeap(int[] streamData, float[] medians){
			
			int initCapacity = 50 ; // an arbitary number 
			
			// The head of the priority queue is the LEAST element based on 
			// the natural ordering or comparator based ordering,		
	        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(initCapacity, 
	                new Comparator<Integer>(){
	                    public int compare(Integer a, Integer b){
	                    	return (-1)*a.compareTo(b); 
	                    }
	        }); 
	        
	        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(initCapacity, 
	                new Comparator<Integer>(){
	                    public int compare(Integer a, Integer b){
	                    	return a.compareTo(b); 
	                    }
	                }); 
	        
	        int numReceived = 0; 
	        for(int i=0;   i<streamData.length;  i++){
	        	
	        	int received = streamData[i]; 
	        	
	        	// adjust the heaps to ensure: 
	        	//  (1) maxHeap.size() <= minHeap.size() 
	        	//  (2) all the values in maxHeap is smaller than those in minHeap 
	        	
	        	if(numReceived%2==0){  // insert into the minHeap 
	        		
	        		// check with the maxHeap first 
	        		int number = received ; 
	        		if(maxHeap.size()!=0  && number < maxHeap.peek()){
	        			maxHeap.add(number); 
	        			number = maxHeap.poll(); 
	        		}
	        		minHeap.add(number); 
	        		
	        	}else{  // insert into the maxHeap 
	        		
	        		// check with the minHeap first 
	        		int number = received ; 
	        		if( minHeap.size()!=0 && number > minHeap.peek()){
	        			minHeap.add(number);
	        			number = minHeap.poll(); 
	        		}
	        		maxHeap.add(number); 
	        	}
	        	numReceived ++; 
	        		        	
	        	if(numReceived%2==0){
	        		medians[i] = ( maxHeap.peek() + minHeap.peek() )/ 2.0f; 
	        	}else{
	        		medians[i] = minHeap.peek(); 
	    
	        	}
	        }
	        
		}
	
}
