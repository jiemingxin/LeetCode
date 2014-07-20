package tutorials.sorting;

/**
 *  
 * http://en.wikipedia.org/wiki/Insertion_sort 
 * 
 * Insertion sort is a simple sorting algorithm that 
 *  builds the final sorted array (or list) one item at a time 
 *  
 * Time complexity:
 *  * best case : theta(N) when the given array is already sorted.  
 *  * worst case: O(N^2) when the given array is sorted in reverse order 
 *  * average case: still quadratic 
 * @author Endeavour
 *
 */
public class InsertionSort {


	public static void sort(int[] arr){
		
		for(int i=1;  i<arr.length;  i++){  // insert from the 2nd element 
			int x = arr[i]; // x is the element to insert 
			int j = i; 
			while( j>0 && arr[j-1] > x ){ //  swap if necessary 
				arr[j] = arr[j-1]; 
				j--;
			}
			arr[j] = x ; 
		}
	}
	
	
	
}
