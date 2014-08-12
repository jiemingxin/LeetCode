package tutorials.array;

/**
 * 
 * http://leetcode.com/2011/01/find-k-th-smallest-element-in-union-of.html 
 * http://nriverwang.blogspot.com.au/2013/04/k-th-smallest-element-of-two-sorted.html 
 * 
 * Problem:
 *   Given two sorted arrays A, B of size m and n respectively. Find the k-th 
 * smallest element in the union of A and B. You can assume that there are no 
 * duplicate elements.
 * 
 * Solution I: 
 *   As per the idea of merge sort, merge two arrays until the k-th 
 *   element is found. Time complexity : theta(k) 
 *     
 * Solution II: 
 *   This solution is not trivial. Since two arrays are sorted, we can make
 *   use of binary search. In a sorted array, the k-th smallest element must
 *   be larger than (k-1) numbers.
 *  
 *   Assume A[i] is the very element we want, then obviously A[i] is larger
 *   than i numbers. To make sure A[i] is larger than j=k-1-i numbers in B, we 
 *   must have B[j-1] <= A[i] <= B[j]. 
 *   
 *   Based on this analysis, 
 *   
 *   We start the binary search from the mid element of A[i], 
 *   Let j = k-1-i 
 *   (1) if B[j-1] <= A[i] && A[i] <=B[j] 
 *         return A[i]
 *   (2) if (A[i] > B[j]) 
 *         => A[i] is larger than i+j+1 numbers, 
 *         => A[i] is larger than k numbers 
 *         => A[i] is too large
 *         => search the desired A[i'] in A[0..i-1] inclusively 
 *         
 *   (3) A[i] < B[j-1] => A[i] is lesser than k elements 
 *         => search the value in A[i+1..M-1] 
 *   
 *   We need to consider the following corner cases:
 *   (1) the answer is in B : this happens when we finish searching A 
 *   (2) i>=k ==> A[i] is at least greater than k numbers 
 *            ==> A[i] is at least the (k+1)th element
 *            ==>  search the value in A[0..i-1] 
 *   (3) i+n < k-1 ==> even if A[i] is larger than all values in B,
 *                     A[i] cannot be larger than (k-1) numbers 
 *                 ==> A[i] will be at most (k-1)th element 
 *   (4) j=k-1-i <=0 ==> like case (1) 
 *   (4) j>(n-1) ==> there is not enough elements in B to make 
 *                   sure A[i] is larger than (k-1) elements 
 *               ==> increase i ==> search in A[i+1, M-1] 
 *   
 *   Time complexity : O(log(M) + O(log(N)) 
 * 
 * @author Endeavour
 *
 */
public class kthSmallestElem {

	
	
	/**
	 *   Find out the k-th smallest element by merging two 
	 *   arrays 
	 *   
	 * @param A
	 * @param B
	 * @param k
	 * @return
	 */
	public static int mergeFind(int[] A, int[] B, int k){
	
		int m = A.length; 
		int n = B.length; 
		
		if(k<0 || k>m+n)
			return -1; 
		
		int ret=0, pA=0, pB=0; 
		for(int i=0;  i<k;  i++){
			
		  if( pA <m && pB <n){
			if(A[pA] < B[pB])
				ret = A[pA++]; 
			else
				ret = B[pB++]; 	
		  }else{
			if( pA >=m)
				ret = B[pB++]; 
			else 
				ret = A[pA++]; 
		  }	
		}
		return ret ; 
	}
	
	
	
	/**
	 *  This method is based on binary search 
	 * 
	 * 
	 * 
	 * @param A
	 * @param B
	 * @param k
	 * @return
	 */
	public static int searchFind(int[] A, int[] B, int k){
		return searchFind(A, B, k, 0, A.length-1); 
	}
	
	
	
	/**
	 *  Use binary search to search for the k-th element in the union
	 *  of A and B. 
	 *   
	 * @param A
	 * @param B
	 * @param k
	 * @param p - the inclusive begin index in A 
	 * @param q - the inclusive end index in A 
	 * @return
	 */
	protected static int searchFind(int[] A, int[] B, int k, int p, int q){
		
		int m = A.length ; 
		int n = B.length ; 
		
		if( p > q)
			return searchFind(B, A, k, 0, n-1); 
		
	    int i = p + (q - p) / 2;
	    int j = k - 1 - i - 1;
	        
	    if ((j < 0 || (j < n && A[i] >= B[j])) 
	        && (j+1 >= n || (j+1 >= 0 && A[i] <= B[j+1]))) {
	        return A[i];
	    } else if (j < 0 || (j+1 < n && A[i] > B[j+1])) {
	        return searchFind(A, B, k, p, i-1);
	    } else {
	        return searchFind(A, B, k, i+1, q);
	    }   
	}
}
	