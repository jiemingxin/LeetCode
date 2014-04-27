package tutorials.bitwiseops;

public class BitwiseOperations {
	
	
	/**
	 * This method implements the bitwise operation to check if a given number 
	 * is a power of two 
	 * 
	 *  http://leetcode.com/2010/09/fun-with-bit-operations.html 
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isPowerofTwo(int value){
		return (value!=0) && ( (value & (value-1))==0) ; 
	}	

	
	
	
	/**
	 * Counts the number of "1" bits an *unsigned* integer has 
	 * 
	 * http://leetcode.com/2010/09/number-of-1-bits.html 
	 * 
	 * @param value
	 * @return
	 */
	public static int countNumOneBits(int value){
		
		int x = value, numOneBits = 0 ;
		while(x != 0){
			x = x & (x-1) ; 
			numOneBits ++; 
		}
		return numOneBits ; 
	}
	
	
}
