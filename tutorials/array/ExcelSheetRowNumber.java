package tutorials.array;


/**
 * 
 *  Given the sequence S1 = {a,b,c,d,бн,x,y,z,aa,ab,acбн. } and given that this sequence 
 *  corresponds (term for term) to the sequence S2 = {0,1,2,3,бн.}. Write code to convert 
 *  an element of S2 to the corresponding element of S1.
 * 
 *   http://leetcode.com/2010/10/amazon-bar-raiser-interview-question.html 
 * 
 * @author endeavour
 *
 */


public class ExcelSheetRowNumber {

	
	public static int ALPHABET_SIZE = 26 ; 
	
	public static String numToStr(int number){
		
		if( number < 0 )
			return null ; 
		
		StringBuffer buffer = new StringBuffer(); 
		
		// get the length of the string 
		int length = 1;
		int radix = ALPHABET_SIZE ; 
		while(number > 0){
			radix = radix * ALPHABET_SIZE ; 
			number = number / radix ; 
			length ++; 
		}
		
		
		for(int i=length; i>0; i--){
			char c = (char) ('a' +  length/ALPHABET_SIZE) ; 
			buffer.append(c); 
		}
				
		return buffer.toString(); 
	}
	
	
	
	
	
	
	
	
}
