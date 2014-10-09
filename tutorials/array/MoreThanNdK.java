package tutorials.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * == Problem == 
 * http://www.geeksforgeeks.org/given-an-array-of-of-size-n-finds-all-the-elements-that-appear-more-than-nk-times/ 
 * 
 * Given an array of size n, find all elements in array that appear more than n/k times,
 * where k is a given parameter. 
 * 
 * == Analysis == 
 * (1) Sort the array and then apply a linear scan. 
 *     Time complexity: O(nlogn)+O(n) = O(nlogn) 
 *     
 * (2) Hashing: store the elements and their frequency in a hash table. 
 *     Time complexiyt O(n) but requires extra O(n) space 
 *
 * (3) Using Moore’s Voting Algorithm. Its basic idea is if we cancel 
 *     out each occurrence of the frequent elements e (i.e., elements appearing more than n/k times)
 *     with all the other elements different from e then e will exist. 
 *     
 *     Note that there can never be more than (k-1) elements in the output otherwise there will 
 *     be more than n elements in total. In light of this observation, we can have a solution
 *     that has time complexity of O(nk) with extra O(k-1) space. If n is very large than k then 
 *     this solution is better than solution (1) 
 *     
 * @author jack
 *
 */
public class MoreThanNdK {

	
	public static ArrayList<Integer> searchByHashing(int[] arr, int k){
		
		int arrLen = arr.length; 
		int freq = arrLen / k ; 
		
		Hashtable<Integer,Integer> occurs = new Hashtable<Integer, Integer>();
		for(int i=0;  i<arrLen;  i++){
			Integer key = arr[i]; 
			Integer value = occurs.get(key);
			if(value!=null){
				occurs.put(key, ++value); 
			}else
				occurs.put(key, 1); 
		}
		
		ArrayList<Integer> keys = new ArrayList<Integer>(); 
		for(Enumeration<Integer> iter = occurs.keys(); iter.hasMoreElements(); ){
			Integer key 	= iter.nextElement(); 
			Integer value 	= occurs.get(key); 
			if( value > freq){
				keys.add(key); 
			}
		}
		return keys;
	}
	
	
	
	
	public static ArrayList<Integer> searchBySorting(int[] arr, int k){
		
		Arrays.sort(arr);
		int arrLen = arr.length; 
		int freq = arrLen / k ; 
		
		ArrayList<Integer> keys = new ArrayList<Integer>();  
		for(int i=0; i<arr.length; ){			
			int value = arr[i]; 
			int offset = i+ freq ; 
			if( offset < arrLen && arr[offset] == value){
				keys.add(value); 
				i = offset +1 ;
			}else 
				i += 1; 
		}
		return keys; 	
	}
	
	
	static class Candidate { 
		public int value; 
		public int count; 		
	}
	
	
	
	/**
	 * An implementation based on Moore’s Voting Algorithm: 
	 * (1)  create a 'candidates' array of size (k-1) to store candidate elements 
	 *      and their counts: O(k) in time  
	 * (2)  traverse the array to update the 'candidates' array 
	 *       * an element can be inserted there is vacancy 
	 *       * if an element already exist, increase its count 
	 *       * if there is no space left, decrease all counts. Elements with
	 *         0 count will be removed in the next traversal 
	 *      this step requires O(nk) time 
	 * (3) iterate through the remaining (k-1) candidates. Output elements 
	 *     with frequency larger than the threshold: O(nk) in time  
	 * 
	 * An array based implementation requires O(nk) time. A better data structure
	 * can reduce it to O(nlogk) time. 
	 *      
	 * @param arr
	 * @param k
	 * @return
	 */
	public static ArrayList<Integer> searchByVoting(int[] arr, int k){
		
		int numCands = k-1; 
		int arrLen 	= arr.length ;
		int freqThres = arrLen / k ; 
		
		// (1) create the candidate array 
		Candidate[] cands = new Candidate[numCands]; 
		for(int i=0; i<numCands; i++)
			cands[i] = new Candidate(); 
		
		// (2) update the candidate array  
		for(int i=0; i<arrLen; i++){
			int value = arr[i]; 
			
			int j=0; 
			for( ; j<numCands; j++)
				if(cands[j].value==value){
					cands[j].count++ ; 
					break; 
				}
			
			if(j==numCands){ 
				int c; // the array is full, kick out values with count 0  
				for(c=0; c<numCands; c++)
					if(cands[c].count==0){
						cands[c].value = value ; 
						cands[c].count =1; 
						break ; 
					}
				// decrease all the counts if none of them has 0 counts 
				if(c==numCands)
					for(Candidate cand: cands)
						cand.count -- ; 
			}			
		}
		
		// (3) compute the actual count 
		ArrayList<Integer> keys = new ArrayList<Integer>();    
		for(Candidate cand: cands){
			int count=0; 
			for(int i=0; i<arrLen; i++)
				if(arr[i] == cand.value)
					count ++; 
			if(count > freqThres)
				keys.add(cand.value); 
		}
					
		return keys; 	 
	}

}
