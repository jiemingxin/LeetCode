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
		return (value!=0) && (value & (value-1))!=0; 
	}	

}
