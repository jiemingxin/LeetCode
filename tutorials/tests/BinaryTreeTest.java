package tutorials.tests;

import static org.junit.Assert.*;

import java.io.PrintStream;
import org.junit.Test;
import tutorials.trees.BinaryTree;


public class BinaryTreeTest {

	
	public static boolean isSameBinaryTree(BinaryTree s, BinaryTree t){
	
		if(s==null && t==null)
			return true ; 
		
		if(s==null || t==null)
			return false; 
		
		return  (s.value == t.value) && isSameBinaryTree(s.left, t.left) 
									 && isSameBinaryTree(s.right, t.right); 
	}
	
	
	
	
	public static BinaryTree createTwoLevelBinaryTree(){
		
		BinaryTree root = new BinaryTree(5); 
		root.right  = new BinaryTree(7); 
		return root ; 
	}
	
	
	
	public static BinaryTree createThreeLevelBinaryTree(){
		
		BinaryTree root = new BinaryTree(10); 
		root.left  = new BinaryTree(5); 
		root.right = new BinaryTree(15); 
		root.left.left   = new BinaryTree(1); 
		root.left.right  = new BinaryTree(8); 
		root.right.right = new BinaryTree(17); 
	
		return root ; 
	}
	
	
	
	public static BinaryTree createBalancedBinarySearchTree(){
		
		BinaryTree root = new BinaryTree(10); 
		root.left  = new BinaryTree(5); 
		root.right = new BinaryTree(15); 
		root.left.left   = new BinaryTree(1); 
		root.left.right  = new BinaryTree(8); 
		root.right.right = new BinaryTree(17); 
	
		return root ; 
	}
	
	
	
	
	
	
	public static BinaryTree createFourLevelBinaryTree(){
		
		BinaryTree root = new BinaryTree(5); 
		root.left  = new BinaryTree(3); 
		root.right = new BinaryTree(25); 
		root.left.left   = new BinaryTree(2); 
		root.left.right  = new BinaryTree(4); 
		root.right.left  = new BinaryTree(11); 
		root.right.left.right = new BinaryTree(20);
		root.right.left.left  = new BinaryTree(19);
		
		return root ; 
	}
	
	
	
	public static BinaryTree createFiveLevelBinaryTree() {
		
		BinaryTree root = new BinaryTree(5); 
		root.left  = new BinaryTree(7); 
		root.right = new BinaryTree(8); 
		root.left.left   = new BinaryTree(9); 
		root.left.right  = new BinaryTree(10); 
		root.right.left  = new BinaryTree(11); 
		root.right.left.right = new BinaryTree(20);
		root.right.left.left  = new BinaryTree(19);
		root.right.left.left.right = new BinaryTree(50); 
		root.right.right = new BinaryTree(12); 
		root.left.left.left = new BinaryTree(13); 	
		root.left.left.right = new BinaryTree(14); 	
		root.left.left.right.left = new BinaryTree(37); 
		root.left.left.right.left.right = new BinaryTree(87); 
		
		return root ; 
	}
	
	
	
