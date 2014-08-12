package tutorials.array;

/**
 * 
 * http://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-array/ 
 * 
 * 
 * Problem: 
 *    Given a sorted and rotated array, find out its the minimum values We assume 
 *    that all elements in the array are unique. 
 * 
 *    For example, 
 *      findMin([5,6,1,2,3]) = 1 ; 
 *      findMin([3,4,1,2])   = 1 ; 
 *      findMin([1,2]) = 1 
 *      findMin([2,1]) = 1  
 * 
 * Analysis:
 *  If we observe carefully, we can tell that the minimum element is always following
 *  the maximum element. It is also true in converse. If an element follows a bigger 
 *  element, then that element is the minimum 
 *  
 *  Since the array is sorted, we can utilise the binary search. However we are not 
 *  sure whether the minimum is "mid" or "mid-1" or "mid+1" so we need to check all 
 *  these conditions 
 * 
 *  We also need to consider the following corner cases:
 *    (1) the array is sorted and rotated by its length: the minimum is the first 
 *        element then 
 *    (2) there are only two elements in the array 
 *    (3) there are only a single element in the array 
 *    
 * Lessons:
 *   (1) identity the property of the solution 
 *   (2) check corner cases 
 *   (3) determine which half to throw    
 *  
 * Extensions: 
 *   How to handle the duplicates?    
 *  
 *    
 * @author jack
 *
 */

public class MinInRotatedSortedArray {

	
	public static int findMin(int[] arr){
		return findMin(arr, 0, arr.length-1); 
	}
	
	
	public static int findMin(int[] arr, int lo, int hi){
		
		// corner case 1: the array is sorted 
		if(arr[lo] < arr[hi])
			return arr[lo]; 
		
		//corner case 2:  there is only an element in the array 
		if( lo == hi)
			return arr[lo]; 
		
		int mid = lo + (hi-lo)/2 ; 
		
		// check if arr[mid+1] is the minimum 
		if( mid<hi && arr[mid] > arr[mid+1])
			return arr[mid+1]; 
		
		// check if arr[mid] is the minimum 
		if( lo<mid && arr[mid-1] > arr[mid])
			return arr[mid]; 
		
		if( arr[mid] < arr[hi]) // arr[mid] is omitted as we have checked it 
			return findMin(arr, lo, mid-1); 
		
		return findMin(arr, mid+1, hi); 
	}
						
}
