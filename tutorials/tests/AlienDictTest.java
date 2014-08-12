package tutorials.tests;

import static org.junit.Assert.*;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

import org.junit.Test;

import tutorials.graph.AlienDict;

public class AlienDictTest {

	PrintStream print = System.out ; 
	
	@Test
	public void testAssignIdsCase1() {
		String[] words = {"baa", "abcd", "abca", "cab", "cad"}; 
		HashMap<Character, Integer> charToId = new HashMap<Character, Integer>(); 
		HashMap<Integer, Character> idToChar = new HashMap<Integer, Character>(); 
		AlienDict.assignIds(words, charToId, idToChar); 
		
		print.println("== testAssignId Case 1=="); 
		Set<Integer> ids = idToChar.keySet();
		for(Integer id:ids)
			print.print(id + "-->" + idToChar.get(id) + " "); 
		print.println(); 
		
		Set<Character> chars = charToId.keySet();
		for(Character ch:chars)
			print.print(ch + "-->" + charToId.get(ch) + " "); 
		print.println("\n========="); 
				
	}
	
	
	
	@Test 
	public void testAssignIdsCase2(){
		String[] words = {"caa", "aaa", "aab"}; 
		HashMap<Character, Integer> charToId = new HashMap<Character, Integer>(); 
		HashMap<Integer, Character> idToChar = new HashMap<Integer, Character>(); 
		AlienDict.assignIds(words, charToId, idToChar);  
		
		print.println("== testAssignId Case 2=="); 
		Set<Integer> ids = idToChar.keySet();
		for(Integer id:ids)
			print.print(id + "-->" + idToChar.get(id) + " "); 
		print.println(); 
		
		Set<Character> chars = charToId.keySet();
		for(Character ch:chars)
			print.print(ch + "-->" + charToId.get(ch) + " "); 
		print.println("\n=========");  	
	}
	
	
	@Test
	public void testConstructGraphCase1(){
	
		String[] words = {"baa", "abcd", "abca", "cab", "cad"}; 
		HashMap<Character, Integer> charToId = new HashMap<Character, Integer>(); 
		HashMap<Integer, Character> idToChar = new HashMap<Integer, Character>(); 
		AlienDict.assignIds(words, charToId, idToChar);   
		
		int numNodes = idToChar.keySet().size(); 
		int[][] graph = new int[numNodes][numNodes]; 
		AlienDict.constructGraph(words, charToId, graph);
		
		print.println("== testConstructGraphCase1 ==");  
		for(int i=0; i<numNodes; i++){
			print.println(Arrays.toString(graph[i])); 
		}
		
	}
		
	
	
	@Test
	public void testconstructGraphCase2(){
		
		String[] words = {"caa", "aaa", "aab"}; 
		HashMap<Character, Integer> charToId = new HashMap<Character, Integer>(); 
		HashMap<Integer, Character> idToChar = new HashMap<Integer, Character>(); 
		AlienDict.assignIds(words, charToId, idToChar);  
		
		int numNodes = idToChar.keySet().size(); 
		int[][] graph = new int[numNodes][numNodes]; 
		AlienDict.constructGraph(words, charToId, graph);
		
		print.println("== testConstructGraphCase2 ==");  
		for(int i=0; i<numNodes; i++){
			print.println(Arrays.toString(graph[i])); 
		}
	}
	
	
	@Test
	public void testGetCharOrderCase1(){
		String[] words = {"baa", "abcd", "abca", "cab", "cad"};  
		String actual = AlienDict.getCharOrder(words); 
		String expected = "bdac" ; 
		assertEquals(actual, expected); 	
	}
	
	
	@Test
	public void testGetCharOrderCase2(){
		String[] words = {"caa", "aaa", "aab"};  
		String actual = AlienDict.getCharOrder(words); 
		String expected = "cab" ; 
		assertEquals(actual, expected); 	
	}
	
	
	
	


}