	public static BinaryTree createSkewedBinarySearchTree(){
		
		BinaryTree root = new BinaryTree(7); 
		root.left  = new BinaryTree(6); 
		root.left.left = new BinaryTree(5); 
		root.left.left.left = new BinaryTree(3); 
		root.left.left.left.left = new BinaryTree(2); 
		
		return root ; 
	}
	
	
	
	
	
	
	//@Test 
	public static void testFindMaxBst(){
		
		int margin = 5 ; 
		PrintStream out = System.out ; 
		BinaryTree tree ; 
		
//		BinaryTree tree = createTwoLevelBinaryTree(); 	
//		tree = createThreeLevelBinaryTree(); 		
//		tree = createThreeLevelBinaryTree(); 		
		tree = createFourLevelBinaryTree(); 
		
		out.println("Current binary tree:");
		tree.prettyPrint(margin, System.out);
		out.println("Tree Size = " + tree.size());
		out.println("Is Bst ? = " + tree.isBinarySearchTree());  
		
		
		BinaryTree maxBst = BinaryTree.findMaxBst(tree); 
		out.println("The maximum binary tree: ");
		if(maxBst != null)
			maxBst.prettyPrint(margin, out);
		else 
			out.println("Max bst not found"); 
		
		BinaryTree maxBstSubtree = BinaryTree.findMaxBstSubtreeTopDown(tree); 
		out.println("The maximum binary tree subtree (Top down):");
		if(maxBstSubtree != null)
			maxBstSubtree.prettyPrint(margin, out);
		else 
			out.println("Max bst subtree not found"); 
		
	    maxBstSubtree = BinaryTree.findMaxBstSubtreeBottomUp(tree); 
		out.println("The maximum binary tree subtree (Bottom up):");
		if(maxBstSubtree != null)
			maxBstSubtree.prettyPrint(margin, out);
		else 
			out.println("Max bst subtree not found"); 
	}
	
	
	
	
	
	//@Test 
	public void testPrintTreeBoundaryView(){
		
		int margin = 5 ;  
		BinaryTree tree = createFiveLevelBinaryTree(); 
		tree.prettyPrint(margin, System.out); 
		
		BinaryTree.printLeftView(tree); 
		BinaryTree.printRightView(tree);
		BinaryTree.printRightViewBottomUp(tree); 
	}
	
	
	
	
	
	@Test
	public void testPreOrderTreeTraversal(){
		
		BinaryTree tree = createTwoLevelBinaryTree(); 
		String recursivePostString = BinaryTree.preOrderTraversalRecursive(tree);  
		String iterativePostString = BinaryTree.preOrderTraversalIterative(tree); 
		assertEquals(recursivePostString, iterativePostString); 
		
		tree = createThreeLevelBinaryTree();  
		recursivePostString = BinaryTree.preOrderTraversalRecursive(tree);  
		iterativePostString = BinaryTree.preOrderTraversalIterative(tree); 
		assertEquals(recursivePostString, iterativePostString); 
		
		tree = createFourLevelBinaryTree(); 
		recursivePostString = BinaryTree.preOrderTraversalRecursive(tree);  
		iterativePostString = BinaryTree.preOrderTraversalIterative(tree); 
		assertEquals(recursivePostString, iterativePostString); 
		
		tree = createFiveLevelBinaryTree(); 
		recursivePostString = BinaryTree.preOrderTraversalRecursive(tree);  
		iterativePostString = BinaryTree.preOrderTraversalIterative(tree); 
		assertEquals(recursivePostString, iterativePostString); 
	}
	
	
	
	
	
