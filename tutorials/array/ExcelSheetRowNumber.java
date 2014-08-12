
package tutorials.array; 

public class ExcelSheetRowNumber {


		public static int ALPHABET_SIZE = 26 ;
		
		
		public static String numToStr(int number){
		
			if( number < 0 )
				return null ;
		
			StringBuffer buffer = new StringBuffer();
		
			// get the length of the string
			int length = 1;
			int radix = ALPHABET_SIZE ;
			while(number > 0){
				radix = radix * ALPHABET_SIZE ;
				number = number / radix ;
				length ++;
			}
			
			
			for(int i=length; i>0; i--){
				char c = (char) ('a' + length/ALPHABET_SIZE) ;
				buffer.append(c);
			}
			
			return buffer.toString();
		}


		
		

		
		
		
		

}