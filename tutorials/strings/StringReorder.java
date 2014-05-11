package tutorials.strings;

/**
 * 
 *  Problem: 
 *    http://leetcode.com/2010/05/here-is-another-google-phone-interview.html 
 *    
 *   Given a string of lowercase characters, reorder them such that the same 
 *   characters are at least distance d from each other.
 *   
 *   Input: { a, b, b }, distance = 2 
 *   Output: { b, a, b }
 * 
 * @author endeavour
 *
 */

public class StringReorder {
	
	public static int NUM_ASCII_CHARS = 128 ;  
	
	
	/**
	 * Reorder the string such that duplicated characters are at least "dist" 
	 * apart from each other. Note that There could be more than one solution 
	 * for the same given string 
	 * 
	 * This problem can be solved using a greedy algorithm. The idea is to insert
	 * a character to the reordered string each time. The character to insert 
	 * depends on the following factors:
	 *    (1) the same character should be inserted "dist" apart 
	 *    (2) insert the characters with maximum frequency first 
	 *  
	 * 
	 * @param source
	 * @return
	 */
	public static String reorderString(String source, int dist){
		
		// collect the character frequency 
		int[] occur = new int[NUM_ASCII_CHARS] ; 
		for(int i=0; i<source.length(); i++) 
			occur[source.charAt(i)] ++ ; 
		
		// now start to insert, but we need some accounting props 
		
		
		
		
		
		
		return null; 
		
	} 
		
}
