package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.strings.WordCount;

public class WordCountTest {

	
	
	@Test
	public void testCountWordsNoWords() {
		
		String str = "           " ; 
		int expected = str.split("\\s").length; 
		int actual   = WordCount.countWords(str); 
		
		assertEquals(expected, actual); 
	}

	
	
	@Test
	public void testCountWordsTwoWords() {
		
		String str = "hello world ." ; 
		int expected = str.split("\\s").length; 
		int actual   = WordCount.countWords(str); 
		
		assertEquals(expected, actual); 
	}
	
	
	
	@Test
	public void testCountWordsThreeWords() {
		
		String str = "hi are you ?" ; 
		int expected = str.split("\\s").length; 
		int actual   = WordCount.countWords(str); 
		
		assertEquals(expected, actual); 
	}
	
	
	/**
	 *  The sentence for test comes from http://en.wikipedia.org/wiki/Audrey_Hepburn 
	 * 
	 */
	@Test
	public void testCountWordsManyWords() {
		
		String str = "Audrey Hepburn (born Audrey Kathleen Ruston; 4 May 1929 ¨C 20 January 1993) was a British actress and humanitarian. " ; 
		int expected = str.split("\\s").length; 
		int actual   = WordCount.countWords(str); 
		
		assertEquals(expected, actual); 
	}
	
	
	
	
}
