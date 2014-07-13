package clrs.ch6;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  A class to pretty print a binary tree. This class is used 
 *  for demonstrate the heap construction. 
 *  
 *  This class is not perfect; mis-alignment can still be found.
 *  However it is good enough for demo purpose. 
 * 
 * Written by J.Xu 
 * By Feb 09, 2013
 */

public class BinaryTreePrinter <T extends Comparable<? super T>>  {
		
	protected static PrintStream ps 			= System.out ; 
	protected static int unitWidth 				= 3 ; 
	protected static int spaceBtwLeafSibling 	= 1 * unitWidth ; // the width between sibling leaf nodes 

	public int maxHeight(Node<T> node){
		if( node == null ) return 0 ; 
		else return 1 +  Math.max( maxHeight(node.left),  maxHeight(node.right)) ; 
	}
	
	
	
	public void prettyPrintBinaryTree(Node<T> root){
		ps.println("+-------------------------------+"); 
		printInternalNodes(Collections.singletonList(root), maxHeight(root), 0); // level is zero based 
		ps.println("+-------------------------------+\n"); 
	}
	
	
	/**
	 * Pretty-print a given list of nodes 
	 * 
	 * @param nodes     - the given list of nodes which are in the same level of a binary tree 
	 * @param maxHeight - the maximum height of the binary tree 
	 * @param level     - the current level of the nodes( the root node is at level 0) 
	 */
	public void printInternalNodes(List<Node<T>> nodes, int maxHeight, int level){
	
		if( nodes.isEmpty() || areAllElementsNull(nodes)) return ;  
		
		List<Node<T>> child_nodes = new ArrayList<Node<T>>();  
		for(Node<T> node: nodes){			
			if(node != null){
				child_nodes.add(node.left); 
				child_nodes.add(node.right); 
			}else{
				child_nodes.add(null); 
				child_nodes.add(null); 
			}
			printNode(node, maxHeight, level);
		}
		ps.println(); 
		printEdges(nodes.size(), maxHeight, level);
	
		printInternalNodes(child_nodes, maxHeight, level+1); 
	}
	
	

	
	/**
	 *  print the edges for the given list of nodes
	 * 
	 * @param numNodes	 - the number of nodes in this level  
	 * @param maxHeight  - the maximum height of the binary tree 
	 * @param level		 - the current level of the nodes 
	 */ 
	protected void printEdges(int numNodes, int maxHeight, int level){
		
		if(level == maxHeight-1) return;  // current nodes are leaf nodes 
		int spaceWidth 		= ( (int)Math.pow(2, maxHeight-level-2) - 1) * unitWidth ; 
		int btwSpaceWidth 	= ( (int)Math.pow(2, maxHeight-level-1) - 1) * unitWidth ; 
		
 		for(int i=0; i<numNodes; i++){ 
 			printSpace(spaceWidth); 
 			printLeftEdge(); 
 			printSpace(btwSpaceWidth); 
 			printRightEdge(); 
 			printSpace(spaceWidth); 
 			printSpace(spaceBtwLeafSibling); 
 		}	
 		ps.println(); 
	}
	
	
	
	protected void printNode(Node<T> node, int maxHeight, int level){
		
		if(level == maxHeight-1 ){	
			printNode(node); 
		}else{
			int spaceWidth	= ( (int) Math.pow(2, maxHeight-level-2)    ) * unitWidth ; 
			int lineLength	= ( (int) Math.pow(2, maxHeight-level-2) -1   ) * unitWidth ; 
		
			printSpace(spaceWidth);
			if(node != null) printLine(lineLength); 
			printNode(node); 
			if(node != null) printLine(lineLength);
			printSpace(spaceWidth); 
		}
		printSpace(spaceBtwLeafSibling); 
	}
	
	
	
	protected boolean areAllElementsNull(List<Node<T>> nodes){
		boolean allNull = true ; 
		for(Node<T> node: nodes)
			if( node!= null){  allNull = false; break ; } 
		return allNull ; 
	}
	
	
	protected void printLeftEdge() {  for(int i=0; i<unitWidth-1; i++) ps.print(" "); ps.print("/"); }
	protected void printRightEdge(){  for(int i=0; i<unitWidth-1; i++) ps.print(" "); ps.print("\\"); }
	
	protected void printSpace(int width) { for(int i=0; i<width; i++) ps.print(" "); }
	protected void printLine(int length) { for(int i=0; i<length; i++) ps.print("_"); }
	
	
	protected void printNode(Node<T> node){ 
		if( node != null) ps.format("%" + String.valueOf(unitWidth)+ "d", node.data); 
		else {
			printSpace(unitWidth-2); 
			ps.print("()"); 
		}
	}
	
	
	public static Node<Integer> test1(){
		
        Node<Integer> root = new Node<Integer>(22); 
        Node<Integer> n11 = new Node<Integer>(77);
        Node<Integer> n12 = new Node<Integer>(55);
        Node<Integer> n21 = new Node<Integer>(26);
        Node<Integer> n22 = new Node<Integer>(67);
        Node<Integer> n23 = new Node<Integer>(30);
        Node<Integer> n24 = new Node<Integer>(61);
        Node<Integer> n31 = new Node<Integer>(52);
        Node<Integer> n32 = new Node<Integer>(83);
        Node<Integer> n33 = new Node<Integer>(44);
        Node<Integer> n34 = new Node<Integer>(55);
        Node<Integer> n35 = new Node<Integer>(86);
        Node<Integer> n36 = new Node<Integer>(47);
        Node<Integer> n37 = new Node<Integer>(58);
        Node<Integer> n38 = new Node<Integer>(89);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;
        n12.left = n23;
        n12.right = n24;

        n21.left = n31;
        n21.right = n32;
        n22.left = n33;
        n22.right = n34;
        n23.left = n35;
        n23.right = n36;
        n24.left = n37;
        n24.right = n38;
		
        return root ; 
	}
	
	
	public static Node<Integer> test2(){
		
        Node<Integer> root = new Node<Integer>(2);
        Node<Integer> n11 = new Node<Integer>(7);
        Node<Integer> n12 = new Node<Integer>(5);
        Node<Integer> n21 = new Node<Integer>(2);
        Node<Integer> n22 = new Node<Integer>(6);
        Node<Integer> n23 = new Node<Integer>(9);
        Node<Integer> n31 = new Node<Integer>(5);
        Node<Integer> n32 = new Node<Integer>(8);
        Node<Integer> n33 = new Node<Integer>(4);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;

        n12.right = n23;
        n22.left = n31;
        n22.right = n32;

        n23.left = n33;
        
        return root; 
 	
	}
	

	public static void main(String[] args){
		
		BinaryTreePrinter<Integer> treePrinter = new BinaryTreePrinter<Integer>(); 
		
		treePrinter.prettyPrintBinaryTree( test1() );
		treePrinter.prettyPrintBinaryTree( test2() ); 
		
	}
	
	
	
	
	
	
	
}



