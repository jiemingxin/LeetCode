package tutorials.array;

/**
 * 
 * http://www.geeksforgeeks.org/the-ubiquitous-binary-search-set-1/ 
 * 
 * Problem: 
 *   Given a sorted array 'arr', and a value 'val', output the biggest 
 *   index 'i', such that arr[i] <= val && arr[i+1] > val  
 * 
 * Analysis
 *   This problem can definitely be solved using binary search, given
 *   that:
 *     (1) the array is sorted 
 *     (2) we know the property for that figure 
 *  
 *   We still need to consider some corner cases:
 *     (1) arr[0] > val 
 *     (2) arr[last] < val 
 *     (3) singlar array 
 *     (4) arrays with only two elements 
 *     
 * NOTE: 
 *   Need to deeply understand the neat solution, which considers 
 *   all these cases  
 *   
 * @author jack
 */
public class FloorInSortedArray {
	
	public static int findFloor(int[] arr, int val){
		return findFloor(arr, val, 0, arr.length-1); 
	}
	
	protected static int findFloor(int[] arr, int val, int lo, int hi){
		
		// handle the exceptions 
		if(arr[lo] > val) 
			return -1; 
		
		// handle the corner/base cases 
		if(arr[hi] < val) 
			return hi; 
		if(lo == hi)
			if(arr[lo] <= val)
				return lo; 
			else
				return -1; 
		
		int mid = lo + (hi-lo)/2; 
		if(mid<hi && arr[mid] <= val && arr[mid+1]>val)
			return mid ; 
		
		if(lo<mid && arr[mid-1]<=val && arr[mid]>val)
			return mid-1; 
		
		if(arr[mid] > val)
			return findFloor(arr, val, lo, mid-1);
		
		return findFloor(arr, val, mid+1, hi); 		
	}
	

	public static int findFloorNeat(int[] arr, int val){
		
		if( val < arr[0])
			return -1; 		
		return findFloorNeat(arr, val, 0, arr.length);
	}
		
	/**
	 * NOTE: 
	 *   In this neat solution, the hi index is exclusive   
	 * 
	 * @param arr
	 * @param val
	 * @param lo
	 * @param hi - the exclusive high index 
	 * @return
	 */
	protected static int findFloorNeat(int[] arr, int val, int lo, int hi){
		
		 while( hi - lo > 1){
			 int mid = lo + (hi-lo)/2; 
			 if( arr[mid] <= val) 
				 lo = mid ; 
			 else 
				 hi = mid ; // exclusive upper bound 
		 }	 
		 
		 // Interestingly once we reach this point, we have
		 // hi=lo+1, since hi is the exclusive upper bound 
		 // we don't need to compare the element with arr[hi] 
		 // from the conditions in the loop, we know that 
		 // arr[lo] <= val 
		 return lo;		
	}

}
