package tutorials.array;


/**
 * 
 *  Given the sequence S1 = {a,b,c,d,...,y,z,aa,ab,ac...} and given that this sequence 
 *  corresponds (term for term) to the sequence S2 = {0,1,2,3,...}. Write code to convert 
 *  an element of S2 to the corresponding element of S1.
 * 
 *   http://leetcode.com/2010/10/amazon-bar-raiser-interview-question.html 
 *   
 *  NOTE: 
 *    This problem is essentially an base conversion problem. However it is quite easy
 *    to make a mistake if we simply apply the base conversion algorithm here, as the
 *    index starts from 0 in this problem. It means for string "a" to "z", the starting
 *    index is 0. From "aa" to "zz", the starting index is 1 rather than 0. 
 *    
 *    If the starting index for two-char-string is 0, then "aa" will be translated to "00", 
 *    which is not correct. The correct conversion for "aa" is 26, which is calculated as 
 *    1*26^1 + 0*26, where 1 is the index of "a" in from the more significant bit. 
 *    
 *    On the other hand, if S2 is defined as {1,2,3,...}, this question can be solved simply
 *    using the standard base conversion
 * 
 * @author endeavour
 *
 */


public class ExcelSheetRowNumber {

	
	public static int ALPHABET_SIZE = 26 ; 
	
	public static String numToStr(int number){
		
		if( number < 0 )
			return null ; 
		
		StringBuilder builder = new StringBuilder(); 
		int base = ALPHABET_SIZE ;  
		int remainder = number % base ; 
		builder.append( (char) ( 'a' + remainder ) );
		number = number / base ; 
		
		while(number > 0){
			
			remainder = (number-1) % base  ; 
			number = number / base ;  
			char c = (char) ( 'a' + remainder  ) ; 
			builder.append(c); 
		}
		
		return builder.reverse().toString();  
	}
	
	
	
	
	
	
	
	
}
