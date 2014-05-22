package tutorials.array;

/**
 * 
 * Problem: 
 *  http://leetcode.com/2010/04/rotating-array-in-place.html 
 * 
 *  Rotate a one-dimensional array of n elements to the right 
 *  by k steps. For instance, with n=7 and k=3, the array 
 *  {a, b, c, d, e, f, g} is rotated to {e, f, g, a, b, c, d}.
 *  
 *  
 *  This problem can be understood as swapping the "A" and "B"
 *  in a given string "AB". The output of the swap should be 
 *  "BA". There are three cases:
 *  
 *  (1) if(|A| == |B|), simple swap both items 
 *  (2) |A| > |B}, break A into two parts, namely A1A2, where
 *      |A1| = |B|. Swap A1 with B ==> BA2A1 => shift "A2A1" 
 *      to "A1A2" recursively 
 *  (3) |A| < |B|, break B into two parts, namely B1B2, where 
 *      |A| = |B2|. Swap A with B2 ==> B2B1A => shift "B2B1" 
 *      to "B1B2" recursively 
 * 
 * 
 * 
 * @author endeavour
 *
 */
public class ArrayRightShift {
	
	
	
	public static void shiftRight(int[] arr, int nShifts){
		int length = arr.length; 
		shiftRight(arr, 0, length-1, nShifts%length); 		
	}
	

	/**
	 * Right shift the content in the array within the range of 
	 * [start, finish] by "nShifts" 
	 * 
	 * @param arr
	 * @param start
	 * @param finish
	 * @param nShifts
	 */
	protected static void shiftRight(int[] arr, int start,
									 int finish, int nShifts){
		// handle the exception 
		if(start > finish||nShifts ==0)
			return; 

		int total   = finish - start + 1; 
		int nFronts = total - nShifts ; 
				
		// handle the base case 
		if( nFronts == nShifts ){	
			for(int i=0; i<nFronts; i++)
				swap(arr, start+i, finish-nShifts+i+1); 
			return ; 
		}
		
		// the recursion 
		if ( nFronts < nShifts){
			for(int i=0; i<nFronts; i++)
				swap(arr, start+i, finish-nFronts+i+1); 
			shiftRight(arr, start, finish-nFronts, nShifts-nFronts); 
		}else{
			for(int i=0; i<nShifts; i++) 
				swap(arr, start+i, finish-nShifts+i+1); 
			shiftRight(arr, start+nShifts, finish, nShifts); 
		}
		
		return ; 
	}
	

	protected static void swap(int[] arr, int m, int n){	
		int tmp = arr[n]; 
		arr[n]  = arr[m]; 
		arr[m]  = tmp ; 
	}
	
}
	
	
