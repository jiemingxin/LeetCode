package tutorials.strings;

/**
 * 
 * A class written to understand the interview problem of "Finding the 
 * longest substring in a given string" 
 * 
 * @author Fantasy
 * By July 22, 2012 
 * 
 */

public class Palindrome {

	/**
	 * Find out the longest palindromic substring from the given string 
	 * in O(N^2) time
	 *   
	 * @param str
	 */
	public static String quadraticLongestPalindromicSubstr(String str){
		
		int strLen    = str.length() ; 	
		int maxOffset = 0,  left = 0 , right = 0, maxLen  = -1 ; 
		float index   = 0 ;
		
		float centerIndex  = 0.0f ; 
		while( centerIndex < strLen ){ 
			
			left   = (int) Math.floor(centerIndex); 
			right  = (int) Math.ceil(centerIndex); 
			int offset = 0 ; 
			while(true){
				if( left-offset < 0 || right + offset >=strLen ||
					str.charAt(left-offset)!= str.charAt(right+offset))
					break ; 
				offset ++; 
			}
			int  len = (left!=right)? 2*offset: 2*(offset-1)+1; 
			
			if(len > maxLen){
				maxLen    = len ; 
				index     = centerIndex ; 
				maxOffset = offset ; 
			}
			
			// move to the next position 
			centerIndex += 0.5 ; // the linear algorithm does a better job 
		}
	
		// String.substring(beginIndex, endIndex)
		// beginIndex: inclusive, endIndex: exclusive 
		left  =  (int) Math.floor(index) - (maxOffset-1)  ; 
		right =  (int) Math.ceil(index) + (maxOffset-1)  ;  
		
		return str.substring(left,right+1);  
	}
	
	/**
	 * Find out the longest palindromic substring from the given string 
	 * in O(N)time
	 *   
	 * @param str
	 */
	public static String linearLongestPalindromicSubstr(String str){
		
		int strLen     = str.length(); 
		int numLocs    = 2*strLen - 1 ; 		
		int[] lenArray = new int[numLocs];  
		int maxOffset = 0,  maxLen  = -1; 
		int left, right, dist; 
		
		float centerIndex = 0, maxIndex = 0; 
		while( 2*centerIndex < numLocs ){
			
			// expand bilaterally 
			left  = (int) Math.floor(centerIndex); 
			right = (int) Math.ceil(centerIndex); 
			
			int offset = 0; 
			while(true){
				if(left-offset <0 || right+offset >=strLen || 
				   str.charAt(left-offset)!= str.charAt(right+offset)) break; 
				offset ++; 
			}
			int len = (left!=right)? 2*offset: 2*(offset-1)+1; 
			
			// check if it is longer 
			if(len > maxLen){
				maxLen    = len ; 
				maxIndex  = centerIndex ; 
				maxOffset = offset ; 
			}
				
			
			// update the LenArray and find next position for search 
			lenArray[(int)(2*centerIndex)] = len ; 
			float oldIndex = centerIndex ;  
			if( len <= 1) 
				centerIndex += 0.5f ; 
			else{
				int arrayIndex = (int)(2 * centerIndex)  ; 
			    for(dist=1 ;  dist < 2*(offset-1) ; dist++) // search in the L.H.S. of the current center 
				   if(lenArray[arrayIndex - dist]!= 0 )break ;
			   centerIndex = (arrayIndex+dist)/2; 
			}
			
			// uncomment this line to see the actual speed-up
			//System.out.println( oldIndex + "->" + centerIndex) ; 
			
				
//			System.out.print("Len Array :");
//			for(int i=0; i<lenArray.length; i++) 
//				System.out.print(lenArray[i] + ","); 
//			System.out.println(); 
		}
		
		left  =  (int) Math.floor(maxIndex) - (maxOffset-1)  ; 
		right =  (int) Math.ceil( maxIndex) + (maxOffset-1)  ;  
		return str.substring(left, right+1); 	
	}
	
	
	public static void main(String[] args){
		
		String[] instrs = { "abc", "abcba", "cda", "abccbaabs", "ababab", "abcbabcba" }; 
		
		for(String str :instrs){
			System.out.print( "Testing [" + str + "] --> "); 
			String qStr = quadraticLongestPalindromicSubstr(str) ; 
			String lStr = linearLongestPalindromicSubstr(str); 
			if( qStr.compareTo(lStr)==0 ) 
				System.out.println(qStr + " [Passed]") ; 
			else 
				System.out.println("[" + qStr + "] vs ["  + lStr + "]" + " [Failed]"); 
		}
		
	}
}

