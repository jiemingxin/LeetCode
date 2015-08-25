package tutorials.bitwise;

/**
 * 
 * The integer division of two integers without using division operators 
 * The idea is to simulate hand division using bitwise operation. Its essence is 
 * shift and subtract.  Unlike the decimal division one has to estimate 
 * the next digit of the result, in binary case the next digit is always either
 * 0 or 1. The corresponding is either subtract the divisor or not.  
 * 
 * http://stackoverflow.com/questions/5386377/division-without-using 
 * 
 * @author jack
 *
 */

public class BitwiseDiv {

	/*
	 * Bitwise division by convert the decimal 1/divisor into binary values. 
	 * 
	 * @divident - the number to be divided, nonnegative  
	 * @divisor  - the number to divide with, nonnegative 
	 * @return   - the quotient of the divident/divisor  
	 *
	 */
	public static int bitDiv(int divident, int divisor){
		
		if(divident < divisor)
			return 0; 
		if(divident == divisor)
			return 1; 
		
		int quotient = 0; 
		int value    = 1; 
		while(divident >=divisor){
			divisor <<= 1 ; 
			value <<= 1; 
		}
		
		divisor >>= 1; 
		value >>= 1; // the "value" is a sequence of 1's and it helps to 
			         // set the bits in "qotient" 
		while(divisor !=0){
			if(divident >= divisor){
				divident -= divisor ; 
				quotient |= value  ; 
			}
			
			divisor >>= 1; 
			value  >>= 1; 
		}
		
		return quotient ; 
	}
	
}
