package tutorials.trees;

/**
 * Binary Index Tree 
 * 
 * http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=binaryIndexedTrees 
 * (NOTE: this reference is not well written)  
 * 
 * A Binary Index Tree (BIT) can be considered as a compressed binary tree. It can
 * be applied to the problem of counting frequencies for positive integer numbers. 
 * It provides efficient solutions for the following two operations: 
 *  (1) update the frequency for i 
 *  (2) retrieve the cumulative frequency for a range from i to j, 
 * where i and j are positive integers 
 * 
 * The intuition behind the BIT is to precompute the cumulative frequency of all 
 * elements before specific points in the range. The advantage of doing so is that 
 * we can figure out the cumulative sum at a point by just summing up the right 
 * combinations of precomputed sums. 
 * 
 * There are two sets of frequencies, namely the actual frequency and the tree frequency. 
 * Similarly there are two sets of indices, namely the actual index and the tree index. 
 * Let F be the frequency array, and Tree be the tree array. The tree array is magically 
 * encoded such that Tree[treeIdx] is the accumulative sum of Tree[treeIdx-2^r+1..treeIdx], 
 * where r is the index of the first nonzero bit for treeIdx. 
 *  
 * Due to such encoding, a BIT has such a property that: 
 *  for each node i, its accumulative value is the sum of all the accumulative values from 
 *  its left sub tree. 
 * 
 * @author jack
 */

public class BinaryIndexTree {

	private int[] treeFreqs ; 
	private int maxValue ; 
		
	public BinaryIndexTree(int maxVal){
		
		treeFreqs = new int[maxVal +1]; // the index 0 will not be used
		maxValue  = maxVal; 
	}
	
	
	/**
	 *  Read the accumulative frequency for F[1..idx].  
	 * 
	 * @param idx - the inclusive index for the accumulative index. It is 
	 *              used as both a tree index and also actual index 
	 * @return
	 */
	public int readCumFreq(int idx){
		
		int sum = 0; 
		while(idx>0){
			sum += treeFreqs[idx]; 
			idx -= (idx&-idx);  // idx&-idx isolates the first nonzero bit in idx 
		}
		return sum ; 
	}
	
	
	/**
	 * Add the given value to the accumulative frequency for F[1..idx], which
	 * will affect any accumulative frequency covering this range. 
	 * 
	 * @param idx - the inclusive index for the accumulative index. 
	 * @param val - the given value 
	 */
	public void updateCumFreq(int idx, int val){
		
		while(idx <= maxValue){
			treeFreqs[idx] += val; 
			idx += (idx&-idx);
		}
	}
	
	
	/**
	 * Read the actual frequency for the given value, which is 
	 * actually the given index 
	 */
	public int readSingleFreq(int idx){
		
		if(idx<=0 || idx> maxValue)
			return 0; 
			
		int freq   = treeFreqs[idx]; 
		int endIdx = idx - (idx&-idx);
		idx--; 
		while(idx != endIdx){
			freq -= treeFreqs[idx]; 
			idx  -= (idx&-idx); 
		}
		return freq; 
	}
	
	
	/**
	 *  Return an index having the given accumulative frequency value
	 * 
	 * @param freq
	 * @return
	 */
	public int findCumFreq(int cumFreq){
		
		int bitMask = highestBit(maxValue); 
		int idx = 0, freq = cumFreq; 
				
		while(bitMask!=0 && idx <= maxValue){	
			int treeIdx = idx + bitMask; 
			if( treeIdx > maxValue){
				// this is necessary to avoid out of boundary exception
			}else if( freq == treeFreqs[treeIdx])
				return treeIdx; 
			else if(freq >= treeFreqs[treeIdx]){
				freq -= treeFreqs[treeIdx]; 
				idx = treeIdx ; 
			}
			bitMask >>= 1; 
		}
		return freq==0?idx:-1; 
	}
	

	protected int highestBit(int value){
		
		if(value==0)
			return 0; 	
		int ret=1; 
		while( (value >>= 1)!= 0)
			ret <<= 1; 
		return ret; 
	}
	
}
