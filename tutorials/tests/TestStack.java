package tutorials.tests;

import java.util.Stack;

public class TestStack {


	public static void main(String[] args){
		
		Stack<Integer> stack = new Stack<Integer>(); 
		
		Integer value = new Integer(1); 
		
		stack.push(value); 
		value ++; 
		
		System.out.println(value);
		
		System.out.println( stack.pop()); 
		
	}
	
	
	
	
}
