package tutorials.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tutorials.graph.DirectedGraph;

public class DirectedGraphTest {

	@Test
	public void testCase1() {
		
		DirectedGraph diGraph = new DirectedGraph(5);
		diGraph.addEdge(0, 1);
		diGraph.addEdge(1, 2);
		diGraph.addEdge(2, 3);
		diGraph.addEdge(3, 0);
		diGraph.addEdge(2, 4);
		diGraph.addEdge(4, 2);
		
		boolean actual = diGraph.areNonzeroVerticesConnected(); 
		boolean expected = true; 
		
		actual = diGraph.isEulerianCircuit(); 
		expected = true; 
		assertEquals(actual, expected); 		
	}
	
	@Test
	public void testCase2() {
		
		DirectedGraph diGraph = new DirectedGraph(5);
		diGraph.addEdge(0, 1);
		diGraph.addEdge(1, 2);
		diGraph.addEdge(2, 3);
		diGraph.addEdge(3, 0);
		diGraph.addEdge(2, 4);
		
		boolean actual = diGraph.areNonzeroVerticesConnected(); 
		boolean expected = true; // 4's out degree is 0, hence 
		assertEquals(actual, expected); 	
		
		actual = diGraph.isEulerianCircuit(); 
		expected = false; 
		assertEquals(actual, expected); 
	}
	
	
	@Test
	public void testCase3() {
		
		DirectedGraph diGraph = new DirectedGraph(4);
		diGraph.addEdge(0, 1);
		diGraph.addEdge(1, 2);
		diGraph.addEdge(2, 3);
		
		boolean actual = diGraph.areNonzeroVerticesConnected(); 
		boolean expected = false; 
		assertEquals(actual, expected); 		
		
		actual = diGraph.isEulerianCircuit(); 
		expected = false; 
		assertEquals(actual, expected); 
	}
	
	
	@Test
	public void testIsStronglyConnectedtCase4() {
		
		DirectedGraph diGraph = new DirectedGraph(4);		
		boolean actual = diGraph.areNonzeroVerticesConnected(); 
		boolean expected = false; 
		assertEquals(actual, expected); 	
		
		actual = diGraph.isEulerianCircuit(); 
		expected = false; 
		assertEquals(actual, expected); 
	}
	

}
