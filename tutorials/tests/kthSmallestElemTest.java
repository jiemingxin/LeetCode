package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.array.kthSmallestElem;

public class kthSmallestElemTest {


		//@Test
		public void testMergeFind() {
		
			int[] A0 = {1,2,3,4};
			int[] B0 = {5,6,7,8};
			int k = 3;
			int expected = 3;
			int actual = kthSmallestElem.mergeFind(A0,B0,k);
			assertEquals(expected, actual);
			
			int[] A1 ={-1, 0, 5, 6, 7};
			int[] B1 ={-1, 0, 5, 6, 7};
			expected = 0 ;
			actual = kthSmallestElem.mergeFind(A1,B1,k);
			assertEquals(expected, actual);
			
			
			int[] A2 ={5, 7, 8, 9, 10};
			int[] B2 ={4, 5, 6, 10, 11};
			k = 4;
			expected = 6 ;
			actual = kthSmallestElem.mergeFind(A2,B2,k);
			assertEquals(expected, actual);
			
			
			int[] A3 ={5, 7, 8, 9, 10};
			int[] B3 ={4, 5, 6, 10, 11};
			k = 5;
			expected = 7 ;
			actual = kthSmallestElem.mergeFind(A3,B3,k);
			assertEquals(expected, actual);
		}
		
		
		
		@Test
		public void testSearchFind() {
		
			int[] A0 = {0,1,2};
			int[] B0 = {-2,-1};
			int k = 4;
			int expected = 3;
			int actual = kthSmallestElem.searchFind(A0,B0,k);
			assertEquals(expected, actual);
			
//			int[] A1 ={-1, 0, 5, 6, 7};
//			int[] B1 ={-1, 0, 5, 6, 7};
//			expected = 0 ;
//			actual = kthSmallestElem.searchFind(A1,B1,k);
//			assertEquals(expected, actual);
//			
//			
//			int[] A2 ={5, 7, 8, 9, 10};
//			int[] B2 ={4, 5, 6, 10, 11};
//			k = 4;
//			expected = 6 ;
//			actual = kthSmallestElem.searchFind(A2,B2,k);
//			assertEquals(expected, actual);
//			
//			
//			int[] A3 ={5, 7, 8, 9, 10};
//			int[] B3 ={4, 5, 6, 10, 11};
//			k = 5;
//			expected = 7 ;
//			actual = kthSmallestElem.searchFind(A3,B3,k);
//			assertEquals(expected, actual);
		}
		

}