package tutorials.array;

/**
 * http://www.geeksforgeeks.org/find-length-of-the-longest-consecutive-path-in-a-character-matrix/ 
 * 
 * Given an array of characters, find length of the longest path from a given character, such that 
 * all characters in the path are consecutive to each other. It is allowed to move in all 8 directions
 * from a cell.
 *  
 *  
 * NOTE:
 *  my current solution is a recursive one. However one can adapt the memorisation technique for improvement
 *  
 *  
 * @author orthogonal
 *
 */

public class LongestConsecutivePath {

	
	public static int getLongestPathLength(char[][] matrix, char startChar){
		
		// find the index of the starting char 
		int startRow=-1, startCol=-1; 
		for(int i=0; i<matrix.length; i++)
			for(int j=0; j<matrix[0].length; j++)
			{
				if(matrix[i][j] == startChar){
					startRow = i; 
					startCol = j; 
					break; 
				}
			}
		if(startRow==-1 && startCol==-1)
			return -1; // the starting char not found 
		
		return getLongestPathLength(matrix, startRow, startCol); 
	}
	
	
	
	protected static int getLongestPathLength(char[][] matrix, int startRow, int startCol){
		
		int[] colOffsets = {-1, -1, -1,  0, 0,  1,  1,  1}; 
		int[] rowOffsets = {-1,  0,  1, -1, 1,  -1, 0,  1}; 
		
		int matrixHeight = matrix.length ; 
		int matrixWidth  = matrix[0].length; 
		
		char nextChar = (char) (matrix[startRow][startCol] +1) ; 
		
		int maxLength = 1; 
		for(int i=0; i<8; i++){
			
			int nextCol = startCol + colOffsets[i]; 
			int nextRow = startRow + rowOffsets[i]; 
			
			
			if( nextCol <0 || nextCol >= matrixWidth)
				continue; 
			
			if( nextRow < 0 || nextRow >= matrixHeight)
				continue; 
			
			if( matrix[nextRow][nextCol] == nextChar )
				maxLength = Math.max(maxLength, 1 + getLongestPathLength(matrix, nextRow, nextCol));
		}
		
		return maxLength; 
	}
	
	
	
	
	
	
}
