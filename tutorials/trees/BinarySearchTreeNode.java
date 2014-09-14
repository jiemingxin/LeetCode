package tutorials.trees;

public class BinarySearchTreeNode extends BinaryTree {

	protected BinarySearchTreeNode parent ; 
		
	public BinarySearchTreeNode(int value, BinarySearchTreeNode parent){
		super(value);
		this.parent=parent; 
	}
				
	public BinarySearchTreeNode left(){ 
		return (BinarySearchTreeNode) left; 
	};
	
	public BinarySearchTreeNode right(){ 
		return (BinarySearchTreeNode) right; 
	};
	
	public BinarySearchTreeNode parent(){ 
		return parent;
	};
	
	
	public void setLeft(BinarySearchTreeNode left){
		this.left = left; 
	}
	
	public void setRight(BinarySearchTreeNode right){
		this.right = right; 
	}
	
	public void setParent(BinarySearchTreeNode parent){
		this.parent = parent; 
	}
	
	//////////////////////////////////////////////////////////////
	/// Search in Binary Search Tree Node 
	//////////////////////////////////////////////////////////////
	
	public static BinarySearchTreeNode search(int value, BinarySearchTreeNode node){
		//return recursiveSearch(value, node);
		return iterativeSearch(value, node);
	}
	
	public static BinarySearchTreeNode recursiveSearch(int value, BinarySearchTreeNode node){
		
		if(node==null || node.value==value)
			return node; 
		
		if(value < node.value )
			return recursiveSearch(value, node.left()); 
		return recursiveSearch(value, node.right()); 
	}
	
	public static BinarySearchTreeNode iterativeSearch(int value, BinarySearchTreeNode node){
		
		BinarySearchTreeNode ret = node; 
		while( ret!=null && ret.value !=value){
			if( value < ret.value )
				ret = ret.left(); 
			else 
				ret = ret.right() ; 
		} 
		return ret ; 
	}
	
	// return the floor value of the given value, which is the largest value 
	// smaller than the given value 
	public static BinarySearchTreeNode floor(int value, BinarySearchTreeNode node){
		
		if(node==null || value==node.value) // an exact match is found 
			return node; 
				
		if(value < node.value) // the floor value could only exist in node.left subtree 
			return BinarySearchTreeNode.floor(value, node.left()); 
		
		// value < node.value --> the floor value may be in the right subtree or 
		// in the root. If nothing is found in the right tree, return the root value 
		BinarySearchTreeNode ret = BinarySearchTreeNode.floor(value, node.right()); 
		return ret==null?node:ret; 
	}
	
	
	// return the ceil value of the given value, which is the smallest integer
	// larger than the given value 
	public static BinarySearchTreeNode ceil(int value, BinarySearchTreeNode node){
		
		if(node==null || value==node.value) // an exact match is found 
			return node; 
				
		if(node.value < value ) // the ceiling value could only exist in node.right subtree 
			return BinarySearchTreeNode.ceil(value, node.right()); 
		
		// value < node.value --> the ceiling value may be in the left subtree or
		// in the root. If nothing is found in the left subtree, the returned value
		// should be the root value 
		BinarySearchTreeNode ret = BinarySearchTreeNode.ceil(value, node.left()); 
		return ret==null?node:ret; 
	}
	
	
	//////////////////////////////////////////////////////////////
	/// Insert in Binary Search Tree Node 
	//////////////////////////////////////////////////////////////
	
	public static void insert(int value, BinarySearchTreeNode node){
	
		// locate the parent node for the insert 
		BinarySearchTreeNode parent=null; 
		while(node!=null){
			parent = node; 
			if(value < node.value )
				node = node.left(); 
			else
				node = node.right(); 
		}
		
		// insert into the parent node 
		if(value<parent.value)
			parent.left = new BinarySearchTreeNode(value, parent) ;
		else
			parent.right = new BinarySearchTreeNode(value, parent) ; 		
	}
	
	
	//////////////////////////////////////////////////////////////
	/// Min and Max in Binary Search Tree Node 
	//////////////////////////////////////////////////////////////

	public static BinarySearchTreeNode min(BinarySearchTreeNode node){
		
		while(node.left()!=null) // reach the most left node  
			node = node.left();	
		return node ; 
	}
		
	public static BinarySearchTreeNode max(BinarySearchTreeNode node){
		
		while(node.right()!=null) // reach the most right node 
			node = node.right();	
		return node;  		
	}

	
	//////////////////////////////////////////////////////////////
	/// Successor and predecessor in terms of in order traversal
	//////////////////////////////////////////////////////////////

	public static BinarySearchTreeNode successor(BinarySearchTreeNode node){
		
		if(node.right()!=null)  
			return min( node.right() ); 
		
		// look for the first ascendant upwards which has a left child  
		BinarySearchTreeNode ret = node.parent, curr=node; 
		while( ret!=null && curr==ret.right){ // stops when ret is null or node=ret.left  
			curr = ret ; 
			ret  = curr.parent ; 
		}
		return ret; 
	}
	
	
	public static BinarySearchTreeNode predecessor(BinarySearchTreeNode node){
		
		if(node.left()!=null)
			return max( node.left()); 
		
		// look for the first descendant upwards which has a right child 
		BinarySearchTreeNode ret=node.parent, curr=node; 
		while( ret!=null && curr==ret.left){
			curr = ret; 
			ret = curr.parent; 
		}
		return ret; 
	}

}
