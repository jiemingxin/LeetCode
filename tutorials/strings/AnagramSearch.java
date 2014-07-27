package tutorials.strings;

/**
 * == Problem == 
 * 
 * Given a string "text" and a string "pattern", output all occurrence
 * of pattern and its anagram in "text". You may assume "text" is longer
 * than "pattern" 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * @author Endeavour
 *
 */

public class AnagramSearch {

	public static int NUM_CHARS = 256 ; 
	
	public static void search(String text, String pattern){
		
		// collect statistics 
		int[] needToFind = new int[NUM_CHARS]; 
		int[] hasFound   = new int[NUM_CHARS]; 
		int patternLength = pattern.length(); 
		int textLength = text.length(); 
		for(int i=0; i<patternLength; i++)
			needToFind[ pattern.charAt(i)]++; 
		
		int count=0; 
		for(int begin=0,end=0;  end<textLength;  end++){
			
			char c = text.charAt(end); 
			if(needToFind[c]==0)
				continue ; 
			hasFound[c] ++ ; 
			
			if(hasFound[c] <= needToFind[c]) 
				count ++ ; 
			
			if(count == patternLength){
				c = text.charAt(begin); 
				while( needToFind[c]==0 || hasFound[c] > needToFind[c]){
					if(hasFound[c] > needToFind[c])
						hasFound[c]--; 
					c = text.charAt(++begin); 
				}

				int winSize = end - begin +1 ; 
				if(winSize == patternLength)
					System.out.println(begin); 
			}
		}

		
	}
	
	
}
