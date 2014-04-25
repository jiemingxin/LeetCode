package tutorials.array;

import tutorials.utils._;



/**
 *  Write an efficient algorithm that searches for a value in an n x m table (two-dimensional array). 
 *  This table is sorted along the rows and columns ¡ª that is, 
 *       Table[i][j] ¡Ü Table[i][j + 1],   Table[i][j] ¡Ü Table[i + 1][j]       
 */
 

/**
 *  Stepwise linear search algorithm 
 *  Time complexity: O(n+m) 
 * 
 * @author endeavour
 *
 */
public class Search2DSortedArray {

	
	public static boolean stepwiseSearch(int[][] mat, int target, _<Integer> rowLoc, _<Integer> colLoc)
	{
		int rows = mat.length; 
		int cols = mat[0].length;
		if( target < mat[0][0] || target > mat[rows-1][cols-1])
			return false ;
		
		int rowIdx = 0,  colIdx = cols-1; 
		while( true ){
			
			if( rowIdx <0 || colIdx <0 )
				break ; 
			
			int val = mat[rowIdx][colIdx]; 
			if( val == target ){
				rowLoc.set(rowIdx); 
				colLoc.set(colIdx); 
				return true ; 
			}else  if ( val < target ){
				rowIdx ++ ; 
			}else 
				colIdx -- ; 
		}
		return false; 
	} 
	
	
	
	/**
	 *  Divide and conquer. Divide the matrix into four parts and we only need 
	 *  to search three out of them. 
	 * 
	 *  Time complexity :  O(n1.58)    
	 * 
	 * @param mat
	 * @param target
	 * @param rowLoc
	 * @param colLoc
	 * @return
	 */	
	public static boolean quadPartSearch(int[][] mat, int target, _<Integer> rowLoc, _<Integer> colLoc)
	{
		int rows = mat.length; 
		int cols = mat[0].length; 	
		return quadPartSearch(mat, target, 0, rows-1, 0, cols-1, rowLoc, colLoc);  
	}
	
	
	
	
	protected static boolean quadPartSearch(int[][] mat, int target, int rowStart, int rowFinish, 
				int colStart, int colFinish, _<Integer> rowLoc, _<Integer> colLoc )
	{
		if(rowStart > rowFinish || colStart > colFinish)
			return false ; 
		
		int rowMid = rowStart + (rowFinish - rowStart)/2 ; 
		int colMid = colStart + (colFinish - colStart)/2 ; 
		
		if(mat[rowMid][colMid] == target){
			rowLoc.set(rowMid); 
			colLoc.set(colMid); 
			return true ; 
		}else if ( rowStart == rowFinish && colStart == colFinish){
			return false; 
		}else if ( mat[rowMid][colMid] > target ){
			return 		quadPartSearch(mat, target, rowStart, rowMid,    colStart, colMid,  rowLoc, colLoc)|| 
						quadPartSearch(mat, target, rowMid+1, rowFinish, colStart, colMid,   rowLoc, colLoc)|| 
						quadPartSearch(mat, target, rowStart, rowMid,    colMid+1, colFinish, rowLoc, colLoc);
		}else{
			return 		quadPartSearch(mat, target, rowMid+1, rowFinish,    colMid+1, colFinish,  rowLoc, colLoc)|| 
					   	quadPartSearch(mat, target, rowMid+1, rowFinish, colStart, colMid,   rowLoc, colLoc)|| 
					   	quadPartSearch(mat, target, rowStart, rowMid,    colMid+1, colFinish, rowLoc, colLoc); 
			
		}

	}
	
	
	
	
	
	
	

	
	
		
	
	public static void main(String[] args){
		
		
		int[][] mat = { {1,  4,  7,  11, 15}, 
						{2,  5,  8,  12, 19}, 
						{3,  6,  9,  16, 22}, 
						{10, 13, 14, 17, 24},
						{18, 21, 23, 26, 30} }; 
		
	
		_<Integer> rowLoc = new _<Integer>(); 
		_<Integer> colLoc = new _<Integer>(); 
		int target = 10 ; 
		
		if( quadPartSearch(mat, target, rowLoc, colLoc)){
			
			System.out.println("Target: " + target + " was found @ (" + rowLoc.value() + "," + colLoc.value() + ")" );
		}else{
			System.out.println("Target not Found"); 
			
		}
	
	}
	
	
		
	
			
}
	
	