	@Test
	public void testInOrderTreeTraversal(){
		
		BinaryTree tree = createTwoLevelBinaryTree(); 
		String recursivePostString = BinaryTree.inOrderTraversalRecursive(tree);  
		String iterativePostString = BinaryTree.inOrderTraversalIterative(tree); 
		assertEquals(recursivePostString, iterativePostString); 
		
		tree = createThreeLevelBinaryTree();  
		recursivePostString = BinaryTree.inOrderTraversalRecursive(tree);  
		iterativePostString = BinaryTree.inOrderTraversalIterative(tree); 
		assertEquals(recursivePostString, iterativePostString); 
		
		tree = createFourLevelBinaryTree(); 
		recursivePostString = BinaryTree.inOrderTraversalRecursive(tree);  
		iterativePostString = BinaryTree.inOrderTraversalIterative(tree); 
		assertEquals(recursivePostString, iterativePostString); 
		
		tree = createFiveLevelBinaryTree(); 
		recursivePostString = BinaryTree.inOrderTraversalRecursive(tree);  
		iterativePostString = BinaryTree.inOrderTraversalIterative(tree); 
		assertEquals(recursivePostString, iterativePostString); 
	}
	
	
	@Test
	public void testPostOrderTreeTraversal(){
		
		BinaryTree tree = createTwoLevelBinaryTree(); 
		String recursivePostString = BinaryTree.postOrderTraversalRecursive(tree);  
		String iterativePostString = BinaryTree.postOrderTraversalIterative(tree); 
		assertEquals(recursivePostString, iterativePostString); 
				
		tree = createThreeLevelBinaryTree(); 
		recursivePostString = BinaryTree.postOrderTraversalRecursive(tree);  
		iterativePostString = BinaryTree.postOrderTraversalIterative(tree); 
		assertEquals(recursivePostString, iterativePostString); 
		
		
		tree = createFourLevelBinaryTree(); 
		recursivePostString = BinaryTree.postOrderTraversalRecursive(tree);  
		iterativePostString = BinaryTree.postOrderTraversalIterative(tree); 
		assertEquals(recursivePostString, iterativePostString); 
		
		
		tree = createFiveLevelBinaryTree(); 
		recursivePostString = BinaryTree.postOrderTraversalRecursive(tree);  
		iterativePostString = BinaryTree.postOrderTraversalIterative(tree); 
		assertEquals(recursivePostString, iterativePostString); 
	}
	
	
	
	
	


	
	
	
	
	@Test 
	public void testBinarySearchTreeSerialisation4BalancedBST(){
		
		BinaryTree savedBst = createBalancedBinarySearchTree(); 
		String bstFilePath = "BalancedBST" ; 
		BinaryTree.serializeBinarySearchTree(savedBst, bstFilePath); 
		BinaryTree loadedBst = BinaryTree.deserializeBinarySearchTree(bstFilePath); 
		
		boolean isEqual = isSameBinaryTree(savedBst, loadedBst);
		assertTrue(isEqual); 
	}
	
	
	
	
	@Test 
	public void testBinarySearchTreeSerialisation4SkewedBST(){
		
		BinaryTree savedBst = createSkewedBinarySearchTree(); 
		String bstFilePath = "SkewedBst" ; 
		BinaryTree.serializeBinarySearchTree(savedBst, bstFilePath); 
		BinaryTree loadedBst = BinaryTree.deserializeBinarySearchTree(bstFilePath); 
		
		boolean isEqual = isSameBinaryTree(savedBst, loadedBst);
		assertTrue(isEqual); 
	}
	
	
	
	@Test 
	public void testBinarySearchTreeSerialisation4NullBST(){
		
		BinaryTree savedBst = null ; 
		String bstFilePath = "NullBst" ; 
		BinaryTree.serializeBinarySearchTree(savedBst, bstFilePath); 
		BinaryTree loadedBst = BinaryTree.deserializeBinarySearchTree(bstFilePath); 
		
		boolean isEqual = isSameBinaryTree(savedBst, loadedBst);
		assertTrue(isEqual); 
	}
	
	
	
	@Test 
	public void testBinaryTreeSerialisationNULLTree(){
		
		String filePath = "NullTree" ; 
		BinaryTree savedTree = null ; 
		BinaryTree.serializeBinaryTree(savedTree, filePath); 
		BinaryTree loadedTree = BinaryTree.deserializeBinaryTree(filePath); 
		
		boolean isEqual = isSameBinaryTree(savedTree, loadedTree);
		assertTrue(isEqual); 
	}
	
	
	
	
	@Test 
	public void testBinaryTreeSerialisationTwoLevelBinaryTree(){
		
		String filePath = "TwoLevelBinaryTree" ; 
		BinaryTree savedTree = createTwoLevelBinaryTree() ; 
		BinaryTree.serializeBinaryTree(savedTree, filePath); 
		BinaryTree loadedTree = BinaryTree.deserializeBinaryTree(filePath); 
		
		boolean isEqual = isSameBinaryTree(savedTree, loadedTree);
		assertTrue(isEqual); 
	}
	
	
	
