package tutorials.tests;

import org.junit.Test;

import tutorials.array.XOMatrix;

public class XOMatrixTest {

	@Test
	public void testPrintCase1() {
		int numRows = 3; 
		int numCols =3; 
		XOMatrix.print(numRows, numCols); 
		
		System.out.println(".............."); 
		numRows = 4; 
		numCols = 5; 
		XOMatrix.print(numRows, numCols); 
		
		System.out.println(".............."); 
		numRows = 5; 
		numCols = 5; 
		XOMatrix.print(numRows, numCols); 
		
		System.out.println(".............."); 
		numRows = 6; 
		numCols = 7; 
		XOMatrix.print(numRows, numCols);  
		
	}

}
