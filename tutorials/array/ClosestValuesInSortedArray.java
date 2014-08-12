package tutorials.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * http://www.geeksforgeeks.org/find-k-closest-elements-given-value/ 
 * 
 * Given a sorted array arr[] and a value X, find the k closest elements to X in arr[].
 * 
 * NOTE: 
 *   (1) the value X might not be in the array. 
 *   (2) if X is present in the array, then it should not be outputed only other
 *           closet elements are required 
 *           
 * Example:   
 *   Input: K=2, X = 20, arr[] = { 3, 5, 7, 8, 11, 19, 20};      
 *   Output: 11, 19  
 *  
 * Analysis: 
 *   We assume that all the elements are unique. 
 * 
 *   Since it is a sorted array, binary search can be adapted to find the closest element to X 
 *   We define such element as the crossover point, which means the largest element smaller or 
 *   equal to X. All figures before the crossover point should be smaller than X, and numbers 
 *   after the point should be greater than X. 
 *  
 * 
 * @author Endeavour 
 *
 */

public class ClosestValuesInSortedArray {

	
	/**
	 *  Given a sorted array arr[] and a value key, find the total closest elements to X in arr[].
	 * 
	 * @param arr - the array is sorted 
	 * @param total   
	 * @param key
	 * @return
	 */
	public static String findClosetValues(int[] arr, int total, int key){
		
		// find the cross over point 
		int crossIndex = findCrossoverIndex(arr, key);
		
		// now collect the results 
		ArrayList<Integer> values = new ArrayList<Integer>(); 
		int left  = crossIndex, right = left+1; 
		int count = 0, arrLength = arr.length; 
		
		// skip duplicate values 
		while(left>=0 && arr[left]== key)
			left--; 
		
		// scan both ways 
		while(left>=0 && right<arrLength && count <total){
		
			if(key-arr[left] < arr[right]-key){
				values.add(arr[left]); 
				left--; 
			}else{
				values.add(arr[right]); 
				right++; 
			}
			count++; 
		}
		
		// not enough values on the R.H.S
		while(left>=0 && count<total){
			values.add(arr[left]); 
			left--;
			count ++; 
		}
		
		// not enough values on the L.H.S 
		while(right<arrLength && count <total){
			values.add(arr[right]); 
			right++; 
			count++; 
		}
		
		Collections.sort(values); 
		return Arrays.toString(values.toArray()); 
	}
	
	
	
	
	/**
	 *  Given a key value "x" and the array, return an index "i",
	 *  such that arr[i] <= x and arr[i+1] > x 
	 * 
	 * @param arr
	 * @param key
	 * @return
	 */
	public static int findCrossoverIndex(int[] arr, int key){
		
		if(arr[0] > key) // key is smaller than all values 
			return 0; 
		
		int arrLength = arr.length; 
		if(arr[arrLength-1]<key)  // key is larger than all values 
			return arrLength -1; 
				
		// find the cross over inside the array 
		return findCrossoverIndex(arr, key, 0, arr.length); 
	}
	
	
	
	/**
	 * This method is actually the FloorInSortedArray.findFloorNeat() method 
	 *  
	 * @param arr
	 * @param key
	 * @param low
	 * @param high
	 * @return
	 */
	protected static int findCrossoverIndex(int[] arr, int key, int low, int high){ 
		
		while(high - low > 1){
			
			int mid = low + (high-low)/2; 
			if(arr[mid] <= key)
				low = mid; 
			else 
				high = mid; 
		}
		
		return low; 
	}
		
		
		

	
	
	
	
	

}
