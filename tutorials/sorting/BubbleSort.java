package tutorials.sorting;


/**
 * http://en.wikipedia.org/wiki/Bubble_sort 
 * 
 * Bubble sort is an simple algorithm that sorts an array by repeatedly swapping 
 * adjacent array elements if they are in wrong order 
 * 
 * Time Complexity:
 *  Best case O(N) for already-sorted array 
 *  Worst and average case O(N^2) for unsorted array 
 *  It is average case determines that it is not practical for large N. 
 *  
 * Its advantage over other sorting algorithms but not insertion is its 
 * capability of knowing when the array is sorted.  
 * 
 * Depending on the implementation, it might not be a stable sorting 
 * algorithm 
 * 
 * @author jack
 *
 */

public class BubbleSort {

	public static void sort(int[] arr){	
		sort(arr, 0, arr.length-1); 
	}
	
	

	/**
	 *  Use bubble sort to sort arr[begin, end] 
	 * 
	 * @param arr
	 * @param begin
	 * @param end
	 */
	protected static void sort(int[] arr, int begin, int end){
	
		if(begin < end){
			int arrLen = end - begin +1; 
			boolean swap; 
			do{
				swap = false; 
				for(int i=1; i<arrLen; i++)
					if(arr[i-1] > arr[i]){
						int tmp  = arr[i-1];
						arr[i-1] = arr[i];
						arr[i] = tmp ; 
						swap = true ; 
					}
			}while(swap); 
		}
	}
	
}
