package tutorials.array;

import java.util.Arrays;

/**
 * Count distinct pairs with their difference equals k 
 * http://www.geeksforgeeks.org/count-pairs-difference-equal-k/ 
 * 
 * == Analysis == 
 * Solutions: (Let n be the #elements in the array ) 
 * (1) naive search: enumerate all possible pairs : Time complexity: O(n^2) 
 * (2) sort the array then use binary search
 * (3) use hashtable : time complexity: O(n), space complexity: O(n)
 * (4) use a balanced binary search tree or two heaps (refer to the stream median
 *     problem ) 
 * 
 * This file implements solution (2) 
 * 
 * @author jack
 *
 */

public class DistinctPairs {

	

	
	
	
	/**
	 *  Count the #pairs with given difference 
	 * 
	 * @param diff
	 * @return
	 */
	public static int count(int[] arr, int diff){
		
		Arrays.sort(arr); // O(nlogn) 
		
		// need to remove duplicates here , O(n) 
		arr = removeDuplicates(arr);
		
		int pairCounts=0;
		for(int i=0; i<arr.length;i++){
			int key = arr[i];
			if(binarySearch(arr,key+diff)!=-1)
				pairCounts++; 
		}
	
		return pairCounts ; 
	}
	
	
	protected static int binarySearch(int[] arr, int key){
		
		int lo=0, hi=arr.length;
		while(hi-lo>1){
			int mid = lo+(hi-lo)/2;
			if(arr[mid]<=key)
					lo=mid;
			else
				hi=mid; 
		}		
		return arr[lo]==key?lo:-1;
	}
	

	
	public static int[] removeDuplicates(int[] arr){
		
			int uniqueIdx = 0; 
			int idx = 0; 
			while(idx < arr.length){
				int duplicateIdx = idx + 1;
				int val = arr[idx] ; 
				while(duplicateIdx<arr.length &&  arr[duplicateIdx] == val)
					duplicateIdx++; 
				arr[uniqueIdx++] = val; 
				idx = duplicateIdx ; 
			}
			
			return Arrays.copyOf(arr, uniqueIdx); 
	}
	
	
	
}
