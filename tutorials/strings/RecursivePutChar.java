package tutorials.strings;

import java.io.PrintStream;


/**
 *  
 *  Given only putchar (no sprintf, itoa, etc.) write a routine putlong
 *  that prints out an unsigned long in decimal.
 *    
 *    http://leetcode.com/2010/02/here-is-one-of-questions-from-microsoft.html 
 * 
 *  Actually a recursive solution still incurs memory overhead, it just looks 
 *  fancy. Anyhow this problem is a good problem for introducing the Recursion
 *  concept 
 * 
 * 
 * @author endeavour
 *
 */

public class RecursivePutChar {

	
	public static void putLong(Long number){
		
		PrintStream out = System.out ; 
	
		// handle the base case   
		if( number < 10){  	
			out.print(number); 
			return ; 
		}
			
		putLong(number/10);  // pass it to recursion 
		out.print(number%10); 
		
	}
	

	
}
