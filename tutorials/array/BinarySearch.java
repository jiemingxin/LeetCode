package tutorials.array;

/**
 * 
 * Problem:
 *    Search for a key value in a sorted array 
 * Assumption:
 *    There is no duplicates in the sorted array 
 * 
 * @author Endevour 
 *
 */
public class BinarySearch {

	/**
	 *  Search the key value in the array and return its
	 *  index if it can be found, otherwise return -1 
	 *  
	 *  Assumption: all the numbers in the array are unique 
	 *  
	 * @param elems
	 * @param key
	 * @return
	 */
	public static int iterativeSearch(int[] elems, int key){
		
		int lo=0, hi=elems.length-1; 
		while(lo<=hi){
			
			int mid = lo + (hi-lo)/2; 
			int value = elems[mid]; 
			if( value == key ){
				return mid ; 
			}else if ( value < key ){
				lo = mid + 1; 
			}else{
				hi = mid -1 ; 
			}
		}
		return -1; 
	}
	
	
	
	/**
	 *  A neater implementation of iterative binary search 
	 *  In this implementation, we only need one comparison
	 *  in the while loop 
	 * 
	 * @param arr
	 * @param key
	 * @return
	 */
	 public static int iterativeSearchNeat(int[] arr, int key){
		 
		 // NOTE: "hi" is initialised as the length of the array
		 // In this implementation we don't need to access arr[hi]
		 int lo=0, hi=arr.length; 
		 
		 // the while loop converges to the point where "hi" and "lo"
		 // point to two consecutive elements 	 						    
		 while(hi-lo>1){
			 
			 int mid = lo+ (hi-lo)/2; 
			 if(arr[mid] <= key )  // only one comparison 
				 lo = mid; 
			 else  
				 hi = mid ; 
		 }
		 
		 // we need one more comparison here 
		 // once we reach here, we know the invariant always stands
		 //  arr[lo] <= key and arr[hi] > key 
		 return (arr[lo]==key?lo:-1); 
	 }
	
	
	public static int recursiveSearch(int[] elems, int key){
		return recursiveSearch(elems, key, 0, elems.length-1); 		
	}
	
	
	protected static int recursiveSearch(int[] elems, int key, int lo, int hi){
	
		// handle exceptions 
		if( lo > hi)
			return -1; 
		
		// base case 		
		int mid = lo + (hi-lo)/2 ; 
		int val = elems[mid]; 
		if( val == key)
			return mid ; 
		
		// recursion 
		if( val < key )
			return recursiveSearch(elems, key, mid+1, hi); 
		else
			return recursiveSearch(elems, key, lo, mid-1); 
	}
	
	
}
