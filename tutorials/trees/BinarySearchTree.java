package tutorials.trees;

import java.io.PrintStream;

public class BinarySearchTree {

	private BinarySearchTreeNode root; 
	
	public BinarySearchTree(int value){
		root = new BinarySearchTreeNode(value, null); 
	}
	
	
	public void insert(int value){
		BinarySearchTreeNode.insert(value, root); 
	}
	
	
	public BinarySearchTreeNode search(int value){
		return BinarySearchTreeNode.search(value, root); 
	}
	
	
	public void prettyPrint(int margin, PrintStream stream){
		if(root!=null)
			root.prettyPrint(margin, stream);
		else
			stream.println("NULL");
	}
	
	
	//////////////////////////////////////////////////////////////
	/// Delete in Binary Search Tree 
	//////////////////////////////////////////////////////////////
		
	/**
	 *  Replaces one subtree as a child of its parent with another subtree.
	 *  This method only updates the parent-child link 
	 *   
	 *  (1) u's parent becomes v's parent 
	 *  (2) u's parent ends up having v as an appropriate child 
	 * 
	 * @param u - a BinarySearchTree subtree in the current bst 
	 * @param v - a BinarySearchTree subtree in the current bst 
	 */
	protected void transplant(BinarySearchTreeNode u, BinarySearchTreeNode v){
		
		if(u==null) // undefined 
			return; 
		
		// set the child link for the parent 
		if(u.parent==null){     
			root = v; 
		}else if( u==u.parent.left)
			u.parent.left =v; 
		else 
			u.parent.right=v; 
		
		// set the parent link for the child 
		if(v!=null)
			v.parent = u.parent; 
	}
	
	
	
	/**
	 *  Delete a node in the binary search tree 
	 *  
	 *  The key is to fill in the blank with the successor of the 
	 *  node to be deleted 
	 * 
	 * @param node
	 */
	public void delete(BinarySearchTreeNode node){
	
		if(node.left()==null){
			transplant(node, node.right()); 
		}else if (node.right()==null){
			transplant(node, node.left());
		}else{
			
			// the successor is actually node.right.min(). Note it does not 
			// have a left child 
			BinarySearchTreeNode successor = node.successor(); 
			if(successor.parent() != node){ // update the successor's right child 
				                            // the reason for the checking is that the 'successor' 
				                            // will be the parent for node.right. 
				transplant(successor, successor.right());
				successor.setRight(node.right()); 
				successor.right().setParent(successor); 
			}
			
			// update node.left() to be successor's left() 
			transplant(node, successor); 
			successor.setLeft(node.left()); 
			successor.left().setParent(successor); 
		}

	}
	
}
