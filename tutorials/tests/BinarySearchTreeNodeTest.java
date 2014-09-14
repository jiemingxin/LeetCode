package tutorials.tests;

import static org.junit.Assert.assertEquals;

import java.io.PrintStream;
import java.util.Arrays;

import org.junit.Test;

import tutorials.trees.BinarySearchTreeNode;
import tutorials.utils.RandArray;

public class BinarySearchTreeNodeTest {

	private PrintStream print = System.out ; 
	private static int min = 1; 
	private static int max = 10000; 
	private static int arrLen = 6;
	private static int iters = 15; 
	private static int margin = 5;
	

	@Test
	public void testSearch() {
	
		for(int i=0; i<iters; i++){
		
			// populate the data 
			int[] rands  = RandArray.generateRandIntArr(min, max, arrLen); 
			BinarySearchTreeNode root = new BinarySearchTreeNode(rands[0], null); 
			
			for(int j=1; j<arrLen; j++){
				int value = rands[j]; 
				BinarySearchTreeNode.insert(value, root); 
			}
			
			for(int j=0; j<arrLen; j++){
				int value = rands[j];
				BinarySearchTreeNode node = BinarySearchTreeNode.search(value, root);
				assertEquals(value, node.value); 
			}

		}	
	}

	
	@Test
	public void testInsertInt() {
		
		for(int i=0; i<iters; i++){
		
			// populate the data 
			int[] rands  = RandArray.generateRandIntArr(min, max, arrLen); 
			BinarySearchTreeNode root = new BinarySearchTreeNode(rands[0], null); 
			for(int j=1; j<arrLen; j++){
				BinarySearchTreeNode.insert(rands[j], root);  
			}
			
			print.println("<<<<<<<<<<<<<<<<<<<<<<<<");
			print.println(Arrays.toString(rands)); 
			root.prettyPrint(margin, print); 
		}		
	}

	
	@Test
	public void testMinMax() {
		
	
		for(int i=0; i<iters; i++){
		
			// populate the data 
			int[] rands  = RandArray.generateRandIntArr(min, max, arrLen); 
			BinarySearchTreeNode root = new BinarySearchTreeNode(rands[0], null); 
			
			int minVal=rands[0], maxVal=rands[0]; 
			for(int j=1; j<arrLen; j++){
				int value = rands[j]; 
				BinarySearchTreeNode.insert(value, root);  
				
				minVal = Math.min(value, minVal); 
				maxVal = Math.max(value, maxVal); 
			}
			
			assertEquals(minVal, BinarySearchTreeNode.min(root).value); 
			assertEquals(maxVal, BinarySearchTreeNode.max(root).value); 
		}		
	}


	
	
	@Test
	public void testCeilFloor() {
		
		for(int i=0; i<iters; i++){
		
			// populate the data 
			int[] rands  = RandArray.generateRandIntArr(min, max, arrLen); 
			BinarySearchTreeNode root = new BinarySearchTreeNode(rands[0], null); 
			for(int j=1; j<arrLen; j++){
				int value = rands[j]; 
				BinarySearchTreeNode.insert(value, root);  
			}
			
			for(int j=0; j<arrLen;j++){
				int value = rands[j];
				//BinarySearchTreeNode floor = BinarySearchTreeNode.floor(value+1, root);
				//assertEquals(value, floor.value); 
				
				BinarySearchTreeNode ceil = BinarySearchTreeNode.ceil(value-1, root);
				assertEquals(value, ceil.value); 
			}
			
		}		
	}
	
	
	

	@Test
	public void testSuccessor() {
		
		for(int i=0; i<iters; i++){
		
			// populate the data 
			int[] rands  = RandArray.generateRandIntArr(min, max, arrLen);	
			BinarySearchTreeNode root = new BinarySearchTreeNode(rands[0], null); 
			
			for(int j=1; j<arrLen; j++){
				int value = rands[j]; 
				BinarySearchTreeNode.insert(value, root);  
			}
			
			print.println("<<<<<<<<<<<<<<<<<<<<<<<<");
			print.println(Arrays.toString(rands)); 
			root.prettyPrint(margin, print); 

			// note some test case will fail when dealing 
			// with duplicate keys, which is fine. The problem happens
			// because the search method cannot distinguish duplicate keys 
			
			Arrays.sort(rands); 
			for(int j=0; j<arrLen-1; j++){
				int value = rands[j]; 
				BinarySearchTreeNode node = BinarySearchTreeNode.search(value, root); 
				assertEquals(rands[j+1], BinarySearchTreeNode.successor(node).value); 
			}

		}		
	}

	
	
	
	
	@Test
	public void testPredecessor() {
		
		
		for(int i=0; i<iters; i++){
		
			// populate the data 
			int[] rands  = RandArray.generateRandIntArr(min, max, arrLen);	
			BinarySearchTreeNode root = new BinarySearchTreeNode(rands[0], null); 
			
			for(int j=1; j<arrLen; j++){
				BinarySearchTreeNode.insert(rands[j], root);  
			}
			
			print.println("<<<<<<<<<<<<<<<<<<<<<<<<");
			print.println(Arrays.toString(rands)); 
			root.prettyPrint(margin, print); 
			
			// note some test case will fail when dealing 
			// with duplicate keys, which is fine. The problem happens
			// because the search method cannot distinguish duplicate keys 
			Arrays.sort(rands); 
			for(int j=arrLen-1; j>=1; j--){
				int value = rands[j]; 
				//print.println("Current =" + value);
				BinarySearchTreeNode node = BinarySearchTreeNode.search(value, root); //always return the shallowest key 
				assertEquals(rands[j-1], BinarySearchTreeNode.predecessor(node).value); 
			}

		}		
	}

}
