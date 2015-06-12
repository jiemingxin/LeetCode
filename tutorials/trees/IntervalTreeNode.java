package tutorials.trees;

import java.util.ArrayList;
import java.util.List;

/**
 *  This class implements the Interval Tree Node as a binary 
 *  search tree 
 *  
 *  
 * @author orthogonal
 *
 */

public class IntervalTreeNode {
	
	public IntervalTreeNode parent, left, right ; 	
	public Interval interval ; 
	public int max ; 
	

	public IntervalTreeNode(Interval interval){
		
		this.interval = new Interval(interval); 
		max = interval.high; 
		parent=left=right=null; 
	}
	
	
	
	
	/**
	 *  Insert an interval to the current node. At the moment the implementation
	 *  can have worst time complexity O(n^2). The use of self-balancing binary
	 *  search tree can reduce that to O(nlogn) 
	 * 
	 * @param interval
	 */
	public static IntervalTreeNode insert(Interval interval, IntervalTreeNode iTreeNode){
		
		if(iTreeNode==null)
			return new IntervalTreeNode(interval); 
					
		if(interval.low < iTreeNode.interval.low){
			iTreeNode.left = insert(interval, iTreeNode.left); 
		}else
			iTreeNode.right = insert(interval, iTreeNode.right); 
		
		if(iTreeNode.max < interval.high)
			iTreeNode.max = interval.high;
		
		return iTreeNode; 
		
//		IntervalTreeNode parent = null; 
//		IntervalTreeNode node = iTreeNode ; 
//		while(node !=null){
//			parent = node ; 
//			if(interval.low < node.interval.low)
//				node = node.left ; 
//			else 
//				node = node.right; 
//		}
//		
//		if(parent!=null){
//			if(interval.low < parent.interval.low)
//				parent.left = new IntervalTreeNode(interval); 
//			else 
//				parent.right = new IntervalTreeNode(interval); 
//		}
			
//		// update the max bound 
//		if(iTreeNode.max < interval.high)
//			iTreeNode.max = interval.high;
	}
	
	
	
	
	/**
	 * Search for overlaps with the given overlap 
	 *  
	 */
	public static List<Interval> searchOverlaps(Interval interval, IntervalTreeNode node){
		
		if(node==null)
			return null; 
		
		List<Interval> overlaps = new ArrayList<Interval>(); 
		searchOverlaps(interval, node,  overlaps);
		return overlaps; 
	}
		
	
	
	
	/**
	 *  Return all the overlapping interval with the current interval 
	 *  Time complexity O(nlogn)
	 *  
	 * @param interval
	 * @param node
	 * @param overlaps
	 */
	protected static void searchOverlaps(Interval interval, IntervalTreeNode node, List<Interval> overlaps){
				
		if( node.left!=null && node.left.max >= interval.low ){
			searchOverlaps(interval, node.left, overlaps); 
		}
		
		if(Interval.doOverlap(node.interval, interval)){
			overlaps.add(node.interval);
		}
		
		if(node.right!=null &&  interval.high >= node.right.interval.low)
			searchOverlaps(interval, node.right, overlaps); 	
	}
	

	
}
