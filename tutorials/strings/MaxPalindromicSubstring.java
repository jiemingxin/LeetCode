package tutorials.string;


/**
 *  http://en.wikipedia.org/wiki/Longest_palindromic_substring 
 * 
 *  This class implements the linear algorithm for finding the longest palindromic substring. 
 *  The linear algorithm takes advantage of the symmetric property of a palindrome. 
 *  
 *  The key of the points are listed as follows:
 *  (1) String conversion: 
 *      "#" is inserted between characters in the source string. For example, "abc" --> "#a#b#c#" 
 *      Let the converted string be S. The benefit of doing it is that if we expand from position
 *      i at the converted string to S[i-d,i+d], then we can know that 'd' is the length of the palindrome 
 *      
 *  (2) Length calculation:
 *      We keep an array P, where P[i] stores the length of the maximum palindromic substring centered
 *      at S[i]. To populate P, we use the following variables:  "center" (the center of current palindrome), 
 *      "left" and "right" (the inclusive left and right boundary of current palindrome), 
 *  
 *      Each time we calculate P[i], we first check the value of its symmetric character P[i']. There are
 *      two cases:
 *        I) R - i > P[i']: it means the right boundary of the palindrome centered S[i] is smaller than R 
 *           ==> there cannot be a palindrome centered at S[i] whose length is longer than P[i']
 *           ==> we set P[i] as P[i'] 
 *        II) R -i <= P[i']: it means that according to the symmetric property of a palindrome, the right
 *              boundary of the palindrome centered at S[i] could expand beyond R 
 *           ==> we need to compare characters from both sides of S[i] in order to determine P[i'] 
 *           
 *      We can keep track of the longest palindrome when we populate the P array. 
 *      
 *   Some corner cases:
 *   (1) i' <= 0 ==> we have a reference values 
 *               ==> we need to compare characters 
 *   (2) left and right are out of boundary 
 * 
 * @author jack
 *
 */



public class MaxPalindromicSubstring {


	public static String findMaxPalindrome(String source){
		
		return null ; 
		
	}
	

	/**
	 *  Insert "#" in between characters 
	 * 
	 * @param source
	 * @return
	 */
	public static String preProcess(String source){
		
		int strLen = (source.length()<<1) + 1; 
		char[] converted = new char[strLen]; 
		
		for(int i=0; i<strLen-1; i++){
			converted[i] = (i%2==0)? '#' : source.charAt(i>>1);
		}
		converted[strLen-1]= '#';
		
		return new String(converted); 
	}
	
	
	
	
	
	public static String search(String converted){
		
		int strLen = converted.length(); 
		int center=0, left=0, right=0; 
		
		int[] P = new int[strLen]; 
		for(int i=0;   i<strLen;  i++){
			
			
				
			
			
		}
		
		return null; 
		
	}
	
	
	
	
	
	
}
