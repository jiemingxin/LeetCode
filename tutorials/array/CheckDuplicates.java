package tutorials.array;

/**
 * http://www.geeksforgeeks.org/check-given-array-contains-duplicate-elements-within-k-distance/
 *   
 * Given an unsorted array that may contain duplicates. Also given a number 
 * k which is smaller than size of array. Write a function that returns true 
 * if array contains duplicates within k distance.
 *   
 * 
 * @author jack
 *
 */

import java.util.HashMap; 
import java.util.HashSet; 

public class CheckDuplicates {

	
	/**
	 *  Returns true if the given array 'arr' contains duplicates
	 *  which are within k distance units. False otherwise. 
	 * 
	 * @param arr - the given integer array 
	 * @param k   - the window size 
	 * @return
	 */
	public static boolean containDuplicates(int[] arr, int k){
		
		HashMap<Integer, Integer> valueIndice = new HashMap<Integer, Integer>();
	
		for(int currIdx=0;  currIdx<arr.length; currIdx++){
			
			int value = arr[currIdx]; 
			if( valueIndice.containsKey(value) ){
				
				int prevIdx = valueIndice.get(value); 
				if( currIdx - prevIdx <= k )
					return true; 
				else
					valueIndice.put(value, currIdx); 
			}else{
				
				valueIndice.put(value, currIdx); 
			}
		}
		
		return false; 		
	}
	
	
	
	
	/**
	 *  This is the sample solution found on the link. In essence both solutions
	 *  make good use of hash. However the sample solution uses HashSet, and it
	 *  does not store the index, which is neater. 
	 * 
	 * 
	 * @param arr
	 * @param k
	 * @return
	 */
	public static boolean checkDuplicatesWithinK(int arr[], int k)
    {
      
        HashSet<Integer> set = new HashSet<>();
 
        for (int i=0; i<arr.length; i++)
        {
            // If already present n hash, then we found 
            // a duplicate within k distance
            if (set.contains(arr[i]))
               return true;
 
            // Add this item to hashset
            set.add(arr[i]);
 
            // Remove the k+1 distant item - this ensures the 
            // comparison is within a window of size k 
            if (i >= k)
              set.remove(arr[i-k]);
        }
        return false;
    }
	

	
}
