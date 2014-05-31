package tutorials.array;

import java.util.ArrayList;

/**
 * http://leetcode.com/2010/03/here-is-phone-screening-question-from.html 
 * 
 * Problem: 
 *   Find the intersection of two sorted arrays. 
 *   
 * Analysis: 
 *   Since both arrays are sorted, we will take the advantage of it. 
 *   This is an open ended questions and there are more than one 
 *   solution. The optimal solution depends on the length of both 
 *   arrays 
 *   
 *   
 * Solutions:
 *   Let both arrays be A and B respectively. Denote m as |A|, and n 
 *   as |B|
 *    
 *  (1) Pairwise comparison. For each element in A, scan B to see if it
 *      exists in B. 
 *      Time complexity: O(mn)  
 *      
 *  (2) We assume n < m.  For each element in A, we search in B to see
 *      if it exists using binary search. (Both A and B are sorted) 
 *      Time complexity: O(mlog(n))
 *      
 *  (3) Again we search in B each element in A. however this time we 
 *      hash B first. In this case each scan only takes O(1) time. 
 *      Time complexity:
 *        If n is very big then The hash table will either requires a 
 *      large amount of memory space, or there will be lots of collision
 *      in the table, which makes access time no longer O(1) time. Accordingly 
 *      using a hash table is not a good general solution to this problem. 
 *      Besides, using hash table DO NOT require that the array being sorted in the first place.   
 *  
 *  (4) This solution is inspired by the merge sort. We take advantage of the fact
 *      that both arrays are sorted. We keep to pointers to A and B, and advance both
 *      pointers based on whether their pointed elements are the same or not. 
 *      Time complexity: O(m+n). Is it the optimal solution? Hard to say. For some n 
 *      O(mlog(n)) might be better. 
 * 
 * 
 * Extensions: 
 * 1) What if elements of array B is stored on disk, and the memory is limited such 
 *    that you cannot load all elements into the memory at once?
 * 2) How will the complexity change in this case? Are there any factors you need to consider? 
 * 3) How do you change your solution to adapt to this situation? 
 * 
 * Now reading data from B involves loading a disk block from the harddrive.  
 * 
 * 
 * @author Endeavour
 *
 */

public class SortedArrayIntersection {

	
	
	public static ArrayList<Integer> findIntersections(int[] A, int[] B){
		
		ArrayList<Integer> intersection = new ArrayList<Integer>(); 
		
		int pA=0, pB=0; 		
		while(pA < A.length && pB < B.length){ // NOTE it is an AND condition 
			
			if( A[pA] == B[pB]){
				intersection.add(A[pA]); 
				pA++ ; pB++; 
			}else if ( A[pA] < B[pB] )
				pA++ ; 
			else 
				pB++; 
		}		
		return intersection ; 
	}
	
	
	
	
	
	public static ArrayList<Integer> findIntersectionsPairwiseScan(int[] A, int[] B){
	
		ArrayList<Integer> intersection = new ArrayList<Integer>();  
		
		for(int i=0; i<A.length; i++)
			for(int j=0; j<B.length; j++)
				if(A[i] == B[j])
					intersection.add(A[i]); 
		return intersection ; 
	}
	
	
}
