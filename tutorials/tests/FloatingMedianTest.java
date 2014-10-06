package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import tutorials.streams.FloatingMedian;



public class FloatingMedianTest {

	//@Test
	public void testSumOfMediumByBruteForce() {
	
		int[] seeds 	= {3,  	10,  	4123,	32321, 	1, 	32321, 		452,	62000 }; 
		int[] muls  	= {1,  	0,   	2341,  	46543,	2,	46543,		2,		1 }; 
		int[] adds   	= {1,  	13,  	1231,  	32552,	0,	32552,		64,		1 }; 
		int[] totalNums = {10, 	5, 		7, 		17,		250000,	17,		351,	250000 }; 
		int[] seqLength = {3, 	2, 		3, 		17,		23,		17,		349,	4789 }; 
		long[] expects 	= {60, 	49, 	102186, 25569,	80,		25569,	196416,	7643623468L}; 
		
	
		int iters = seeds.length; 
		for(int i=0; i<iters; i++){
			long actual = FloatingMedian.sumOfMediumByBruteForce(seeds[i],muls[i],
									adds[i], totalNums[i], seqLength[i]); 
			long expected = expects[i]; 
			assertEquals(expected, actual); 
		}
	}


	
	@Test
	public void testSumOfMediumByBIT() {
		
		int[] seeds 	= {3,  	10,  	4123,	32321, 	1, 	32321, 		452,	62000 }; 
		int[] muls  	= {1,  	0,   	2341,  	46543,	2,	46543,		2,		1 }; 
		int[] adds   	= {1,  	13,  	1231,  	32552,	0,	32552,		64,		1 }; 
		int[] totalNums = {10, 	5, 		7, 		17,		250000,	17,		351,	250000 }; 
		int[] seqLength = {3, 	2, 		3, 		17,		23,		17,		349,	4789 }; 
		long[] expects 	= {60, 	49, 	102186, 25569,	80,		25569,	196416,	7643623468L}; 
		
		
		int iters = seeds.length; 
		for(int i=0; i<iters; i++){	
			
			System.out.println(">>>>>>>>>>>>>>>>>>>>>> " + i); 
			
			long actual = FloatingMedian.sumOfMediumByBIT(
					seeds[i],muls[i],adds[i], totalNums[i], seqLength[i]); 
			long expected = expects[i]; 
			assertEquals(expected, actual); 
			
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<");  
		}
	}

}
