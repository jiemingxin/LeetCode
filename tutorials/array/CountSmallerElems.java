package tutorials.array;

import tutorials.trees.BinaryIndexTree;

/**
 * == Problem == 
 * Given an array, count the number of smaller elements on the R.H.S 
 * of each element in the array. The output should be an array as well.
 * 
 * 
 * == Examples ==
 * (1)  arr[] =  {12, 1, 2, 3, 0, 11, 4} ==> {6, 1, 1, 1, 0, 1, 0}  
 * (2)  arr[] =  {5, 4, 3, 2, 1}   ==>  {4, 3, 2, 1, 0}  
 * (3)  arr[] =  {1, 2, 3, 4, 5} ==> {0, 0, 0, 0, 0} 
 * 
 * 
 * == Solutions == 
 * (1) double for loop: O(N^2) 
 * (2) Binary Index Tree (BIT): O(MlogM), where M is the maximum value 
 *     inside the array. It requires the array is nonnegative.  
 * 
 * @author jack
 *
 */
public class CountSmallerElems {

	public static int[] countByLooping(int[] elems){
		
		int numElems = elems.length ; 
		int[] outputs = new int[numElems];
		
		for(int i=numElems-2; i>=0; i--){
			int value = elems[i]; 
			int counts= 0;
			for(int j=i+1; j<numElems; j++)
				if(value>elems[j])
					counts++; 
			outputs[i] = counts ; 
		}
		return outputs ; 
	}
	
	
	public static int[] countByBIT(int[] elems){
	
		// get the maximum first 
		int max = elems[0]; 
		int numElems = elems.length; 
		for(int i=0; i<numElems; i++)
			max = Math.max(max, elems[i]); 
		
		BinaryIndexTree biTree = new BinaryIndexTree(max); 
		int[] outputs = new int[numElems]; 
		for(int i=numElems-1; i>=0; i--){
			int value = elems[i]; 
			biTree.updateCumFreq(value, 1);
			int cumFreq    = biTree.readCumFreq(value); 
			int singleFreq = biTree.readSingleFreq(value); 
			outputs[i] = cumFreq - singleFreq ;
		}
		return outputs ; 
	}

	
}
