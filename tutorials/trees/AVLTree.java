package tutorials.trees;

import java.io.PrintStream;

public class AVLTree {

	private AVLTreeNode root; 
	
	public AVLTree(){
		root = null; 
	}
	
	public AVLTreeNode getRoot(){
		return root; 
	}
	
	//////////////////////////////////////////////////////////////
	/// Rotating operations 
	///  NOTE: the current node is always the parent node of the pivot 
	/// in the rotation 
	///
	//////////////////////////////////////////////////////////////
	/**
	 *  The meaning of left rotation: the node to be rotated (Node) 
	 *  locates to the left of the pivot node (pivot) 
	 *    
	 *        Node                              Pivot         
	 *       /   \                              /   \ 
	 *      T1  Pivot   left rotate node =>   Node  T3 
	 *           / \                          / \ 
	 *          T2 T3                        T1 T2
	 * 
	 * @param node
	 * @return
	 */
	protected AVLTreeNode rotateLeft(AVLTreeNode node){
		
		AVLTreeNode pivot = node.right() ;
		
		// append pivot.left to node.right
		AVLTreeNode t = pivot.left(); 
		node.setRight(t);
		if(t!=null)
			t.setParent(node); 
		
		// update pivot's parent 
		AVLTreeNode parent = node.parent(); 
		pivot.setParent(parent);
		if(parent==null)
			root = pivot; 
		else if (parent.left() == node)
			parent.setLeft(pivot);
		else 
			parent.setRight(pivot); 
		
		// link node to pivot 
		node.setParent(pivot); 
		pivot.setLeft(node); 
		
		// set the balance field 
		node.setBalance(); 
		pivot.setBalance(); 
		return pivot; 
	}
	
	
	/**
	 *  The meaning of right rotation: the node to be rotated (Node) 
	 *  locates to the right of the pivot node (pivot) 
	 *    
	 *        Node                              Pivot         
	 *       /   \                              /   \ 
	 *    Pivot   T3   right rotate node =>   T1    Node 
	 *    /  \                                      /  \
	 *   T1  T2                                    T2  T3 
	 * 
	 * @param node
	 * @return
	 */
	protected AVLTreeNode rotateRight(AVLTreeNode node){
	
		AVLTreeNode pivot = node.left(); 
		
		// append pivot.right to node.left 
		AVLTreeNode t = pivot.right();
		node.setLeft(t); 
		if(t!=null)
			t.setParent(node); 
		
		// update pivot's parent  
		AVLTreeNode parent = node.parent(); 
		pivot.setParent(parent);
		if(parent==null)
			root = pivot; 
		else if (parent.left() == node)
			parent.setLeft(pivot);
		else 
			parent.setRight(pivot); 
		
		// link node to pivot 
		node.setParent(pivot); 
		pivot.setRight(node); 
		
		// set the balance field 
		node.setBalance(); 
		pivot.setBalance(); 
		return pivot; 
	}
		
	//////////////////////////////////////////////////////////////
	/// Inserting operations 
	//////////////////////////////////////////////////////////////
	/**
	 *  Calculating the "height" of a node. This method considers
	 *  the NULL case 
	 *  
	 * @param node
	 * @return -1 if the node is null 
	 */
	public int height(AVLTreeNode node){
	
		if(node==null)
			return -1; 
		return node.getHeight(); 					
	}
	

	public void insert(int value){
		
		// locate the parent node for the insert 
		AVLTreeNode parent=null, node=root; 
		while(node!=null){
			parent = node; 
			if(value < node.value )
				node = node.left(); 
			else
				node = node.right(); 
		}
		
		// insert into the parent node 
		if(parent!=null){ 
			if(value<parent.value)
				parent.left = new AVLTreeNode(value, parent) ;
			else
				parent.right = new AVLTreeNode(value, parent) ; 		
			recursiveBalance(parent); 
		}else 
			root = new AVLTreeNode(value, null);  
	}
	
	
	public void recursiveBalance(AVLTreeNode node){
		
		node.setBalance(); 
		int balance = node.getBalance(); // right - left 
		if(balance==-2){  // left tree is deeper 
			AVLTreeNode leftGrandChild  = node.left().left();  // they can be null 
			AVLTreeNode rightGrandChild = node.left().right(); 
			if( height(leftGrandChild) >= height(rightGrandChild)){ // left-left case 
				node = rotateRight(node);  
			}else{ // left-right case 
				node.setLeft( rotateLeft(node.left()) ); 
				node = rotateRight(node); 
			}
		}else if(balance==2){ // right tree is deeper 
			AVLTreeNode leftGrandChild  = node.right().left();  // they can be null 
			AVLTreeNode rightGrandChild = node.right().right(); 
			if( height(rightGrandChild) >= height(leftGrandChild)){ // right-right case
				node = rotateLeft(node); 
			}else{ // right-left case 
				node.setRight(rotateRight(node.right())); 
				node = rotateLeft(node); 
			}
		}
		
		if(node.parent()!=null){
			recursiveBalance(node.parent()); 
		}
	}
	
