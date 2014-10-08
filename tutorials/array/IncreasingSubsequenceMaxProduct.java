package tutorials.array;

import tutorials.trees.AVLTree;
import tutorials.trees.AVLTreeNode;

/**
 * == Problem == 
 *  http://www.geeksforgeeks.org/increasing-subsequence-of-length-three-with-maximum-product/ 
 *  
 *  Find the increasing subsequence of length three with maximum product from a nonnegative 
 *  array. Examples: 
 *  (1) {6, 7, 8, 1, 2, 3, 9, 10}  ==> {8,9,10} 
 *  (2) {1, 5, 10, 8, 9} ==> {5,8,9} 
 *  
 * == Analysis ==
 *  (1) This problem is similar to the problem of ThreeIncreasingElements. The only 
 *      difference is that this question has the maximum product constraint on the 
 *      sub sequence. As a result, this problem can be solved by a similar approach, 
 *      i.e., the two-way search. For each element A[i] in the array, we find the 
 *      maximum of smaller element its left side, and the maximum of greater number 
 *      on its right side. 
 *      The overall time complexity is O(N^2) 
 *  
 *  (2) The key to this problem is to compute these two arrays:
 *      maxLesser[]: 
 *        maxLesser[i] is the maximum of values smaller than arr[i] in arr[0..i]  
 *      maxGreater[]: 
 *        maxGreater[i] is the maximum of values bigger than arr[i]  in arr[i+1, end] 
 *      
 *      Solution 1 computes them in a brute-force manner. In fact, they can be computed 
 *      more efficiently.
 *      (i)  To compute "maxLesser", we need an AVL tree. For each element arr[i], we 
 *           insert the values on its left side, and query the floor value of arr[i]. 
 *           Time complexity: O(NlongN), where N is the length of the array ; 
 *      (ii) To compute "maxGreater", we need a linear scan starting from the right end 
 *           of the array 
 *       	 Time complexity: O(N), where N is the length of the array 
 * 
 * @author jack
 *
 */
public class IncreasingSubsequenceMaxProduct {

	
	public static String searchByTwoWayScan(int[] arr){
	
		int arrLen 		= arr.length; 
		int maxProduct 	= -1; 
		StringBuilder stringBuilder = null; 
		for(int i=1;  i<arrLen;  i++){
			
			int val = arr[i]; 
			
			// search for the max lesser 
			int maxLesser=-1; 
			for(int j=0;   j<i;  j++)
				if(arr[j] < val){ 
					if( maxLesser==-1 )
						maxLesser = arr[j];
					else 
						maxLesser = Math.max(arr[j], maxLesser); 
				}
			if(maxLesser==-1)
				continue; 
			
			// search for the maxGreater 
			int maxGreater=-1; 
			for(int k=i+1;  k<arrLen;  k++)
				if(arr[k] > val){ 
					if( maxGreater==-1 )
						maxGreater = arr[k];
					else 
						maxGreater = Math.max(arr[k], maxGreater); 
				}
			if(maxGreater==-1)
				continue; 
			
			// compute the max product 
			int product = maxLesser * val * maxGreater ; 
			if( product > maxProduct){
				maxProduct = product ; 
				stringBuilder = new StringBuilder(); 
				stringBuilder.append(maxLesser + "," + val + "," +maxGreater); 
			}
		}
			
		if(stringBuilder!=null)
			return stringBuilder.toString();
		else 
			return null; 		
	}
	
	
	
	
	public static String searchByAVLTree(int[] arr){
	
		int arrLen = arr.length ; 
		AVLTree avlTree  = new AVLTree(); 
		int maxLesser[]  = new int[arrLen]; 
		int maxGreater[] = new int[arrLen];
		
		// compute maxLesser 
		maxLesser[0]=-1; 
		avlTree.insert(arr[0]); 
		for(int i=1;  i<arrLen;  i++){
			int currNum = arr[i]; 
			AVLTreeNode node = avlTree.floor( currNum );
			if(node!=null && node.value != currNum ) // strictly smaller 
				maxLesser[i] = node.value; 
			else 
				maxLesser[i] = -1; 
			avlTree.insert(currNum);
		}
		
		// compute maxGreater
		int max = arr[arrLen-1];
		maxGreater[arrLen-1]=-1; 
		for(int j=arrLen-2; j>=0; j--){
			if(arr[j] >= max){  // strictly bigger 
				max = arr[j]; 
				maxGreater[j]=-1;
			}else
				maxGreater[j] = max; 
		}
			
		// now compute the max product
		int maxProduct 	= -1; 
		StringBuilder stringBuilder = null; 
		for(int k=0;  k<arrLen; k++)
			if(maxLesser[k]!=-1 && maxGreater[k]!=-1){
				int product = maxLesser[k] * arr[k] * maxGreater[k]; 
				if( product > maxProduct){
					maxProduct = product ; 
					stringBuilder = new StringBuilder(); 
					stringBuilder.append(maxLesser[k] + "," + arr[k] + "," +maxGreater[k]); 
				}
			}
		
		if(stringBuilder!=null)
			return stringBuilder.toString();
		else 
			return null; 		
	}
		
	
}
