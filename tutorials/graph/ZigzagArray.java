package tutorials.array;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/convert-array-into-zig-zag-fashion/ 
 * 
 * == Problem == 
 * Given an integer array, convert it into an zig-zag array. The converted
 * array should have the form of  a < b > c < d > e < f. 
 * 
 * Input:  arr[] = {4, 3, 7, 8, 6, 2, 1}
 * Output: arr[] = {3, 7, 4, 8, 2, 6, 1}
 * 
 * 
 * == My solution == 
 *  Sort the array, and then insert large elements between each pair of 
 *  smaller elements. 
 *  
 *  Time complexity: O(nlogn) for sorting, O(n) for inserting 
 *  (with a memory buffer ) 
 * 
 * == Sample solution == 
 *  Only requires O(n). The idea is based a modified bubble sort.  
 *  A zigzag array can have two forms: (1) a < b > c < d > e < f ; 
 *  or (2) a > b < c > d < e > f. The essence of a zigzag array is the 
 *  switching of "less than" and "larger than" relationships, excluding
 *  the first element
 *  
 *  We will keep a flag: "true" means a lesser-than relation, whereas 
 *  "false" means a larger-than relation. Say if we are processing B and C. 
 *  The expected relation is the lesser-than but we have B > C -- (i). 
 *  
 *  Since current expected relation is the lesser-than, we know the 
 *  previous expectation is larger than. Let the previous value be A, 
 *  we have A > B -- (ii) 
 *  
 *  (i)(ii) ==> A >B >C , to make them into the zigzag form, we only need
 *  to swap B and C. 
 *  
 *  If B is the starting element, it still makes sense to swap B and C.
 *    
 * @author jack
 */

public class ZigzagArray {
	
	public static void convertToZigZagArray(int[] arr){
		
		boolean flag = true; // expect a lesser-than as the start 
		for(int i=0; i<arr.length-2; i++){
			
			if( flag ){ // expect a "<"
				if( arr[i] > arr[i+1])
					swap(arr, i, i+1); 
				
			}else{ // expect a ">"
				if( arr[i] < arr[i+1])
					swap(arr, i, i+1); 
			}
			flag = !flag ; 
		}
	}
	
	
	protected static void swap(int[] arr, int i, int j){
		int tmp = arr[i]; 
		arr[i] = arr[j];
		arr[j] = tmp ;
	}
	
	
	public static void main(String[] args){
		
		
		int[] src = {4, 3, 7, 8, 6, 2, 1}; 
		System.out.println("INPUT: "  + Arrays.toString(src)); 
		ZigzagArray.convertToZigZagArray(src);
		System.out.println("OUTPUT: " + Arrays.toString(src)); 

	}
	
	
	

}
