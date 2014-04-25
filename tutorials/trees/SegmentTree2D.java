package tutorials.trees;

public class SegmentTree2D {
	
	private int[][] tree ; 
	private int  xSize ; 
	private int  ySize ; 
		
	public SegmentTree2D(int[][] source){
		
		ySize = source.length ; 
		xSize = source[0].length ; 
		tree  = new int[2*ySize][2*xSize]; 
		
		buildTree(source);
	}
	
	
	
	protected void buildTree(int[][] source){
		
		int vy   = 0; 
		int topY = 0 ; 
		int botY = ySize - 1; 
		
		buildY(source, vy, topY, botY); 
	}
	
	
	
	
	
	protected void buildY(int[][] source, int nodeY, int srcTopY, int srcBotY){
		
		if( srcTopY != srcBotY ){
			int midY = (srcTopY + srcBotY)/2; 
			buildY(source, nodeY*2+1, srcTopY,    midY); 
			buildY(source, nodeY*2+2, midY+1,  srcBotY); 
		}
		
		int nodeX  		= 0 ;
		int srcLeftX  	= 0 ; 
		int srcRightX 	= xSize-1; 
		buildX(source, nodeY, srcTopY, srcBotY, nodeX, srcLeftX, srcRightX); 	
	}
	
	
	
	protected void buildX(int[][] source, int nodeY, int srcTopY, int srcBotY, int nodeX, int srcLeftX, int srcRightX){
		
		if( srcLeftX != srcRightX ){
			int midX = (srcLeftX + srcRightX)/2; 
			buildX(source, nodeY, srcTopY, srcBotY, 2*nodeX+1, srcLeftX, midX); 
			buildX(source, nodeY, srcTopY, srcBotY, 2*nodeX+2, midX+1, srcRightX); 
			tree[nodeY][nodeX] = Math.max(tree[nodeY][2*nodeX+1], tree[nodeY][2*nodeX+2]); 
		}else{
			// leftX equals rightX 
			if(srcTopY == srcBotY){
				tree[nodeY][nodeX] = source[srcTopY][srcLeftX]; 
			}else{
				tree[nodeY][nodeX] = Math.max(tree[2*nodeY+1][nodeX], tree[2*nodeY+2][nodeX]); 				
			}
		}
	}
	
	
	
	public int queryTree(int queryTopY, int queryBotY, int queryLeftX, int queryRightX){
		
		// boundary check 
		if( queryTopY < 0 || queryBotY >= ySize || queryLeftX < 0 || queryRightX >= xSize) 
			return -1; 
		
		int nodeY    = 0; 
		int treeTopY = 0; 
		int treeBotY = ySize -1 ;   
		return queryY(nodeY, treeTopY, treeBotY, queryTopY, queryBotY, queryLeftX, queryRightX  ); 
	}
	                                                                                                                  
	
	
	// NOTE treeTopY and treeBotY defines the range inside the original array, not on the 
	// tree array 
	protected int queryY(int nodeY, int treeTopY, int treeBotY, 
						 int queryTopY, int queryBotY, int queryLeftX, int queryRightX){
		
		// exception handling  [queryTopY, queryBotY] is to the LHS of [treeTopY, treeBotY] 
		// or it is to the RHS of [treeTopY, treeBotY] 
		if( queryTopY > treeBotY || queryBotY < treeTopY)
			return -1; 
		
		// base case  [queryTopY, queryBotY] includes [treeTopY, treeBotY] 
		if( queryTopY <= treeTopY && treeBotY <= queryBotY ){ 
			int nodeX      = 0; 
			int treeLeftX  = 0; 
			int treeRightX = xSize -1  ;	
			return queryX(nodeY, nodeX, treeLeftX, treeRightX, queryLeftX, queryRightX); 
		}
		
		// recursion 
		int treeMidY = (treeTopY + treeBotY)/ 2; 
		int m1       = queryY(2*nodeY+1, treeTopY,   treeMidY, queryTopY, queryBotY, queryLeftX, queryRightX); 
		int m2       = queryY(2*nodeY+2, treeMidY+1, treeBotY, queryTopY, queryBotY, queryLeftX, queryRightX);
		if( m1 == -1)
			return m2 ; 
		if( m2 == -1)
			return m1 ; 
		return Math.max(m1, m2); 
	}
	
	
	// NOTE treeLeftX and treeRightX defines the range inside the original array, not on the 
	// tree array 

	protected int queryX(int nodeY, int nodeX, int treeLeftX, int treeRightX, 
						int queryLeftX, int queryRightX){
	
		// exception handling 
		if( queryRightX < treeLeftX || queryLeftX > treeRightX)
			return -1; 
	
		// base case  
		if( queryLeftX <= treeLeftX && treeRightX <= queryRightX ){ 
			return tree[nodeY][nodeX]; 
		}
	
		// recursion 
		int treeMidX = (treeLeftX + treeRightX)/2 ; 
		int m1       = queryX(nodeY, 2*nodeX+1, treeLeftX,  treeMidX,   queryLeftX, queryRightX);
		int m2       = queryX(nodeY, 2*nodeX+2, treeMidX+1, treeRightX, queryLeftX, queryRightX); 
		if( m1 == -1)
			return m2 ; 
		if( m2 == -1)
			return m1 ; 
		return Math.max(m1, m2); 
	}
	
	
	
	
	
	public static void main(String[] args){
		
		int[][] data = { 
							{11 ,23 ,43 ,14},  
							{65, 76, 72, 81}, 
							{90, 39, 45, 50}, 
							{51, 93, 37, 25} 
						}; 
		
		SegmentTree2D segTree = new SegmentTree2D(data);  
		
		int topY = 2, botY = 2, leftX = 1, rightX = 2; 
		
		int max = segTree.queryTree(topY, botY, leftX, rightX);
		
		System.out.println("Max within (" + topY + "," + botY + "," + leftX + "," + rightX + "):" + max );
				
	}
	
	
	
	
	
	
	
	
	
	
	

}