	//////////////////////////////////////////////////////////////
	/// Removing operations 
	//////////////////////////////////////////////////////////////
	
	public void delete(int value){ 
		delete(root, value);
	}
	
	
	protected void delete(AVLTreeNode node, int value){
		
		if(node!=null){
			
			if(node.value < value)
				delete(node.right(), value);
			else if (node.value > value)
				delete(node.left(), value); 
			else{
				deleteNode(node); 
			}
		}
	}
	
	
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
	protected void transplant(AVLTreeNode u, AVLTreeNode v){
		
		if(u==null) // undefined 
			return; 
		
		if(u.parent==null){     
			root = v; 
		}else if( u==u.parent.left)
			u.parent.left =v; 
		else 
			u.parent.right=v; 
		
		if(v!=null)
			v.parent = u.parent; 
	}
	
	/**
	 *  There are three cases: 
	 *   (1) the node is a leaf node. Remove it straight away 
	 *   (2) the node has only one child. Make the pointer to this node point to that child 
	 *   (3) the node has two children. Swap values with the successor of the node ( the minimum 
	 *       value in its right sub tree ), and delete the successor from the right subtree 
	 *   Don't forget to re-balance the tree if necessary 
	 *   
	 *   In this implementation we don't actually remove the given node. Instead we swap 
	 *   its value with that of the replacer
	 * 
	 * @param node - the node to be removed 
	 */
	protected void deleteNode(AVLTreeNode node){
	
		if(node==null)
			return ; 
		
		AVLTreeNode toBeChecked=null;  		
		if(node.left()==null){
			toBeChecked = node.parent(); 
			transplant(node, node.right());
		}else if (node.right()==null){
			toBeChecked = node.parent(); 
			transplant(node, node.left());
		}else{
			AVLTreeNode successor = (AVLTreeNode) node.successor(); 
			toBeChecked = successor.parent(); 
			if(successor.parent() != node){ // update the successor's right child 
				                            // the reason for the checking is that the 'successor' 
				                            // will be the parent for node.right. 
				transplant(successor, successor.right());
				successor.setRight(node.right()); 
				successor.right().setParent(successor); 
			}
			// update the successor's left child 
			transplant(node, successor); 
			successor.setLeft(node.left()); 
			successor.left().setParent(successor); 
		}
		
		if(toBeChecked!=null)
			recursiveBalance(toBeChecked); 
	}

	
//   protected void deleteNode(AVLTreeNode node){
//		// get the node to be removed 
//		AVLTreeNode toBeRemoved=null; 
//		if(node.left()==null || node.right()==null){ // the node has only one child 
//			toBeRemoved = node; 
//		}else{
//			toBeRemoved = (AVLTreeNode) node.successor(); // the successor has only one child 
//			node.value = toBeRemoved.value ; 
//		}
//			
//		// get the child of the node to be removed 
//		AVLTreeNode child=null; 
//		if(toBeRemoved.left()!=null)
//			child = toBeRemoved.left();
//		else 
//			child = toBeRemoved.right(); 
//		
//		// link the "child" with "toBeRemoved"'s parent 
//		if(child!=null)
//			child.setParent(toBeRemoved.parent); 
//		
//		// link "toBeRemoved"'s parent with "child" 
//		if(toBeRemoved.parent()==null)
//			root = child ;
//		else{
//			if( toBeRemoved == toBeRemoved.parent().left()) 
//				toBeRemoved.parent().setLeft(child); 
//			else 
//				toBeRemoved.parent().setRight(child); 
//			recursiveBalance(toBeRemoved.parent()); // balancing must be done till reaching the root 
//		}
//		
//		toBeRemoved=null; 
//	}
	
	
	//////////////////////////////////////////////////////////////
	/// Search operations 
	//////////////////////////////////////////////////////////////
	
	public AVLTreeNode search(int value){
		return (AVLTreeNode) BinarySearchTreeNode.search(value, root); 
	}	
	
	
	public AVLTreeNode floor(int value){
		return (AVLTreeNode) BinarySearchTreeNode.floor(value, root); 
	}
	
	
	public AVLTreeNode ceil(int value){
		return (AVLTreeNode) BinarySearchTreeNode.ceil(value, root); 
	}
	
	//////////////////////////////////////////////////////////////
	/// Displaying operations 
	//////////////////////////////////////////////////////////////
	
	public void prettyPrint(int margin, PrintStream stream){
		if(root!=null)
			root.prettyPrint(margin, stream);
		else
			stream.println("NULL");
	}
	
}
