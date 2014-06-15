package tutorials.strings;

/**
 * http://codercareer.blogspot.com.au/2013/02/no-43-minimal-number-of-splits-on-string.html 
 * 
 * Problem: 
 *    Given a string, find out the minimum number of splits which result in each substring 
 *  being a palindromic substring 
 *   
 * Analysis: 
 *   This question can be solved by dynamic programming due to the following factors:
 *   (1) there is a recurrence pattern in the problem 
 *   (2) there are overlaps in subproblems 
 * 
 * NOTE:
 *   Things to pay attention when using Dynamic Programming:
 *    (1) the base cases 
 *    (2) the recurrence 
 *    (3) the initialised values 
 *
 * @author endeavour
 *
 */

public class MinPalindromicSplit {

	/**
	 * 
	 * Analysis: 
	 *   This problem can be solved using dynamic programming  
	 * 
	 *   Let f(k) be the minimum number of splits in source[k..N-1], where
	 *   N is the length of the string. We have: 
	 *  
	 *   f(k) = 0 if source[k..N-1] is a palindrome ( both indice are inclusive) 
	 *  	 else 
	 *       = min{ 1 + f(j) }, where  k<j<=N-1 and source[k..j-1] is a palindrome 
	 *  
	 *   Base case: f(N-1) = 0; 
	 *  
	 *   The answer to this problem is f(0) 
	 *  
	 * Time complexity:      
	 *   O(N^2) where N is the length of the given string    
	 *   
	 * NOTE: 
	 *   By default, f(k) is initialized as N-1-k 
	 *   
	 *      
	 * @param source
	 * @return
	 */
	public static int getMinSplits(String source){
		
		int strLen = source.length(); 
		int[] f = new int[strLen]; 
		
		// compute the lookup table 
		boolean[][] isPalindrome = computeLookupTable(source); 
		
		// Note the base case 
		f[strLen-1] = 0 ; 
		for(int i=strLen-2;  i>=0;  i--){
			
			if(isPalindrome[i][strLen-1])
				f[i] = 0 ; 
			else{ 
				
				// NOTE the initialization values 
				int minValue = strLen-1-i ;  // minimum split is at least (strLen-1-i) 
				for(int j=i+1;  j<strLen;  j++)
					if( isPalindrome[i][j-1] ){
						minValue = Math.min(minValue, f[j]+1) ; 
					}
				f[i] = minValue ; 
			}
		}
					
		return f[0]; 
	}
	
	
		
	/**
	 *  Compute the lookup table "isPalindrome", which is a 2D array.  
	 *  
	 *  NOTE: 
	 *  
	 *  (1) isPalindrome[i][j] is true if source[i..j] is a palindrome,
	 *      where i and j are inclusive indice; 
	 *  (2) isPalindrome[i][j] can be computed via dynamic programming: 
	 *      isPalindrome[i][j] is true if 
	 *        charAt(i) == charAt(j) && ((j-i<2) || isPalindrome[i+1][j-1])  
	 *  (3) computing this table requires O(N^2) time, where N is the 
	 *      length of the string 
	 * 
	 * @param source
	 * @return the "isPalindrome" lookup table 
	 */
	protected static boolean[][] computeLookupTable(String source){
		
		int strLen = source.length(); 
		boolean[][] isPalindrome = new boolean[strLen][strLen]; 
		
		// base cases 
		for(int i=0;  i<strLen; i++)
			isPalindrome[i][i] = true; 
		
		for(int diff=1; diff<strLen; diff++)
			for(int startIdx=strLen-2;  startIdx>=0;  startIdx--)
			{
				int endIdx = startIdx + diff ; 
				if( endIdx >= strLen) 
					continue; 
				
				char head = source.charAt(startIdx); 
				char tail = source.charAt(endIdx); 
				
				isPalindrome[startIdx][endIdx] = 
						(head == tail) && ( diff<2 || isPalindrome[startIdx+1][endIdx-1]); 
			}	
		return isPalindrome ; 
		
	}
	

	
	
}
