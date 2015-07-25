package tutorials.trees;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

import tutorials.utils._;

/**
 *  The binary tree definition 
 * 
 * @author Endeavour
 *
 */

public class BinaryTree {
	
	public int value ; 
	public BinaryTree left, right ; 
	public BinaryTree nextRight ;  // defined as the next node in the same level 
	
	protected static String nodeSeparator = " " ; 
	protected static int fieldWidth 	  = 6 ; 
	protected static int leafNodeDistance = 6 ; 

	public BinaryTree(int value){
		this.value = value ; 
		this.left  = null ; 
		this.right = null ; 
	}
		
	public int size(){

		// the base case 
		if( left == null && right == null)
			return 1; 
		
		if( left == null)
			return 1 + right.size(); 
		if( right == null)
			return 1 + left.size(); 
		return 1 + left.size() + right.size(); 
	}
	
	
	
	public boolean isBinarySearchTree(){
			
		return isBinarySearchTree(Integer.MIN_VALUE, Integer.MAX_VALUE); 
	}
	
	
	protected boolean isBinarySearchTree(Integer min, Integer max){
		
		if( value < min || value > max)
			return false; 
	
		boolean isLeftBST = true ; 
		if( left != null ) 
			isLeftBST = left.isBinarySearchTree(min, value); 
		
		boolean isRightBST = true; 
		if( right != null)
			isRightBST = right.isBinarySearchTree(value, max); 
		
		if(isLeftBST && isRightBST)
			return true; 
		else 
			return false ; 
	}
	
	
	public void printInLevelOrder(){
				
		Deque<BinaryTree> nodesInCurrentLevel = new LinkedList<BinaryTree>();  
		Deque<BinaryTree> nodesInNextLevel    = new LinkedList<BinaryTree>();   
		
		nodesInCurrentLevel.add(this);  
		
		while(!nodesInCurrentLevel.isEmpty() )
		{
			BinaryTree node = nodesInCurrentLevel.removeLast(); 
			System.out.print(node.value + " "); 
			if(node.left!=null)
				nodesInNextLevel.addFirst(node.left); 
			if(node.right!=null)
				nodesInNextLevel.addFirst(node.right); 
			
			if( nodesInCurrentLevel.isEmpty())
			{
				Deque<BinaryTree> tmp = nodesInCurrentLevel ; 
				nodesInCurrentLevel = nodesInNextLevel ; 
				nodesInNextLevel    = tmp;
				System.out.println();   
			}
		}
	}
	
	
	public int getHeight(){
		
		if( left==null && right == null )
			return 0; 
		
		int height = 0; 
		if( left != null )
			height = Math.max(height, 1+left.getHeight()); 
		
		if( right!= null) 
			height = Math.max(height, 1+right.getHeight()); 
		
		return height ; 
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////// 
	//// Printing Trees 
	////////////////////////////////////////////////////////////////////////////////////////  
	
	public void prettyPrint(int margin, PrintStream outStream){
		
		int height = getHeight(); 
		int nodeWidth = (int) Math.pow(2, height) * fieldWidth ; 
		int nodeDistance = nodeWidth ; 
		int leadingSpaceLength 	= margin + (int)( (Math.pow(2, height)-1) *fieldWidth/2.0f) ; 
		int sideBarLength = (nodeWidth - fieldWidth) /2;  
		
		// print the root node 
		ArrayList<BinaryTree> nodesAtCurrentLevel = new ArrayList<BinaryTree>(); 
		nodesAtCurrentLevel.add(this); 
		ArrayList<BinaryTree> nodesAtNextLevel = 
				printInternalNodes(leadingSpaceLength, sideBarLength, nodeDistance, 
						nodesAtCurrentLevel, outStream);  
		printBranches(leadingSpaceLength, nodeWidth,  nodeDistance, nodesAtNextLevel, outStream );
		
		for(int i=1; i<height; i++)
		{
			nodesAtCurrentLevel = nodesAtNextLevel ; 
			
			nodeWidth     = (int) (nodeWidth/2.0f) ; 
			nodeDistance  = nodeWidth ; 
			sideBarLength = (int) ( (nodeWidth - fieldWidth) /2.0f) ; 
			leadingSpaceLength -= nodeWidth/2;  
			
			nodesAtNextLevel =  printInternalNodes(leadingSpaceLength, sideBarLength, 
					nodeDistance, nodesAtCurrentLevel, outStream); 
			printBranches(leadingSpaceLength, nodeWidth,  nodeDistance, nodesAtNextLevel, outStream ); 	
		}
		
		printLeafNodes(margin, nodesAtNextLevel,  outStream);
		outStream.println();
	}
	
	

	protected ArrayList<BinaryTree> printInternalNodes(int leadingSpaceLength, int sideBarLength, 
			int nodeDistance, ArrayList<BinaryTree> nodes, PrintStream outStream )
	{
		ArrayList<BinaryTree> nodesAtNextLevel = new ArrayList<BinaryTree>();   
		
		for(int i=0; i<leadingSpaceLength; i++) 
			outStream.print(' ');  
		
		for(BinaryTree node : nodes)
		{ 
			if( node == null){ 
				for(int i=0; i<nodeDistance; i++)
					System.out.print(' '); 
				nodesAtNextLevel.add(null); 
				nodesAtNextLevel.add(null);  
				
			}else{ 
				
				// print the L.H.S 
				if(node.left != null) 
				{
					outStream.print('+'); 
					for(int i=1; i<sideBarLength; i++)
						outStream.print('-');
				}else{
					for(int i=0; i<sideBarLength; i++)
						outStream.print(' '); 
				}
					
				// print the Value 
				String field = center( String.valueOf(node.value), fieldWidth, " "); 
				outStream.print(field); 
	
				// print the R.H.S 
				if(node.right != null) 
				{
					for(int i=1; i<sideBarLength; i++)
						outStream.print('-');
					outStream.print('+');  
				}else{
					for(int i=0; i<sideBarLength; i++)
						outStream.print(' '); 
				}
				
				nodesAtNextLevel.add(node.left); 
				nodesAtNextLevel.add(node.right);  
			}
			
			for(int j=0; j<nodeDistance; j++) 
				outStream.print(' '); 

		} 
		outStream.println(); 
		return nodesAtNextLevel;
	}
	
	
	
	protected void printBranches(int leadingSpaceLength, int nodeWidth, 
			int nodeDistance, ArrayList<BinaryTree> nodes,  PrintStream outStream )
	{
		// print the leading space 
		for(int i=0; i<leadingSpaceLength; i++) 
			outStream.print(' '); 
		
		int nodeIndex =  0; 
		for(BinaryTree node: nodes)
		{
			if( node == null )
				outStream.print(' '); 
			else 
				outStream.print('|'); 
			
			//print the internal space 
			int distance = ( nodeIndex % 2 ==0)? nodeWidth-2:nodeDistance ;  
			nodeIndex++; 
			
			for(int j=0; j<distance; j++)  
				outStream.print(' '); 
		}
		outStream.println(); 
	}
	
	

	protected void printLeafNodes(int margin, ArrayList<BinaryTree> nodes,  PrintStream outStream )
	{
		for(int i=0; i<margin; i++) 
			outStream.print(' '); 
		
		for(BinaryTree node: nodes)
		{ 
			if( node == null ){
				for(int i=0; i<fieldWidth; i++)
					outStream.print(' '); 
			}else {		
				String nodeStr = center( String.valueOf(node.value), fieldWidth, " "); 
				outStream.print( nodeStr); 
			}
			for(int i=0; i<leafNodeDistance; i++)
				outStream.print(' '); 	
		} 
	}
	

	protected String center(String str, int paddingLength, String padStr) {
	    
		if (str.length() > paddingLength) {
	        return str.substring(0, paddingLength);
	    } else if (str.length() == paddingLength) {
	        return str;
	    } else {
	        int leftPadding = (paddingLength - str.length()) / 2; 
	        StringBuilder leftBuilder = new StringBuilder();
	        for (int i = 0; i < leftPadding; i++) {
	            leftBuilder.append(padStr);
	        }

	        int rightPadding = paddingLength - str.length() - leftPadding;
	        StringBuilder rightBuilder = new StringBuilder();
	        for (int i = 0; i < rightPadding; i++) 
	            rightBuilder.append(padStr);

	        return leftBuilder.toString() + str 
	                + rightBuilder.toString();
	    }
	}
	

	//////////////////////////////////////////////////////////////////////////////////////// 
	//// Search for Max Binary Search Tree 
	////  http://leetcode.com/2010/11/largest-binary-search-tree-bst-in_22.html 
	////  http://leetcode.com/2010/11/largest-binary-search-tree-bst-in.html 
	////
	////////////////////////////////////////////////////////////////////////////////////////  
	
	public static BinaryTree findMaxBstSubtreeTopDown(BinaryTree tree)
	{
		if( tree == null )
			return null ; 
		
		if( tree.isBinarySearchTree())
			return tree ; 
		
		BinaryTree leftMaxBst  = findMaxBstSubtreeTopDown(tree.left); 
		BinaryTree rightMaxBst = findMaxBstSubtreeTopDown(tree.right); 
		
		if( leftMaxBst == null )
			return rightMaxBst ; 
		if( rightMaxBst == null)
			return leftMaxBst ; 
		
		int leftSize  = leftMaxBst.size(); 
		int rightSize = rightMaxBst.size(); 
			
		return leftSize > rightSize ? leftMaxBst: rightMaxBst ; 
	}
	
	
	public static BinaryTree findMaxBstSubtreeBottomUp(BinaryTree tree)
	{
		_<Integer> min = new _<Integer>(0) ; 
		_<Integer> max = new _<Integer>(0) ; 
		
		_<BinaryTree> maxBst = new _<BinaryTree>(null) ;  
		_<Integer> maxBstSize = new _<Integer>(0); 
		
		findMaxBstSubtreeBottomUp(tree, min, max, maxBst, maxBstSize); 
		return maxBst.value() ; 
	}
		

	/**
	 * 
	 * Return -1 if no BST is found 
	 *  
	 * @param tree the current binary search tree 
	 * @param min - the minimum value found in the current binary tree 
	 * @param max - the maximum value found in the current binary tree
	 * @param maxBst - the maximum binary tree found 
	 * @param maxBstSize - the size of the maximum binary tree 
	 * @return the size of binary tree found under current subtree. Return -1 if no binary tree is found 
	 * 
	 * @NOTE: the values of min and max are passed from the callee as it is a bottom-up method. On 
	 * 		  the other hand, there is no need to pass any values back from the callee in a top-down method. 
	 */ 
	protected static int findMaxBstSubtreeBottomUp(BinaryTree tree, _<Integer> min, _<Integer> max, 
											_<BinaryTree> maxBst, _<Integer> maxBstSize){
		// base case 
		if( tree == null){	
			return 0; 
		}
		
		boolean isBST = true ; 
		
		// check the left subtree first 
		int leftMaxBstSize = findMaxBstSubtreeBottomUp(tree.left, min, max, maxBst, maxBstSize); 
		int currMin = (leftMaxBstSize ==  0)? tree.value : min.value() ; 
		if( leftMaxBstSize == -1 || ( leftMaxBstSize!=0 && tree.value < max.value()))
			isBST = false; 
				
		// then check the right subtree				
		int rightMaxBstSize = findMaxBstSubtreeBottomUp(tree.right, min, max, maxBst, maxBstSize); 
		int currMax = (rightMaxBstSize == 0)? tree.value : min.value(); 
		if( rightMaxBstSize == -1 || ( rightMaxBstSize!=0 && tree.value > min.value()))
			isBST = false; 
		
		if( isBST ){ 

			min.set(currMin); 
			max.set(currMax);
			int currBstSize = 1 + leftMaxBstSize + rightMaxBstSize ; 
			if( currBstSize > maxBstSize.value()) // update the "global" variable 
			{ 
				maxBstSize.set( currBstSize ); 
				maxBst.set( tree ) ; 
			}
			return currBstSize ; 
		}else 
			return -1; 		
	}
			
	
	public static BinaryTree findMaxBst(BinaryTree tree)
	{
		_<BinaryTree> maxBst  = new _<BinaryTree>(); 
		_<BinaryTree> childBst = new _<BinaryTree>();  
		_<Integer> maxBstSize  = new _<Integer>(0); 		
		
		findMaxBst(tree, Integer.MIN_VALUE, Integer.MAX_VALUE, maxBst, maxBstSize, childBst); 
		
		return maxBst.value(); 	
	}
	
	
	/**
	 * Search the maximum binary subtree in a given binary tree 
	 * 
	 * @param tree  - the given binary tree 
	 * @param min   - the minimum value passed from by caller 
	 * @param max   - the maximum value passed from by caller 
	 * @param maxBst  - the discovered maximum binary search tree
	 * @param maxBstSize  - the size of the maximum binary search tree 
	 * @param childBst - the maximum bst found under the subtree rooted at current tree
	 * @return the total number of nodes in the 'child' tree 
	 */ 
	protected static int findMaxBst(BinaryTree tree, int min, int max, 
			_<BinaryTree> maxBst, _<Integer> maxBstSize, _<BinaryTree> childBst)
	{
		// base case 
		if( tree == null ){
			childBst.set(null); 
			return 0;
		}
		
		if( tree.value > min && tree.value < max){
			
			_<BinaryTree> maxLeftBst  = new _<BinaryTree>() ; 
			_<BinaryTree> maxRightBst = new _<BinaryTree>() ; 
			int maxLeftBstSize = 0, maxRightBstSize = 0 , bstSize; 
			
			maxLeftBstSize  = findMaxBst(tree.left,  min, tree.value, maxBst, maxBstSize, maxLeftBst);  
			maxRightBstSize = findMaxBst(tree.right, tree.value, max, maxBst, maxBstSize, maxRightBst); 
			
			BinaryTree bst = new BinaryTree(tree.value); 
			bst.left  = maxLeftBstSize  ==0? null : maxLeftBst.value() ; 
			bst.right = maxRightBstSize ==0? null : maxRightBst.value() ; 
			bstSize = maxLeftBstSize + maxRightBstSize + 1; 
			childBst.set(bst) ; 
			
			if( bstSize > maxBstSize.value()){
				
				maxBst.set(childBst.value()) ; 
				maxBstSize.set(bstSize) ; 
			}
			return bstSize ; 
			
		}else{
			findMaxBst(tree,  Integer.MIN_VALUE, Integer.MAX_VALUE, maxBst, maxBstSize, childBst);  
			return 0; 
		}		
	}
			
	
	//////////////////////////////////////////////////////////////////////////////////////// 
	//// Print left and right view 
	////////////////////////////////////////////////////////////////////////////////////////  
	/** 
	 * The left view contains all nodes that are first nodes in their levels. 
	 */
	public static void printLeftView(BinaryTree tree){
		
		int level = 1 ;
		_<Integer> maxLevel = new _<Integer>(0); 
		
		System.out.println("Left View: "); 
		printLeftView(tree, level, maxLevel); 
		System.out.println(); 
	}
	
	
	protected static void printLeftView(BinaryTree  tree, int level, _<Integer> maxLevel){
		
		if( tree == null) // base case  
			return ; 
		                               
		if( level > maxLevel.value()){
			System.out.print(tree.value + " ");
			maxLevel.set(level); 
		}
		
		printLeftView(tree.left,  level+1, maxLevel); 
		printLeftView(tree.right, level+1, maxLevel); 
	} 
	

	
	/** 
	 * The right view contains all nodes that are last nodes in their levels. 
	 */	
	public static void printRightView(BinaryTree tree){
		
		int level = 1 ;
		_<Integer> maxLevel = new _<Integer>(0); 
		
		System.out.println("Right View: "); 
		printRightView(tree, level, maxLevel); 
		System.out.println();  
	}
	

	protected static void printRightView(BinaryTree  tree, int level, _<Integer> maxLevel){
		
		if( tree == null) // base case  
			return ; 
		                               
		if( level > maxLevel.value()){
			System.out.print(tree.value + " ");
			maxLevel.set(level); 
		}
		
		printRightView(tree.right, level+1, maxLevel);  
		printRightView(tree.left,  level+1, maxLevel); 
	} 
	
	
	public static void printRightViewBottomUp(BinaryTree tree){	
		
		System.out.println("Right View (bottom up)"); 
		printRightViewBottomUp(tree,  true);
		System.out.println();
	}
	
	
	
	
	protected static void printRightViewBottomUp(BinaryTree tree, boolean print ){
		
		 if (tree==null) 
			 return;
		  
		 printRightViewBottomUp(tree.left, (print && tree.right==null ? true : false)); 
		 printRightViewBottomUp(tree.right, print); 
		 
		 //if (print || (tree.left == null && tree.right == null))
		 if( print )
			 System.out.print(tree.value + " "); 
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////// 
	//// Maximum height 
	//////////////////////////////////////////////////////////////////////////////////////// 

	/**
	 * 
	 * The maximum height of a binary tree is defined as the number of nodes along the 
	 * path from the root node to the deepest leaf node. Note that the maximum height 
	 * of an empty tree is 0. 
	 * 	  
	 * @param tree
	 * @return
	 */
	public static int maxHeightRecursive(BinaryTree tree){
		
		if(tree==null)
			return 0; 
		return Math.max( maxHeightRecursive(tree.left), maxHeightRecursive(tree.right) ) + 1; 
	}
	
	
	
	/**
	 *  This iterative solution is based on post order tree traversal 
	 * 
	 * @param tree
	 * @return
	 */
	public static int maxHeightIterative(BinaryTree tree){
		
		if(tree==null)
			return 0; 
				
		int height =  0; 
		int maxHeight = Integer.MIN_VALUE ;  
		
		BinaryTree prev = null ;  
		
		Stack<BinaryTree> stack = new Stack<BinaryTree>(); 
		stack.push(tree);  
		while(!stack.isEmpty()){
			
			BinaryTree curr = stack.pop(); 
	
			if(prev==null || curr == prev.left || curr == prev.right ){
				// we are traversing downwards 
				if( curr.left!=null){
					stack.push(curr); 
					height ++; 
				}else{
					if(curr.right!=null){
						stack.push(curr); 
						height ++ ; 
					}else{
						// now we have reached one leaf node, since 
						// both 'left' and 'right' are null 
						maxHeight = Math.max(maxHeight, height); 
					}
				}
			}else{
				// we are traversing upwards 
				if( prev == curr.left ){
					// we have finished the left tree 
					height -- ; 
					if(curr.right!=null){
						stack.push(curr.right);
						height ++; 
					}else{
						stack.pop(); 
					}
				}else if ( prev == curr.right){
					// we have finished the right tree
					height -- ; 
					stack.pop(); 
				}
			} 
			prev = curr ; 
		}

		return maxHeight ; 
	}
	
	////////////////////////////////////////////////////////////////////////////////////////
	///////////////  Tree Traversals 
	//////////////////////////////////////////////////////////////////////////////////////// 
	
	public static String preOrderTraversalRecursive(BinaryTree tree){
		
		if( tree == null)
			return null ; 
		
		String leftTreeString  = preOrderTraversalRecursive(tree.left); 
		String currNodeStr = String.valueOf(tree.value);  
		String rightTreeString = preOrderTraversalRecursive(tree.right);
		
		StringBuilder stringBuilder = new StringBuilder();
		if( leftTreeString == null && rightTreeString == null) 
			stringBuilder.append(currNodeStr); 
		else if ( leftTreeString == null || rightTreeString == null){
			if( leftTreeString == null)
				stringBuilder.append(currNodeStr + nodeSeparator + rightTreeString); 
			else 
				stringBuilder.append(currNodeStr + nodeSeparator + leftTreeString ); 
		}else{
			stringBuilder.append( currNodeStr + nodeSeparator +  leftTreeString +  
									nodeSeparator +  rightTreeString ); 
		}
		return 	stringBuilder.toString(); 		
	}
	

	public static String inOrderTraversalRecursive(BinaryTree tree){
		
		if( tree == null)
			return null ; 
		
		String leftTreeString  = inOrderTraversalRecursive(tree.left); 
		String currNodeStr = String.valueOf(tree.value);  
		String rightTreeString = inOrderTraversalRecursive(tree.right);
		
		StringBuilder stringBuilder = new StringBuilder();
		if( leftTreeString == null && rightTreeString == null) 
			stringBuilder.append(currNodeStr); 
		else if ( leftTreeString == null || rightTreeString == null){
			if( leftTreeString == null)
				stringBuilder.append(currNodeStr + nodeSeparator + rightTreeString); 
			else 
				stringBuilder.append(leftTreeString + nodeSeparator + currNodeStr); 
		}else{
			stringBuilder.append(leftTreeString + nodeSeparator + currNodeStr 
										+  nodeSeparator  +  rightTreeString  ); 
		}
		return 	stringBuilder.toString(); 		
	}
	
	
	
	public static String postOrderTraversalRecursive(BinaryTree tree){
		
		if( tree == null )
			return null; 
		
		String leftTreeString  = postOrderTraversalRecursive(tree.left); 
		String rightTreeString = postOrderTraversalRecursive(tree.right);
		
		StringBuilder stringBuilder = new StringBuilder(); 
		String currNodeStr = String.valueOf(tree.value); 

		if( leftTreeString == null && rightTreeString == null)
			stringBuilder.append( currNodeStr ); 
		else if ( leftTreeString == null || rightTreeString == null){
			if( leftTreeString == null)
				stringBuilder.append(rightTreeString + nodeSeparator + currNodeStr); 
			else 
				stringBuilder.append(leftTreeString + nodeSeparator + currNodeStr); 
		}else{
			stringBuilder.append(leftTreeString + nodeSeparator + rightTreeString 
					+ nodeSeparator + currNodeStr); 
		}
		return 	stringBuilder.toString(); 
	}
	
	
	
	
	public static String preOrderTraversalIterative(BinaryTree root){
		
		Stack<BinaryTree> stack = new Stack<BinaryTree>(); 
		stack.push(root); 
		BinaryTree  prev = null ; 
		
		StringBuilder stringBuilder = new StringBuilder();   
		while(!stack.isEmpty()){
			
			BinaryTree curr = stack.peek(); 
			if(prev==null || curr==prev.left || curr==prev.right){ 
				// we are traversing downwards 
				if(stringBuilder.length()== 0) 
					stringBuilder.append(curr.value);
				else 
					stringBuilder.append(nodeSeparator + curr.value); 
				
				if(curr.left!= null) 
					stack.push(curr.left); 
				else{ 
					if(curr.right!=null)        // when traveing downwards, the right kid 
						stack.push(curr.right); // is pushed to the stack only when the 
					else                        // the left kid is null, and right kid is not null 
						stack.pop();
				}
				
			}else{
				// we are traversing upwards 
				if( prev == curr.left){
					// the left node has been processed 
					if( curr.right!=null)
						stack.push(curr.right);
					else 
						stack.pop(); 
				}else if( prev == curr.right){
					// the right node has been processed 
					// we process left, right, then the parent node -> pop it 
					stack.pop(); 
				}
			}
			prev = curr ; 
		}
		
		return stringBuilder.toString(); 
	}
	
	
	
	
	/**
	 *   Similar to the iterative postOrder traversal method, we keep two references, namely 
	 *   "prev" and "curr". Their relationship helps to determine if we are traversing 
	 *    upwards or downwards 
	 * 
	 * @param root
	 * @return
	 */
	public static String inOrderTraversalIterative(BinaryTree root){
		
		Stack<BinaryTree> stack = new Stack<BinaryTree>(); 
		BinaryTree prev = null ; 
		stack.push(root); 
		
		StringBuilder stringBuilder = new StringBuilder();  
		while(!stack.isEmpty()){
			
			BinaryTree curr = stack.peek(); 
			if(prev==null || prev.left==curr || prev.right== curr ){  
				// we are traversing downwards 
				if(curr.left != null){
					stack.push(curr.left) ; 
				}else{
					if(stringBuilder.length()!= 0)
						stringBuilder.append(nodeSeparator + curr.value); 
					else 
						stringBuilder.append(curr.value); 
	
					if(curr.right!=null) 
						stack.push(curr.right); 	
					else 
						stack.pop(); 
				}
			}else{ // we are traversing upwards  
				
				if(curr.left == prev){
					// the left child has been processed 
					if(stringBuilder.length()!= 0)
						stringBuilder.append(nodeSeparator + curr.value);
					else 
						stringBuilder.append(curr.value);
					
					if( curr.right != null)
						stack.push(curr.right); 
					else 
						stack.pop();

				}else if(curr.right == prev){
					// the right child has been processed -> the parent 
					// node should have been processed -> pop it 
					stack.pop(); 
			   }
			}
			prev = curr ;
		}
		return stringBuilder.toString(); 
	}
	
	
	/**
	 * 
	 *  An iterative version of post order traversal 
	 *    
	 *   A stack is used to mimic the behavior of the recursive solution. 
	 *   A "curr" reference points to the element at the top of the stack 
	 *   A "prev" reference points to the previously traversed node. 
	 *   By using the "curr" and "prev" reference, we can infer whether we're traversing up 
	 *   or down the tree. Different cases are handled differently: 
	 *    1) "prev" is the parent of "curr", i.e., prev.left == curr || prev.right == curr 
	 *        we are traversing down the tree, so need to push curr.left to stack if it is not null, 
	 *          otherwise push curr.right to the stack; if both curr.left and curr.right are null, 
	 *          print the value of current node, and pop the stack 
	 *    2) "curr" is the parent of "prev", i.e., curr.left == prev || curr.right == prev 
	 *        we are traversing up the tree, so finish processing curr.left, so we will 
	 *         need to push curr.right to the stack if it is not null, 
	 *         otherwise print the value of current node, and pop the stack  
	 *       
	 * @param root - the root of the binary tree 
	 */
	public static String postOrderTraversalIterative(BinaryTree root){
	
		Stack<BinaryTree> stack  = new Stack<BinaryTree>(); 
		StringBuilder stringBuilder = new StringBuilder(); 
		
		BinaryTree prev = null ; 
		stack.push(root); 
		
		while(!stack.isEmpty()){
			
			BinaryTree curr = stack.peek(); 
			
			// "prev" is the parent of "curr" : we are traversing down the tree 
			if( prev == null || prev.left == curr || prev.right == curr ){
				if( curr.left != null )
					stack.push( curr.left); 
				else if ( curr.right != null)
					stack.push( curr.right); 
				else{ 
					if(stringBuilder.length()!= 0)
						stringBuilder.append(nodeSeparator + curr.value);
					else 
						stringBuilder.append(curr.value);
					stack.pop(); // pop the current node only if it has been visited 
				}
			}else{ // "curr" is the parent of "prev": we are traversing up the tree 
			
				if( curr.left == prev ){ // we finish processing the left node  
					if( curr.right!= null) 
						stack.push(curr.right); 
					else{
						if(stringBuilder.length()!= 0)
							stringBuilder.append(nodeSeparator + curr.value);
						else 
							stringBuilder.append(curr.value);
						stack.pop(); 
					}
				}else if( curr.right == prev){ // we finish processing the right kid 
					
					if(stringBuilder.length()!= 0)
						stringBuilder.append(nodeSeparator + curr.value);
					else 
						stringBuilder.append(curr.value);
					stack.pop(); 
				}
			}	
			prev = curr ; 
		}
		return stringBuilder.toString(); 
	}
		
	
	
	
	/**
	 *  In order traversal using threaded tree
	 *   
	 *  The space complexity of this algorithm is O(1) as it utilises 
	 *  the NULL pointers in the tree node 
	 *   
	 *  The essence of this algorithm is to link the node whose right 
	 *  is null to its in order successor. 
	 *  
	 * 
	 * @param root - the root of the binary tree  
	 * @return
	 */
	public static String inOrderTraversalThreadedTree(BinaryTree root){
	
		StringBuilder ret = new StringBuilder();
		BinaryTree curr = root ; 
		
		while(curr!=null){
			
			if(curr.left == null){
				if(ret.length()!= 0)
					ret.append(nodeSeparator + curr.value);
				else 
					ret.append(curr.value);
				curr = curr.right ; 
			}else{
				BinaryTree pred = curr.left ; 
				while(pred.right!=null && pred.right!=curr)
					pred = pred.right; 
				
				if(pred.right==null){  // they are threaded before the traversal of left 
					pred.right = curr ;   
					curr = curr.left; 
				}else{
					pred.right = null; // they are disconnected when finishing the 
									   // traversal of left 
					if(ret.length()!= 0)
						ret.append(nodeSeparator + curr.value);
					else 
						ret.append(curr.value);
					curr = curr.right; 
				}			
			}	
		}
		return ret.toString(); 
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////
	///////////////  Tree Serialization 
	//////////////////////////////////////////////////////////////////////////////////////// 
	public static void serializeBinarySearchTree(BinaryTree bst, String bstFilePath)
	{
		FileOutputStream outStream  ; 
		try{ 
			outStream = new FileOutputStream( new File(bstFilePath) ); 
			
			if(bst == null ){
				outStream.close(); 
				return ; 
			}
			
			serializeBinarySearchTree(bst, outStream); 
			outStream.close(); 
				
		}catch(IOException e){
			e.printStackTrace();
		}			
	}
	

	
	protected static void serializeBinarySearchTree(BinaryTree bst, FileOutputStream outStream)
	{
		if( bst == null)
			return ; 
		
		ByteBuffer buffer = ByteBuffer.allocate(4);
		buffer.putInt(bst.value); 
		try {
			outStream.write(buffer.array());
			serializeBinarySearchTree(bst.left, outStream); 
			serializeBinarySearchTree(bst.right, outStream);
			
		} catch (IOException e) {
			e.printStackTrace();
		} 		
	}
	
	
	
	
	public static BinaryTree deserializeBinarySearchTree(String bstFilePath)
	{
		FileInputStream inStream  ;  
		BinaryTree bst = null ; 
		_<Integer> val = new _<Integer>(); 	
		
		try{  
			
			inStream = new FileInputStream( new File(bstFilePath) );  
			if( readIntValueFromStream(inStream, val) == -1){
				inStream.close(); 
				return null ; 
			}
							
			bst = deserializeBinarySearchTree(inStream, val, Integer.MIN_VALUE, Integer.MAX_VALUE); 
			inStream.close(); 

		}catch (IOException e) {
			e.printStackTrace();
		}
		return bst ; 	
	}
	
	
	
	
	protected static BinaryTree deserializeBinarySearchTree(FileInputStream inStream, 
			_<Integer> insertValue, int minValue, int maxValue){
		
		try {
			
			int value = insertValue.value(); 
			if( value > minValue && value < maxValue ){
				
				BinaryTree tree = new BinaryTree(value);  
				
				if( readIntValueFromStream(inStream, insertValue) == -1){
					inStream.close(); 
					return tree ; 
				}
				
				tree.left  = deserializeBinarySearchTree(inStream,   insertValue,   minValue,     value); 
				tree.right = deserializeBinarySearchTree(inStream,   insertValue,   value,     maxValue); 
				return tree ; 
			}

		} catch (IOException e) {
			e.printStackTrace();
		} 
		return null ; 
	}
	
	
	

	/**
	 *  Read an integer from the given FileInputStream 'inStream' 
	 *  If the stream reaches its end, returns -1; 
	 * 
	 * @param inStream
	 * @param value - the integer value read from the stream 
	 * @return
	 */
	protected static int readIntValueFromStream(FileInputStream inStream, _<Integer> value)
	{		
		int numBytesInInt=4, ret=-1 ;   
		byte[]  buffer = {0,0,0,0};    

		try {
				
			int nBytes = inStream.read(buffer);
			if( nBytes == -1){
				ret = -1;  
			}else {
				ByteBuffer byteBuffer = ByteBuffer.allocate(numBytesInInt);
				for(int i=0; i<numBytesInInt; i++)
					byteBuffer.put(i, buffer[i]);
				value.set(byteBuffer.getInt()); 
				ret = 0; 
			}			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;  
	}
	
	
	
	
	/**
	 *  Serialize a given binary tree, we need a padding "#" to represent the NULL values 
	 * 
	 * @param bst
	 * @param bstFilePath
	 */
     public static void serializeBinaryTree(BinaryTree tree, String filePath){
    	 
		try {
			FileWriter writer = new FileWriter(new File(filePath)); 
			serializeBinaryTree(tree, writer); 
			writer.close(); 
    		  
		} catch (IOException e) {
			e.printStackTrace();
		} 
     }
	
	
     protected static void serializeBinaryTree(BinaryTree tree, FileWriter writer) throws IOException
     {
    	 if(tree == null){
    		 writer.write("# "); 
    	 }else{
    		 writer.write(String.valueOf(tree.value) + " "); 
    		 serializeBinaryTree(tree.left,  writer);
    		 serializeBinaryTree(tree.right, writer); 
    	 }
     }
	
          
     public static BinaryTree deserializeBinaryTree(String filePath){
    	 
    	BinaryTree tree = null ;  
		try {
			
			Scanner scanner = new Scanner(new File(filePath)); 
			tree = deserializeBinaryTree(scanner); 
			scanner.close(); 
			  
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tree; 
     } 
     
    
     public static BinaryTree deserializeBinaryTree(Scanner scanner){
    	 
    	BinaryTree tree = null; 
    	if( scanner.hasNext()){ 
    	
    		String strValue = scanner.next(); 
			if( !strValue.equalsIgnoreCase("#") ){ 
				tree = new BinaryTree( Integer.parseInt(strValue)); 
				tree.left  = deserializeBinaryTree(scanner); 
				tree.right = deserializeBinaryTree(scanner); 
			}
    	} 
		return tree ; 
     }
     
    
     
 	////////////////////////////////////////////////////////////////////////////////////////
 	///////////////  Populating the next right fields 
 	//////////////////////////////////////////////////////////////////////////////////////// 
     
    /**
     *  Problem:  Populating next right pointers in each node  
     *    http://leetcode.com/2010/03/first-on-site-technical-interview.html    
     *    
     *  Observations: 
     *  (1) Most likely this can be implemented recursively, because 
     *      you can identify the linking of nodes as sub-problems.
     *  (2) The main difficulty of this problem is linking rightChild 
     *      with the nextSibling of rightChild.
     *  (3) Each node has no parent pointer. Therefore, there is no way
     *      linking the rightChild with its nextSibling at a level.
     *    
     *  Breadth-First Search(BFS) is natural solution however it requires 
     *  additional memory to store the nodes. 
     *  
     *  KEY IDEA: 
     *   The key to this recursive solution is to use already-populated 
     *   "nextRight" fields 
     *  
     *  NOTES: 
     *   This implementation can definitely work on complete binary trees. The
     *   concept of "nextRight" field is not defined properly in this question
     *   for incomplete binary trees. For example, if one node contains a non-null
     *   left and null right, should the 'left' child connects to the first non-null
     *   node at the same level? 
     *  
     *   For example, 
     *  
     *            + ------- 9 ------ + 
     *       +--- 7 --- +     +----- 10 -----+
     *       8                11             12
     *       
     *   Should 8 be connected to 11?   Current implementation connects them.   
     *       
     * @param root
     */
    public static void recursivePopulateNextRights(BinaryTree root){
    	
    	// handle the exception 
    	if(root==null)
    		return; 
    	
    	// handle the base case 
    	if(root.left == null && root.right==null)
    		return; 
    	
    	// handle the recursion, namely setting the field for both 
    	// the left and right child 
    	if(root.right!=null){
        	if(root.left!=null) // link 'left' with 'right' if 'right' is not null  
        		root.left.nextRight = root.right; 
    		root.right.nextRight = getNextNotNullRightAtTheSameLevel(root.nextRight); 
    	}else{
    		// link 'left' with the first non-null node in the same level  
    		if(root.left!=null){ 
    			root.left.nextRight = getNextNotNullRightAtTheSameLevel(root.nextRight); 
    		}
    	} 	
    	recursivePopulateNextRights(root.left); 
    	recursivePopulateNextRights(root.right); 
    }
     
    
    
    /**
     *  Scan from left to right, at both the parent and child level
     *  The purpose is to find the first non-null child node at the
     *  same level as nextRightParent's left or right 
     * 
     * @param nextRightParent
     * @return
     */
    protected static BinaryTree getNextNotNullRightAtTheSameLevel(BinaryTree nextRightParent){
    	
		BinaryTree nextRightChild=null; 

		while(nextRightParent!=null){
			if(nextRightParent.left!=null){
				nextRightChild = nextRightParent.left; 
				break; 
			}else if (nextRightParent.right!=null){
				nextRightChild = nextRightParent.right;
				break; 
			}
			nextRightParent = nextRightParent.nextRight; 
		} 
		return nextRightChild ; 
    }
    
}