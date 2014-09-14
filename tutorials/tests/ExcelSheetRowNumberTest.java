package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.array.ExcelSheetRowNumber;

public class ExcelSheetRowNumberTest {


		@Test
		public void testNumToStrNullCase() {
			int number = -1;
			String actual = ExcelSheetRowNumber.numToStr(number);
			assertEquals(null, actual);
			
			actual = ExcelSheetRowNumber.numToStr2(number);
			assertEquals(null, actual);

		}
		
		
		@Test
		public void testNumToStrCase1() {
			int number = 0;
			String actual = ExcelSheetRowNumber.numToStr(number);
			String expected = "a";
			assertEquals(expected, actual);
			
			number = 1;
			actual = ExcelSheetRowNumber.numToStr2(number);
			expected = "a";
			assertEquals(expected, actual);
		}
		
		
		
		@Test
		public void testNumToStrCase2() {
			int number = 727;
			String actual = ExcelSheetRowNumber.numToStr(number);
			String expected = "aaz";
			assertEquals(expected, actual);
			
			number = 728;
			actual = ExcelSheetRowNumber.numToStr2(number);
			assertEquals(expected, actual);
		}
		
		
		
		@Test
		public void testNumToStrCase3() {
			int number = 701;
			String actual = ExcelSheetRowNumber.numToStr(number);
			String expected = "zz";
			assertEquals(expected, actual);
			
			number +=1;
			actual = ExcelSheetRowNumber.numToStr2(number);
			assertEquals(expected, actual);
		}
		
		
		@Test
		public void testNumToStrCase4() {
			int number = 677;
			String actual = ExcelSheetRowNumber.numToStr(number);
			String expected = "zb";
			assertEquals(expected, actual);
			
			
			number +=1;
			actual = ExcelSheetRowNumber.numToStr2(number);
			assertEquals(expected, actual);
			
		}
		


	
	
}
