package tutorials.strings;


/**
 * Online algorithm for checking palindrom in a stream 
 *   http://www.geeksforgeeks.org/online-algorithm-for-checking-palindrome-in-a-stream/ 
 *   
 * Given a stream of characters being received one by one, write a function that prints
 * 'Y' if the received characters make a complete palindrom, otherwise print 'N'  
 *   
 * Let the input string be inStr
 * 
 * Solution 1: for each i, check if inStr[0..i] is a palindrome. Time complexity: O(N^3) 
 * 
 * Solution 2: Use the idea of rolling hash in Rabin Karp algorithm. The idea is to 
 *             update the hash values for the left and second half of the substring.
 *             If their hash values do not equal, output 'N' straight away 
 *             If their hash values are the same, run a palindrome check.
 *             
 *             Since the rolling hash update is constant operation, the worst time 
 *             for solution 2 is O(N^2) where both hash values are the same for each
 *             position i. 
 *             
 * @author jack
 */

public class OnlinePalindrome {
	
	private static int base = 256 ;    // #characters in the input alphabet 
	private static int quotient = 103; // a prime number used to update the rolling hash 
		
	
	
	protected static boolean isPalindrome(char[] letters, int endIdx){
		
		int left =0, right = endIdx; 
		while( left < right ){
			
			if( letters[left] != letters[right])
				return false; 
			left ++ ; 
			right --; 
		}
		return true; 
	}
	
	

	public static String checkPalindrome(String inStr){
		
		StringBuilder builder = new StringBuilder(); 
		
		char[] letters = inStr.toCharArray(); 
		int leftHash  = letters[0] % quotient ; 
		int rightHash = letters[1] % quotient ; 
		int strLen    = inStr.length();
		
		builder.append("Y"); // a single character is always a palindrome
		
		for(int i=1,h=1; i<strLen; i++){
			
			System.out.print("i = " + i + " LeftHash = " + leftHash + " RightHash = " + rightHash + "\n"); 
			
			if(leftHash != rightHash)
				builder.append("N"); 
			else{
				if(isPalindrome(letters, i))
					builder.append("Y");
				else 
					builder.append("N"); 
			}
			
			if( i== strLen-1)
				break ; 
			
			// update the hash values 
			if(i%2==1){ 
				// current string length is even ==> next i is even
				// Need to chop the head of the right substring
				// and append (i+1)th char the right substring 
				rightHash = (rightHash + quotient - letters[(i+1)/2]*h)  ;
				rightHash = ( (rightHash * base) % quotient + letters[i+1]) % quotient ; 	
			}else{
				// current string length is odd ==> next i is odd 
				// need to append the middle char to the left substring
				// need to append the (i+1)-th char to the right substring
				h = (h*base) % quotient ; 
				leftHash  = (letters[i/2]* h + leftHash) % quotient ;
				rightHash = ( (rightHash * base)% quotient + letters[i+1]) % quotient ; 
			}
		}
		
		return builder.toString(); 
	}
	

}
