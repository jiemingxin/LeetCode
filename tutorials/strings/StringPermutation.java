package tutorials.strings;

import java.util.ArrayList;


/**
 *   A class to generate all permutation of a string 
 * 
 * @author jack
 */

public class StringPermutation {
	
	
	/**
	 *  Generate all permutation for the given string using recursion 
	 * 
	 * @param source
	 * @return
	 */
	public static ArrayList<String> recursiveGenerateAll(String source){
		
		ArrayList<String> ret = new ArrayList<String>(); 
		if(source.length()==1)  // base case  
			ret.add(source); 
		else{
			for(int i=0; i<source.length(); i++){
				
				char c = source.charAt(i); 
				String prefix = source.substring(0, i); 
				String suffix = source.substring(i+1); 
				String rest = prefix + suffix ; 
				
				if(!rest.isEmpty()){
					ArrayList<String> subRet = recursiveGenerateAll(rest);
					for(int j=0; j<subRet.size(); j++){
						String s = subRet.get(j);
						subRet.set(j, c+s); 
					}
					ret.addAll(subRet); 
				}	
			}
		}
		return ret ;
	}
	
	
	/**
	 *  Generate all permutations using backtracking 
	 * @param args
	 */
	 public static ArrayList<String> backtrackGenerateAll(String source){
		 
		 ArrayList<String> perms = new ArrayList<String>(); 
		 permute(source.toCharArray(), 0, source.length()-1, perms);
		 return perms ; 
	 }
	 
	 protected static void swap(char[] source, int i, int j){
		 
		 char tmp  = source[i]; 
		 source[i] = source[j]; 
		 source[j] = tmp; 
	 }
	  
	 /**
	  * 
	  * 
	  * 
	  * @param source
	  * @param begin   inclusive index on string[] 
	  * @param finish  inclusive index on string[]
	  * @param perms
	  */
	 protected static void permute(char[] source, int begin, int finish, ArrayList<String> perms){
		 
		 if(begin==finish){
			 perms.add( new String(source)); 
			 
		 }else{
			
			 for(int i=begin; i<=finish;  i++){ 
				 swap(source, begin, i);
				 permute(source, begin+1, finish, perms);
				 swap(source, begin, i); 
			 }
		 }
	 }
	
	
}
	

