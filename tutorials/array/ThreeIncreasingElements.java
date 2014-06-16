package tutorials.array;

/**
 * 
 * http://codercareer.blogspot.com.au/2013/02/no-42-three-increasing-elements-in-array.html 
 * 
 * Problem: 
 *    Given an array of integers A, find three indices i, j, k, such that i<j<k and A[i]<A[j]<A[k] 
 *   
 * Analysis:
 *   (1) As always, this problem can be solved via a naive search algorithm. My idea was a solution
 *       with O(N^3) time complexity.  However it can be made more efficient, via a two-way search. 
 *       For each element A[i] in the array, we check if there is a smaller element on its left 
 *       side, and a greater number on its right side. The overall time complexity is O(N^2) 
 *       
 * 
 * @author Endeavor
 *
 */

public class ThreeIncreasingElements {
	
	
	/**
	 * 
	 * Naive search: 
	 *   For each element, search in its left and right hand side 
	 * Time Complexity: 
	 *   O(N^2) 
	 *
	 * @param arr
	 */
	public static void naiveQuadraticSearch(int[] arr){
		
		for(int idx=0; idx<arr.length; idx++){
			
			int value = arr[idx];
			
			// search for the smaller value 
			int smallIdx=-1; 
			for(int j=idx-1; j>=0; j--){
				if(arr[j] < value){
					smallIdx = j;
					break ; 
				}
			}
			if(smallIdx==-1)
				continue; 
			
			// search for the big value 
			int greatIdx = -1; 
			for(int k=idx+1; k<arr.length; k++)
				if(arr[k] > value){
					greatIdx = k;
					break ; 
				}
			
			if(smallIdx!=-1 && greatIdx!=-1){
				System.out.println(" [" + smallIdx  + "]:"  + arr[smallIdx] + ", " + 
								   " [" + idx + "]:" + arr[idx] + "," +  
								   " [" + greatIdx  + "]:"  + arr[greatIdx] + " "); 
				return ; 
			}
		}
		System.out.println("There is no such triplets") ;
	}
	
	
	
	
	/**
	 * Linear search:
	 *    The problem with the naive search is that, it does not memorise any
	 *    interim steps. For example, if we have A[i] < A[j], and 
	 *    A[j] < A[k]  then we have found a triplet. The naive search will 
	 *    ignore such relation when it conducts a search for a new array 
	 *    element. 
	 *    
	 *    In this solution we choose to store the min & max values from 
	 *    left and right respectively. Let leftMin and rightMax be two arrays.
	 *    Specifically, leftMin[i] keeps the index of minimum for arr[0..i] 
	 *    inclusively. Likewise, rightMax[i] stores the index of maximum for 
	 *    arr[i..N-1] inclusively. 
	 *    
	 *    As per these two arrays, the two inner-loops inside solution I can be 
	 *    reduced to a constant time table look-up 
	 * 
	 * Complexity 
	 *    O(N) in time and O(N) space consumption 
	 * 
	 * @param arr
	 */
	public static void linearSearch(int[] arr){
		
		int numElems = arr.length; 
		
		// construct the leftMin array 
		int[] leftMin = new int[numElems]; 
		int minValue = Integer.MAX_VALUE ; 
		for(int i=0;  i<numElems; i++)
			if( minValue > arr[i]){
				minValue = arr[i]; 
				leftMin[i] = i ; 
			}else 
				leftMin[i] = leftMin[i-1]; 
		
		
		// construct the rightMax array 
		int[] rightMax = new int[numElems]; 
		int maxValue = Integer.MIN_VALUE ; 
		for(int j=numElems-1;  j>=0; j--)
			if( maxValue < arr[j]){
				maxValue = arr[j]; 
				rightMax[j] = j ; 
			}else{
				rightMax[j] = rightMax[j+1];
			}
		
		
		// now do the search 
		for(int idx=0;  idx<numElems; idx++){
			int smallIdx = leftMin[idx]; 
			int greatIdx = rightMax[idx]; 
			
			if(arr[idx] > arr[smallIdx] && arr[idx] < arr[greatIdx] ){
				System.out.println(" [" + smallIdx  + "]:"  + arr[smallIdx] + ", " + 
						   " [" + idx + "]:" + arr[idx] + "," +  
						   " [" + greatIdx  + "]:"  + arr[greatIdx] + " "); 
				return ; 
			}
		}
		
		System.out.println("There is no such triplets") ; 
	}
	
	
	
	
	
	
	
	public static void main(String[] args){
		
		int[] arr = { 3, 2, 5, 1, 4, 7, 9, 6, 8 };   
		ThreeIncreasingElements.naiveQuadraticSearch(arr); 
		ThreeIncreasingElements.linearSearch(arr); 
		
	}
	
	
	

}
