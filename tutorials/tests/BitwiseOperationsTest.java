package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.bitwiseops.BitwiseOperations;

public class BitwiseOperationsTest {

	
	@Test 
	public void testIsPowerofTwoZero(){
		int value = 0 ;
		boolean actual = BitwiseOperations.isPowerofTwo(value); 
		assertFalse(actual);
	}
	
	
	@Test 
	public void testIsPowerofTwoNegativeCase(){
		int value = 45 ;
		boolean actual = BitwiseOperations.isPowerofTwo(value); 
		assertFalse(actual);
	}
	
	
	
	
	@Test 
	public void testIsPowerofTwoPositiveCase(){
		int value = 8 ;
		boolean actual = BitwiseOperations.isPowerofTwo(value); 
		assertTrue(actual);
	}
	
	
	
	@Test 
	public void testCountNumOneBitsCase1(){
		int value    = 8 ;
		int actual   = BitwiseOperations.countNumOneBits(value); 
		int expected = 1; 
		assertTrue(actual==expected);
	}
	
	
	
	@Test 
	public void testCountNumOneBitsCase2(){
		int value    = 0 ;
		int actual   = BitwiseOperations.countNumOneBits(value); 
		int expected = 0 ; 
		assertTrue(actual==expected);
	}
	
	
	
	
	@Test 
	public void testCountNumOneBitsCase3(){
		int value    = 7 ;
		int actual   = BitwiseOperations.countNumOneBits(value); 
		int expected = 3 ; 
		assertTrue(actual==expected);
	}
	
	
	

	
	
	
}
