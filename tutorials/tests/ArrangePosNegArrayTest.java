package tutorials.tests;

import java.util.Arrays;

import org.junit.Test;

import tutorials.array.ArrangePosNegArray;

public class ArrangePosNegArrayTest {

	
	@Test
	public void testArrangeCase1() {
		 int arr[] = {1, 2, 3, -4, -1, 4}; 
		 ArrangePosNegArray.arrange(arr); 
		 System.out.println(Arrays.toString(arr)); 
	}

	
	@Test
	public void testArrangeCase2() {
		 int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
		 ArrangePosNegArray.arrange(arr); 
		 System.out.println(Arrays.toString(arr)); 
	}
	
	
	@Test
	public void testArrangeCase3() {
		 int arr[] = {-5, -2, -6, -2, -4, -7, 1, 8, 0, -8};
		 ArrangePosNegArray.arrange(arr); 
		 System.out.println(Arrays.toString(arr)); 
	}
	
	
	@Test
	public void testArrangeCase4() {
		 int arr[] = {1,2,3,4,5,6,7,8,-1,-2,-3,-4};
		 ArrangePosNegArray.arrange(arr); 
		 System.out.println(Arrays.toString(arr)); 
	}
	
	
	
	
	
	
}
