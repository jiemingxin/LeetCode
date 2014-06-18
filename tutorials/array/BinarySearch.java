package tutorials.array;

/**
 *  This class implements the basic version of binary search 
 * 
 * @author Endevour 
 *
 */

public class BinarySearch {

	/**
	 *  Search the key value in the array and return its
	 *  index if it can be found, otherwise return -1 
	 *  
	 *  Assumption: all the numbers in the array are unique 
	 *  
	 * @param elems
	 * @param key
	 * @return
	 */
	public static int iterativeSearch(int[] elems, int key){
		
		int lo=0, hi=elems.length-1; 
		while(lo<=hi){
			
			int mid = lo + (hi-lo)/2; 
			int value = elems[mid]; 
			if( value == key ){
				return mid ; 
			}else if ( value < key ){
				lo = mid + 1; 
			}else{
				hi = mid -1 ; 
			}
		}
		return -1; 
	}
	
	
	
	public static int recursiveSearch(int[] elems, int key){
		return recursiveSearch(elems, key, 0, elems.length-1); 		
	}
	
	
	protected static int recursiveSearch(int[] elems, int key, int lo, int hi){
	
		// handle exceptions 
		if( lo > hi)
			return -1; 
		
		// base case 		
		int mid = lo + (hi-lo)/2 ; 
		int val = elems[mid]; 
		if( val == key)
			return mid ; 
		
		// recursion 
		if( val < key )
			return recursiveSearch(elems, key, mid+1, hi); 
		else
			return recursiveSearch(elems, key, lo, mid-1); 
	}
	
	
}
