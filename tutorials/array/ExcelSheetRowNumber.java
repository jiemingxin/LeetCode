package tutorials.array; 

public class ExcelSheetRowNumber {

		public static int ALPHABET_BASE = 26 ;
				
		/**
		 *  S1 = {"a","b","c","d",....."z", "aa","ab", ...}
		 *  S2 = { 0,  1,  2,  3,...    25,  26,  27,  ...} 
		 *  
		 *  Write a method to convert items in S2 to S1 
		 *  
		 * @param num
		 * @return
		 */
		public static String numToStr(int num){
		
			if( num < 0 )
				return null ;			
			StringBuilder builder = new StringBuilder();
			int rem = num % ALPHABET_BASE ;
			builder.append((char) ('a' +rem) );
			num= (num-rem)/ALPHABET_BASE; 
			
			
			while( num>0 ){
				rem = (num-1) % ALPHABET_BASE ; 
				builder.append((char)('a' + rem)); 		
				num = (num - rem -1)/ALPHABET_BASE ; 
			}
			return builder.reverse().toString(); 
		}

		
		/**
		 *  S1 = {"a","b","c","d",....."z", "aa","ab", ...}
		 *  S2 = { 1,  2,  3,  4,...    26,  27,  28,  ...} 
		 *  
		 *  Write a method to convert items in S2 to S1 
		 *  
		 * @param num
		 * @return
		 */
		public static String numToStr2(int num){
			
			if( num < 0 )
				return null ;
			
			StringBuilder builder = new StringBuilder();
			while(num>0){
				int rem = num % ALPHABET_BASE; 
				if(rem==0){
					builder.append('z');
					num -= ALPHABET_BASE ; 
				}else{
					builder.append((char)('a'+rem-1));
					num -= rem; 
				}
				num /= ALPHABET_BASE ; 
			}
			return builder.reverse().toString(); 
		}
		
		
		/**
		 *  S1 = {"a","b","c","d",....."z", "aa","ab", ...}
		 *  S2 = { 0,  1,  2,  3,...    25,  26,  27,  ...} 
		 *  
		 *  Write a method to convert items in S2 to S1 
		 *  
		 * @param num
		 * @return
		 */
		public static String numToStrRecursive(int num){
			
			if(num<0)   // handle exception 
				return null; 
			if(num<26) // handle the base case 
				return Character.toString((char)('a' + num));
			
			StringBuilder builder = new StringBuilder();
			builder.append( numToStrRecursive(num/26-1) ); 
			builder.append((char)('a' + num%26)); 
			return builder.toString(); 
		}

}