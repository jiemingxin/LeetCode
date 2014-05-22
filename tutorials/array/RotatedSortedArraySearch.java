package tutorials.array;

/**
 * http://leetcode.com/2010/04/searching-element-in-rotated-array.html
 * 
 * Problem: 
 * 
 *  Suppose a sorted array is rotated at some pivot unknown before hand. 
 *  (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). Find an element in 
 *  the rotated array efficiently. You may assume no duplicate exists in 
 *  the array.
 * 
 * 
 * NOTE: 
 *  The solution definitely has something to do with binary search. One
 *  obvious solution is to locate the pivot and do a binary search in
 *  either partition. Is it necessary to locate the pivot first? Not
 *  really 
 *  
 *  We can compare the middle value with two ends to see which partition
 *  is sorted. A binary search is then perfomed on the sorted partition
 *  
 *  When using binary search, it is important to set the "=" properly. 
 *  The key to understand it is to  know that, both pointers "lo" and "hi"
 *  could point to the same element. If this case is not covered then
 *  there will be a bug. 
 *  
 * @author endeavour
 *
 */


public class RotatedSortedArraySearch {

	
	
	/**
	 *  Return the index of the number in the array. 
	 *  -1 is returned if not found 
	 * 
	 * @param arr
	 * @param key
	 * @return
	 */
	
	public static int searchKey(int[] arr, int key){
		
		int lo = 0; 
		int hi = arr.length-1;
		
		while(lo<=hi){
			
			int mid = lo + (hi-lo)/2; 
			if(arr[mid] == key)
				return mid ; 
			
			if(arr[lo] <= arr[mid]){
				// the first half is sorted  
				if( arr[lo] <= key && key < arr[mid] ){
					hi = mid-1; 
				}else{
					lo = mid+1; 
				}
			}else{
				// the bottom half is sorted 
				if( arr[mid] < key && key <= arr[hi]){
					lo = mid+1; 
				}else{
					hi = mid-1; 
				}
			}
		}
		return -1; 
	}
	
	

	
	
	
	
	
}
