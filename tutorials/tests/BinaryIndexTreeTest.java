package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.trees.BinaryIndexTree;
import tutorials.utils.RandArray;

public class BinaryIndexTreeTest {

	static int maxs[] ={9,99,999,9999,10000, 20001, 400003, 50005, 60007, 80008};
	
	@Test
	public void testUpdateAccFreq() {
		
		int min=1,arrLen=100, iters=10; 
		for(int i=0; i<iters; i++){
			
			int max = maxs[i]; 
			int[] rands  = RandArray.generateRandIntArr(min, max, arrLen); 
			
			BinaryIndexTree biTree = new BinaryIndexTree(max); 
			for(int j=0; j<arrLen; j++){
				int val = rands[j];
				
				int oldAccFreq = biTree.readCumFreq(val); 
				biTree.updateCumFreq(val,1); 
				int updatedAccFreq = biTree.readCumFreq(val); 
				
				assertEquals(oldAccFreq+1, updatedAccFreq); 
			}
		}	
	}
	
	

	@Test
	public void testReadSingleFreq() {
		
		int min=1, arrLen=100, iters=10; 
		for(int i=0; i<iters; i++){
			
			int max = maxs[i]; 
			int[] rands  = RandArray.generateRandIntArr(min, max, arrLen); 
			int[] freqs  = computeFreqArray(max, rands); 
		
			BinaryIndexTree biTree = new BinaryIndexTree(max); 
			insertValues(biTree, rands); 
			
			for(int j=0; j<arrLen; j++){
				int index = rands[j];
				assertEquals(freqs[index], biTree.readSingleFreq(index)); 
			}
		}
	}
	
	
	
	@Test
	public void testReadAccFreq() {
		
		int min=1, arrLen=100, iters=10; 
		for(int i=0; i<iters; i++){
			
			int max = maxs[i]; 
			int[] rands  = RandArray.generateRandIntArr(min, max, arrLen); 
			int[] freqs  = computeFreqArray(max, rands); 
			int[] accums = computeAccArray(max, freqs); 
			
			BinaryIndexTree biTree = new BinaryIndexTree(max); 
			insertValues(biTree, rands); 
			
			for(int j=0; j<arrLen; j++){
				int index = rands[j];
				assertEquals(accums[index], biTree.readCumFreq(index)); 
			}
		}
	}

	
	
	
	@Test
	public void testFindValue() {
		
		int min=1, arrLen=10, iters=10; 
		for(int i=0; i<iters; i++){
			
			int max = maxs[i]; 
			int[] rands  = RandArray.generateRandIntArr(min, max, arrLen);
		
			int[] freqs  = computeFreqArray(max, rands); 
			int[] accums = computeAccArray(max, freqs);  
			
			BinaryIndexTree biTree = new BinaryIndexTree(max); 
			insertValues(biTree, rands); 
			
			for(int j=1; j<=max; j++){
				int cumFreq = accums[j]; 				
				int key = biTree.findCumFreq(cumFreq); 
				assertEquals(accums[key], cumFreq);
			}
		}
	}

		
	protected int[] computeFreqArray(int max, int[] rands){
		
		int arrLen = rands.length; 
		int[] freqs = new int[max+1]; 
		for(int i=0; i<arrLen; i++) 
			freqs[rands[i]]++; 
		return freqs; 
	}

	
	protected int[] computeAccArray(int max, int[] freqs){
		
		int arrLen = freqs.length;  
		int[] accums = new int[max+1]; 
		for(int i=1; i<arrLen; i++) 
			accums[i] += freqs[i] + accums[i-1]; 
		return accums; 
	}
	
	
	protected void insertValues(BinaryIndexTree biTree, int[] rands){
		
		for(int i=0; i<rands.length; i++){
			biTree.updateCumFreq(rands[i],1); 
		}
	}
	
	
}
