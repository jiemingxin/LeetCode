package tutorials.tests;

import org.junit.Test;

import tutorials.strings.AnagramSearch;

public class AnagramSearchTest {

	@Test
	public void testSearch() {
		String text = "BACDGABCDA" ; 
		String pattern = "ABCD" ; 
		AnagramSearch.search(text, pattern); 
	}

}
