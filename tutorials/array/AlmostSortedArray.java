package tutorials.array;

/**
 * == Problem == 
 *  http://www.geeksforgeeks.org/search-almost-sorted-array/ 
 * 
 *  Given an array "arr" which is sorted, but after sorting arr[i] may be 
 *  swapped with arr[i-1] or arr[i]. For example, in the array 
 *  {2,3,10,4,40}, 4 is swapped with 10. Output the index of a given 
 *  key value. If the value is not in the array return -1 
 *  
 *  It is assumed that the array has no duplicate elements. Note that
 *  there is only swap for arr[i] with arr[i-1] or arr[i+1] 
 * 
 * == Example == 
 *  (1) arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 40 ==> 2 
 *  (2) arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 90 ==> -1 
 * 
 * == My Solution == 
 *  Since the array is sorted, we can use the binary search here. 
 *  However we need to compare the key value with arr[mid], arr[mid-1]
 *  and arr[mid+1] each time. 
 * 
 * @author jack
 *
 */
public class AlmostSortedArray {
	
	public static int search(int[] arr, int key){
		
		int lo=0, hi=arr.length-1; // inclusive indice 
		
		while(lo<=hi){
			
			int mid = lo+ (hi-lo)/2; 
			if( arr[mid] == key )
				return mid ;
			else if ( mid>0 && arr[mid-1]==key)
				return mid-1; 
			else if ( mid<hi && arr[mid+1]==key )
				return mid+1; 
			else if( arr[mid] < key)
				lo = mid + 1; 
			else 
				hi = mid- 1; 
		}
		return -1; 
	}
		
}
