package clrs.ch6;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *  Chapter 6: HeapSort 
 * 
 * @author J.Xu 
 * @since  Feb 3rd, 2013
 *
 */

public class Heap {

	protected static PrintStream ps = System.out; 
	protected static BinaryTreePrinter<Integer> treePrint  ; 
	static {  treePrint = new BinaryTreePrinter<Integer>(); }

	protected int[] elems ;  
	
	public Heap(int[] elems){ this.elems = Arrays.copyOf(elems, elems.length); }

	protected int parent(int i){ return i/2;  } 
	protected int left(int i){  return 2*i+1; } 
	protected int right(int i){ return 2*i+2; } 
	
	public void printArray(){ ps.println( Arrays.toString(elems) );}
	
	public void printHeapTree(){
		Node<Integer> root = constructTree(); 
		treePrint.prettyPrintBinaryTree(root); 
	}
	
	
	protected Node<Integer> constructTree(){
		
		int nelems = elems.length ;  
		List<Node<Integer>> nodes = new ArrayList<Node<Integer>>(nelems); 		
		for(int i=0;   i<nelems;   i++){
			Node<Integer> node = new Node<Integer>(elems[i]); 
			nodes.add(node); 
		}
		
		for(int i=0;   i<nelems;   i++){
			Node<Integer> node = nodes.get(i); 
			int leftIdx  = left(i);  if( leftIdx  < nelems) node.left  = nodes.get(leftIdx); 
			int rightIdx = right(i); if( rightIdx < nelems) node.right = nodes.get(rightIdx); 
		}
		return nodes.get(0); 
	}
	
	
	
	
	/**
	 * To make sure the subtree index @idx is a Heap, i.e., the root of any subtree
	 * is larger than any elements inside that subtree 
	 * 
	 * @param idx         - the index of the root of the subtree 
	 * @param arrayLength - the length of the underlying array 
	 */
	public void maxHeapify(int idx, int arrayLength){
		
		if( idx < 0 || idx > arrayLength) throw new IndexOutOfBoundsException(); 
		
		int l 		= left(idx); 
		int r 		= right(idx); 
		int nelems 	= arrayLength ; 
		
		int largest ; 
		if( l < nelems && elems[l] > elems[idx] ){  // compare root and its left child   
			largest = l; 
		}else 
			largest = idx ; 
		
		if( r < nelems && elems[r] > elems[largest]){ largest = r; }   // compare root and its right child 
			 
		if( largest != idx ) {
			int tmp    = elems[idx]; 
			elems[idx] = elems[largest]; 
			elems[largest] = tmp ; 
			maxHeapify(largest, arrayLength); 
		}
	}
		
	
	
	
	
	/**
	 *  Make sure the whole binary tree is a Max Heap by calling the Heapify method 
	 *  Time complexity: O(N)  
	 *  @param arrayLength - the length of the array to build a max heap 
	 */
	public void buildMaxHeap(int arrayLength){
		
		if( arrayLength <0 ) arrayLength = 0; 
		if( arrayLength >elems.length) arrayLength = elems.length ; 
		
		int lastNonLeafNodeIdx = arrayLength/2 - 1 ; // leaf nodes contribute to half of all nodes 
		
		for(int i=lastNonLeafNodeIdx;  i>=0;  i--)  maxHeapify(i, arrayLength);
	}
	
	
	
	
	
	
	/**
	 *  Sort an array using HeapSort 
	 */
	public void heapSort(){
		
		for(int i=elems.length;  i>=2;  i--){
			buildMaxHeap(i);  
			int tmp    = elems[i-1];  // at each iteration elems[0] stores the maximum   
			elems[i-1] = elems[0]; 
			elems[0]   = tmp ; 
		}
	}
	

	
	

		 
	public static void main(String[] args){
		
		int nelems 		= 10 ; 
		int[] elems 	= new int[nelems]; 
		Random random 	= new Random(); 
		for(int i=0;  i<nelems;  i++)
			elems[i] = random.nextInt() % 100; 
			
		Heap h = new Heap(elems); 

		
		ps.println("+-----------------------------------+"); 
		ps.println("Initial Array"); 
		ps.println("+-----------------------------------+"); 
		
		h.printArray();  
		h.printHeapTree(); 
		
		ps.println("+-----------------------------------+"); 
		ps.println("After running Heap_Sort"); 
		ps.println("+-----------------------------------+"); 
		
		h.heapSort(); 
		h.printArray(); 
		h.printHeapTree(); 

	}
	
	
	
	
}
