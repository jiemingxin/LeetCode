package tutorials.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * == Problem == 
 * Print all possible strings that can be made by placing spaces 
 *  http://www.geeksforgeeks.org/print-possible-strings-can-made-placing-spaces/ 
 * 
 * Given a string containing no spaces, print out all possible strings
 * that can be made by placing spaces ( zero or one ) in between them 
 * 
 * == Analysis == 
 * This problem can be solved using recursion. Imagine that we have a place holder,
 * and we need to populate characters onto it. We can choose inserting a space 
 * or a character each time. After that, we pass it to the recursion 
 *  
 * @author jack
 */

public class PlacingSpaces {

	public static void printStrings(String inStr){
		
		List<String> allStrings = new ArrayList<String>(); 
		StringBuilder buffer = new StringBuilder();
		char[] chars = inStr.toCharArray(); 
		
		buffer.append(chars[0]);
		
		printStrings(buffer, chars, 1, allStrings); 
		
		for(String str:allStrings){
			System.out.println(str); 
		}	
	}
	
	
	public static void printStrings(StringBuilder buffer, char[] chars, int charStart, List<String> allStrings){
		
		if(charStart == chars.length){
			allStrings.add(buffer.toString());
			return ; 
		}
			
		// recursion here 
		int strLen = buffer.length();
		String currStr = buffer.toString();
		if( currStr.charAt(strLen-1) != ' '){
			StringBuilder copy = new StringBuilder(buffer); 
			printStrings(buffer.append(' '), chars, charStart, allStrings);
			printStrings(copy.append(chars[charStart]), chars, charStart+1, allStrings); 
		}else{
			printStrings(buffer.append(chars[charStart]), chars, charStart+1, allStrings); 
		}
			
	}
		
	
	public  static void main(String[] args){
	
		String inStr = "ABC"; 
		printStrings(inStr);
		
		
		inStr = "ABCD"; 
		printStrings(inStr);
		
	}
	
}
