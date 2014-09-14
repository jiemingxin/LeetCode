package tutorials.array;

/**
 * == Problem == 
 * 
 * http://www.geeksforgeeks.org/count-possible-groups-size-2-3-sum-multiple-3/
 * 
 * Count all possible groups of size 2 or 3 that have sum as multiple of 3
 *  
 * Given an unsorted integer (positive values only) array of size ‘n’, we can 
 * form a group of two or three, the group should be such that the sum of all
 * elements in that group is a multiple of 3. 
 *  
 * == Analysis == 
 * 
 * This is actually a maths problem. The key is to divide the numbers in the 
 * group based on their remainders divided by 3. 
 * 
 * @author jack
 *
 */
public class CountGroups {

	public static int count(int[] arr){
		
		// remCounts[i] keeps the #elements whose remainder 
		// is i divided by 3. There are three groups, namely
		// groups 0, 1, and 2 
		int[] remCounts = {0,0,0}; 
		for(int i=0; i<arr.length; i++)
			remCounts[arr[i]%3]++; 
		
		int total = 0; 
		/**
		 * Count the group of size 2, two possibilities:
		 * (1) both elements have remainder of 0 
		 *     => select 2 values from group 0 
		 * (2)  one has remainder of 1, and the other has 2 
		 *     => select 1 from group 1 and the other from group 2 
		 */
		total += calcCombinations(remCounts[0], 2); 
		total += (remCounts[1] * remCounts[2]); 
		
		/**
		 * count the group of size 3: 
		 * 
		 * (1) all of them are from group 0 
		 * (2) all of them are from group 1 
		 * (3) all of them are from group 2 
		 * (4) each of them are from group 0, 1, and 2 respectively
		 */
		total += calcCombinations(remCounts[0], 3);
		total += calcCombinations(remCounts[1], 3);
		total += calcCombinations(remCounts[2], 3);
		total += remCounts[0] * remCounts[1] * remCounts[2];
		
		return total ; 
	}
	
	/**
	 *  Compute the combinations of C(total,selects)
	 * 
	 * 
	 * @param total
	 * @param selects
	 * @return
	 */
	protected static int calcCombinations(int total, int selects){
		
		int combinations = 1; 
		for(int i=0; i<selects; i++)
			combinations *= (total-i);	
		for(int i=1; i<=selects; i++)
			combinations /= i; 
		return combinations ; 
	}
}
