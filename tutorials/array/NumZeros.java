package tutorials.array;

/**
 * == Problem == 
 * http://www.geeksforgeeks.org/find-number-zeroes/ 
 * Given an array of 1's and 0's which has all 1's followed by 0's.
 * Count the number of zeros in that array 
 * 
 * @author jack
 *
 */

public class NumZeros {
	
	public static int countZeros(int[] arr){
		
		int arrLen = arr.length;
		// tackle corner cases 
		if(arr[0]==0)
			return arrLen; 
		if(arr[arrLen-1]==1)
			return 0; 
		
		/**
		 * I use the neat version of binary search here:
		 * (1) "hi" is an exclusive indice 
		 * (2) the invariant inside the loop is that 
		 *     arr[lo]>0 and arr[hi]<=0 
		 *     As a result, when hi-lo=1 the loop exists
		 *     and we know arr[hi]=0 and arr[lo]>0
		 */
		int lo=0, hi=arrLen; 
		while(hi-lo>1){
			
			int mid = lo+(hi-lo)/2; 
			if(arr[mid]>0)
				lo = mid ; 
			else 
				hi = mid ; 
		}
		return arrLen-hi; // (arrLen-1)-(hi)+1	
	}
}
