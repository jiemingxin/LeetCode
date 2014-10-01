package tutorials.trees;

public class AVLTreeNode extends BinarySearchTreeNode {
	
	protected int balance ; 

	
	public AVLTreeNode(int value, AVLTreeNode parent){
		super(value, parent); 
	}
	
	///////////////////////////////////////////////////////////////////
	/// Enforcing all nodes (left, right, and parent) are AVLTreeNode 
	///////////////////////////////////////////////////////////////////
	
	public AVLTreeNode left(){ 
		return  left==null?null:(AVLTreeNode) left; 
	};
	
	public AVLTreeNode right(){ 
		return  right==null?null:(AVLTreeNode) right; 
	};
	
	public AVLTreeNode parent(){ 
		return parent==null?null:(AVLTreeNode) parent;
	};

	public void setLeft(AVLTreeNode left){
		this.left = left; 
	}
	
	public void setRight(AVLTreeNode right){
		this.right = right; 
	}
	
	public void setParent(AVLTreeNode parent){
		this.parent = parent; 
	}
	
	
	///////////////////////////////////////////////////////////////////
	/// Balance updating  
	///////////////////////////////////////////////////////////////////
	
	public int getBalance(){
		return balance ; 
	}
	
	public void setBalance(){
		// the height difference between right and left
		// note that -1 is returned for null trees 
		int rightHeight = right()==null ? -1:right().getHeight(); 
		int leftHeight  = left()==null ?  -1:left().getHeight(); 
		balance = rightHeight - leftHeight; 
	}
		
}
