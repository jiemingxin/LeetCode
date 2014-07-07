package tutorials.strings;

/**
 * 
 * This class implements the Knuth–Morris–Pratt (KMP) algorithm
 * for string matching 
 * 
 * ======= Analysis ========
 * 	The gist of the KMP algorithm is to slide the pattern string
 *	 as much as possible whenever a mismatch occurs 
 * 
 * 	Let "text" be the source string and "pattern" be the pattern 
 * 	string. When there is a mismatch between text[i] and pattern[j],
 * 	(which means text[i-j-1..i-1] match with pattern[0..j-1] (1) )  
 *  
 * 	The algorithm then slides the pattern string to align text[i] 
 * 	with pattern[j'], such that pattern[0..j'-1] matches 
 * 	text[i-j'-1, i-1] (2) 
 * 
 * 	It is quite natural that j' < j (3) 
 * 
 * 	(1)(2)(3) --> pattern[0..j'-1] is the maximum common prefix 
 * 	and suffix of pattern[0..j]( inclusive indices) 
 *  
 * ======= Computation =======
 *  We want to compute a next[] array, such that next[i] keeps
 *  the length of the maximum common prefix and suffix of patter[0..i].
 *  
 *  To compute the next array, we start with next[0] = 0. To compute 
 *  next[i], we assume next[i-1] is known. 
 *  If pattern[i] == pattern[next[i-1]],
 *       then we can simply append pattern[i] to the max prefix and suffix 
 *       from pattern[0..i-1] 
 *  otherwise, 
 *       we work backwards to compare which pattern[i'] equals 
 *       pattern[next[i'-1]]   
 * 
 * 
 * @author Endeavour
 */

public class KMP {

	/**
	 *  Compute the "Next" array 
	 *  
	 *  Next[0] is a special case 
	 *  
	 */
	protected static void computeNext(String pattern, int[] next){
		
		int strLen = pattern.length(); 
		next[0] = 0; 
		for(int i=1,j=0;  i<strLen;  i++){
			// backward computation, each time when this line is 
			// reached, j is initiated as next[i-1] from last loop 
			while(j>0 && pattern.charAt(i) != pattern.charAt(j))
				j = next[j-1]; 
			// check if we can append the char@i
			if(pattern.charAt(i) == pattern.charAt(j)) 
				j++; 
			
			next[i] = j; 
		}
	}
	
	
	/**
	 * 
	 *  Locate the pattern string in the text string 
	 * 
	 * @param text
	 * @param pattern
	 * @return the index of pattern string in the text string 
	 */
	public static int findString(String text, String pattern)
	{
		int patternLen = pattern.length(); 
		if( patternLen == 0)
			return 0; 
		
		// compute the next array 
		int[] next = new int[patternLen]; 
		computeNext(pattern, next); 
		
		for(int i=1,j=0; i<text.length(); i++){
			// note the resemblance between the following line
			// and the corresponding line in computeNext() 
			while(j>0 && text.charAt(i)!= pattern.charAt(j))
				j = next[j-1]; 
			
			if(text.charAt(i) == pattern.charAt(j))
				j++; 
			
			if( j == patternLen ){
				return i-j+1; 
			}
		}		
		return -1; 
	}

	
}
