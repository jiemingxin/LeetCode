package tutorials.array;

/**
 * This is a nice mathematical problem 
 *  http://www.geeksforgeeks.org/rearrange-given-array-place/
 *   
 * == Problem == 
 * Given an array arr[] of size n where every element is in range from 0 to n-1. 
 * Rearrange the given array so that arr[i] becomes arr[arr[i]]. This should be done 
 * with O(1) extra space.
 * 
 * == Analysis ==
 * Since all elements are in the range from 0 to n-1, the input 
 * array is actually a permutation from 0 to n-1. What we need to
 * do is to convert it to another permutation.
 * 
 * Since we can only use O(1) extra space, we need to do in-place 
 * swapping. This is actually similar to the problem of swapping
 * two variables A and B without using extra variable. A generalised
 * solution is given as follows:
 *   A = A op B, B = A op^(-1) B, A = A op(^-1) B,
 * where "op" and "op^{-1}" are inverse operations. One example 
 * is: A = A+B; B=A-B; A=A-B; 
 *  
 * One still needs to keep the value of B using the above method. 
 * In this problem, we can't have an array to keep the original value.
 * If we observe carefully, all values in the array are remainders
 * of n. We can use the additional variable n, and play some tricks
 * on modular arithmetic here:
 * 
 *  (1) we add to (arr[arr[i]] % arrLen) * arrLen to arr[i] 
 *        the "%" operation makes sure that even if arr[arr[i]] has been 
 *        changed, it can still retrieve its old value.
 *  
 *  (2) for each new arr[i], we set arr[i] as arr[i]/arrLen to get 
 *        arr[arr[i]]
 *  
 * @author jack
 *
 */
public class ArrangeArray {

	public static void arrange(int[] arr){
		
		int arrLen = arr.length; 

		for(int i=0;  i<arrLen; i++)
			arr[i] += (arr[arr[i]] % arrLen) * arrLen; 
			
		for(int i=0; i<arrLen; i++)
			arr[i] /=  arrLen ; 
	}
				
}
