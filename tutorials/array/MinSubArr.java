package tutorials.array;

import tutorials.utils._;

/**
 * Find the smallest subarray with sum greater than a given value 
 *  http://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/ 
 *  
 * Examples:
 *  (1)  arr[] = {1, 4, 45, 6, 0, 19}
 *       x  =  51
 *       Output: 3
 *       Minimum length subarray is {4, 45, 6}
 *  
 *  (2)  arr[] = {1, 10, 5, 2, 7}
 *       x  =  9
 *       Output: 1
 *       Minimum length subarray is {10}
 *   
 * Analysis:
 *   (1) This problem can be solved using a naive solution which enumerate all 
 *       possible subsets. Its time complexity is O(N^2); 
 *   (2) A linear scan algorithm can do a better job in this problem.  
 *   
 * @author jack
 *
 */
public class MinSubArr {
	
	public static int findMinSubArr(int[] arr, int x){
		
		_<Integer> begin = new _<Integer>();
		_<Integer> end = new _<Integer>();
		
		int minWinSize = findMinSubArr(arr,  x,  begin,  end);  
		System.out.println("Min Size = " + minWinSize );  
		if(minWinSize!=-1){ 
			System.out.print("{"); 
			for(int i=begin.value(); i<=end.value(); i++) 
				System.out.print(arr[i] + " "); 
			System.out.println("}"); 
		}
		return minWinSize ; 
	}
	
	
	/**
	 *  The indices "begin" and "end" are inclusive indices 
	 * 
	 * @param arr
	 * @param x
	 * @param begin
	 * @param end
	 * @return
	 */
	protected static int findMinSubArr(int[] arr, int x, _<Integer> begin, _<Integer> end){
		
		int left=0, right=0, sum=0, minWinSize=Integer.MAX_VALUE; 
		
		while( right < arr.length ){
		
			while(sum<=x && right<arr.length) // we want a sum larger than x 
				sum += arr[right++]; 
				
			// once we reach here "right" will point to the next 
			// element beyond the window 
			while(sum>x && left<arr.length){
			
				int winSize = right-1-left+1 ; 
				if(winSize < minWinSize){
					minWinSize = winSize ; 
					begin.set(left); 
					end.set(right-1); 
				}
				
				sum -= arr[left++]; 
			}
		}			
		return minWinSize==Integer.MAX_VALUE?-1:minWinSize; 
	}
}
