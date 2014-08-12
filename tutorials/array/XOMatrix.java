package tutorials.array;

import java.io.PrintStream;

/**
 * Create a matrix with alternating rectangles of O and X 
 *  http://www.geeksforgeeks.org/create-a-matrix-with-alternating-rectangles-of-0-and-x/
 * 
 *  Input: m = 3, n = 3
 *  Output: Following matrix 
 *  X X X
 *  X 0 X
 *  X X X
 *
 *  Input: m = 4, n = 5
 *  Output: Following matrix
 *  X X X X X
 *  X 0 0 0 X
 *  X 0 0 0 X
 *  X X X X X
 *
 *  Input: m = 5, n = 5
 *  Output: Following matrix
 *  X X X X X
 *  X 0 0 0 X
 *  X 0 X 0 X
 *  X 0 0 0 X
 *  X X X X X
 *  
 * 
 * Analysis:
 *  (1) This problem has a recursive pattern so it can be solved using recursion
 *      My solution is a recursive solution 
 *      
 *  (2) This problem is similar to the problem of spirally printing matrix. Note that
 *      the boundary has the same marker. We can use the same method for that problem
 *      to populate a 2D array with the XO matrix 
 * 
 * @author jack
 *
 */

public class XOMatrix {
	
	 private static PrintStream print = System.out ; 
	 
	 public static void print(int numRows, int numCols){
		 print(numRows, numCols, "X", ""); 
	 }
	 
	 
	 protected static void print(int numRows, int numCols, String marker, String margin){
		 
		 // handle the base case
		 if(numRows<=0 || numCols<=0)
			 return; 
		 
		 String revMargin = new StringBuilder(margin).reverse().toString(); 
		 
		 // print the head row 
		 print.print(margin); 
		 for(int i=0; i<numCols; i++)
			 print.print(marker);
		 print.println(revMargin);
		 
		 String nextMarker = marker.compareTo("X")==0? "O":"X"; 
		 print(numRows-2, numCols-2, nextMarker, margin+marker); 
		 
		 // print the bottom row 
		 if(numRows>=2){
			 print.print(margin); 
			 for(int i=0; i<numCols; i++)
				 print.print(marker);
			 print.println(revMargin);
		 }
	 }
	 
}
