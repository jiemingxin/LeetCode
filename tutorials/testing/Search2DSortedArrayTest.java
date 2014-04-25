package tutorials.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.array.Search2DSortedArray;
import tutorials.utils._;

public class Search2DSortedArrayTest {

	public static int[][] mat = { 
					{1,  4,  7,  11, 15}, 
					{2,  5,  8,  12, 19}, 
					{3,  6,  9,  16, 22}, 
					{10, 13, 14, 17, 24},
					{18, 21, 23, 26, 30} 
				}; 
	
	@Test
	public void testStepwiseSearchValueSmallerThanMinimum() {
		
		_<Integer> rowLoc = new _<Integer>(); 
		_<Integer> colLoc = new _<Integer>(); 
		int target = -1 ; 
	
		boolean actual = Search2DSortedArray.stepwiseSearch(mat, target, rowLoc, colLoc); 
		assertFalse(actual); 
	}
	
	
	@Test
	public void testStepwiseSearchValueBiggerThanMaximum() {
		
		_<Integer> rowLoc = new _<Integer>(); 
		_<Integer> colLoc = new _<Integer>(); 
		int target = 100 ; 
	
		boolean actual = Search2DSortedArray.stepwiseSearch(mat, target, rowLoc, colLoc); 
		assertFalse(actual); 
	}
	
	
	@Test
	public void testStepwiseSearchValueInsideMatrix1() {
		
		_<Integer> actualRowLoc = new _<Integer>(); 
		_<Integer> actualColLoc = new _<Integer>(); 
		int target = 14 ; 
		int expectedRowLoc = 3; 
		int expectedColLoc = 2; 
		
		boolean actual = Search2DSortedArray.stepwiseSearch(mat, target, actualRowLoc, actualColLoc); 
		assertFalse(!actual); 
		assertEquals(expectedRowLoc,actualRowLoc.value().intValue());
		assertEquals(expectedColLoc,actualColLoc.value().intValue());		
	}
	
	
	
	@Test
	public void testStepwiseSearchValueInsideMatrix2() {
		
		_<Integer> actualRowLoc = new _<Integer>(); 
		_<Integer> actualColLoc = new _<Integer>(); 
		int target = 10 ; 
		int expectedRowLoc = 3; 
		int expectedColLoc = 0; 
		
		boolean actual = Search2DSortedArray.stepwiseSearch(mat, target, actualRowLoc, actualColLoc); 
		assertFalse(!actual); 
		assertEquals(expectedRowLoc,actualRowLoc.value().intValue());
		assertEquals(expectedColLoc,actualColLoc.value().intValue());		
	}
	
	
	@Test
	public void testStepwiseSearchValueInsideMatrix3() {
		
		_<Integer> actualRowLoc = new _<Integer>(); 
		_<Integer> actualColLoc = new _<Integer>(); 
		int target = 7 ; 
		int expectedRowLoc = 0; 
		int expectedColLoc = 2; 
		
		boolean actual = Search2DSortedArray.stepwiseSearch(mat, target, actualRowLoc, actualColLoc); 
		assertFalse(!actual); 
		assertEquals(expectedRowLoc,actualRowLoc.value().intValue());
		assertEquals(expectedColLoc,actualColLoc.value().intValue());		
	}
	
	
	@Test
	public void testStepwiseSearchValueInsideMatrix4() {
		
		_<Integer> actualRowLoc = new _<Integer>(); 
		_<Integer> actualColLoc = new _<Integer>(); 
		int target = 30 ; 
		int expectedRowLoc = 4; 
		int expectedColLoc = 4; 
		
		boolean actual = Search2DSortedArray.stepwiseSearch(mat, target, actualRowLoc, actualColLoc); 
		assertFalse(!actual); 
		assertEquals(expectedRowLoc,actualRowLoc.value().intValue());
		assertEquals(expectedColLoc,actualColLoc.value().intValue());		
	}
	
	
	
	@Test
	public void testQuadPartSearchValueSmallerThanMinimum() {
		
		_<Integer> rowLoc = new _<Integer>(); 
		_<Integer> colLoc = new _<Integer>(); 
		int target = -1 ; 
	
		boolean actual = Search2DSortedArray.quadPartSearch(mat, target, rowLoc, colLoc); 
		assertFalse(actual); 
	}
	
	
	@Test
	public void testQuadPartSearchValueBiggerThanMaximum() {
		
		_<Integer> rowLoc = new _<Integer>(); 
		_<Integer> colLoc = new _<Integer>(); 
		int target = 100 ; 
	
		boolean actual = Search2DSortedArray.quadPartSearch(mat, target, rowLoc, colLoc); 
		assertFalse(actual); 
	}
	
	
	
	@Test
	public void testQuadPartSearchValueInsideMatrix1() {
		
		_<Integer> actualRowLoc = new _<Integer>(); 
		_<Integer> actualColLoc = new _<Integer>(); 
		int target = 14 ; 
		int expectedRowLoc = 3; 
		int expectedColLoc = 2; 
		
		boolean actual = Search2DSortedArray.quadPartSearch(mat, target, actualRowLoc, actualColLoc); 
		assertFalse(!actual); 
		assertEquals(expectedRowLoc,actualRowLoc.value().intValue());
		assertEquals(expectedColLoc,actualColLoc.value().intValue());		
	}
	
	
	
	@Test
	public void testQuadPartSearchValueInsideMatrix2() {
		
		_<Integer> actualRowLoc = new _<Integer>(); 
		_<Integer> actualColLoc = new _<Integer>(); 
		int target = 10 ; 
		int expectedRowLoc = 3; 
		int expectedColLoc = 0; 
		
		boolean actual = Search2DSortedArray.quadPartSearch(mat, target, actualRowLoc, actualColLoc); 
		assertFalse(!actual); 
		assertEquals(expectedRowLoc,actualRowLoc.value().intValue());
		assertEquals(expectedColLoc,actualColLoc.value().intValue());		
	}
	
	
	
	@Test
	public void testQuadPartSearchValueInsideMatrix3() {
		
		_<Integer> actualRowLoc = new _<Integer>(); 
		_<Integer> actualColLoc = new _<Integer>(); 
		int target = 7 ; 
		int expectedRowLoc = 0; 
		int expectedColLoc = 2; 
		
		boolean actual = Search2DSortedArray.quadPartSearch(mat, target, actualRowLoc, actualColLoc); 
		assertFalse(!actual); 
		assertEquals(expectedRowLoc,actualRowLoc.value().intValue());
		assertEquals(expectedColLoc,actualColLoc.value().intValue());		
	}
	
	
	@Test
	public void testQuadPartSearchValueInsideMatrix4() {
		
		_<Integer> actualRowLoc = new _<Integer>(); 
		_<Integer> actualColLoc = new _<Integer>(); 
		int target = 30 ; 
		int expectedRowLoc = 4; 
		int expectedColLoc = 4; 
		
		boolean actual = Search2DSortedArray.quadPartSearch(mat, target, actualRowLoc, actualColLoc); 
		assertFalse(!actual); 
		assertEquals(expectedRowLoc,actualRowLoc.value().intValue());
		assertEquals(expectedColLoc,actualColLoc.value().intValue());		
	}
	
	
	
	
	

}
