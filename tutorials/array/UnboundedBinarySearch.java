package tutorials.array;

/**
 * == Problem == 
 *  http://www.geeksforgeeks.org/find-the-point-where-a-function-becomes-negative/ 
 *  
 *  Given a function ‘int f(unsigned int x)’ which takes a non-negative integer ‘x’ 
 *  as input and returns an integer as output. The function is monotonically increasing 
 *  with respect to value of x, i.e., the value of f(x+1) is greater than f(x) for every 
 *  input x. Find the value ‘n’ where f() becomes positive for the first time. 
 *  
 * == Analysis == 
 *  The values of the function is monotonically increasing so the binary search could be
 *  employed. However we can only perform binary search in a closed interval. Here the
 *  interval is opened. To use the binary search, we could locate an upper boundary 
 *  where f(x) has positive value (not necessarily the first positive value ) 
 *  
 * @author jack
 *
 */
public class UnboundedBinarySearch {

	public static int f(int x){
		return x*x - 2*x -200 ; 
	}

	
	public static int findFirstPositive(){
		
		// locate the uppder bound ;
		if( f(0) > 0)
			return 0; 
		
		int idx = 0; 
		while(f(idx) <= 0)
			idx = 2*idx +1; 
		
		return binarySearch(idx/2, idx); 
	}
	
	
	
	
	/**
	 *  Return the first index at which f(index) is positive 
	 * 
	 * @param lo
	 * @param hi
	 * @return
	 */ 		
	protected static int binarySearch(int lo, int hi){
		
		while(hi-lo>1){
			int mid = (hi+lo)/2; 
			if( f(mid) <= 0 ) 
				lo = mid ;
			else 
				hi = mid ; 
		}
		return hi; 
	}


	
	
}
