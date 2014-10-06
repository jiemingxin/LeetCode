package tutorials.streams;

import java.util.Collections;
import java.util.LinkedList;

import tutorials.trees.BinaryIndexTree;


/**
 * == Problem == 
 * http://community.topcoder.com/stat?c=problem_statement&pm=6551&rd=9990 
 * 
 * Given a sequence of N integers in the range [0,M), find the sum of medians of N-K+1 
 * contiguous subsequences of length K. (1<=N<=250,000; 1<=K<=1000, M=65536). 
 * 
 * NOTE: 
 *   (1) In this problem the median has a slightly different connotation: it is defined
 *       as "Given K numbers, their median is the ((K+1)/2)-th smallest of them, rounding 
 *       down for even K, and indexing from 1". For example, the median of (1, 2, 6, 5, 4, 3) 
 *       is 3, and the median of (11, 13, 12, 14, 15) is 13.
 *       
 *   (2) The sequence is generated using the following random number generator: 
 *        t(0) = seed 
 *        t(k+1) = ( t(k) * mul + add ) mod 65536  
 *       
 * == Solution == 
 * A Binary Index Tree can be used to solve this problem as it it related to cumulative 
 * frequency. 
 * 
 * @author jack
 *
 */
public class FloatingMedian {

	static int MAX_VALUE = 65536 ; 
	
	/**
	 *  Sum of the medians of the integer stream 
	 * 
	 * @param seed - the seed for generating random numbers 
	 * @param mul  - the 'mul' coefficient for generating random numbers 
	 * @param add  - the 'add' coefficient for generating random numbers 
	 * @param totalNumber - total numbers in the stream 
	 * @param subSeqLength - the length of the sub sequence 
	 * @return 0 the sum of medians in all sub sequences 
	 */
	public static long sumOfMediumByBruteForce(int seed, int mul, int add, int totalNumber, int subSeqLength){
		
		long randNum = seed ; 
		long sumOfMediums = 0;
		int mediumIndex = (subSeqLength+1)/2-1; 
		
		LinkedList<Long> subsequence = new LinkedList<Long>(); 
		subsequence.add( randNum); 
		
		for(int i=1;  i<totalNumber;  i++){
			randNum = (randNum * mul + add) % 65536 ;
		
			subsequence.add( randNum);  
			if(subsequence.size() == subSeqLength){
				LinkedList<Long> copy = new LinkedList<Long>(subsequence); 
				Collections.sort(copy); 				
				sumOfMediums += copy.get(mediumIndex);
				subsequence.pollFirst(); 
			}				
		}
		return sumOfMediums; 
	}
	
	
	public static long sumOfMediumByBIT(int seed, int mul, int add, int totalNumber, int subSeqLength){
		
		long randNum = seed ; 
		long sumOfMediums = 0;
		int mediumIndex = (subSeqLength+1)/2; 
		
		BinaryIndexTree biTree = new BinaryIndexTree(MAX_VALUE); 
		LinkedList<Integer> subsequence = new LinkedList<Integer>();  
		
		biTree.updateCumFreq((int)randNum, 1); 
		subsequence.add((int)randNum); 
	
		for(int i=1;  i<totalNumber;  i++){ 
			randNum = (randNum * mul + add) % 65536 ;  
			biTree.updateCumFreq((int)randNum, 1); 
			subsequence.add((int) randNum);  
			
			if(subsequence.size() == subSeqLength){
				int medium = biTree.findLowestIndex(mediumIndex); 
				sumOfMediums += medium;  
								
				int previusRandNum = subsequence.pollFirst(); 
				biTree.updateCumFreq(previusRandNum, -1); 
			} 
		}
		
		return sumOfMediums; 
	}
	
}
