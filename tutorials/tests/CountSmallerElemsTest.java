package tutorials.tests;

import static org.junit.Assert.*;

import java.io.PrintStream;
import java.util.Arrays;

import org.junit.Test;

import tutorials.array.CountSmallerElems;
import tutorials.trees.AVLTree;
import tutorials.utils.RandArray;

public class CountSmallerElemsTest {

	private static int min = 1; 
	private static int max = 100; 
	private static int arrLen = 10;
	private static int iters = 5; 
	private static int margin = 5;
	
	
	@Test
	public void testCountByBIT() {
		
		PrintStream print = System.out; 
		
		for(int i=0; i<iters; i++){  // populate the data  
			
			int[] numbers  = RandArray.generateRandIntArr(min, max, arrLen); 
			int[] expected = CountSmallerElems.countByLooping(numbers);
			int[] actual   = CountSmallerElems.countByBIT(numbers); 
			
			print.println(">>>>>>>>> "); 
			print.println("Input " + Arrays.toString(numbers));
			print.println("Expected " + Arrays.toString(expected));
			print.println("Actual " + Arrays.toString(actual));
			
			
			assertArrayEquals(expected, actual); 
		}
	}

}
