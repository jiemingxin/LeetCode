package tutorials.tests;

import static org.junit.Assert.assertEquals;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import tutorials.array.MoreThanNdK;
import tutorials.utils.RandArray;

public class MoreThanNdKTest {

	private PrintStream print = System.out ; 
	private static int min = 1; 
	private static int max = 20; 
	private static int arrLen = 50;
	private static int iters = 80; 

	
	
	@Test
	public void testSearchByVoting() {
		
		int k=10; 
		for(int i=0; i<iters; i++){
			
			int[] rands  = RandArray.generateRandIntArr(min, max, arrLen); 
			
			//int[] rands =  {10, 12, 10, 19, 4, 17, 20, 4, 11, 19, 10, 6, 19, 5, 5, 20, 8, 13, 19, 10, 8, 13, 20, 1, 10, 5, 5, 14, 6, 7, 14, 10, 11, 19, 15, 4, 12, 11, 14, 15, 15, 16, 11, 20, 9, 20, 12, 20, 15, 15};
			
			
			String expected = conver2String( MoreThanNdK.searchByHashing(rands, k) ); 
			String actual 	= conver2String( MoreThanNdK.searchByVoting(rands, k) ); 
			
			print.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");   
			print.println("Inputs: " + Arrays.toString(rands)); 
			print.println("Frequency Threshold:" + arrLen/k);
			print.println("Expected: " + expected);  
			print.println("Actual: " + actual); 
			
			assertEquals(expected, actual); 
		}
	}
	
	
	
	//@Test
	public void testSearchBySorting() {
		
		int k=10; 
		for(int i=0; i<iters; i++){
			
			int[] rands  = RandArray.generateRandIntArr(min, max, arrLen);  
			String expected = conver2String( MoreThanNdK.searchByHashing(rands, k) ); 
			String actual 	= conver2String( MoreThanNdK.searchBySorting(rands, k) ); 			
			assertEquals(expected, actual); 
		}
	}
	
	
	protected static String conver2String(ArrayList<Integer> keys){
		
		Collections.sort(keys);  
		StringBuilder stringBuilder = new StringBuilder();  
		for(Integer key: keys){
			stringBuilder.append(key + " "); 
		}
		return stringBuilder.toString(); 
	}
	

}
