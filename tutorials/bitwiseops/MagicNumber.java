package tutorials.bitwise;

/**
 * Find the n-th magic number 
 *   http://www.geeksforgeeks.org/find-nth-magic-number/ 
 *  
 * == Statement == 
 *  In this problem a magic number is defined as a number which can be 
 *  expressed as a power of 5 of sum of unique powers of 5. 
 *  
 *  First few are 5, 25, 30(5+25), 125, 130(125+5) 
 *  
 * == Analysis == 
 *  Bitwise operation provides a very nice solution to this problem. 
 *  In fact, the magic numbers can be considered as a linear combination
 *  of magic basis.  The magic basis consists of powers of 5. 
 *  
 *  If we look at the binary representation of the magic numbers,
 *  we can see that they can be represented as: 001, 010, 011 etc, where
 *  001 = 0*pow(5,3) + 0*power(5,2) + 1*power(5,1) 
 *  
 *  The solution checks number of 1's in the binary representation of 
 *  number "n". 
 * 
 * @author jack
 */


public class MagicNumber {
	
	
	public static int nthNumber(int n){
		
		int value = 0;
		int power = 5; 
		while(n != 0){
			
			if( (n&1) != 0){
				value += power ; 
			}
			
			power *= 5; 
			n >>= 1; 
		}
		
		return value ; 		
	}
	

}
