package tutorials.array;

/**
 * http://codercareer.blogspot.com.au/2013/02/no-41-group-of-1s-in-matrix.html 
 *  
 * Problem: 
 *   Given a matrix with 1s and 0s, find the number of groups of 1s. A group 
 *   is defined horizontally and vertically adjacent 1s. 
 *   
 *   For example, there are two groups of ones in this example:
 *   
 *    { { 1, 0 } 
 *      { 0, 1} } 
 * 
 * Analysis: 
 *   This is essentially a graph problem. 
 *  
 *   
 * @author Endeavour 
 *
 */

public class GroupsOfOne {

	
	/**
	 * Solution:
	 *  Go through all cells and mark connected components 
	 * 
	 * Time Complexity: 
	 *  O(MN), where M and N are the width and height of the given 
	 *  matrix respectively  
	 * 
	 * @param matrix
	 * @return
	 */
	public static int countGroups(int[][] matrix){
		
		int rows = matrix.length;
		int cols = matrix[0].length; 
		
		int[][] visited = new int[rows][cols]; 
		int numGroups = 0; 
		for(int r=0;  r<rows;  r++)
			for(int c=0;  c<cols;  c++)
			{
				if(matrix[r][c] == 1 && visited[r][c]!= 1){
					markGroup(matrix, r, c, visited); 
					numGroups ++; 
				}				
				visited[r][c] = 1 ; 
			}
		return numGroups ; 
	}
	
	
	
	
	
	
	/**
	 * 
	 *  This is a recursive implementation. The memory overhead 
	 *  depends on the given matrix 
	 * 
	 * 
	 * @param matrix
	 * @param row
	 * @param col
	 * @param visited
	 */
	protected static void markGroup(int[][] matrix, int row, int col, int[][] visited){
		
		// handle the exceptions 
		int rows = matrix.length ; 
		int cols = matrix[0].length ; 
		if(row<0 || row>=rows || col<0 || col>=cols)
			return ; 
		
		// handle the base case 
		if(matrix[row][col]==0 || visited[row][col]==1)
			return ; 
		
		visited[row][col] = 1; 
		
		markGroup(matrix, row+1, col, visited); 
		markGroup(matrix, row-1, col, visited); 
		markGroup(matrix, row, col-1, visited); 
		markGroup(matrix, row, col+1, visited); 
	}
		

	
	
	
	
	
	
	
	
}
