package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.graph.CircularStringChains;

public class CircularStringChainsTest {

	@Test
	public void testCanFormCircleCase1() {
		
		String[] arr = {"geek", "king"}; 
		boolean expected = true ; 
		boolean actual   = CircularStringChains.canFormCircleRecursive(arr); 
		assertEquals(expected, actual);
		
		actual = CircularStringChains.canFormCircleGraph(arr); 
		assertEquals(expected, actual);
	}

	
	@Test
	public void testCanFormCircleCase2() {
		
		String[] arr =  {"for", "geek", "rig", "kaf"}; 
		boolean expected = true ; 
		boolean actual   = CircularStringChains.canFormCircleRecursive(arr); 
		assertEquals(expected, actual);
		
		actual = CircularStringChains.canFormCircleGraph(arr); 
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void testCanFormCircleCase3() {
		
		String[] arr = {"aaa", "bbb", "baa", "aab"}; 
		boolean expected = true ; 
		boolean actual   = CircularStringChains.canFormCircleRecursive(arr); 
		assertEquals(expected, actual);
		
		actual = CircularStringChains.canFormCircleGraph(arr); 
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCanFormCircleCase4() {
		
		String[] arr = {"aaa"} ; 
		boolean expected = true ; 
		boolean actual   = CircularStringChains.canFormCircleRecursive(arr); 
		assertEquals(expected, actual);
		
		actual = CircularStringChains.canFormCircleGraph(arr); 
		assertEquals(expected, actual);
	}
	

	
	@Test
	public void testCanFormCircleCase5() {
		
		String[] arr = {"aaa", "bbb"} ; 
		boolean expected = false ; 
		boolean actual   = CircularStringChains.canFormCircleRecursive(arr); 
		assertEquals(expected, actual);
		
		actual = CircularStringChains.canFormCircleGraph(arr); 
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void testCanFormCircleCase6() {
		
		String[] arr =  {"geek", "for", "rig", "kaf"}; 
		boolean expected = true ; 
		boolean actual   = CircularStringChains.canFormCircleRecursive(arr); 
		assertEquals(expected, actual);
		
		actual = CircularStringChains.canFormCircleGraph(arr); 
		assertEquals(expected, actual);
	}
	
	
	

	
}
