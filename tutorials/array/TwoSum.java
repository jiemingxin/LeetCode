package tutorials.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * Problem: 
 *   
 *  http://stackoverflow.com/questions/11928091/linear-time-algorithm-for-2-sum  
 *   
 *  Given an integer x and a sorted array a of N distinct integers, design 
 *  a linear-time algorithm to determine if there exists two distinct indices 
 *  i and j such that a[i] + a[j] == x
 *   
 *  
 *  Solution: 
 *  
 *  We assume the array is sorted otherwise we will have to sort it( nlog(n)) 
 *  For the sorted array, we keep two pointers, namely left and right. 
 *  Initially left and right points to the begin and end position of the array. 
 *  
 *  We search for the complementary value for the 'left' value. If such value 
 *  can be found then we output it. If the complementary value is smaller than
 *  the actual needed, we will ignore the current 'left' value. If the value 
 *  is bigger than the complementary value, we drop the 'right' value 
 *   
 * @author Endeavour
 *
 */
public class TwoSum {
	
	
	public static Set<Set<Integer>> searchPairs(int[] arr, int sum){
		
		Set<Set<Integer>> pairs = new HashSet<Set<Integer>>(); 
		
		// nlog(n) in sorting  
		Arrays.sort(arr);  
		
		// linear search 
		int left=0 ; 
		int right= arr.length -1; 
		while(left < right){
			
			// we calculate the complement value for arr[left] 
			int leftValue  = arr[left]; 
			int rightValue = arr[right]; 
			int complement = sum - leftValue; 
						
			if( rightValue == complement ){
				
				HashSet<Integer> pairFound = new HashSet<Integer>(); 
				pairFound.add(leftValue); 
				pairFound.add(rightValue); 
				pairs.add(pairFound); 
	
				left ++ ; 
			}else if ( rightValue < complement ){ 
				// it is impossible to get such a value in the array 
				// as 'right' always points to largest possible complement 
				// so we just ignore the current value pointed by "left" 
				left ++; 
			}else{
				// the largest possible complementary value is larger than
				// the actual complement. To decrease the complementary value 
				// for current 'left' value, we need to reduce the 'right' value 
				right --; 
			}
			
			// Assume there are multiple pairs for the same sum. Let them be
			// (p1, p1'), (p2,p2'), ... (p3, p3'); 
			// if p1<p2<p3, then p1'> p2'>p3' 
		}
		
		return pairs; 
	}
	
	

	public static void main(String[] args){
		

		
		
		
		
	}
		
}
