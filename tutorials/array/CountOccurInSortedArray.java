package tutorials.array;


/**
 * 
 * Problem: 
 *   http://www.geeksforgeeks.org/count-number-of-occurrences-in-a-sorted-array/  
 *  
 *   Count the number of occurrence of an element in a sorted array.  
 *   
 * Solutions: 
 *   (1) linear scan: requires O(n) in time complexity 
 *   (2) binary search: O(nlog(n)) in time complexity 
 *   
 * @author Endeavour
 *
 */

public class CountOccurInSortedArray {


	/**
	 *  Count the number of occurrence of an element in a
	 *  sorted array 
	 * 
	 * @param arr - an integer array 
	 * @param number - the number to search in the array 
	 * @return -1 if the number is not found otherwise
	 *         the number of occurrence of 'number' 
	 */
	public static int countOccurrence(int[] arr, int number){
		
		int start = findFirstOccurrence(arr, number); 
		if(start==-1)
			return -1; 
		
		int finish = findLastOccurrence(arr, number); 
		return finish-start+1 ; 
	}
	
	
	
	protected static int findFirstOccurrence(int[] arr, int number){
		
		int lo = 0, hi = arr.length -1; 
		while( lo <= hi){
			
			int mid = lo + (hi-lo)/2; 
			if( arr[mid]==number &&(mid==0||arr[mid-1]<number) ){
				return mid ; 
			}else if ( arr[mid] >= number )
				hi = mid-1; 
			else 
				lo = mid+1; 
		}
		return -1; 
	}
	
	
	
	protected static int findLastOccurrence(int[] arr, int number){
		
		int arrLength = arr.length ; 
		int lo = 0, hi = arrLength -1; 
		
		while( lo <= hi){
			
			int mid = lo + (hi-lo)/2; 
			if( arr[mid]==number &&(mid==arrLength-1||arr[mid+1]>number) ){
				return mid ; 
			}else if ( arr[mid] > number )
				hi = mid-1; 
			else 
				lo = mid+1; 
		}
		return -1; 
	}
	

}
