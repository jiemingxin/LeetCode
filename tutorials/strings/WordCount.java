package tutorials.strings;


/**
 * 
 *  This class counts #words inside a given string. 
 *  
 *  http://leetcode.com/2010/02/c-code-to-count-number-of-words-in.html 
 *  There is a bug in his implementation. His implementation did not consider
 *  the case where the last character in the given string is an alphabetical 
 *  character 
 *  
 * 
 * @author endeavour
 *
 */

public class WordCount {

	public static int countWords(String str){
		
		boolean inWord = false; 
		int numWords = 0; 
		
		for(int i=0;  i<str.length(); i++){
			
			char c = str.charAt(i); 
			if( !inWord && (Character.isLetter(c)||Character.isDigit(c)) ){  // getting into a word 
				inWord = true ; 
			}else if ( inWord && !Character.isLetter(c) && !Character.isDigit(c) ) {  // from word to spaces, increment the count 
				numWords ++ ; 
			}
		}
		
		if(inWord)  // the given string could end with an alphabetical character 
			numWords ++; 

		return numWords ; 
	}
	
	
	
}


