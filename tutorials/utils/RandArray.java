package tutorials.utils;

import java.util.Random;

public class RandArray {

	public static int[] generateRandIntArr(int min, int max, int arrLen){
			
		Random rand = new Random();
		int[] arr = new int[arrLen];
		int range = max-min+1;
		for(int i=0; i<arrLen; i++)
			arr[i] = rand.nextInt(max) % range + min;
		return arr; 
	}

}
