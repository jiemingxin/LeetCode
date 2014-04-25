package tutorials.trees;

public class SegmentTree1D {
	
	
	private int[] lazy ; 
	private int[] tree; 
	private int   sourceSize ; 

	
	
	
	// this is a max segment tree 
	public SegmentTree1D(int[] source){
		
		int treeHeight = (int) Math.ceil( Math.log(source.length+1)/Math.log(2));  
		int treeSize   = (1 << (treeHeight+1)) -1 ;  	 
		
		sourceSize 	= source.length ; 
		tree 		= new int[treeSize]; 
		lazy 		= new int[treeSize]; 
		
		int treeIndex = 0 ; 
		int srcLeftX  = 0, srcRightX = source.length -1; 
		buildTree(source, treeIndex, srcLeftX, srcRightX); 
	}
	
	
	protected void buildTree(int[] source, int treeIndex, int srcLeftX, int srcRightX)
	{
		if( srcLeftX == srcRightX )
			tree[treeIndex] = source[srcLeftX]; 
		else {
			int srcMidX = (srcLeftX + srcRightX)/2;
			buildTree(source, 2*treeIndex+1, srcLeftX,  srcMidX); 
			buildTree(source, 2*treeIndex+2, srcMidX+1, srcRightX); 
			tree[treeIndex] = Math.max( tree[2*treeIndex+1], tree[2*treeIndex+2]); 
		}
	}
	
	
	public int queryTree(int queryLeftX, int queryRightX){
		
		int treeIndex  = 0 ; 
		int treeLeftX  = 0 ; 
		int treeRightX = sourceSize -1 ; // note the range of query and tree 
		//return queryTree(treeIndex, queryLeftX, queryRightX, treeLeftX, treeRightX); 
		return queryLazyUpdateTree(treeIndex, queryLeftX, queryRightX, treeLeftX, treeRightX); 
	}
	
	
	
	
	protected int queryLazyUpdateTree(int treeIndex, int queryLeftX, int queryRightX, int treeLeftX, int treeRightX){
	
		// exception handling 
		if( queryLeftX > queryRightX || queryLeftX > treeRightX || queryRightX < treeLeftX ) 
			return -1;
		
		// handle lazy updates 
		if( lazy[treeIndex]!= 0){  // current node requires updating 
			tree[treeIndex] += lazy[treeIndex]; 
			
			if( treeLeftX != treeRightX){ // if current node is not a leaf node, mark its children for lazy updates
				lazy[2*treeIndex+1] += lazy[treeIndex]; 
				lazy[2*treeIndex+2] += lazy[treeIndex]; 
			}
			lazy[treeIndex] = 0; // reset it 
		} 
		
		// base case 
		if ( queryLeftX <= treeLeftX && treeRightX <= queryRightX )
			return tree[treeIndex]; 
		
		// recursion 
		int treeMidX = ( treeLeftX + treeRightX)/2; 
		int m1 = queryLazyUpdateTree(2*treeIndex+1, queryLeftX,  queryRightX,  treeLeftX, treeMidX); 
		int m2 = queryLazyUpdateTree(2*treeIndex+2, queryLeftX,  queryRightX,  treeMidX+1, treeRightX); 
		if( m1 == -1) 
			return m2 ; 
		if( m2 == -1)
			return m1 ; 
		return Math.max(m1, m2); 

	}
	
	
	
	
	
	/**
	 *  NOTE the tree range should be the same as the source range. 
	 * 
	 * @param treeIndex    - the index of the tree node 
	 * @param queryLeftX   - the starting index of the query range 
	 * @param queryRightX  - the ending index of the query range 
	 * @param treeLeftX    - the starting index of the tree range 
	 * @param treeRightX   - the ending index of the tree range 
	 * @return
	 */
	protected int queryTree(int treeIndex, int queryLeftX, int queryRightX, int treeLeftX, int treeRightX){
		
		// exception handling 
		if( queryLeftX > queryRightX || queryLeftX > treeRightX || queryRightX < treeLeftX ) 
			return -1;
		
		// base case 
		if ( queryLeftX <= treeLeftX && treeRightX <= queryRightX )
			return tree[treeIndex]; 
		
		// recursion 
		int treeMidX = ( treeLeftX + treeRightX)/2; 
		int m1 = queryTree(2*treeIndex+1, queryLeftX,  queryRightX,  treeLeftX, treeMidX); 
		int m2 = queryTree(2*treeIndex+2, queryLeftX,  queryRightX,  treeMidX+1, treeRightX); 
		if( m1 == -1) 
			return m2 ; 
		if( m2 == -1)
			return m1 ; 
		return Math.max(m1, m2); 
	} 
		
	
	public void updateTree(int delta, int srcLeftX, int srcRightX){
		
		int treeIndex  = 0; 
		int treeLeftX  = 0;
		int treeRightX = sourceSize - 1; 
		//updateTree(delta, treeIndex, srcLeftX, srcRightX, treeLeftX, treeRightX); 
		
		lazyUpdateTree(delta, treeIndex, srcLeftX, srcRightX, treeLeftX, treeRightX); 
	}
	
	
	
	
	
