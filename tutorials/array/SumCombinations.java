package tutorials.array;

import java.io.PrintStream;


/**
 * 
 * Given a target number, and a series of candidate numbers, print out all combinations, 
 * so that the sum of candidate numbers equals to the target.
 * Here order is not important, so don¡¯t print the duplicated combination.
 * 
 * e.g. target is 7, candidate is 2,3,6,7 
 * output should be 7 and 3+2+2 (but not print 2+3+2, 2+2+3)
 *
 *  http://leetcode.com/2010/09/print-all-combinations-of-number-as-sum.html 
 *
 * @author endeavour
 *
 */



public class SumCombinations {
	
	
	public static void findAllCombinations(int sum, int[] candidates){
		
		int[] selected = new int[candidates.length]; 
		findAllCombinations(sum, candidates, selected); 
	}
	
	
	
	protected static void findAllCombinations(int sum, int[] candidates, int[] selected){
		
		// base case 
		if( sum < 0) 
			return  ; 
		
		for(int i=0; i<candidates.length; i++){
			if(sum == candidates[i]){ 
				selected[i] ++; 
				printSelected(candidates, selected);
				return ; 
			}
		}
		
		
		for(int i=0; i<candidates.length; i++){
			int remain = sum - candidates[i]; 
			selected[i] ++; 
			findAllCombinations(remain, candidates, selected);
			selected[i]-- ; 
		}
	}
	
	
	
	public static void printSelected(int[] candidates, int[] selected){
		
		PrintStream out = System.out; 
		
		out.print("[ "); 
		for(int i=0; i<selected.length; i++)
		{
			for(int k=0; k<selected[i]; k++)
				out.print(candidates[i] + ","); 
		}
		out.println(" ]"); 
	}

	
	
	
	
	
	public static void main(String[] args){
	
		int sum =  7; 
		int[] candidates = {2, 2, 3, 4}; 
		findAllCombinations(sum, candidates); 
	}
	
	
	

}
