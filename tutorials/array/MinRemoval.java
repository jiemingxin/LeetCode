package tutorials.array;

/**
 * Problem: 
 *  
 *  Given an array, and its elements can be removed from either ends. 
 *  Output the minimum number of removals, such that the twice of the minimum 
 *  of remaining numbers is larger than the maximum of them. 
 *  
 *  http://www.geeksforgeeks.org/remove-minimum-elements-either-side-2min-max/ 
 * 
 * Examples: 
 * 
 *  (1) arr[] = {4, 5, 100, 9, 10, 11, 12, 15, 200}
 *      Output: 4 ( We need to remove 4 elements (4, 5, 100, 200) so that 
 *      2*min becomes more than max.
 *  
 *  (2) arr[] = {4, 7, 5, 6}
 *      Output: 0 ( We don't need to remove any element as 4*2 > 7 (Note that 
 *      min = 4, max = 8)
 *      
 *  (3) arr[] = {20, 7, 5, 6}
 *      Output: 1  ( We need to remove 20 so that 2*min becomes more than max ) 
 *      
 *  (4) arr[] = {20, 4, 1, 3} 
 *      Output: 3  ( We need to remove any three elements from ends like 20, 4, 1 
 *            or 4, 1, 3 or 20, 3, 1 or 20, 4, 1 ) 
 * 
 * Analysis: 
 * 
 * Solutions I and II: 
 *   This problem is related to array, so we can try the strategy of reduce-and 
 *   conquer. The idea is to reduce the problem from the scale of N to N-1. 
 *   
 *   The strategy can be formulated as : 
 *     if 2*min > max in the current array, return 0 
 *     else compare the results of removing the left/right end, and return their 
 *     minimum
 *   
 *   There can be two implementations 
 *   (1) recursive implementation, time complexity is T(n) = 2*T(n-1)+n => 
 *       T(n) = O(n*2^n) 
 *   (2) dynamic programming, time complexity T(n) = O(n^3), which requires O(N^2) 
 *       space 
 *       
 * Solution III:
 *   Since this question ask for the minimum number of removal, we can look for
 *   the longest sub array which satisfies the condition that 2*min > max 
 *   
 *   Enumerating all possible sub arrays requires O(n^2), which can be implemented
 *   using two for loops. The min and max values can also be calculated along 
 *   the way 
 *     
 * 
 * @author Endeavour
 *
 */



public class MinRemoval {
	
	public static int recursiveCompute(int[] arr){
		return recursiveCompute(arr, 0, arr.length-1); 
	}
	
	
	/**
	 * Solution I: recursive solution 
	 * 
	 *  Calculate the minimum number of elements to remove from
	 *  arr[begin, end]. 
	 *  
	 * @param arr
	 * @param begin
	 * @param end
	 * @return
	 */
	protected static int recursiveCompute(int[] arr, int begin, int end){
		
		if(begin == end) // base case 
			return 0; 
		
		int min = min(arr, begin, end); 
		int max = max(arr, begin, end); 
		if( 2*min > max )
			return 0; 
		
		return Math.min( recursiveCompute(arr, begin+1, end)+1, 
						 recursiveCompute(arr, begin, end-1)+1); 
	}
	
	
	
	
	
	/**
	 * 
	 * Solution II: Dynamic Programming 
	 * 
	 *  Compute the answer using Dynamic Programming 
	 *  Let f(i,j) be the minimum number of removals for arr[i,j]
	 *  We have 
	 *    (1) f(i,i) =0; 
	 *    (2) f(i,j) = min( 1+f(i+1,j), 1+f(i,j-1)); 
	 *  We want f(0,N-1), where N is the length of the array 
	 *  
	 * @param arr
	 * @return
	 */
	public static int dpCompute(int[] arr){
		
		int numElems = arr.length ; 
		int[][] f = new int[numElems][numElems];
	
		// initialize the base case, this can be skipped 
		// as they are all initialised as 0 
		for(int i=0; i<numElems; i++)
			f[i][i] = 0 ;
		
		for(int gap=1; gap<numElems; gap++)
			for(int begin=numElems-2; begin>=0; begin--) 
			{
				int end = begin + gap ; 
				if(end >= numElems ) 
					continue; 
				
				int min = min(arr, begin, end); 
				int max = max(arr, begin, end); 
				if( 2*min > max )
					f[begin][end] = 0; 
				else 
					f[begin][end] = Math.min(1+f[begin+1][end], 1+f[begin][end-1]); 
			}
		return f[0][numElems-1]; 	
	}
	
	
	
	
	/**
	 * Solution III: pairwise search 
	 *
	 * @param arr
	 * @return
	 */
	public static int pairwiseCompute(int[] arr){
	
		int arrSize = arr.length ; 
		int maxSubArrSize = 1;  // we can also output a singular element 
		
		for(int start=0; start<arrSize; start++){
			
			int min = arr[start] ; 
			int max = arr[start] ; 
			
			for(int end=start+1; end <arrSize; end++){
				
				min = Math.min(min, arr[end]); 
				max = Math.max(max, arr[end]); 
				
				if(2*min>max){
					int subArrSize = end - start +1 ; 
					maxSubArrSize = Math.max(maxSubArrSize, subArrSize); 
				}
			}			
		}
		
		return arrSize - maxSubArrSize ; 
	}
		

	
	
	/**
	 *  Calculate the min value in arr[begin, end] 
	 * 
	 * @param arr
	 * @param begin
	 * @param end
	 * @return
	 */
	protected static int min(int[] arr, int begin, int end){
		
		int min = Integer.MAX_VALUE ; 
		for(int i=begin; i<=end; i++)
			min = Math.min(arr[i], min); 
		return min ; 
	}
	
	
	/**
	 *  Calculate the max value in arr[begin, end] 
	 * 
	 * @param arr
	 * @param begin
	 * @param end
	 * @return
	 */
	protected static int max(int[] arr, int begin, int end){
		
		int max = Integer.MIN_VALUE ; 
		for(int i=begin; i<=end; i++)
			max = Math.max(arr[i], max); 
		return max; 
	} 
	
	
	
	
	
	
	
	
	

}
