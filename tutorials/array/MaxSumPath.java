package tutorials.array;

/**
 *  == Problem == 
 *  http://www.geeksforgeeks.org/maximum-sum-path-across-two-arrays/ 
 * 
 *  Given sorted arrays such that they may have common elements. Output the sum of
 *  maximum sum path reaching from the beginning of either array to the end of 
 *  either of the two arrays. Note that we can switch array when we encounter 
 *  at common elements 
 *  
 *  == Examples == 
 *  (1) Input:  ar1[] = {2, 3, 7, 10, 12}, ar2[] = {1, 5, 7, 8} 
 *      Output: 35 
 *      Reason: 35 is the sum of 1+5+7+10+12 ( starting from ar2, then switch to ar1 
 *              at the element 7, followed by 10 and 12  
 *      
 *  (2) Input:  ar1[] = {10, 12}, ar2 = {5, 7, 9}
 *     Output: 22
 *     Reason: 22 = 10 + 12. No switch can be made in this example as there is no 
 *             common element. 
 * 
 *  (3) Input: ar1[] = {2, 3, 7, 10, 12, 15, 30, 34} 
 *  		   ar2[] = {1, 5, 7, 8, 10, 15, 16, 19} 
 *      Output: 122 ( 122 is sum of 1, 5, 7, 8, 10, 12, 15, 30, 34) 
 *      
 *  (4) Input: ar1[] = {1, 4, 7, 8, 9  } 
 *             ar2[] = {6, 7, 10 }   
 *   	Output: 30 (6+7+8+9) 
 *   
 *  == Analysis == 
 *  It looks like this problem is quite complicated as we need to consider many 
 *  possible cases of switching at the common elements. If we think it over, 
 *  there are not that many cases. 
 *  
 *  If there are no common element, then the problem is easy, we only need to 
 *  compare the sums of two arrays. For cases with common elements, we have 
 *  two options for the sum paths. As a result, we can align both arrays using
 *  those common elements, and also keep two sums for two paths. Then we can
 *  compare the sums resulted by adding the common elements to both paths. 
 *  
 *  Actually the setting of this problem is quite similar to merge sort. And we
 *  can actually use the same program structure to solve this problem.  
 *           
 * @author jack
 *
 */


public class MaxSumPath {
	
	public static int computeMaxSum(int[] arr1, int[] arr2){
		
		int m = arr1.length, n = arr2.length ; 
		int p1=0, p2=0, sum1=0, sum2=0, maxSum=0; 
		
		while(p1<m && p2<n){
			
			if(arr1[p1] < arr2[p2]){ // increment the smaller pointer 
				sum1 += arr1[p1++]; 
			}else if (arr1[p1] > arr2[p2]){
				sum2 += arr2[p2++]; 
			}else{
				//  we encounter one common element 
				maxSum += (Math.max(sum1, sum2) + arr1[p1]); 
				// increment the pointer and reset sum1 and sum2 
				p1++; p2++; 
				sum1=0; sum2=0; 
			}
		}
		
		while(p1<m){
			sum1 += arr1[p1++]; 
		}
		
		while(p2<n){
			sum2 += arr2[p2++]; 
		}
		
		maxSum += Math.max(sum1, sum2); 
	    return maxSum;		
	}

	

}
