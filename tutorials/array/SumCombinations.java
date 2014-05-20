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
 * The solution is a recursive solution 
 *
 *
 * @author endeavour
 *
 */



public class SumCombinations {
	
	
	///////////////////////////////////////////////////////////////////
	///  Solution from the link above 
	///////////////////////////////////////////////////////////////////
	
	public static void solve(int target, int[] candidates){
		
		int[] index = new int[candidates.length+1]; 
		solve(target, 0, candidates, index, 0); 
	}
	
	
	
	protected static void solve(int target, int sum, int[] candidates, int index[], int endIdx) {
		  if (sum > target)
		    return;
		  if (sum == target)
		    printSum(candidates, index, endIdx);
		 
		  for (int i = index[endIdx];  i<candidates.length;  i++) {
			  index[endIdx+1] = i;
			  solve(target, sum + candidates[i], candidates, index, endIdx+1);
		  }
	} 
	
	
	
	protected static void printSum(int candidates[], int index[], int endIdx) {
		 
		// note the indexing variable 'i' starts from 1 
		for (int i = 1; i <= endIdx; i++)
		    System.out.print( candidates[index[i]] + ((i == endIdx) ? "" : "+") );
		System.out.println(); 
	}
		
	
	
	///////////////////////////////////////////////////////////////////
	///  Incorrect solution... 
	///////////////////////////////////////////////////////////////////
	
	public static void findAllCombinations(int sum, int[] candidates){
		
		int[] selected = new int[candidates.length+1]; 
		findAllCombinations(sum, candidates, selected, 0); 
	}
	
	
	
	protected static void findAllCombinations(int sum, int[] candidates, int[] selected, int startIdx){
		
		// exception handling 
		if( sum < 0) 
			return  ;
		
		// base case 
		if( sum == 0){
			printSelected(candidates, selected); 
			return ; 
		} 
			
		
		// recursive call 
		for(int i=startIdx; i<candidates.length; i++){
			int remain = sum - candidates[i]; 
			selected[i] ++; 
			findAllCombinations(remain, candidates, selected, 0);
			selected[i]-- ; 
		}
	}
	
	
	
	
	public static void printSelected(int[] candidates, int[] selected){
		
		PrintStream out = System.out; 
		
		out.print("[ "); 
		for(int i=0; i<selected.length; i++)
		{
			for(int k=0; k<selected[i]; k++)
				out.print(candidates[i] + " "); 
		}
		out.println("]"); 
	}

	
	
	
	
	
	public static void main(String[] args){
	
		int sum =  7; 
		//int[] candidates = {2, 3, 4}; 
		int[] candidates = {2,3,6,7};
		//int[] candidates = {10, 1, 2, 7, 6, 1, 5}; 
		
		solve(sum, candidates);
		
		//findAllCombinations(sum, candidates); 
	}
	
	
	

}
