package tutorials.sorting;

/**
 * http://www.geeksforgeeks.org/counting-sort/  
 * http://en.wikipedia.org/wiki/Counting_sort 
 * 
 * According to the Wikipedia, counting sort is considered as a type of 
 * distribution sort. It is a technique based on keys within a specific range. 
 * It works by counting objects having distinct key values. Then some simple 
 * arithmetic is used to calculate the position of each object in the output sequence. 
 * 
 * NOTES:
 * 1. the time complexity is O(n+k), where n is the size of the input, and k 
 *    is the range of the keys. 
 * 2. Counting sort is efficient if the range of input data is not significantly 
 *    greater than #objects 
 * 3. It is not a comparison based sorting, and is often used as a sub-routine to 
 *    another sorting algorithm like radix sort.
 * 
 * @author jack
 */
public class CountingSort {
	
	public static void sort(int[] arr){
		
		int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
		for(int i=0; i<arr.length; i++){
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]); 
		}
		sort(arr, min, max); 
	}
	
	protected static void sort(int[] arr, int min, int max){
	
		int range  = max - min +1; 
		int arrLen = arr.length; 
		
		int[] counts = new int[range]; 
		int[] sorted = new int[arrLen];
		
		for(int i=0; i<arrLen; i++)
			counts[arr[i]-min]++;
		
		for(int i=1; i<range; i++)
			counts[i] += counts[i-1];
		
		for(int i=arrLen-1; i>=0; i--){
			// (1) note: need to subtract 1 from the counts to locate
			//     the actual index, since the index starts from 0
			//     whereas counting sort cares about nonzero counts 
			// (2) need to populate the sorted array backwards to 
			//     ensure stability 
			sorted[counts[arr[i]-min]-1] = arr[i]; 
			counts[arr[i]-min]--;
		}
			
		for(int i=0; i<arrLen; i++)
			arr[i] = sorted[i]; 
	}
}
