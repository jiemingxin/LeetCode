package tutorials.string;

public class RotatedPalindrome {

	
	public static boolean isRotatedPalindrome(String source){
		
		int strLen = source.length(); 
		boolean isRotatedPalindrome = false; 
		for(int i=0;  i<strLen;   i++){
			
			// set the pivot 
			int pivot = i; 
			
			// check both ways 
			int left, right; 
			if( strLen%2 ==0 )
				left = pivot ; 
			else
				left = (pivot-1 + strLen)%strLen; 
			right = (pivot+1+strLen)%strLen; 
			
			boolean found = true ; 
			while(left!=right){
				
				if(source.charAt(left)!= source.charAt(right)){
					found = false ;
					break ; 
				}
				left  = left -1 + strLen % strLen ; 
				right = right+1 + strLen % strLen ;
			}
				
			if(found){
				isRotatedPalindrome = true; 
				break ; 
			}
		}
		
		return isRotatedPalindrome; 
	}
	
	
	
}
