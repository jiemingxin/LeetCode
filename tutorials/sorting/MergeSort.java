package tutorials.sorting;


/**
 *  Merge sort with a memory buffer. 
 *  
 *  Merge sort is an O(n log n) comparison-based sorting algorithm. Most implementations 
 *  produce a stable sort, which means that the implementation preserves the input order
 *  of equal elements in the sorted output. 
 *  
 *  http://en.wikipedia.org/wiki/Merge_sort 
 *  
 * @author jack
 *
 */
public class MergeSort {

	public static void sort(int[] arr){
		int[] buf = new int[arr.length];
		sort(arr, buf); 
	}
	
	protected static void sort(int[] arr, int[] buf){
		
		int arrLen = arr.length ; 
		for(int subArrSize=1;  subArrSize<arrLen;  subArrSize*=2)	
			for(int arrStart=0; arrStart<arrLen; arrStart +=subArrSize*2){
				merge(arr, buf, arrStart, subArrSize);
			}		
	}
		

	/**
	 *  Merge two sorted array starting at arrStart, and arrStart+subArrSize respectively 
	 * 
	 * @param arr
	 * @param buf
	 * @param subArrSize
	 */
	protected static void merge(int[] arr, int[] buf, int arrStart, int subArrSize){
		
		int pA = arrStart, pB = arrStart+subArrSize; 
		int pAEnd = Math.min(pA+subArrSize, arr.length); 
		int pBEnd = Math.min(pB+subArrSize, arr.length); 
		
		int bufIdx=0; 
		while( pA<pAEnd && pB<pBEnd){
			if(arr[pA] <= arr[pB]) // the equal sign is needed to ensure stability
				                   // pA appears before pB 
				buf[bufIdx++] = arr[pA++];  
			else
				buf[bufIdx++] = arr[pB++]; 
		}
		
		while( pA<pAEnd ) 
			buf[bufIdx++] = arr[pA++]; 
		while( pB<pBEnd ) 
			buf[bufIdx++] = arr[pB++]; 
			
		// copy the sorted array back to the source arr
		for(int i=0; i<bufIdx; i++)
			arr[arrStart+i] = buf[i];				
	}
		
}
