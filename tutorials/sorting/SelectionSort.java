package tutorials.sorting;

/**
 * 
 * http://en.wikipedia.org/wiki/Selection_sort 
 * 
 * Selection sort is an in-place sorting. It has more comparisons than insertion sort however 
 * it is preferable to insertion sort in terms of number of writes. 
 * 
 * During sorting, the array contains two parts: a sorted part followed by an unsorted part. 
 * The main idea of it is to select a minimum value from the unsorted part each time, and then
 * append it to the sorted part.  
 * 
 * Time complexity: theta(n^2) 
 * Space complexity: O(1) 
 * 
 * @author jack
 *
 */

public class SelectionSort {

	
	public static void sort(int[] arr){	
		sort(arr, 0, arr.length-1); 
	}
	
	
	
	/**
	 *  Use selection sort to sort arr[begin, end] 
	 * 
	 * @param arr
	 * @param begin
	 * @param end
	 */
	protected static void sort(int[] arr, int begin, int end){
	
		if(begin < end){
			
			// the outer loop only touches the second last one 
			for(int i=begin; i<=end-1; i++){ 
				
				int minIndex = i ; 
				 // the inner loop can touch the last one 
				for(int j=i+1; j<=end; j++)
					if(arr[j] < arr[minIndex])
						minIndex = j ; 
				
				// only swap when necessary 
				if( minIndex != i){  
					int tmp = arr[i];
					arr[i] = arr[minIndex]; 
					arr[minIndex] = tmp; 
				}
			}
			
		}
	}
	
}
