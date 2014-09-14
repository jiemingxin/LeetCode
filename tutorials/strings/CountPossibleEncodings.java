package tutorials.strings;

/**
 * == Problem == 
 * http://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/ 
 * 
 * Let 1 represent 'A', 2 represents 'B', etc. Given a digit sequence, count the number
 * of possible decodings of the given digit sequence.
 * 
 * == Examples == 
 * (1) digits[] = "121"  ==> 3  ( "ABA", "AU", "LA" ) 
 * (2) digits[] = "1234" ==> 3  ("ABCD", "LCD", "AWD")  
 *  
 * == Analysis == 
 * This problem can be solved using recursion. 
 * 
 * == NOTE == 
 * The description of the problem is confusing for handling the case of multiple 0's 
 * 
 * @author jack
 *
 */
public class CountPossibleEncodings {
	
	
	/**
	 * It may be assumed that the input contains valid digits from 0 to 9 and there 
	 * are no leading 0′s, no extra trailing 0′s and no two or more consecutive 0′s.
	 * 
	 * This is a recursive solution. Its time complexity is exponential:
	 * T(n) = T(n-1) + T(n-2) + O(1) 
	 *
	 * 
	 * @param digits
	 * @return
	 */
	public static int countEncodingsRecursive(String digits){
		
		// base case:
		int strLen = digits.length(); 
		if(strLen==1 || strLen==0)
			return 1; 
		
		int total=0; 
		if(isValidNumber(digits))
			total += 1; 
		
		total += countEncodingsRecursive(digits.substring(1)); 
		if(strLen>2){ 
			String prefix = digits.substring(0,2); 
			String remain = digits.substring(2); 
			if( isValidNumber(prefix) )
				total += countEncodingsRecursive(remain); 
		}
		return total ; 
	}

	
	protected static boolean isValidNumber(String str){
		int val = Integer.valueOf(str); 
		return (val>=0) && (val<=26); 
	}

	
	
	
}
