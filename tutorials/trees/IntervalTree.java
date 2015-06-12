package tutorials.trees;

import java.util.List;

public class IntervalTree {

	private IntervalTreeNode root ; 
	
	public IntervalTree(Interval interval){
		this.root = new IntervalTreeNode(interval); 
	}
	
	
	public IntervalTree(){
		root = null ;
	}
	
		
	/**
	 *  A utility method to insert a new interval
	 *  This is similar to the Insert operation in binary search tree. 
	 *  The low value of the interval is used to maintain the binary
	 *  search tree property 
	 * 
	 */
	public void insert(Interval interval){
		if( root != null)
			IntervalTreeNode.insert(interval, root);
		else
			root = new IntervalTreeNode(interval); 
	}
	
	
	public List<Interval> searchOverlaps(Interval interval){
		return IntervalTreeNode.searchOverlaps(interval, root); 
	}
	
	
	
	
	
}
