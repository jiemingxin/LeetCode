package tutorials.array;

/**
 * 
 * == Problem == 
 * 
 *  Given a number n, output the smallest number that has the same set of digits 
 *  and greater than n. 
 *  
 *  http://www.geeksforgeeks.org/find-next-greater-number-set-digits/ 
 * 
 *  == Examples == 
 *  (1)  "218765"  --> "251678" 
 *  (2)  "1234" --> "1243" 
 *  (3)  "4321" --> "N/A" 
 *  (4)  "534976" --> "536479" 
 * 
 * == Analysis == 
 *  Since the desired number shares the same set of digits with the 
 *  given number, this problem boils down to an array manipulate problem. We plan to 
 *  to find the next number by swapping digits from the array.
 * 
 *  Observations from the examples show that, we have the following 
 *  conclusions:
 *  
 *  (1) if the digits are sorted in ascending order from the rightmost 
 *      side, then there is no answer. For example ,"4321". 
 *      The reason being the most significant digit is the largest.
 *  (2) we scan from the right most side, keep traversing until we find
 *      an digit arr[i], such that arr[i] < arr[i+1]. Denote its index
 *      as "pivot". For example, the pviot of "218765" is 1, corresponding
 *      to '1'  
 *  (3) we then search in arr[pivot+1..end-1], to locate the smallest 
 *      arr[j], such that arr[j] > arr[pivot]. After we find j, we swap
 *      arr[j] and arr[pivot]. Now we get one number greater than n, but
 *      this may not be the smallest one. 
 *  (4) to make this number the smallest, we need to sort 
 *      arr[pivot+1..end-1] 
 *  
 * @author jack
 *
 */
public class NextGreatNumber {

	public static String findNext(String figure){
		
		char[] arr = figure.toCharArray(); 
		int nChars = figure.length(); 
		
		int pivot = -1; 
		for(int i=nChars-1; i>0 ; i--)
			if(arr[i-1]<arr[i]){
				pivot = i-1; 
				break ; 
			}
		if(pivot ==-1)
			return "N/A"; 
		
		// look for the minimum arr[i] such that i>pivot and 
		// arr[i]>arr[pivot], then swap them 
		char min = 255; 
		int idx  = 0; 
		for(int i=pivot+1; i<nChars; i++){
			char val = arr[i]; 
			if( val > arr[pivot] && val < min ){
				min = val; idx = i;  
			}
		}
		char tmp = arr[pivot]; 
		arr[pivot] = arr[idx];
		arr[idx] = tmp ; 
		
		// sort the [pivot+1..nChars-1] 
		for(int i=pivot+2; i<nChars; i++){
			char x = arr[i]; 
			int  j = i ; 
			while( j>pivot+1 && arr[j-1] > x ){
				arr[j] = arr[j-1]; 
				j--; 
			}
			arr[j] = x ; 
		}
	
		return new String(arr); 
	}
	
}
