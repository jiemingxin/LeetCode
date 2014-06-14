package tutorials.strings;


/**
 * Problem: 
 *    Given an string, find out its longest palindromic substring. 
 * 
 * Solution I:  naive enumeration 
 * 
 * Solution II: dynamic programming which is based on one property of a 
 *              palindromic string. If S[i,j] is a palindrome, then 
 *              we have (S[i] == S[j]) & ( S[i+1,j-1] is a palindrome || j-i>2) 
 *                
 * Solution III: a linear scan algorithm which is also based on one property of 
 *               palindromic string 
 * 
 * @author endeavour
 *
 */


public class MaxPalindromicSubstring {

	
	/**
	 * Solution I:
	 *   Enumerate all possible substring of the given string. 
	 * Time complexity: 
	 *   O(N^3), where N is the length of the string 
	 * 
	 * @param source
	 * @return
	 */
	public static String naiveSearch(String source){
		
		int length = source.length() ; 
		int maxLen = -1, start = 0; 
		for(int startIdx=0;  startIdx<length;  startIdx++) // inclusive startIndex 
			for(int endIdx=startIdx+1; endIdx<=length; endIdx++) // exclusive endIndex 
			{
				String sstr = source.substring(startIdx,endIdx); 
				if(isPalindrome(sstr))
				{
					int strLen = endIdx-startIdx ; 
					if(strLen > maxLen){
						maxLen = strLen ; 
						start  = startIdx ; 
					}
				}
			}
		return source.substring(start, start+maxLen); 
	}
		
	
	protected static boolean isPalindrome(String sstr){
		
		int i=0, j=sstr.length()-1; 
		while(i<j){
			
			if(sstr.charAt(i) != sstr.charAt(j)){
				return false ; 
			}
			i++ ; j--; 
		}
		return true ; 
	}
	
	
	
		
	/**
	 * Solution II: Memorization 
	 *   Let isPalindrome be a 2D array. isPalindrome[i][j] is true if 
	 *   source[i..j] is a palindromic string. Note that both indices 
	 *   are inclusive indice 
	 * 
	 * Time Complexity: O(N^2), where N is the length of the string 
	 * 
	 * @param source
	 * @return
	 */
	public static String dpSearch(String source){
		
		int strLen = source.length(); 
		boolean[][] isPalindrome = new boolean[strLen][strLen]; 
		
		// base case: single character string (len is 1)
		for(int i=0;  i<strLen;  i++)
			isPalindrome[i][i] = true ; 
		
		// populate the matrix diagonally 
		int maxLen=1; int maxStartIdx=0; 
		for(int offset=1;  offset<strLen;  offset++)
			for(int startIdx=strLen-2; startIdx>=0; startIdx--)
			{
				int endIdx = startIdx + offset ; // inclusive index 
				if( endIdx >= strLen) 
					continue ; 
				char head = source.charAt(startIdx); 
				char tail = source.charAt(endIdx); 
				
				isPalindrome[startIdx][endIdx] = 
						(head==tail) && (offset<2 || isPalindrome[startIdx+1][endIdx-1]); 
				
				if( isPalindrome[startIdx][endIdx]){
					int len = endIdx - startIdx + 1; 
					if(len > maxLen){
						maxLen = len ; 
						maxStartIdx = startIdx; 
					}
				}
			}
		
		return source.substring(maxStartIdx, maxStartIdx+maxLen); 
	}

	
	
	
	
	
	
}