	protected void lazyUpdateTree(int delta, int treeIndex, int srcLeftX, int srcRightX, int treeLeftX, int treeRightX)
	{
		if( srcLeftX > srcRightX || srcRightX < treeLeftX || srcLeftX > treeRightX)
			return ; 
		
		// handle lazy updates 
		if( lazy[treeIndex]!= 0){  // current node requires updating 
			tree[treeIndex] += lazy[treeIndex]; 
			
			if( treeLeftX != treeRightX){ // if current node is not a leaf node, mark its children for lazy updates
				lazy[2*treeIndex+1] += lazy[treeIndex]; 
				lazy[2*treeIndex+2] += lazy[treeIndex]; 
			}
			lazy[treeIndex] = 0; // finish the current node 
		} 
			
		// base case : current segment within range 
		if( srcLeftX <= treeLeftX && treeRightX <= srcRightX ){
			tree[treeIndex] += delta ; 
			if( treeLeftX != treeRightX){ // if current node is not a leaf node, mark its children for lazy updates 
					lazy[2*treeIndex+1] += delta ; 
					lazy[2*treeIndex+2] += delta ; 
			}
			return ; 
		}
		
		// recursion: update the child subtree 
		int treeMidX 		= ( treeLeftX + treeRightX)/2; 
		int leftChildIndex  = 2* treeIndex + 1; 
		int rightChildIndex = 2* treeIndex +2; 

		lazyUpdateTree(delta, 2*treeIndex+1, srcLeftX, srcRightX, treeLeftX, treeMidX);
		lazyUpdateTree(delta, 2*treeIndex+2, srcLeftX, srcRightX, treeMidX+1,treeRightX); 
		
		// don't forget to update the parent 
		tree[treeIndex] = Math.max(tree[leftChildIndex], tree[rightChildIndex]); 
	}
	
	
	
	
	
		
	/**
	 * Increment elements within range [srcLeftX, srcRightX] with a value 'delta' 
	 */
	protected void updateTree(int delta, int treeIndex, int srcLeftX, int srcRightX, int treeLeftX, int treeRightX)
	{
		// exception handling 
		if( srcLeftX > srcRightX || srcRightX < treeLeftX || srcLeftX > treeRightX)
			return ; 
		
		// base case 
		if( treeLeftX == treeRightX ){
			tree[treeLeftX] += delta ; 
			return ; 
		}
		
		// recursion: update the child subtree 
		int treeMidX 		= ( treeLeftX + treeRightX)/2; 
		int leftChildIndex  = 2* treeIndex + 1; 
		int rightChildIndex = 2* treeIndex +2; 
		
		updateTree(delta, leftChildIndex, srcLeftX, srcRightX, treeLeftX, treeMidX);
		updateTree(delta, rightChildIndex, srcLeftX, srcRightX, treeMidX+1,treeRightX); 
		
		// don't forget to update the parent 
		tree[treeIndex] = Math.max(tree[leftChildIndex], tree[rightChildIndex]); 

	}
	
	
	
			
		
	
	public static void main(String[] args){
		
		int[] data = { 8, 9, 0, -1, -10 , 11, 34, 13, 57, 88, 100, 92, 12 }; 
		
		SegmentTree1D segTree = new SegmentTree1D(data); 
		
		int queryLeftX = 0, queryRightX = 12;  
				
		System.out.println("Max over  [" + queryLeftX + ", " + queryRightX + "]: " + segTree.queryTree(queryLeftX, queryRightX)); 
//		System.out.println("Increment [" + queryLeftX + ", " + queryRightX + "]: by " + delta ); 
		//segTree.updateTree(delta, queryLeftX, queryRightX);
		
		segTree.updateTree(5, 0, 6); 
		segTree.updateTree(12, 7, 10); 
		segTree.updateTree(100, 10, 12); 
			
		System.out.println("Max over  [" + queryLeftX + ", " + queryRightX + "]: " + segTree.queryTree(queryLeftX, queryRightX)); 
		
	}
		
	
}
	

