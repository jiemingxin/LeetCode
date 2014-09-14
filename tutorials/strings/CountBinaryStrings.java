package tutorials.strings;

import java.util.ArrayList;

/**
 * http://www.geeksforgeeks.org/count-number-binary-strings-without-consecutive-1s/ 
 * 
 *  Given a positive integer N, count all possible distinct binary strings of length 
 *  N such that there are no consecutive 1′s.
 * 
 * Analysis:
 *   (1) Filtering approach: 
 *       we can generate all possible binary strings of length N, and then filter them
 *       by checking if they satisfy the condition. This method is very computational 
 *       expensive; it takes O(2^N) to go through all possible binary strings
 *   
 *   (2) Generative approach: 
 *       This method is actually based on reduced-and-conquer. The idea is to generate
 *       the answers for case N based on the answers from case N-1. If the trailing bit
 *       is 1 then we can only append 0 otherwise we can append 0 or 1. 
 *       
 *       This can be implemented using recursion or dynamic programming 
 *       Time complexity: T(N) = T(N-1) + 
 * 
 * @author jack
 *
 */

public class CountBinaryStrings {
	
	/**
	 *  Recursively generate all valid strings of length N 
	 * 
	 * @param N
	 * @return
	 */
	public static int countStrings(int N){
		ArrayList<Integer>  ret = generateValidStrings(N); 
		return ret.size();
	}

	protected static ArrayList<Integer> generateValidStrings(int N){
		
		ArrayList<Integer> result = new ArrayList<Integer>(); 
		if( N == 1){
			result.add(1); 
			result.add(0);
			return result; 
		}
		
		ArrayList<Integer> subResults = generateValidStrings(N-1);
		for(Integer val: subResults){
			if( (val & 1) != 0){ // ending with 1
				result.add( (val << 1 ) ); 
			}else{ 
				result.add( val << 1 ); 
				result.add( (val << 1) + 1); 
			}			
		}
		return result ; 
	}
	
	
	/**
	 *  Compute the answer using dynamic programming 
	 *  
	 *  Since we treat strings trailing 0 and 1 differently, we store
	 *  their numbers in two variables 
	 *  
	 */
	public static int countStringsDP(int N){
		
		int[] counts = {1, 1}; // count[0] keeps the #string ending with bit 1 
		                      // count[1] keeps the #strings ending with bit 0 
		
		for(int i=1; i<N; i++){
			counts[0] = counts[0]; // can only append 0 to each of them 
			counts[1] *= 2 ;        // can append 0 or 1 to each of them 
		}
		
		return (counts[0] + counts[1]); 

	}
	
}
	
