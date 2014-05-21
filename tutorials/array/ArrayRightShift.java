package tutorials.array;

import java.util.Arrays;

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
 * 
 * @author endeavour
 *
 */
public class ArrayRightShift {
	
	
	
	public static void shiftRight(int[] arr, int nShifts){
		shiftRight(arr, 0, arr.length-1, nShifts); 		
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
	protected static void shiftRight(int[] arr, int start, int finish, int nShifts){
		
		// handle the exception 
		if(start > finish)
			return; 
		
		// handle the base case 
		if(nShifts == 1){
			swap(arr, start, finish);
			return ; 
		}
			
		// handle the recursion 
		int total   = finish - start + 1; 
		int nFronts = total - nShifts ; 
		if( nFronts > nShifts){
			// exchange the first "nShifts" elements with the last "nShifts" elements 
			for(int i=0; i<nShifts; i++)
				swap(arr, i, total-nShifts+i); 	
			shiftRight(arr, nShifts, finish, total-nShifts); 
		}else{
			for(int i=0; i<nFronts; i++)
				swap(arr, i, total-nFronts+i); 
			shiftRight(arr, 0, finish-nFronts+1, nShifts-nFronts); 
		}
	}
	

	protected static void swap(int[] arr, int m, int n){	
		int tmp = arr[n]; 
		arr[n]  = arr[m]; 
		arr[m]  = tmp ; 
	}
	
	
	
	public static void main(String[] args){
		
		int[] arr = {1,2,3,4,5,6,7}; 
		shiftRight(arr, 3); 
		
		System.out.println(Arrays.toString(arr));
		
		
		
		
		
		
		
	}
	
}
	
	
