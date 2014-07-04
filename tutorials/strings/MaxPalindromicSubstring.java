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

	
	
	/**
	 *  
	 *  Solution III： The Manacher Algorithm 
	 *    
	 *  The key of this algorithm are listed as follows:
	 *  (1) String conversion:
	 *      "#" is inserted between characters in the source string. For example, 
	 *      "abc" --> "#a#b#c#". Let the converted string be S. The benefit of doing
	 *      is that if we expand from position i at the converted string to S[i-d,i+d], 
	 *      then we can know that 'd' is the length of the palindrome
	 *      
	 *  (2) Length calculation:
	 *      We keep an array P, where P[i] stores the length of the maximum palindromic 
	 *      substring centered at S[i]. To populate P, we use the following variables: 
	 *       "center" (the center of current palindrome), and "right" (the inclusive right 
	 *       boundary of current palindrome),
	 *       
	 *       Each time we calculate P[i], we first check the value of its symmetric character
	 *       P[i']. There are two possible cases:
	 *       
	 *        I) R - i > P[i']: it means the right boundary of the palindrome centered S[i] 
	 *        is smaller than R
	 *          ==> there cannot be a palindrome centered at S[i] whose length is longer 
	 *          	than P[i']
	 *          ==> we set P[i] as P[i']
	 *        II) R -i <= P[i']: it means that according to the symmetric property of 
	 *              a palindrome, the right boundary of the palindrome centered at S[i] 
	 *             could expand beyond R
	 *          ==> we need to compare characters from both sides of S[i] in order to 
	 *               determine P[i']
	 *          
	 *   We can keep track of the longest palindrome when we populate the P array.
	 *     
	 *   Some corner cases:
	 *   (1) i' <= 0 ==> P[i] starts from 0 
	 *               ==> we need to compare characters
	 *   (2) left and right are out of boundary
	 */
	public static String linearSearch(String source){
	
		String processed = preProcess(source); 
		int strLen = processed.length(); 
		int[] P = new int[strLen]; 
		int center=0, right=0;  
		
		for(int i=0; i<strLen; i++){
			
			// check the value at the mirror element 
			int i_mirror = center - (i-center);
			if(i_mirror <0)
				P[i] = 0; 
			else 
				P[i] = (right > i ? Math.min(P[i_mirror], right-i):0);
				
			// always need to expand the string 
			int l = i - P[i] - 1; 
			int r = i + P[i] + 1; 
			while(true){
				if(l<0 || r>=strLen)
					break ; 
				if(processed.charAt(l)==processed.charAt(r))
					P[i]++; 
				else
					break ; 
				l--; r++; 
			}
			
			// update the center and boundary if current 
			// palindrome expand past "right" 
			if( i+P[i] > right){
				center = i; 
				right = i+ P[i]; 
			}
		}
		
		//caluclate the max palindromic substring 
		int maxLen=-1, centerIndex=0; 
		for(int i=0; i<strLen; i++)
		{
			if(P[i] > maxLen){
				maxLen = P[i]; 
				centerIndex = i; 
			}
		}

		int startIdx = (centerIndex-maxLen)>>1; 
		int endIdx = startIdx + maxLen ; 
		return source.substring(startIdx, endIdx); 
	}
	
	
	
	protected static  String preProcess(String source){
			
		int strLen = (source.length() << 1) + 1; 
		char[] converted = new char[strLen]; 
		
		for(int i=0; i<strLen-1; i++){
			converted[i] = (i%2==0)? '#': source.charAt(i>>1); 
		}
		converted[strLen-1] = '#' ; 
		return new String(converted); 
	}
	
	
}
