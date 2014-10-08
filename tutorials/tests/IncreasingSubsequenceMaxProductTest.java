package tutorials.tests;

import static org.junit.Assert.*;

import java.io.PrintStream;
import java.util.Arrays;

import org.junit.Test;

import tutorials.array.IncreasingSubsequenceMaxProduct;
import tutorials.utils.RandArray;

public class IncreasingSubsequenceMaxProductTest {

	private PrintStream print = System.out ; 
	private static int min = 1; 
	private static int max = 1000; 
	private static int arrLen = 6;
	private static int iters = 15; 

		
	@Test
	public void testSearchByAVLTree() {
		
		for(int i=0; i<iters; i++){	
			int[] rands  = RandArray.generateRandIntArr(min, max, arrLen); 
			
			print.println(">>>>>>>>>>>>>>>>>>>>>>>>>"); 
			print.println(Arrays.toString(rands)); 
			
			String expected = IncreasingSubsequenceMaxProduct.searchByTwoWayScan(rands); 
			String actual   = IncreasingSubsequenceMaxProduct.searchByAVLTree(rands); 
			assertEquals(expected, actual); 
			
			print.println("Max sub seq :[" + actual + "]"); 
			print.println("<<<<<<<<<<<<<<<<<<<<<<<<<"); 
			
		}
	}
	
	
	

}
