package tutorials.array;


/**
 * 
 * http://leetcode.com/2010/05/printing-matrix-in-spiral-order.html
 * 
 * Problem: 
 *  Given a matrix (2D array) of m x n elements (m rows, n columns), 
 *  write a function that prints the elements in the array in a spiral 
 *  manner. 
 * 
 * Solution: 
 *   The idea is like peeling an onion via recursion 
 * 
 * @author endeavour
 *
 */

public class ArraySpiralPrint {
	
	
	
	public static String print2DArray(int[][] arr){
		
		StringBuilder stringBuilder = new StringBuilder(); 
		print2DArray(arr, 0, 0, arr[0].length, arr.length, stringBuilder); 	
		return stringBuilder.toString(); 
	}
	
	
	
	
	protected static void print2DArray(int[][] arr, int startRow, int startCol, 
			int width, int height, StringBuilder builder){
	
		// handle the exceptions 
		if( width<=0 || height<=0 )
			return ; 
		
		int r, c; 
		
		// handle the base case 
		if( width == 1){
			for(r=startRow, c=startCol; r<startRow+height; r++ )
				builder.append(arr[r][c] + " "); 
			return ; 		
		}else if (height == 1){
			for(r=startRow, c=startCol; c<startCol+width; c++)
				builder.append(arr[r][c] + " "); 
			return ; 
		}
		
		
		// top left -> top right 
		for(r=startRow, c=startCol; c<startCol+width; c++)
			builder.append(arr[r][c] + " "); 
		
		// top right -> bottom right 
		for(r=startRow+1, c=startCol+width-1; r<startRow+height; r++)
			builder.append(arr[r][c] + " "); 
		
		// bottom right -> bottom left 
		for(r=startRow+height-1, c=startCol+width-2; c>=startCol; c--)
			builder.append(arr[r][c] + " ");  
		
		// bottom left -> top left 
		for(r=startRow+height-2, c=startCol;  r>startRow; r--)
			builder.append(arr[r][c] + " ");  
		
		// pass the rest to the recursion 
		print2DArray(arr, startRow+1, startCol+1, width-2, height-2, builder); 
	}
	
	
	

}
