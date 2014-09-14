package tutorials.array;

import java.util.HashMap;
import tutorials.utils._;

/**
 * == Problem == 
 * Find if there is a sub array with 0 sum 
 *   http://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/ 
 *   
 * == Analysis == 
 *  A naive solution is to enumerate all possible sub arrays however this 
 *  solution is not favored, as its time complexity is O(N^2) where N is
 *  the length of the array 
 *  
 *  Based on the past experience I felt that there should be a linear 
 *  solution. I got stuck in manipulating the "begin" and "end" pointers
 *  and failed to find the correct solution. 
 *  
 *  To get the liner solution, some observation is needed. The key observation
 *  here is the property of 0 sum. If there were such a sub array, then if
 *  we sum the values of arr[0..i] then a sum figure would appear twice. 
 *  
 * == Solution ==
 *  Sum the values from arr[0..i] and hash them. If a value appears twice
 *  then we know there is a sub array of sum 0. We also need to consider the 
 *  following corner cases: (1) arr[i] is 0; (2) sum is 0. 
 *  
 * == Lesson == 
 *  When dealing with unknown problem, it is important to be observant and 
 *  creative. 
 * 
 * @author jack
 *
 */

public class ZeroSumSubArr {
	
	public static boolean findZeroSumSubArr(int[] arr, _<Integer> begin, _<Integer> end){
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 

		for(int i=0, sum=0; i<arr.length; i++){
			
			sum += arr[i]; 

			if(arr[i]==0){
				begin.set(i); 
				end.set(i);
				return true ; 
			}else if(sum==0){
				begin.set(0);
				end.set(i); 
				return true; 
			}else if( map.get(sum)!= null){
				begin.set(map.get(sum)+1); 
				end.set(i); 
				return true; 
			}
			
			map.put(sum, i); // add the pair <sum, endIdx> to the hash map 	 
		}		
		return false; 
	}
	
}
