package tutorials.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * http://lostincompilation.blogspot.com.au/2013/06/3sum-hard.html 
 * http://leetcode.com/2010/04/finding-all-unique-triplets-that-sums.html 
 * 
 * Problem: 
 * 
 *   Given a set S of n integers and an integer sum k,  are there 
 *   elements a, b, c in S such that a + b + c = k? Find all unique 
 *   triplets in the set which gives the sum of k.
 *   
 *  Analysis: 
 *  
 *    This problem is an extension of the TwoSum problem. As we know,  
 *  the TwoSum problem can be solved in linear time. This problem can
 *  be reduced to the TwoSum problem if we fix one value for the first
 *  element. 
 *  
 *  Time Complexity: 
 *  
 *    (1) Sorting the array takes O(nlog(n)) using quick sort 
 *    (2) Fixing one value requires one scan of the array, which requires O(n) 
 *    (3) solving reduced TwoSum problem requires O(n) time 
 *     
 *  As a result, the time complexity is O(n^2)( O(nlog(n)) is not 
 *  dominant.)       
 * 
 * @author Endeavour
 *
 */

public class ThreeSum {
	
	
	public static Set<Set<Integer>> searchTriplets(int[] arr, int sum){
		
		int nelems = arr.length ; 
		Set<Set<Integer>> triplets = new HashSet<Set<Integer>>(); 
		
		Arrays.sort(arr); 
		for(int i=0;  i<nelems;  i++){

			int fixedValue = arr[i];  
			
			int left  = i + 1 ; 
			int right = nelems - 1; 			
			
			while(left < right){
				
				int leftValue = arr[left]; 
				int rightValue = arr[right]; 
				int complement = sum - fixedValue - leftValue ; 
				
				if( complement == rightValue){
					Set<Integer> triplet = new HashSet<Integer>(); 
					triplet.add(fixedValue); 
					triplet.add(leftValue); 
					triplet.add(rightValue); 	
					triplets.add(triplet); 
					left ++ ; 
				}else if ( complement > rightValue){ 
					// no 'right' value can be found for the 'left' value  
					 left ++ ; 
				}else {
					 right -- ; 
				}				
			}
		}
		return triplets ; 
	}
	
	
	
	
	public static Set<Set<Integer>> bruteforceSearch(int[] arr, int sum){
		
		int nelems = arr.length ; 
		Set<Set<Integer>> triplets = new HashSet<Set<Integer>>(); 
		
		for(int i=0; i<nelems; i++)
			for(int j=i+1; j<nelems; j++)
				for(int k=j+1; k<nelems; k++){
					
					if( arr[i] + arr[j] + arr[k] == sum){
						Set<Integer> triplet = new HashSet<Integer>(); 
						triplet.add(arr[i]); 
						triplet.add(arr[j]); 
						triplet.add(arr[k]); 	
						triplets.add(triplet); 
					}
				}
		
		return triplets ; 
	}
	
	
	

}
