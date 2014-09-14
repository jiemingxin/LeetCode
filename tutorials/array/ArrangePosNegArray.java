package tutorials.array;

/**
 * == Problem == 
 * http://www.geeksforgeeks.org/rearrange-array-alternating-positive-negative-items-o1-extra-space/ 
 * Rearrange in alternating positive & negative items with O(1) extra space
 * 
 * == My Solution == 
 * (1) use Quicksort's partition method to move negative numbers before the positive numbers
 * (2) insert positive numbers between negative numbers 
 * 
 * @author jack
 *
 */


public class ArrangePosNegArray {

	
	public static void arrange(int[] arr){
	
		// step 1: move negative numbers before the positive figures 
		int lesserIndex=-1;
		int arrLen = arr.length ; 
		for(int i=0; i<arrLen; i++){
			if(arr[i]<0){
				lesserIndex++; 
				int tmp = arr[lesserIndex]; 
				arr[lesserIndex] = arr[i];
				arr[i] = tmp; 
			}
		}
		
		// step 2: start alternating 
		int negBound = lesserIndex + 1; 
		int posIndex = negBound; 
		for(int negIndex=0; negIndex<negBound && posIndex<arrLen; negIndex+=2, posIndex+=1){
			int tmp = arr[posIndex]; 
			arr[posIndex] = arr[negIndex] ; 
			arr[negIndex] = tmp ;
			negBound++;
		}
		
	}
	
	
	
	
}
