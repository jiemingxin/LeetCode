package tutorials.graph;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * == Problem == 
 *  Given an array of strings, find if strings can be chained to form a circle 
 *   http://www.geeksforgeeks.org/given-array-strings-find-strings-can-chained-form-circle/
 *  We assume that all the strings are lower case 
 * 
 * 
 * == Examples == 
 *  (1) arr[] = {"geek", "king"} == > Yes  
 *     the last char of "geek" is the same as the first char of "king"; 
 *     the last char of "king" is the same as the first char of "geek"   
 *  (2) arr[] = {"for", "geek", "rig", "kaf"} ==> Yes 
 *  (3) arr[] = {"aaa", "bbb", "baa", "aab"}  ==> Yes 
 *  (4) arr[] = {"aaa"} ==> Yes ( the last char is the same as the first char ) 
 *  (5) arr[] = {"aaa", "bbb"} ==> No 
 * 
 * 
 * == Analysis == 
 * Solution I: naive recursive solution. If we find two strings are chainable, we chain them
 *             and process the chained string with the remaining string. 
 *             The base case is when there is only one word 
 *             Time complexity (2^n) 
 * Solution II: construct a directed graph, and find if it contains a Euler circuit
 *              
 * @author jack
 *
 */

public class CircularStringChains {

	
	public static boolean canFormCircleGraph(String[] words){
	
		int numChars = 26; 
		DirectedGraph graph = new DirectedGraph(numChars); 
	
		// add an edge from the first character to the last 
		// character of every string 
		for(String word:words)
			graph.addEdge(word.charAt(0)-'a', word.charAt(word.length()-1)-'a'); 
			
		return graph.isEulerianCircuit(); 			
	}
		
	
	public static boolean canFormCircleRecursive(String[] words){
		ArrayList<String> wordList = new ArrayList<String>(Arrays.asList(words)); 
		return canFormCircle(wordList); 
	}
	
	
	public static boolean canFormCircle(ArrayList<String> words){
		
		// base case  
		int numWords = words.size() ; 
		if(numWords==1)
			return chainable( words.get(0) ); 
		
		ArrayList<String> copies = new ArrayList<String>(words); 
		
		// recursive call 
		boolean chainable = false ; 
		for(int i=0; i<numWords; i++){
			String currWord = words.get(i); 
			for(int j=i+1;  j<numWords;  j++){
				String nextWord = words.get(j); 
				if(chainable(currWord, nextWord)){
					String newWord = currWord + nextWord ; 
					copies.remove(currWord);
					copies.remove(nextWord); 
					copies.add(newWord); 
					chainable = canFormCircle(copies); 
					if(chainable)
						return true ; 
				}
			}
		}
		
		return chainable; 
	}

	
	/**
	 * Returns if we can chain the string "first" with the string "second" 
	 * We only need to compare the first char of "first", with the last char 
	 * of "second" 
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	protected static boolean chainable(String first, String second){
		return first.charAt(first.length()-1) == second.charAt(0); 
	}
	
	
	/**
	 *  Return true if the given string has the same characters for
	 *  both the prefix and the suffix 
	 *  
	 * @param word
	 * @return
	 */
	protected static boolean chainable(String word){
		return word.charAt(0) == word.charAt(word.length()-1); 
	}
	
	
	
	
	
}
