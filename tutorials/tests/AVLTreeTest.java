package tutorials.tests;

import static org.junit.Assert.assertTrue;

import java.io.PrintStream;
import java.util.Arrays;

import org.junit.Test;

import tutorials.trees.AVLTree;
import tutorials.trees.AVLTreeNode;
import tutorials.trees.BinarySearchTreeNode;
import tutorials.utils.RandArray;

public class AVLTreeTest {


	private PrintStream print = System.out ; 
	private static int min = 1; 
	private static int max = 5000; 
	private static int arrLen = 10;
	private static int iters = 5; 
	private static int margin = 5;
	
	
	//////////////////////////////////////////////////////////////
	/// Auciliary methods 
	//////////////////////////////////////////////////////////////
	
	public static boolean isValidAVLTree(AVLTree tree){
		
		boolean isBST = isBST(tree.getRoot()); 
		boolean isBalanced = isBalanced(tree.getRoot()); 
		return  isBST && isBalanced ; 
	}
	
	protected static boolean isBST(AVLTreeNode root){
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE); 
	}
	
	protected static boolean isBST(AVLTreeNode node, int minValue, int maxValue){
		
		if(node==null)
			return true; 
		
		int value = node.value; 
		if( value < minValue || value > maxValue)
			return false; 
		
		return isBST(node.left(), minValue, value) && isBST(node.right(), value, maxValue);
	}
	
	public static boolean isBalanced(AVLTreeNode node){
		
		if(node==null)
			return true; 
		if(node.getBalance()>=2)
			return false; 
		return isBalanced(node.left()) && isBalanced(node.right()); 
	}
	
	protected void reverse(int[] arr){
		
		int left=0, right=arr.length-1; 
		while( left<right ){
			int tmp 	= arr[left]; 
			arr[left] 	= arr[right];
			arr[right] 	= tmp;  
			left++;
			right--; 
		}
	}
	

	//////////////////////////////////////////////////////////////
	/// Testing methods 
	//////////////////////////////////////////////////////////////
	
	@Test
	public void testInsertRandom() {
		
		for(int i=0; i<iters; i++){  // populate the data  
			
			int[] numbers  = RandArray.generateRandIntArr(min, max, arrLen); 
			AVLTree avlTree = new AVLTree(); 		
			for(int j=0; j<arrLen; j++){
				int value = numbers[j];
				
				print.println(">>>>>>>>>>>>>>>>>>>>>>> Before >>>>>>>>>>>>>>"); 
				avlTree.prettyPrint(margin, print); 
				print.println();
						
		
				print.println(".... inserting " + value);
				avlTree.insert(value); 
				
				print.println(">>>>>>>>>>>>>>>>>>>>>>> After >>>>>>>>>>>>>>"); 
				print.println();
				avlTree.prettyPrint(margin, print); 
				
				assertTrue(isValidAVLTree(avlTree)); 
			}
		}
	}

	
	@Test
	public void testInsertAscend() {
		
		for(int i=0; i<iters; i++){  // populate the data  
			
			int[] numbers  = RandArray.generateRandIntArr(min, max, arrLen);
			Arrays.sort(numbers);
			
			AVLTree avlTree = new AVLTree(); 		
			for(int j=0; j<arrLen; j++){
				int value = numbers[j];
				
				print.println(">>>>>>>>>>>>>>>>>>>>>>> Before >>>>>>>>>>>>>>"); 
				avlTree.prettyPrint(margin, print); 
				print.println();
						
		
				print.println(".... inserting " + value);
				avlTree.insert(value); 
				
				print.println(">>>>>>>>>>>>>>>>>>>>>>> After >>>>>>>>>>>>>>"); 
				print.println();
				avlTree.prettyPrint(margin, print); 
				
				assertTrue(isValidAVLTree(avlTree)); 
			}
		}
	}


	@Test
	public void testInsertDescend() {
		
		for(int i=0; i<iters; i++){  // populate the data  
			
			int[] numbers  = RandArray.generateRandIntArr(min, max, arrLen);
			Arrays.sort(numbers);
			reverse(numbers); 
					
			AVLTree avlTree = new AVLTree(); 		
			for(int j=0; j<arrLen; j++){
				int value = numbers[j];
				
				print.println(">>>>>>>>>>>>>>>>>>>>>>> Before >>>>>>>>>>>>>>"); 
				avlTree.prettyPrint(margin, print); 
				print.println();
						
		
				print.println(".... inserting " + value);
				avlTree.insert(value); 
				
				print.println(">>>>>>>>>>>>>>>>>>>>>>> After >>>>>>>>>>>>>>"); 
				print.println();
				avlTree.prettyPrint(margin, print); 
				
				assertTrue(isValidAVLTree(avlTree)); 
			}
		}
	}
	
	
	
	@Test
	public void testDelete() {
		
		for(int i=0; i<iters; i++){
			
			// populate the data 
			int[] rands  = RandArray.generateRandIntArr(min, max, arrLen); 
			AVLTree avlTree = new AVLTree(); 	
			
			for(int j=0; j<arrLen; j++){
				avlTree.insert(rands[j]); 
			}
			
			for(int j=0; j<arrLen; j++){
				int value = rands[j];
				
				print.println(">>>>>>>>>>>>>>>>>>>>>>> Before >>>>>>>>>>>>>>"); 
				avlTree.prettyPrint(margin, print); 
				print.println();
						
				BinarySearchTreeNode node = avlTree.search(value);
				print.println(".... removing " + value);
				avlTree.delete(value); 
				
				print.println(">>>>>>>>>>>>>>>>>>>>>>> After >>>>>>>>>>>>>>"); 
				print.println();
				avlTree.prettyPrint(margin, print); 
				
				node = avlTree.search(value);
				assertTrue(node==null); 
				assertTrue(isValidAVLTree(avlTree)); 
			}
		}	
	}
	
	
	
	

	

	
}
