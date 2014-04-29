package tutorials.array;

import tutorials.utils._;


/**
 * 
 * http://leetcode.com/2010/11/finding-minimum-window-in-s-which.html 
 * 
 * Given a set T of characters and a string S, find the minimum window 
 * in S which will contain all the characters in T in complexity O(n). 
 *  e.g.,
 *      S = ¡°ADOBECODEBANC¡±,  T = ¡°ABC¡±
 * Minimum window is ¡°BANC¡±.
 * 
 * @author endeavour
 *
 */

public class MinWindow {
	
	public static int NUM_ASCII_CHARS = 128 ; 
	
	/**
	 * In this implementation it is assumed that all characters
	 * are ASCII characters 
	 * 
	 * Time complexity: O(N), where N is the size of source string 
	 * 
	 * @param source   - the source string 
	 * @param charSet  - the set of characters 
	 * @param minWinBegin - the starting index of the minimum window 
	 * @param minWinEnd   - the finishing index of the minimum window  
	 * @return true if a window can be located, otherwise false 
	 */
	public static boolean locateMinWindow(String source, String charSet, 
			_<Integer> minWinBegin, _<Integer> minWinEnd)
	{
		int[] needToFind = new int[NUM_ASCII_CHARS] ; 
		int[]  hasFound  = new int[NUM_ASCII_CHARS] ; 
		
		int minWinSize  = Integer.MAX_VALUE ;
		int charSetSize = charSet.length(); 
		for(int i=0;  i<charSetSize;  i++)
			needToFind[charSet.charAt(i)]++ ; 
		
		int count = 0 ; 
		for(int begin=0, end=0;  end<source.length(); end++ )
		{
			char c = source.charAt(end); 
			if( needToFind[c] == 0)  // skip the chars not in the set 
				continue ; 
			hasFound[c]++;  // one char in the set is found
			
			if( hasFound[c] <= needToFind[c]) // increment the count only 
				count++ ;                     // if we haven't found enough 
			
			if( count == charSetSize ){ // all the characters have been found, now 
				                        // it is time to advance the begin pointer 
				c = source.charAt(begin); 
				while( needToFind[c]==0 || hasFound[c] > needToFind[c] ){ 
					// the while loop keeps the invariant that all the characters
					// in the set are all contained in this window, while 
					// advancing the begin pointer 
					if( hasFound[c] > needToFind[c]) 
						hasFound[c]--;
					c = source.charAt(++begin);  
				}
				
				// one window has been found 
				int winSize = end - begin + 1; 
				if( winSize < minWinSize ){
					minWinSize = winSize ; 
					minWinBegin.set(begin); 
					minWinEnd.set(end); 
				}
			}
		}
		
		return (count==charSetSize); 
	}
	

}
