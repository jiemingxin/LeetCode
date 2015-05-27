package tutorials.sorting;


/**
 *  Sort a given array using max Heap 
 * 
 * 
 * @author jack
 *
 */
public class HeapSort {

	
	public static void sort(int[] arr){
		
		int arrLen = arr.length ; 
		buildMaxHeap(arr, arrLen); // time complexity O(n) 
		for(int i=arrLen-1;  i>0;  i--){
			swap(arr, i, 0);
			maxHeapify(arr, 0, i);  // O(logn)
		}
	}
	
	
	protected static void maxHeapify(int[] arr, int index, int arrLen){
		
		if( index <0 || index>=arrLen)
			return ; 
		
		int left = 2*index+1; 
		int right = 2*index+2; 
		int maxIndex = index ; 
		
		if( left <arrLen && arr[left] > arr[maxIndex]){
			maxIndex = left ; 			
		}
		
		if( right <arrLen && arr[right] > arr[maxIndex]){
			maxIndex = right ; 
		}
		
		if( maxIndex != index){
			swap(arr, maxIndex, index); 
			maxHeapify(arr, maxIndex, arrLen); 
		}
	}
	
	
	protected static void buildMaxHeap(int[] arr, int length){
		
		for(int i=length/2-1; i>=0; i--)
			maxHeapify(arr,i,length); 
	}
	
	
	
	protected static void swap(int[] arr, int i, int j){
		
		int tmp = arr[i]; 
		arr[i] = arr[j]; 
		arr[j] = tmp; 
	}
	
	
}
