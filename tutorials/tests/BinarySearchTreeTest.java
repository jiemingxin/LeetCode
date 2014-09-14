package tutorials.tests;

import static org.junit.Assert.*;

import java.io.PrintStream;

import org.junit.Test;

import tutorials.trees.BinarySearchTree;
import tutorials.trees.BinarySearchTreeNode;
import tutorials.utils.RandArray;

public class BinarySearchTreeTest {

	private PrintStream print = System.out ; 
	private static int min = 1; 
	private static int max = 10000; 
	private static int arrLen = 6;
	private static int iters = 15; 
	private static int margin = 5;
	
	
	@Test
	public void testDelete() {
		
		for(int i=0; i<iters; i++){
			
			// populate the data 
			int[] rands  = RandArray.generateRandIntArr(min, max, arrLen); 
			BinarySearchTree bst = new BinarySearchTree(rands[0]); 
			for(int j=1; j<arrLen; j++){
				bst.insert(rands[j]); 
			}
			
			for(int j=0; j<arrLen; j++){
				int value = rands[j];
				
				print.println(">>>>>>>>>>>>>>>>>>>>>>> Before >>>>>>>>>>>>>>"); 
				bst.prettyPrint(margin, print); 
				print.println();
						
				BinarySearchTreeNode node = bst.search(value);
				print.println(".... removing " + value);
				bst.delete(node); 
				
				print.println(">>>>>>>>>>>>>>>>>>>>>>> After >>>>>>>>>>>>>>"); 
				print.println();
				bst.prettyPrint(margin, print); 
				
				node = bst.search(value);
				assertTrue(node==null); 
	
			}
		}	
	}

}