	@Test 
	public void testBinaryTreeSerialisationTreeThreeLevelBinaryTree(){
		
		String filePath = "ThreeLevelBinaryTree" ; 
		BinaryTree savedTree = createThreeLevelBinaryTree() ; 
		BinaryTree.serializeBinaryTree(savedTree, filePath); 
		BinaryTree loadedTree = BinaryTree.deserializeBinaryTree(filePath); 
		
		boolean isEqual = isSameBinaryTree(savedTree, loadedTree);
		assertTrue(isEqual); 
	}
	

	
	
	
	@Test 
	public void testTreeMaxHeight(){
		
		BinaryTree tree = createTwoLevelBinaryTree();  
		int expected = BinaryTree.maxHeightRecursive(tree); 
		int actual   = BinaryTree.maxHeightRecursive(tree); 
		assertEquals(expected, actual); 
		
		
		tree = createThreeLevelBinaryTree();  
		expected = BinaryTree.maxHeightRecursive(tree); 
		actual   = BinaryTree.maxHeightRecursive(tree); 
		assertEquals(expected, actual);  
		
		
		tree = createFourLevelBinaryTree();  
		expected = BinaryTree.maxHeightRecursive(tree); 
		actual   = BinaryTree.maxHeightRecursive(tree); 
		assertEquals(expected, actual);   
		
		
		tree = createFiveLevelBinaryTree();  
		expected = BinaryTree.maxHeightRecursive(tree); 
		actual   = BinaryTree.maxHeightRecursive(tree); 
		assertEquals(expected, actual);   
	}

	
	
	
	@Test
	public void testRecursivePopulateNextRights(){
		
		BinaryTree tree = createTwoLevelBinaryTree();  
		BinaryTree.recursivePopulateNextRights(tree);
		String actualTraversal   = retrieveNextRightString(tree); 
		String expectedTraversal = "5;7;"; 
		assertEquals(actualTraversal, expectedTraversal);  

		
		tree = createThreeLevelBinaryTree();   
		BinaryTree.recursivePopulateNextRights(tree); 
		actualTraversal   = retrieveNextRightString(tree); 
		expectedTraversal = "10;5 15;1 8 17;"; 
		assertEquals(actualTraversal, expectedTraversal); 
		
		
		tree = createFourLevelBinaryTree();  
		BinaryTree.recursivePopulateNextRights(tree); 
		actualTraversal   = retrieveNextRightString(tree); 
		expectedTraversal = "5;3 25;2 4 11;19 20;"; 
		assertEquals(actualTraversal, expectedTraversal); 		
		
		
		tree = createFiveLevelBinaryTree();  
		BinaryTree.recursivePopulateNextRights(tree); 
		actualTraversal   = retrieveNextRightString(tree); 
		tree.prettyPrint(3, System.out);
		expectedTraversal = "5;7 8;9 10 11 12;13 14 19 20;37 50;87;"; 
		assertEquals(actualTraversal, expectedTraversal); 
		
		
	}
	
	
	
	protected String retrieveNextRightString(BinaryTree tree){
		
		StringBuilder builder = new StringBuilder(); 
		BinaryTree currRoot=tree, nextRoot=null ; 
		
		while(currRoot!=null){
			
			BinaryTree nextRight = currRoot ; 
			
			// horizontal scan 
			while(nextRight!=null){
				builder.append(nextRight.value + (nextRight.nextRight==null?";":" "));  
				if(nextRoot==null){
					if(nextRight.left!=null)
						nextRoot = nextRight.left;
					else if(nextRight.right!=null)
						nextRoot = nextRight.right ; 
				}
				nextRight = nextRight.nextRight;
			}		
			
			// initialize for next level 
			currRoot = nextRoot ; 
			nextRoot = null ; 
		}
		return builder.toString();
	}
	
	
	
	
	
	
}
