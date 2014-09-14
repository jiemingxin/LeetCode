package tutorials.tests;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;
import tutorials.array.MergeSortedArrays;



public class MergeSortedArraysTest {

	
	protected int[][] initArrs(int numArrs, int arrSize){
		
		Random rand = new Random(); 
		
		int[][] arrs = new int[numArrs][arrSize]; 
		for(int i=0; i<numArrs; i++){
			for(int j=0; j<arrSize; j++)
				arrs[i][j] = rand.nextInt(); 
			Arrays.sort(arrs[i]); 
		}
		
		return arrs;
	}
	
	
	
	protected int[] sortArrs(int[][] arrs){
		
		int arrSize  = arrs[0].length ; 
		int arrCount = arrs.length; 
		int totalNum = arrSize * arrCount ; 
		
		int[] flat = new int[totalNum]; 
		int flatIdx=0;
		for(int i=0; i<arrCount; i++)
			for(int j=0; j<arrSize; j++)
				flat[flatIdx++] = arrs[i][j]; 
		
		Arrays.sort(flat);
		return flat ; 
	}
	
	
	
	
	@Test
	public void testMergeArrays() {
		
		int maxArrsCount=10; 
		int maxArrSize=10; 
		MergeSortedArrays merger = new MergeSortedArrays(); 
		
		for(int numArrs=3; numArrs<maxArrsCount; numArrs++)
			for(int arrSize=1; arrSize<maxArrSize; arrSize++){
				
				int[][] arrs = initArrs(numArrs, arrSize); 
				int[] sorted = sortArrs(arrs); 
				int[] merged = merger.mergeArrays(arrs);
				
				System.out.println(numArrs + " arrays each has " + arrSize + " elements");
				
				System.out.println(Arrays.toString(sorted)); 
				System.out.println(Arrays.toString(merged));
				
				assertArrayEquals(null, sorted, merged); 
				System.out.println("..............");
			}
	}
	
	
	//@Test 
	public void testMergeArraysCase1() {
	
		MergeSortedArrays merger = new MergeSortedArrays(); 
		int[][] arrs = { {-1226848687}, {91865341}, {100317013}}; 
		int[] merged = merger.mergeArrays(arrs);
		int[] sorted = { -1226848687, 91865341, 100317013 }; 
		
		System.out.println(Arrays.toString(merged)); 
		assertArrayEquals(null, sorted, merged); 
	}
	
	
	
}


