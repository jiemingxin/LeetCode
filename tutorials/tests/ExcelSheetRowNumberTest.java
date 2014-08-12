package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.array.ExcelSheetRowNumber;

public class ExcelSheetRowNumberTest {


			//@Test
		public void testNumToStrNullCase() {
			int number = -1;
			String actual = ExcelSheetRowNumber.numToStr(number);
			assertEquals(actual, null);
		}
		
		
		//@Test
		public void testNumToStrCase1() {
			int number = 0;
			String actual = ExcelSheetRowNumber.numToStr(number);
			String expected = "a";
			assertEquals(actual, expected);
		}
		
		
		
		@Test
		public void testNumToStrCase2() {
		int number = 727;
		String actual = ExcelSheetRowNumber.numToStr(number);
		String expected = "aaz";
		assertEquals(actual, expected);
		}
		
		
		
		//@Test
		public void testNumToStrCase3() {
		int number = 701;
		String actual = ExcelSheetRowNumber.numToStr(number);
		String expected = "zz";
		assertEquals(actual, expected);
		}
		
		
		//@Test
		public void testNumToStrCase4() {
		int number = 677;
		String actual = ExcelSheetRowNumber.numToStr(number);
		String expected = "zb";
		assertEquals(actual, expected);
		}
		


	
	
}
