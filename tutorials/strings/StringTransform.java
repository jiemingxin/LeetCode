package tutorials.strings;

/**
 *  Minimum number of operations to convert a string to another 
 *   http://www.geeksforgeeks.org/transform-one-string-to-another-using-minimum-number-of-given-operation/ 
 * 
 * 
 * @author orthogonal
 *
 */


public class StringTransform {

	public static int NUM_CHARS = 256 ; 
	

	public static int getMinOPerations(String src, String dest){
		
		if( src.compareTo(dest) == 0)
			return 0; 
		
		int minOperations = Integer.MAX_VALUE ; 
		for(int i=1; i<src.length(); i++){
			
			String converted = pickAndInsertFront(src, i); 
			int numOperations = 1 + getMinOPerations(converted, dest); 
			minOperations = Math.min(minOperations, numOperations);
		}
		
		return minOperations;	
	}
	
	protected static String pickAndInsertFront(String src, int charIdx){
		
		StringBuilder builder = new StringBuilder(); 
		builder.append(src.substring(0, charIdx)); 
		if( charIdx+1 < src.length())
			builder.append(src.substring(charIdx+1));
		builder.insert(0,  src.charAt(charIdx)); 
		return builder.toString(); 
	}
	
	
	public static int minOps(String src, String dest){
		
		// check if the conversion is possible 
		int[] counts = new int[NUM_CHARS]; 
		for(int i=0; i<src.length(); i++)
			counts[src.charAt(i)] ++; 
		for(int i=0; i<src.length(); i++)
			counts[dest.charAt(i)] --; 
		for(int i=0; i<NUM_CHARS; i++)
			if( counts[i] !=0 )
				return -1; 
		
		// now calculate the minimum operations to 
		// convert 'src' to 'dest' 
		
		// the idea is to work from backwards, let i,j both be (n-1)
		// if src[i] == dest[j], then we only need to check src[0..i-1], and dest[0..j-1]
		// if they don't match, search dest[j] in src[0..i-1], let's say src[ip] = dest[j],
		// then all the characters between src[ip..i] needs to be moved to front of A
		int len = src.length(); 
		int minOps = 0; 
		for(int i=len-1, j=len-1; i>=0; ){
			
			while(i>=0 && src.charAt(i)!=dest.charAt(j)){
				i--; minOps ++; 
			}
			
			if( i>=0 ){ // src[i] matches dest[j] 
				i--; j--;
			}
		}
			
		return minOps; 
	}
		
	
}
