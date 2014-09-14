package tutorials.sorting;

/**
 * http://www.geeksforgeeks.org/radix-sort/ 
 * 
 * == Time complexity analysis ==
 * Let n be the #elements, b be the base, and d be #digits, then the time 
 * complexity is O(n*(b+d)). Denote k be the maximum number in the array, then 
 * d = log_b(k) => the time complexity is O( n*(b+log_b(k))). If we assume k=n^c, 
 * where c is a constant, then the time becomes O(nlog_b(n))(b and c are constant) 
 *  
 * As a result, the final time complexity depends on the choice of b. If we set
 * b to n, then the time complexity becomes O(n). 
 * 
 * == NOTE == 
 * This implementation only supports sorting positive figures. However it is not
 * hard to extend it to deal with negative figures. We can simply add a partition
 * method then sort two partitions.
 * 
 * @author jack
 *
 */
public class RadixSort {
	
	public static void sort(int[] arr){
			
		int max = Integer.MIN_VALUE;  // get the maximum  
		for(int i=0; i<arr.length; i++)
			max = Math.max(max, arr[i]); 
		
		// set the base to 'max' to achieve linear time sorting 
		for(int exp=1, base=max; max/exp>0; exp *= base){
			countingSort(arr, exp, base); 
		}
	}
	
	/**
	 *  Sort the array using counting sort according to the 
	 *  digit represented by "exp" 
	 * 
	 * @param arr
	 * @param exp
	 * @param base
	 */
	protected static void countingSort(int[] arr, int exp, int base){
		
		int arrLen = arr.length ; 
		int[] counts = new int[base];
		int[] sorted = new int[arrLen]; 
		
		for(int i=0; i<arrLen; i++){
			int key = hash(arr[i], exp, base); 
			counts[key]++; 
		}
			
		for(int i=1; i<base; i++)
			counts[i] += counts[i-1];
		
		// NOTE: populate the sorted array starting from the tail here.
		// This is to ensure the stability of duplicate keys. 
		// If we starts from 0 then the counting sort is not stable
		// 
		// For example, say arr[0] and arr[2] contributes to counts[1]
		// if we populate the sorted array starting from 0, then 
		// arr[2] will be listed before arr[0] is the sorted array 
		//
		// Maintaining the stability is important in Radix Sort, as
	    // we want to maitain the same relative order when we sort
		// different digits 
		for(int i=arrLen-1; i>=0; i--){
			int key = hash(arr[i], exp, base); 
			sorted[ counts[key]-1 ] = arr[i]; 
			counts[key]--;
		}
		
		for(int i=0; i<arrLen; i++)
			arr[i] = sorted[i]; 	
	}
	
	
	/**
	 *  Compute the key value for a given value according to the 
	 *  digit represented by "exp" and "base" 
	 * 
	 * @param value
	 * @param exp
	 * @param base
	 * @return
	 */
	public static int hash(int value, int exp, int base){
		return  (value/exp)%base  ;  
	}
	
}
	

