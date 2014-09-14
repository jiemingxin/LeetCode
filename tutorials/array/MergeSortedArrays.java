package tutorials.array;

/**
 * == Problem == 
 *  Merge k sorted arrays 
 *   http://www.geeksforgeeks.org/merge-k-sorted-arrays/  
 * 
 * 
 * == Analysis == 
 * Solution I: 
 *   Apply the merge sort to the first two arrays, then merge the 
 *   third array with the merged array, then merge with the fourth array...
 *   
 *   It seems that the time complexity is kn, where k is the #arrays, and n
 *   is the size of each array. However this is not true. The time for the
 *   merge is : 2n+3n+4n+...kn=O(n^2) 
 *   
 * Solution II: 
 *   This problem is similar to the handling of stream data. The idea is 
 *   still to merge k numbers at a time, but we want to use a data structure
 *   to retrieve the minimum values efficiently. Heap is a good option. 
 *   The size of the heap is set to k, which give rise to the time complexity
 *   of O(logk) to retrieve the minimum value. Accordingly the total time 
 *   complexity is O(nklogk). 
 * 
 * @author jack
 *
 */

public class MergeSortedArrays {

	private class HeapNode{ 
		public int value; 
		public int arrIndex;  // the index of the source array 
		public int elemIndex; // the index of the element in the source array
	}
	
	private class MinHeap{ 

		private HeapNode[] elems; 
		
		public MinHeap(int[][] arrs){
			
			// initialise the data 
			int arrsCount = arrs.length; 
			elems = new HeapNode[arrsCount]; // keeps one value from each array 
			for(int i=0, index=0;  i<arrsCount; i++,index++){
				HeapNode node = new HeapNode(); 
				node.value = arrs[i][0]; 
				node.arrIndex  = i; 
				node.elemIndex = 0; 
				elems[index] = node ; 
			}
			
			// create a min heap 
			for(int i=arrsCount/2-1; i>=0; i--)
				minHeapify(i);
		}
		
		
		public void replaceMin(HeapNode node){
			elems[0] = node ; 
			minHeapify(0); 
		}
		
		
		protected int leftChildIndex(int index){ 
				return 2*index+1; 
		}
		
		protected int rightChildIndex(int index){
				return 2*index+2; 
		}
		
		protected HeapNode getMin(){
			return elems[0]; 
		}
	
		/**
		 *  Ensure the heap@index is a min heap 
		 * @param index
		 */
		protected void minHeapify(int index){
			
			int numNodes = elems.length; 
			int leftIndex  = leftChildIndex(index); 
			int rightIndex = rightChildIndex(index); 
			int smallestIndex = index ; 
			
			if( leftIndex < numNodes && elems[leftIndex].value < elems[index].value)
				smallestIndex = leftIndex ; 
			if( rightIndex < numNodes && elems[rightIndex].value < elems[smallestIndex].value)
				smallestIndex = rightIndex ; 
			
			if( smallestIndex != index){
				HeapNode tmp = elems[index]; 
				elems[index] = elems[smallestIndex];
				elems[smallestIndex] = tmp; 
				minHeapify(smallestIndex); 
			}
		}
	}

	
	public int[] mergeArrays(int[][] arrs){
	
		int arrSize = arrs[0].length;  
		int numArrs = arrs.length ; 
		
		int totalNumbers = arrSize * numArrs ; 
		int[] sorted = new int[totalNumbers]; 
		
		MinHeap minHeap = new MinHeap(arrs);
		for(int i=0;  i<totalNumbers; i++){
			HeapNode node = minHeap.getMin(); 
			sorted[i] = node.value ; 
			
			if(node.elemIndex +1 < arrSize){
				node.elemIndex++; 
				node.value = arrs[node.arrIndex][node.elemIndex]; 
			}else
				node.value = Integer.MAX_VALUE ; 
			
			minHeap.replaceMin(node); 
		}
		
		return sorted; 
	}
}
